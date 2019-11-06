package Practiseprograms;

public class Overloading {
	
	public int add(int a, int b) {
		return (a+b);
		}
	public int add(int a, int b, int c) {
		return(a+b+c);
	}
	public double add(double a, double b, double c) {
		return(a+b+c);
	}

public static void main(String[] args) {
	Overloading s=new Overloading();
	System.out.println(s.add(10, 10));
	System.out.println(s.add(10, 10, 10));
	System.out.println(s.add(10.5, 10.5, 0.5));
}



}


