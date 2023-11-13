import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class RegisterPage extends BasePage{

    private By titulo = By.xpath("//h1[normalize-space()='Account']");
    private By nombre = By.id("input-firstname");
    private By apellido = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");

    private By contrasenia = By.id("input-password");
    private By confirmacionDeContrasenia = By.id("input-confirm");

   // private By suscribirseOpcion = By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input");
    private  By privacidadBotonAceptacion = By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");

    private By continueBtn = By.className("btn-primary");

    //private By continuarBoton = By.xpath("//a[text()='Continue']");
    private By mensajeRegistroExitoso = By.xpath("//*[@id=\"content\"]/p[1]");


    public RegisterPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String obtenerTituloRegistro() throws InterruptedException {
        System.out.println("Me encuentro en la página de Registro: " + getText(titulo));
        return this.getText(titulo);
    }

    public void escribirNombre(String name) throws InterruptedException {
        sendText(name, nombre);
    }

    public void escribirApellido(String lastName) throws InterruptedException {
        sendText(lastName, apellido);
    }

    public void escribirMail(String mail) throws InterruptedException {
        sendText(mail, email);
    }

    public void escribirTelefono(String telefono) throws InterruptedException {
        sendText(telefono, telephone);
    }


    public void escribirContrasenia(String clave) throws InterruptedException {
        sendText(clave, contrasenia);
    }

    public void escribirConfirmarContrasenia(String clave) throws InterruptedException {
        sendText(clave, confirmacionDeContrasenia);
    }

    public void clickAceptarPoliticasPrivacidad () throws InterruptedException{
        click(privacidadBotonAceptacion);
    }

    public void clickRegistrarse() throws InterruptedException {
        click(continueBtn);
    }


    public String obtenerMensajeExito() throws InterruptedException {
        System.out.println("RESULTADO DE LA BUSQUEDA: " + this.getText(mensajeRegistroExitoso));
        return this.getText(mensajeRegistroExitoso);
    }

}
