package com.gk.study.java.eight.streams;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author javaenthu
 *
 */
public class StreamBuilders {

	public static void main(String args[]){
		
		System.out.println("............... 5.7.2 Stream from values - Stream.of");
		
		Stream<String> strings = Stream.of("Java 8 ","Lambdas ","In","Action");
		
		strings.map(s -> s.toUpperCase())
				.forEach(s -> System.out.println(s));
		
		System.out.println("............... 5.7.2 Stream from arrays - Arrays.stream");
		int[] arr = {1,2,3,4,5,6};
		
		System.out.println(Arrays.stream(arr).sum());
		
		System.out.println("............... 5.7.4 Stream from functions:creating infinite streams");
		
		Stream.iterate(0, n -> n+2)
			  .limit(10)
			  //.map(e -> Arrays.asList(e))
			  .forEach(System.out::println);
		
		//Fibonacci tuple series
		System.out.println("............... Fibonacci tuple series");
		Stream.iterate(new int[]{0,1},t -> new int[]{t[1],t[0]+t[1]})
			  .limit(20)
			  .forEach(ar -> System.out.print(Arrays.toString(ar) +" "));
		
		/*Stream.iterate(1, n->n+2)
			  .limit(20)
			  .forEach(System.out::println);*/
		System.out.println("............... Fibonacci series");
		Stream.iterate(new int[]{0, 1}, t->new int[]{t[1],t[0]+t[1]})
			  .limit(20)
			  .map(e -> e[0])
			  .forEach(fs -> System.out.print(fs+" "));
		}
					
		
	
}
