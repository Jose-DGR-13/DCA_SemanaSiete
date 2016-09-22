import java.util.Objects;

import processing.core.PApplet;
import processing.core.PImage;

public class Archivo implements Comparable<Archivo> {

	// Atributos
	PApplet app = MainApp.app;
	String name, type;
	int width, height;
	PImage img;
	private float size;

	public Archivo(String _name, String _type, int _width, int _height, PImage _img) {

		name = _name;
		type = _type;
		width = _width;
		height = _height;
		img = _img;

	}

	/*
	 * Manipulacion de Imagen
	 */
	public void zoomIn() {
		if (app.mouseX > 750 && app.mouseX < 770 && app.mouseY > 690 && app.mouseY < 700) {
			size += 0.2;
			if (size >= 1.6f) {
				size = 1.6f;
			}
			System.out.println("entro");
		}
	}

	public void zoomOut() {
		if (app.mouseX > 770 && app.mouseX < 790 && app.mouseY > 690 && app.mouseY < 700) {
			size -= 0.2;
			if (size <= 1) {
				size = 1;
			}
			System.out.println("entro2");
		}
	}


	public void rotarDer() {

	}

	public void loadImage() {
		img = app.loadImage(name + "." + type);
	}

	public void pintar() {
		app.pushMatrix();
		app.imageMode(app.CENTER);
		app.translate(app.width/2, app.height/2);
		app.scale(size);
		app.image(img, 0, 0);
		app.imageMode(app.CENTER);
		app.popMatrix();
		System.out.println(size);
	}

	/*
	 * //toDo
	 * 
	 * @Override public int compareTo(Object o) { // TODO Auto-generated method
	 * stub return 0; }
	 */
	// toDo
	@Override
	public int compareTo(Archivo o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
