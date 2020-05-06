package regression.pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AssignGrpTestListPage extends basePage {

    @FindBy(how = How.XPATH, using = "//h1[text()='Assign Grouptest List']")
    WebElement GrpTestList;

    @FindBy(how = How.XPATH, using = "//input[@class='form-control input-sm input-small input-inline']")
    WebElement search;

    @FindBy(how = How.XPATH, using = "//tr[1]//td[1]")
    WebElement display;

    @FindBy(how = How.XPATH, using = "//tr[1]//td[5]//a[1]//i[1]")
    WebElement delete;

    public boolean gotoGrpTestList(){
        return GrpTestList.isDisplayed();
    }

    public void gotosearchoption(String search){
       this.search.sendKeys(search);
    }

    public boolean displaySearch(String dis){
        return display.isDisplayed();
    }

    public void deleteResult(){
        delete.click();
        Alert alert = driver.switchTo().alert();
        String  alerttx = alert.getText();
        System.out.println(alerttx);
        alert.accept();

    }

}
