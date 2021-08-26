package step_definitions;


import command_providers.ActOn;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;


public class LoginSteps {
    private static final By FullName = By.id("name");
    private static final By Password = By.id("password");
    private static final By Login = By.id("login");
    private static final By Logout = By.id("logout");
    private static final By InvalidPassword= By.xpath("//*[@id='pageLogin']/form//div[text()='Password is invalid']");
    private static Logger LOGGER = LogManager.getLogger(LoginSteps.class);
    WebDriver driver = Hooks.driver;

    //precondition
    @Given("^a user is on the login page$")
    public void navigateToLogInPage() {
        ActOn.browser(driver).openBrowser("https://example.testproject.io/web/");
        LOGGER.info("a user is in the login page");
    }
    //main action
    //parameterize value
    @When("^user enters username \"(.+?)\" and password \"(.+?)\"$")
    public void enterUserCredentials(String username, String password) {
            ActOn.element(driver, FullName).setValue(username);
            ActOn.element(driver, Password).setValue(password);
            LOGGER.info("user has entered invalid credentials");

        }
        @And("^click on login button$")
    public void clickOnLogin(){
        ActOn.element(driver, Login).click();
        LOGGER.info("user clicked on login button");
    }
    @When("^user click on login button upon entering credentials$")
    public void userClickOnLoginButtonUponEnteringCredentials(DataTable table){
        List<Map<String,String>> data = table.asMaps(String.class,String.class);
        for(Map<String,String> cells:data) {
            ActOn.element(driver, FullName).setValue(cells.get("username"));
            ActOn.element(driver, Password).setValue(cells.get("password"));
            LOGGER.info("user has entered invalid credentials");

            ActOn.element(driver, Login).click();
            LOGGER.info("user clicked on login button");

        }
    }

            //Assertion
            @Then("^user is navigate to home page$")
            public void validateUserIsSuccessfullyLogin () {
                boolean logoutDisplayed = driver.findElement(Logout).isDisplayed();
                Assert.assertTrue("logout button is not displayed", logoutDisplayed);
                LOGGER.info("user is in the home page");

            }
            @Then("^user is failed to login$")
            public void validateUserIsFailedToLogin () {
                boolean invalidPassword = driver.findElement(InvalidPassword).isDisplayed();
                Assert.assertTrue("invalid password is not displayed", invalidPassword);
                LOGGER.info("user still is in the home page");

            }
        }



