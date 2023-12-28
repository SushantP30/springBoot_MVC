package in.sushit.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.sushit.entity.Book;
import in.sushit.repository.bookRepo;
@Service
public class bookServiceImpl implements bookService {
	@Autowired
private bookRepo repo;
	@Override
	public List<Book> getAllBooks() {
		
		// TODO Auto-generated method stub
		//return repo.findAll();
		return repo.findByActiveSW("Y");
	}
	@Override
	public boolean saveBook(Book book) {
		// TODO Auto-generated method stub
		book.setActiveSW("Y");
		Book savedBook=repo.save(book);
		if(savedBook.getBookId()!=null) {
			return true;
		}
		return false;
	}
	@Override
	public void deleteBook(Integer bookId) {
		//HardDelete 
		//repo.deleteById(bookId);
	//Logic to softDelete
		java.util.Optional<Book> findById=repo.findById(bookId);
		if(findById.isPresent()) {
			Book book =findById.get();
			book.setActiveSW("N");
			repo.save(book);
		}
		
		
		
	}
	

}
