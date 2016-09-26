import java.util.Objects;

import processing.core.PApplet;
import processing.core.PImage;

public class Archivo implements Comparable<Archivo> {

	// Atributos
	PApplet app = MainApp.app;
	String name, type;
	int width, height;
	PImage img;
	private float size = 1;

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
	width = width +(int) (width*0.1);
	height = height + (int) (height*0.1);
	img.resize(width, height);
	}

	public void zoomOut() {
		width = width - (int) (width*0.1);
		height = height - (int) (height*0.1);
		img.resize(width, height);
		//System.out.println("ZoomOut Class");
	}

	public void loadImage() {
		img = app.loadImage(name + "." + type);
	}

	public void pintar() {
		app.pushMatrix();
		app.imageMode(app.CENTER);
		app.translate(app.width / 2, app.height / 2);
		app.image(img, 0, 0);
		app.imageMode(app.CENTER);
		app.popMatrix();
		System.out.println(size);
	}

	@Override
	public int compareTo(Archivo o) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setSize(float size2) {
		this.size=size2;
	}

}
