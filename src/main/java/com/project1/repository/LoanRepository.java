package com.project1.repository;

import com.project1.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
    List<Loan> findLoanByUsername(String username);

    Loan findLoanById(int id);
}
