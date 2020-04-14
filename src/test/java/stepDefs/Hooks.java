package stepDefs;

import PageFactory.HomePage;
import PageFactory.PracticePage;
import Utilities.AutomationContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import managers.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {
    AutomationContext context;

    public Hooks(AutomationContext context){
        this.context=context;
    }


    @Before
    public void set(Scenario scenario){
        Driver.initializeDriver();
        context.getScenarioManager().setScenario(scenario);
        Driver.getDriver().manage().window().maximize();

    }

    @After
    public void tearDown(){
        Driver.getDriver().quit();
    }

}
