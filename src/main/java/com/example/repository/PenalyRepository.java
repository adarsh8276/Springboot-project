package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Penalty;

public interface PenalyRepository  extends JpaRepository<Penalty, Integer>{

}
