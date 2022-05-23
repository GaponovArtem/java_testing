import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.Duration;
import java.util.Locale;

public class AppManager {


    private WebDriver wd;

    public void init(String browser) {
        if (browser.equals("chrome")) {
            wd = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            wd = new FirefoxDriver();
        }

        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        wd.manage().window().maximize();
        wd.get("http://google.com");
        wd.findElement(By.name("q")).sendKeys("calculator", Keys.ENTER);
    }

    public void shutDown() {
        wd.quit();
    }

    public void input(String input) {
        String[] parsed = input.split("");
        for (String n : parsed) {
            click(n);
        }

    }

    public void click(String n) {
        switch (n) {
            case "(":
                wd.findElement(By.cssSelector(".ElumCf tbody tr:nth-child(1) td:nth-child(1)")).click();
                break;
            case ")":
                wd.findElement(By.cssSelector(".ElumCf tbody tr:nth-child(1) td:nth-child(2)")).click();
                break;
            case "%":
                wd.findElement(By.cssSelector(".ElumCf tbody tr:nth-child(1) td:nth-child(3)")).click();
                break;
            case "AC":
                wd.findElement(By.cssSelector(".ElumCf tbody tr:nth-child(1) td:nth-child(4)")).click();
                break;
            case "7":
                wd.findElement(By.cssSelector(".ElumCf tbody tr:nth-child(2) td:nth-child(1)")).click();
                break;
            case "8":
                wd.findElement(By.cssSelector(".ElumCf tbody tr:nth-child(2) td:nth-child(2)")).click();
                break;
            case "9":
                wd.findElement(By.cssSelector(".ElumCf tbody tr:nth-child(2) td:nth-child(3)")).click();
                break;
            case "/":
                wd.findElement(By.cssSelector(".ElumCf tbody tr:nth-child(2) td:nth-child(4)")).click();
                break;
            case "4":
                wd.findElement(By.cssSelector(".ElumCf tbody tr:nth-child(3) td:nth-child(1)")).click();
                break;
            case "5":
                wd.findElement(By.cssSelector(".ElumCf tbody tr:nth-child(3) td:nth-child(2)")).click();
                break;
            case "6":
                wd.findElement(By.cssSelector(".ElumCf tbody tr:nth-child(3) td:nth-child(3)")).click();
                break;
            case "*":
                wd.findElement(By.cssSelector(".ElumCf tbody tr:nth-child(3) td:nth-child(4)")).click();
                break;
            case "1":
                wd.findElement(By.cssSelector(".ElumCf tbody tr:nth-child(4) td:nth-child(1)")).click();
                break;
            case "2":
                wd.findElement(By.cssSelector(".ElumCf tbody tr:nth-child(4) td:nth-child(2)")).click();
                break;
            case "3":
                wd.findElement(By.cssSelector(".ElumCf tbody tr:nth-child(4) td:nth-child(3)")).click();
                break;
            case "-":
                wd.findElement(By.cssSelector(".ElumCf tbody tr:nth-child(4) td:nth-child(4)")).click();
                break;
            case "0":
                wd.findElement(By.cssSelector(".ElumCf tbody tr:nth-child(5) td:nth-child(1)")).click();
                break;
            case ".":
                wd.findElement(By.cssSelector(".ElumCf tbody tr:nth-child(5) td:nth-child(2)")).click();
                break;
            case "=":
                wd.findElement(By.cssSelector(".ElumCf tbody tr:nth-child(5) td:nth-child(3)")).click();
                break;
            case "+":
                wd.findElement(By.cssSelector(".ElumCf tbody tr:nth-child(5) td:nth-child(4)")).click();
                break;
        }
    }


    public String actualResult() {
        return wd.findElement(By.cssSelector(".qv3Wpe")).getText();

    }

    public String expectedResult(double formula) {
        Locale.setDefault(Locale.US);
        DecimalFormat df = new DecimalFormat("#0.00000000000");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(formula);
    }


}



