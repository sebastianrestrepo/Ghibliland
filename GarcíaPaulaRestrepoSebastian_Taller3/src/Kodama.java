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
		criaturaFrontal = m.getCargar().getCriaturaFrontalKodama();
		criaturaDer = m.getCargar().getCriaturaDerKodama();
		criaturaIzq = m.getCargar().getCriaturaIzqKodama();
		criaturaPosterior = m.getCargar().getCriaturaPosteriorKodama();
	}

	public void cargar(PApplet app) {
		this.app = app;

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
			app.image(criaturaFrontal[numFrame], posX, posY, criaturaFrontal[numFrame].width/2+tam,
					criaturaFrontal[numFrame].height/2+tam);
			break;
		case 1:
			app.image(criaturaDer[numFrameDer], posX, posY,  criaturaDer[numFrameDer].width/2+tam,
					criaturaDer[numFrameDer].height/2+tam);
			break;
		case 2:
			app.image(criaturaIzq[numFrameIzq], posX, posY,  criaturaIzq[numFrameIzq].width/2 + tam,
					criaturaIzq[numFrameIzq].height/2+ tam);
			break;
		case 3:
			// System.out.println("numFramePost: " + numFramePost);
			app.image(criaturaPosterior[numFramePost], posX, posY, criaturaPosterior[numFramePost].width/2+ tam,
					criaturaPosterior[numFramePost].height/2+ tam);
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