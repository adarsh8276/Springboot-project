package com.example.service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dto.BorrowBookDto;
import com.example.entity.Book;
import com.example.entity.Penalty;
import com.example.entity.Transaction;
import com.example.entity.User;
import com.example.exception.ApplicationException;
import com.example.repository.BookRepository;
import com.example.repository.PenalyRepository;
import com.example.repository.TransactionRepository;
import com.example.repository.UserRepository;
@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private BookRepository bookRepo;
	@Autowired
	private PenalyRepository penaltyRepo;
	@Autowired
	private TransactionRepository tranRepo;
	public User addNewUser(User u) {
		User user=userRepo.save(u);
		return user;
	}

	@Override
	public boolean checkAvailability(int bookId) {
		//if the stock of the book is <=0 return false else return true
		return false;
	}

	@Override
	public List<Transaction> chkTransactionByUser(int userId) {
		//by the userid get all the transactions....
		return null;
	}

	@Override
	public Book borrowBook(BorrowBookDto borrowDto) {
		int userId=borrowDto.getUserId();
		int bookId=borrowDto.getBookId();
		User user=userRepo.findById(userId).
				orElseThrow(() -> new ApplicationException("user id not found"));
		Book book=bookRepo.findById(bookId).orElseThrow(()-> new ApplicationException("Book id not found"));
		if(book.getStock()>0) {
			Transaction t= new Transaction();
			t.setBook(book);
			t.setUser(user);
			t.setAmount(book.getCost());
			t.setStatus("BORROWED");
			book.setStock(book.getStock()-1);
			tranRepo.save(t);
		return bookRepo.save(book);
		}
		throw new ApplicationException("sorry Stock is over");
	}

	@Override
	public Book returnBook(int tid) {
		// By Duration object calcualte the diff bw dates (returned date-borrow date)
		//if its more than 30 for each day 50 rs penalty will be applied
		// update the transaction table
		//add record penalty if required 
		Transaction t=
		tranRepo.findById(tid).orElseThrow(()-> new ApplicationException("Invalid transaction id") );
		LocalDate borrowedDate=t.getBorrowedDate();
		LocalDate returnedDate =LocalDate.now();
		//borrowedDate.atStartOfDay()==> returns LocalDateTime
		//LocalDateTime --> it stores time as well
		Duration duration=  Duration.between(borrowedDate.atStartOfDay(), returnedDate.atStartOfDay());
	    long noOfDays=duration.toDays();
	    Book book=t.getBook();
	    if(t.getStatus().equals("BORROWED")) {
	    if(noOfDays>30) {
	    	//calculate the penalty
	    	Penalty p=new Penalty();
	    	p.setAmount((noOfDays-30)*50);
	    	p.setNoOfDays((int) noOfDays);
	    	p.setRemarks("total "+noOfDays);
	    	t.setPenalty(p);
	    	penaltyRepo.save(p);
	    }
	    	book.setStock(book.getStock()+1);
	    	t.setReturnedDate(returnedDate);
	    	t.setStatus("RETURNED");
	    	bookRepo.save(book);
	  
	    tranRepo.save(t);
	    }
	    else throw new ApplicationException("Book Already returned");
	    return book;
	}
}
