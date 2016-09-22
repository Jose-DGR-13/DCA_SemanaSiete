import processing.core.PApplet;

public class MainApp extends PApplet {

	static PApplet app;
	Logica logica;

	public void settings() {
		size(1280, 720);
	}

	public void setup() {
		app = this;
		logica = new Logica();
	}

	public void draw() {
		background(255);
		logica.pintar();		
	}

	public static void main(String[] args) {
		PApplet.main("MainApp");

	}

	// Mouse Events
	public void mouseClicked() {
		logica.click();
	}
	
	//Key Pressed
	public void keyPressed(){
		switch (key) {
		case '1':
			logica.ordenarNombreA();
			break;
		case '2':
			logica.ordenarNombreD();
			break;
		case '3':
			logica.ordenarTipoA();
			break;
		case '4':
			logica.ordenarTipoD();
			break;
		case '5':
			logica.ordenarAltoA();
			break;
		case '6':
			logica.ordenarAltoD();
			break;
		case '7':
			logica.ordenarAnchoA();
			break;
		case '8':
			logica.ordenarAnchoD();
			break;
		default:
			break;
		}
	}

}
