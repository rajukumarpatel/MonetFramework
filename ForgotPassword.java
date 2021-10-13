package testScripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import appfunction.AppFunc;

public class ForgotPassword extends RootTest
{
	AppFunc ap=new AppFunc(gf);
	
	@Test(enabled=true)
	public void forgotpassword() throws FileNotFoundException, IOException
	{
		 gf.startchromeBrowser("C:\\Users\\ASTR-34\\Desktop\\MonetFramework\\Drivers\\chromedriver.exe","https://dev.monetrewards.com/diy_beta_1/#/auth");
	     gf.maximixeBrowser();
         ap.forgotpassword();
         gf.sleep(5000);
         gf.closeBrowser();
         
		 
		
	}
	
	
}
