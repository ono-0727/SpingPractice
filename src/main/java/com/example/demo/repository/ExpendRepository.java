package com.example.demo.repository;

import com.example.demo.entity.Expend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 収支情報の永続化および検索を行うリポジトリ
 */
@Repository
public interface ExpendRepository extends JpaRepository<Expend, Long> {

    /**
     * 論理削除フラグが0の収支情報を全件取得する
     */
    List<Expend> findByDFlag(Integer dFlag);
}
