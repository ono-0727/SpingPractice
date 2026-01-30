package com.example.demo.Service.strategy;

import com.example.demo.DTO.TransactionsForm;
import com.example.demo.Enum.PaymentsStatus;

public interface PaymentStrategy {
	
	// 支払種別を取得
	public PaymentsStatus getType();
	
	// 対応のレコードを取得
	public String getDbRecordName();
	
	// 登録処理の実行
	public void register(TransactionsForm form);

}
