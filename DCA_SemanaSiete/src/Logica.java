import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Pattern;

import processing.core.PApplet;
import processing.core.PImage;

//En la carpeta docs queda un diagrama de clases basico para tener una idea de como se va a trabajar

public class Logica {
	//Atributes
	PApplet app = MainApp.app;
	
	//Relaciones
	ArrayList<Archivo> archivosArray;
	LinkedList<Archivo> archivosLinked;
	Archivo selector;
	
	public Logica() {
		init();
	}
	
	//Initialize
	public void init(){
		archivosArray = new ArrayList<Archivo>();
		archivosLinked = new LinkedList<Archivo>();
		crearImagenes();
	}
	
	//Cargar Imagenes y Crear objetos Archivo
	public void crearImagenes(){
		
		//Creo string para el nombre de la carpeta y un tipo File para que tenga el directorio
		String directorioImagenes = "./data/";
		File dirImg = new File(directorioImagenes);
		
		//Valido que exista la capeta
		if(dirImg.exists()){
			
			//usando list files, guardo cada archvo en un array archivoTemp con listfile y luego con getName obtengo el nombre
			File[] archivosTemp = dirImg.listFiles();
			for (int i=0;i<archivosTemp.length;i++){
			 // System.out.println(archivosTemp[i].getName());
			  agregarImagen(archivosTemp[i]);
			}
		} else {
			//Do Nothing
			System.err.println("No Directory or Files Found on: " + directorioImagenes);
		}
		
	}
	
	public void agregarImagen(File _file){
		
		String name = _file.getName();
		String[] typeArray = name.split(Pattern.quote("."));
		String type = typeArray[1];
		PImage imgTemp = app.loadImage("./data/"+name);	
		int width = imgTemp.width;
		int height = imgTemp.height;
		
		Archivo archivoTemp = new Archivo(name,type,width,height,imgTemp);
		
		archivosArray.add(archivoTemp);
		System.out.println(name+ " added to ArrayList");
	}
	
	public void pintarInterfaz(){
		/*
		 * Metodo para pintar interfaz, botones de interaccion y de mas
		 * */
	}
	
	public void pintarLista(){
		/*
		 * Metodo para refrescar la lista al realizar un nuevo reOrdenamiento
		 * */
	}
	
	public void pintar(){
		pintarInterfaz();
		pintarLista();
	}
	
	/*
	 * 
	 * 
	 * Metodos Ordenamiento
	 * 
	 * 
	 * */
	
	
	public void ordenarNombreA(){
		
	}
	
	public void ordenarNombreD(){
		
	}
	
	public void ordenarTipoA(){
		
	}
	
	public void ordenarTipoD(){
		
	}
	
	public void ordenarAltoA(){
		
	}
	
	public void ordenarAltoD(){
		
	}
	
	public void ordenarAnchoA(){
		
	}
	
	public void ordenarAnchoD(){
		
	}
	
	
	/*
	 * 
	 *Metodos Manipulacion de Escenario
	 * 
	 * 
	 * */
	
	
	public void setFullScreen(){
		
	}
	
	public void noFullScreen(){
		
	}
	
	public void nextImage(){
		
	}
	
	public void prevImage(){
		
	}
	
	//Mouse Events
	public void click(){
		
	}
}
