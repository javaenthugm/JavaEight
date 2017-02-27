package com.gk.study.java.eight.streams.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author java
 *
 */
public class IOExamples {
	
	public static void main(String args[]){
		String fileName = "/home/gopi/work/study/datasource/printers.txt";
		
		try(Stream<String> lines = Files.lines(Paths.get(fileName))) {
			
			//lines.forEach(System.out::println);
			
			List<String> fLine = lines.filter(line->line.contains("Download"))
			.map(line->line.toUpperCase())
			.collect(Collectors.toList());
			
			fLine.forEach(System.out::println);
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
