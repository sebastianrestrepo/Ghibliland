import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

/*
 * Ghibliland - Taller 3 DCA
 * Paula García
 * Sebastián Restrepo
 */

public class MainAppTaller3 extends PApplet {

	private Mundo m;
	private Minim minim;
	private AudioPlayer totosong;
	
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
		inicializarCancion();
	}
	
	public void inicializarCancion(){
		minim = new Minim(this);
		totosong =  minim.loadFile("../data/Song.mp3");
		totosong.loop();

	}

	@Override
	public void draw() {
		totosong.play();
		m.pintar();
	}

	@Override
	public void keyReleased() {
		m.teclas();
		if (mouseX >= 300 && mouseX <= 412 && mouseY >= 322 && mouseY <= 412) {
			System.out.println("true");
		}
	}
	
	public void mouseReleased(){
		println(mouseX, mouseY);
	}
	
}