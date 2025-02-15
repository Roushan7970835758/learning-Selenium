package javaStreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;
import org.testng.annotations.Test;

public class test1 {
	
	//count the number of word starting with alphabet A in given list
	
//	@Test
	public  void regular() {
		ArrayList<String> name = new ArrayList<>();
		name.add("rousnan");
		name.add("Aman");
		name.add("shyam");
		
		name.add("mohan");
		name.add("shivam");
		
		int count=0;
		
		for(int i=0;i<name.size();i++) {
			String actualName = name.get(i);
			
			if(actualName.startsWith("A")) {
				System.out.println(actualName);
				count++;
			}
			
			
			
		}
		
		
	}
//	@Test
	public void streamFilter() {
		ArrayList<String> name = new ArrayList<>();
		name.add("Rousnan");
		name.add("Aman");
		name.add("Ankit");
		name.add("shyam");
		
		name.add("mohan");
		name.add("shivam");
		
		
		
		long n = name.stream().filter(s->s.startsWith("A")).count();
		System.out.println(n);
		
		long n1 = Stream.of("Roushan","Aman","Ankit","Shyam","Mohit").filter(s->{
			s.startsWith("A");
			return false;
		}).count();
		System.out.println(n1);
		
		//Print all the names in arraylist
//		name.stream().forEach(s->System.out.println(s));
//		name.stream().filter(s->s.length()>5).forEach(s->System.out.println(s));
		name.stream().filter(s->s.length()>5).limit(1).forEach(s-> System.out.println(s));
	}
	
//	@Test
	public void streamMap(){
		//print name which has last letter as a with uppercase
		Stream.of("Roushana","Aman","Ankita","Shyama","Mohit").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
		.forEach(s->System.out.println(s));	
		
		//print names which has first letter as a with upper case and sorted
		Stream.of("Roushan","Aman","Ankita","Shyam","Mohit").filter(s->s.startsWith("A")).sorted()
		.forEach(s->System.out.println(s));
		
		
		//merging two list and printing in sorted order
		List<String> names =Arrays.asList("Roushan","Mohit","Ankit","Ankita","praveen");
		
		ArrayList<String> names1 = new ArrayList<>();
		names1.add("Rousnan");
		names1.add("Aman");
		names1.add("Ankit");
		names1.add("shyam");
		
		names1.add("mohan");
		names1.add("shivam");
		
		Stream<String> mergedList = Stream.concat(names.stream(), names1.stream());
//		mergedList.sorted().forEach(s->System.out.println(s));
		
		//find if perticular value is present or not
		boolean flag = mergedList.anyMatch(s->s.equalsIgnoreCase("Roushan"));
		
		Assert.assertTrue(flag);
		
				
		}
	@Test
	public void streamCollect() {
		List<String> ls = Stream.of("Roushan","Aman","Ankita","Shyam","Mohit").filter(s->s.startsWith("A")).map(s->s.toUpperCase())
		.collect(Collectors.toList());
		System.out.println(ls.get(0));
		ls.stream().limit(1).forEach(s->System.out.println(s));
		
		
		List<Integer> arr = Arrays.asList(2,4,6,3,3,66,45,66,76);
		//print unique number from this array
		arr.stream().distinct().forEach(s->System.out.println(s));
		//sort this array &get the 3rd index
		List<Integer> ans = arr.stream().distinct().sorted().collect(Collectors.toList());
		System.out.println(ans.get(2));
		
		
		
		
	}
}









