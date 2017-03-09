package com.gk.study.java.eight.streams;

import java.util.function.Function;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @author javaenthu
 *
 */
public class Ch07_ParallelDataProcessingAndPerformance {
	
	public static void main(String args[]){
		/*long sum = LongStream.rangeClosed(1, 10000000)
						   .parallel()
				 		   .reduce(0L,(a,b) -> a+b) ;
		System.out.println("sum="+sum);*/
		
		System.out.println("Sequetial sum done in "
							+ measureSumPerf(Ch07_ParallelDataProcessingAndPerformance::sequentialSum, 10_000_000) + " msecs");
		
		//System.out.println("Iterative sum done in "
		//		+ measureSumPerf(Ch07_ParallelDataProcessingAndPerformance::iterativeSum, 10_000_000) + " msecs");

		System.out.println("Sequetial sum done in "
				+ measureSumPerf(Ch07_ParallelDataProcessingAndPerformance::parallelSum, 10_000_000) + " msecs");
	  
		System.out.println("Sequetial sum using Streams done in "
				+ measureSumPerf(Ch07_ParallelDataProcessingAndPerformance::parallelSumUsingLongStream, 10_000_000) + " msecs");
		
	}
	
	public static long sequentialSum(long n){
		return Stream.iterate(1L, i ->i+1)
					 .limit(n)
					 .reduce(0L, Long::sum);
	}
	
	
	public static long parallelSum(long n){
		
		return Stream.iterate(1L,i ->i+1)
					 .limit(n)
					 .parallel()
					 .reduce(0L, (a,b) -> a+b);
	}
	public static long iterativeSum(long n){
		long result = 0;
		
		for(long i= 1L ;i <=n; n++){
			result +=i;
		}
		return result;
	}
	
	public static long parallelSumUsingLongStream(long n){
		return LongStream.rangeClosed(1, n)
						 .parallel()
						 .reduce(1L, (a,b) -> a+b);
	}
	
	
	public static long measureSumPerf(Function<Long, Long> adder , long n){
		
		long fastest  = Long.MAX_VALUE;
		
		for (int i=0;i < 10;i++){
			long start = System.nanoTime();
			long sum = adder.apply(n);
			long duration = (System.nanoTime() - start)/1_000_000;
			
			System.out.println("Result = "+sum);
			if(duration < fastest) fastest = duration;
		}
		
		return fastest;
	}
	

}
