package com.web.socket.server.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.web.socket.server.constant.MessageApiConstant;
import com.web.socket.server.controller.BaseController;
import com.web.socket.server.controller.ResponseMessage;
import com.web.socket.server.converter.JpaToModelConverter;
import com.web.socket.server.converter.ModelToJpaConverter;
import com.web.socket.server.entity.Message;
import com.web.socket.server.model.MessageModel;
import com.web.socket.server.service.MessageService;

@RestController
@RequestMapping(value = "/message")
@CrossOrigin(value = "http://localhost:4200")
public class MessageController extends BaseController {

	@Autowired
	public MessageService messageService;

	@PostMapping(value = "/save-message")
	public ResponseEntity<?> saveMessage(@RequestBody MessageModel meesageModel) {
		ResponseMessage responseMessage = new ResponseMessage();
		Message message = ModelToJpaConverter.getMessageJpaObject(meesageModel);
		messageService.saveMessage(message);
		responseMessage.setMessage(MessageApiConstant.SAVED_MESSAGE);
		responseMessage.setStatus(true);
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/get-message-by-user-unique-id")
	public ResponseEntity<?> getMessageByUserUniqueId(
			@RequestParam(value = "messageSenderId") String messageSenderId,
			@RequestParam(value = "messageReceiverId") String messageReceiverId) {
		ResponseMessage responseMessage = new ResponseMessage();
		if (messageSenderId != null && !messageSenderId.isEmpty() && messageReceiverId != null
				&& !messageReceiverId.isEmpty()) {
			List<Message> messageList = messageService.getMessageByUserUniqueId(messageSenderId, messageReceiverId);
			List<MessageModel> messageModelList = JpaToModelConverter.getMessageModelListObject(messageList);
			responseMessage.setData(messageModelList);
			responseMessage.setStatus(true);
		}
		return sendResponse(responseMessage);
	}
}
