import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.Iterator;
import java.util.Set;

public class LiveHelpSteps {
    protected WebDriver driver;

    static String page2 = "https://www.halkbank.com.tr/";

    @Given("user opens page")
    public void userOpensPage() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(page2);

    }

    @And("scroll down to the bottom")
    public void scrollDownToTheBottom() throws InterruptedException {
        Actions actions=new Actions(driver);
        actions.scrollByAmount(0,2300).perform();
        Thread.sleep(3000);

    }

    @When("click live help chat bubble")
    public void clickLiveHelpChatBubble() throws InterruptedException {
        //click the chat bubble
        driver.findElement(By.xpath("/html/body/div[4]/img")).click();
        Thread.sleep(1000);
    }

    @And("select an option and click start the conversation")
    public void selectAnOptionAndClickStartTheConversation() throws InterruptedException {
        //yeni sekmeye gecildi
        String parent = driver.getWindowHandle();

        Set<String> s = driver.getWindowHandles();

        // Now iterate using Iterator
        Iterator<String> I1 = s.iterator();

        while (I1.hasNext()) {

            String child_window = I1.next();


            if (!parent.equals(child_window)) {
                driver.switchTo().window(child_window);
                driver.manage().window().maximize();
                driver.findElement(By.xpath("//a[@href='javascript:void(0);']")).click();//ürünler hakkında bilgi alacağım tıklandı
                driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div[2]/div[1]/div[4]/a")).click();//konuşmayı başlat tıklandı
                Thread.sleep(3000);

            }
        }
    }
    @And("enter the information in the form")
    public void enterTheInformationInTheForm() throws InterruptedException {
        driver.findElement(By.name("name")).sendKeys("Sude");
        driver.findElement(By.name("surname")).sendKeys("Sarıçayır");
        driver.findElement(By.name("identityNumber")).sendKeys("11111111111");
        driver.findElement(By.name("email")).sendKeys("invalid@gmail.com");
        driver.findElement(By.name("gsmNo")).sendKeys("5555555555");
        Thread.sleep(1000);
        Actions actions=new Actions(driver);
        actions.scrollByAmount(0,100).perform();
        Thread.sleep(3000);
        String captchaVal = JOptionPane.showInputDialog("Please enter the captcha value with UPPERCASE LETTER:");
        //Type the entered captcha to the text box
        driver.findElement(By.name("captcha")).sendKeys(captchaVal);
        Thread.sleep(3000);

    }
    @And("click continue and see the error message because of invalid data input")
    public void clickContinueAndSeeTheErrorMessageBecauseOfInvalidDataInput() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div[2]/div[1]/div[5]/div/form/div[2]/input[2]")).submit();
        System.out.println("Kimlik bilgileriniz uyusmuyor!");
        Thread.sleep(3000);

    }
    @And("click to the back")
    public void clickToTheBack() throws InterruptedException {

        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div[2]/div[1]/div[5]/div/form/div[2]/input[1]")).click();

        Thread.sleep(3000);

    }
    @Then("choose another option and see the bug")
    public void chooseAnotherOptionAndSeeTheBug() {
        //teknik bir yardım alacağım tıklandı
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div[2]/div[1]/div[2]/a[3]")).click();
        //sayfa aşağıya çekildi
        Actions actions=new Actions(driver);
        actions.scrollByAmount(0,100).perform();
        //konuşmayı başlat tıklandı
        driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div/div[2]/div[2]/div[1]/div[4]/a")).click();


    }


}
