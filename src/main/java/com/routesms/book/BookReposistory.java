package com.routesms.book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReposistory extends CrudRepository<Book, Long> {
	
	

}
