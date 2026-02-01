package com.example.demo.Service.strategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.DTO.TransactionsForm;
import com.example.demo.Entity.Pay;
import com.example.demo.Enum.PaymentsStatus;
import com.example.demo.Repository.PayRepository;

@Component
public class PayPaymentsStrategy implements PaymentStrategy {

	@Autowired
	private PayRepository payRepository;

	@Override
	public PaymentsStatus getType() {
		return PaymentsStatus.PAY;
	}
	
	@Override
	public String getDbRecordName() {
		return "T_PAY";
	}


	// 登録処理の実行
	@Override
	public void register(TransactionsForm form) {
		Pay payDbValue = new Pay();
		payDbValue.setMonth(form.getMonthDto());
		payDbValue.setContent(form.getContentDto());
		payDbValue.setAmount(form.getAmountDto());
		payRepository.save(payDbValue);
	}
}
