package com.caveofprogramming.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Robot {
	
	private String id = "Default robot";
	private String speech = "hello";
	
	public void speak() {
		System.out.println(id + ": " + speech);
	}

	@Autowired
	public void setId(@Value("#{randomText.getText()?.length()}") String id) {
		this.id = id;
	}

	@Autowired
	public void setSpeech(@Value("#{randomText.getText()}") String speech) {
		this.speech = speech;
	}
	
	
}
