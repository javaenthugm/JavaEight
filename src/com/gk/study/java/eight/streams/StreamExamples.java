package com.gk.study.java.eight.streams;

import java.util.ArrayList;
import java.util.Arrays;
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
				.filter(a->a.getWeight()>14)
				.sorted(Comparator.comparing(Apple::getWeight))
				.collect(Collectors.toList());
		
		
		biggerApples.forEach(System.out::println);
		
		biggerApples.forEach(app -> System.out.println(app.getColor()));
		System.out.println("...........................................");
		System.out.println(biggerApples.parallelStream().findFirst().get().getColor());
		
		System.out.println("...........................................");
		System.out.println(biggerApples.parallelStream().findAny().get().getColor());
		
		
		/**
		 * Data source
		 * */
		
		List<Dish> menu = Arrays.asList(
				new Dish("pork",false, 800, Dish.Type.MEAT),
				new Dish("beef",false, 700, Dish.Type.MEAT),
				new Dish("chicken",false, 400, Dish.Type.MEAT),
				new Dish("french fries",true, 530, Dish.Type.OTHER),
				new Dish("rice",true, 350, Dish.Type.OTHER),
				new Dish("season fruit",true, 120, Dish.Type.OTHER),
				new Dish("pizza",true, 550, Dish.Type.OTHER),
				new Dish("prawns",false, 300, Dish.Type.FISH),
				new Dish("salmon",false, 300, Dish.Type.FISH)				
				);
		
		List<String> hcItems = menu.parallelStream().filter(m -> m.getCalories() > 400).map(Dish::getName).collect(Collectors.toList());
		hcItems.forEach(System.out::println);
		
		
	}

}
