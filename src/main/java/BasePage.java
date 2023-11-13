import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

//import java.time.Duration;

public class BasePage {

    private By miCuenta = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a");
    protected By menuRegistro = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[1]/a");



    public static WebDriver driver;
    public static WebDriverWait wait;

    public BasePage(WebDriver driver, WebDriverWait wait) {
        BasePage.driver = driver;
        BasePage.wait = wait;
    }

    public void setUp() {
        driver.manage().window().maximize();
    }

    public void getUrl(String url) {
        driver.get(url);
    }


    public void close() {
        driver.quit();
    }

    protected WebElement elementFind(By locator) throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    protected void sendText(String imputText, By locator) throws InterruptedException {
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

    /*public void clickLogin() throws InterruptedException {
        this.click(loginButtom);
    }*/

    public void clickMiCuenta() throws InterruptedException {
        Thread.sleep(1000);
        this.click(miCuenta);
    }

    public void clickRegistrar() throws InterruptedException {
        Thread.sleep(1000);
        this.click(menuRegistro);
    }

    protected void sendKeys(By inputResultadosBuscador, String producto) {
    }



    /*public String obtenerUsuario() throws InterruptedException {
        System.out.println("EL USUARIO ES: " + this.getText(nombreUsuario));
        return this.getText(nombreUsuario);
    }*/

}