package com.web.socket.server.model;

public class MessageModel {

	private Integer id;
	private Integer senderUserId;
	private Integer receiverUserId;
	private String message;
	private String messageDate;
	private String messgeTime;
	private String messageSender;
	private String messageReceiver;
	private String messageSenderName;
	private String messageReceiverName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSenderUserId() {
		return senderUserId;
	}

	public void setSenderUserId(Integer senderUserId) {
		this.senderUserId = senderUserId;
	}

	public Integer getReceiverUserId() {
		return receiverUserId;
	}

	public void setReceiverUserId(Integer receiverUserId) {
		this.receiverUserId = receiverUserId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMessageDate() {
		return messageDate;
	}

	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}

	public String getMessgeTime() {
		return messgeTime;
	}

	public void setMessgeTime(String messgeTime) {
		this.messgeTime = messgeTime;
	}

	public String getMessageSender() {
		return messageSender;
	}

	public void setMessageSender(String messageSender) {
		this.messageSender = messageSender;
	}

	public String getMessageReceiver() {
		return messageReceiver;
	}

	public void setMessageReceiver(String messageReceiver) {
		this.messageReceiver = messageReceiver;
	}

	public String getMessageSenderName() {
		return messageSenderName;
	}

	public void setMessageSenderName(String messageSenderName) {
		this.messageSenderName = messageSenderName;
	}

	public String getMessageReceiverName() {
		return messageReceiverName;
	}

	public void setMessageReceiverName(String messageReceiverName) {
		this.messageReceiverName = messageReceiverName;
	}

	@Override
	public String toString() {
		return "MessageModel [id=" + id + ", senderUserId=" + senderUserId + ", receiverUserId=" + receiverUserId
				+ ", message=" + message + ", messageDate=" + messageDate + ", messgeTime=" + messgeTime
				+ ", messageSender=" + messageSender + ", messageReceiver=" + messageReceiver + ", messageSenderName="
				+ messageSenderName + ", messageReceiverName=" + messageReceiverName + "]";
	}

}
