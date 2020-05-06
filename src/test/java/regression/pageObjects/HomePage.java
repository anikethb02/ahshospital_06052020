package regression.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import regression.TestRunner;

public class HomePage extends basePage{

//    class headers

    @FindBy(how = How.LINK_TEXT, using = "MASTERS")
    WebElement mastersLink;

    @FindBy(how = How.LINK_TEXT, using = "Users")
    WebElement usersLink;

    @FindBy(how = How.LINK_TEXT, using =  "Assign Group Test")
    WebElement assignGroupTest;


///end of class header
    //class body---------

    public void gotoUserListPage(){
        mastersLink.click();
        usersLink.click();
    }
    //class body

    public void gotoMasters(){
        mastersLink.click();
    }

    public void gotoAddAssignGroupTest(){
    assignGroupTest.click();

    }



}
