package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Authour;

public interface AuthourRepository extends JpaRepository<Authour, Integer> {

}
