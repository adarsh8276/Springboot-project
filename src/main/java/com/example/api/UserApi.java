package com.example.api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.BorrowBookDto;
import com.example.entity.Book;
import com.example.entity.User;
import com.example.service.UserService;

import jakarta.validation.Valid;
@RestController
@RequestMapping("/users")
public class UserApi {
	@Autowired
    private UserService userService;
	@PostMapping
	public User addNewUser(@RequestBody User user) {
		User u=userService.addNewUser(user);
		return u;
	}
	@PostMapping("/borrow")
	public Book borrowBook(@RequestBody  @Valid BorrowBookDto borrowDto) {
		return userService.borrowBook(borrowDto);
	}
	
	@PutMapping ("/returnbook/{tid}")
	public Book returnBook( @PathVariable("tid") int tid) {
		return userService.returnBook(tid);
	}
}
