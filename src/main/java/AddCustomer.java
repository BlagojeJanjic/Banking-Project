import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddCustomer extends BasePage {
    private By addCustomer = By.xpath("/html/body/div/div/div[2]/div/div[1]/button[1]");
    private By firstName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[1]/input");
    private By lastName = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[2]/input");
    private By postCode = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/div[3]/input");
    private By createCustomerButton = By.xpath("/html/body/div/div/div[2]/div/div[2]/div/div/form/button");

    public AddCustomer(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void addCustomer() {
        getDriver().findElement(this.addCustomer).click();
    }

    public void enterFirstName(String firstName) {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(this.firstName));
        getDriver().findElement(this.firstName).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(this.lastName));
        getDriver().findElement(this.lastName).sendKeys(lastName);
    }

    public void enterPostCode(String postCode) {
        getDriverWait().until(ExpectedConditions.elementToBeClickable(this.postCode));
        getDriver().findElement(this.postCode).sendKeys(postCode);
    }

    public void addNewCustomer(String firstName, String lastName, String postCode) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterPostCode(postCode);
    }

    public boolean isAddCustomerButtonEnabled() {
        return getDriver().findElement(createCustomerButton).isEnabled();
    }

    public void clickAddCustomerButton() {
        getDriver().findElement(createCustomerButton).click();
    }

    public boolean confirmation() {
        if(getDriverWait().until(ExpectedConditions.alertIsPresent()) == null) {
            return false;
        }
        return true;
    }
}
