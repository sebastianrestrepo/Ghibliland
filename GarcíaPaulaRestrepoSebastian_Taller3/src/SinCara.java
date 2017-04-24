import processing.core.PApplet;

public class SinCara extends Criatura implements NEncontrable {

	private int posX, posY, tam;
	
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

	/*
	 *  Método que se encargará de pintar las secuencias de imagenes de los personajes 
	 *  @parametro PApplet app
	 *	@retorno void 
	 */
	public void pintar(PApplet app) {
		// TODO Auto-generated method stub

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
