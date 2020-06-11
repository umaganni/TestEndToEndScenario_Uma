package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage
{
   // WebDriver driver;
    public CartPage(WebDriver driver)
    {
        //this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "termsofservice")
    private WebElement termsOfServiceChkBox;

    @FindBy(how = How.ID, using = "checkout")
    private WebElement checkOutBtn;

    public void chkTermsOfService()
    {
        termsOfServiceChkBox.click();
    }
    public void clkCheckOut()
    {
        checkOutBtn.click();
    }

}
