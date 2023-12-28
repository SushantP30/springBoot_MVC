package in.sushit.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sushit.entity.Book;

public interface bookRepo extends JpaRepository<Book, Integer> {
 
	public List <Book> findByActiveSW(String status);
}
