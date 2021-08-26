package page_objects;

import command_providers.ActOn;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar {
    private final By MortgageCalculatorLogo = By.xpath("//a/img[@alt ='Logo']");
    private final By RatesLink = By.linkText("Rates");
    private final By RealAprLink = By.linkText("Real APR");

    public WebDriver driver;

    public NavigationBar(WebDriver driver){
        this.driver = driver;

    }
    //Mouse hover to the rates link
    public NavigationBar mouseHoverToRates(){
        ActOn.element(driver,RatesLink).mouseHover();
        return this;
    }
    //Click on RealApr link
    public RealApr navigateToRealApr(){
        ActOn.element(driver,RealAprLink).click();
        return new RealApr(driver);
    }
    //Navigate to Home page
    public Home navigateToHome(){
        ActOn.element(driver,MortgageCalculatorLogo).click();
        return new Home(driver);

    }
}
