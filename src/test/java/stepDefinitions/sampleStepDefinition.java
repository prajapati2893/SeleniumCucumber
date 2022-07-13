package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class sampleStepDefinition {
    private WebDriver driver;
    @Given("Login page")
    public void open_login_page(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions());
        driver.get("https://the-internet.herokuapp.com/login");
        driver.manage().window().maximize();
    }
    @Then("Enter username and password and login")
    public void login(){
        By username = By.xpath("//input[@id='username']");
        By password = By.xpath("//input[@id='password']");
        By loginButton = By.xpath("//button[@type='submit']");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));

        driver.findElement(username).sendKeys("tomsmith");
        driver.findElement(password).sendKeys("SuperSecretPassword!");
        driver.findElement(loginButton).click();
    }
    @Then("Check for successful login")
    public void check_login_success(){
        By heading = By.xpath("//h2[contains(.,'Secure Area')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(heading));
    }
    @Then("Logout")
    public void logout(){
        By logoutButton = By.xpath("//a/i[contains(.,'Logout')]");
        driver.findElement(logoutButton).click();
    }
    @Then("Check for successful logout")
    public void check_logout_success(){
        By heading = By.xpath("//h2[contains(.,'Login Page')]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.presenceOfElementLocated(heading));

        driver.quit();
    }
}
//https://www.selenium.dev/documentation/webdriver/
//https://www.selenium.dev/selenium/docs/api/java/allclasses-noframe.html
//https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/


