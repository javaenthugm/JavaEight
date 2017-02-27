package com.gk.study.java.eight.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author javaenthu
 *
 */
public class WorkingWithStreams {
	
	public static void main(String args[]){
		
		List<String> words = Arrays.asList("Java8","Lambdas","In","Action");
		
		System.out.println("................. map");
		words.stream()
			 .map(String::length)
			 .forEach(System.out::println);
		
		System.out.println("..................");
		
		words.stream()
			 .map(e -> e.length())
			 .sorted(Comparator.comparing(e -> e.toString()).reversed())
			 .limit(1)
			 .forEach(e -> System.out.println(e));
		
		
		
		System.out.println("................. flatMap");
		
		List<String> uniquewords = words.stream()
									   .map(e -> e.toLowerCase())
									   .map(word -> word.split(""))
									   .flatMap(arr -> Arrays.stream(arr))
									   .distinct()
									   .collect(Collectors.toList());
		
		uniquewords.forEach(System.out::print);
		
		List<Integer> numbers1 = Arrays.asList(1,2,3);
		List<Integer> numbers2 = Arrays.asList(2,3);
		
		
		List pairs = numbers1.stream()
							.flatMap(i -> numbers2.stream().map(j -> new int[]{i,j}))
							.collect(Collectors.toList());
		
	}

}
