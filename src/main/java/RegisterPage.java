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

    //private By suscribirseOpcion = By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[2]/input");

    private  By privacidadBotonAceptacion = By.xpath("//*[@id=\"content\"]/form/div/div/input[1]");

    private By continueBtn = By.className("btn-primary");

    private By continuarBoton = By.xpath("//a[text()='Continue']");
    //private By continuarBoton = By.xpath("//*[@id=\"content\"]/form/div/div/input[2]");

    private By mensajeRegistroExitoso = By.xpath("//*[@id=\"content\"]/p[1]");


    private By nombreObligatorio = By.xpath("//*[@id=\"account\"]/div[2]/div/div");
    private By apellidoObligatorio = By.xpath("//*[@id=\"account\"]/div[3]/div/div");
    private By mailObligatorio = By.xpath("//*[@id=\"account\"]/div[4]/div/div");
    private By telefonoObligatorio = By.xpath("//*[@id=\"account\"]/div[5]/div/div");
    private By contraseniaObligatorio = By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[1]/div/div");
    //private By confirmacionDeContraseniaObligatorio = By.xpath("//*[@id=\"content\"]/form/fieldset[2]/div[2]/div/div");



    private By mailRepetido = By.className("alert-danger");
    private By privacidadNoAceptada = By.className("alert-dismissible");

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


    // TEST FALLIDO POR CAMPOS NO RELLENOS

    public String obtenerMensajeNombreObligatorio() throws InterruptedException {
        System.out.println("Verificar Nombre: " + getText(nombreObligatorio));
        return this.getText(nombreObligatorio);
    }

    public String obtenerMensajeApellidoObligatorio() throws InterruptedException {
        System.out.println("Verificar Apellido: " + getText(apellidoObligatorio));
        return this.getText(apellidoObligatorio);
    }

    public String obtenerMensajeCorreoObligatorio() throws InterruptedException {
        System.out.println("Verificar Correo: " + getText(mailObligatorio));
        return this.getText(mailObligatorio);
    }

    public String obtenerMensajeTelefonoObligatorio() throws InterruptedException {
        System.out.println("Verificar Telefono: " + getText(telefonoObligatorio));
        return this.getText(telefonoObligatorio);
    }


    public String obtenerMensajeContraseniaObligatorio() throws InterruptedException {
        System.out.println("Verificar Contraseña: " + getText(contraseniaObligatorio));
        return this.getText(contraseniaObligatorio);
    }

    /*public String obtenerMensajeConfirmarContraseniaObligatorio() throws InterruptedException {
        System.out.println("Verificar Confirmación de Contraseña: " + getText(confirmacionDeContraseniaObligatorio));
        return this.getText(confirmacionDeContraseniaObligatorio);
    }*/


    public String obtenerMensajeAceptarPoliticas() throws InterruptedException {
        System.out.println("Verificar la aceptacion de las políticas de privacidad: " + getText(privacidadNoAceptada));
        return this.getText(privacidadNoAceptada);

    }
    public String obtenerMensajeCorreoRepetido() throws InterruptedException {
        System.out.println("Verificar el mensaje de correo repetido: " + getText(mailRepetido));
        return this.getText(mailRepetido);
    }



}
