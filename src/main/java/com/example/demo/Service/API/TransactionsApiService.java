package com.example.demo.Service.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Expend;
import com.example.demo.Repository.ExpendRepository;

@Service
public class TransactionsApiService {
	
	@Autowired
	ExpendRepository expendRepository;
	
	public Expend findExpendLeatest() {
		Expend expend = expendRepository.findLeatestExpend();
		
		return expend;
	}

}
