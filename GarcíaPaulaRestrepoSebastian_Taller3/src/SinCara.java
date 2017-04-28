import processing.core.PApplet;
import processing.core.PImage;

public class SinCara extends Criatura implements NEncontrable {
	
	private int numFrame;
	
	/*
	 *  Constructor de SinCara
	 *  @parametro Mundo m
	 *  @parametro int posX
	 *	@parametro int posY
	 *  @parametro int tam
	 */
	public SinCara(Mundo m, int posX, int posY, int tam) {
		super(m, posX, posY, tam);
	}

	public void cargar(PApplet app) {
		this.app = app;
		criatura = new PImage[19];
		for (int i = 0; i < criatura.length; i++) {
			criatura[i] = app.loadImage("../data/personajes/sinCaraFrontal/No Face_" + i + ".png");
		}
	}
	
	/*
	 *  Método que se encargará de hacer los cálculos para pintar las secuencias de los personajes 
	 *	@retorno void
	 */
	public void calculo(){
		numFrame++;
		if (numFrame == criatura.length) {
			numFrame = 0;
		}	
	}
	
	/*
	 *  Método que se encargará de pintar las secuencias de imagenes de los personajes 
	 *  @parametro PApplet app
	 *	@retorno void 
	 */
	public void pintar(PApplet app) {
		this.app = app;
		app.image(criatura[numFrame], posX, posY, criatura[numFrame].width, criatura[numFrame].height);
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
