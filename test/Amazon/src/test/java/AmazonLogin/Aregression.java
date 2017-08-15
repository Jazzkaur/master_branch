package AmazonLogin;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Aregression
{
    WebDriver driver;

    @Before
    public void start() {
        System.setProperty("web.chrome.driver", "chromedriver.exe");// this works for both windows and mac
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");// this works for both windows and mac
        // System.setProperty("webdriver.chrome.driver", "chromedriver");

        driver = new ChromeDriver();

        driver.get("https://www.amazon.co.uk");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    @Given("^User can go to home page$")
    public void User_can_go_to_home_page() throws Throwable {
        checkTitle();
    }

    @After
    public void end() {
        driver.quit();
    }

    public void checkTitle() {
        String title = driver.getTitle();
        System.out.println(title);
        Assert.assertTrue(title.equals("welcome"));

    }


    @When("^user navigate to login page$")
    public void userNavigateToLoginPage() throws Throwable {
        driver.findElement(By.className("Login")).click();


    }



    @Then("^a welcome message is displayed$")
    public void aWelcomeMessageIsDisplayed() throws Throwable
    {
        driver.findElement(By.linkText("Login successfully"));
    }

    @And("^the logout link is displayed$")
    public void theLogoutLinkIsDisplayed() throws Throwable {
        String actualtext;
        actualtext=driver.findElement(By.xpath("/body")).getText();
        String expected = "Logout";
        Assert.assertEquals(actualtext,expected);

    }
}
