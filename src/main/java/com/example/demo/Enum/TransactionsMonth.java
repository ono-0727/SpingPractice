package com.example.demo.Enum;
import java.util.Arrays;
import java.util.List;

public enum TransactionsMonth {
		JANUARY("01", "1月"),
		FEBRUARY("02", "2月"),
		MARCH("03", "3月"),
		APRIL("04", "4月"),
		MAY("05", "5月"),
		JUNE("06", "6月"),
		JULY("07", "7月"),
		AUGUST("08", "8月"),
		SEPTEMBER("09", "9月"),
		OCTOBER("10", "10月"),
		NOVEMBER("11", "11月"),
		DECEMBER("12", "12月");
		
		private final String code;
		private final String value;
		
		TransactionsMonth(String code, String value) {
			this.code = code;
			this.value = value;
		}
		
		public String getCode() {
			return code;
		}
		
		public String getValue() {
			return value;
		}
		
		
		// codeからEnumを取得するメソッド
		public static TransactionsMonth fromCode(String code) {
			for (TransactionsMonth month : TransactionsMonth.values()) {
				if (month.getCode().equals(code)) {
					return month;
				}
			}
			return null;
		}
		
		// 画面入力値からEnumを取得するメソッド
		public static TransactionsMonth fromValue(String value) {
			for (TransactionsMonth month : TransactionsMonth.values()) {
				if (month.getValue().equals(value)) {
					return month;
				}
			}
			return null;
		}
		
		// 月選択用リストを表示
		public static List<TransactionsMonth> getSelectItems() {
			return Arrays.asList(TransactionsMonth.values());
		}
				
		
	}

