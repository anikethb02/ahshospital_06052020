package regression.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import regression.BrowserFactory;
import regression.TestRunner;

public class basePage {

    WebDriver driver;

    public basePage(){
        driver = BrowserFactory.getDriver();
        PageFactory.initElements(driver,this);
    }
}
