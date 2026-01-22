-- =====================================================
-- Oracle Database用 テーブル定義SQL
-- 家計簿記録アプリケーション
-- =====================================================

-- Table: T_EXPEND (収支一覧)
CREATE TABLE T_EXPEND (
    id NUMBER(19) PRIMARY KEY,
    month NUMBER(2) NOT NULL,
    payments CHAR(1) NOT NULL,
    content VARCHAR2(300),
    amount NUMBER(13) NOT NULL,
    data TIMESTAMP NOT NULL,
    d_flag NUMBER(1) NOT NULL
);

CREATE SEQUENCE T_EXPEND_SEQ START WITH 1 INCREMENT BY 1;

-- Table: T_INCOME (収入一覧)
CREATE TABLE T_INCOME (
    id NUMBER(19) PRIMARY KEY,
    month NUMBER(2) NOT NULL,
    content VARCHAR2(300) NOT NULL,
    amount NUMBER(13) NOT NULL
);

CREATE SEQUENCE T_INCOME_SEQ START WITH 1 INCREMENT BY 1;

-- Table: T_PAY (支出一覧)
CREATE TABLE T_PAY (
    id NUMBER(19) PRIMARY KEY,
    month NUMBER(2) NOT NULL,
    content VARCHAR2(300) NOT NULL,
    amount NUMBER(13) NOT NULL
);

CREATE SEQUENCE T_PAY_SEQ START WITH 1 INCREMENT BY 1;
