import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class GatoBus implements Runnable{
	private PImage[] criatura;
	private int numFrame;
	private PApplet app;
	private Mundo m;
	private ArrayList<Comida> comida;
	private ArrayList<Criatura> c;
	private boolean reset;
	private boolean vivo;

	private int x, y;

	/*
	 * Constructor de GatoBus
	 * 
	 * @parametro int posX
	 * 
	 * @parametro int posY
	 * 
	 * @parametro int tam
	 */
	public GatoBus(int posX, int posY, int tam, Mundo m, boolean reset) {
		this.x = posX;
		this.y = posY;
		this.m = m;
		this.reset= reset;
		vivo= true;
	}

	public void cargarCriatura(PApplet app) {
		this.app = app;
		criatura = new PImage[25];
		for (int i = 0; i < criatura.length; i++) {
			criatura[i] = app.loadImage("../data/GatoBusDe/GatobusDe_" + i + ".png");
		}
	}

	/*
	 * Método que se encargará de pintar las secuencias de imagenes de los
	 * personajes
	 * 
	 * @parametro PApplet app
	 * 
	 * @retorno void
	 */
	public void pintar(PApplet app) {
		this.app = app;
		app.image(criatura[numFrame], x, y, criatura[numFrame].width / 3 + 15, criatura[numFrame].height / 3 + 15);
		if (app.frameCount % 2 == 0) {
			numFrame++;
			if (numFrame >= criatura.length) {
				numFrame = 0;
			}
		}

	}

	@Override
	public void run() {
		while (vivo) {
			try {
				mover();
				reset();
			//	System.out.println("reseteandooooo");
				Thread.sleep(33);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}		
	}
	public void mover() {
		if (x >= -150) {
			x += 3;
			 if (x >= app.width + 150) {
					x = -150;
				}
		}
	}

	public void reset() {

		ArrayList<Criatura> refC = m.getCriaturas();
		for (int i = 0; i < refC.size(); i++) {
			Criatura ref = refC.get(i);
			if (PApplet.dist(x, y, ref.getPosX(), ref.getPosY()) < 110) {
				refC.remove(ref);
			}
		}
		
		ArrayList<Comida> refCo = m.getComida();
		for (int i = 0; i < refCo.size(); i++) {
			Comida ref = refCo.get(i);
			if (PApplet.dist(x, y, ref.getPosX(), ref.getPosY()) < 110) {
				refCo.remove(ref);
			}
		}
	}

	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
