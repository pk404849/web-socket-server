package com.web.socket.server.business;

import java.util.List;

import com.web.socket.server.entity.Message;

public interface MessageBusiness {

	Message saveMessage(Message message);

	List<Message> getMessageByUserUniqueId(String messageSenderId, String messageReceiverId);

}
