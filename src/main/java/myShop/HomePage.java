package myShop;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

/**
 * Created by Acer on 10/10/2017.
 */
public class HomePage extends BasePage {
    String title;
    static String currentUrl;
    static String email;
    static String password;
    static String loginUrl;
    static int productCounts;


    @FindBy(css = "[Class='login']")
    WebElement gotoSignBtn;
    @FindBy(css = "[id='email_create']")
    WebElement enterEmailId;
    @FindBy(css = "[id='SubmitCreate']")
    WebElement createAnAccountBtn;
    @FindBy(css = "[id='id_gender1']")
    WebElement titleGender;
    @FindBy(css = "[id='customer_firstname']")
    WebElement firstName;
    @FindBy(css = "[id='customer_lastname']")
    WebElement lastName;
    @FindBy(css = "[id='passwd']")
    WebElement enterPassword;
    @FindBy(css = "[name='days']")
    WebElement dayDropDown;
    @FindBy(css = "[id='months']")
    WebElement monthDropDown;
    @FindBy(css = "[id='years']")
    WebElement yearDropDown;
    @FindBy(id = "phone")
    WebElement enterPhoneNo;
    @FindBy(id = "address1")
    WebElement enterAddressOne;
    @FindBy(id = "address2")
    WebElement enterAddressTwo;
    @FindBy(id = "city")
    WebElement enterCity;
    @FindBy(id = "id_state")
    WebElement stateDropDown;
    @FindBy(id = "postcode")
    WebElement enterPostCode;
    @FindBy(id = "id_country")
    WebElement enterCountryName;
    @FindBy(id = "submitAccount")
    WebElement enterOnRegisterBtn;
    @FindBy(css = "body")
    WebElement registrationCompleteWelmcomeMsg;
    @FindBy(css = "[id='email']")
    WebElement enterExitingEmail;
    @FindBy(css = "[id='passwd']")
    WebElement enterExitingPwd;
    @FindBy(css = "[id='SubmitLogin']")
    WebElement submitBtn;
    //how to select below mention locator
    @FindBy(css = ".alert.alert-danger>ol>li")
    WebElement unregisterEmailError;
   @FindBy(css = "[id='search_query_top']")
   WebElement searchBox;
   @FindBy(css = "[name='submit_search']")
   WebElement searchButton;


    public void theUserIsInHomePage() {
        checkTitle();
        checkUrl();

    }

    private void checkUrl() {
        currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, "http://automationpractice.com/index.php");
        System.out.println("HomePage Url is....." + currentUrl);

    }

    private void checkTitle() {
        title = driver.getTitle();
        Assert.assertTrue(title.contains("My Store"));
        System.out.println("Title Name is...." + title);
    }

    public void userProvideValidRegistraionDetail() {
        navigateToSignBtn();
        provideRegistraionDetails();
    }

    public void checkForRegistrationComplete() {
        checkRegistrationCompleteText("MY ACCOUNT");

    }

    private void checkRegistrationCompleteText(String welcomeMsg) {
        registrationCompleteWelmcomeMsg.getText();
        Assert.assertTrue(welcomeMsg.contains("MY ACCOUNT"));


    }

    private void navigateToSignBtn() {
        gotoSignBtn.click();
    }

    private void provideRegistraionDetails() {
        email = (new Random().nextInt() + "daksh@hotmail.com");
        enterEmailId.sendKeys(email);
        createAnAccountBtn.click();
        titleGender.click();
        firstName.sendKeys("daksh");
        lastName.sendKeys("kaialsh");
        password = "pass123";
        enterPassword.sendKeys(password);
        dayDropDown.sendKeys("30");
        monthDropDown.sendKeys("January");
        yearDropDown.sendKeys("1980");
        enterAddressOne.sendKeys("aaaaaa");
        enterAddressTwo.sendKeys("bbbbbb");
        enterCity.sendKeys("New York");
        enterPhoneNo.sendKeys("9999999999");
        Select state = new Select(stateDropDown);
        state.selectByVisibleText("Alaska");
        enterPostCode.sendKeys("00000");
        enterCountryName.sendKeys("United Kingdome");
        enterOnRegisterBtn.click();
    }

    public void loginWithExistingEmailId() {
        gotoSignBtn.click();
        enterExistingEmail();
        enterExistingPassword();

    }

    public void checkLoginUrl() {
        checkLoginCurrentUrl();
        loginUrl = driver.getCurrentUrl();
        Assert.assertEquals(loginUrl, "http://automationpractice.com/index.php?controller=my-account");

    }

    private void checkLoginCurrentUrl() {

    }

    private void enterExistingPassword() {
        enterExitingPwd.sendKeys("pass123");
        submitBtn.click();
    }

    private void enterExistingEmail() {
        enterExitingEmail.sendKeys("1604496446daksh@hotmail.com");

    }

    public void loginWithUnregisterdEmailId(String loginIds, String passwd) {
        gotoSignBtn.click();
        enterExitingEmail.sendKeys(loginIds);
        enterExitingPwd.sendKeys(passwd);
        submitBtn.click();

    }

    public void unregisteredEmailErro(String msg) {
        eailError("Authentication failed.");
    }

    private void eailError(String msg) {
        unregisterEmailError.getText();
        System.out.println("Unregistered Email Id Error Msg....." + unregisterEmailError.getText());
        Assert.assertEquals(msg, "Authentication failed.");
    }

    public void lookingProductInProductTab(String productTab) {
        productTabs(productTab);

    }

    private void productTabs(String productTab) {
        WebElement product = driver.findElement(By.linkText(productTab));
        product.click();
    }

    public void selectProductFromSubCategory(String productCategory) {
        productCategories(productCategory);

    }

    private void productCategories(String productCategory) {
        WebElement subCategory = driver.findElement(By.linkText(productCategory));
        subCategory.click();

    }

    public void countProduct(int count) {
        productCount(count);
    }

    private void productCount(int productCount) {
        List<WebElement> products = driver.findElements(By.cssSelector(".product_list.row.grid >li"));
        productCounts = products.size();
        System.out.println("number of product..." + productCounts);
        Assert.assertEquals(productCount, productCounts);
        }

    public void searchProdutByProductName(String productName){
        searchProduct(productName);
    }

    private void searchProduct(String productName) {
        searchBox.clear();
        searchBox.sendKeys(productName);
        searchButton.click();

    }
    public void searchResult(int count){
        searchResuts(count);
    }

    private void searchResuts(int count) {
       List<WebElement> items = driver.findElements(By.cssSelector(".product_list.row.grid >li"));
       int itemCount = items.size();
       Assert.assertEquals(count,itemCount);

    }


}











