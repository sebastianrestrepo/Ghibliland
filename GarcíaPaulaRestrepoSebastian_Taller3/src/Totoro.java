import processing.core.PApplet;

public class Totoro extends Criatura implements BEncontrable {

	private int posX, posY, tam;
	
	/*
	 *  Constructor de Totoro
	 *  @parametro Mundo m
	 *  @parametro int posX
	 *	@parametro int posY
	 *  @parametro int tam
	 */
	public Totoro(Mundo m, int posX, int posY, int tam) {
		super(m, posX, posY, tam);
	}

	/*
	 *  Método que se encargará de pintar las secuencias de imagenes de los personajes 
	 *  @parametro PApplet app
	 *	@retorno void 
	 */
	public void pintar(PApplet app) {

	}

	/*
	 *  Método que no me acuerdo que llamará el método de calcular de distancia y bajo la condición de que este retorne true
	 *  llamará al método huir
	 *	@retorno void 
	 */
	public void encuentro() {
		// TODO Auto-generated method stub
		
	}
	
}
