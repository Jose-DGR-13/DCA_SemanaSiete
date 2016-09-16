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
	}

	public static void main(String[] args) {
		PApplet.main("MainApp");

	}

}
