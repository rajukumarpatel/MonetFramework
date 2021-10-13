package testScripts;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import appfunction.AppFunc;
import utilities.Constants;

public class UploadContentTestCase extends RootTest
{
AppFunc ap=new AppFunc(gf);

@Test
public void uploadContent() throws FileNotFoundException, IOException, AWTException
 {
	 gf.startchromeBrowser("C:\\Users\\ASTR-34\\Desktop\\MonetFramework\\Drivers\\chromedriver.exe","https://dev.monetrewards.com/diy_beta_1/#/auth");
	 gf.maximixeBrowser();
	 gf.sleep(3000);
	 ap.Loadpropfile();
	 ap.login(Constants.Uname,Constants.pword); 
	 gf.sleep(3000);
	 ap.uploadcontent();
	 gf.sleep(3000);
	 gf.closeBrowser();  
 }
		
}
   

		
