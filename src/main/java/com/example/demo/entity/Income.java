package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;

/**
 * 収入情報を保持するエンティティ (T_INCOME)
 */
@Entity
@Table(name = "T_INCOME")
@Data
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`month`", nullable = false)
    private Integer month;

    @Column(name = "content", nullable = false, length = 300)
    private String content;

    @Column(name = "amount", nullable = false)
    private Integer amount;
}
