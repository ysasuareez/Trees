package models;

import java.util.ArrayList;

public class Nodo {

	//ATRIBUTOS
	private String value;
	private ArrayList <Nodo> hijos;
	
	
	
	//CONSTRUCTOR
	public Nodo(String value, ArrayList <Nodo> hijos) {
		super();
		this.value = value;
		this.hijos = hijos;
	}
	
	public Nodo(String value) {
		super();
		this.value = value;
		
	}

	
	
	//G & S
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public ArrayList <Nodo> getHijos() {
		return hijos;
	}

	public void setHijos(ArrayList <Nodo> hijos) {
		this.hijos = hijos;
	}

	
	
	// MÉTODOS

	/**
	 * Método que comprueba si el Nodo tiene Nodos hijos
	 * @return true si el Nodo tiene hijos; false si el Nodo no tiene hijos
	 */
	public boolean existenHijos() {
		return !this.hijos.isEmpty();
	}

	/**
	 * Método que inmprime el arbol junto con su recorrido, desde la raiz hasta todos sus nodos
	 * @param nodo, Nodo que se busca
	 */
	public void preOrden(Nodo nodo) {
		
		System.out.print(nodo.value + " | "); 

			for (int i = 0; i < nodo.hijos.size(); i++) {
				preOrden(nodo.hijos.get(i)); 
			}

	}

	/**
	 * Metodo que funciona igual que el anterior pero el orden  inverso, desde los nodos hasta la raiz
	 * @param n, Nodo que se busca
	 */
	public void postOrden(Nodo nodo) {
		

			for (int i = 0; i < nodo.hijos.size(); i++) {
				postOrden(nodo.hijos.get(i)); 
			}

		System.out.print(nodo.value + " | ");
	}

	/**
	 * Busca un nodo desde su atributo
	 * @param valor, Atributo String de el nodo que buscamos
	 * @return Nodo buscado, si existe
	 */
	public Nodo buscar(String value) {
		
		if (this.value.equals(value)) {
			return this;
		}
		
		if (this.existenHijos()) {
			
			for (int i = 0; i < hijos.size(); i++) {
				
				Nodo nodo = this.hijos.get(i).buscar(value);
				
				if (nodo != null) {
					return nodo;
				}
			}
			
		}
		
		return null;
	}
	
	
	/**
	 * 
	 * @param value
	 * @param prof
	 * @return
	 */
	public int profundidad(String value, int prof) {
		if (this.value.equals(value)) {
			return prof;
		}

		if (existenHijos()) {
			
			for (int i = 0; i < this.hijos.size(); i++) {

				int n = this.hijos.get(i).profundidad(value, ++prof);
				if (n != -1) {
					return n;
				}else {
					--prof;
				}
			}
		}
		return -1;
	}

	/**
	 * Método que inserta un nodo hijo que el nodo padre que deseemos
	 * @param padre, nodo padre en el que se inserta un nodo hijo
	 * @param value, atributo value que construira al nuevo nodo hijo
	 * @return nodo insertado, null si no se ha insertado
	 */
	public Nodo insertarNodo(Nodo padre, String value) {
		ArrayList <Nodo> hijosNew = new ArrayList();
		Nodo nodoNew = new Nodo(value, hijosNew);
		
		if (this.value.equals(padre.value)) {
			
			padre.hijos.add(nodoNew);
			return this;
			
		}else{
			
			for (int i = 0; i < hijos.size(); i++) {
				hijos.get(i).insertarNodo(padre, value);
			}
			
		}
		
		return padre.buscar(value);
		
	}

	/**
	 * Método que devuelve la ruta o camino dese la raiz hasta el nodo que se esta 
	 * buscando mediante su atributo valor
	 * @param valor, atributo del nodo al que se le quiere sacar la ruta
	 * @return
	 */

	public ArrayList<String> path(String valor, ArrayList<String> path) {

		if (!this.value.equals(valor)) { 
			for (int i = 0; i < this.hijos.size(); i++) {
				
				if (this.hijos.get(i).buscar(valor) != null && !this.hijos.get(i).value.equals(valor)) {
					this.hijos.get(i).path(valor, path); 
					path.add(this.value);
				}
				if (this.hijos.get(i).value.equals(valor)) {
					path.add(this.hijos.get(i).value);
					path.add(this.value);
				}
			}
		}else {			
			path.add(this.value); 
		}

		return path;
	}
	
	/**
	 * Metodo que mediante la recursividad sacara los hijos de los hijos y los añadirá 
	 * a la lista que se desee llamada por el arbol
	 * @param nodo, inicial al que se le buscan los hijos
	 * @param lista, a la que se añade el value del nodo
	 */
	public void hijosDeHijos(Nodo inicial, ArrayList<String> lista) {
		lista.add(inicial.value);
		for (int i = 0; i < inicial.hijos.size(); i++) {
			hijosDeHijos(inicial.hijos.get(i), lista);
		}
	}


	//TO STRING
	@Override
	public String toString() {
		return "Nodo [value: " + value + " | hijos: " + hijos + "]";
	}



	

}