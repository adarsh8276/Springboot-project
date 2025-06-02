package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import com.example.dto.BookDto;
import com.example.entity.Authour;
import com.example.entity.Book;
import com.example.entity.Genre;
import com.example.exception.ApplicationException;
import com.example.repository.AuthourRepository;
import com.example.repository.BookRepository;
@Component
public class BookServiceImpl implements BookService {
	@Autowired
	private AuthourRepository authourRepo;
	@Autowired
	private BookRepository bookRepo;
	@Override
	public Book addBook(BookDto bookDto) {
		int authourId=bookDto.getAuthourId();
	//  Authour authour=authourRepo.findById(authourId).get();
		//optional is used to avoid null pointer exception issues
	Optional<Authour> optionalAuth=	authourRepo.findById(authourId);
	if(optionalAuth.isPresent()) {
		Authour authour=optionalAuth.get();
	
	  Book book= new Book();
	  //from dto to book copy all properties
//	  book.setBookId(bookDto.getBookId());
//	  book.setBookName(bookDto.getBookName());
//	  book.setCost(bookDto.getCost());
//	  book.setStock(bookDto.getStock());
//	  book.setGenre(bookDto.getGenre());
//	  book.setPublishedDate(bookDto.getPublishedDate());
	  BeanUtils.copyProperties(bookDto, book);
	  book.setAuthourId(authour);
	 return bookRepo.save(book);
	}
	 throw new ApplicationException("Authour does not exist");
	}

	public Authour addAuthour(Authour authour) {
		return authourRepo.save(authour);
	}
	
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	@Override
	public Page<Book> allBookswithPagination(int pageNo, int size) {
		Pageable pageable= PageRequest.of(pageNo, size,Sort.by("bookName"));
		return bookRepo.findAll(pageable);
	}

	@Override
	public List<Book> searchByAuthour(int authourId) {
		return null;
	}
	public List<Book> searchByGenre2(Genre genre) {
		return null;
	}
	@Override
	public List<Book> searchByGenre(Genre genre) {
		return bookRepo.findByGenre(genre);
	}
	@Override
	public Book searchBookById(int bookId) {
/*	Optional<Book> optBook=	bookRepo.findById(bookId);
	if(optBook.isPresent())
		return optBook.get();
	throw new ApplicationException("Book "+bookId+" doesnot exist");
	*/
		//OR v hv a short cut
	return bookRepo.findById(bookId).
	orElseThrow(()-> new ApplicationException("Book "+bookId+" doesnot exist"));
	}
	@Override
	public void removeBook(int bookId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Book> searchByBookName(String bookName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateCost(int bookId, float cost) {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
