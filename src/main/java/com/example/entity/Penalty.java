package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//for setter & getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Penalty {
	@Id @GeneratedValue
 private int pid;
 private float amount;
 private int noOfDays;
 private String remarks;
}
