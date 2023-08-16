import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SearchbarStep {

    protected WebDriver driver;

    static String page = "https://www.halkbank.com.tr/";

    @Given("user goes to homepage")
    public void userGoesToHomepage() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); //open the browser
        driver.manage().window().maximize(); //maximize the window
        driver.get(page); //open the website on the browser

    }
    @And("user clicks the searchbar")
    public void userClicksTheSearchbar() {

        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div[1]/div/div[1]/div/div[2]/div/form/input")).click();
    }
    @When("user fills the search box with keyword or sentence")
    public void userFillsTheSearchBoxWithKeywordOrSentence() {

        driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div/div/div/div/div[1]/div/div[1]/div/div[2]/div/form/input")).sendKeys("konut");
    }
    @Then("user clicks enter")
    public void userClicksEnter() throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();
        //wait 3 second
        Thread.sleep(3000);
    }
    @And("scroll down the page")
    public void scrollDownThePage() throws InterruptedException {
        //scroll down the page
        Actions actions=new Actions(driver);
        actions.scrollByAmount(0,1300).perform();
        Thread.sleep(3000);

    }

    @And("go another page and click on the title")
    public void goAnotherPageAndClickOnTheTitle() throws InterruptedException {
        //close the live help
        driver.findElement(By.xpath("/html/body/div[4]/img[3]")).click();
        //close the cookies
        driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div[5]/div/div/a")).click();
        //ikinci sayfaya gec
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[2]/div/div/div/div/div[5]/div/div/ul/li[3]")).click();
        Thread.sleep(2000);

        Actions actions1=new Actions(driver);
        actions1.scrollByAmount(0,400).perform();

        //click the konut mevduat
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[2]/div/div/div/div/div[4]/div[3]/a")).click();

        Actions actions2=new Actions(driver);
        actions2.scrollByAmount(0,460).perform();

    }
}
