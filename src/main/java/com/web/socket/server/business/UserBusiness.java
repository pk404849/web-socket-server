package com.web.socket.server.business;

import java.util.List;

import com.web.socket.server.entity.User;

public interface UserBusiness {
	public User saveUser(User user);

	public User getUserById(Integer userId);

	public List<User> getAllUser();

	public boolean deleteUserById(Integer id);

	public User getUserByUserUniqueId(String userUniqueId);

	public User getUserByMobileNumber(String mobileNumber);

	public User getUserByEmail(String email);
}
