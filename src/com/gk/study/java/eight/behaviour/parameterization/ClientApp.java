package com.gk.study.java.eight.behaviour.parameterization;

import java.util.ArrayList;
import java.util.List;

public class ClientApp {
	
	public static void filterApple(List<Apple> inventory, AppleFormatter formatter){
		for(Apple a :inventory){
			System.out.println(formatter.formatApple(a));
		}
	}
	
	public static void main(String args[]){
		List<Apple> inventory = new ArrayList<>();
		
		inventory.add(new Apple("red", 6.0f));
		inventory.add(new Apple("blue", 2.0f));
		inventory.add(new Apple("purple", 1.0f));
		inventory.add(new Apple("green", 3.0f));
		
		
		filterApple(inventory, new FancyFormatter());
	}

}
