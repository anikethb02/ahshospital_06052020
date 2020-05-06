package regression.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class AssignGroupTestPage extends basePage {

    @FindBy(how = How.XPATH, using = "//*[@id=\"sample_editable_1_new\"]")
    WebElement assignGroupTest;

    @FindBy(how = How.XPATH, using = "//div[@class='form-body']//div[1]//div[1]//select[1]")
    WebElement mainTestId;


    @FindBy(how = How.XPATH, using = "//div[2]//div[1]//select[1]")
    WebElement mainTestList;

    @FindBy(how = How.XPATH, using = "//div[3]//div[1]//select[1]")
    WebElement subTestId;

    @FindBy(how = How.XPATH, using = "//button[@class='btn green']")
    WebElement submit;

    public void gotoAssignGroupTestPage(){
        assignGroupTest.click();
    }

public void assignGroupTests(String grouptest, String maintest, String subtest)  {

Select sel1 = new Select(mainTestId);
sel1.selectByVisibleText(grouptest);


Select sel2 = new Select(mainTestList);
sel2.selectByVisibleText(maintest);


Select sel3 = new Select(subTestId);
sel3.selectByVisibleText(subtest);


}

public void submitGrpTests(){
    submit.click();
}

}
