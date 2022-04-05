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
	
	
	//MÉTODOS
	
	/**
	 * Método que imprime la raiz del arbol y sus hijos de derecha a izquierda
	 */
	public void preOrden() {
		this.raiz.preOrden(raiz);
	}
	
	/**
	 * Método que imprime los hijos de izquierda a derecha y la raiz del arbol por último
	 */
	public void postOrden() {
		this.raiz.postOrden(raiz);
	}
	
	/**
	 * Método que busca un nodo a partir de su atributo value
	 * @param valor, atributo del nodo bsucado
	 * @return el nodo buscadp
	 */
	public Nodo buscarNodo(String value) {
		return this.raiz.buscar(value);
	}
	
	/**
	 * Método que muestra la profundidad del arbol
	 * @param value, atributo value del nodo del que queremos returnar su profundidad 
	 * @return profundidad del nodo
	 */
	public int profundidad(String value) {
		return this.raiz.profundidad(value, 0);
	}
	
	/**
	 * Método que inserta un nodo nuevo, a partir su atributo value
	 * @param padre
	 * @param value
	 * @return
	 */
	public Nodo insertarNodo(Nodo padre, String value) {
		return this.raiz.insertarNodo(padre, value);
	}
	
	/**
	 * Método que devuelve la ruta del nodo
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
	 * Método que imprime el árbol en orden descendente a partir de un nodo introducido
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