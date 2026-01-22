package com.example.demo.repository;

import com.example.demo.entity.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 支出の永続化を行うリポジトリ
 */
@Repository
public interface PayRepository extends JpaRepository<Pay, Long> {
}
