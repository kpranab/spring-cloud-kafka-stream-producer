package com.spring.clould.producer.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Account {

	private String account_number;
	private String account_type;
	private String account_subtype;
	private String line_of_business;
	private String account_status;
	private long timestamp;
}
