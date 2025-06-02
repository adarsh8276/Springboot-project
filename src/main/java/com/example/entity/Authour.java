package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data//for setter & getter
@NoArgsConstructor
@AllArgsConstructor
public class Authour {
	@Id
private int authourId;
	@NotNull(message="plz enter authour name")
	@NotBlank(message="authour name cant be blank")
private String authourName;
}
