package com.tinlee.app.rest.Repo;

import com.tinlee.app.rest.Models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
}
