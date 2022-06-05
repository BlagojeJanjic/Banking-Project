import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAsCustomer extends BasePage{
    private By customerLogin = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button");
    private By yourNameField = By.id("userSelect");
    private By loginButton = By.xpath("/html/body/div/div/div[2]/div/form/button");
    private By logoutButton = By.xpath("/html/body/div/div/div[1]/button[2]");
    private By homeButton = By.xpath("/html/body/div/div/div[1]/button[1]");

    public LoginAsCustomer(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clickHomeButton() {
        getDriver().findElement(homeButton).click();
    }

    public void clickCustomerLoginButton() {
        getDriver().findElement(customerLogin).click();
    }

    public boolean isYourNameFieldEnabled() {
        return getDriver().findElement(yourNameField).isEnabled();
    }

    public void selectCustomer() {
        Select dropdown = new Select(getDriver().findElement(yourNameField));
        dropdown.selectByIndex(1);
    }

    public boolean isLoginButtonEnabled() {
        return getDriver().findElement(loginButton).isEnabled();
    }

    public void clickLoginButton() {
        getDriver().findElement(loginButton).click();
    }

    public boolean isLogoutButtonEnabled() {
        return getDriver().findElement(logoutButton).isEnabled();
    }


}
