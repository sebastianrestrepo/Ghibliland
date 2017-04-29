import java.util.ArrayList;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PImage;

public class Mundo {

	private PApplet app;
	private int pantallas;
	private int equipoNegro, equipoBlanco;
	private PImage fondoInicio, instrucciones, fondoEsc, pasto;
	private PImage[] enterUno, enterDos, luces;
	private int numActual, numLuces;
	private ArrayList<Criatura> criaturas;
	private ArrayList<Thread> capsulas; // ArrayList para encapsular los hilos
										// de las criaturas
	private ArrayList<Comida> comida;
	private GatoBus gatobus;
	

	/*
	 * Constructor de Mundo
	 * 
	 * @parametro PApplet app
	 */
	public Mundo(PApplet app) {
		this.app = app;
		app.imageMode(app.CENTER);
		inicializarVariables();
		cargarComida();
		anadirComidaInicial();
		agregarCriaturasInicio();
	}
	/*
	 * Metodo que se encargara de iniciar todas las variables y listas
	 * 
	 * @retorno void
	 */
	public void inicializarVariables() {
		criaturas = new ArrayList<Criatura>();
		comida = new ArrayList<Comida>();
		gatobus = new GatoBus(0, app.height / 2, 50);
		capsulas = new ArrayList<Thread>();

	}

	/*
	 * Metodo que se encargara de iniciar todas las variables y listas
	 * 
	 * @retorno void
	 */
	public void agregarCriaturasInicio() {
		criaturas.add(new SinCara(this, app.width / 2 + 50, app.height / 3, 150));
		criaturas.add(new Duende(this, app.width / 2 - 50, app.height / 4, 30));
		criaturas.add(new Totoro(this, app.width / 2 +100, app.height / 4, 30));
		criaturas.add(new MiniTotoro(this, 200, 400, 30));
		criaturas.add(new Kodama(this, 150, app.height / 4, 30));
		for (int i = 0; i < criaturas.size(); i++) {
			capsulas.add(new Thread(criaturas.get(i)));
		}
	}

	/*
	 * Metodo que se encargara de añadir la comida que estará incialmene en el
	 * lienzo
	 * 
	 * @retorno void
	 */
	public void anadirComidaInicial() {
		for (int i = 0; i < 15; i++) {
			comida.add(new Comida((int) (30 + Math.random() * 560), (int) (30 + Math.random() * 560),
					(int) (15 + Math.random() * 25)));
		}
		
	
	}

	public void anadirEquipoNegro() {
		equipoNegro = (int) (1 + Math.random() * 2);
		System.out.println(equipoNegro);
		switch (equipoNegro) {
		case 1:
			criaturas.add(new SinCara(this, app.width / 2 + 50, app.height / 3, 150));
			break;
		case 2:
			criaturas.add(new Duende(this, app.width / 2 - 50, app.height / 4, 30));
			break;
		}
		for (int i = 0; i < criaturas.size(); i++) {
			capsulas.add(new Thread(criaturas.get(i)));
			if (capsulas.get(i).getState() == Thread.State.NEW) {
				capsulas.get(i).start();
			}
		}
	}

	/*
	 * Método que se encargará de iniciar y encapsular los Hilos
	 * 
	 * @retorno void
	 */
	public void iniciarHilos() {
		for (int i = 0; i < capsulas.size(); i++) {
			capsulas.get(i).start();
		}
	}

	/*
	 * Metodo que se encargara de cargar las imagenes de las pantalla
	 * 
	 * @retorno void
	 */
	public void cargarImagenes() {
		fondoInicio = app.loadImage("../data/fondoInicio.png");
		instrucciones = app.loadImage("../data/instrucciones.png");
		fondoEsc = app.loadImage("../data/escenario/fondo.png");
		pasto = app.loadImage("../data/escenario/pasto.png");
		cargarEnterUno();
		cargarEnterDos();
		cargarLuces();
		cargarCriaturas();
		cargarComida();
		gatobus.cargarCriatura(app);
	}

	/*
	 * Metodo que se encargara de cargar a todos los tipos de criaturas
	 * 
	 * @retorno void
	 */
	public void cargarCriaturas() {
		for (int i = 0; i < criaturas.size(); i++) {
			criaturas.get(i).cargar(app);
		}
	}

	public void cargarEnterUno() {
		enterUno = new PImage[23];
		for (int i = 0; i < enterUno.length; i++) {
			enterUno[i] = app.loadImage("../data/enterUno/ENTERUNO_" + i + ".png");
		}
	}

	public void cargarEnterDos() {
		enterDos = new PImage[23];
		for (int i = 0; i < enterUno.length; i++) {
			enterDos[i] = app.loadImage("../data/enterDos/ENTERDOS_" + i + ".png");
		}
	}

	public void cargarLuces() {
		luces = new PImage[15];
		for (int i = 0; i < luces.length; i++) {
			luces[i] = app.loadImage("../data/Luces/Luces_" + i + ".png");
		}
	}

	/*
	 * Metodo que se encargara de cargar las imagenes de la comida
	 * 
	 * @retorno void
	 */
	public void cargarComida() {
		for (int i = 0; i < comida.size(); i++) {
			comida.get(i).cargarComida(app);
		}
	}

	/*
	 * Metodo que se encargara de pintar la comida
	 * 
	 * @retorno void
	 */
	public void pintarComida() {
		for (int i = 0; i < comida.size(); i++) {
			comida.get(i).pintar(app);
		}
	}

	public void pintarLuces() {
		app.image(luces[numLuces], app.width / 2, app.height / 2);
		if (app.frameCount % 5 == 0) {
			numLuces++;
			if (numLuces >= luces.length) {
				numLuces = 0;
			}
		}
	}

	public void pintarEnterUno() {
		app.image(enterUno[numActual], app.width / 2, app.height / 2);
		if (app.frameCount % 5 == 0) {
			numActual++;
			if (numActual >= enterUno.length) {
				numActual = 0;
			}
		}
	}

	public void pintarEnterDos() {
		app.image(enterDos[numActual], app.width / 2, 454);
		if (app.frameCount % 5 == 0) {
			numActual++;
			if (numActual >= enterDos.length) {
				numActual = 0;
			}
		}
	}

	public void pintarCriaturas() {
		for (int i = 0; i < criaturas.size(); i++) {
			criaturas.get(i).pintar(app);
			
		}
		darDeComer();
	}
	
	//M�todo para pasarle el arraylist de comida a las criaturas
	public void darDeComer() {
		for (int i = 0; i < criaturas.size(); i++) {
			criaturas.get(i).comer(comida);
			
		}
	}
	public void cambioEstado() {
		for (int i = 0; i < criaturas.size(); i++) {
			criaturas.get(i).cambioEstado(app);
		}
	}

	/*
	 * Método que se encargará de llamar a todos los pintar que vienen de las
	 * otras clases y que será llamado en el Ejectuable en el draw
	 * 
	 * @retorno void
	 */
	public void pintar() {
		pantallas();
	}

	/*
	 * Método que se contendrá un switch que definirá los cambios pantallas
	 * 
	 * @retorno void
	 */
	public void pantallas() {
		
		switch (pantallas) {
		case 0:
			app.image(fondoInicio, app.width / 2, app.height / 2);
			pintarEnterUno();
			break;
		case 1:
			app.image(fondoInicio, app.width / 2, app.height / 2);
			app.image(instrucciones, app.width / 2, app.height / 2);
			pintarEnterDos();
			break;
		case 2:
			app.image(fondoEsc, app.width / 2, app.height / 2);
			app.image(pasto, app.width / 2, app.height / 2);
			pintarLuces();
			// pintarGato();
			pintarComida();
			cambioEstado();
			pintarCriaturas();
			
			break;
		}
	}

	
	public void pintarGato() {
		gatobus.pintar(app);
	}

	/*
	 * Método que se encargará de los eventos del teclado otras clases y que
	 * será llamado en el Ejectuable en el keyReleased
	 * 
	 * @retorno void
	 */
	public void teclas() {
		switch (pantallas) {
		case 0:
			if (app.keyCode == app.ENTER) {
				pantallas = 1;
			}
			break;
		case 1:
			if (app.keyCode == app.ENTER) {
				iniciarHilos();
				pantallas = 2;
			}
			break;
		case 2:
			if (app.key == 'N' || app.key == 'n') {
				anadirEquipoNegro();
			}
			break;
		}
	}

	/*
	 * Método que se removerá del ArrayList al elementos que esté huyendo justo
	 * en el momento en que salda de la pantalla, lo sabrá por medio del boolean
	 * 'huyendo'.
	 * 
	 * @retorno void
	 */
	public void remover() {

	}

	// GETTERS Y SETTERS
	public ArrayList<Criatura> getCriaturas() {
		return criaturas;
	}

	public void setCriaturas(ArrayList<Criatura> criaturas) {
		this.criaturas = criaturas;
	}

	public ArrayList<Comida> getComida() {
		return comida;
	}

	public void setComida(ArrayList<Comida> comida) {
		this.comida = comida;
	}

}
