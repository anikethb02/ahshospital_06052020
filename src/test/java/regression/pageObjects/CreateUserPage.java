package regression.pageObjects;

import com.devskiller.jfairy.Fairy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import regression.TestRunner;

public class CreateUserPage extends basePage  {


    @FindBy(how = How.ID, using = "UserName")
    WebElement username;

    @FindBy(how = How.ID, using = "MobileNumber")
    WebElement mobilenumber;

   @FindBy(how = How.ID, using = "EmailID")
    WebElement emailid;

    @FindBy(how = How.ID, using = "Password")
    WebElement password;

    @FindBy(how = How.ID, using = "UserType")
   WebElement usertype;

    @FindBy(how = How.ID, using = "BranchID")
    WebElement branchid;

    @FindBy(how = How.XPATH, using = "//button[text()='Submit']")
    WebElement submit;

    @FindBy(how = How.XPATH, using = "//h1[text()='User Details']")
    WebElement userdetails;


    public void createUser(String user){
        username.sendKeys("Test user");

        String mobile = Fairy.create().person().getTelephoneNumber();
        mobilenumber.sendKeys(mobile);

        String email = Fairy.create().person().getEmail();
        emailid.sendKeys(email);

        password.sendKeys("testuser");

        Select select = new Select(usertype);
        select.selectByVisibleText(user);

        Select select1 = new Select(branchid);
        select1.selectByVisibleText("Visakhapatnam");

        submit.click();
    }

    public boolean isUserCreated(){
        return userdetails.isDisplayed();
    }

}
