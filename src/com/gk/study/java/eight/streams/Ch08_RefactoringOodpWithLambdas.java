package com.gk.study.java.eight.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author javaenthu
 *
 */
public class Ch08_RefactoringOodpWithLambdas {
	
	public static void main(String args[]){
		
		String onlyText="helloworld";
		String onlyNumberic ="1234";
		
		System.out.println(onlyNumberic.matches("\\d+"));
		
		System.out.println(onlyText.matches("[a-z]+"));
		
		IntStream.range(1, 10).filter(i -> i<3).forEachOrdered( i-> System.out.println("here is "+i));
		
		System.out.println(".................8.4.2 Logging information");
		
		List<Integer> numbers = Arrays.asList(2,3,4,5);
		
		numbers.stream()
			   .map(x -> x +17)
			   .peek(x -> System.out.println("x after map="+x))
			   .filter(x -> x % 2 == 0)
			   .peek(x -> System.out.println("x after filter="+x))
			   .limit(2)
			   .forEach(System.out::println);
			   
		
		
	}

}
