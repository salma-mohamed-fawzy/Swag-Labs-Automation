
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SameinFunctions {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @Test
    public void testDemo() {
        driver.get("https://www.saucedemo.com/");
        assertLoginPageHeader();
        login();
        assertInventoryItemsCount();
        addItemToCart("Sauce Labs Backpack");
        navigateToCart();
        assertItemInCart("Sauce Labs Backpack");
    }

    private void assertLoginPageHeader() {
        WebElement loginPageHeader = driver.findElement(By.className("login_logo"));
        Assert.assertEquals(loginPageHeader.getText(), "Swag Labs", "Login page header does not match requirement");
    }

    private void login() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).sendKeys(Keys.ENTER);
    }

    private void assertInventoryItemsCount() {
        List<WebElement> inventoryItems = driver.findElements(By.className("inventory_item"));
        Assert.assertEquals(inventoryItems.size(), 6, "The number of inventory items is not 6");
    }

    private void addItemToCart(String productName) {
        xpathOfDifferentProducts(productName);
    }

    private void navigateToCart() {
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    private void assertItemInCart(String itemName) {
        String itemInCart = driver.findElement(By.xpath("//div[text()='" + itemName + "']")).getText();
        Assert.assertEquals(itemInCart, itemName, "Item not found in the cart");
    }

    // Generic locator method
    private void xpathOfDifferentProducts(String productName) {
        String xpathOfProduct = String.format("//div[contains(text(), '%s')]/ancestor::div[contains(@class, 'inventory_item')]//button", productName);
        WebElement button = driver.findElement(By.xpath(xpathOfProduct));
        button.click();
    }
}

