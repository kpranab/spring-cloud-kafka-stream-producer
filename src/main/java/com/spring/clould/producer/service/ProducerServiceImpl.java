package com.spring.clould.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.spring.clould.producer.model.Account;
import com.spring.clould.producer.model.CreditHistory;
import com.spring.clould.producer.stream.ProducerTopics;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProducerServiceImpl implements ProducerService {

	@Autowired
	ProducerTopics producerTopics;

	@Override
	public boolean publishAccountInfo(Account account) {
		log.info("Publishing account info {}", account);
		MessageChannel messageChanel = producerTopics.account();
		return messageChanel.send(MessageBuilder.withPayload(account)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());

	}

	@Override
	public void publishCreditHistory(CreditHistory creditHistory) {
		log.info("Publishing creditHistory info{}", creditHistory);
		MessageChannel messageChannel = producerTopics.credit_history();
		messageChannel.send(MessageBuilder.withPayload(creditHistory)
				.setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON).build());

	}

}
