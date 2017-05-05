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
		criaturaFrontal = m.getCargar().getCriaturaFrontalTotoro();
		criaturaDer = m.getCargar().getCriaturaDerTotoro();
		criaturaIzq = m.getCargar().getCriaturaIzqTotoro();
		criaturaPosterior = m.getCargar().getCriaturaPosteriorTotoro();
	}

	public void cargar(PApplet app) {
		this.app = app;

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
			app.image(criaturaFrontal[numFrame], posX, posY, criaturaFrontal[numFrame].width/2 + tam,
					criaturaFrontal[numFrame].height /2 + tam);
			break;
		case 1:
			app.image(criaturaDer[numFrame], posX, posY, criaturaDer[numFrame].width/2 + tam, criaturaDer[numFrame].height/2 + tam);
			break;
		case 2:
			app.image(criaturaIzq[numFrame], posX, posY, criaturaIzq[numFrame].width/2 + tam, criaturaIzq[numFrame].height/2 + tam);
			break;
		case 3:
			app.image(criaturaPosterior[numFrame], posX, posY, criaturaPosterior[numFrame].width/2 + tam,
					criaturaPosterior[numFrame].height/2 + tam);
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