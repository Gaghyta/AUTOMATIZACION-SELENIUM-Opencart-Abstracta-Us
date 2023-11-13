import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage extends BasePage {

    private final By inputResultadosBuscador = By.name("search");
    private final By botonResultadosBuscador = By.className("input-group-btn");
    private final By botonAgregarAlCarrito = By.xpath("//*[@id=\"content\"]/div[3]/div/div/div[2]/div[2]/button[1]");
    private final By mensajeDeConfirmacion = By.className("alert-success");


    public SearchPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void ingresarProductoABuscar(String texto) throws InterruptedException {
        Thread.sleep(1000);
        sendText(texto,inputResultadosBuscador);
    }


    public void enviarProductoABuscar() throws InterruptedException {
        Thread.sleep(2000);
        click(botonResultadosBuscador);

    }

    public void clickAgregarAlCarrito() throws InterruptedException{
        Thread.sleep(1000);
        click(botonAgregarAlCarrito);

    }
    public String obtenerMensajeDeConfirmacion() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("RESULTADO DE LA BUSQUEDA: " + this.getText(mensajeDeConfirmacion));
        return this.getText(mensajeDeConfirmacion);
    }
}
