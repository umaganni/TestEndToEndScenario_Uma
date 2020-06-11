import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.*;

import java.util.concurrent.TimeUnit;

public class MyStepdefs  extends TestRunner{

   // WebDriver driver;
    public static WebDriverWait wait;

    HomePage homePage;
    LoginPage loginPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    OrderConfirmationPage orderConfirmationPage;


    @Before
    public void initializeBrowser()
    {
       // wait = new WebDriverWait(driver, 40);
        //driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
    }

    @After
    public void tearDownBrowser(Scenario scenario)
    {
        // if(scenario.isFailed()) {
        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshotBytes, "image/png");
        // }
     // driver.quit();

    }
    @Given("^user is in home page$")
    public void userIsInHomePage()
    {
//        driver.manage().timeouts().implicitlyWait(40, TimeUnit.MILLISECONDS);
        //driver.get("http://twentyconsulting-001-site1.dtempurl.com/");
        homePage.gotoHomePage(driver);
    }

    @When("^user click on login in link$")
    public void userClickOnLoginInLink()
    {
        homePage.clickLoginLink();
    }

    @Then("^user is in login page$")
    public void userIsInLoginPage()
    {
        String actLoginPgtitle = driver.getTitle();
    }

    @When("^user enters email as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void userEntersEmailAsAndPasswordAs(String email, String password) throws Throwable
    {
        loginPage.setEmailAndPassword(email, password);
    }

    @And("^user clicks log in button$")
    public void userClicksLogInButton()
    {
        loginPage.clickLoginBtn();
    }

    @When("^user adds first item into cart$")
    public void userAddsFirstItemIntoCart()
    {
       //driver.manage().timeouts().implicitlyWait(40, TimeUnit.MILLISECONDS);
       homePage.clkOnFirstItemInHmPage();
    }

    @Then("^user should go to cart page$")
    public void userShouldGoToCartPage()
    {
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.MILLISECONDS);

        homePage.clickCartLink();
    }

    @And("^user should checkout from cart$")
    public void userShouldCheckoutFromCart()
    {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);

        cartPage.chkTermsOfService();
        cartPage.clkCheckOut();
    }

    @And("^set new billing address and give details$")
    public void setNewBillingAddressAndGiveDetails()
    {
        checkoutPage.chkShipToSameAddChkBox();

        checkoutPage.selNewBillAddFrmDDList();

        checkoutPage.selNewBillAddrCountry();

        checkoutPage.setNewBillAddrCity();
        checkoutPage.setNewBillAddrAddress1();
        checkoutPage.setNewBillAddrPostCode();
        checkoutPage.setNewBillAddrPhNumb();

        checkoutPage.clkNewBillAddrCntBtn();
    }

    @And("^set default shipping address$")
    public void setDefaultShippingAddress() throws InterruptedException {
       Thread.sleep(2000);

       // driver.manage().timeouts().implicitlyWait(40, TimeUnit.MILLISECONDS);
        checkoutPage.clkDefaultShipAddrCntBtn();
    }

    @And("^set the default shipping method$")
    public void setTheDefaultShippingMethod() throws InterruptedException {
       Thread.sleep(2000);

        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        checkoutPage.clkDefaultShipMethodContBtn();
    }

    @And("^set default payment method$")
    public void setDefaultPaymentMethod() throws InterruptedException {

        Thread.sleep(2000);

       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        checkoutPage.clkDefaultPaymentMethodContBtn();
    }

    @And("^set default payment info$")
    public void setDefaultPaymentInfo() throws InterruptedException {
       Thread.sleep(2000);

        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        checkoutPage.clkDefaultPaymentInfoContBtn();
    }

    @And("^confirm the order$")
    public void confirmTheOrder() throws InterruptedException {
       Thread.sleep(2000);

       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        checkoutPage.clkConfirmOrderBtn();
    }

    @Then("^the order confirmation page with a message \"([^\"]*)\" is seen$")
    public void theOrderConfirmationPageWithAMessageIsSeen(String expOrderConfMsg) throws Throwable
    {
       // driver.manage().timeouts().implicitlyWait(30, TimeUnit.MILLISECONDS);
        Thread.sleep(4000);

        String actualOrderConfMsg = orderConfirmationPage.getConfirmOrderMsgText();

       //System.out.println("----- actualText ------ : "+actualText);

        Assert.assertEquals(expOrderConfMsg,actualOrderConfMsg);
    }
}
