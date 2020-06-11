package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
   // WebDriver driver;
    public HomePage(WebDriver driver)
    {
        //this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(how = How.LINK_TEXT, using = "Log in")
    private WebElement loginLink;

    @FindBy(how = How.XPATH, using = "(//input[@class='button-2 product-box-add-to-cart-button'])[1]")
    private WebElement firstItemHmPage;

    @FindBy(how = How.CSS, using = "span.cart-label")
    private WebElement shoppingCartLink;

    public void gotoHomePage(WebDriver driver){
        driver.get("http://twentyconsulting-001-site1.dtempurl.com/");
    }

    public void clickLoginLink()
    {
        loginLink.click();
    }
    public void clkOnFirstItemInHmPage()
    {
        firstItemHmPage.click();
    }
    public void clickCartLink()
    {
        shoppingCartLink.click();
    }
}
