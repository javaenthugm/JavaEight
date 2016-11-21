package com.gk.study.java.eight.basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Apple{
	
	String color;
	Float weight;
	
	public Apple(String clr,Float wgt){
		this.color = clr;
		this.weight = wgt;
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", weight=" + weight + "]";
	}
	
	
}



/**
 * @author javaenthu
 *
 */
public class WhyJavaEight {
	
	public static void main(String args[]){
		
		Apple a1 = new Apple("red",3.0f);
		Apple a2 = new Apple("red",5.0f);
		Apple a3 = new Apple("red",1.0f);
		
		List<Apple> appleList = new ArrayList<>();
		appleList.add(a1);
		appleList.add(a2);
		appleList.add(a3);
		
		System.out.println("Before Sorting:"+appleList.toString());
		
		Collections.sort(appleList, new Comparator<Apple>() {

			@Override
			public int compare(Apple o1, Apple o2) {
				return o1.getWeight().compareTo(o2.getWeight());
			}
		});
		
		System.out.println("After Sorting using Java 7:"+appleList.toString());
		
		//System.out.println("Soring using java 8:"+appleList.sort(comparing(Apple::getWeight)));
		
	}

}
