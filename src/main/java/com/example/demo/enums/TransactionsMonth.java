package com.example.demo.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 収支の対象の月を管理するEnum
 */
public enum TransactionsMonth {
    JANUARY("01", 1, "1月"),
    FEBRUARY("02", 2, "2月"),
    MARCH("03", 3, "3月"),
    APRIL("04", 4, "4月"),
    MAY("05", 5, "5月"),
    JUNE("06", 6, "6月"),
    JULY("07", 7, "7月"),
    AUGUST("08", 8, "8月"),
    SEPTEMBER("09", 9, "9月"),
    OCTOBER("10", 10, "10月"),
    NOVEMBER("11", 11, "11月"),
    DECEMBER("12", 12, "12月");

    private final String code;
    private final Integer value;
    private final String displayName;

    TransactionsMonth(String code, Integer value, String displayName) {
        this.code = code;
        this.value = value;
        this.displayName = displayName;
    }

    /**
     * DB登録用コード値を返却
     */
    public String getCode() {
        return code;
    }

    /**
     * 画面表示・選択用の月を返却
     */
    public Integer getValue() {
        return value;
    }

    /**
     * 表示名を返却
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * コード値からEnum取得
     */
    public static TransactionsMonth fromCode(String code) {
        return Arrays.stream(values())
                .filter(month -> month.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid code: " + code));
    }

    /**
     * 画面入力値からEnum取得
     */
    public static TransactionsMonth fromValue(Integer value) {
        return Arrays.stream(values())
                .filter(month -> month.value.equals(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid value: " + value));
    }

    /**
     * 月選択用リスト取得
     */
    public static List<TransactionsMonth> getSelectItems() {
        return Arrays.asList(values());
    }
}
