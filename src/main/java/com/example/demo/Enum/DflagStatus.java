package com.example.demo.Enum;

public enum DflagStatus {
	NOT_DELETED(0, "未削除"),
	DELETED(1, "削除");
	
	private final Integer code;
	private final String description;
	
	DflagStatus(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public String getDescription() {
		return description;
	}
	
	public static DflagStatus fromCode(Integer code) {
		for (DflagStatus status : DflagStatus.values()) {
			if(status.getCode().equals(code)) {
				return status;
			}
		}
		return null;
	}
	
	
	// 未削除フラグが立っているか判定するメソッド
	public static boolean isNotDeleted(Integer code) {
		if (code.equals(NOT_DELETED.getCode())) {
			return true;
		} 
		return false;
	}
	
	// 削除フラグが立っているか判定するメソッド
	public static boolean isDeleted(Integer code) {
		if (code.equals(DELETED.getCode())) {
			return true;
		} 
		return false;
	}

}
