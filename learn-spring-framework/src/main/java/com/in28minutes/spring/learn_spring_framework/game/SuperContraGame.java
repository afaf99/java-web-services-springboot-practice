package com.in28minutes.spring.learn_spring_framework.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SuperContraGame implements GamingConsole {
	
	public void up() {
		System.out.println("Super Contra Game jump");
	}
	
	public void down() {
		System.out.println("Super Contra Game down");
	}
	
	public void left() {
		System.out.println("Super Contra Game left");
	}
	
	public void right() {
		System.out.println("Super Contra Game right");
	}
}
