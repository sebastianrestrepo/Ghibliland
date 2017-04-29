import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Kodama extends Criatura implements BEncontrable {

	private int numFrame, numFrameDer, numFrameIzq, numFramePost;

	/*
	 * Constructor de Kodama
	 * 
	 * @parametro Mundo m
	 * 
	 * @parametro int posX
	 * 
	 * @parametro int posY
	 * 
	 * @parametro int tam
	 */
	public Kodama(Mundo m, int posX, int posY, int tam) {
		super(m, posX, posY, tam);

		numFrameDer = 3;
	}

	public void cargar(PApplet app) {
		this.app = app;
		// Frontal
		criaturaFrontal = new PImage[33];
		for (int i = 0; i < criaturaFrontal.length; i++) {
			criaturaFrontal[i] = app.loadImage("../data/personajes/Kodama/KodamaF/KodamaF_" + i + ".png");
		}
		// Izquierda
		criaturaIzq = new PImage[39];
		for (int i = 0; i < criaturaIzq.length; i++) {
			criaturaIzq[i] = app.loadImage("../data/personajes/Kodama/KodamaIz/KodamaIz_" + i + ".png");
		}
		// Derecha
		criaturaDer = new PImage[36];
		for (int i = 3; i < criaturaDer.length; i++) {
			criaturaDer[i] = app.loadImage("../data/personajes/Kodama/KodamaDe/KodamaDe_" + i + ".png");
		}
		// Posterior
		criaturaPosterior = new PImage[33];
		for (int i = 0; i < criaturaPosterior.length; i++) {
			criaturaPosterior[i] = app.loadImage("../data/personajes/Kodama/KodamaEs/KodamaEs_" + i + ".png");
		}
	}

	@Override
	public void calculo() {
		switch (estado) {
		// frente
		case 0:
			numFrame++;
			if (numFrame >= 33) {
				numFrame = 0;
			}
			break;
		// Derecha
		case 1:
			numFrameDer++;
			if (numFrameDer >= 36) {
				numFrameDer = 3;
			}
			break;
		// Iz
		case 2:
			numFrameIzq++;
			if (numFrameIzq >= 39) {
				numFrameIzq = 0;
			}
			break;
		// posterior
		case 3:
			numFramePost++;
			if (numFramePost >= 33) {
				numFramePost = 0;
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
			// System.out.println("numFrame: " + numFrame);
			app.image(criaturaFrontal[numFrame], posX, posY, criaturaFrontal[numFrame].width,
					criaturaFrontal[numFrame].height);
			break;
		case 1:
			app.image(criaturaDer[numFrameDer], posX, posY, criaturaDer[numFrameDer].width,
					criaturaDer[numFrameDer].height);
			break;
		case 2:
			app.image(criaturaIzq[numFrameIzq], posX, posY, criaturaIzq[numFrameIzq].width,
					criaturaIzq[numFrameIzq].height);
			break;
		case 3:
			// System.out.println("numFramePost: " + numFramePost);
			app.image(criaturaPosterior[numFramePost], posX, posY, criaturaPosterior[numFramePost].width,
					criaturaPosterior[numFramePost].height);
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
					System.out.println("Fuerza Kodama: " + fuerza + " Fuerza Negro: " + refCriaturas.get(i).fuerza);
					System.out.println("huyeee");
				}
			}
		}
	}

	// FINAL DE LA CLASE KODAMA
}