package org.example.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.HashMap;
import java.util.Map;

public class SetupEnvironement {
    public static WebDriver driver;

    public static void setupEnvironment(String browser) {
        if(browser.equalsIgnoreCase("edge")){
            System.setProperty("webdriver.edge.driver", "driiver/msedgedriver.exe");
            driver = new EdgeDriver();
        }else{
            System.setProperty("webdriver.chrome.driver", "driiver/chromedriver.exe");
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
    }


}
