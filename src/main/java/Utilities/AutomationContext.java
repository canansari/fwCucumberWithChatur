package Utilities;

import managers.PageObjectMgr;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class AutomationContext {
    PageObjectMgr pageObjectMgr;
    ScenarioManager scenarioManager;
    ConfigFileReader configFileReader;

    private Map<String, String> contextCache=new HashMap<>();
    private HashMap<String, HashMap<String ,String>> cacheParamMap=new HashMap<>();

    public HashMap<String, HashMap<String, String>> getCacheParamMap() {
        return cacheParamMap;
    }

    public void setCacheParamMap(HashMap<String, HashMap<String, String>> cacheParamMap) {
        this.cacheParamMap.put(key, paramsMap);
    }



    public AutomationContext(ScenarioManager scenarioManager){
        pageObjectMgr =new PageObjectMgr();
        this.scenarioManager=scenarioManager;
        configFileReader = new ConfigFileReader(System.getProperty("region"));
    }

    public PageObjectMgr getPageObjectMgr(){
        return pageObjectMgr;
    }

    public ScenarioManager getScenarioManager(){
        return scenarioManager;
    }

    public String getContextCache(String key) {
        if(StringUtils.isBlank(key)){
            return key;
        }
        String value=contextCache.get(key);
        if(value !=null){
            return value;
        }
        value=System.getProperty(key);
        if(value !=null){
            return value;
        }
        value=configFileReader.getPropertyValue(key);
        if(value !=null){
            return value;
        }
        return key;

    }

    public void setContextCache(String key, String value) {
        contextCache.put(key, value);
    }

    public ConfigFileReader getConfigFileReader(){
        return configFileReader;
    }


}
