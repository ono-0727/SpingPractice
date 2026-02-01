package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.DTO.TransactionsForm;
import com.example.demo.Enum.PaymentsStatus;
import com.example.demo.Enum.TransactionsMonth;
import com.example.demo.Service.TransactionsService;


@Controller
public class TransactionsController {

	@Autowired
	private TransactionsService transactionsService;
	
	/**
	 * 取引登録フォーム表示
	 * 
	 * @param model
	 * @return 取引登録フォーム画面
	 */
	@GetMapping("/transactions/form")
	public String top(Model model) {
		model.addAttribute("TransactionsForm", new TransactionsForm());
		model.addAttribute("monthList", TransactionsMonth.getSelectItems());
		model.addAttribute("payMentsList", PaymentsStatus.getSelectItems());
		return "top";
	}
	
	
	/**
	 * 内容確認画面表示
	 * 
	 * @param model
	 * @param transactionsForm 取引情報フォーム
	 * @param bindingResult バリデーション結果
	 * @return 取引一覧画面
	 */
	@PostMapping("/transactions/confirm")
	public String create(Model model, @Validated TransactionsForm transactionsForm, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			model.addAttribute("mouthList", TransactionsMonth.getSelectItems());
			model.addAttribute("payMnetsList", PaymentsStatus.getSelectItems());
			return "top";
		}
		model.addAttribute("transactionsForm",transactionsForm);
		return "confirm";
	}
	
	/**
	 * 取引登録完了画面表示
	 */
	@PostMapping("/transactions/complete")
	public String complete(Model model, TransactionsForm form) {
		transactionsService.register(form);
		return "redirect:/transactions/form";
	}
	

}
