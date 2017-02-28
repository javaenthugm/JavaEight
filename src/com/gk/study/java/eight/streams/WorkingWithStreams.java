package com.gk.study.java.eight.streams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
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
		pairs.forEach(e -> System.out.println(Arrays.toString((int[])e)));
		
		
		System.out.println("................. Optional");
		
		Optional<String> option = words
									.stream()
									.filter(e->e.length()>10)
									.findAny();
		
		option.ifPresent(e->System.out.println(e));
		
		System.out.println("................. Finding the first Element");
		
		List<Integer> iList = Arrays.asList(1,2,3,4,5);
		
		Optional<Integer> element = iList.stream()
								 .map(x -> x*x)
								 .filter(x -> x%3 == 0)
								 .findFirst();

		element.ifPresent(e->System.out.println(e));
		
		System.out.println("................. 5.4 Reducing");
		
		int sum = iList.stream().reduce(0,(a,b) -> a+b);
		System.out.println("sum="+sum);
		
		Optional<Integer> optionalSum = iList.stream().reduce((a,b)-> a+b );
		optionalSum.ifPresent(System.out::println);
		
		
		System.out.println("................. 5.4.2 Maximum and Minimum - using Method reference");
		
		iList.stream().reduce(Integer::max).ifPresent(max -> System.out.println("max="+max));
		
		iList.stream().reduce(Integer::min).ifPresent(min -> System.out.println("min="+min));
		
		System.out.println("................. 5.4.2 Maximum and Minimum - using Using lambda");
		
		iList.stream().reduce((a,b) -> a<b?a:b).ifPresent(min->System.out.println("min="+min));
		iList.stream().reduce((a,b) -> a>b?a:b).ifPresent(max->System.out.println("max="+max));
		
		iList.stream().map(e ->1).reduce(Integer::sum).ifPresent(count -> System.out.println("count="+count));
		System.out.println("count="+iList.stream().count());
		System.out.println("count="+iList.stream().collect(Collectors.toList()).size());
	
	}

}
