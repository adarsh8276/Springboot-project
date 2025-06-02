package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Book;
import com.example.entity.Genre;

public interface BookRepository extends JpaRepository<Book,Integer>{
	// to find by genre we can various ways
	
	//1. by query methods findBy<FieldName>>
	//here method name must be same 
 	List<Book> findByGenre(Genre genre);
	
	//2. to use own query
	@Query(value = "select b from Book b where b.genre= :g")//jpql
	//any method name
	List<Book> searchBookByGenre( @Param("g") Genre genre);
	
	//1. by query method
	List<Book> findByBookName(String bookName);
	//2. to use own query (native)
	@Query(value = "select * from book where book_name= :n",nativeQuery = true)
	List<Book> searchBookByName(@Param("n")  String name);
}
