package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class wikiloginPage
{
    WebDriver driver;

    By LoginTab=By.xpath("//*[@id='pt-login']/a");
    By username=By.xpath("//*[@id='wpName1']");
    By password=By.xpath("//*[@id='wpPassword1']");
    By logIn=By.xpath("//*[@id='wpLoginAttempt']");

    public wikiloginPage(WebDriver driver)
    {
        this.driver =driver;
    }
    public void clickLoginTab()
    {
        driver.findElement(LoginTab).click();
    }
    public void typeUserName()
    {
        driver.findElement(username).sendKeys("santoshwiki1983");
    }
    public void typePassword()
    {
        driver.findElement(password).sendKeys("Tcs@1983");
    }
    public void clickLoginButton()
    {
        driver.findElement(logIn).click();
    }

}
