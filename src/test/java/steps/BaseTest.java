package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.utils.SetupEnvironement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    @Before
    public void setup() {
        SetupEnvironement.setupEnvironment();
    }
    @After
    public void teardown() {
        SetupEnvironement.driver.quit();
    }
}
