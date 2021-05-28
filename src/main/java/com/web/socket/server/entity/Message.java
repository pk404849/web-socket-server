package com.web.socket.server.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "MESSAGE")
public class Message {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "SENDER_USER")
	private Integer senderUserId;
	@Column(name = "RECEIVER_USER")
	private Integer receiverUserId;
	@Column(name = "MESSAGE")
	private String message;
	@Column(name = "MESSAGE_DATE")
	private String messageDate;
	@Column(name = "MESSAGE_TIME")
	private String messgeTime;
	@Column(name = "MESSAGE_SENDER")
	private String messageSender;
	@Column(name = "MESSAGE_RECEIVER")
	private String messageReceiver;
	@Column(name = "MESSAGE_SENER_NAME")
	private String messageSenderName;
	@Column(name = "MESSAGE_RECEIVER_NAME")
	private String messageReceiverName;
	@CreationTimestamp
	@Column(name = "CREATED_DATE", insertable = true, updatable = false)
	private LocalDateTime createdDate;
	@CreationTimestamp
	@Column(name = "UPDATED_DATE", insertable = true, updatable = true)
	private LocalDateTime updatedDate;

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

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
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

}
