package Pages;

import Config.TestBase;
import ObjectRepository.SWTestAcademy_OR;
import Utils.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class swtContactPage
{
    public static WebDriver driver;

    //@BeforeTest

    public void setUp()
    {
       TestBase t = new TestBase();
    }
    public swtContactPage(WebDriver driver)
    {
        TestBase t = new TestBase();
        this.driver = t.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath =  SWTestAcademy_OR.SWT_ContactLink )
    public WebElement  SWT_ContactLink;
    @FindBy(xpath =  SWTestAcademy_OR.SWT_Contact_Name_txt )
    public WebElement  SWT_Contact_Name_txt;
    @FindBy(xpath =  SWTestAcademy_OR.SWT_Contact_Email_txt )
    public WebElement  SWT_Contact_Email_txt;
    @FindBy(name =  SWTestAcademy_OR.SWT_Contact_Subject_txt )
    public WebElement  SWT_Contact_Subject_txt;
    @FindBy(xpath =  SWTestAcademy_OR.SWT_Contact_Message_txt )
    public WebElement  SWT_Contact_Message_txt;
    @FindBy(xpath =  SWTestAcademy_OR.SWT_Contact_Submit_btn )
    public WebElement  SWT_Contact_Submit_btn;

   public void launchSwtAcademySite(String url)
    {
        driver.navigate().to(url);
    }
    public void clickContactsLink()
    {
        SWT_ContactLink.click();
    }
    public void fillContactDetails(String name,String email,String subject,String message)
    {
        SWT_Contact_Name_txt.sendKeys(name);
        SWT_Contact_Email_txt.sendKeys(email);
        SWT_Contact_Subject_txt.sendKeys(subject);
        SWT_Contact_Message_txt.sendKeys(message);
      //  SWT_Contact_Submit_btn.click();

    }

}
