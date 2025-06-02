package com.example.entity;

import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data//for setter & getter
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
	@Id @GeneratedValue
private int tid;
@CreationTimestamp	//date of the record insertion....
private LocalDate borrowedDate;
private LocalDate returnedDate;
@ManyToOne @JoinColumn(name="userId")
private User user;
@ManyToOne @JoinColumn(name="bookId")
private Book book;
private float amount;
private String status;//must be enum
@OneToOne @JoinColumn(name="penalty_id")
private Penalty penalty;
}
