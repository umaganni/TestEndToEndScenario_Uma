package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage
{
    //WebDriver driver;
    public OrderConfirmationPage(WebDriver driver)
    {
        //this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//div[@class = 'title']/strong[contains(text(),'Your order has been')]")
    private WebElement confirmOrderMsg;

    public String getConfirmOrderMsgText()
    {
        return confirmOrderMsg.getText();
    }

}
