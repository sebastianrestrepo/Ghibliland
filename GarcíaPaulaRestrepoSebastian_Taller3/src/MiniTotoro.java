import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class MiniTotoro extends Criatura implements BEncontrable {

	private int numFrame;

	/*
	 * Constructor de MiniTotoro
	 * 
	 * @parametro Mundo m
	 * 
	 * @parametro int posX
	 * 
	 * @parametro int posY
	 * 
	 * @parametro int tam
	 */

	private int numFrameCuatro;

	public MiniTotoro(Mundo m, int posX, int posY, int tam) {
		super(m, posX, posY, tam);

		numFrameCuatro = 4;
	}

	public void cargar(PApplet app) {
		this.app = app;
		// Frontal
		criaturaFrontal = new PImage[15];
		for (int i = 4; i < criaturaFrontal.length; i++) {
			criaturaFrontal[i] = app.loadImage("../data/personajes/Minitoto/MiniTotoF/MinitotoF_" + i + ".png");
		}
		// Izquierda
		criaturaIzq = new PImage[11];
		for (int i = 0; i < criaturaIzq.length; i++) {
			criaturaIzq[i] = app.loadImage("../data/personajes/Minitoto/MiniTotoIz/MiniTotoIz_" + i + ".png");
		}
		// Derecha
		criaturaDer = new PImage[11];
		for (int i = 0; i < criaturaDer.length; i++) {
			criaturaDer[i] = app.loadImage("../data/personajes/Minitoto/MiniTotoDe/MinitotoDe_" + i + ".png");
		}
		// Posterior
		criaturaPosterior = new PImage[15];
		for (int i = 4; i < criaturaPosterior.length; i++) {
			criaturaPosterior[i] = app.loadImage("../data/personajes/Minitoto/MiniTotoEs/MinitotoEs_" + i + ".png");
		}
	}

	@Override
	public void calculo() {
		switch (estado) {

		case 0:
			numFrameCuatro++;
			if (numFrameCuatro >= 15) {
				numFrameCuatro = 4;
			}
			break;
		case 1:
			numFrame++;
			if (numFrame >= 11) {
				numFrame = 0;
			}
			break;
		case 2:
			numFrame++;
			if (numFrame >= 11) {
				numFrame = 0;
			}
			break;
		case 3:
			numFrameCuatro++;
			if (numFrameCuatro >= 15) {
				numFrameCuatro = 4;
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
			app.image(criaturaFrontal[numFrameCuatro], posX, posY,  criaturaFrontal[numFrameCuatro].width/2+ tam,
					criaturaFrontal[numFrameCuatro].height/2+ tam);
			break;
		case 1:
			app.image(criaturaDer[numFrame], posX, posY, criaturaDer[numFrame].width/2+ tam,
					criaturaDer[numFrame].height/2+ tam);
			break;
		case 2:
			app.image(criaturaIzq[numFrame], posX, posY, criaturaIzq[numFrame].width/2+ tam,
					criaturaIzq[numFrame].height/2+ tam);
			break;
		case 3:
			app.image(criaturaPosterior[numFrameCuatro], posX, posY, criaturaPosterior[numFrameCuatro].width/2+tam,
					criaturaPosterior[numFrameCuatro].height/2+ tam);
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
					System.out
							.println("Fuerza Mini Totoro: " + fuerza + " Fuerza Negro: " + refCriaturas.get(i).fuerza);
					System.out.println("huyeee");
				}
			}
		}
	}

	// FINAL DE LA CLASE MINI TOTORO
}
