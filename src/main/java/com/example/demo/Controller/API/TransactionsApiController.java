package com.example.demo.Controller.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Expend;
import com.example.demo.Service.API.TransactionsApiService;

@RestController
public class TransactionsApiController {
	
	@Autowired
	private TransactionsApiService transactionsApiService;
	
	@GetMapping("/api/transactions")
	public ResponseEntity<Expend> findExpendLeatest() {
		Expend apiExpendrespone = transactionsApiService.findExpendLeatest();
		return ResponseEntity.ok(apiExpendrespone);
	}
	

}
