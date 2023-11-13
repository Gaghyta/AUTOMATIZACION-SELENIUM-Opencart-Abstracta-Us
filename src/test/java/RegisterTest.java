import Reportes.*;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterTest {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES-ANTONINI/RegisterTest.html");
    static ExtentReports extent;

    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp() throws InterruptedException {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.setUp();
        registerPage.url("https://opencart.abstracta.us/index.php?route=common/home");
    }

    @Test
    @Tag("Registro")
    @Tag("ALL")
    public void RegistroExitosoTest() throws InterruptedException {
       ExtentTest test = extent.createTest("Prueba de Crear Cuenta Exitosa");
        test.log(Status.INFO, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(driver, wait);

        try {
            registerPage.clickMiCuenta();
            registerPage.clickRegistrar();
            Assertions.assertEquals(registerPage.obtenerTituloRegistro(), "Account");
            test.log(Status.PASS, "Ingreso a la página de Registro");

            registerPage.escribirNombre("Carla Gisele");
            registerPage.escribirApellido("Antonini");
            registerPage.escribirMail("carla.antonini.goitre3@hotmail.com");
            registerPage.escribirTelefono("1161112222");
            registerPage.escribirContrasenia("123456");
            registerPage.escribirConfirmarContrasenia("123456");

            //registerPage.clickSuscripcionNoticias();
            registerPage.clickAceptarPoliticasPrivacidad();

            test.log(Status.PASS, "Completo los datos de registro de forma correcta");

            registerPage.clickRegistrarse();
            Assertions.assertTrue(registerPage.obtenerMensajeExito().startsWith("Congratulations! Your new account has been successfully created!"));
            test.log(Status.PASS, "Obtener mensaje de éxito en registro");

            /*registerPage.clickContinuarLogin();
            test.log(Status.PASS, "Regreso a la página inicial");*/

        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }

    //TEST FALLIDO POR CAMPOS NO RELLENOS

    @Test
    @Tag("Registro")
    @Tag("ALL")
    public void RegistroFallidoTodosTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de registro fallido - Todos los campos vacios");
        test.log(Status.INFO, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(driver, wait);

        try {
            registerPage.clickMiCuenta();
            registerPage.clickRegistrar();
            Assertions.assertEquals(registerPage.obtenerTituloRegistro(), "Account");
            test.log(Status.PASS, "Ingreso a la página de Registro");

            registerPage.clickRegistrarse();
            test.log(Status.PASS, "Presiono el boton registrarse sin completar ningun campo");

            Assertions.assertEquals(registerPage.obtenerMensajeNombreObligatorio(), "First Name must be between 1 and 32 characters!");
            Assertions.assertEquals(registerPage.obtenerMensajeApellidoObligatorio(), "Last Name must be between 1 and 32 characters!");
            Assertions.assertEquals(registerPage.obtenerMensajeCorreoObligatorio(), "E-Mail Address does not appear to be valid!");
            Assertions.assertEquals(registerPage.obtenerMensajeTelefonoObligatorio(), "Telephone must be between 3 and 32 characters!");
            Assertions.assertEquals(registerPage.obtenerMensajeContraseniaObligatorio(), "Password must be between 4 and 20 characters!");
            //Assertions.assertEquals(registerPage.obtenerMensajeConfirmarContraseniaObligatorio(),"Password confirmation does not match password!");

            Assertions.assertEquals(registerPage.obtenerMensajeAceptarPoliticas(),"Warning: You must agree to the Privacy Policy!");
            test.log(Status.PASS, "Valido que en todos los campos se vean los requerimientos obligatorios");

        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }

    // TEST FALLIDO POR EMAIL YA REGISTRADO
    @Test
    @Tag("Registro")
    @Tag("ALL")
    public void   RegistroMailRepetidoTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Crear una cuenta con un mail repetido");
        test.log(Status.INFO, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(driver, wait);

        try {
            registerPage.clickMiCuenta();
            registerPage.clickRegistrar();
            Assertions.assertEquals(registerPage.obtenerTituloRegistro(), "Account");
            test.log(Status.PASS, "Ingreso a la página de Registro");

            registerPage.escribirNombre("Carla Gisele");
            registerPage.escribirApellido("Antonini");
            registerPage.escribirMail("carla.antonini@hotmail.com");
            registerPage.escribirTelefono("1161112222");
            registerPage.escribirContrasenia("123456");
            registerPage.escribirConfirmarContrasenia("123456");

            registerPage.clickAceptarPoliticasPrivacidad();

            test.log(Status.PASS, "Completo los datos de registro de forma correcta, con un mail usado");

            registerPage.clickRegistrarse();
            test.log(Status.PASS, "Completo el registro");

            Assertions.assertEquals(registerPage.obtenerMensajeCorreoRepetido(), "Warning: E-Mail Address is already registered!");
            test.log(Status.PASS, "Valido no poder registrarme con un correo repetido");

            test.log(Status.PASS, "Regreso a la página inicial");

            driver.manage().deleteAllCookies();
            driver.navigate().refresh();
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }


    @AfterEach
    public void cerrar() {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}
