import java.util.ArrayList;
import java.util.LinkedList;
import processing.core.PApplet;

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
		
	}
	
	//Cargar Imagenes y Crear objetos Archivo
	public void crearImagenes(){
		//Metodo para cargar imagenes y propiedades a objetos Archivo
		//De este metodo puede resultar que toque hacer otros, como split para separar el normbre del tipo
		//obtener el tamaño de la imagenes
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
