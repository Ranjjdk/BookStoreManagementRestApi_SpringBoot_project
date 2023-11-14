package com.routesms.book;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    
	@Autowired
	private BookService bookService;
	
	
	//handler method to save books
	@PostMapping("/savebooks")
	@ResponseBody
    public Book createBook(@RequestBody Book book) {
    	
    	return this.bookService.saveBook(book);
    }
	
	//hander method to shows books list
	@GetMapping("/getbooks")
	@ResponseBody
	public ResponseEntity<List<Book>> getBookList(){
		
		List<Book> allBooks = this.bookService.getAllBooks();
		//if no books available in store then return response status not found
		if(allBooks.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(allBooks));
	}
	
	//hander method to delete book
	@DeleteMapping("/deletebook/{id}")
	@ResponseBody
	public String deleteBook(@PathVariable("id") Long id) {
		this.bookService.deleteBook(id);
		return "book Deleted successfully";
	}
	
	@PutMapping("/updatebook/{id}")
    @ResponseBody
    public Book updateBook(@PathVariable("id") Long id, @RequestBody Book book) {
		
	  return this.bookService.updateBookDetails(id, book);	
	}	
	
}
