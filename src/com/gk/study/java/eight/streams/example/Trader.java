package com.gk.study.java.eight.streams.example;

/**
 * @author javaenthu
 *
 */
public class Trader {

	private final String name;
	private final String city;
	
	public Trader(String name, String city){
		this.name = name;
		this.city = city;
	}
	
	public String getCity(){
		return this.city;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String toString(){
		return "Trader:"+this.name+" in "+ this.city;
	}
}
