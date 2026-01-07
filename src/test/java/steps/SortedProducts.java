package steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.repository.AllItemsRepository;
import org.example.repository.LoginPageRepository;
import org.example.utils.GlobalFunction;
import org.example.utils.SetupEnvironement;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class SortedProducts{
    List<String> sortingList = new ArrayList<>();

    @Given("user in login page")
    public void user_in_login_page() {
        String urls = "https://www.saucedemo.com/";
        SetupEnvironement.driver.get(urls);
        Assert.assertEquals(SetupEnvironement.driver.getTitle(),"Swag Labs");
    }
    @When("user login with valid credential")
    public void user_login_with_valid_credential() {
        GlobalFunction.waitElementPresent(SetupEnvironement.driver, LoginPageRepository.FLD_Username_id,"id").sendKeys("standard_user");
        SetupEnvironement.driver.findElement(By.id(LoginPageRepository.FLD_Password_id)).sendKeys("secret_sauce");
        SetupEnvironement.driver.findElement(By.id(LoginPageRepository.BTN_Login_id)).click();
        String validateLoginSuccess = GlobalFunction.waitElementPresent(SetupEnvironement.driver,"//div[text()='Swag Labs']","xpath").getText();
        Assert.assertEquals(validateLoginSuccess,"Swag Labs");
    }
    @When("user selects sort option {string}")
    public void user_selects_sort_option(String string) {
        List<WebElement> resultAllProducts = new ArrayList<>();
        WebElement DDL_Short = GlobalFunction.waitElementPresent(SetupEnvironement.driver, AllItemsRepository.DDL_Shorted_xpath,"xpath");
        Select selectShort = new Select(DDL_Short);
        selectShort.selectByVisibleText(string);
        if(string.contains("Price")){
            resultAllProducts = SetupEnvironement.driver.findElements(By.xpath(AllItemsRepository.ITM_AllProductsPrice_xpath));

        }else {
            resultAllProducts = SetupEnvironement.driver.findElements(By.xpath(AllItemsRepository.ITM_AllProductsName_xpath));
        }
        for(WebElement element : resultAllProducts){
            sortingList.add(element.getText().replace("$",""));
        }

    }
    @Then("Then the product list should be displayed in ascending order by name")
    public void then_the_product_list_should_be_displayed_in_ascending_order_by_name() {
        Assert.assertEquals(sortingList,GlobalFunction.sortAscending(sortingList));
    }
    @Then("Then the product list should be displayed in descending order by name")
    public void then_the_product_list_should_be_displayed_in_descending_order_by_name() {
        Assert.assertEquals(sortingList,GlobalFunction.sortDescending(sortingList));
    }
    @Then("Then the product list should be displayed in ascending order by price")
    public void then_the_product_list_should_be_displayed_in_ascending_order_by_price() {
        Assert.assertEquals(sortingList,GlobalFunction.sortAscendingPrice(sortingList));
    }
    @Then("Then the product list should be displayed in descending order by price")
    public void then_the_product_list_should_be_displayed_in_descending_order_by_price() {
        Assert.assertEquals(sortingList,GlobalFunction.sortDescendingPrice(sortingList));
    }

//    @After
//    public void after_all(){
//        driver.quit();
//    }
}
