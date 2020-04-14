package stepDefs;

import Utilities.AutomationContext;
import Utilities.WebElementMgr;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ValidationStepDefs {

    AutomationContext context;

    public ValidationStepDefs(AutomationContext context){
        this.context=context;
    }

    @Then("^I validate (\\w+) is displayed$")
    public void i_validate_displayed(String elementNm) throws Exception{
        WebElement displayElement= (WebElement) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), elementNm);
        if (!displayElement.isDisplayed()){
            context.getScenarioManager().getScenario().write(elementNm+" not displayed");
        } else context.getScenarioManager().getScenario().write(elementNm+" displayed");
        throw new Exception(elementNm + " displayed");
    }

    /**
     * Step to validate element's attribute value with expected
     * @param elementNm
     * @param attributeNm
     * @param expectedValue
     */
    @Then("^I validate (\\w+) (\\w+) is \"([^\"]*)\"$")
    public void i_validate_attribute(String elementNm, String attributeNm, String expectedValue)throws Exception{
        WebElement attrElement= (WebElement) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), elementNm);
        String actualValue=attrElement.getAttribute(attributeNm);
        if(!actualValue.equals(expectedValue)){
            context.getScenarioManager().getScenario().write(expectedValue + " not found on page. Found "+actualValue);
            throw new Exception(expectedValue + " not found on page. Found " + actualValue );
        }
    }
    @Then("^I validate (\\w+) is (enabled|disabled)$")
    public void i_validate_enable_disable(String elementNm, String state)throws Exception {
        WebElement stateElement=(WebElement) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), elementNm);
        boolean stateBool=state.equalsIgnoreCase("enabled");
        if(stateElement.isEnabled()==stateBool){
            context.getScenarioManager().getScenario().write("pass: "+elementNm+"button is: "+stateBool);
        }else{
            context.getScenarioManager().getScenario().write("Fail: "+elementNm+"button is: "+stateBool);
            throw new Exception("Fail: "+elementNm+"button is: "+stateBool);
        }
    }
    @Then("^I validate (\\w+) has (\\w+) elements and print (\\w+)$")
    public void i_validate_list(String  elementNm, int count, String attr)throws Exception{
        List<WebElement> listElement= (List<WebElement>) WebElementMgr.getWebElement(context.getPageObjectMgr().getCurrentPage(), elementNm);
        if(listElement.size()==count){
            context.getScenarioManager().getScenario().write("Pass: There are "+count+" " +elementNm);
            for (WebElement we:listElement) System.out.println(we.getAttribute(attr));
        }else{
            context.getScenarioManager().getScenario().write("Fail: There are "+listElement+" " +elementNm);
            for(WebElement we:listElement) context.getScenarioManager().getScenario().write(we.getAttribute(attr));
            throw new Exception("Fail: There are "+listElement+" " +elementNm);

        }

    }

}