import processing.core.PApplet;

/*
 * Ghibliland - Taller 3 DCA
 * Paula García
 * Sebastián Restrepo
 */

public class MainAppTaller3 extends PApplet {

	private Mundo m;

	// hey!
	// :3

	public static void main(String[] args) {
		PApplet.main("MainAppTaller3");
	}

	@Override
	public void settings() {
		size(700, 700);
	}

	@Override
	public void setup() {
		m = new Mundo(this);
		m.cargarImagenes();
	}

	@Override
	public void draw() {
		m.pantallas();
	}

	@Override
	public void keyReleased() {
		m.teclas();
	}

}
