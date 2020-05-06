package regression;

import com.devskiller.jfairy.Fairy;
import cucumber.api.Format;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import regression.pageObjects.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MyStepdefs extends TestRunner {

    public LoginPage loginPage;
    public HomePage homePage;
    public UserListPage userListPage;
    public CreateUserPage userPage;
    public AssignGroupTestPage assignGrpTestPage;
    public AssignGrpTestListPage GrpTestListPage;
    public ReportsPage reportsPage;
    private List<Date> dates;

    @Before
    public void start(){
        loginPage = new LoginPage();
        homePage = new HomePage();
        userListPage = new UserListPage();
        userPage = new CreateUserPage();
        assignGrpTestPage = new AssignGroupTestPage();
        GrpTestListPage = new AssignGrpTestListPage();
        reportsPage = new ReportsPage();
        driver.get("http://ahs.bananaapps.co.uk/");
    }

    @After
    public void stop(Scenario scenario){

        if(!scenario.isFailed()) {
            byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshotBytes, "image/png");
        }

        //else
        //is passed
        //remove
        //negation

    }


    @Given("^admin logged into the portals$")
    public void admin_logged_into_the_portals() throws Throwable {
        loginPage.login("07442382353","Superadmin");
    }




    @When("^he go to user module$")
    public void heGoToUserModule() {
        homePage.gotoUserListPage();
    }

    @And("^created a new user \"([^\"]*)\"$")
    public void createdANewUser(String user) throws Throwable {
        userListPage.gotoAddCreateUser();
        userPage.createUser(user);

    }

    @Then("^the user should be created successfully$")
    public void theUserShouldBeCreatedSuccessfully() {
        Assert.assertTrue(userPage.isUserCreated());
    }

    @Given("^user is in login page$")
    public void userIsInLoginPage() {
        Assert.assertTrue(driver.findElement(By.id("MobileNumber")).isDisplayed());
    }

    @When("^he login with username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void heLoginWithUsernameAndPassword(String username, String password) throws Throwable {
        loginPage.login(username,password);
    }

    @Then("^the login should be successful$")
    public void theLoginShouldBeSuccessful() {
        Assert.assertTrue( driver.findElement(By.linkText("MASTERS")).isDisplayed());
    }


    @Then("^the error message is shown \"([^\"]*)\"$")
    public void theErrorMessageIsShown(String message) throws Throwable {
        Assert.assertEquals(message,driver.findElement(By.cssSelector("div.col-md-6.alert.alert-danger")).getText().replace("\n","").replace("×","").trim());
    }

    @Given("^Super admin logged in$")
    public void superAdminLoggedIn() {
        loginPage.login("07442382353","Superadmin");
    }

    @And("^Navigated to Masters page$")
    public void navigatedToMastersPage() {
        homePage.gotoMasters();
    }

    @And("^Navigated to Assign Group Test$")
    public void navigatedToAssignGroupTest() {
       homePage.gotoAddAssignGroupTest();
    }


    @When("^opens the Add Assign Group Test$")
    public void opensTheAddAssignGroupTest() {
        assignGrpTestPage.gotoAssignGroupTestPage();
    }


    @And("^set Group test as \"([^\"]*)\" Main test as \"([^\"]*)\" Sub test as \"([^\"]*)\"$")
    public void setGroupTestAsMainTestAsSubTestAs(String grouptest, String maintest, String subtest) throws Throwable {
        assignGrpTestPage.assignGroupTests(grouptest, maintest,subtest);

    }

    @And("^Submits the data to create Assign Group Test$")
    public void submitsTheDataToCreateAssignGroupTest() {
    assignGrpTestPage.submitGrpTests();
    }

    @Then("^should be navigating to list of Assign Group Test$")
    public void shouldBeNavigatingToListOfAssignGroupTest() {
        //Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Assign Grouptest List']")).isDisplayed());
        Assert.assertTrue(GrpTestListPage.gotoGrpTestList());
    }


    @When("^search name or number \"([^\"]*)\"  is entered$")
    public void searchNameOrNumberIsEntered(String search) throws Throwable {

        GrpTestListPage.gotosearchoption(search);

    }

    @Then("^results for name or number \"([^\"]*)\" are shown$")
    public void resultsForNameOrNumberAreShown(String dis) throws Throwable {
        Assert.assertTrue(GrpTestListPage.displaySearch(dis));
    }

    @When("^delete button clicked for the result$")
    public void deleteButtonClickedForTheResult() {
        GrpTestListPage.deleteResult();
    }

    @Then("^user should NOT see the corresponding \"([^\"]*)\" result$")
    public void userShouldNOTSeeTheCorrespondingResult(String dis) throws Throwable {
        Assert.assertFalse(GrpTestListPage.displaySearch(dis));
    }

    @And("^Navigated to the reports page\\.$")
    public void navigatedToTheReportsPage() {

    }

    @When("^when i pass start date \"([^\"]*)\" and end date \"([^\"]*)\"$")
    public void whenIPassStartDateAndEndDate(String start, String end) throws Throwable {
      reportsPage.searchDates(start,end);
    }

    @Then("^submit the selected date range$")
    public void submitTheSelectedDateRange() {
    reportsPage.submitSelection();
    }



}
