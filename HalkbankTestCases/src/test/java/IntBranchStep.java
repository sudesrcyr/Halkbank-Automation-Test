import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class IntBranchStep {
    protected WebDriver driver;
    static String loginPageUrl="https://www.halkbank.com.tr/";

    @Given("user goes bank page")
    public void userGoesBankPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();//browser'ı açar
        driver.manage().window().maximize();//browser'ı maksimum boyuta getirir
        driver.get(loginPageUrl);//web sitesini browserda açar

    }


    @And("user click internet branch")
    public void userClickInternetBranch() {

        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div[1]/div/div[2]/div/div[2]/div/div[1]")).click();

    }

    @And("user click retail")
    public void userClickRetail() {

        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div[1]/div/div[2]/div/div[2]/div/div[2]/a[1]")).click();

    }

    @When("user fills in the identity number")
    public void userFillsInTheIdentityNumber() throws InterruptedException {

        // It will return the parent window name as a String
        String parent=driver.getWindowHandle();

        Set<String> s=driver.getWindowHandles();

        // Now iterate using Iterator
        Iterator<String> I1= s.iterator();

        while(I1.hasNext())
        {

            String child_window=I1.next();


            if(!parent.equals(child_window))
            {
                driver.switchTo().window(child_window);
                //System.out.println(driver.switchTo().window(child_window).getTitle());
                driver.findElement(By.xpath("/html/body/div[1]/section/section[1]/div/div[2]/div[1]/div/div[3]/div/div/div[2]/form/fieldset/div/section[1]/label/input")).sendKeys("11111111111");
                Thread.sleep(100);
            }

        }

    }

    @And("user fills in the password")
    public void userFillsInThePassword() throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div[1]/section/section[1]/div/div[2]/div[1]/div/div[3]/div/div/div[2]/form/fieldset/div/section[2]/label/input")).sendKeys("123456");
        Thread.sleep(1000);

    }

    @Then("user click the login button and sees the error message")
    public void userClickTheLoginButtonAndSeesTheErrorMessage() {

        driver.findElement(By.xpath("/html/body/div[1]/section/section[1]/div/div[2]/div[1]/div/div[3]/div/div/div[2]/form/div[2]/div[2]/input")).submit();
        System.out.println("Bilgiler hatali! Lutfen tekrar deneyiniz!");
    }

}
