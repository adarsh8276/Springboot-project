package com.example.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class BorrowBookDto {
	//@NotBlank(message = "must enter bookId")
	//@NotEmpty(message = "must enter bookId")
	
private int bookId;
	//@NotBlank(message = "must enter userId")
	//@NotEmpty(message = "must enter userId")
private int userId;

}
