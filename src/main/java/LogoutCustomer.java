import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutCustomer extends BasePage{
    private By logoutButton = By.xpath("/html/body/div/div/div[1]/button[2]");
    private By yourNameField = By.id("userSelect");

    public LogoutCustomer(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void logoutCustomer() {
        getDriver().findElement(logoutButton).click();
    }

    public boolean isYourNameFieldEnabled() {
        return getDriver().findElement(yourNameField).isEnabled();
    }
}
