package testScripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import appfunction.AppFunc;

public class ForgotPassWithInvalidOtp extends RootTest
{
AppFunc ap=new AppFunc(gf);
	
	@Test(enabled=true)
	
	public void ForgotPasswordwithInvlidOTP() throws FileNotFoundException, IOException
	{
		 gf.startchromeBrowser("C:\\Users\\ASTR-34\\Desktop\\MonetFramework\\Drivers\\chromedriver.exe","https://dev.monetrewards.com/diy_beta_1/#/auth");
	     gf.implicitwait(20);
		 gf.maximixeBrowser();
	     gf.sleep(4000);
         ap.ForgotPassWithInvalidOtp();
         gf.sleep(4000);
         gf.closeBrowser();
		 
		
	}
}
