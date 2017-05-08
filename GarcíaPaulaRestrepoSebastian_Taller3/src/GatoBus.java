import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class GatoBus implements Runnable {
	private PImage[] criatura, criaturaIz;
	private int numFrame;
	private PApplet app;
	private Mundo m;
	private ArrayList<Comida> comida;
	private ArrayList<Criatura> c;
	private boolean vivo;
	private boolean pausa;
	private int mover, dir;
	private float x, y;

	/*
	 * Constructor de GatoBus
	 * 
	 * @parametro int posX
	 * 
	 * @parametro int posY
	 * 
	 * @parametro int tam
	 */
	public GatoBus(float posX, float posY, int tam, Mundo m) {
		this.x = posX;
		this.y = posY;
		this.m = m;
		pausa = true;
		vivo = true;
		mover = 1;
	}

	@Override
	public void run() {
		while (vivo) {
			try {
				if (!pausa) {
					mover();
					reset();
				}
				Thread.sleep(33);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public void cargarCriatura(PApplet app) {
		this.app = app;
		criatura = new PImage[25];
		for (int i = 0; i < criatura.length; i++) {
			criatura[i] = app.loadImage("../data/GatoBusDe/GatobusDe_" + i + ".png");
		}

		criaturaIz = new PImage[25];
		for (int i = 0; i < criaturaIz.length; i++) {
			criaturaIz[i] = app.loadImage("../data/GatoBus Iz/GatobusIz_" + i + ".png");
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
		switch (mover) {

		case 1:
			app.image(criatura[numFrame], x, y, criatura[numFrame].width / 3 + 15, criatura[numFrame].height / 3 + 15);
			if (app.frameCount % 2 == 0) {
				numFrame++;
				if (numFrame >= criatura.length) {
					numFrame = 0;
				}
			}
			break;

		case 2:
			app.image(criaturaIz[numFrame], x, y, criaturaIz[numFrame].width / 3 + 15,
					criaturaIz[numFrame].height / 3 + 15);
			if (app.frameCount % 2 == 0) {
				numFrame++;
				if (numFrame >= criaturaIz.length) {
					numFrame = 0;
				}
			}
			break;
		}

	}

	public void mover() {
		switch (mover) {
		case 1:
			if (x < 800) {
				x += 7;
				y += 0.8;
			} else {
				mover = 2;
			}
			break;
		case 2:
			if (x > -150) {
				x -= 7;
				y += 0.8;
			} else {
				mover = 1;
			}
			break;
		}
	}

	public void reset() {

		//Eliminar criaturas y comida del GatoBus a su paso
		ArrayList<Criatura> refC = m.getCriaturas();
		for (int i = 0; i < refC.size(); i++) {
			Criatura ref = refC.get(i);
			if (PApplet.dist(x, y, ref.getPosX(), ref.getPosY()) < 80) {
				refC.remove(ref);
			}

		}

		ArrayList<Comida> refCo = m.getComida();
		for (int i = 0; i < refCo.size(); i++) {
			Comida ref = refCo.get(i);
			if (PApplet.dist(x, y, ref.getPosX(), ref.getPosY()) < 80) {
				refCo.remove(ref);
			}

		}

		//Eliminar todos los elementos del lienzo cuando el GatoBus sale
		//del mismo, de igual manera se reinician sus variables
		if (y > 760) {
			refCo.clear();
			refC.clear();
			x = -149;
			y = 100;
			pausa = true;
		}
	}


	// GETTERS Y SETTERS
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public boolean isPausa() {
		return pausa;
	}

	public void setPausa(boolean pausa) {
		this.pausa = pausa;
	}

	// ----------FINAL DE LA CLASE GATO BUS-----------//
}
