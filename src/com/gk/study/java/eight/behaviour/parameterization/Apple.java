package com.gk.study.java.eight.behaviour.parameterization;

/**
 * @author javaenthu
 *
 */
public class Apple {
	
	String color;
	Float weight;
	
	public Apple(Float wgt,String col){
		this.weight=wgt;
		this.color=col;
	}
	
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
