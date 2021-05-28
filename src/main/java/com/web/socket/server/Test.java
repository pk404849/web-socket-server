package com.web.socket.server;

import java.time.LocalDateTime;

public class Test {

	public static void main(String[] args) {
		LocalDateTime localDateTime = LocalDateTime.now(); 
		int year = localDateTime.getYear();
		int monthValue = localDateTime.getMonthValue();
		int dayOfMonth = localDateTime.getDayOfMonth();
		String date = dayOfMonth + ":" + monthValue + ":" + year;
		System.out.println(date);

	}

}
