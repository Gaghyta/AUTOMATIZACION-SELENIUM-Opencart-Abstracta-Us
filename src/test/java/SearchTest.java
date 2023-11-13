import Reportes.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchTest {
    public WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES-ANTONINI/SearchTest.html");
    static ExtentReports extent;

    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void inicio() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        SearchPage searchPage = new SearchPage(driver, wait);
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        searchPage.setUp();
        searchPage.url("https://opencart.abstracta.us/index.php?route=common/home");
    }

    @Test
    @Tag("Busqueda")
    @Tag("ALL")
    public void testBusqueda_Iphone() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de buscar un producto Iphone de forma exitosa");
        test.log(Status.INFO, "Comienza el Test");
        SearchPage searchPage = new SearchPage(driver, wait);

        searchPage.ingresarProductoABuscar("Iphone");
        searchPage.enviarProductoABuscar();

        test.log(Status.PASS, "Completar Busqueda de Iphone");

        searchPage.clickAgregarAlCarrito();
        test.log(Status.PASS, "Se agrega el Iphone al carro");
        Assertions.assertTrue(searchPage.obtenerMensajeDeConfirmacion().startsWith("Success: You have added iPhone to your shopping cart"));

        searchPage.obtenerMensajeDeConfirmacion();

        test.log(Status.PASS, "El producto se ha agregado al carrito correctamente. Se obtiene el mensaje esperado");


    }

    @AfterEach
    public void quit() {
        SearchPage searchPage = new SearchPage(driver, wait);
        searchPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}