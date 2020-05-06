package regression.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import regression.TestRunner;

public class UserListPage extends basePage{

    @FindBy(how = How.ID, using = "sample_editable_1_new")
    WebElement adduser;

    public void gotoAddCreateUser(){
        adduser.click();
    }
}
