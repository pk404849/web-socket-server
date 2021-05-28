package com.web.socket.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.socket.server.business.MessageBusiness;
import com.web.socket.server.entity.Message;
import com.web.socket.server.service.MessageService;

@Service
public class MessageServiceImpl implements MessageService{

	@Autowired
	public MessageBusiness messageBusiness;
	
	@Override
	public Message saveMessage(Message message) {
		return messageBusiness.saveMessage(message);
	}

	@Override
	public List<Message> getMessageByUserUniqueId(String messageSenderId, String messageReceiverId) {
		return messageBusiness.getMessageByUserUniqueId(messageSenderId, messageReceiverId);
	}

}
