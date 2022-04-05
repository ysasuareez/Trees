package models;

import java.util.ArrayList;
import java.util.Collections;

public class Arbol {

	//ATRIBUTOS
	private Nodo raiz;

	//CONSTRUCTOR
	public Arbol(Nodo raiz) {
		super();
		this.raiz = raiz;
	}
	
	//G & S
	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}
	
	
	//M�TODOS
	
	/**
	 * M�todo que imprime la raiz del arbol y sus hijos de derecha a izquierda
	 */
	public void preOrden() {
		this.raiz.preOrden(raiz);
	}
	
	/**
	 * M�todo que imprime los hijos de izquierda a derecha y la raiz del arbol por �ltimo
	 */
	public void postOrden() {
		this.raiz.postOrden(raiz);
	}
	
	/**
	 * M�todo que busca un nodo a partir de su atributo value
	 * @param valor, atributo del nodo bsucado
	 * @return el nodo buscadp
	 */
	public Nodo buscarNodo(String value) {
		return this.raiz.buscar(value);
	}
	
	/**
	 * M�todo que muestra la profundidad del arbol
	 * @param value, atributo value del nodo del que queremos returnar su profundidad 
	 * @return profundidad del nodo
	 */
	public int profundidad(String value) {
		return this.raiz.profundidad(value, 0);
	}
	
	/**
	 * M�todo que inserta un nodo nuevo, a partir su atributo value
	 * @param padre
	 * @param value
	 * @return
	 */
	public Nodo insertarNodo(Nodo padre, String value) {
		return this.raiz.insertarNodo(padre, value);
	}
	
	/**
	 * M�todo que devuelve la ruta del nodo
	 * @param value, atributo del nodo al que sacar la ruta
	 * @return ruta
	 */
	public String path(String value){
		ArrayList<String> ruta = new ArrayList<String>(); 
		
		ruta = this.raiz.path(value, ruta); 

		Collections.reverse(ruta); 
		
		return ruta.toString(); 
	
	}
	

	
	/**
	 * M�todo que imprime el �rbol en orden descendente a partir de un nodo introducido
	 * @param inicial, nodo a partir del cual se muestra su arbol
	 */
	public void mostrarArbol(Nodo inicial) {
		ArrayList<String> lista = new ArrayList<String>(); 
																	
		this.raiz.hijosDeHijos(inicial, lista); 
		for (int i = 0; i < lista.size(); i++) {
			System.out.println(this.path(lista.get(i))); 
																	
		}
	}
	

}