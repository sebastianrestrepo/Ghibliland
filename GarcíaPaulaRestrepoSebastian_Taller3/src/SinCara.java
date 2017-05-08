import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class SinCara extends Criatura implements NEncontrable {

	private int numFrame, numFramePost;

	/*
	 * Constructor de SinCara
	 * 
	 * @parametro Mundo m
	 * 
	 * @parametro int posX
	 * 
	 * @parametro int posY
	 * 
	 * @parametro int tam
	 */
	public SinCara(Mundo m, int posX, int posY, int tam) {
		super(m, posX, posY, tam);
		criaturaFrontal = m.getCargar().getCriaturaFrontalSinCara();
		criaturaDer = m.getCargar().getCriaturaDerSinCara();
		criaturaIzq = m.getCargar().getCriaturaIzqSinCara();
		criaturaPosterior = m.getCargar().getCriaturaPosteriorSinCara();
	}

	public void cargar(PApplet app) {
		this.app = app;

	}

	/*
	 * Método que se encargará de hacer los cálculos para pintar las secuencias
	 * de los personajes
	 * 
	 * @retorno void
	 */
	public void calculo() {
		switch (estado) {
		case 0:
			numFrame++;
			if (numFrame >= 19) {
				numFrame = 0;
			}
			break;
		case 1:
			numFrame++;
			if (numFrame >= 19) {
				numFrame = 0;
			}
			break;
		case 2:
			numFrame++;
			if (numFrame >= 19) {
				numFrame = 0;
			}
			break;
		case 3:
			numFramePost++;
			if (numFramePost >= 15) {
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
		//System.out.println("Tamaño SinCara" + tam);
		this.app = app;
		switch (estado) {
		case 0:
			/*
			 * System.out.println("LETERRITO: " + criaturaFrontal);
			 * app.println(criaturaFrontal); System.out.println("-----");
			 */
			app.image(criaturaFrontal[numFrame], posX, posY, criaturaFrontal[numFrame].width / 2 + tam,
					criaturaFrontal[numFrame].height / 2 + tam);

			break;
		case 1:
			app.image(criaturaDer[numFrame], posX, posY, criaturaDer[numFrame].width / 2 + tam,
					criaturaDer[numFrame].height / 2 + tam);
			break;
		case 2:
			app.image(criaturaIzq[numFrame], posX, posY, criaturaIzq[numFrame].width / 2 + tam,
					criaturaIzq[numFrame].height / 2 + tam);
			break;
		case 3:
			app.image(criaturaPosterior[numFramePost], posX, posY, criaturaPosterior[numFramePost].width / 2 + tam,
					criaturaPosterior[numFramePost].height / 2 + tam);
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
					System.out.println("Fuerza Sin Cara: " + fuerza + " Fuerza Blanco: " + refCriaturas.get(i).fuerza);
					System.out.println("huyeee");
				}
			}
		}
	}

	// FINAL DE LA CLASE SIN CARA
}