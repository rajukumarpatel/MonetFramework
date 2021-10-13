
package testScripts;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import appfunction.AppFunc;
import utilities.Constants;

public class ReviewandCheckout extends RootTest 
{

AppFunc ap=new AppFunc(gf);
	
	@Test 
	public void review() throws FileNotFoundException, IOException, AWTException
	 {   
		 gf.startchromeBrowser("C:\\Users\\ASTR-34\\Desktop\\MonetFramework\\Drivers\\chromedriver.exe","http://dev.monetrewards.com/diy_beta_2/#/");
	     //https://dev.monetrewards.com/diy_beta_1/#/auth
		 //http://dev.monetrewards.com/diy_beta_2/#/
		 gf.maximixeBrowser();
		 gf.sleep(3000);
		 ap.Loadpropfile(); 
		 ap.login(Constants.Unames,Constants.pwords); 
		 gf.sleep(3000);
		 ap.reviewandCheckout();  
		 
    	
	 }
}
