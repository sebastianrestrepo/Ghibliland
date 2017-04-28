import processing.core.PApplet;
import processing.core.PImage;

public class Kodama extends Criatura implements BEncontrable {

	
	/*
	 *  Constructor de Kodama
	 *  @parametro Mundo m
	 *  @parametro int posX
	 *	@parametro int posY
	 *  @parametro int tam
	 */
	public Kodama(Mundo m, int posX, int posY, int tam) {
		super(m, posX, posY, tam);
	}

	public void cargar(PApplet app) {
		this.app= app;
		//Frontal
		criaturaFrontal = new PImage[33];
		for (int i = 0; i < criaturaFrontal.length; i++) {
			criaturaFrontal[i] = app.loadImage("../data/personajes/Kodama/KodamaF/KodamaF_" + i + ".png");
		}
		//Izquierda
		criaturaIzq = new PImage[39];
		for (int i = 0; i < criaturaIzq.length; i++) {
			criaturaIzq[i] = app.loadImage("../data/personajes/Kodama/KodamaIz/KodamaIz_" + i + ".png");
		}
		//Derecha
		criaturaDer = new PImage[36];
		for (int i = 3; i < criaturaDer.length; i++) {
			criaturaDer[i] = app.loadImage("../data/personajes/Kodama/KodamaDe/KodamaDe_" + i + ".png");
		}
		//Posterior
		criaturaPosterior = new PImage[33];
		for (int i = 0; i < criaturaPosterior.length; i++) {
			criaturaPosterior[i] = app.loadImage("../data/personajes/Kodama/KodamaEs/KodamaEs_" + i + ".png");
		}
	}
	
	@Override
	public void calculo() {
		switch (estado) {
		//frente
		case 0:
			numFrame++;
			if (numFrame >= 33) {
				numFrame = 0;
			}
			break;
			//Derecha
		case 1:
			numFrame++;
			if (numFrame >= 36) {
				numFrame = 3;
			}
			break;
			//Iz
		case 2:
			numFrame++;
			if (numFrame >= 39) {
				numFrame = 0;
			}
			break;
			//posterior
		case 3:
				numFrame++;
			if (numFrame >= 33) {
				numFrame = 0;
			}
			break;
		}
	}
	
	/*
	 *  Método que se encargará de pintar las secuencias de imagenes de los personajes 
	 *  @parametro PApplet app
	 *	@retorno void 
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
	 *  Método que llamará el método de calcular de distancia y bajo la condición de que este retorne true
	 *  llamará al método huir
	 *	@retorno void 
	 */
	public void encuentro() {

	}

}
