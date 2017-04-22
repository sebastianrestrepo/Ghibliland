import processing.core.PApplet;

public abstract class Criatura implements Runnable {

	protected int estado;
	protected int posX, posY, tam;
	protected int fuerza;
	protected int ritmo;
	protected boolean vivo;
	protected boolean huyendo;
	
	public Criatura(int posX, int posY, int tam){
		
	}

	public abstract void pintar(PApplet app);
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
	}
	
	public void mover(){
		//Switch
	}
	
	
	public void huir(){
		
	}
	
	public abstract void encuentro();
	
	
	public void devuelvis(){
		
	}
	
	public void comer(){
		
	}
	
	public boolean calcularDistancia(Criatura ref){
		return true;
	}
	
}
