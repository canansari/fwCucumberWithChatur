package stepDefs;

import PageFactory.HomePage;
import PageFactory.PracticePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {


    @Before
    public void set(){
        Driver.getDriver().manage().window().maximize();

    }

    @After
    public void tearDown(){
        Driver.getDriver().quit();
    }

}
