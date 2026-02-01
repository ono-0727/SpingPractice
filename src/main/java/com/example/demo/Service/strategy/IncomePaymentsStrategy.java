package com.example.demo.Service.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.TransactionsForm;
import com.example.demo.Entity.Income;
import com.example.demo.Enum.PaymentsStatus;
import com.example.demo.Repository.IncomeRepository;

@Component
public class IncomePaymentsStrategy implements PaymentStrategy {

	@Autowired
	private IncomeRepository incomeRepository;

	@Override
	public PaymentsStatus getType() {
		return PaymentsStatus.INCOME;
	}
	
	@Override
	public String getDbRecordName() {
		return "T_INCOME";
	}

	// 登録処理の実行
	@Override
	public void register(TransactionsForm form) {
		Income incomeDbValue = new Income();
		incomeDbValue.setMonth(form.getMonthDto());
		incomeDbValue.setContent(form.getContentDto());
		incomeDbValue.setAmount(form.getAmountDto());
		incomeRepository.save(incomeDbValue);
	}
}
