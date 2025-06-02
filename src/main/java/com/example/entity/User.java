package com.example.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data//for setter & getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
private int userId;
private String firstName;
private String lastName;
@Column(unique = true)
private String email;
@Column(unique = true)
private int phoneNo;
}
