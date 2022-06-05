import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WithdrawlForCustomer extends BasePage {
    private By withdrawlButton = By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]");
    private By confirmButton = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button");
    private By balance = By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]");
    private By amount = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input");
    private By message = By.xpath("/html/body/div/div/div[2]/div/div[4]/div/span");

    public WithdrawlForCustomer(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickWithdrawlButton() {
        getDriver().findElement(withdrawlButton).click();
    }

    public boolean isConfirmButtonDisplayed() {
        return getDriver().findElement(confirmButton).isDisplayed();
    }

    public void amountForWithdrawl(String value) {
        int amount = Integer.parseInt(getDriver().findElement(balance).getText());
        int amountForWithdrawl = Integer.parseInt(value);

        if (amount > amountForWithdrawl) {
            getDriver().findElement(this.amount).sendKeys(value);
            getDriver().findElement(message).getText();
        } else {
            getDriver().findElement(this.amount).sendKeys(value);
            getDriver().findElement(message).getText();
        }
    }

    public void clickConfirmButton() {
        getDriver().findElement(confirmButton).click();
    }

    public String message() {
        return getDriver().findElement(message).getText();
    }
}
