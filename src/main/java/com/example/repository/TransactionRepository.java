package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
