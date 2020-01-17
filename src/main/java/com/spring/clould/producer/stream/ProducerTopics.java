package com.spring.clould.producer.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProducerTopics {

	String ACCOUNT = "ACCOUNT";
	String CREDIT_HISTORY = "CREDIT_HISTORY";

	@Output(ACCOUNT)
	MessageChannel account();

	@Output(CREDIT_HISTORY)
	MessageChannel credit_history();
}
