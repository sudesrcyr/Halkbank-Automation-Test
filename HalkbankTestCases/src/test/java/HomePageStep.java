import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.*; //keys kütüphanesi
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import javax.swing.*;

public class HomePageStep {

    protected WebDriver driver;
    static String loginPageUrl = "https://www.halkbank.com.tr/";

    @Given("user goes to link")
    public void userGoesToLink() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();//browser'ı ac
        driver.manage().window().maximize();//browser'ı maksimum boyuta getir
        driver.get(loginPageUrl);//web sitesini browserda ac
        
    }

    @And("user scroll down the page")
    public void userScrollDownThePage() throws InterruptedException {

        //sayfayı 1260 char asagı kaydır
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1260)", "");
        Thread.sleep(1200);
        
    }
    @And("user click the any credit type")
    public void userClickTheAnyCreditType() throws InterruptedException {

        //konut kredisine tıklandı
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[1]/div/div/div[2]/ol/li[3]")).click();
        Thread.sleep(1200);
    }
    
    @And("click the select-box")
    public void clickTheSelectBox() throws InterruptedException {

        //comboboxa tıklandı
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[1]/div/div/div[2]/div[4]/div/form/div[2]/div/span/span[1]/span")).click();
        //combonun icinde bulunan ikinci secenege kadar in ve sec
        for(int i = 0; i <= 2; i++){
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.DOWN).build().perform();//press down arrow key
            actions.sendKeys(Keys.ENTER).build().perform();//press enter
        }
        Thread.sleep(1200);
        //canlı yardımı kapat
        driver.findElement(By.xpath("/html/body/div[4]/img[3]")).click();
        Thread.sleep(1200);
        //cookie consent text'i kapat
        driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div[5]/div/div/a")).click();
        Thread.sleep(1200);
        
    }
    
    @When("user fills the first box")
    public void userFillsTheFirstBox() throws InterruptedException {

        //kredi tutarının icindeki default degeri sil
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[1]/div/div/div[2]/div[4]/div/form/div[5]/div[3]/input[1]")).clear();
        Thread.sleep(1200);
        //kredi tutarının icine yeni degeri gir
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[1]/div/div/div[2]/div[4]/div/form/div[5]/div[3]/input[1]")).sendKeys("10000");
        Thread.sleep(1200);
        
    }

    @And("user fills the second box")
    public void userFillsTheSecondBox() throws InterruptedException {

        //vadenin icindeki default degeri sil
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[1]/div/div/div[2]/div[4]/div/form/div[6]/div[3]/input")).clear();
        Thread.sleep(1200);
        //vadenin icine yeni deger gir
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[1]/div/div/div[2]/div[4]/div/form/div[6]/div[3]/input")).sendKeys("12");
        Thread.sleep(1200);
    }

    @And("click the button")
    public void clickTheButton() throws InterruptedException {

        //hesapla'ya tıklandı
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[1]/div/div/div[2]/div[4]/div/form/button")).click();
        //diger adıma gecmeden 1200 ms bekle
        Thread.sleep(1200);
        
    }

    @And("user click the next button")
    public void userClickTheNextButton() throws InterruptedException {

        //krediye basvur'a tıklandı
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[1]/div/div/div[2]/div[4]/div/form/div[7]/a")).click();
        //yeni sekmeye gecmeden önce 1200ms bekle
        Thread.sleep(1200);
        
    }

    @And("user enter the information")
    public void userEnterTheInformation() throws InterruptedException {

        //id gir
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/div[3]/div/form/div/div[2]/div[2]/div/button")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/form[1]/div/div[1]/div[2]/div/input")).sendKeys("11111111111");

        //gün/ay/yil gir
        Select drpDay = new Select(driver.findElement(By.name("birthDay")));
        drpDay.selectByIndex(28);

        Select drpMonth = new Select(driver.findElement(By.name("birthMonth")));
        drpMonth.selectByIndex(3);

        Select drpYear = new Select(driver.findElement(By.name("birthYear")));
        drpYear.selectByIndex(2);

        Thread.sleep(1200);

        //tel no gir
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/form[1]/div/div[3]/div[2]/div/input")).sendKeys("5555555555");

        //cookies close
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div/div/div/div/div/div[5]/div/div/a")).click();

        //recaptcha
        String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value:");
        //Type the entered captcha to the text box
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/form[1]/div/div[4]/div[2]/div/input")).sendKeys(captchaVal);
        Thread.sleep(1200);
    }


    @Then("user clicks continue and get an error message")
    public void userClicksContinueAndGetAnErrorMessage() throws InterruptedException {

        Actions actions=new Actions(driver);
        actions.scrollByAmount(0,600).perform();
        Thread.sleep(1200);
        //devam'a tiklama
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[2]/div/div/div/div[3]/div[1]/form[1]/div/div[7]/div/div[2]")).submit();
        System.out.println("Hata!");
        System.out.println("Kimlik bilgileri hatalidir!");
    }
}
