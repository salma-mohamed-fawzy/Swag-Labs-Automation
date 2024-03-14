
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;

import java.io.File;
import java.util.List;

public class Swaglabs {

    private WebDriver driver;

    @org.testng.annotations.Test
    public void testDemo(){

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);


        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        By loginPageHeaderSelector = By.className("login_logo");
        WebElement loginPageHeader = driver.findElement(loginPageHeaderSelector);
        // System.out.println(loginPageHeader.getText());
        Assert.assertEquals(loginPageHeader.getText(),"Swag Labs","login page header does not match requirement");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).sendKeys(Keys.ENTER);

        //i want to assert there is 6 elements
        List<WebElement> inventoryItems = driver.findElements(By.className("inventory_item"));
        Assert.assertEquals(inventoryItems.size(), 6, "The number of inventory items is not 6");
        /*
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']/ancestor::div[@class='inventory_item']//div[@class='pricebar']/child::button")).click();
        */
        String item="Sauce Labs Backpack";
        xpathOfDifferentProducts(item);

        driver.findElement(By.className("shopping_cart_link")).click();

        // Locate elements representing items in the cart
        List<WebElement> cartItems = driver.findElements(By.className("cart_item"));
        // Assert that items "by name" are present in the cart
        String itemName=driver.findElement(By.xpath("//div[text()='"+item+"']")).getText();
        Assert.assertEquals(itemName,"Sauce Labs Backpack" ,"Items not found in the cart");
        //driver.quit();

    }

    //generic locator
    public void xpathOfDifferentProducts(String productName) {
        String xpathOfProduct = String.format("//div[contains(text(), '%s')]/ancestor::div[contains(@class, 'inventory_item')]//button", productName);
        WebElement button = driver.findElement(By.xpath(xpathOfProduct));
        button.click();
    }
}