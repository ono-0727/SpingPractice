package com.example.demo.DTO;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class TransactionsForm {
	
	@NotNull
	@Min(value = 1)
	@Max(value = 12)
	private Integer monthDto;
	
	@NotNull
	private String paymentsDto;
	
	@NotNull
	@Size(min = 1, max = 300)
	private String contentDto;
	
	@NotNull
	@Min(value = 1)
	private Integer amountDto;
	
	public Integer getMonthDto() {
		return monthDto;
	}
	public void setMonthDto(Integer monthDto) {
		this.monthDto = monthDto;
	}
	public String getPaymentsDto() {
		return paymentsDto;
	}
	public void setPaymentsDto(String paymentsDto) {
		this.paymentsDto = paymentsDto;
	}
	public String getContentDto() {
		return contentDto;
	}
	public void setContentDto(String contentDto) {
		this.contentDto = contentDto;
	}
	public Integer getAmountDto() {
		return amountDto;
	}
	public void setAmountDto(Integer amountDto) {
		this.amountDto = amountDto;
	}
}
