package com.spring.clould.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.clould.producer.model.Account;
import com.spring.clould.producer.model.CreditHistory;
import com.spring.clould.producer.service.ProducerService;

@RestController
public class ProducerController {

	@Autowired
	ProducerService producerService;
	
	@PostMapping("/publishAccount")
	public String publishAccount(@RequestBody Account account) {
		Account acc = Account.builder()
				.account_number(account.getAccount_number())
				.account_status(account.getAccount_status())
				.account_type(account.getAccount_type())
				.account_subtype(account.getAccount_subtype())
				.line_of_business(account.getLine_of_business())
				.timestamp(System.currentTimeMillis())
				.build();
		return producerService.publishAccountInfo(acc) ? "Successfully publishAccount":"Opps! Failed to publishAccount";
	}
	
	@PostMapping("publishCreditHistory")
	public String publishCreditHistory(CreditHistory creditHistory) {
		CreditHistory ch = CreditHistory.builder()
				.account_number(creditHistory.getAccount_number())
				.credit_class(creditHistory.getCredit_class())
				.timestamp(System.currentTimeMillis())
				.build();
		producerService.publishCreditHistory(ch);
		return "Success";
	}
}
