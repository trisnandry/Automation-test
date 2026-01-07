package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.repository.CheckoutRepository;
import org.example.utils.GlobalFunction;
import org.example.utils.SetupEnvironement;
import org.testng.Assert;

public class CheckoutTest {

    @When("user click checkout")
    public void user_click_checkout() {
        GlobalFunction.waitElementPresent(SetupEnvironement.driver, CheckoutRepository.BTN_Checkout_id,"id").click();
    }

    @When("user fill valid frist name {string}")
    public void user_fill_valid_frist_name(String string) {
        GlobalFunction.waitElementPresent(SetupEnvironement.driver,CheckoutRepository.FLD_FirstName_id,"id").sendKeys(string);
    }

    @When("user fill valid last name {string}")
    public void user_fill_valid_last_name(String string) {
        GlobalFunction.waitElementPresent(SetupEnvironement.driver,CheckoutRepository.FLD_LastName_id,"id").sendKeys(string);
    }

    @When("user fill valid zip code {string}")
    public void user_fill_valid_zip_code(String string) {
        GlobalFunction.waitElementPresent(SetupEnvironement.driver,CheckoutRepository.FLD_ZipCode_id,"id").sendKeys(string);
    }

    @When("user click continue")
    public void user_click_continue() {
        GlobalFunction.waitElementPresent(SetupEnvironement.driver, CheckoutRepository.BTN_Continue_id,"id").click();
    }

    @When("user click finish")
    public void user_click_finish() {
        GlobalFunction.waitElementPresent(SetupEnvironement.driver, CheckoutRepository.BTN_Finish_id,"id").click();
    }
    @Then("user get message error order {string}")
    public void user_get_message_error_order(String string) {
        String validate = GlobalFunction.waitElementPresent(SetupEnvironement.driver,CheckoutRepository.TXT_ErrorMEssage_xpath,"xpath").getText();
        Assert.assertEquals(validate,string);
    }
    @Then("user get message success order {string}")
    public void user_get_message_succes_order(String string) {
        String validate = GlobalFunction.waitElementPresent(SetupEnvironement.driver,CheckoutRepository.TXT_SuccesOrder_xpath,"xpath").getText();
        Assert.assertEquals(validate,string);
    }
}
