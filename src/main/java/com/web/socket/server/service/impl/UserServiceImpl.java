package com.web.socket.server.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.socket.server.business.UserBusiness;
import com.web.socket.server.entity.User;
import com.web.socket.server.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserBusiness userBusiness;

	@Override
	public User saveUser(User user) {
		return userBusiness.saveUser(user);
	}

	@Override
	public User getUserById(Integer id) {
		return userBusiness.getUserById(id);
	}

	@Override
	public List<User> getAllUser() {
		return userBusiness.getAllUser();
	}

	@Override
	public boolean deleteUserById(Integer userId) {
		return userBusiness.deleteUserById(userId);
	}

	@Override
	public User getUserByUserUniqueId(String userUniqueId) {
		return userBusiness.getUserByUserUniqueId(userUniqueId);
	}

	@Override
	public User loginUser(String userName, String password) {
		User user = userBusiness.getUserByMobileNumber(userName);
		Boolean isTrue = false;
		if (user != null) {
			isTrue = validateLoginUser(user, userName, password);
		} else {
			user = userBusiness.getUserByEmail(userName);
			if (user != null) {
				isTrue = validateLoginUser(user, userName, password);
			}
		}
		if(isTrue) {
			return user;
		}else {
			return null;
		}
	}

	private Boolean validateLoginUser(User user, String userName, String password) {
		if (userName.equalsIgnoreCase(user.getEmail()) && password.equalsIgnoreCase(user.getPassword())) {
			return true;
		} else if (userName.equalsIgnoreCase(user.getMobileNumber()) && password.equalsIgnoreCase(user.getPassword())) {
			return true;
		}
		return  false;
	}
}
