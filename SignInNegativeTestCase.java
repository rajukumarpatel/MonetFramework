package testScripts;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import appfunction.AppFunc;
import utilities.Constants;

public class SignInNegativeTestCase extends RootTest
{
    AppFunc ap=new AppFunc(gf); 
    @Test(enabled=true)
	public void signinNegativetestcase() throws FileNotFoundException, IOException, AWTException 
	{
     gf.startchromeBrowser("C:\\Users\\ASTR-34\\Desktop\\MonetFramework\\Drivers\\chromedriver.exe","https://dev.monetrewards.com/diy_beta_1/#/auth");
     gf.maximixeBrowser();
     ap.Loadpropfile();
	 ap.signinNegtiveTestcase(Constants.invaUname,Constants.invapword);
	 //gf.closeBrowser();
	 
	}
	
	
}
