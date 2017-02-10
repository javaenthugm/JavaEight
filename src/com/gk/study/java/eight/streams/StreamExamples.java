package com.gk.study.java.eight.streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.gk.study.java.eight.behaviour.parameterization.Apple;

/**
 * @author javaenthu
 *
 */
public class StreamExamples {
	
	public static void main(String args[]){
		
		List<Apple> apples = new ArrayList<>();
		
		apples.add(new Apple("red",10f));
		apples.add(new Apple("red",20f));
		apples.add(new Apple("orange",20f));
		apples.add(new Apple("orange",25f));
		apples.add(new Apple("green",10f));
		apples.add(new Apple("green",13f));
		apples.add(new Apple("green",14f));
		apples.add(new Apple("orange",14f));
		
		System.out.println(".............. bigger apples count ...........");
		long  cntbiggerApples = apples.parallelStream().filter(a -> a.getWeight()>10).count();
		System.out.println(cntbiggerApples);
		
		System.out.println(".............. bigger apples .............");
		//Comparator.comparing
		List<Apple> biggerApples = apples.parallelStream()
				.filter(a->a.getWeight()>10)
				.sorted(Comparator.comparing(Apple::getWeight))
				.collect(Collectors.toList());
		
		
		biggerApples.forEach(System.out::println);
		
		biggerApples.forEach(app -> System.out.println(app.getColor()));
				
	}

}
