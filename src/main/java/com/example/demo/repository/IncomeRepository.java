package com.example.demo.repository;

import com.example.demo.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 収入の永続化を行うリポジトリ
 */
@Repository
public interface IncomeRepository extends JpaRepository<Income, Long> {
}
