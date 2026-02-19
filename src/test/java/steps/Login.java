package steps;

import org.openqa.selenium.By;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.testng.Assert;
import base.BaseDriver;

public class Login {

    WebDriver driver;
    WebDriverWait wait;


    @Given("the user is on the Sauce Labs Demo website")
    public void the_user_is_on_the_sauce_labs_demo_website() {
        BaseDriver.initializeDriver();
        BaseDriver.openUrl("https://www.saucedemo.com/");
        driver = BaseDriver.getDriver();
    }

    @When("the user is login as a standard_user")
    public void the_user_is_login_as_a_standard_user() {
        // Mencari field username dan memasukkan username
        WebElement usernameField = driver.findElement(By.id("user-name"));
        usernameField.sendKeys("standard_user");

        // Mencari field password dan memasukkan password
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        // Mencari button login dan click
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
    }

    @When("the user will successfully login")
    public void the_user_will_successfully_login() {
        // Assert that the login was successful by checking if the inventory container is displayed
        WebElement inventoryContainer = driver.findElement(By.id("inventory_container"));
        Assert.assertTrue(inventoryContainer.isDisplayed(), "Inventory container should be displayed after login");
    }
}