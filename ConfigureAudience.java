package testScripts;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Test;

import appfunction.AppFunc;
import utilities.Constants;
 
public class ConfigureAudience extends RootTest
{
	AppFunc ap=new AppFunc(gf);

	@Test
	public void configureAudience() throws IOException, AWTException
	 {  
		gf.startchromeBrowser("C:\\Users\\ASTR-34\\Desktop\\MonetFramework\\Drivers\\chromedriver.exe","https://dev.monetrewards.com/diy_beta_1/#/auth");
		 gf.maximixeBrowser();
		 gf.sleep(3000);
		 ap.Loadpropfile();
		 ap.login(Constants.Uname,Constants.pword); 
		 gf.sleep(3000);
		 ap.configureAudience(); 
		 gf.sleep(3000);
		 gf.closeBrowser();
	 }
}

