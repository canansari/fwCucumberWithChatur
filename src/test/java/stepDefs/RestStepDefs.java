package stepDefs;

import Utilities.AutomationContext;
import groovyjarjarantlr4.v4.codegen.model.SrcOp;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class RestStepDefs {
    AutomationContext context;

    public RestStepDefs(AutomationContext context){
        this.context=context;
    }

    @Then("^I verify (get|post|put|delete)Service has status (\\d+) on \"(.*)\" with path params \"(.*)\$")
    public void i_validate_rest_service(String method, int statusCode, String url){
        url=context.getContextCache(url);
        RequestSpecification request=given();
        Response response=null;
        switch (method){
            case "get":
                response=request.get(url);
                break;
            case "post":
                response=request.post(url);
                break;
            case "put":
                response=request.put(url);
                break;
            case "delete":
                response=request.delete(url);
                break;
        }
        response.then().assertThat().statusCode(statusCode);
        context.getScenarioManager().getScenario().write("Rest service call completed with status code "+statusCode+ ". Response json:\r\n"+response.asString());
    }
    @Then("^I store parameters in (\\w+) map$")
    public void i_store_map(String key, Map<String , String> params){
        Map<String, String > paramsMap=new HashMap<>();
        for(Map.Entry<String, String > param: params.entrySet()){
            paramsMap.put(param.getKey(), param.getValue());
        }
        context.setCo;

    }

}
