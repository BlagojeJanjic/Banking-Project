import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankManagerLogin extends BasePage {
    private By bankManagerLogin = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[2]/button");
    private By addCustomerButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");

    public BankManagerLogin(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void bankManagerLoginButton() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(bankManagerLogin));
        getDriver().findElement(bankManagerLogin).click();
    }

    public boolean isAddCustomerButtonEnabled() {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(addCustomerButton));
        return getDriver().findElement(addCustomerButton).isEnabled();
    }

}
