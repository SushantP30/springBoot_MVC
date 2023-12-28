package in.sushit.service;

import java.util.List;

import in.sushit.entity.Book;

public interface bookService {
public List<Book> getAllBooks();
public boolean saveBook(Book book);
public void deleteBook(Integer bookId);
}
