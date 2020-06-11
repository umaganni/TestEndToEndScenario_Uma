package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
   // WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        //this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.ID, using = "Email")
    private WebElement email;

    @FindBy(how = How.ID, using = "Password")
    private WebElement password;

    @FindBy(how = How.CSS, using = "input.login-button")
    private WebElement loginBtn;

    public void setEmailAndPassword(String emailStr, String pwdStr)
    {
       // System.out.println("--- emailStr ---- :" + emailStr + "---- pwdStr --- :"+pwdStr);
        email.sendKeys(emailStr);
        password.sendKeys(pwdStr);
    }

    public void clickLoginBtn()
    {
        loginBtn.click();
    }

}
