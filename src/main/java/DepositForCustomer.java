import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DepositForCustomer extends BasePage{
    private By depositButton = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]");
    private By confirmButton = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");
    private By amount = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By message = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span");
    public DepositForCustomer(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickDepositButton() {
        getDriver().findElement(depositButton).click();
    }

    public boolean isConfirmButtonEnabled() {
        return getDriver().findElement(confirmButton).isEnabled();
    }

    public void inputDepositAmount(String value) {
        getDriver().findElement(amount).sendKeys(value);
    }

    public void confirmDeposit() {
        getDriver().findElement(confirmButton).click();
    }

    public String message() {
        return getDriver().findElement(message).getText();
    }
}
