package Registrationpages;

import org.testng.annotations.Test;

import Salon_web_Reg.Applaunch;
import Salon_web_Reg.Firstregistration;

public class Registration_testcase extends Applaunch{
   @Test
   public void reg() throws Exception {
	   Firstregistration m=new Firstregistration(driver);
	    m.mobilenumber();
	    m.nextbtn();
	    m.otp();
	    m.verifyotpnextbtn();
      m.Firstname();
     m.lastname();
     m.email();
      m.password();
     m.Gender();
      m.coutnry();
      m.Regnextbn();
      m.salonname();
      m.salonaliasname();
      m.contactnumber();
      m.adminemail();
      
      
      
      
      
      
      
      //m.monday();
      //m.scrolldown();
  
  
   }
   
	
	
	
}
