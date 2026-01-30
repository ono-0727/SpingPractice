package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.DTO.TransactionsForm;
import com.example.demo.Entity.Expend;
import com.example.demo.Enum.DflagStatus;
import com.example.demo.Enum.PaymentsStatus;
import com.example.demo.Repository.ExpendRepository;
import com.example.demo.Service.strategy.PaymentStrategy;

@Service
public class TransactionsService {

	private Map<PaymentsStatus, PaymentStrategy> strategyMap;

	// 登録処理対象のDBを判別するために使用する定数
	private static final String EXPEND = "T_EXPEND";

	@Autowired
	private ExpendRepository expendRepository;
	

	// Springによって、PaymentStrategy実装クラスがListとして自動注入される
	public TransactionsService(List<PaymentStrategy> strategies) {
		this.strategyMap = new HashMap<>();
		for (PaymentStrategy strategy : strategies) {
			this.strategyMap.put(strategy.getType(), strategy);
		}
	}

	/**
	 * 取引登録
	 * @param transactionsForm 取引情報フォーム
	 * @throws DataAccessException
	 */
	@Transactional
	public void register(TransactionsForm form) {
		
		String dbSetStep = EXPEND + "の登録処理";
		try {
			Expend expendDbValue = createExpendEntity(form);
			expendRepository.save(expendDbValue);
			
			PaymentStrategy strategy = strategyMap.get(PaymentsStatus.fromCode(expendDbValue.getPayments()));
			if (strategy != null) {
				dbSetStep = strategy.getDbRecordName() + "の登録処理";
				strategy.register(form);
			} else {
				throw new RuntimeException("対応する支払種別の登録処理が見つかりません。");
			}

		} catch (DataAccessException e) {
			throw new RuntimeException(dbSetStep + "でエラーが発生しました。", e);
		}

	}
	
	// Expendエンティティ作成メソッド
	private Expend createExpendEntity(TransactionsForm form) {
	    Expend expend = new Expend();
	    
	    expend.setMonth(form.getMonthDto());
	    expend.setPayments((form.getPaymentsDto()));
	    expend.setContent(form.getContentDto());
	    expend.setAmount(form.getAmountDto());
	    expend.setData(LocalDateTime.now());
	    expend.setDFlag(DflagStatus.NOT_DELETED.getCode());
	    return expend;
	}
}
