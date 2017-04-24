import processing.core.PApplet;

public class Gato extends Criatura implements NEncontrable {
            
	
	/*
	 *  Constructor de Gato 
	 *  @parametro Mundo m
	 *  @parametro int posX
	 *	@parametro int posY
	 *  @parametro int tam
	 */
	public Gato(Mundo m, int posX, int posY, int tam) {
		super(m, posX, posY, tam);
		// TODO Auto-generated constructor stub
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
	 *  Método que llamará el método de calcular de distancia y bajo la condición de que este retorne true
	 *  llamará al método huir
	 *	@retorno void 
	 */
	public void encuentro() {
		// TODO Auto-generated method stub

	}

}
