package Practiseprograms;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Systemdate {
	
	public static void main(String[] args) {

		DateFormat df=new SimpleDateFormat("MM/dd/yyyy HH:mm.ss");
		
		Date d=new Date();
		
		String date=df.format(d);
		
		System.out.println("current date is " +date);
		}

}
