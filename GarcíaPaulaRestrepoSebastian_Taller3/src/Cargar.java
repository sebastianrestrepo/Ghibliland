import processing.core.PApplet;
import processing.core.PImage;

public class Cargar {

	private PApplet app;
	private PImage[] criaturaFrontalDuende, criaturaFrontalSinCara, criaturaFrontalGato, criaturaFrontalKodama,
			criaturaFrontalTotoro, criaturaFrontalMiniTotoro;
	private PImage[] criaturaIzqDuende, criaturaIzqSinCara, criaturaIzqGato, criaturaIzqKodama, criaturaIzqTotoro,
			criaturaIzqMiniTotoro;
	private PImage[] criaturaDerDuende, criaturaDerSinCara, criaturaDerGato, criaturaDerKodama, criaturaDerTotoro,
			criaturaDerMiniTotoro;
	private PImage[] criaturaPosteriorDuende, criaturaPosteriorSinCara, criaturaPosteriorGato, criaturaPosteriorKodama,
			criaturaPosteriorTotoro, criaturaPosteriorMiniTotoro;
	private PImage estrellaAmarilla, estrellaAzul, estrellaRoja, estrellaRosa, estrellaVioleta;
	
	public Cargar(PApplet app) {
		this.app = app;
		cargarDuende();
		cargarSinCara();
		cargarGato();
		cargarKodama();
		cargarTotoro();
		cargarMiniTotoro();
		cargarComida();
	}

	// --------------------------COMIDA------------------------//
	public void cargarComida(){
		estrellaAmarilla = app.loadImage("../data/estrellas/estrellaAmarilla.png");
		estrellaAzul = app.loadImage("../data/estrellas/estrellaAzul.png");
		estrellaRosa = app.loadImage("../data/estrellas/estrellaRosa.png");
		estrellaVioleta = app.loadImage("../data/estrellas/estrellaVioleta.png");
	}
	
	// --------------------------EQUIPO NEGRO------------------------//
	public void cargarDuende() {
		// Frontal
		criaturaFrontalDuende = new PImage[11];
		for (int i = 0; i < criaturaFrontalDuende.length; i++) {
			criaturaFrontalDuende[i] = app.loadImage("../data/personajes/duende/duendeFrontal/Duende_" + i + ".png");
		}
		// Izquierda
		criaturaIzqDuende = new PImage[11];
		for (int i = 0; i < criaturaIzqDuende.length; i++) {
			criaturaIzqDuende[i] = app.loadImage("../data/personajes/duende/duendeIzq/Duende izq_" + i + ".png");
		}
		// Derecha
		criaturaDerDuende = new PImage[11];
		for (int i = 0; i < criaturaDerDuende.length; i++) {
			criaturaDerDuende[i] = app.loadImage("../data/personajes/duende/duendeDer/Duende der_" + i + ".png");
		}
		// Posterior
		criaturaPosteriorDuende = new PImage[11];
		for (int i = 0; i < criaturaPosteriorDuende.length; i++) {
			criaturaPosteriorDuende[i] = app
					.loadImage("../data/personajes/duende/duendePosterior/Duende posterior_" + i + ".png");
		}
	}

	public void cargarGato() {
		criaturaFrontalGato = new PImage[29];
		for (int i = 0; i < criaturaFrontalGato.length; i++) {
			criaturaFrontalGato[i] = app.loadImage("../data/personajes/jiji/jijiFrontal/jijiFrontal_" + i + ".png");
		}
		// Izquierda
		criaturaIzqGato = new PImage[9];
		for (int i = 0; i < criaturaIzqGato.length; i++) {
			criaturaIzqGato[i] = app.loadImage("../data/personajes/jiji/jijiIzq/jijiIzq_" + i + ".png");
		}
		// Derecha
		criaturaDerGato = new PImage[9];
		for (int i = 0; i < criaturaDerGato.length; i++) {
			criaturaDerGato[i] = app.loadImage("../data/personajes/jiji/jijiDer/jijiDer_" + i + ".png");
		}
		// Posterior
		criaturaPosteriorGato = new PImage[29];
		for (int i = 0; i < criaturaPosteriorGato.length; i++) {
			criaturaPosteriorGato[i] = app
					.loadImage("../data/personajes/jiji/jijiPosterior/jijiPosterior_" + i + ".png");
		}
	}

	public void cargarSinCara() {
		// Frontal
		criaturaFrontalSinCara = new PImage[19];
		for (int i = 0; i < criaturaFrontalSinCara.length; i++) {
			criaturaFrontalSinCara[i] = app
					.loadImage("../data/personajes/sinCara/sinCaraFrontal/No Face_" + i + ".png");
		}
		// Izquierda
		criaturaIzqSinCara = new PImage[19];
		for (int i = 0; i < criaturaIzqSinCara.length; i++) {
			criaturaIzqSinCara[i] = app.loadImage("../data/personajes/sinCara/sinCaraIzq/No Face Izq_" + i + ".png");
		}
		// Derecha
		criaturaDerSinCara = new PImage[19];
		for (int i = 0; i < criaturaDerSinCara.length; i++) {
			criaturaDerSinCara[i] = app.loadImage("../data/personajes/sinCara/sinCaraDer/No Face Der_" + i + ".png");
		}
		// Posterior
		criaturaPosteriorSinCara = new PImage[15];
		for (int i = 0; i < criaturaPosteriorSinCara.length; i++) {
			criaturaPosteriorSinCara[i] = app
					.loadImage("../data/personajes/sinCara/sinCaraPosterior/No Face posterior_" + i + ".png");
		}
	}

	// ------------------------------EQUIPO BLANCO-------------------------//
	public void cargarTotoro() {
		// Frontal
		criaturaFrontalTotoro = new PImage[14];
		for (int i = 0; i < criaturaFrontalTotoro.length; i++) {
			criaturaFrontalTotoro[i] = app.loadImage("../data/personajes/Totoro/TotoFrente/TotoF_" + i + ".png");
		}
		// Izquierda
		criaturaIzqTotoro = new PImage[14];
		for (int i = 0; i < criaturaIzqTotoro.length; i++) {
			criaturaIzqTotoro[i] = app.loadImage("../data/personajes/Totoro/TotoroIz/TotoroIz_" + i + ".png");
		}
		// Derecha
		criaturaDerTotoro = new PImage[14];
		for (int i = 0; i < criaturaDerTotoro.length; i++) {
			criaturaDerTotoro[i] = app.loadImage("../data/personajes/Totoro/TotoroDe/TotoroDe_" + i + ".png");
		}
		// Posterior
		criaturaPosteriorTotoro = new PImage[14];
		for (int i = 0; i < criaturaPosteriorTotoro.length; i++) {
			criaturaPosteriorTotoro[i] = app.loadImage("../data/personajes/Totoro/TotoroEs/TotoroEs_" + i + ".png");
		}
	}

	public void cargarMiniTotoro() {
		// Frontal
		criaturaFrontalMiniTotoro = new PImage[15];
		for (int i = 4; i < criaturaFrontalMiniTotoro.length; i++) {
			criaturaFrontalMiniTotoro[i] = app
					.loadImage("../data/personajes/Minitoto/MiniTotoF/MinitotoF_" + i + ".png");
		}
		// Izquierda
		criaturaIzqMiniTotoro = new PImage[11];
		for (int i = 0; i < criaturaIzqMiniTotoro.length; i++) {
			criaturaIzqMiniTotoro[i] = app.loadImage("../data/personajes/Minitoto/MiniTotoIz/MiniTotoIz_" + i + ".png");
		}
		// Derecha
		criaturaDerMiniTotoro = new PImage[11];
		for (int i = 0; i < criaturaDerMiniTotoro.length; i++) {
			criaturaDerMiniTotoro[i] = app.loadImage("../data/personajes/Minitoto/MiniTotoDe/MinitotoDe_" + i + ".png");
		}
		// Posterior
		criaturaPosteriorMiniTotoro = new PImage[15];
		for (int i = 4; i < criaturaPosteriorMiniTotoro.length; i++) {
			criaturaPosteriorMiniTotoro[i] = app
					.loadImage("../data/personajes/Minitoto/MiniTotoEs/MinitotoEs_" + i + ".png");
		}
	}

	public void cargarKodama() {
		// Frontal
		criaturaFrontalKodama = new PImage[33];
		for (int i = 0; i < criaturaFrontalKodama.length; i++) {
			criaturaFrontalKodama[i] = app.loadImage("../data/personajes/Kodama/KodamaF/KodamaF_" + i + ".png");
		}
		// Izquierda
		criaturaIzqKodama = new PImage[39];
		for (int i = 0; i < criaturaIzqKodama.length; i++) {
			criaturaIzqKodama[i] = app.loadImage("../data/personajes/Kodama/KodamaIz/KodamaIz_" + i + ".png");
		}
		// Derecha
		criaturaDerKodama = new PImage[36];
		for (int i = 3; i < criaturaDerKodama.length; i++) {
			criaturaDerKodama[i] = app.loadImage("../data/personajes/Kodama/KodamaDe/KodamaDe_" + i + ".png");
		}
		// Posterior
		criaturaPosteriorKodama = new PImage[33];
		for (int i = 0; i < criaturaPosteriorKodama.length; i++) {
			criaturaPosteriorKodama[i] = app.loadImage("../data/personajes/Kodama/KodamaEs/KodamaEs_" + i + ".png");
		}
	}

	// GETTERS Y SETTERS
	public PImage[] getCriaturaDerDuende() {
		return criaturaDerDuende;
	}

	public PImage[] getCriaturaFrontalDuende() {
		return criaturaFrontalDuende;
	}

	public PImage[] getCriaturaIzqDuende() {
		return criaturaIzqDuende;
	}

	public PImage[] getCriaturaPosteriorDuende() {
		return criaturaPosteriorDuende;
	}

	public PImage[] getCriaturaFrontalSinCara() {
		return criaturaFrontalSinCara;
	}

	public void setCriaturaFrontalSinCara(PImage[] criaturaFrontalSinCara) {
		this.criaturaFrontalSinCara = criaturaFrontalSinCara;
	}

	public PImage[] getCriaturaFrontalGato() {
		return criaturaFrontalGato;
	}

	public void setCriaturaFrontalGato(PImage[] criaturaFrontalGato) {
		this.criaturaFrontalGato = criaturaFrontalGato;
	}

	public PImage[] getCriaturaFrontalKodama() {
		return criaturaFrontalKodama;
	}

	public void setCriaturaFrontalKodama(PImage[] criaturaFrontalKodama) {
		this.criaturaFrontalKodama = criaturaFrontalKodama;
	}

	public PImage[] getCriaturaFrontalTotoro() {
		return criaturaFrontalTotoro;
	}

	public void setCriaturaFrontalTotoro(PImage[] criaturaFrontalTotoro) {
		this.criaturaFrontalTotoro = criaturaFrontalTotoro;
	}

	public PImage[] getCriaturaFrontalMiniTotoro() {
		return criaturaFrontalMiniTotoro;
	}

	public void setCriaturaFrontalMiniTotoro(PImage[] criaturaFrontalMiniTotoro) {
		this.criaturaFrontalMiniTotoro = criaturaFrontalMiniTotoro;
	}

	public PImage[] getCriaturaIzqSinCara() {
		return criaturaIzqSinCara;
	}

	public void setCriaturaIzqSinCara(PImage[] criaturaIzqSinCara) {
		this.criaturaIzqSinCara = criaturaIzqSinCara;
	}

	public PImage[] getCriaturaIzqGato() {
		return criaturaIzqGato;
	}

	public void setCriaturaIzqGato(PImage[] criaturaIzqGato) {
		this.criaturaIzqGato = criaturaIzqGato;
	}

	public PImage[] getCriaturaIzqKodama() {
		return criaturaIzqKodama;
	}

	public void setCriaturaIzqKodama(PImage[] criaturaIzqKodama) {
		this.criaturaIzqKodama = criaturaIzqKodama;
	}

	public PImage[] getCriaturaIzqTotoro() {
		return criaturaIzqTotoro;
	}

	public void setCriaturaIzqTotoro(PImage[] criaturaIzqTotoro) {
		this.criaturaIzqTotoro = criaturaIzqTotoro;
	}

	public PImage[] getCriaturaIzqMiniTotoro() {
		return criaturaIzqMiniTotoro;
	}

	public void setCriaturaIzqMiniTotoro(PImage[] criaturaIzqMiniTotoro) {
		this.criaturaIzqMiniTotoro = criaturaIzqMiniTotoro;
	}

	public PImage[] getCriaturaDerSinCara() {
		return criaturaDerSinCara;
	}

	public void setCriaturaDerSinCara(PImage[] criaturaDerSinCara) {
		this.criaturaDerSinCara = criaturaDerSinCara;
	}

	public PImage[] getCriaturaDerGato() {
		return criaturaDerGato;
	}

	public void setCriaturaDerGato(PImage[] criaturaDerGato) {
		this.criaturaDerGato = criaturaDerGato;
	}

	public PImage[] getCriaturaDerKodama() {
		return criaturaDerKodama;
	}

	public void setCriaturaDerKodama(PImage[] criaturaDerKodama) {
		this.criaturaDerKodama = criaturaDerKodama;
	}

	public PImage[] getCriaturaDerTotoro() {
		return criaturaDerTotoro;
	}

	public void setCriaturaDerTotoro(PImage[] criaturaDerTotoro) {
		this.criaturaDerTotoro = criaturaDerTotoro;
	}

	public PImage[] getCriaturaDerMiniTotoro() {
		return criaturaDerMiniTotoro;
	}

	public void setCriaturaDerMiniTotoro(PImage[] criaturaDerMiniTotoro) {
		this.criaturaDerMiniTotoro = criaturaDerMiniTotoro;
	}

	public PImage[] getCriaturaPosteriorSinCara() {
		return criaturaPosteriorSinCara;
	}

	public void setCriaturaPosteriorSinCara(PImage[] criaturaPosteriorSinCara) {
		this.criaturaPosteriorSinCara = criaturaPosteriorSinCara;
	}

	public PImage[] getCriaturaPosteriorGato() {
		return criaturaPosteriorGato;
	}

	public void setCriaturaPosteriorGato(PImage[] criaturaPosteriorGato) {
		this.criaturaPosteriorGato = criaturaPosteriorGato;
	}

	public PImage[] getCriaturaPosteriorKodama() {
		return criaturaPosteriorKodama;
	}

	public void setCriaturaPosteriorKodama(PImage[] criaturaPosteriorKodama) {
		this.criaturaPosteriorKodama = criaturaPosteriorKodama;
	}

	public PImage[] getCriaturaPosteriorTotoro() {
		return criaturaPosteriorTotoro;
	}

	public void setCriaturaPosteriorTotoro(PImage[] criaturaPosteriorTotoro) {
		this.criaturaPosteriorTotoro = criaturaPosteriorTotoro;
	}

	public PImage[] getCriaturaPosteriorMiniTotoro() {
		return criaturaPosteriorMiniTotoro;
	}

	public void setCriaturaPosteriorMiniTotoro(PImage[] criaturaPosteriorMiniTotoro) {
		this.criaturaPosteriorMiniTotoro = criaturaPosteriorMiniTotoro;
	}

	public void setCriaturaFrontalDuende(PImage[] criaturaFrontalDuende) {
		this.criaturaFrontalDuende = criaturaFrontalDuende;
	}

	public void setCriaturaIzqDuende(PImage[] criaturaIzqDuende) {
		this.criaturaIzqDuende = criaturaIzqDuende;
	}

	public void setCriaturaDerDuende(PImage[] criaturaDerDuende) {
		this.criaturaDerDuende = criaturaDerDuende;
	}

	public void setCriaturaPosteriorDuende(PImage[] criaturaPosteriorDuende) {
		this.criaturaPosteriorDuende = criaturaPosteriorDuende;
	}

	public PImage getEstrellaAmarilla() {
		return estrellaAmarilla;
	}

	public void setEstrellaAmarilla(PImage estrellaAmarilla) {
		this.estrellaAmarilla = estrellaAmarilla;
	}

	public PImage getEstrellaAzul() {
		return estrellaAzul;
	}

	public void setEstrellaAzul(PImage estrellaAzul) {
		this.estrellaAzul = estrellaAzul;
	}

	public PImage getEstrellaRoja() {
		return estrellaRoja;
	}

	public void setEstrellaRoja(PImage estrellaRoja) {
		this.estrellaRoja = estrellaRoja;
	}

	public PImage getEstrellaRosa() {
		return estrellaRosa;
	}

	public void setEstrellaRosa(PImage estrellaRosa) {
		this.estrellaRosa = estrellaRosa;
	}

	public PImage getEstrellaVioleta() {
		return estrellaVioleta;
	}

	public void setEstrellaVioleta(PImage estrellaVioleta) {
		this.estrellaVioleta = estrellaVioleta;
	}
	
	
    //----//
	// FINAL DE LA CLASE CARGAR
}