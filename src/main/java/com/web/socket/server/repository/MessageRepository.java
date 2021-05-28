package com.web.socket.server.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.web.socket.server.entity.Message;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

	@Query("SELECT m from Message m where m.messageSender =:messageSenderId and m.messageReceiver =:messageReceiverId")
	List<Message> findMessageBySenderAndReceiverId(
			@Param("messageSenderId") String messageSenderId,
			@Param("messageReceiverId") String messageReceiverId);

}
