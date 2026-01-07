package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.repository.ChartRepository;
import org.example.utils.GlobalFunction;
import org.example.utils.SetupEnvironement;
import org.openqa.selenium.By;

public class AddToChartTest {

    @When("user click add to chart")
    public void user_click_add_to_chart() {
        GlobalFunction.waitElementPresent(SetupEnvironement.driver, ChartRepository.BTN_AddToCHart_id,"id").click();
        String validateChartInsert = SetupEnvironement.driver.findElement(By.xpath(ChartRepository.NTF_NotifChart_xpath)).getText();
        System.out.println(validateChartInsert);
    }
    @When("user click chart")
    public void user_click_chart() {
        SetupEnvironement.driver.findElement(By.xpath(ChartRepository.BTN_Chart_xpath)).click();
    }
    @Then("Then the product exist in chart list")
    public void then_the_product_exist_in_chart_list() {
        GlobalFunction.waitElemenstPresent(SetupEnvironement.driver,ChartRepository.FLD_ChartList_xpath, "xpath");
    }
}
