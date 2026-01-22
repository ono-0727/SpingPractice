package com.example.demo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * 収支入力画面の入力値を保持するDTO
 */
@Data
public class TransactionsForm {

    @NotNull(message = "対象月を選択してください")
    @Min(value = 1, message = "対象月は1から12の間で選択してください")
    @Max(value = 12, message = "対象月は1から12の間で選択してください")
    private Integer monthDto;

    @NotNull(message = "収支区分を選択してください")
    private String paymentsDto;

    @NotNull(message = "収支内容を入力してください")
    @Size(max = 300, message = "収支内容は300文字以内で入力してください")
    private String contentDto;

    @NotNull(message = "金額を入力してください")
    @Min(value = 1, message = "金額は1以上を入力してください")
    private Integer amountDto;
}
