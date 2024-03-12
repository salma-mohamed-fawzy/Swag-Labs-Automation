import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testcase {
    //variables
      WebDriver driver;
      String url="https://www.google.com/";
      String text="test automation";
    //locator
//q and  result-stats
    //keywords
    @Test
    public void mytest(){
        driver=new ChromeDriver();
        driver.get(url);
        driver.findElement(By.name("q")).sendKeys(text);
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        WebElement resultelement= driver.findElement(By.id("result-stats"));
        Assert.assertTrue(resultelement.isDisplayed());
        Assert.assertTrue(resultelement.getText().contains("1,030,000,000"), "Number is wrong");
        //i want it to close after period of time
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();


    }
}
