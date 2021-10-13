package imagetestscript;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import appfunction.AppFunc;
import testScripts.RootTest;
import utilities.Constants;

public class ImageProfileTestCase  extends RootTest
{
AppFunc ap=new AppFunc(gf);
@Test
public void imageprofile() throws FileNotFoundException, IOException, EncryptedDocumentException, AWTException
{
 gf.startchromeBrowser("C:\\Users\\ASTR-34\\Desktop\\MonetFramework\\Drivers\\chromedriver.exe","https://dev.monetrewards.com/diy_dev_image_report/#/auth");
 gf.maximixeBrowser();
 ap.Loadpropfile();
 ap.login(Constants.iUname,Constants.ipassword); 
 ap.imageprofiletestcase();
 gf.closeBrowser();
 
 
}

}