package com.example.demo.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private static final Logger logger = LoggerFactory.getLogger(TransactionsService.class);

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
	 * @param form 取引情報フォーム
	 * @throws RuntimeException 登録処理でエラーが発生した場合
	 */
	@Transactional
	public void register(TransactionsForm form) {
		
		String dbSetStep = EXPEND + "の登録処理";
		
		// 支払種別の事前検証
		String paymentsCode = form.getPaymentsDto();
		PaymentsStatus paymentsStatus = PaymentsStatus.fromCode(paymentsCode);
		if (paymentsStatus == null) {
			String errorMsg = "不正な支払種別コード[" + paymentsCode + "]が指定されました。";
			logger.error(errorMsg);
			throw new IllegalArgumentException(errorMsg);
		}
		
		// 支払種別に対応する処理の存在確認
		PaymentStrategy strategy = strategyMap.get(paymentsStatus);
		if (strategy == null) {
			String errorMsg = "支払種別[" + paymentsStatus + "]に対応する登録処理が見つかりません。";
			logger.error(errorMsg + " 登録可能な支払種別: {}", strategyMap.keySet());
			throw new IllegalStateException(errorMsg);
		}
		
		try {
			// 支出テーブルへの登録
			Expend expendDbValue = createExpendEntity(form);
			expendRepository.save(expendDbValue);
			
			// 支払種別に応じた追加登録処理
			dbSetStep = strategy.getDbRecordName() + "の登録処理";
			strategy.register(form);

		} catch (DataAccessException e) {
			logger.error("{}でデータベースエラーが発生しました。", dbSetStep, e);
			throw new RuntimeException(dbSetStep + "でデータベースエラーが発生しました。", e);
		}

	}
	
	// Expendエンティティ作成メソッド
	private Expend createExpendEntity(TransactionsForm form) {
	    Expend expend = new Expend();
	    
	    expend.setMonth(form.getMonthDto());
	    expend.setPayments((form.getPaymentsDto()));
	    expend.setContent(form.getContentDto());
	    expend.setAmount(form.getAmountDto());
	    expend.setDate(LocalDateTime.now());
	    expend.setDFlag(DflagStatus.NOT_DELETED.getCode());
	    return expend;
	}
}
