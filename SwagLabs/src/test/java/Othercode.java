import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Othercode {

    private WebDriver driver;

    @org.testng.annotations.Test
    public void testDemo() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);


        driver.get("https://www.saucedemo.com/");
        By username=By.id("user-name");
        WebElement user=driver.findElement(username);
        user.sendKeys("standard_user");
        By password=By.id("password");
        WebElement pass=driver.findElement(password);
        pass.sendKeys("secret_sauce");
        By loginbutton=By.id("login-button");
        WebElement login=driver.findElement(loginbutton);
        login.click();

        /*By loginPageHeaderSelector = By.className("login_logo");
        WebElement loginPageHeader = driver.findElement(loginPageHeaderSelector);
// System.out.println(loginPageHeader.getText());
        Assert.assertEquals(loginPageHeader.getText(),"Swag Labs1","login page header does not match requirement");*/
// driver.quit();



        //driver.findElement(By.xpath("//div[@class='inventory_item_name' and contains(text(),'Sauce Labs Backpack')]/ancestor::div/following-sibling::div/button")).sendKeys();
        String locator = "add-to-cart-sauce-labs-backpack";
        driver.findElement(By.name(locator)).click();
        driver.get("https://www.saucedemo.com/cart.html");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

        String locator2 = "//div[@class='inventory_item_name' and contains(text(),'%s')]";
        String s2 = String.format(locator2,"Sauce Labs Backpack");
        By itemLocator = By.xpath(s2);


        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(itemLocator));
            //System.out.print("gg");
        } catch (TimeoutException e) {
            System.out.println("Element not visible");
        }
        //driver.findElement(By.xpath("//div[@class='inventory_item_name' and contains(text(),'Sauce Labs Backpack')]"));

    }
}