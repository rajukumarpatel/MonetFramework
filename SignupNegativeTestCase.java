package testScripts;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import appfunction.AppFunc;

public class SignupNegativeTestCase extends RootTest

{   AppFunc ap=new AppFunc(gf);
	@Test
	public void signupNegativeTestcase() throws FileNotFoundException, IOException, AWTException
	{   gf.startchromeBrowser("C:\\Users\\ASTR-34\\Desktop\\MonetFramework\\Drivers\\chromedriver.exe","https://dev.monetrewards.com/diy_beta_1/#/auth");
	    gf.maximixeBrowser();
	    ap.signupNegativeTestCase();
		gf.sleep(4000);
		gf.closeBrowser();
	   
		
		
	}
	
	
}
