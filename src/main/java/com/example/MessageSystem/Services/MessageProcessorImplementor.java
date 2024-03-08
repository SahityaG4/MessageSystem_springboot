package com.example.MessageSystem.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MessageProcessorImplementor implements MessageProcessor {
	
	public MessageService ms;
	
	@Autowired
	public MessageProcessorImplementor(@Qualifier("email service") MessageService ms) {
		super();
		this.ms = ms;
	}

	@Override
	public void processMessage() {
		// TODO Auto-generated method stub
		ms.sendMessage();
	}

}
