package com.example.demo.enums;

import java.util.Arrays;

/**
 * 論理削除状態を表すEnum
 */
public enum DflagStatus {
    NOT_DELETED(0, "未削除"),
    DELETED(1, "削除");

    private final Integer code;
    private final String description;

    DflagStatus(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    /**
     * DB登録用コード値を返却
     */
    public Integer getCode() {
        return code;
    }

    /**
     * 説明文を返却
     */
    public String getDescription() {
        return description;
    }

    /**
     * コード値からEnum取得
     */
    public static DflagStatus fromCode(Integer code) {
        return Arrays.stream(values())
                .filter(status -> status.code.equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid code: " + code));
    }

    /**
     * 削除状態か判定
     */
    public boolean isDeleted() {
        return this == DELETED;
    }

    /**
     * 未削除状態か判定
     */
    public boolean isNotDeleted() {
        return this == NOT_DELETED;
    }
}
