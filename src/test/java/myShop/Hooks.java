package myShop;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utils.BrowserFactory;

import java.net.MalformedURLException;

/**
 * Created by Acer on 10/10/2017.
 */
public class Hooks extends BrowserFactory{
    private Scenario scenario;

    @Before
    public static void setUp() throws MalformedURLException {
        BrowserFactory.openBrowser();
    }


    @After
    public void tearDown(Scenario scenario){
        this.scenario = scenario;
        if (scenario.isFailed()){
            BrowserFactory.screenShot(scenario);
            }else {
            BrowserFactory.closeBrowser();
        }

        BrowserFactory.closeBrowser();
    }
}
