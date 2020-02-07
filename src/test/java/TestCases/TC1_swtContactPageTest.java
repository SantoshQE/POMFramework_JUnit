package TestCases;

import Config.TestBase;
import Config.TestResultLoggerExtension;
import Pages.swtContactPage;
import com.aventstack.extentreports.ExtentTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(TestResultLoggerExtension.class)
public class TC1_swtContactPageTest extends TestBase
{
    public static swtContactPage swtContactPg ;
    public static TestBase init ;
    public static TestBase extentTestbase;
    public static ExtentTest test;
    public static ExtentTest parentTest;
    public static ExtentTest childTest;

/*    @BeforeMethod
    public void setup(Method method)
    {
        System.out.println(method);
        String testMethodName = method.getName();
        String descriptiveTestName = method.getAnnotation(Test.class).testName();
        test = ExtentManager.startTest(descriptiveTestName, ExtentManager.getLabel(method.getDeclaringClass().getName()));
    }*/
    @BeforeAll()
    public static void launchBrowser_Chrome()
    {
        System.out.println("Inside @BeforeTest --launchBrowser_Chrome ");
        TestBase.open_Browser("Chrome");
        swtContactPg = new swtContactPage(driver);
        swtContactPg.launchSwtAcademySite("https://www.swtestacademy.com/");
    }
    @Test() @Order(1)
    public void navigateToContactsPage() throws Throwable
    {
        swtContactPg.clickContactsLink();
        System.out.println("inside navigateToContactsPage ... executed");
    }
    @Test() @Order(2)
    public void enterContactDetails() throws Throwable
    {
        swtContactPg.fillContactDetails("TestUser","TestUser@gmail.com","Testsubject","Testmessage");
    }
    @AfterAll() //Teardown steps close the borser
    public static void tearDown_Chrome()
    {
        if(driver!=null)
        {
            driver.close();
        }
    }
}
