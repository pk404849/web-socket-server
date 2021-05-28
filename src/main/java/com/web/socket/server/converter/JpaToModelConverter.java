package com.web.socket.server.converter;

import java.util.ArrayList;
import java.util.List;

import com.web.socket.server.entity.Message;
import com.web.socket.server.entity.User;
import com.web.socket.server.model.MessageModel;
import com.web.socket.server.model.UserModel;

public class JpaToModelConverter {

	public static UserModel getUserModelObject(User user) {

		UserModel userModel = new UserModel();
		if (user != null) {
			userModel.setId(user.getId());
			userModel.setUserUniqueId(user.getUserUniqueId());
			userModel.setName(user.getName());
			userModel.setPassword(user.getPassword());
			userModel.setMobileNumber(user.getMobileNumber());
			userModel.setEmail(user.getEmail());
			userModel.setIsActive(user.getIsActive());
			userModel.setCreatedDate(user.getCreatedDate());
			userModel.setUpdatedDate(user.getUpdatedDate());
		}
		return userModel;
	}

	public static List<UserModel> getUserModelListObject(List<User> userList) {
		List<UserModel> userModelList = new ArrayList<UserModel>();
		if (userList != null && !userList.isEmpty()) {
			for (User user : userList) {
				userModelList.add(getUserModelObject(user));
			}
		}
		return userModelList;
	}

	public static List<MessageModel> getMessageModelListObject(List<Message> messageList) {
		List<MessageModel> messageModelList = null;
		if (messageList != null && !messageList.isEmpty()) {
			messageModelList = new ArrayList<>();
			for (Message message : messageList) {
				messageModelList.add(getMessageModelObject(message));
			}
		}
		return messageModelList;
	}

	private static MessageModel getMessageModelObject(Message message) {

		MessageModel messageModel = null;
		if (message != null) {
			messageModel = new MessageModel();
			messageModel.setId(message.getId());
			messageModel.setMessage(message.getMessage());
			messageModel.setMessageDate(message.getMessageDate());
			messageModel.setMessageReceiver(message.getMessageReceiver());
			messageModel.setMessageSender(message.getMessageSender());
			messageModel.setMessgeTime(message.getMessgeTime());
			messageModel.setReceiverUserId(message.getReceiverUserId());
			messageModel.setSenderUserId(message.getSenderUserId());
			messageModel.setMessageSenderName(message.getMessageSenderName());
			messageModel.setMessageReceiverName(message.getMessageReceiverName());
		}
		return messageModel;
	}

}
