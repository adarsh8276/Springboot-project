package com.example.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.dto.BookDto;
import com.example.entity.Authour;
import com.example.entity.Book;
import com.example.entity.Genre;

public interface BookService {

Authour addAuthour(Authour authour);
Book searchBookById(int bookId);
Book addBook(BookDto book);
List<Book> searchByGenre2(Genre genre);
List<Book> allBooks();
Page<Book> allBookswithPagination(int pageNo,int size);
List<Book> searchByAuthour(int authourId);
List<Book> searchByGenre(Genre genre);
//Book updateBook(BookDto book,int bookId);
void removeBook(int bookId);

List<Book> searchByBookName(String bookName);
public int updateCost(int bookId, float cost);
}
