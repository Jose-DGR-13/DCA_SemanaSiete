import java.util.Objects;

import processing.core.PApplet;
import processing.core.PImage;

public class Archivo implements Comparable<Archivo> {

	// Atributos
	PApplet app = MainApp.app;
	String name, type;
	int width, height;
	PImage img;

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

	}

	public void zoomOut() {

	}


	public void rotarDer() {

	}

	public void loadImage() {
		img = app.loadImage(name + "." + type);
	}

	public void pintar() {
		app.image(img, 0, 0);
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
