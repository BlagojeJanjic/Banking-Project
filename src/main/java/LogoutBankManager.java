import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LogoutBankManager extends BasePage{
    private By logoutButton = By.xpath("/html/body/div/div/div[1]/button[1]");

    public LogoutBankManager(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void logoutForBankManager() {
        getDriver().findElement(logoutButton).click();
    }
}
