package com.example.demo.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.Data;

/**
 * 収支情報を保持するエンティティ (T_EXPEND)
 */
@Entity
@Table(name = "T_EXPEND")
@Data
public class Expend {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_EXPEND_SEQ_GEN")
    @SequenceGenerator(name = "T_EXPEND_SEQ_GEN", sequenceName = "T_EXPEND_SEQ", allocationSize = 1)
    private Long id;

    @Column(name = "month", nullable = false)
    private Integer month;

    @Column(name = "payments", nullable = false, length = 1)
    private String payments;

    @Column(name = "content", length = 300)
    private String content;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "data", nullable = false)
    private LocalDateTime data;

    @Column(name = "d_flag", nullable = false)
    private Integer dFlag;
}