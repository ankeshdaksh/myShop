package myShop;

import org.openqa.selenium.support.PageFactory;
import utils.BrowserFactory;

/**
 * Created by Acer on 10/10/2017.
 */
public class BasePage extends BrowserFactory{
    BasePage(){
        PageFactory.initElements(driver, this);
    }
}
