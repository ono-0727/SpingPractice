package com.example.demo.controller;

import com.example.demo.dto.TransactionsForm;
import com.example.demo.enums.PaymentsStatus;
import com.example.demo.enums.TransactionsMonth;
import com.example.demo.service.TransactionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 収支の金額を受け取り画面に表示する処理全般を担当
 */
@Controller
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionsController {

    private final TransactionsService transactionsService;

    /**
     * 収支入力画面の表示
     * @param model モデル
     * @return 収支入力画面
     */
    @GetMapping("/form")
    public String top(Model model) {
        // TransactionsFormの生成
        model.addAttribute("transactionsForm", new TransactionsForm());
        
        // 月選択用リスト
        model.addAttribute("months", TransactionsMonth.getSelectItems());
        
        // 収支区分選択用リスト
        model.addAttribute("paymentsStatuses", PaymentsStatus.getSelectPayments());
        
        // 収支入力画面の表示
        return "top";
    }

    /**
     * 収支入力確認画面の表示
     * @param form 収支入力フォーム
     * @param result バリデーション結果
     * @param model モデル
     * @return 収支入力確認画面
     */
    @PostMapping("/confirm")
    public String create(@Validated @ModelAttribute TransactionsForm form,
                        BindingResult result,
                        Model model) {
        // バリデーションエラーの場合は入力画面に戻る
        if (result.hasErrors()) {
            model.addAttribute("months", TransactionsMonth.getSelectItems());
            model.addAttribute("paymentsStatuses", PaymentsStatus.getSelectPayments());
            return "top";
        }
        
        // 確認画面用のデータをモデルに追加
        model.addAttribute("transactionsForm", form);
        
        // 収支入力確認画面の表示
        return "create";
    }

    /**
     * 収支登録完了処理
     * @param form 収支入力フォーム
     * @param model モデル
     * @return リダイレクト先
     */
    @PostMapping("/complete")
    public String complete(@ModelAttribute TransactionsForm form, Model model) {
        // TransactionsService.register() を呼び出し
        transactionsService.register(form);
        
        // 収支入力画面の再表示（リダイレクト）
        return "redirect:/transactions/form";
    }
}
