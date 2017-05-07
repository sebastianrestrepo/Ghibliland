import processing.core.PApplet;
import processing.core.PImage;

public class Comida {
	
	private PApplet app;
	private int posX, posY, tam;
	private int comida;
	private Mundo m;
	private PImage estrellaAmarilla, estrellaAzul, estrellaRoja, estrellaRosa, estrellaVioleta;

	/*
	 *  Constructor de Comida 
	 *  @parametro int posX
	 *	@parametro int posY
	 *  @parametro int tam
	 */
	public Comida(Mundo m, int posX, int posY, int tam){
		this.posX = posX;
		this.posY = posY;
		this.tam = tam;
		this.m = m;
		estrellaAmarilla = m.getCargar().getEstrellaAmarilla();
		estrellaAzul = m.getCargar().getEstrellaAzul();
		estrellaVioleta= m.getCargar().getEstrellaVioleta();
		estrellaRosa = m.getCargar().getEstrellaRosa();
		comida = (int) (1+Math.random()*4);
	}
	
	/*
	 *  Método que se encargará de pintar las secuencias de imagenes de la comida de
	 *  forma random gracias al switch asociado a la variable entera 'comida'
	 *  @parametro PApplet app
	 *	@retorno void 
	 */
	public void pintar(PApplet app){
		this.app = app;
		switch(comida){
		case 1:
			app.image(estrellaAmarilla, posX, posY, tam, tam);
			break;
		case 2:
			app.image(estrellaAzul, posX, posY, tam, tam);
			break;
		case 3:
		    app.image(estrellaRosa, posX, posY, tam, tam);
			break;
		case 4:
			app.image(estrellaVioleta, posX, posY, tam, tam);
			break;
		}
	}
	
	public int getPosX() {
		return posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
}
