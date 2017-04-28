import processing.core.PApplet;
import processing.core.PImage;

public class GatoBus {
	private PImage [] criatura;
	private int numFrame;
	private PApplet app;
	
	private int x,y;
	/*
	 *  Constructor de GatoBus
	 *  @parametro int posX
	 *	@parametro int posY
	 *  @parametro int tam
	 */
	public GatoBus(int posX, int posY, int tam){
		this.x = posX;
		this.y = posY;
	}
	public void cargarCriatura(PApplet app) {
		this.app = app;
		criatura = new PImage[25];
		for (int i = 0; i < criatura.length; i++) {
			criatura[i] = app.loadImage("../data/GatoBusDe/GatobusDe_" + i + ".png");
		}		
	}

	/*
	 *  Método que se encargará de pintar las secuencias de imagenes de los personajes 
	 *  @parametro PApplet app
	 *	@retorno void 
	 */
	public void pintar(PApplet app){
		this.app = app;
			app.image(criatura[numFrame], x, y,criatura[numFrame].width/3, criatura[numFrame].height/3);
			if (app.frameCount % 2 == 0) {
				numFrame++;
				if (numFrame >= criatura.length) {
					numFrame = 0;
				}
			}
			if (x>=0) {
				x++;
			}
			
			if (x>=app.width) {
				x--;
			}
		
	}



	
}
