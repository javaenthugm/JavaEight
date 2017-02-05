package com.gk.study.java.eight.behaviour.parameterization;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

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
		
		//using AppleFormatter predicate
		filterApple(inventory, new FancyFormatter());
		
		
		//using anonymous inner class
		filterApple(inventory, new AppleFormatter() {
			
			@Override
			public String formatApple(Apple a) {
				return "printing only color="+a.getColor();
			}
		});
		
		// lambda
		filterApple(inventory, (Apple a) -> "Color or the apple is  "+a.getColor());
		
		//Sorting using anonymous inner class		
		inventory.sort(new Comparator<Apple>() {

			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight().compareTo(o2.getWeight());
			}
			
		});
		
		System.out.println();
		System.out.println("Sorting by Anonymous inner class - by weight");
		for(Apple a : inventory)System.out.println(a);
		
		//Sorting using lamdas
		inventory.sort((Apple a1,Apple a2) -> a1.getColor().compareTo(a2.getColor()));
		
		System.out.println();
		System.out.println("Sorting by Lambdas - by color");
		for(Apple a : inventory)System.out.println(a);
		
		
		Runnable r1 = () -> System.out.println(Thread.currentThread().getName());
		Thread t1 = new Thread(r1);
		t1.start();
		
		
		Predicate<String> nonEmptyString = (String s) -> !s.isEmpty();
		
		
		
	}

}
