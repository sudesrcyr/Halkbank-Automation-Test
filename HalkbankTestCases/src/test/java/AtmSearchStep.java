import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AtmSearchStep {

    protected WebDriver driver;
    static String loginPageUrl="https://www.halkbank.com.tr/";

  @Given("user goes to the website")
    public void userGoesToTheWebsite() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();//browser'ı açar
        driver.manage().window().maximize();//browser'ı maksimum boyuta getirir
        driver.get(loginPageUrl);//web sitesini browserda açar

    }

    @And("user scrolls down the page to the bottom")
    public void userScrollsDownThePageToTheBottom() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"92df953a_187c310a331\"]/button")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        driver.findElement(By.xpath("/html/body/div[4]/img[3]")).click();//canli yardimi kapat
        Thread.sleep(1200);
        
    }

    @And("user clicks on the branch atm search")
    public void userClicksOnTheBranchAtmSearch() throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div[1]/div/div[4]/div/div/div/div/div/div[1]/div/div/div/div/div/div/div[3]/div[1]/a")).click();
        Thread.sleep(1200);

    }

    @And("scroll down the new page again")
    public void scrollDownTheNewPageAgain() {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");
        
    }

    @And("user clicks on the from list")
    public void userClicksOnTheFromList() throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div[1]/ol/li[2]")).click();
        Thread.sleep(1000);
        
    }

    @When("user clicks on the atm")
    public void userClicksOnTheAtm() throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div[1]/div/form/div/div/div[1]/div/div/div[2]/label")).click();
        Thread.sleep(1200);
    }

    @And("user clicks on the first combobox and select any city")
    public void userClicksOnTheFirstComboboxAndSelectAnyCity() {

        Select drpCity = new Select(driver.findElement(By.name("city")));
        drpCity.selectByIndex(1);
        
    }

    @And("user clicks on the second combobox and select any county")
    public void userClicksOnTheSecondComboboxAndSelectAnyCounty() {

        Select drpCounty = new Select(driver.findElement(By.name("county")));
        drpCounty.selectByIndex(9);
        
    }

    @And("user clicks on the third combobox and select any branch type")
    public void userClicksOnTheThirdComboboxAndSelectAnyBranchType() {

        Select drpAtm = new Select(driver.findElement(By.name("atmType")));
        drpAtm.selectByIndex(2);

    }

    @And("user clicks on the fourth combobox and select any option")
    public void userClicksOnTheFourthComboboxAndSelectAnyOption() {

        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div[1]/div/form/div/div/div[7]/div/div")).click();
        
    }

    @Then("user clicks on the search and see the result on the right side")
    public void userClicksOnTheSearchAndSeeTheResultOnTheRightSide() {

        //cookies close
        driver.findElement(By.xpath("/html/body/div[1]/div/div[5]/div/div/div/div/div/div[5]/div/div/a")).click();
        //submit search button
        driver.findElement(By.xpath("/html/body/div[1]/div/div[3]/div/div[2]/div/div[2]/div/div/div/div[2]/div/div/div[1]/div/form/div/div/div[8]")).submit();
        Actions actions=new Actions(driver);
        actions.scrollByAmount(0,400).perform();
        System.out.println("Sonuclar sag tarafta listelendi!");
    }
}
