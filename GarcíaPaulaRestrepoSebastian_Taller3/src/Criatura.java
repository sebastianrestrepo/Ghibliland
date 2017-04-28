import processing.core.PApplet;
import processing.core.PImage;

public abstract class Criatura implements Runnable {

	protected PApplet app;
	protected int estado;
	protected int posX, posY, tam;
	protected int fuerza;
	protected int ritmo;
	protected Mundo m;
	protected PImage[] criaturaFrontal, criaturaDer, criaturaIzq, criaturaPosterior;
	protected int numFrame;
	protected boolean vivo;
	protected boolean huyendo;

	/*
	 * Constructor de Criatura
	 * 
	 * @parametro Mundo m
	 * 
	 * @parametro int posX
	 * 
	 * @parametro int posY
	 * 
	 * @parametro int tam
	 */
	public Criatura(Mundo m, int posX, int posY, int tam) {
		this.m = m;
		this.posX = posX;
		this.posY = posY;
		this.tam = tam;
		vivo = true;
		estado = 0;
		ritmo = 66;
	}

	@Override
	public void run() {
		while (vivo) {
			try {
				calculo();
				mover();
				Thread.sleep(ritmo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	/*
	 * Método que se encargará de cargar las secuencias de imagenes de los
	 * personajes
	 * 
	 * @retorno void
	 */
	public abstract void cargar(PApplet app);

	/*
	 * Método que se encargará de pintar las secuencias de imagenes de los
	 * personajes
	 * 
	 * @retorno void
	 */
	public abstract void calculo();

	/*
	 * Método que se encargará de pintar las secuencias de imagenes de los
	 * personajes
	 * 
	 * @parametro PApplet app
	 * 
	 * @retorno void
	 */
	public abstract void pintar(PApplet app);

	/*
	 * Método que contendrá un switch asociado a un número random que definirá
	 * movimientos en cuatro direcciones difentes con base al random estado. Se
	 * llamará en el hilo (run)
	 * 
	 * @retorno void
	 */
	public void mover() {
		switch (estado) {
		case 0:
			posY += 2;
			break;
		case 1:
			posX += 2;
			break;
		case 2:
			posX -= 2;
			break;
		case 3:
			posY -= 2;
			break;
		}
	}

	/*
	 * La variable entera 'estado' cambia cada cierto tiempo definido por el
	 * frameCount
	 * 
	 * @retorno void
	 */
	public void cambioEstado(PApplet app) {
		this.app = app;
		if (app.frameCount % 750 == 0) {
			estado = (int) (1 + Math.random() * 3);
			System.out.println(estado);
		}
	}

	/*
	 * Método que al ser llamado aumente la variable de ritmo y haga que el hilo
	 * se ejecute más rápido para que el personaje huya, adicionalmente activará
	 * la variable huyendo a true.
	 * 
	 * @retorno void
	 */
	public void huir() {

	}

	/*
	 * Método que no me acuerdo que llamará el método de calcular de distancia y
	 * bajo la condición de que este retorne true llamará al método huir
	 * 
	 * @retorno void
	 */
	public abstract void encuentro();

	/*
	 * Método que se encarga de comprobar cuando una criatura está a punto de
	 * salir del lienzo, y a base de condiciones hacerla devolver a la dirección
	 * contraria a la que venía, solo sucederá mientras el boolean 'huyendo' sea
	 * false
	 * 
	 * @retorno void
	 */
	public void devuelvis() {

	}

	/*
	 * Método que se encarga de definir que cuando una criatura pasé por encima
	 * de la comida, esta se sume a su contador interno de fuerza y además haga
	 * aumentar su tamaño como feedback de que es más fuerte
	 * 
	 * @retorno void
	 */
	public void comer() {

	}

	/*
	 * Método que se encarga de calcular la distancia de las criaturas por medio
	 * del método estático dist y que retornara true cuando dos criaturas estén
	 * muy cerca. Se llamará en el huir
	 * 
	 * @retorno boolean
	 */
	public boolean calcularDistancia(Criatura ref) {
		return true;
	}

	// FINAL DE LA CLASE CRIATURA
}
