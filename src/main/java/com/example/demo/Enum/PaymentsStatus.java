package com.example.demo.Enum;

import java.util.Arrays;
import java.util.List;

public enum PaymentsStatus {
	INCOME("1", "収入"),
	PAY("0", "支出");
	
	private final String code;
	private final String description;
	
	PaymentsStatus(String code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
	
	// コードからEnum値を取得するメソッド
	public static PaymentsStatus fromCode(String code) {
   		for(PaymentsStatus status : PaymentsStatus.values()) {
   			if(status.getCode().equals(code)) {
   				return status;
   			}
   		}
   		return null;
	}
	
	// 画面表示からEnumのコード値を取得するメソッド
	public static String fromDescription(String description) {
		String normalized = description.trim();
   		for(PaymentsStatus status : PaymentsStatus.values()) {
   			if(status.getDescription().equals(normalized)) {
   				return status.code;
   			}
   		}
   		return null;
	}
	
	// 支払・入金選択用リストを表示
	public static List<PaymentsStatus> getSelectItems() {
		return Arrays.asList(PaymentsStatus.values());
	}
	
}
