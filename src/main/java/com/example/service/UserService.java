package com.example.service;

import java.util.List;

import com.example.dto.BorrowBookDto;
import com.example.entity.Book;
import com.example.entity.Transaction;
import com.example.entity.User;

public interface UserService {
	User addNewUser(User u);
	//need later....
   Book borrowBook(BorrowBookDto borrowDto);
	Book returnBook(int tid);
	boolean checkAvailability(int bookId);
	List<Transaction>  chkTransactionByUser(int userId);
}
