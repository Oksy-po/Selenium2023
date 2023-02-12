package lesson02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCafeExamplePage {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://devexpress.github.io/testcafe/example/");
        driver.findElement(By.id("developer-name")).sendKeys("Oksana");
        driver.findElement(By.id("remote-testing")).click();
        driver.findElement(By.name("re-using")).click();
        driver.findElement(By.xpath("//*[@id=\"background-parallel-testing\"]")).click();
        driver.findElement(By.name("CI")).click();
        driver.findElement(By.id("traffic-markup-analysis")).click();
        driver.findElement(By.id("tried-test-cafe")).click();
        driver.findElement(By.xpath("//*[@id=\"comments\"]")).sendKeys("I want to be QA Engineer!");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("#submit-button")).click();
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.equals("https://devexpress.github.io/testcafe/example/thank-you.html")){
            String message = driver.findElement(By.id("article-header")).getText();
            String title = driver.getTitle();
            if (message.equals("Thank you, Oksana!") ){
                System.out.println("The message is correct!");
            }
            else {
                System.out.println("The message isn't correct!");
            }
            if(title.equals("Thank you!")){
                System.out.println("The title is correct");
            }
            else {
                System.out.println("The title is not correct");
            }
            System.out.println("URL is correct");
        }
        else {
            System.out.println("Uuuups....");
        }
        Thread.sleep(1000);
        driver.quit();


    }
}
