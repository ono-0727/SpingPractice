package com.example.demo.service;

import com.example.demo.dto.TransactionsForm;
import com.example.demo.entity.Expend;
import com.example.demo.entity.Income;
import com.example.demo.entity.Pay;
import com.example.demo.enums.DflagStatus;
import com.example.demo.enums.PaymentsStatus;
import com.example.demo.repository.ExpendRepository;
import com.example.demo.repository.IncomeRepository;
import com.example.demo.repository.PayRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 収支登録および参照に関する業務ロジックを担当する
 */
@Service
@Transactional
@RequiredArgsConstructor
public class TransactionsService {

    private final ExpendRepository expendRepository;
    private final IncomeRepository incomeRepository;
    private final PayRepository payRepository;

    /**
     * 収支一覧取得（論理削除除外）
     * @return 収支データリスト
     * @throws DataAccessException データアクセスエラー
     */
    public List<Expend> findAll() throws DataAccessException {
        return expendRepository.findByDFlag(DflagStatus.NOT_DELETED.getCode());
    }

    /**
     * 収支登録
     * @param form 収支入力フォーム
     * @throws DataAccessException データアクセスエラー
     */
    public void register(TransactionsForm form) throws DataAccessException {
        // Expend Entityの生成と登録
        Expend expend = new Expend();
        expend.setMonth(form.getMonthDto());
        expend.setPayments(form.getPaymentsDto());
        expend.setContent(form.getContentDto());
        expend.setAmount(form.getAmountDto());
        expend.setDate(LocalDateTime.now());
        expend.setDFlag(DflagStatus.NOT_DELETED.getCode());

        expendRepository.save(expend);

        // 収入の場合
        if (PaymentsStatus.INCOME.getCode().equals(form.getPaymentsDto())) {
            registerIncome(form);
        }
        // 支出の場合
        else if (PaymentsStatus.PAY.getCode().equals(form.getPaymentsDto())) {
            registerPay(form);
        }
    }

    /**
     * 収入をTBに登録
     * @param form 収支入力フォーム
     */
    private void registerIncome(TransactionsForm form) {
        Income income = new Income();
        income.setMonth(form.getMonthDto());
        income.setContent(form.getContentDto());
        income.setAmount(form.getAmountDto());

        incomeRepository.save(income);
    }

    /**
     * 支出をTBに登録
     * @param form 収支入力フォーム
     */
    private void registerPay(TransactionsForm form) {
        Pay pay = new Pay();
        pay.setMonth(form.getMonthDto());
        pay.setContent(form.getContentDto());
        pay.setAmount(form.getAmountDto());

        payRepository.save(pay);
    }
}
