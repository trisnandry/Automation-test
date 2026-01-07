package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.repository.LoginPageRepository;
import org.example.utils.GlobalFunction;
import org.example.utils.SetupEnvironement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginTest {

    @When("user fill valid username {string}")
    public void user_fill_valid_username(String string) {
        GlobalFunction.waitElementPresent(SetupEnvironement.driver, LoginPageRepository.FLD_Username_id,"id").sendKeys(string);
    }
    @When("user fill valid password {string}")
    public void user_fill_valid_password(String string) {
        GlobalFunction.waitElementPresent(SetupEnvironement.driver, LoginPageRepository.FLD_Password_id,"id").sendKeys(string);
    }
    @Then("user direct to dashboard page")
    public void user_direct_to_dashboard_page() {
        String validateLoginSuccess = GlobalFunction.waitElementPresent(SetupEnvironement.driver,"//div[text()='Swag Labs']","xpath").getText();
        Assert.assertEquals(validateLoginSuccess,"Swag Labs");
    }
    @When("user fill invalid username {string}")
    public void user_fill_invalid_username(String string) {
        GlobalFunction.waitElementPresent(SetupEnvironement.driver, LoginPageRepository.FLD_Username_id,"id").sendKeys(string);
    }
    @When("user fill invalid password {string}")
    public void user_fill_invalid_password(String string) {
        GlobalFunction.waitElementPresent(SetupEnvironement.driver, LoginPageRepository.FLD_Password_id,"id").sendKeys(string);
    }
    @When("user click button login")
    public void user_click_button_login() {
        SetupEnvironement.driver.findElement(By.id(LoginPageRepository.BTN_Login_id)).click();
    }
    @Then("user get error message")
    public void user_get_error_message() {
        String validateLoginSuccess = GlobalFunction.waitElementPresent(SetupEnvironement.driver,LoginPageRepository.FLD_ValidateErrorLogin_xpath,"xpath").getText();
        Assert.assertEquals(validateLoginSuccess,"Epic sadface: Username and password do not match any user in this service");
    }
}
