package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Income;

@Repository
public interface IncomeRepository  extends JpaRepository<Income, Long> {

}
