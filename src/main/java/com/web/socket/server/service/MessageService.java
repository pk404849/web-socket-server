package com.web.socket.server.service;

import java.util.List;

import com.web.socket.server.entity.Message;

public interface MessageService {

	public Message saveMessage(Message message);
	
	public List<Message> getMessageByUserUniqueId(String messageSenderId, String messageReceiverId);

}
