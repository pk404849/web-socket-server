package com.web.socket.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
public class BaseController {

	public ResponseEntity<?> sendResponse(ResponseMessage responseMessage) {
		return ResponseEntity.ok().body(responseMessage);
	}
}
