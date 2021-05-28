package com.web.socket.server.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.socket.server.constant.MessageApiConstant;
import com.web.socket.server.controller.BaseController;
import com.web.socket.server.controller.ResponseMessage;
import com.web.socket.server.converter.JpaToModelConverter;
import com.web.socket.server.converter.ModelToJpaConverter;
import com.web.socket.server.entity.User;
import com.web.socket.server.model.LoginModel;
import com.web.socket.server.model.UserModel;
import com.web.socket.server.service.UserService;

@RestController
@RequestMapping(value = "/user")
@CrossOrigin(value = "http://localhost:4200")
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/save-user")
	public ResponseEntity<?> saveUser(@RequestBody UserModel userModel) {
		ResponseMessage responseMessage = new ResponseMessage();

		User user = ModelToJpaConverter.getUserJpaObject(userModel);
		if (user != null) {
			userService.saveUser(user);
			responseMessage.setStatus(true);
			if (userModel.getId() == null || userModel.getId() == 0) {
				responseMessage.setMessage(MessageApiConstant.SAVED_USER);
			} else {
				responseMessage.setMessage(MessageApiConstant.UPDATE_USER);
			}
		}
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/get-user-by-id/{id}")
	public ResponseEntity<?> getUserById(@PathVariable(value = "id") Integer id) {
		ResponseMessage responseMessage = new ResponseMessage();
		if (id != null && id != 0) {
			User user = userService.getUserById(id);
			UserModel userModel = JpaToModelConverter.getUserModelObject(user);
			responseMessage.setData(userModel);
			responseMessage.setStatus(true);
		}
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/get-user-by-user-unique-id/{userUniqueId}")
	public ResponseEntity<?> getUserByUserId(@PathVariable(value = "userUniqueId") String userUniqueId) {
		ResponseMessage responseMessage = new ResponseMessage();
		if (userUniqueId != null && !userUniqueId.isEmpty()) {
			User user = userService.getUserByUserUniqueId(userUniqueId);
			UserModel userModel = JpaToModelConverter.getUserModelObject(user);
			responseMessage.setData(userModel);
			responseMessage.setStatus(true);
		}
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/get-all-users")
	public ResponseEntity<?> getAllUser() {
		ResponseMessage responseMessage = new ResponseMessage();
		List<User> userList = userService.getAllUser();
		if (userList != null && !userList.isEmpty()) {
			List<UserModel> userModelList = JpaToModelConverter.getUserModelListObject(userList);
			responseMessage.setData(userModelList);
			responseMessage.setStatus(true);
		}
		return sendResponse(responseMessage);
	}

	@GetMapping(value = "/delete-user-by-id/{userId}")
	public ResponseEntity<?> deleteUserById(@PathVariable(value = "userId") Integer userId) {
		ResponseMessage responseMessage = new ResponseMessage();
		if (userId != null && userId != 0) {
			boolean isDeleted = userService.deleteUserById(userId);
			responseMessage.setStatus(isDeleted);
			responseMessage.setMessage(MessageApiConstant.DELETED_USER);
		}
		return sendResponse(responseMessage);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody LoginModel loginModel) {
		ResponseMessage responseMessage = new ResponseMessage();
		User loginUser = userService.loginUser(loginModel.getUserName(), loginModel.getPassword());
		if (loginUser != null) {
			responseMessage.setStatus(true);
			responseMessage.setData(loginUser);
		} else {
			responseMessage.setMessage("Invalid credential, Please try again...");
		}
		return sendResponse(responseMessage);
	}
}
