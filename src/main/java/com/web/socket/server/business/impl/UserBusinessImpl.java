package com.web.socket.server.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.socket.server.business.UserBusiness;
import com.web.socket.server.entity.User;
import com.web.socket.server.repository.UserRepository;

@Service
public class UserBusinessImpl implements UserBusiness{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(Integer userId) {
		return userRepository.getById(userId);
	}

	@Override
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@Override
	public boolean deleteUserById(Integer userId) {
		userRepository.deleteById(userId);
		return true;
	}

	@Override
	public User getUserByUserUniqueId(String userId) {
		return userRepository.findByUserUniqueId(userId);
	}

	@Override
	public User getUserByMobileNumber(String mobileNumber) {
		
		return userRepository.findByMobileNumber(mobileNumber);
	}

	@Override
	public User getUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}
}
