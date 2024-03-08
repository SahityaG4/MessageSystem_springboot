package com.example.MessageSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.MessageSystem.Services.EmailService;
import com.example.MessageSystem.Services.MessageProcessor;
import com.example.MessageSystem.Services.MessageProcessorImplementor;
import com.example.MessageSystem.Services.MessageService;
import com.example.MessageSystem.Services.SMSService;

@SpringBootApplication
public class MessageSystemApplication {
	@Bean("email service")
	public MessageService emailservice() {
		return new EmailService();
	}
	
	@Bean("sms service")
	public MessageService smsservice() {
		return new SMSService();
	}
	
	@Bean("message processor")
	public MessageProcessor messageprocessor() {
		return new MessageProcessorImplementor(emailservice());
	}

	public static void main(String[] args) {
		MessageProcessor mp = 
		SpringApplication.run(MessageSystemApplication.class, args).getBean(MessageProcessor.class);
	
	
		mp.processMessage();
	}
	

}
