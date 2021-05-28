package com.web.socket.server.service;

import java.util.List;

import com.web.socket.server.entity.User;

public interface UserService {
	public User saveUser(User user);

	public User getUserById(Integer userId);

	public List<User> getAllUser();

	public boolean deleteUserById(Integer id);

	public User getUserByUserUniqueId(String userUniqueId);

	public User loginUser(String userName, String password);
}
