package selenium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Test;
import org.junit.Before;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    
    private WebDriver driver;

    @Before
    public void setUp(){
        System.out.println("Iniciando configuración...");
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        System.out.println("Iniciando Pruebas...");

        //driver.findElement(By.xpath("//*[@data-id-product='1']")).click();

        WebElement element = driver.findElement(By.xpath("//*[@data-id-product='1']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement element2 = driver.findElement(By.xpath("//a[contains(@title,'Proceed to checkout')]"));
        JavascriptExecutor executor2 = (JavascriptExecutor)driver;
        executor2.executeScript("arguments[0].click();", element2);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement element3 = driver.findElement(By.xpath("//a[contains(@class,'standard-checkout')]"));
        JavascriptExecutor executor3 = (JavascriptExecutor)driver;
        executor3.executeScript("arguments[0].click();", element3);


        WebElement searchbox = driver.findElement(By.name("email_create"));
        searchbox.sendKeys("grupo1_14@gmail.com");
        searchbox.submit();

        WebElement element4 = driver.findElement(By.xpath("//button[contains(@name,'SubmitCreate')]"));
        JavascriptExecutor executor4 = (JavascriptExecutor)driver;
        executor4.executeScript("arguments[0].click();", element4);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Test 1

        if(driver.findElement(By.id("email")).getAttribute("value").equals("grupo1_14@gmail.com"))
        {
            System.out.println("Test 1 - Coincide email: OK");
        }
        else
        {
            System.out.println("Test 1 - No Coincide email: Not OK");
            System.out.println(driver.findElement(By.id("email")).getAttribute("value"));
        }

        WebElement customer_firstname = driver.findElement(By.name("customer_firstname"));
        customer_firstname.sendKeys("Gerardo");

        WebElement customer_lastname = driver.findElement(By.name("customer_lastname"));
        customer_lastname.sendKeys("Soto");

        WebElement passwd = driver.findElement(By.name("passwd"));
        passwd.sendKeys("passw5678");

        Select drpDays = new Select(driver.findElement(By.name("days")));
        drpDays.selectByIndex(12);

        Select drpMonths = new Select(driver.findElement(By.name("months")));
        drpMonths.selectByIndex(11);

        Select drpYears = new Select(driver.findElement(By.name("years")));
        drpYears.selectByVisibleText("2000  ");

        WebElement address1 = driver.findElement(By.name("address1"));
        address1.sendKeys("3116 Annandale Rd");

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Falls Church");

        Select drpState = new Select(driver.findElement(By.name("id_state")));
        drpState.selectByVisibleText("Virginia");
        
        WebElement postcode = driver.findElement(By.name("postcode"));
        postcode.sendKeys("22042");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("555665544");
        
        WebElement phone_mobile = driver.findElement(By.name("phone_mobile"));
        phone_mobile.sendKeys("555665544");

        WebElement submitAccount = driver.findElement(By.xpath("//button[contains(@name,'submitAccount')]"));
        JavascriptExecutor executorSubmitAccount = (JavascriptExecutor)driver;
        executorSubmitAccount.executeScript("arguments[0].click();", submitAccount);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Test 2

        //ul class="address item box" id="address_delivery"
        //address_title
        //address_firstname address_lastname
        //address_address1 address_address2
        //address_city address_state_name address_postcode
        //address_country_name
        //address_phone_mobile
        //address_update

        //address_firstname address_lastname
        WebElement linkElement1 = driver.findElement(By.xpath("//ul[@id='address_delivery']/li[2]"));
        if(linkElement1.getText().equals("Gerardo Soto"))
        {
            System.out.println("Test 2 - Coincide Name (Gerardo Soto): OK");
        }
        else
        {
            System.out.println("test 2- No Coincide Name (Gerardo Soto): Not OK");
            System.out.println(linkElement1.getText());
        }

        //address_address1 address_address2
        WebElement linkElement2 = driver.findElement(By.xpath("//ul[@id='address_delivery']/li[3]"));
        if(linkElement2.getText().equals("3116 Annandale Rd"))
        {
            System.out.println("Test 3 - Coincide address (3116 Annandale Rd): OK");
        }
        else
        {
            System.out.println("Test 3 - No Coincide address (3116 Annandale Rd): Not OK");
            System.out.println(linkElement2.getText());
        }

        //address_city address_state_name address_postcode
        WebElement linkElement3 = driver.findElement(By.xpath("//ul[@id='address_delivery']/li[4]"));
        if(linkElement3.getText().equals("Falls Church, Virginia 22042"))
        {
            System.out.println("Test 4 - Coincide City, State Postcode (Falls Church, Virginia 22042): OK");
        }
        else
        {
            System.out.println("Test 4 - No Coincide City, State Postcode (Falls Church, Virginia 22042): Not OK");
            System.out.println(linkElement3.getText());
        }

        //address_country_name
        WebElement linkElement4 = driver.findElement(By.xpath("//ul[@id='address_delivery']/li[5]"));
        if(linkElement4.getText().equals("United States"))
        {
            System.out.println("Test 5 - Coincide Country (United States): OK");
        }
        else
        {
            System.out.println("Test 5 - No Coincide Country (United States): Not OK");
            System.out.println(linkElement4.getText());
        }

        //address_phone_mobile
        WebElement linkElement6 = driver.findElement(By.xpath("//ul[@id='address_delivery']/li[7]"));
        if(linkElement6.getText().equals("555665544"))
        {
            System.out.println("Test 6 - Coincide Phone Mobile (555665544): OK");
        }
        else
        {
            System.out.println("Test 6 - No Coincide Phone Mobile (555665544): Not OK");
            System.out.println(linkElement6.getText());
        }

        WebElement processAddress = driver.findElement(By.xpath("//button[contains(@name,'processAddress')]"));
        JavascriptExecutor executorProcessAddress= (JavascriptExecutor)driver;
        executorProcessAddress.executeScript("arguments[0].click();", processAddress);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement checkBoxAgree = driver.findElement(By.xpath("//input[contains(@name,'cgv')]"));
        JavascriptExecutor executorCheckBoxAgree = (JavascriptExecutor)driver;
        executorCheckBoxAgree.executeScript("arguments[0].click();", checkBoxAgree); 

        WebElement processCarrier = driver.findElement(By.xpath("//button[contains(@name,'processCarrier')]"));
        JavascriptExecutor executorprocessCarrier= (JavascriptExecutor)driver;
        executorprocessCarrier.executeScript("arguments[0].click();", processCarrier);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        

        WebElement payByBankWire = driver.findElement(By.xpath("//a[contains(@title,'Pay by bank wire')]"));
        JavascriptExecutor executorPayByBankWire = (JavascriptExecutor)driver;
        executorPayByBankWire.executeScript("arguments[0].click();", payByBankWire);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement confirmButton = driver.findElement(By.xpath("//span[contains(text(), 'I confirm my order')]"));
        JavascriptExecutor executorConfirmButton = (JavascriptExecutor)driver;
        executorConfirmButton.executeScript("arguments[0].click();", confirmButton);    
    }
}
