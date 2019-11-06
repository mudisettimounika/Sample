package Practiseprograms;

import java.util.ArrayList;

public class Arraylist {

	public static void main(String[] args) {
		 int n=6;
		 ArrayList<Integer> var=new ArrayList<Integer>(n);
		 
		 for(int i=1;i<=n; i++) {
			 var.add(i);
			  System.out.println(var);
			 
		 }
	}

}
