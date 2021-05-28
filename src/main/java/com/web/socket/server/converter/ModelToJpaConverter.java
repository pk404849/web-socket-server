package com.web.socket.server.converter;

import com.web.socket.server.entity.Message;
import com.web.socket.server.entity.User;
import com.web.socket.server.model.MessageModel;
import com.web.socket.server.model.UserModel;
import com.web.socket.server.util.WebSocketServerUtil;

public class ModelToJpaConverter {

	public static User getUserJpaObject(UserModel userModel) {
		User user = null;
		if (userModel != null) {
			user = new User();
			user.setId(userModel.getId());
			if (user.getId() == null || user.getId() == 0) {
				String userId = WebSocketServerUtil.getUniqueUserId();
				user.setUserUniqueId(userId);
			} else {
				user.setUserUniqueId(userModel.getUserUniqueId());
			}
			user.setName(userModel.getName());
			user.setPassword(userModel.getPassword());
			user.setMobileNumber(userModel.getMobileNumber());
			user.setEmail(userModel.getEmail());
			user.setIsActive(userModel.getIsActive() == null ? true : false);
			user.setCreatedDate(userModel.getCreatedDate());
			user.setUpdatedDate(userModel.getUpdatedDate());
		}
		return user;
	}

	public static Message getMessageJpaObject(MessageModel meesageModel) {
		Message message = null; 
		if(meesageModel != null) {
			message = new Message();
			message.setId(meesageModel.getId());
			message.setMessage(meesageModel.getMessage());
			message.setMessageDate(WebSocketServerUtil.getStringDate());
			message.setMessgeTime(WebSocketServerUtil.getMessageTime());
			message.setMessageReceiver(meesageModel.getMessageReceiver());
			message.setMessageSender(meesageModel.getMessageSender());
			message.setReceiverUserId(meesageModel.getReceiverUserId());
			message.setSenderUserId(meesageModel.getSenderUserId());
			message.setMessageSenderName(meesageModel.getMessageSenderName());
			message.setMessageReceiverName(meesageModel.getMessageReceiverName());
		}
		return message;
	}

	

}
