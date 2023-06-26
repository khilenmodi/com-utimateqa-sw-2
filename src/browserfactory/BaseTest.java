package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

        public static WebDriver driver;

            public void openBrowser(String baseUrl){
                // launching the WebBrowser
                driver = new ChromeDriver();
                // getting the baseUrl
                driver.get(baseUrl);
                // maximize the Browser
                driver.manage().window().maximize();
                //Implicitly wait time
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            }
            public void closeBrowser(){
                driver.quit();
            }
}
