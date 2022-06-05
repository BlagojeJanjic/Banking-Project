import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewAccountForCustomer extends BasePage{
    private By openAccountButton = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[2]");
    private By customerField = By.id("userSelect");
    private By currencyField = By.id("currency");
    private By processButton = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");

    public NewAccountForCustomer(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public boolean isOpenAccountButtonEnabled() {
        return getDriver().findElement(openAccountButton).isEnabled();
    }

    public void openAccountPage() {
        getDriver().findElement(this.openAccountButton).click();
    }

    public void selectCustomer(String customer) {
        Select dropdown = new Select(getDriver().findElement(customerField));
        dropdown.selectByVisibleText(customer);
    }

    public void selectCurrency() {
        Select dropdown = new Select(getDriver().findElement(currencyField));
        dropdown.selectByIndex(1);
    }

    public void clickProcessButton() {
        getDriver().findElement(processButton).click();
    }

    public boolean confirmation() {
        if (getDriverWait().until(ExpectedConditions.alertIsPresent()) == null) {
            return false;
        }
        return true;
    }
}
