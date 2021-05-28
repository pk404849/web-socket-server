package com.web.socket.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.web.socket.server.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUserUniqueId(String userUniqueId);

	User findByMobileNumber(String mobileNumber);

	User findByEmail(String email);

}
