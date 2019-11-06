package Practiseprograms;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		
		String abc,rev="";
		Scanner h=new Scanner(System.in);
		System.out.println("Enter a string");
		abc=h.nextLine();
		 
		
		int length=abc.length();
		for(int i=length-1;i>=0;i--) {
			rev=rev+abc.charAt(i);
			}
		
		if(abc.equals(rev)) {
			System.out.println("palindrome");
		}
		else {
			System.out.println("not a palindrome");
		}
		
		}

}
