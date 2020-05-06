package regression.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import regression.TestRunner;

public class LoginPage extends basePage {

    @FindBy(how = How.ID, using = "MobileNumber")
    WebElement mobilenumber;

    @FindBy(how = How.ID, using = "Password")
    WebElement pass;

    @FindBy(how = How.CLASS_NAME, using = "chic-button")
    WebElement button;


    public void login(String username,String password) {
        mobilenumber.sendKeys(username);
        pass.sendKeys(password);
        button.click();
    }
}
