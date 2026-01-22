package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * 収支情報を保持するエンティティ (T_EXPEND)
 */
@Entity
@Table(name = "T_EXPEND")
@Data
public class Expend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`month`", nullable = false)
    private Integer month;

    @Column(name = "payments", nullable = false, length = 1)
    private String payments;

    @Column(name = "content", length = 300)
    private String content;

    @Column(name = "amount", nullable = false)
    private Integer amount;

    @Column(name = "data", nullable = false)
    private LocalDateTime date;

    @Column(name = "d_flag", nullable = false)
    private Integer dFlag;
}
