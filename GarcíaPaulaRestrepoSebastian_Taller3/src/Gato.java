import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Gato extends Criatura implements NEncontrable {

	private int numFrame, numFrameDer, numFrameIzq, numFramePost;

	/*
	 * Constructor de Gato
	 * 
	 * @parametro Mundo m
	 * 
	 * @parametro int posX
	 * 
	 * @parametro int posY
	 * 
	 * @parametro int tam
	 */
	public Gato(Mundo m, int posX, int posY, int tam) {
		super(m, posX, posY, tam);
		// TODO Auto-generated constructor stub
	}

	public void cargar(PApplet app) {
		this.app = app;
		// Frontal
		criaturaFrontal = new PImage[29];
		for (int i = 0; i < criaturaFrontal.length; i++) {
			criaturaFrontal[i] = app.loadImage("../data/personajes/jiji/jijiFrontal/jijiFrontal_" + i + ".png");
		}
		// Izquierda
		criaturaIzq = new PImage[9];
		for (int i = 0; i < criaturaIzq.length; i++) {
			criaturaIzq[i] = app.loadImage("../data/personajes/jiji/jijiIzq/jijiIzq_" + i + ".png");
		}
		// Derecha
		criaturaDer = new PImage[9];
		for (int i = 0; i < criaturaDer.length; i++) {
			criaturaDer[i] = app.loadImage("../data/personajes/jiji/jijiDer/jijiDer_" + i + ".png");
		}
		// Posterior
		criaturaPosterior = new PImage[29];
		for (int i = 0; i < criaturaPosterior.length; i++) {
			criaturaPosterior[i] = app.loadImage("../data/personajes/jiji/jijiPosterior/jijiPosterior_" + i + ".png");
		}
	}

	@Override
	public void calculo() {
		switch (estado) {
		// frente
		case 0:
			numFrame++;
			if (numFrame >= 29) {
				numFrame = 0;
			}
			break;
		// Derecha
		case 1:
			numFrameDer++;
			if (numFrameDer >= 9) {
				numFrameDer = 0;
			}
			break;
		// Iz
		case 2:
			numFrameIzq++;
			if (numFrameIzq >= 9) {
				numFrameIzq = 0;
			}
			break;
		// posterior
		case 3:
			numFramePost++;
			if (numFramePost >= 29) {
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
			app.image(criaturaFrontal[numFrame], posX, posY, criaturaFrontal[numFrame].width/2 +25,
					criaturaFrontal[numFrame].height/2 +25);
			break;
		case 1:
			app.image(criaturaDer[numFrameDer], posX, posY, criaturaDer[numFrameDer].width/2 +25,
					criaturaDer[numFrameDer].height/2 +25);
			break;
		case 2:
			app.image(criaturaIzq[numFrameIzq], posX, posY, criaturaIzq[numFrameIzq].width/2 +25,
					criaturaIzq[numFrameIzq].height/2 +25);
			break;
		case 3:
			// System.out.println("numFramePost: " + numFramePost);
			app.image(criaturaPosterior[numFramePost], posX, posY, criaturaPosterior[numFramePost].width/2 +25,
					criaturaPosterior[numFramePost].height/2 +25);
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
			if (refCriaturas.get(i) instanceof BEncontrable) {
				if (calcularDistancia(refCriaturas.get(i))) {
					if (fuerza < refCriaturas.get(i).fuerza) {
						huir();
					}
					System.out.println("Fuerza Gato: " + fuerza + " Fuerza Blanco: " + refCriaturas.get(i).fuerza);
					System.out.println("huyeee");
				}
			}

		}
	}
	
//FINAL DE LA CLASE GATO
}
