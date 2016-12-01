package com.gk.study.java.eight.basics;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.gk.study.java.eight.behaviour.parameterization.Apple;





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
		
		File[] hiddenFiles = new File(".").listFiles(File::isHidden);
		
		List<Apple> s = appleList.parallelStream().filter((Apple a) -> a.getWeight()>1).collect(Collectors.toList());

		//s.sort((Apple a1) -> a1.color.compareTo(a2.color));
		
		for(Apple a :s)System.out.println(a);
		
	}

}
