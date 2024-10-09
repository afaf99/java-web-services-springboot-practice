package com.in28minutes.spring.learn_spring_framework.game;

import org.springframework.stereotype.Component;

@Component
public class PacManGame implements GamingConsole {
	
	public void up() {
		System.out.println("Pac Man Gamejump");
	}
	
	public void down() {
		System.out.println("Pac Man Game down into a hole");
	}
	
	public void left() {
		System.out.println("Pac Man Game stop");
	}
	
	public void right() {
		System.out.println("Pac Man Game accelerate");
	}
}
