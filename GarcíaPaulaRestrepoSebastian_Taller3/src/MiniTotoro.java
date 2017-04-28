import processing.core.PApplet;
import processing.core.PImage;

public class MiniTotoro extends Criatura implements BEncontrable {

	/*
	 *  Constructor de MiniTotoro
	 *  @parametro Mundo m
	 *  @parametro int posX
	 *	@parametro int posY
	 *  @parametro int tam
	 */
	
	private int numFrameCuatro;
	
	public MiniTotoro(Mundo m, int posX, int posY, int tam) {
		super(m, posX, posY, tam);
		numFrameCuatro = 4;
	}

	public void cargar(PApplet app) {
		this.app= app;
		//Frontal
		criaturaFrontal = new PImage[15];
		for (int i = 4; i < criaturaFrontal.length; i++) {
			criaturaFrontal[i] = app.loadImage("../data/personajes/Minitoto/MiniTotoF/MinitotoF_" + i + ".png");
		}
		//Izquierda
		criaturaIzq = new PImage[11];
		for (int i = 0; i < criaturaIzq.length; i++) {
			criaturaIzq[i] = app.loadImage("../data/personajes/Minitoto/MiniTotoIz/MiniTotoIz_" + i + ".png");
		}
		//Derecha
		criaturaDer = new PImage[11];
		for (int i = 0; i < criaturaDer.length; i++) {
			criaturaDer[i] = app.loadImage("../data/personajes/Minitoto/MiniTotoDe/MinitotoDe_" + i + ".png");
		}
		//Posterior
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
	 *  Método que se encargará de pintar las secuencias de imagenes de los personajes 
	 *  @parametro PApplet app
	 *	@retorno void 
	 */
	public void pintar(PApplet app) {
		this.app = app;
		switch (estado) {
		case 0:
			app.image(criaturaFrontal[numFrameCuatro], posX, posY, criaturaFrontal[numFrameCuatro].width, criaturaFrontal[numFrameCuatro].height);
			break;
		case 1:
			app.image(criaturaDer[numFrame], posX, posY, criaturaDer[numFrame].width, criaturaDer[numFrame].height);
			break;
		case 2:
			app.image(criaturaIzq[numFrame], posX, posY, criaturaIzq[numFrame].width, criaturaIzq[numFrame].height);
			break;
		case 3:
			app.image(criaturaPosterior[numFrameCuatro], posX, posY, criaturaPosterior[numFrameCuatro].width, criaturaPosterior[numFrameCuatro].height);
			break;
		}
	
	}
	/*
	 *  Método que llamará el método de calcular de distancia y bajo la condición de que este retorne true
	 *  llamará al método huir
	 *	@retorno void 
	 */
	public void encuentro() {
		// TODO Auto-generated method stub

	}

}
