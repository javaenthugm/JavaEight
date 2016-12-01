package com.gk.study.java.eight.behaviour.parameterization;

public class FancyFormatter implements AppleFormatter {

	@Override
	public String formatApple(Apple a) {
		return "An apple of "+a.getWeight() +" and "+a.getColor();
	}

}
