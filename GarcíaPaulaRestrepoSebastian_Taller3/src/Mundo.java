import java.util.ArrayList;

import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
import processing.core.PImage;

public class Mundo {

	private PApplet app;
	private int pantallas;
	private int equipoNegro, equipoBlanco;
	private Cargar cargar;
	private PImage fondoInicio, instrucciones, fondoEsc, pasto;
	private PImage[] enterUno, enterDos, luces, mitad, titulo;
	private int numActual, numLuces, numFrame, numTitulo;
	private ArrayList<Criatura> criaturas;
	private ArrayList<Thread> capsulas; // ArrayList para encapsular los hilos
										// de las criaturas
	private Thread capsulaGatoBus;
	private ArrayList<Comida> comida;
	private GatoBus gatobus;
	private boolean reset, resetP, animarMitad;

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
		// agregarCriaturasInicio();
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
		cargar = new Cargar(app);
		reset = false;
		resetP = false;
		animarMitad = false;
	}

	/*
	 * Metodo que se encargara de iniciar todas las variables y listas se
	 * llamará en el método teclas en el momento que se pase de las
	 * instrucciones al escenario
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
			if (criaturas.get(i) != null) {
				capsulas.get(i).start();
			}
		}
	}

	/*
	 * Metodo que se encargara de añadir la comida que estará incialmene en el
	 * lienzo
	 * 
	 * @retorno void
	 */
	public void anadirComidaInicial() {

		// for (int j = 1; j < comida.size(); j++) {

		// if (PApplet.dist(comida.get(j).getPosX(), comida.get(j).getPosY(),
		// comida.get(j - 1).getPosX(),
		// comida.get(j - 1).getPosY()) < 25) {

		for (int i = 0; i < 15; i++) {

			comida.add(new Comida(this, (int) (30 + Math.random() * 560), (int) (30 + Math.random() * 560),
					(int) (15 + Math.random() * 25)));

		}

	}

	/*
	 * Método que se encargará de añadir las criaturas del equipo negro y que
	 * se llamará en método que se encarga de los eventos del teclado y que a
	 * su vez es llamado en el keyReleased
	 * 
	 * @retorno void
	 */
	public void anadirEquipoNegro() {
		equipoNegro = (int) (1 + Math.random() * 3);
		switch (equipoNegro) {
		case 1:
			criaturas.add(new SinCara(this, 121, 145, 10));
			break;
		case 2:
			criaturas.add(new Duende(this, 124, 349, -20));
			break;
		case 3:
			criaturas.add(new Gato(this, 129, 571, 25));
			break;
		}

		Thread temp = new Thread(criaturas.get(criaturas.size() - 1));
		if (temp.getState() == Thread.State.NEW) {
			temp.start();
		}
		capsulas.add(temp);
	}

	/*
	 * Método que se encargará de añadir las criaturas del equipo blanco y
	 * que se llamará en método que se encarga de los eventos del teclado y
	 * que a su vez es llamado en el keyReleased
	 * 
	 * @retorno void
	 */
	public void anadirEquipoBlanco() {
		equipoBlanco = (int) (1 + Math.random() * 3);
		switch (equipoBlanco) {
		case 1:
			criaturas.add(new Totoro(this, 574, 91, 10));
			break;
		case 2:
			criaturas.add(new MiniTotoro(this, 572, 347, 10));
			break;
		case 3:
			criaturas.add(new Kodama(this, 585, 592, 15));
			break;
		}

		Thread temp = new Thread(criaturas.get(criaturas.size() - 1));
		if (temp.getState() == Thread.State.NEW) {
			temp.start();
		}
		capsulas.add(temp);
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
		cargarMitad();
		cargarTitulo();
		gatobus.cargarCriatura(app);
	}

	public void cargarTitulo() {
		numTitulo = 1;
		titulo = new PImage[9];
		for (int i = 1; i < titulo.length; i++) {
			titulo[i] = app.loadImage("../data/Inicio/Inicio_" + i + ".png");
		}
	}

	public void cargarMitad() {
		mitad = new PImage[23];
		for (int i = 0; i < mitad.length; i++) {
			mitad[i] = app.loadImage("../data/mitad/mitad_" + i + ".png");
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
			agregarComida();
			mitad();
			pintarGato();
			pintarLuces();
			System.out.println(numFrame);
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
		if (app.frameCount % 500 == 0) {

			for (int i = 0; i < 10; i++) {

				comida.add(new Comida(this, (int) (30 + Math.random() * 560), (int) (30 + Math.random() * 560),
						(int) (15 + Math.random() * 25)));
				animarMitad = true;
			}
		}
	}

	/*
	 * Método que se encarga de los eventos que sucedan con el elemento de la
	 * mitad es decir, cuando debe pintarla y cuando animarla bajo una
	 * condición
	 */
	public void mitad() {
		if (animarMitad) {
			animarMitad();
		} else {
			pintarMitad();
		}
	}

	/*
	 * Método que se encarga de pintar la mitad
	 */
	public void pintarMitad() {
		app.image(mitad[0], app.width / 2, app.height / 2);
	}

	/*
	 * Método que se encarga de animar la mitad
	 */
	public void animarMitad() {
		numFrame++;
		app.image(mitad[numFrame], app.width / 2, app.height / 2);
		if (numFrame >= 22) {
			numFrame = 0;
			animarMitad = false;
		}
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
	public void teclas() {
		switch (pantallas) {
		case 0:
			if (app.keyCode == app.ENTER) {
				pantallas = 1;
			}
			break;
		case 1:
			if (app.keyCode == app.ENTER) {
				agregarCriaturasInicio();
				// iniciarHilos();
				pantallas = 2;
			}
			break;
		case 2:
			// Anadir equipo negro
			if (app.key == 'N' || app.key == 'n') {
				anadirEquipoNegro();
			}
			// Anadir equipo blanco
			if (app.key == 'B' || app.key == 'b') {
				anadirEquipoBlanco();
			}
			// Reiniciar la aplicación
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

	public void iniciarHiloGato() {
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

	public boolean getResetP() {
		return resetP;
	}

	public Cargar getCargar() {
		return cargar;
	}

	public void setCargar(Cargar cargar) {
		this.cargar = cargar;
	}

	// ---------------------------FINAL DE LA CLASE
	// MUNDO---------------------------//
}