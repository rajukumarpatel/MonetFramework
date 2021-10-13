package testScripts;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import appfunction.AppFunc;
import utilities.Constants;

public class SignInTestCase extends RootTest
{
	
	AppFunc ap=new AppFunc(gf); 

	@Test(enabled=true)
	public void signIntestcase() throws FileNotFoundException, IOException 
	{   
		 gf.startchromeBrowser("C:\\Users\\ASTR-34\\Desktop\\MonetFramework\\Drivers\\chromedriver.exe","https://dev.monetrewards.com/diy_beta_1/#/auth");
	     gf.maximixeBrowser();
	     gf.sleep(4000);
         ap.Loadpropfile();
         gf.sleep(4000);
	     ap.signin(Constants.Uname,Constants.pword);
	     ap.logout();
	     gf.sleep(2000);
	     gf.closeBrowser();
	     	 

	}


}
