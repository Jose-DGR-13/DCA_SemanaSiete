import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.regex.Pattern;

import processing.core.PApplet;
import processing.core.PImage;
import processing.core.PShape;

//En la carpeta docs queda un diagrama de clases basico para tener una idea de como se va a trabajar

public class Logica {
	// Atributes
	PApplet app = MainApp.app;
	PShape zoomIn, zoomOut, fullScreen, noFullScreen, rotateL, rotateR, imgFile, imgNext, imgPrev;
	boolean full = false;
	int posSelector = 0;
	
	// Relaciones
	ArrayList<Archivo> archivosArray;
	LinkedList<Archivo> archivosLinked;
	Archivo selector;

	Iterator<Archivo> iterator;

	

	public Logica() {
		init();
	}

	// Initialize
	public void init() {
		archivosArray = new ArrayList<Archivo>();
		archivosLinked = new LinkedList<Archivo>();
		crearImagenes();

		archivosLinked.addAll(archivosArray);

		ordenarNombreD();

		Iterator<Archivo> iterator = archivosLinked.iterator();

		loadShapes();

		// Por defecto carga el primer elemento del arrayList para mostrarlo

		Archivo archivoTemp = (Archivo) iterator.next();
		selector = archivoTemp;
	}

	// Cargar Imagenes y Crear objetos Archivo
	public void crearImagenes() {

		// Creo string para el nombre de la carpeta y un tipo File para que
		// tenga el directorio
		String directorioImagenes = "./data/";
		File dirImg = new File(directorioImagenes);

		// Valido que exista la capeta
		if (dirImg.exists()) {

			// usando list files, guardo cada archvo en un array archivoTemp con
			// listfile y luego con getName obtengo el nombre
			File[] archivosTemp = dirImg.listFiles();
			for (int i = 0; i < archivosTemp.length; i++) {
				// System.out.println(archivosTemp[i].getName());
				agregarImagen(archivosTemp[i]);
			}
		} else {
			// Do Nothing
			System.err.println("No Directory or Files Found on: " + directorioImagenes);
		}

	}

	public void agregarImagen(File _file) {

		String name = _file.getName();
		String[] typeArray = name.split(Pattern.quote("."));
		String type = typeArray[1];
		PImage imgTemp = app.loadImage("./data/" + name);
		int width = imgTemp.width;
		int height = imgTemp.height;

		Archivo archivoTemp = new Archivo(name, type, width, height, imgTemp);

		archivosArray.add(archivoTemp);
		// System.out.println(name+ " added to ArrayList");
	}

	public void pintarInterfaz() {
		

		// Pintar Imagen seleccionada
		
		//Manejador de Full Screen
		app.imageMode(app.CENTER);
		if (full) {
			app.pushMatrix();
			app.translate(app.width / 2, app.height / 2);
			app.scale(2);
			app.image(selector.img, 0, 0);
			app.popMatrix();
			
			noFullScreen.disableStyle();
			app.fill(120, 120, 120);
			app.stroke(255, 255, 255);
			app.shape(noFullScreen, 1260, 15, 20, 20);

		} else {
			
			// Left Panel

			// gray bg
			app.fill(200, 200, 200);
			app.rect(0, 0, 280, 720);

			// text1
			app.fill(255, 255, 255);
			app.text("Lista de Imagenes", 50, 20);

			// icon1
			app.shapeMode(app.CENTER);
			imgFile.disableStyle(); // Ignore the colors in the SVG
			app.fill(255, 255, 255); // Set the SVG fill to blue
			app.strokeWeight(1);
			app.stroke(0, 0, 0);
			app.shape(imgFile, 25, 15, 20, 20);
			
			app.pushMatrix();
			app.scale(1);
			app.image(selector.img, 500 + 280, 360);
			app.popMatrix();
		
			pintarLista();
			
			// Pintar resto de iconos
			app.shape(zoomIn, 760, 700, 20, 20);
			app.shape(zoomOut, 780, 700, 20, 20);
			app.shape(rotateL, 740, 700, 20, 20);
			app.shape(rotateR, 800, 700, 20, 20);
			app.shape(imgPrev, 300, 360, 20, 20);
			app.shape(imgNext, 1260, 360, 20, 20);
			app.shape(fullScreen, 1260, 15, 20, 20);
		}
		
		
	}

	public void loadShapes() {
		zoomIn = app.loadShape("assets/magnify-plus.svg");
		zoomOut = app.loadShape("assets/magnify-minus.svg");
		imgNext = app.loadShape("assets/step-forward.svg");
		imgPrev = app.loadShape("assets/step-backward.svg");
		rotateL = app.loadShape("assets/rotate-left.svg");
		rotateR = app.loadShape("assets/rotate-right.svg");
		fullScreen = app.loadShape("assets/arrow-expand-all.svg");
		noFullScreen = app.loadShape("assets/arrow-compress-all.svg");
		imgFile = app.loadShape("assets/file-image.svg");
	}

	public void pintarLista() {
		if (archivosLinked != null) {
			int i = 0;
			for (Iterator<Archivo> iterator = archivosLinked.iterator(); iterator.hasNext();) {
				Archivo archivoTemp = (Archivo) iterator.next();
				app.fill(0, 0, 0);
				app.text(archivoTemp.name, 20, 50 + (20 * i));
				i++;
			}

		}
	}

	public void pintar() {
		pintarInterfaz();
		
	}

	/*
	 * 
	 * 
	 * Metodos Ordenamiento
	 * 
	 * 
	 */
	public void resetArray(){
		archivosArray.clear();
		archivosArray.addAll(archivosLinked);
		posSelector = 0;
	}
	
	
	public void ordenarNombreA() {
		Collections.sort(archivosLinked, new Comparator<Archivo>() {

			@Override
			public int compare(Archivo p1, Archivo p2) {
				return p1.name.compareTo(p2.name);
			}
		});

		for (Iterator<Archivo> iterator = archivosLinked.iterator(); iterator.hasNext();) {
			Archivo archivoTemp = (Archivo) iterator.next();
			System.out.println(archivoTemp.name);
		}
		
		resetArray();
	}

	public void ordenarNombreD() {
		Collections.sort(archivosLinked, new Comparator<Archivo>() {

			@Override
			public int compare(Archivo p1, Archivo p2) {
				return p2.name.compareTo(p1.name);
			}
		});
		
		resetArray();

	}

	public void ordenarTipoA() {
		Collections.sort(archivosLinked, new Comparator<Archivo>() {

			@Override
			public int compare(Archivo p1, Archivo p2) {
				return (p1.type).compareTo(p2.type);
			}
		});

		for (Iterator<Archivo> iterator = archivosLinked.iterator(); iterator.hasNext();) {
			Archivo archivoTemp = (Archivo) iterator.next();
			System.out.println(archivoTemp.type);
		}
		resetArray();
	}

	public void ordenarTipoD() {
		Collections.sort(archivosLinked, new Comparator<Archivo>() {

			@Override
			public int compare(Archivo p1, Archivo p2) {
				return (p2.type).compareTo(p1.type);
			}
		});
		for (Iterator<Archivo> iterator = archivosLinked.iterator(); iterator.hasNext();) {
			Archivo archivoTemp = (Archivo) iterator.next();
			System.out.println(archivoTemp.type);
		}
		resetArray();
	}

	public void ordenarAltoA() {
		Collections.sort(archivosLinked, new Comparator<Archivo>() {

			@Override
			public int compare(Archivo p1, Archivo p2) {
				return p2.height - p1.height;
			}
		});
		resetArray();
	}

	public void ordenarAltoD() {
		Collections.sort(archivosLinked, new Comparator<Archivo>() {

			@Override
			public int compare(Archivo p1, Archivo p2) {
				return p1.height - p2.height;
			}
		});
		resetArray();
	}

	public void ordenarAnchoA() {
		Collections.sort(archivosLinked, new Comparator<Archivo>() {

			@Override
			public int compare(Archivo p1, Archivo p2) {
				return p1.width - (p2.width);
			}
		});
		resetArray();
	}

	public void ordenarAnchoD() {
		Collections.sort(archivosLinked, new Comparator<Archivo>() {

			@Override
			public int compare(Archivo p1, Archivo p2) {
				return p2.width - p1.width;
			}
		});
		resetArray();	
	}

	/*
	 * 
	 * Metodos Manipulacion de Escenario
	 * 
	 * 
	 */

	public void setFullScreen() {
		if (app.dist(1260, 15, app.mouseX, app.mouseY)<= 20) {
			full =!full;
		}
	}



	public void nextImage() {
		if (app.dist(1260, 360, app.mouseX, app.mouseY)<= 20 && full == false) {
			if(posSelector + 1 <= archivosArray.size()){
			posSelector = posSelector + 1;
			selector = archivosArray.get(posSelector);
			}
		}
	}
	
	public void prevImage() {
		if (app.dist(300, 360, app.mouseX, app.mouseY)<= 20 && full == false) {
			if(posSelector - 1 >= 0){
			posSelector = posSelector - 1;
			selector = archivosArray.get(posSelector);
			}
		}
	}

	// Mouse Events
	public void click() {
		setFullScreen();
		nextImage();
		prevImage();
	}
	
	

	public void checkIfOnList() {

	}
}
