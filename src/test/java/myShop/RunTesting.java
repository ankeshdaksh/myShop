package myShop;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Acer on 10/10/2017.
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".", tags = "@registrationForNewUser", plugin =
        {"pretty", "html:target/shopMy-html-report", "json:target/myShop_report.json"

}
)
public class RunTesting {
}
