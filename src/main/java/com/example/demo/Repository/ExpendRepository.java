package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Expend;

@Repository
public interface ExpendRepository extends JpaRepository<Expend, Long> {
	
	/**
	 * 論理削除フラグが未削除のレコードを取得
	 * @param dFlag
	 * @return 指定された論理削除フラグに一致する収支情報のリスト
	 */
	  List<Expend> findByDFlag(Integer dFlag);

}
