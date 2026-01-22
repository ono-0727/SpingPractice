# 家計簿記録アプリケーション (Household Budget App)

Spring Bootで実装された家計簿管理システムです。収支（収入・支出）の入力、確認、登録ができます。

## 機能

- 収支入力フォーム
- 入力内容の確認画面
- データベースへの登録
- バリデーション機能
- 論理削除対応

## 技術スタック

- **Java**: 17
- **Spring Boot**: 4.0.1
- **Database**: H2 (In-Memory)
- **ORM**: Spring Data JPA / Hibernate
- **Template Engine**: Thymeleaf
- **Build Tool**: Gradle 9.2.1

## プロジェクト構成

```
src/main/java/com/example/demo/
├── controller/          # Webコントローラー
│   └── TransactionsController.java
├── service/            # ビジネスロジック
│   └── TransactionsService.java
├── repository/         # データアクセス層
│   ├── ExpendRepository.java
│   ├── IncomeRepository.java
│   └── PayRepository.java
├── entity/             # JPA エンティティ
│   ├── Expend.java
│   ├── Income.java
│   └── Pay.java
├── dto/                # データ転送オブジェクト
│   └── TransactionsForm.java
└── enums/              # 列挙型
    ├── TransactionsMonth.java
    ├── PaymentsStatus.java
    └── DflagStatus.java

src/main/resources/
├── templates/          # Thymeleaf テンプレート
│   ├── top.html
│   └── create.html
├── schema.sql          # H2用スキーマ
└── application.properties

docs/
└── oracle_schema.sql   # Oracle用スキーマ
```

## セットアップ

### 前提条件

- Java 17以上
- Gradle 9.2.1以上（Wrapperを使用する場合は不要）

### ビルド

```bash
./gradlew clean build
```

### 実行

```bash
./gradlew bootRun
```

アプリケーションは http://localhost:8080 で起動します。

## 使い方

1. ブラウザで http://localhost:8080/transactions/form にアクセス
2. フォームに収支情報を入力
   - 対象月: 1-12月を選択
   - 収支区分: 収入 または 支払い を選択
   - 収支内容: 内容を入力（最大300文字）
   - 金額: 1以上の整数を入力
3. 「確認」ボタンをクリック
4. 確認画面で内容を確認
5. 「登録」ボタンをクリックして保存

## データベース

### H2コンソール

開発時は H2 Console にアクセスできます:

- URL: http://localhost:8080/h2-console
- JDBC URL: `jdbc:h2:mem:testdb`
- User: `sa`
- Password: （空欄）

### テーブル構成

- **T_EXPEND**: 全収支の記録
- **T_INCOME**: 収入の詳細
- **T_PAY**: 支出の詳細

詳細は `docs/oracle_schema.sql` を参照してください。

## テスト

```bash
./gradlew test
```

## ライセンス

このプロジェクトは学習目的で作成されています。
