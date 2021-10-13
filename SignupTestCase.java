package testScripts;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import appfunction.AppFunc;

public class SignupTestCase extends RootTest
{
	AppFunc ap=new AppFunc(gf);
	
@org.testng.annotations.Test(enabled=true)

public void signup() throws AWTException, FileNotFoundException, IOException
{
	gf.startchromeBrowser("C:\\Users\\ASTR-34\\Desktop\\MonetFramework\\Drivers\\chromedriver.exe","https://dev.monetrewards.com/diy_beta_1/#/auth");
    gf.maximixeBrowser();
    gf.sleep(5000);
    ap.signup();
    gf.sleep(4000);
    gf.closeBrowser();
  
}

	
	
}
