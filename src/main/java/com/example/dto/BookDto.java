package com.example.dto;

import java.time.LocalDate;

import com.example.entity.Authour;
import com.example.entity.Genre;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDto {
	private int bookId;
	@NotBlank(message = "Bookname should not blank")
	@NotNull(message = "Bookname should not blank")
	private String bookName;
	@JsonFormat(pattern = "dd-MM-yyyy")//for client
	@PastOrPresent(message = "Accept only past date")
	private LocalDate publishedDate;
	@PositiveOrZero
	private float cost;
	@PositiveOrZero
	private int stock;
	@Enumerated(EnumType.STRING)
	private Genre genre;
	private int authourId;
}
