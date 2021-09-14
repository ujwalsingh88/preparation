package com.java.preparation.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.java.preparation.exception.CustomException;
import com.java.preparation.model.Java8Model;

@Service("javaEight")
public class JavaEight {

	private Logger logger = Logger.getLogger(LinkedList.class);
	
	public void testJava8Features() throws CustomException{
		
		List <Integer>intList = new ArrayList<Integer>();
		intList.add(5);
		intList.add(7);
		intList.add(3);
		intList.add(2);
		intList.add(4);
		intList.add(1);
		intList.add(8);
		intList.add(6);
		intList.add(8);
		
		List <String>stringList = new ArrayList<String>();
		stringList.add("kkd");
		stringList.add("scavc");
		stringList.add("efq");
		stringList.add("abd");
		stringList.add("sfdj");
		stringList.add("abc");
		stringList.add("def");
		stringList.add("bfg");
		
		List<Java8Model> objList = new ArrayList<Java8Model>();
		objList.add(new Java8Model(3,23,56000,"Hamas"));
		objList.add(new Java8Model(1,32,60000,"Ster"));
		objList.add(new Java8Model(2,27,50000,"Abc"));
		objList.add(new Java8Model(4,21,65000,"Def"));
		
	
		
		// Sum Of Even
		int sum =intList.stream().filter(a->a%2==0).mapToInt(a->a).sum();
		System.out.println("EvenSum::"+sum);
		
		//Sum of Age greater 23
		int ageSum= objList.stream().filter(a->a.getAge()>23).mapToInt(a->a.getAge()).sum();
		System.out.println("AgeSum::"+ageSum);
		
		
		//DistinctCount
		long distinctSum= intList.stream().mapToInt(a->a).distinct().count();
		System.out.println("distinctSum::"+distinctSum);
		
		
		//CreateIntList
		List<Integer> intsList = Stream.iterate(0,i->i+2).limit(10).collect(Collectors.toList());
		System.out.println("Random List:::" +intsList.toString());
		
		//CreateIntList  include start, exclude end
		intsList=IntStream.range(1, 7).boxed().collect(Collectors.toList());
		System.out.println("Range List:::" +intsList.toString());
		
		
		//CreateIntList  include start, include end
		intsList=IntStream.rangeClosed(1, 7).boxed().collect(Collectors.toList());
		System.out.println("RangeClosed List:::" +intsList.toString());
		
		
		
		// String builder
		//String builder =Stream.<String>builder().add("Pk").add("ac").add("20").build().flatMap(a->a);
		
		//Join List value into single string
		String joinedString =objList.stream().map(a->a.getName()).collect(Collectors.joining(",","{","}"));
		System.out.println("Join List value into single string:::" +joinedString);
		
		
		
		//Average
		OptionalDouble average =intList.stream().mapToInt(a->a).average();
		System.out.println("average::"+average.getAsDouble());
		
		//max
		OptionalInt max =intList.stream().mapToInt(a->a).max();
		System.out.println("max::"+max.getAsInt());
		
		
		//max
		OptionalInt min =intList.stream().mapToInt(a->a).min();
		System.out.println("min::"+min.getAsInt());
		
		//Stats
		IntSummaryStatistics stats= intList.stream().mapToInt(a->a).summaryStatistics();
		System.out.println("Stats::" +stats);
		
		
		//Sorting List
		objList.sort((h1, h2) -> h1.getName().compareTo(h2.getName()));
		intList.sort((h1, h2) -> h1-h2);
		System.out.println("Sorted Name List::"+ objList.toString());
		System.out.println("Sorted Int List::"+ intList.toString());
		System.out.println("Completed");
		
		
	}
	
	
}
