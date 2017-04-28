import processing.core.PApplet;
import processing.core.PImage;

public class SinCara extends Criatura implements NEncontrable {


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
	}

	public void cargar(PApplet app) {
		this.app = app;
		//Frontal
		criaturaFrontal = new PImage[19];
		for (int i = 0; i < criaturaFrontal.length; i++) {
			criaturaFrontal[i] = app.loadImage("../data/personajes/sinCaraFrontal/No Face_" + i + ".png");
		}
		//Izquierda
		criaturaIzq = new PImage[19];
		for (int i = 0; i < criaturaIzq.length; i++) {
			criaturaIzq[i] = app.loadImage("../data/personajes/sinCaraIzq/No Face Izq_" + i + ".png");
		}
		//Derecha
		criaturaDer = new PImage[19];
		for (int i = 0; i < criaturaDer.length; i++) {
			criaturaDer[i] = app.loadImage("../data/personajes/sinCaraDer/No Face Der_" + i + ".png");
		}
		//Posterior
		criaturaPosterior = new PImage[15];
		for (int i = 0; i < criaturaPosterior.length; i++) {
			criaturaPosterior[i] = app.loadImage("../data/personajes/sinCaraPosterior/No Face posterior_" + i + ".png");
		}
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
			numFrame++;
			if (numFrame >= 15) {
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
			app.image(criaturaFrontal[numFrame], posX, posY, criaturaFrontal[numFrame].width, criaturaFrontal[numFrame].height);
			break;
		case 1:
			app.image(criaturaDer[numFrame], posX, posY, criaturaDer[numFrame].width, criaturaDer[numFrame].height);
			break;
		case 2:
			app.image(criaturaIzq[numFrame], posX, posY, criaturaIzq[numFrame].width, criaturaIzq[numFrame].height);
			break;
		case 3:
			app.image(criaturaPosterior[numFrame], posX, posY, criaturaPosterior[numFrame].width, criaturaPosterior[numFrame].height);
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
		// TODO Auto-generated method stub

	}

}
