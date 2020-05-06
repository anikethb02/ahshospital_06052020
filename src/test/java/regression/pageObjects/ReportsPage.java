package regression.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ReportsPage extends basePage {

    @FindBy(how= How.XPATH, using = "//li[@id='liReports']//a[1]")
    WebElement reports;

    @FindBy(how = How.ID,using = "FromDate")
    WebElement fromDate;

    @FindBy(how = How.ID,using = "ToDate")
    WebElement toDate;

  @FindBy(how = How.XPATH,using = "//button[@class='button btn green']")
  WebElement submit;


    public void gotoReportsPage(){

        reports.click();
    }


    public void searchDates(String start, String end) {
        fromDate.clear();
        fromDate.sendKeys(start);

        toDate.clear();
        toDate.sendKeys(end);
    }

    public void submitSelection(){
        submit.click();
    }
}
