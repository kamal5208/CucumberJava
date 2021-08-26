package page_objects;

import command_providers.ActOn;
import command_providers.AssertThat;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home extends NavigationBar {
    private static final Logger LOGGER = LogManager.getLogger(NavigationBar.class);


    private final By HomeValue = By.id("homeval");
    private final  By DownPayment =By.id("downpayment");
    private final By DownPaymentByDollar=By.xpath("//*[@id='calc']//input[@name ='param[downpayment_type]'][@value='money']");
    private final By LoanAmount = By.id("loanamt");
    private final By InterestRate = By.id("intrstsrate");
    private final By LoanTerm = By.id("loanterm");
    private final By StartDateMonth =By.name("param[start_month]");
    private final By StartDateYear = By.id("start_year");
    private final By PropertyTax = By.id("pptytax");
    private final By Pmi = By.id("pmi");
    private final By Hoi = By.id("hoi");
    private final By Hoa = By.id("hoa");
    private final By LoanType = By.name("param[milserve]");
    private final By LoanTypeBuy = By.name("param[refiorbuy]");
    private final By Calculate =By.name("cal");

    public Home(WebDriver driver){
        super(driver);
    }


    //Enter Home Value
    public Home typeHomePrice(String value){
        LOGGER.debug("Entered Home price is:" + value);
        ActOn.element(driver,HomeValue).setValue(value);
        return this;
    }
    //Enter down payment "60000"
    public Home typeDownPayment(String value){
        LOGGER.debug("Entered down payment is:"  + value);
        ActOn.wait(driver, DownPayment).waitForElementToBeVisible();
        ActOn.element(driver,DownPayment).setValue(value);
        return this;

    }
    //Click on $ radio Button
    public Home clickDownPaymentByDollar(){
        LOGGER.debug("Click on the Down Payment in Dollar");
        ActOn.element(driver,DownPaymentByDollar).click();
        return this;
    }
    //Enter loan amount
    public Home typeLoanAmount(String value){
        LOGGER.debug("Entered loan amount is:" + value);
        ActOn.element(driver,LoanAmount).setValue(value);
        return this;
    }
    //Enter interest rate
    public Home typeInterestRate(String value){
        LOGGER.debug("Entered interest rate is:" + value);
        ActOn.element(driver, InterestRate).setValue(value);
        return this;
    }
    public Home typeLoanTermInYear(String value){
        ActOn.element(driver, LoanTerm).setValue(value);
        return this;

    }
    public Home selectMonth(String month){
        ActOn.element(driver, StartDateMonth).selectValue(month);
        return this;
    }
    public Home selectYear(String year){
        ActOn.element(driver, StartDateYear).setValue(year);
        return this;
    }
    public Home typePropertyTax(String value){
        ActOn.element(driver, PropertyTax).setValue(value);
        return this;
    }
    public Home typePmi(String value){
        ActOn.element(driver, Pmi).setValue(value);
        return this;
    }
    public Home typeHoi(String value){
        ActOn.element(driver, Hoi).setValue(value);
        return this;
    }
    public Home typeHOA(String value){
        ActOn.element(driver, Hoa).setValue(value);
        return this;
    }
    //Select loan type
    public Home selectLoanType (String value){
        ActOn.element(driver, LoanType).selectValue("FHA");
        return this;
    }
    //Select "Buy" from Buy or Refi dropdown
    public Home selectBuyOrRefi(String value){
        ActOn.element(driver,LoanTypeBuy).selectValue(value);
        return this;
    }
    //Click on Calculate button
    public Home clickCalculateButton(){
        ActOn.element(driver, Calculate).click();
        return this;
    }
    //  Validate that total monthly payment is accurate
     public Home validateMonthlyPayment(String totalMonthlyPayment){
        By monthlyPaymentLocator = By.xpath("//*[@id='calc']//h3[text()='"+ totalMonthlyPayment +"']");
         AssertThat.elementAssertions(driver,monthlyPaymentLocator).elementExist();
         return this;
    }
}
