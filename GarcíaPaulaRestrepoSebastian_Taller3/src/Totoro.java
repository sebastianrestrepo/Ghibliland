import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Totoro extends Criatura implements BEncontrable {

	private int numFrame;

	/*
	 * Constructor de Totoro
	 * 
	 * @parametro Mundo m
	 * 
	 * @parametro int posX
	 * 
	 * @parametro int posY
	 * 
	 * @parametro int tam
	 */
	public Totoro(Mundo m, int posX, int posY, int tam) {
		super(m, posX, posY, tam);
	}

	public void cargar(PApplet app) {
		this.app = app;
		// Frontal
		criaturaFrontal = new PImage[14];
		for (int i = 0; i < criaturaFrontal.length; i++) {
			criaturaFrontal[i] = app.loadImage("../data/personajes/Totoro/TotoFrente/TotoF_" + i + ".png");
		}
		// Izquierda
		criaturaIzq = new PImage[14];
		for (int i = 0; i < criaturaIzq.length; i++) {
			criaturaIzq[i] = app.loadImage("../data/personajes/Totoro/TotoroIz/TotoroIz_" + i + ".png");
		}
		// Derecha
		criaturaDer = new PImage[14];
		for (int i = 0; i < criaturaDer.length; i++) {
			criaturaDer[i] = app.loadImage("../data/personajes/Totoro/TotoroDe/TotoroDe_" + i + ".png");
		}
		// Posterior
		criaturaPosterior = new PImage[14];
		for (int i = 0; i < criaturaPosterior.length; i++) {
			criaturaPosterior[i] = app.loadImage("../data/personajes/Totoro/TotoroEs/TotoroEs_" + i + ".png");
		}
	}

	@Override
	public void calculo() {
		switch (estado) {
		case 0:
			numFrame++;
			if (numFrame >= 14) {
				numFrame = 0;
			}
			break;
		case 1:
			numFrame++;
			if (numFrame >= 14) {
				numFrame = 0;
			}
			break;
		case 2:
			numFrame++;
			if (numFrame >= 14) {
				numFrame = 0;
			}
			break;
		case 3:
			numFrame++;
			if (numFrame >= 14) {
				numFrame = 0;
			}
			break;
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
		switch (estado) {
		case 0:
			app.image(criaturaFrontal[numFrame], posX, posY, criaturaFrontal[numFrame].width,
					criaturaFrontal[numFrame].height);
			break;
		case 1:
			app.image(criaturaDer[numFrame], posX, posY, criaturaDer[numFrame].width, criaturaDer[numFrame].height);
			break;
		case 2:
			app.image(criaturaIzq[numFrame], posX, posY, criaturaIzq[numFrame].width, criaturaIzq[numFrame].height);
			break;
		case 3:
			app.image(criaturaPosterior[numFrame], posX, posY, criaturaPosterior[numFrame].width,
					criaturaPosterior[numFrame].height);
			break;
		}

	}

	/*
	 * Método que llamará el método de calcular de distancia y bajo la condición
	 * de que este retorne true llamará al método huir
	 * 
	 * @retorno void
	 */
	public void encuentro() {
		ArrayList<Criatura> refCriaturas = m.getCriaturas();
		for (int i = 0; i < refCriaturas.size(); i++) {
			if (refCriaturas.get(i) instanceof NEncontrable) {
				if (calcularDistancia(refCriaturas.get(i))) {
					if (fuerza < refCriaturas.get(i).fuerza) {
						huir();
					}
					System.out.println("Fuerza Totoro: " + fuerza + " Fuerza Negro: " + refCriaturas.get(i).fuerza);
					System.out.println("huyeee");
				}
			}
		}
	}

	// FINAL DE LA CLASE TOTORO
}
