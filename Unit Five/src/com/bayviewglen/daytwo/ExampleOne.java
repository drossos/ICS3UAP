package com.bayviewglen.daytwo;

public class ExampleOne {

	public static void main(String[] args) {
	/*
	 Java makes a copy when you run things through a method
	 After it runs through the method destroys the variables and returns the variables back to main
	 Runs through method with copy of the data, 

EXAMPLE ONE
Main 

int z = 7
int y = mystery (z)
y = mystery(y)



MYSTERY 
int mystery (int p){
p*=3
return p;
}


EXAMPLE TWO
void mystery (String str)  [mystery gets a copy to reference to bye]{
str = str + "hi";
} in the end str will go to "byehi" and s will still equal "bye"

MAIN
String s = "bye";
mystery(s);    s[b|y|e]


	
	 */
		
		String s = "Bye";
		mystery(s);
		int[] arr = {0,1,2,3,4,5,6,7,8,9};
		mystery(arr);

}
	private static void mystery(int[] a){
		a[3] = 10;
	}
	public static void mystery(String str){
		str = str + "hi";
	}
}