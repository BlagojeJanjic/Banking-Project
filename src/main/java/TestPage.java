import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import sun.awt.windows.ThemeReader;

import java.time.Duration;

public class TestPage {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private BankManagerLogin bankManagerLogin;
    private AddCustomer addCustomer;
    private NewAccountForCustomer newAccountForCustomer;
    private LoginAsCustomer loginAsCustomer;
    private DepositForCustomer depositForCustomer;
    private WithdrawlForCustomer withdrawlForCustomer;
    private LogoutBankManager logoutBankManager;
    private LogoutCustomer logoutCustomer;


    @BeforeClass
    public void beforeClass() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driverWait = new WebDriverWait(driver, Duration.ofSeconds(15));
        bankManagerLogin = new BankManagerLogin(driver, driverWait);
        addCustomer = new AddCustomer(driver, driverWait);
        newAccountForCustomer = new NewAccountForCustomer(driver, driverWait);
        loginAsCustomer = new LoginAsCustomer(driver, driverWait);
        depositForCustomer = new DepositForCustomer(driver, driverWait);
        withdrawlForCustomer = new WithdrawlForCustomer(driver, driverWait);
        logoutBankManager = new LogoutBankManager(driver, driverWait);
        logoutCustomer = new LogoutCustomer(driver, driverWait);

        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

    }

    @Test (priority = 1)
    public void bankManagerLogin() {
        bankManagerLogin.bankManagerLoginButton();
        Assert.assertTrue(bankManagerLogin.isAddCustomerButtonEnabled());
    }

    @Test (priority = 2)
    public void addCustomer() {
        addCustomer.addCustomer();
        addCustomer.addNewCustomer("Pero", "Ilic", "10000");
        Assert.assertTrue(addCustomer.isAddCustomerButtonEnabled());
        addCustomer.clickAddCustomerButton();
        Assert.assertTrue(addCustomer.confirmation());
        driver.switchTo().alert().accept();
    }

    @Test (priority = 3)
    public void createAccount() {
        Assert.assertTrue(newAccountForCustomer.isOpenAccountButtonEnabled());
        newAccountForCustomer.openAccountPage();
        try {
            Thread.sleep(5000);

            newAccountForCustomer.selectCustomer("Pero Ilic");
            newAccountForCustomer.selectCurrency();
            newAccountForCustomer.clickProcessButton();
            Assert.assertTrue(newAccountForCustomer.confirmation());
            driver.switchTo().alert().accept();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test (priority = 4)
    public void customerLogin() {
        try {
            Thread.sleep(3000);

            loginAsCustomer.clickHomeButton();

            Thread.sleep(3000);

            loginAsCustomer.clickCustomerLoginButton();
            Thread.sleep(3000);

            Assert.assertTrue(loginAsCustomer.isYourNameFieldEnabled());
            loginAsCustomer.selectCustomer();
            Assert.assertTrue(loginAsCustomer.isLoginButtonEnabled());
            loginAsCustomer.clickLoginButton();
            Assert.assertTrue(loginAsCustomer.isLogoutButtonEnabled());
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
    }

    @Test (priority = 5)
    public void depositPayment() {
        try {
            Thread.sleep(3000);

            depositForCustomer.clickDepositButton();

            Thread.sleep(3000);

            Assert.assertTrue(depositForCustomer.isConfirmButtonEnabled());
            depositForCustomer.inputDepositAmount("10000");
            depositForCustomer.confirmDeposit();
            Assert.assertEquals(depositForCustomer.message(), "Deposit Successful");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test (priority = 6)
    public void withdrawl() {
        try {
            Thread.sleep(2000);

            withdrawlForCustomer.clickWithdrawlButton();

            Thread.sleep(2000);

            Assert.assertTrue(withdrawlForCustomer.isConfirmButtonDisplayed());

            withdrawlForCustomer.amountForWithdrawl("100000");
            withdrawlForCustomer.clickConfirmButton();
            Thread.sleep(2000);
            Assert.assertEquals(withdrawlForCustomer.message(), "Transaction Failed. You can not withdraw amount more than the balance.");


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test (priority = 7)
    public void logoutCustomer() {
        logoutCustomer.logoutCustomer();
        Assert.assertTrue(logoutCustomer.isYourNameFieldEnabled());
    }

    @Test (priority = 8)
    public void logoutBankManager() {
        logoutBankManager.logoutForBankManager();
        bankManagerLogin.bankManagerLoginButton();
        Assert.assertTrue(bankManagerLogin.isAddCustomerButtonEnabled());
        logoutBankManager.logoutForBankManager();

    }



    @AfterClass
    public void close() {
        driver.close();
    }
}
