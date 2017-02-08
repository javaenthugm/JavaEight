package com.gk.study.java.eight.basics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import com.gk.study.java.eight.behaviour.parameterization.Apple;

/**
 * @author javaenthu
 *
 */
public class Java8Examples {
	
	public static void main(String args[]){
		
		int portNumer = 123;
		
		Runnable r  = () -> System.out.println("hello "+portNumer);
		r.run();
		
		
		BiFunction<String,Float, Apple> c = Apple::new;
		Apple a = c.apply("red",100f);
		Apple b = c.apply("blue",200f);
		
		System.out.println("....................");
		List<Apple> apples = new ArrayList<>();
		apples.add(a);
		apples.add(b);
		apples.add(c.apply("green",50f));
		
		apples.forEach(apple->System.out.println(apple));
		System.out.println("....................");
		
		apples.forEach(System.out::println);
		
		System.out.println("....................");
		
		apples.sort(Comparator.comparing(Apple::getWeight).reversed().thenComparing(Apple::getColor));
		apples.forEach(System.out::println);
		System.out.println("....................");
		
		/*List<Apple> redApple = apples.parallelStream().filter((app)->"red".equalsIgnoreCase(app.getColor())).collect(Collectors.toList());
		redApple.forEach(System.out::println);*/
		
		Predicate<Apple> ra = (ap)->"red".equalsIgnoreCase(ap.getColor());
		
		
		
		
		Predicate<String> nonEmptyStringPreidcate = (String s)->!s.isEmpty();
		
		List<Integer> items = Arrays.asList(1,4,5,6,9);
		
		
		items.forEach(item->System.out.println(item));
		System.out.println("....................");
		items.forEach(item->{
			if(item<5)System.out.println(item);
		});
		System.out.println("....................");
		items.forEach(System.out::println);
		System.out.println("....................");
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "One");
		map.put(2, "Two");
		map.put(3, "Three");
		map.put(4, "Four");
		map.put(5, "Five");
		map.put(6, "Six");
		
		map.forEach((k,v)->System.out.println("key="+k+",value="+v));
		
		IntPredicate intPredicate = (int i) -> i%2 == 0;
		System.out.println(intPredicate.test(1000));
		
		Predicate<Integer> predicate = (Integer i) -> i%2 ==0;
		
		System.out.println(predicate.test(1000));
		
		Consumer ss = (s) ->System.out.println(""+s);
		
		System.out.println("....... Method Referfence ...........");
		
		List<String> str = Arrays.asList("a","b","A","B");
		System.out.println(str);
		
		str.sort((s1,s2)->s1.compareToIgnoreCase(s2));
	
		System.out.println(str);
		
		str.sort(String::compareToIgnoreCase);
		System.out.println(str);
		
		
		
	}

}
