package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;

public class ScrollDataExample {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "driiver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) ...");



        WebDriver driver;

//        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Cookie cfClearance = new Cookie("cf_clearance", "_gid=GA1.2.1473152492.1767779851; _ga_CESXN06JTW=GS2.1.s1767779851$o1$g0$t1767779851$j60$l0$h0; _ga=GA1.1.633200437.1767779851; _ga_WSM10MMEKC=GS2.2.s1767779851$o1$g0$t1767779851$j60$l0$h0; __stripe_mid=177ca763-910f-4aab-a6ba-802560981cae469ca9; cf_clearance=KutVHC4hL9wGj0xF_p519OUghLD2JK050ii1bOUINqU-1767786036-1.2.1.1-PTFADxlFWczRuSatdnA.wB02NBXDYn0o5gVrjsGjuRukGPQXSx7Kejw2JluDeY7yg6Kwl8KYDbIMRS.N_EC0mT7WyNays42ERilkDbLzl4dJs9Zdm4KKr4dD54UokTX..W2pJPgYnExRxRZ5eUhrNeoWvRpXx_kosgTJ0RAyETX32yQgPJaEDZ9kLm2BRR6sqT71p.wojbH10jbIBVedEcGc92z.8MhYjbSjOJyeZF0");
        driver.manage().addCookie(cfClearance);



        driver.get("https://reqres.in/api/users?page=2");
    }
}
