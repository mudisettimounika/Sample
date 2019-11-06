package Practiseprograms;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataprovider {

	@Test(dataProvider="getdata")
	public void setdata(String username, String password) 
	{
		System.out.println("your username is::"+username);
		System.out.println("your password is::"+password);

	}
	
	@DataProvider
	public Object[][] getdata() {
	Object[][] data=new  Object[3][2];	
		
	data[0][0]="user1";
	data[0][1]="abcds";
	
	data[1][0]="user2";
	data[1][1]="abcds";
	
	data[2][0]="user3";
	data[2][1]="abcds";
		
		return data;

	}
	
	
}
