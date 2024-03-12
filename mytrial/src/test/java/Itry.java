import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class Itry {

    //variables

    //locators
    //keywords
    @Test
    public void myfunction(){

        WebDriver driver=new ChromeDriver();
        //use "get" to open any link orr you html files
        driver.get("https://www.google.com/"); //please copy paste the linkkkkkk
        driver.navigate().to("https://practicetestautomation.com/practice-test-login/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        /*copy absolute path of the html files
        driver.get("file://G:\\the material\\ITI -9months proffessional training\\Software Testing & Quality Assurance\\Automation Testing\\code\\mytrial\\src\\main\\resources\\first.html");
         */
         //to maximize the window
        driver.manage().window().maximize(); //or use fullscreen()
        /*
        for different devices sizes
        Dimension iphonexr= new Dimension(414,896);
        driver.manage().window().setSize(iphonexr);
        */
        //if you want the code to print the url of the website ...
        String currentUrl = driver.getCurrentUrl();
        System.out.println("the url is "+currentUrl);

        /////////////////////////////////////////////////////////////////////////////////////////
        String qacarttitle = driver.getTitle();
        System.out.println("the website title is "+qacarttitle);
        /////////////////////////////////////////////////////////////////////////////////////////
        String qacartSourceCode = driver.getPageSource();
        System.out.println("the website source code is \n"+qacartSourceCode);
        ////////////////////////////////////////locatorssss/////////////////////////////////////////////////
        driver.findElement(By.id("username")).sendKeys("student"); //gettext() can be used
        driver.findElement(By.id("password")).sendKeys("Password123");
        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);
        /////////////////////////////////////////////////////////////////////////////////////////

             /*using xpath expressions*/
        /*   xpath=//tagName[@attribute='value']  --> relative xpath  */
        /*   xpath=//*[@attribute='value']  --> tag name replaced by '*' to refer to any tag name has the attribute */
        /*   xpath=//*[contains(@attribute, 'val')]  --> to find element by part of the value of attribute  */
        /*   xpath=//*[text()='value']  --> to find element by text wriien on it "such as button text"  */
        /*   xpath=//*[contains(text() , 'value')]  --> to find element by text wriien on it using contains  */

        /*   xpath=//html/body/tagName[@attribute='value']  --> absolute xpath  */
        /*   xpath=//html/body/ul[index starts from 0]  --> absolute xpath --> here i target the second ul in page  */
        /*   xpath=//html/body/ul[1]/li[1]  --> absolute xpath --> here i target the second ul in page then second list item in it   */

        //########################################################################################################

        /*using CSS selectors     find element by cssSelector*/
        /* parameters  -->  #id   */
        /* parameters  -->  .className  */
        /* parameters  -->  [attribute="value"]  */
        /* parameters  -->  .outerClas .innerClass   --> to go to child css */
        /* parameters  -->  .outerClas > .innerClass   --> the symbol '>' means 'Direct Parent' only
                                                       --> space only can be used for grand parent or direct parent
        */
        /* parameters  -->  .classNameForUL li:nth-of-type(index starts from 1)  --> to go to nth list item for example */

        //########################################################################################################

        //driver.findElements(By.cssSelector(.ULclass li))  -> this returns all list items ina a LIST of WEBELEMENTS
        //driver.findElements(By.cssSelector(.ULclass li)).get(index starts from 0); -->-> this returns list item in index

        //########################################################################################################

       // driver.close(); //closes only current browser
        driver.quit(); //closes all tabs and windows
        //########################################################################################################
        //التعامل مع  checkbox or radiobutton  غالبا بنحتاج سيلينيوم يستنا عشان هو سريع جدا
         //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        //طبعا بعمل  click() to checkbox
        // ########################################################################################################
        //drop down list == <select> tag  has name and id
        //each option has value and text
        /*WebElement dropdown = driver.findElement(By.id("example"));
        Select exampleList = new Select(dropdown);
        exampleList.selectByIndex(0);
        exampleList.deselectByValue("example");
        exampleList.deselectByVisibleText("example");*/
        // ########################################################################################################
       /*
       isDisplayed()
       isEnabled()
       isSelected()
       بترجع  true and false
        متغير  في  منها  الراجع   فبنخزن
       getAttribute("AttributeName") --> returns attribute value as a String
       getTagName() --> returns tag name for the webElement as a String
       getCssValue("backgroubd-color" for example)  --> returns its value as a string

       getLocation() --> from x and y axis --> returns value as a Point ... when printing , print var.x or var .y
       System.out.println(pointvar.x);

       getSize() --> returns a value of class named Dimension equals value of height and width of the webelement
       System.out.println(DimensionVar.height);

       getRect()  --> returns a value of type Rectangle class ... has access to point (x and y)
       and dimension (height and width) when printttting
       */
       // ########################################################################################################
       // right click and double click
       // using Actions Class
       /* Actions action =new Actions(driver);
        action.doubleClick(driver.findEement(By.id("iddd"))).perform();

        perform() to execute action
        build() if u have many actions

        action.contextClick(driver.findEement(By.id("iddd"))).perform();   --> right click

        WebElement button =driver.findEement(By.id("iddd"))                -->move to element
        action.moveToElement(button).perform();

        WebElement source =driver.findEement(By.id("iddd"))               --> drag and drop element from source to destination
        WebElement destination =driver.findEement(By.id("iddd"))
        action.dragAndDrop(source,destination);
        -- equallls
        action.clickAndHold(source).moveToElement(destination).release().build().perform();
        --series of actions
        */

        // ########################################################################################################
        //multiple windows
        //String parent = driver.getWindowHandle();   --> if only one window
        //System.out.println(driver.getWindowHandles());  --> returns id of all opened windows
     /*
       Set<String> allwindows = driver.getWindowHandles();
       for(String window : allwindows){
           if(!window.equalsIgnoreCase(parent)){
               driver.switchTo().window(window);
               thread.sleap(3000);
               driver.close();
           }
           }
       driver.switchTo().window(parent);   --> to return driver to the parent
                                           --> even if closed child windoe the driver is still equals it so
                                               this switch should be done manually
    */
    }
    // ########################################################################################################
    // swiching between frames
    //driver should go first to frame using name or id
    //driver.switchTo().frame("name or id");  --> you can also pass a  of tag <iframe> .. found by class or xpath
     //driver.switchTo().parentFrame();  --> exit from iframe and go to the parent frame
    //if nested frames --> go to outer frame --> then inner frame  ----->>> and same if going out

}
