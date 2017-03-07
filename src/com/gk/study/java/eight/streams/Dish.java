package com.gk.study.java.eight.streams;

/**
 * @author javaenthu
 *
 */
public class Dish {
	private final String name;
	private final boolean vegetarian;
	private final int calories;
	private final Type type;
	
	public Dish(String name, boolean vegetarian, int calories, Type type){
		this.name = name;
		this.vegetarian = vegetarian;
		this.calories = calories;
		this.type = type;
	}
	
	
	
	public String getName() {
		return name;
	}



	public boolean isVegetarian() {
		return vegetarian;
	}



	public int getCalories() {
		return calories;
	}



	public Type getType() {
		return type;
	}



	public enum Type{MEAT, FISH, OTHER}
	
	public String toString(){
		
		return "{Dish:Name="+this.name+",Type="+this.type+",Calories="+this.calories+",Is Vegetarian="+this.vegetarian+"}";
	}

}
