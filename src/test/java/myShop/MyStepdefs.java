package myShop;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Acer on 10/10/2017.
 */
public class MyStepdefs {
    HomePage homePage = new HomePage();
    AddToCart addToCart = new AddToCart();

    @Given("^I am  on home page$")
    public void iAmOnHomePage() throws Throwable {
        homePage.theUserIsInHomePage();

    }

    @When("^I entered my valid detail for registration$")
    public void iEnteredMyValidDetailForRegistration() throws Throwable {
        homePage.userProvideValidRegistraionDetail();

    }

    @Then("^I am able to register successfully$")
    public void iAmAbleToRegisterSuccessfully() throws Throwable {
        homePage.checkForRegistrationComplete();

    }

    @When("^I enter my existing emails and password$")
    public void iEnterMyExistingEmailsAndPassword() throws Throwable {
        homePage.loginWithExistingEmailId();
    }

    @Then("^I am able to login successfully$")
    public void iAmAbleToLoginSuccessfully() throws Throwable {
        homePage.checkLoginUrl();


    }


    @When("^I enter unregister \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iEnterUnregisterAnd(String arg0, String arg1) throws Throwable {
        homePage.loginWithUnregisterdEmailId(arg0, arg1);

    }

    @Then("^I am unbale to loging and error msg appear \"([^\"]*)\"$")
    public void iAmUnbaleToLogingAndErrorMsgAppear(String arg0) throws Throwable {
        homePage.unregisteredEmailErro(arg0);

    }

    @When("^I am looking product in \"([^\"]*)\"$")
    public void iAmLookingProductIn(String arg0) throws Throwable {
        homePage.lookingProductInProductTab(arg0);

    }

    @And("^select the \"([^\"]*)\"$")
    public void selectThe(String arg0) throws Throwable {
         homePage.selectProductFromSubCategory(arg0);

    }

    @Then("^I can see the\"([^\"]*)\"$")
    public void iCanSeeThe(int itemcount) throws Throwable {
        homePage.countProduct(itemcount);
    }


    @When("^I search the product by \"([^\"]*)\"$")
    public void iSearchTheProductBy(String arg0) throws Throwable {
        homePage.searchProdutByProductName(arg0);

    }

    @Then("^search result equal to \"([^\"]*)\" of product is equal$")
    public void searchResultEqualToOfProductIsEqual(int arg0) throws Throwable {
        homePage.searchResult(arg0);

    }

    @And("^add to the cart$")
    public void addToTheCart(String item) throws Throwable {
        addToCart.addToTheCart(item);
    }

    @Then("^I select the product for the Cart$")
    public void iSelectTheProductForTheCart() throws Throwable {
        addToCart.selectForTheCart();
        addToCart.addToBasket();


    }
}

