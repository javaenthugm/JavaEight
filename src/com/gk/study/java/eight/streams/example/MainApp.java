package com.gk.study.java.eight.streams.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author javaenthu
 *
 */
public class MainApp {

	public static void main(String args[]){
		Trader raoul = new Trader("Raoul","Cambridge");
		Trader mario = new Trader("Mario","Milan");
		Trader alan = new Trader("Alan","Cambridge");
		Trader brian = new Trader("Brian","Cambridge");
		
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
				);
		
		//Find all transaction in the year 2011 and sort them by value
		System.out.println("..................Find all transaction in the year 2011 and sort them by value");
		transactions.stream()
					 .filter(t -> t.getYear()==2011)
					 .sorted(Comparator.comparing(Transaction::getValue))
					 .collect(Collectors.toList()).forEach(System.out::println);
		
		//What are all the unique cities where the traders work
		System.out.println("..................What are all the unique cities where the traders work");
		
		transactions.stream()
					.map(t-> t.getTrader().getCity())
					.distinct()
					.collect(Collectors.toList())
					.forEach(System.out::println);
		
		//instead of 'distinct' use 'toSet'
		System.out.println("..................Using 'toSet', What are all the unique cities where the traders work");
		transactions.stream()
					.map(t-> t.getTrader().getCity())
					.collect(Collectors.toSet())
					.forEach(System.out::println);
		
		//Find all traders from Cambridge and sort them by name
		System.out.println("..................Find all traders from Cambridge and sort them by name");
		transactions.stream()
					.map(tx -> tx.getTrader())
					.filter(tr -> tr.getCity().equals("Cambridge"))
					.sorted(Comparator.comparing(Trader::getName))
					.distinct()
					.collect(Collectors.toList())
					.forEach(System.out::println);
		
		//Return a string of all tranders name sorted alphabetically
		System.out.println("..................Return a string of all tranders name sorted alphabetically");
		
		String allName = transactions.stream()
					.map(Transaction::getTrader)
					.map(Trader::getName)
					.sorted()
					.distinct()
					.reduce("",(n1,n2) -> n1+","+n2);
		
		System.out.println("All names ="+allName.substring(1));
		
		String names = transactions.stream()
					.map(Transaction::getTrader)
					.map(Trader::getName)
					.distinct()
					.sorted()
					.collect(Collectors.joining());
		System.out.println("names="+names);
		
		//Are any tranders based in Milan
		
		System.out.println("..................Are any tranders based in Milan");
		transactions.stream()
					.filter(tx ->tx.getTrader().getCity().equals("Milan"))
					.findAny().ifPresent(System.out::println);
		
		//Print all transactions values from the traders living in Cambridge
		
		System.out.println("..................Print all transactions values from the traders living in Cambridge");
		
		transactions.stream()
					.filter(tx -> tx.getTrader().getCity().equals("Cambridge"))
					.map(Transaction::getValue)
					.forEach(System.out::println);
		//What is the highest value of all transactions
		System.out.println("................What is the highest value of all transactions");
		transactions.stream()
					.map(Transaction::getValue)
					.sorted(Comparator.comparing(Integer::intValue).reversed())
					.findFirst().ifPresent(System.out::println);
		
		
		//What is the highest value of all transactions
		System.out.println("................What is the highest value of all transactions");
		transactions.stream()
					.reduce((t1,t2)->t1.getValue()<t2.getValue()?t1:t2)
					.ifPresent(System.out::println);
					
		
		//Chapter - 6
		System.out.println("................Chapter-6");			
		/*Map<Integer,List<Transaction>> map = transactions.stream()
					.collect(Collectors.groupingBy(Transaction::getYear));
		
		map.forEach((k,v) -> System.out.println("Year="+k+", Transactions=" +v));*/
		
		transactions.stream()
					.collect(Collectors.groupingBy(Transaction::getYear))
					.forEach((k,v) -> System.out.println("Year="+k+", Transactions=" +v));
		
		
		
	}
	
}
