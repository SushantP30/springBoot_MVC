package in.sushit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import in.sushit.entity.Book;
import in.sushit.service.bookService;

@Controller
public class bookController {
	@Autowired
private bookService service;
	@GetMapping("/books")
	public ModelAndView getBooks() {
		ModelAndView mv= new ModelAndView();
		List<Book> allBook=service.getAllBooks();
		mv.addObject("book",allBook);
		mv.setViewName("bookView");
		return mv;
	}
	@GetMapping("/index")
	public ModelAndView index() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("book" ,new Book());
		mav.setViewName("index");
		return mav;
	}
	
	
	@PostMapping("/book")
	public ModelAndView saveBook(Book book) {
		ModelAndView mav =new ModelAndView();
		boolean status=service.saveBook(book);
		if(status) {
			mav.addObject("succMsg","Book Saved");
		} else {
			mav.addObject("err","Book Failed to Saved");
		}
		mav.setViewName("index");
		return mav;
		
	}
	@GetMapping("/delete")
	public ModelAndView deleteBook(@RequestParam("bookId")Integer bookId) {
		service.deleteBook(bookId);
		ModelAndView mav=new ModelAndView();
		List<Book> allBooks=service.getAllBooks();
		mav.addObject("book", allBooks);
		mav.setViewName("bookView");
		return mav;
		
	}
}
