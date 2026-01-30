package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

import lombok.Data;

/**
 * 収入エンティティクラス
 */

@Entity
@Table(name = "T_INCOME")
@Data
public class Income {
	
	@Id
	@Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "T_EXPEND_SEQ_GEN")
    @SequenceGenerator(name = "T_EXPEND_SEQ_GEN", sequenceName = "T_EXPEND_SEQ", allocationSize = 1)
	private Long id;
	
	@Column(name="month", nullable = false)
	private Integer month;
	
	@Column(name="content", nullable = false, length = 300)
	private String content;
	
	@Column(name="amount", nullable = false)
	private Integer amount;
}
