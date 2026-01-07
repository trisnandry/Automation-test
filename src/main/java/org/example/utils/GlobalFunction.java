package org.example.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GlobalFunction {
    public static WebElement waitElementPresent(WebDriver driver, String elementToWait, String type){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Tunggu sampai elemen hadir di DOM
        if(type.equalsIgnoreCase("id")){
            return wait.until( ExpectedConditions.presenceOfElementLocated(By.id(elementToWait)) );
        }else {
            return wait.until( ExpectedConditions.presenceOfElementLocated(By.xpath(elementToWait)) );
        }
    }
    public static List<WebElement> waitElemenstPresent(WebDriver driver, String elementToWait, String type){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // Tunggu sampai elemen hadir di DOM
        if(type.equalsIgnoreCase("id")){
            return wait.until( ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(elementToWait)) );
        }else {
            return wait.until( ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(elementToWait)) );
        }
    }
    public static List<String> sortAscending(List<String> input) {
        List<String> sortedList = new ArrayList<>(input); // copy agar tidak ubah list asli
        Collections.sort(sortedList); // urutkan ascending (default A-Z)
        return sortedList;
    }
    public static List<String> sortDescending(List<String> input) {
        List<String> sortedList = new ArrayList<>(input); // copy agar list asli tidak berubah
        Collections.sort(sortedList, Collections.reverseOrder()); // urutkan Z–A
        return sortedList; }
    public static List<String> sortAscendingPrice(List<String> input) {
        List<String> sortedList = new ArrayList<>(input); // copy agar list asli tidak berubah
        sortedList.sort(Comparator.comparingDouble(Double::parseDouble));
        return sortedList; }
    public static List<String> sortDescendingPrice(List<String> input) {
        List<String> sortedList = new ArrayList<>(input); // copy agar list asli tidak berubah
        sortedList.sort((a, b) -> Double.compare(Double.parseDouble(b), Double.parseDouble(a))); // urutkan Z–A
        return sortedList; }
}
