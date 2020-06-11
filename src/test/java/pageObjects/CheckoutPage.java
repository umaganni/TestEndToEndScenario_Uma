package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage
{
    //WebDriver driver;
    public CheckoutPage(WebDriver driver)
    {
       // this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.ID, using = "ShipToSameAddress")
    private WebElement shipToSameAddChkBox;

    @FindBy(how = How.NAME, using = "billing_address_id")
    private WebElement newBillingAddDDList;

    @FindBy(how = How.ID, using = "BillingNewAddress_CountryId")
    private WebElement newBillAddrCountryDDList;

    @FindBy(how = How.ID, using = "BillingNewAddress_City")
    private WebElement newBillAddrCity;

    @FindBy(how = How.ID, using = "BillingNewAddress_Address1")
    private WebElement newBillAddrAddress1;

    @FindBy(how = How.ID, using = "BillingNewAddress_ZipPostalCode")
    private WebElement newBillAddrPostCode;

    @FindBy(how = How.ID, using = "BillingNewAddress_PhoneNumber")
    private WebElement newBillAddrPhNumb;

    @FindBy(how = How.XPATH, using = "//div[@id = 'billing-buttons-container']/input")
    private WebElement NewBillAddrCntBtn;

    @FindBy(how = How.XPATH, using = "//div[@id = 'shipping-buttons-container']/input")
    private WebElement defaultShipAddContinueBtn;

    @FindBy(how = How.XPATH, using = "//div[@id = 'shipping-method-buttons-container']/input")
    private WebElement defaultShipMethodContBtn;

    @FindBy(how = How.XPATH, using = "//div[@id = 'payment-method-buttons-container']/input")
    private WebElement defaultPaymentMethodContBtn;

    @FindBy(how = How.XPATH, using = "//div[@id = 'payment-info-buttons-container']/input")
    private WebElement defaultPaymentInfoContBtn;

    @FindBy(how = How.XPATH, using = "//div[@id = 'confirm-order-buttons-container']/input")
    private WebElement confirmOrderBtn;


    public void chkShipToSameAddChkBox()
    {
        shipToSameAddChkBox.click();
    }

    public void selNewBillAddFrmDDList()
    {
        Select selNewAddress = new Select(newBillingAddDDList);
        selNewAddress.selectByVisibleText("New Address");
    }

    public void selNewBillAddrCountry()
    {
        Select selCountry = new Select(newBillAddrCountryDDList);
        selCountry.selectByVisibleText("United Kingdom");
    }

    public void setNewBillAddrCity()
    {
        newBillAddrCity.sendKeys("London");
    }
    public void setNewBillAddrAddress1()
    {
        newBillAddrAddress1.sendKeys("Patria Close");
    }
    public void setNewBillAddrPostCode()
    {
        newBillAddrPostCode.sendKeys("IG112NP");
    }
    public void setNewBillAddrPhNumb()
    {
        newBillAddrPhNumb.sendKeys("07589564326");
    }
    public void clkNewBillAddrCntBtn()
    {
        NewBillAddrCntBtn.click();
    }
    public void clkDefaultShipAddrCntBtn()
    {
        defaultShipAddContinueBtn.click();
    }
    public void clkDefaultShipMethodContBtn()
    {
        defaultShipMethodContBtn.click();
    }
    public void clkDefaultPaymentMethodContBtn()
    {
        defaultPaymentMethodContBtn.click();
    }
    public void clkDefaultPaymentInfoContBtn()
    {
        defaultPaymentInfoContBtn.click();
    }
    public void clkConfirmOrderBtn()
    {
        confirmOrderBtn.click();
    }

}
