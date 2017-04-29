import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public abstract class Criatura implements Runnable {

	protected PApplet app;
	protected int estado;
	protected int posX, posY, tam;
	protected int fuerza;
	protected int ritmo;
	protected ArrayList<Comida> c;
	protected Mundo m;
	protected PImage[] criaturaFrontal, criaturaDer, criaturaIzq, criaturaPosterior;
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
		huyendo = false;
		ritmo = 66;
	}

	@Override
	public void run() {
		while (vivo) {
			try {
				calculo();
				mover();
				if (!huyendo) {
					devuelvis();
				}
				encuentro();
				remover();
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
		// Hacia abajo
		case 0:
			posY += 2;
			break;
		// Derecha
		case 1:
			posX += 2;
			break;
		// Izquierda
		case 2:
			posX -= 2;
			break;
		// Arriba
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
		huyendo = true;
		ritmo = 10;
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
		// abajo
		if (estado == 0 && posY >= app.height - 90) {
			estado = 0;
		}
		// derecha
		if (estado == 1 && posX >= app.width - 90) {
			estado = 2;
		}
		// izquierda
		if (estado == 2 && posX <= 90) {
			estado = 3;
		}
		// arriba
		if (estado == 3 && posY <= 90) {
			estado = 0;
		}
	}

	/*
	 * Método que se encarga de definir que cuando una criatura pasé por encima
	 * de la comida, esta se sume a su contador interno de fuerza y además haga
	 * aumentar su tamaño como feedback de que es más fuerte
	 * 
	 * @retorno void
	 */
	public void comer(ArrayList<Comida> c) {
		this.c = c;
		for (int i = 0; i < c.size(); i++) {
			if (PApplet.dist(posX, posY, c.get(i).getPosX(), c.get(i).getPosY()) < 50) {
				System.out.println("comioooooooo");
				fuerza += 1;
				c.remove(i);
			}
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
		ArrayList<Criatura> refCriaturas = m.getCriaturas();
		for (int i = 0; i < refCriaturas.size(); i++) {
			Criatura ref = refCriaturas.get(i);
			if (huyendo) {
				if (ref.getPosX() < -30 || ref.getPosX() > 630 || ref.getPosY() < -30 || ref.getPosY() > 630) {
					refCriaturas.remove(ref);
					System.out.println(refCriaturas);
				}
			}
		}
	}

	/*
	 * Método que se encarga de calcular la distancia de las criaturas por medio
	 * del método estático dist y que retornara true cuando dos criaturas estén
	 * muy cerca. Se llamará en el huir
	 * 
	 * @retorno boolean
	 */
	public boolean calcularDistancia(Criatura ref) {
		return PApplet.dist(posX, posY, ref.getPosX(), ref.getPosY()) < 20;
	}

	public boolean calcularDistanciaComida() {
		return true;
	}
	// FINAL DE LA CLASE CRIATURA

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
}
