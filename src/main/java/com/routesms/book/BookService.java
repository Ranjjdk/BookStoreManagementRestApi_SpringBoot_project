package com.routesms.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	
	@Autowired
	private BookReposistory bookRepository;
	
	//method to persist book details
	public Book saveBook(Book book) {
		
		
		return this.bookRepository.save(book);
	}
	
	
	//method to  load all books 
	public List<Book> getAllBooks(){
		
		return (List<Book>) this.bookRepository.findAll();
	}
	//method to delete book of given id\
	public void deleteBook(Long id) {
		 
		this.bookRepository.deleteById(id);
	}
	
	public  Book updateBookDetails(Long id,Book newBookDetails) {
		  
		   
		   Book oldBookDeatils = this.bookRepository.findById(id).get();
		  
		   
		   if(newBookDetails.getBookTitle()!=null && !newBookDetails.getBookTitle().equals("") ) {
			   
			   oldBookDeatils.setBookTitle(newBookDetails.getBookTitle());
		   }
		   
        if(newBookDetails.getLanguage()!=null && !newBookDetails.getBookTitle().equals("") ) {
			   
			   oldBookDeatils.setLanguage(newBookDetails.getLanguage());
		   }
        
        if(newBookDetails.getPrice()!=0 && newBookDetails.getPrice()>0	) {
			   
			   oldBookDeatils.setPrice(newBookDetails.getPrice());
		   }
        
        
        return this.bookRepository.save(oldBookDeatils);
		  
		   
		  
         
	   	}
	
	  

}
