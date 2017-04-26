import java.util.ArrayList;
import processing.core.PApplet;
import processing.core.PImage;

public class Mundo {

	private PApplet app;
	private int pantallas;
	private PImage fondoInicio, instrucciones;
	private ArrayList<Criatura> criaturas;
	private ArrayList<Comida> comida;
	private GatoBus gatobus;

	/*
	 * Constructor de Mundo
	 * 
	 * @parametro PApplet app
	 */
	public Mundo(PApplet app) {
		this.app = app;
		app.imageMode(app.CENTER);
	}

	/*
	 * Método que se encargará de cargar las imagenes de las pantallas
	 * 
	 * @retorno void
	 */
	public void cargarImagenes() {
		fondoInicio = app.loadImage("fondoInicio.png");
		instrucciones = app.loadImage("instrucciones.png");
	}

	/*
	 * Método que se encargará de iniciar todas las variables y listas
	 * 
	 * @retorno void
	 */
	public void iniciarVariables() {

	}

	/*
	 * Método que se encargará de iniciar y encapsular los Hilos
	 * 
	 * @retorno void
	 */
	public void iniciarHilos() {

	}

	/*
	 * Método que se encargará de llamar a todos los pintar que vienen de las
	 * otras clases y que será llamado en el Ejectuable en el draw
	 * 
	 * @retorno void
	 */
	public void pintar() {

	}

	/*
	 * Método que se encargará de los eventos del teclado otras clases y que
	 * será llamado en el Ejectuable en el keyReleased
	 * 
	 * @retorno void
	 */
	public void teclas() {
		switch (pantallas) {
		case 0:
			if(app.keyCode == app.ENTER){
				pantallas = 1;
			}
			break;
		case 1:
			if(app.keyCode == app.ENTER){
				pantallas = 2;
			}
			break;
		case 2:
			app.background(0);
			break;
		}
	}

	/*
	 * Método que se contendrá un switch que definirá los cambios pantallas
	 * 
	 * @retorno void
	 */
	public void pantallas() {
		switch (pantallas) {
		case 0:
			app.image(fondoInicio, app.width/2, app.height/2);
			break;
		case 1:
			app.image(fondoInicio, app.width/2, app.height/2);
			app.image(instrucciones, app.width/2, app.height/2);
			break;
		case 2:
			app.background(0);
			break;
		}
	}

	/*
	 * Método que se removerá del ArrayList al elementos que esté huyendo justo
	 * en el momento en que salda de la pantalla, lo sabrá por medio del boolean
	 * 'huyendo'.
	 * 
	 * @retorno void
	 */
	public void remover() {

	}

	// GETTERS Y SETTERS
	public ArrayList<Criatura> getCriaturas() {
		return criaturas;
	}

	public void setCriaturas(ArrayList<Criatura> criaturas) {
		this.criaturas = criaturas;
	}

	public ArrayList<Comida> getComida() {
		return comida;
	}

	public void setComida(ArrayList<Comida> comida) {
		this.comida = comida;
	}

}
