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
	private PImage[] enterUno, enterDos, luces, mitad, titulo;
	private int numActual, numLuces, numFrame, numTitulo;
	private ArrayList<Criatura> criaturas;
	private ArrayList<Thread> capsulas; // ArrayList para encapsular los hilos
										// de las criaturas
	private Thread capsulaGatoBus;
	private ArrayList<Comida> comida;
	private GatoBus gatobus;
	private boolean reset, resetP;

	/*
	 * Constructor de Mundo
	 * 
	 * @parametro PApplet app
	 */
	public Mundo(PApplet app) {
		this.app = app;
		app.imageMode(app.CENTER);
		inicializarVariables();
		anadirComidaInicial();
		agregarCriaturasInicio();
		cargarImagenes();
	}

	/*
	 * Metodo que se encargara de iniciar todas las variables y listas
	 * 
	 * @retorno void
	 */
	public void inicializarVariables() {
		criaturas = new ArrayList<Criatura>();
		comida = new ArrayList<Comida>();
		gatobus = new GatoBus(-149, 100, 50, this, reset);
		capsulas = new ArrayList<Thread>();
		reset = false;
		resetP = false;

	}

	/*
	 * Metodo que se encargara de iniciar todas las variables y listas
	 * 
	 * @retorno void
	 */
	public void agregarCriaturasInicio() {
		criaturas.add(new SinCara(this, 121, 145, 10));
		criaturas.add(new Duende(this, 124, 349, -20));
		criaturas.add(new Gato(this, 129, 571, 10));
		criaturas.add(new Totoro(this, 574, 91, 10));
		criaturas.add(new MiniTotoro(this, 572, 347, 10));
		criaturas.add(new Kodama(this, 585, 592, 15));
		for (int i = 0; i < criaturas.size(); i++) {
			capsulas.add(new Thread(criaturas.get(i)));
		}
	}

	/*
	 * Metodo que se encargara de a�adir la comida que estar� incialmene en
	 * el lienzo
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
		equipoNegro = (int) (1 + Math.random() * 3);
		System.out.println(equipoNegro);
		switch (equipoNegro) {
		case 1:
			criaturas.add(new SinCara(this, app.width / 2 + 50, app.height / 3, 10));
			break;
		case 2:
			criaturas.add(new Duende(this, app.width / 2 - 50, app.height / 4, 30));
			break;
		case 3:
			criaturas.add(new Gato(this, app.width / 2 - 50, app.height / 4, 25));
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
	 * M�todo que se encargar� de iniciar y encapsular los Hilos
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
		cargarMitad();
		caragarTitulo();
		gatobus.cargarCriatura(app);
	}

	public void caragarTitulo() {
		numTitulo = 1;
		titulo = new PImage[9];
		for (int i = 1; i < titulo.length; i++) {
			titulo[i] = app.loadImage("../data/Inicio/Inicio_" + i + ".png");
		}
	}

	public void cargarMitad() {
		mitad = new PImage[14];
		for (int i = 0; i < mitad.length; i++) {
			mitad[i] = app.loadImage("../data/mitad/mitad_" + i + ".png");
		}
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

	public void pintar() {
		pantallas();
	}

	/*
	 * M�todo que se contendr� un switch que definir� los cambios
	 * pantallas
	 * 
	 * @retorno void
	 */
	public void pantallas() {

		switch (pantallas) {
		case 0:
			app.image(fondoInicio, app.width / 2, app.height / 2);
			pintarEnterUno();
			pintarTitulo();
			break;
		case 1:
			app.image(fondoInicio, app.width / 2, app.height / 2);
			app.image(instrucciones, app.width / 2, app.height / 2);
			pintarEnterDos();
			break;
		case 2:
			app.image(fondoEsc, app.width / 2, app.height / 2);
			app.image(pasto, app.width / 2, app.height / 2);
			pintarComida();
			cambioEstado();
			pintarCriaturas();
			pintarMitad();
			agregarComida();
			pintarGato();
			pintarLuces();

			break;
		}
	}

	public void pintarTitulo() {
		app.image(titulo[numTitulo], app.width / 2, app.height / 2);
		if (app.frameCount % 5 == 0) {
			numTitulo++;
			if (numTitulo >= 8) {
				numTitulo = 8;
			}
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
		app.image(enterUno[numActual], 345, 484);
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

	// M�todo para pasarle el ArrayList de comida a las criaturas
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
	 * M�todo que se encargar� de llamar a todos los pintar que vienen de
	 * las otras clases y que ser� llamado en el Ejectuable en el draw
	 * 
	 * @retorno void
	 */

	public void agregarComida() {
		if (app.frameCount % 150 == 0) {
			// for (int i = 0; i < 10; i++) {
			// comida.add(new Comida((int) (30 + Math.random() * 560), (int) (30
			// + Math.random() * 560),
			// (int) (15 + Math.random() * 25)));
			// }
		}
	}

	public void pintarMitad() {
		app.image(mitad[numFrame], app.width / 2, app.height / 2);
	}

	public void pintarGato() {
		if (resetP) {
			gatobus.pintar(app);
		}
	}

	/*
	 * M�todo que se encargar� de los eventos del teclado otras clases y que
	 * ser� llamado en el Ejectuable en el keyReleased
	 * 
	 * @retorno void
	 */
	public void teclas()  {
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
			// A�adir equipo negro
			if (app.key == 'N' || app.key == 'n') {
				anadirEquipoNegro();
			}
			// A�adir equipo blanco
			if (app.key == 'B' || app.key == 'b') {

			}

			if (app.key == 'R' || app.key == 'r') {
				Thread gb = new Thread(gatobus);
				gb.start();
				reset = true;
				resetP = true;
				System.out.println("boolean" + reset);
				System.out.println("gatoX" + gatobus.getX());
				iniciarHiloGato();

			}
			break;
		}
	}

	public void iniciarHiloGato()  {
		if (reset) {
			
		}

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

	public void setReset(boolean reset) {
		this.reset = reset;
	}
	public void setResetP(boolean resetP) {
		this.resetP = resetP;
	}
	
	public boolean getResetP(){
		return resetP;
	}
}