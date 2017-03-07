package com.gk.study.java.eight.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author javaenthu
 *
 */
public class Ch06_CollectingDataWithStreams {
	
	
	
	public static void main(String args[]){
		
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
		
		System.out.println(".................Count number of dishes in the menu");
		System.out.println(menu.stream()
								.collect(Collectors.counting()));
		
		menu.stream()
			.collect(Collectors.maxBy(Comparator.comparing(Dish::getCalories)))
			.ifPresent(dish -> System.out.println("High Calory Dish="+dish));
		
		
		System.out.println("Total Calory="+menu.stream()
												.collect(Collectors.summingInt(Dish::getCalories)));
		System.out.println("Average Calory="+menu.stream()
												 .collect(Collectors.averagingDouble(Dish::getCalories)));
			
		
		System.out.println(".................6.2.2 Summarization");
		System.out.println("Summary=" + menu.stream()
											.collect(Collectors.summarizingInt(Dish::getCalories)));
		
		System.out.println(".................6.2.3 Joining Strings");
		System.out.println(menu.stream()
								.map(Dish::getName)
								.collect(Collectors.joining(",")));
		System.out.println(".................6.3 Grouping");
		menu.stream()
			.collect(Collectors.groupingBy(Dish::getType))
			.forEach((k,v) -> System.out.println("Name="+k+",Value="+v));
		
		
		menu.stream()
			.collect(Collectors.groupingBy(Dish::getType, Collectors.counting()))
			.forEach((k,v) -> System.out.println(k+"="+v));
		menu.stream()
			.collect(Collectors.groupingBy(Dish::getType, Collectors.toList()))
			.forEach((k,v) -> System.out.println(k+"="+v.size()));
		
	
		menu.stream()
			.collect(Collectors.groupingBy(Dish::getType,Collectors.maxBy(Comparator.comparing(Dish::getCalories))))
			.forEach((k,v) -> System.out.println(k+"="+v.get().getName()));
		
		menu.stream()
			.collect(Collectors.groupingBy(Dish::getType, Collectors.summingInt(Dish::getCalories)))
			.forEach((k,v) -> System.out.println(k+"="+v));
				
		
		System.out.println(".................6.4 Partitioning");
		menu.stream()
			.collect(Collectors.partitioningBy(Dish::isVegetarian))
			.forEach((k,v) -> System.out.println(k+"="+v.stream().map(Dish::getName).collect(Collectors.toList())));
		
	}
	

}
