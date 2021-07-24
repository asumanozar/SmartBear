package com.step_definitions;

import com.pages.LoginPage;
import com.pages.OrderPage;
import com.utilities.ConfigurationReader;
import com.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SmartBear_StepDefinitions {

    OrderPage orderPage = new OrderPage();
    LoginPage loginPage = new LoginPage();


    @When("User is on the SmartBear login page")
    public void user_is_on_the_smart_bear_login_page() {
       String url = ConfigurationReader.getProperty("smartBearUrl");
        Driver.getDriver().get(url);

    }
    @When("User successfully logs in")
    public void user_successfully_logs_in() {
        loginPage.username.sendKeys("Tester");
        loginPage.password.sendKeys("test");
        loginPage.signIn.click();


    }
    @When("User navigates to the Order Page")
    public void user_navigates_to_the_order_page() {

        loginPage.order.click();

    }
    @When("User selects {string} from product dropdown")
    public void user_selects_from_product_dropdown(String product) {

       Select select = new Select(orderPage.productDropdown);
       select.selectByVisibleText(product);


    }
    @When("User enters {string} to quantity")
    public void user_enters_to_quantity(String quantity) {

        orderPage.quantityDropdown.sendKeys(quantity);

    }
    @When("User enters {string} to costumer name")
    public void user_enters_to_costumer_name(String name) {

        orderPage.customer.sendKeys(name);

    }
    @When("User enters {string} to street")
    public void user_enters_to_street(String streetName) {

        orderPage.street.sendKeys(streetName);

    }
    @When("User enters {string} to city")
    public void user_enters_to_city(String cityName) {

        orderPage.city.sendKeys(cityName);

    }
    @When("User enters {string} to state")
    public void user_enters_to_state(String stateName) {

        orderPage.state.sendKeys(stateName);

    }
    @When("User enters {string}")
    public void user_enters(String zip) {

        orderPage.zipCode.sendKeys(zip);

    }
    @When("User selects {string} as card type")
    public void user_selects_as_card_type(String cardType) {

        switch (cardType.toLowerCase()) {
            case "visa" :
                orderPage.visa.click();
                break;
            case "mastercard" :
                orderPage.masterCard.click();
                break;
            case "american express" :
                orderPage.americanExpress.click();
                break;
        }
    }
    @When("User enters {string} to card number")
    public void user_enters_to_card_number(String cardNumber) {

        orderPage.cardNum.sendKeys(cardNumber);


    }
    @When("User enters {string} to expiration date")
    public void user_enters_to_expiration_date(String expDate) {

        orderPage.expiration.sendKeys(expDate);

    }
    @When("User clicks process button")
    public void user_clicks_process_button() {

        orderPage.submit.click();

    }
    @Then("User verifies {string} is in the list")
    public void user_verifies_is_in_the_list(String name) {
        orderPage.viewAllOrders.click();

        List<WebElement> names = orderPage.allNames;
        for(WebElement each : names){
            if(each.getText().equals(name)){
                System.out.println(name +" is in the List");
                Assert.assertEquals(name,each.getText());
            }
        }
    }
}
