package com.bayviewglen.daythree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ExampleTwo {

	public static void main(String[] args) {
		List <String> words = new ArrayList<String>();
		words = new LinkedList<String>();
		
		words.add("hi");
		words.add("bye");
		
		for (String i : words)
			System.out.println(i);
	}

}
