import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Email {
    public static final String ACCOUNT_SID = "AC6b847e684d4e9a39d0c50f9dfd9d1c23";
    public static final String AUTH_TOKEN = "69f28fe0089f7b65ab7272a8b49b965b";

    public static void main(String[] args) throws Exception {

        System.setProperty("webdriver.chrome.driver", "./chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.gmail.com");
        WebElement emailField;
        WebElement button1;
        WebElement passField;
        WebElement button2;
        WebElement inboxField;

        try {
            emailField = driver.findElement(By.xpath("//input"));
            button1 = driver.findElement(By.xpath(".//*[@id='identifierNext']/content/span"));
        }
        catch (Exception e){
            throw e;
        }
        emailField.sendKeys("ela9eandualem@gmail.com");
        button1.click();

        Thread.sleep(5000);

        passField = driver.findElement(By.xpath(".//*[@id='password']/div[1]/div/div[1]/input"));
        try {

            button2 = driver.findElement(By.xpath(".//*[@id='passwordNext']/content/span"));
        }
        catch (Exception e){
            throw e;
        }

        passField.sendKeys("Satellite09");
        button2.click();

        Thread.sleep(5000);

        //inboxField = driver.findElement(By.xpath(".//*[@id=':4e']/div/div[2]/span"));
        inboxField = driver.findElement(By.className("J-Ke"));
        String inbox = inboxField.getText();

        System.out.print(inbox);

        Message message = Message.creator(
                new PhoneNumber("+2510911099351"),
                new PhoneNumber("+19104151890"),
                inbox
        ).create();
        System.out.println(message.getSid());

        driver.close();
    }

}
