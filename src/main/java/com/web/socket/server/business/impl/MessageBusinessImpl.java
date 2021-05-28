package com.web.socket.server.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.socket.server.business.MessageBusiness;
import com.web.socket.server.entity.Message;
import com.web.socket.server.repository.MessageRepository;

@Service
public class MessageBusinessImpl implements MessageBusiness {

	@Autowired
	public MessageRepository messageRepository;
	
	@Override
	public Message saveMessage(Message message) {
		return messageRepository.save(message);
	}

	@Override
	public List<Message> getMessageByUserUniqueId(String messageSenderId, String messageReceiverId) {
		return messageRepository.findMessageBySenderAndReceiverId(messageSenderId, messageReceiverId);
	}

}
