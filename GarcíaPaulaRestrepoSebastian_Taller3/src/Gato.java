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
		criaturaFrontal = m.getCargar().getCriaturaFrontalGato();
		criaturaDer = m.getCargar().getCriaturaDerGato();
		criaturaIzq = m.getCargar().getCriaturaIzqGato();
		criaturaPosterior = m.getCargar().getCriaturaPosteriorGato();
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
			app.image(criaturaFrontal[numFrame], posX, posY, criaturaFrontal[numFrame].width/2 + tam,
					criaturaFrontal[numFrame].height/2 + tam);
			break;
		case 1:
			app.image(criaturaDer[numFrameDer], posX, posY, criaturaDer[numFrameDer].width/2 + tam,
					criaturaDer[numFrameDer].height/2 + tam);
			break;
		case 2:
			app.image(criaturaIzq[numFrameIzq], posX, posY, criaturaIzq[numFrameIzq].width/2 + tam,
					criaturaIzq[numFrameIzq].height/2 + tam);
			break;
		case 3:
			// System.out.println("numFramePost: " + numFramePost);
			app.image(criaturaPosterior[numFramePost], posX, posY, criaturaPosterior[numFramePost].width/2 +tam,
					criaturaPosterior[numFramePost].height/2 +tam);
			break;
		}
	}

	/*
	 * Método que llamará el método de calcular de distancia y bajo la condición
	 * de que este retorne true llamará al método huir siempre y cuando la criatura implemente
	 * la interfaz bandera que identifica al equipo contrario
	 * 
	 * @retorno void
	 */
	public void encuentro() {
		ArrayList<Criatura> refCriaturas = m.getCriaturas();
		for (int i = 0; i < refCriaturas.size(); i++) {
			if (refCriaturas.get(i) instanceof BEncontrable) {
				if (calcularDistancia(refCriaturas.get(i))) {
					if (fuerza <= refCriaturas.get(i).fuerza) {
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