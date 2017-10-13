package myShop;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Acer on 13/10/2017.
 */
public class AddToCart extends BasePage{
    HomePage homePage = new HomePage();

    @FindBy(xpath = "//a[@class='product_img_link'] //img[@title='Blouse']")
    WebElement webItemname;
    @FindBy(xpath = "//p[@id='add_to_cart'] //button[@class='exclusive']")
    WebElement addCartButton;

    public void addToTheCart(String itemName){
        searchProductByName(itemName);
    }

    private void searchProductByName(String itemName){
        WebElement productName = driver.findElement(By.linkText(itemName));
        String productText = productName.getText();
        homePage.searchBox.sendKeys(itemName);
        homePage.searchButton.click();
        Assert.assertEquals(itemName, productText);
    }
    public void selectForTheCart(){
        webItemname.click();

    }
    public void addToBasket(){
        addCartButton.click();
    }

}
