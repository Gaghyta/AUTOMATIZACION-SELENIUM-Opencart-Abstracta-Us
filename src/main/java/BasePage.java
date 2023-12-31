import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BasePage {

    private By miCuenta = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a");
    protected By menuRegistro = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a");



    public static WebDriver driver;
    public static WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        BasePage.driver = driver;
        BasePage.wait = new WebDriverWait(driver, Duration.ofMillis(2000));
    }

    public void setUp() {
        //System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        driver.manage().window().maximize();
    }

    public void url(String url) throws InterruptedException {
        driver.get(url);
        //Thread.sleep(1000);
    }


    public void close() {
        driver.quit();
    }

    protected WebElement elementFind(By locator) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    protected void sendText(String imputText, By locator) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        this.elementFind(locator).clear();
        this.elementFind(locator).sendKeys(imputText);
    }

    protected void sendKey(CharSequence key, By locator) throws InterruptedException {
        this.elementFind(locator).sendKeys(key);
    }

    protected void click(By locator) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        this.elementFind(locator).click();
    }

    protected String getText(By locator) throws InterruptedException {
        return this.elementFind(locator).getText();
    }


    public void clickMiCuenta() throws InterruptedException {
        this.click(miCuenta);
    }

    public void clickRegistrar() throws InterruptedException {
        this.click(menuRegistro);
    }

    protected void sendKeys(By inputResultadosBuscador, String producto) {
    }


}