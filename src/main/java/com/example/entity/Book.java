package com.example.entity;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data//for setter & getter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	@Id
private int bookId;
private String bookName;
private LocalDate publishedDate;
private float cost;
private int stock;
@Enumerated(EnumType.STRING)
private Genre genre;
@ManyToOne
@JoinColumn(name="auth_Id")
private Authour authourId;

}
