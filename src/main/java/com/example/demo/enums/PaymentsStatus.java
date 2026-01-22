package com.example.demo.enums;

import java.util.Arrays;
import java.util.List;

/**
 * 収支区分を判定するEnum
 */
public enum PaymentsStatus {
    INCOME("1", "収入"),
    PAY("0", "支払い");

    private final String code;
    private final String value;

    PaymentsStatus(String code, String value) {
        this.code = code;
        this.value = value;
    }

    /**
     * DB登録用コード値を返却
     */
    public String getCode() {
        return code;
    }

    /**
     * 画面表示の支払い区分を返却
     */
    public String getValue() {
        return value;
    }

    /**
     * コード値からEnum取得
     */
    public static PaymentsStatus fromCode(String code) {
        return Arrays.stream(values())
                .filter(status -> status.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid code: " + code));
    }

    /**
     * 画面表示名からEnum取得
     */
    public static PaymentsStatus fromValue(String value) {
        return Arrays.stream(values())
                .filter(status -> status.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid value: " + value));
    }

    /**
     * 支払区分選択用リスト取得
     */
    public static List<PaymentsStatus> getSelectPayments() {
        return Arrays.asList(values());
    }
}
