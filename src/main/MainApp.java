package main;

import java.util.ArrayList;

import models.Arbol;
import models.Nodo;

public class MainApp {
	public static void main(String[] args) {
		
		/*
		 * Creamos los nodos y los respectivos arrays que contendran a sus hijos.
		 * Aunque algún nodo no tenga actualmente hijos, se crea su array por si 
		 * en un futuro se le desean añadir.
		 */
		
		ArrayList <Nodo> hijosSeis = new ArrayList <Nodo>();
		Nodo seis = new Nodo ("seis", hijosSeis);
		
		ArrayList <Nodo> hijosCinco = new ArrayList <Nodo>();
		Nodo cinco = new Nodo ("cinco", hijosCinco);
		
		ArrayList <Nodo> hijosUno = new ArrayList <Nodo>();
		Nodo uno = new Nodo ("uno", hijosUno);
		
		ArrayList <Nodo> hijosDos = new ArrayList <Nodo>();
		Nodo dos = new Nodo ("dos", hijosDos);
		
		ArrayList <Nodo> hijosTres = new ArrayList <Nodo>();
		Nodo tres = new Nodo ("tres", hijosTres);
		
		ArrayList <Nodo> hijosCuatro = new ArrayList <Nodo>();
		Nodo cuatro = new Nodo ("cuatro", hijosCuatro);
		
		ArrayList <Nodo> hijosTernera = new ArrayList <Nodo>();
		Nodo ternera = new Nodo ("ternera", hijosTernera);
		
		ArrayList <Nodo> hijosCerdo = new ArrayList <Nodo>();
		Nodo cerdo = new Nodo ("cerdo", hijosCerdo);
		
		ArrayList <Nodo> hijosPollo = new ArrayList <Nodo>();	
		Nodo pollo = new Nodo ("pollo", hijosPollo);
		
		ArrayList <Nodo> hijosRaiz = new ArrayList <Nodo>();	
		Nodo raiz = new Nodo ("~", hijosRaiz);
		
		Arbol arbol = new Arbol (raiz);
		
		/*
		 * A cada array se añaden los hijos que corresponden
		 */
		hijosCinco.add(seis);
		hijosDos.add(cinco);
		hijosTernera.add(cuatro);
		hijosCerdo.add(tres);
		hijosPollo.add(uno);
		hijosPollo.add(dos);
		hijosRaiz.add(ternera);
		hijosRaiz.add(cerdo);		
		hijosRaiz.add(pollo);
		

		System.out.println("Árbol - PreOrden()");
		arbol.preOrden();
		System.out.println("\n");
		
		
		System.out.println("Árbol - PostOrden()");
		arbol.postOrden();
		System.out.println("\n");
		
		System.out.println("Buscar Nodo Seis en el árbol");
		System.out.println(arbol.buscarNodo("seis"));
		System.out.println("");
		
		System.out.println("Buscar Nodo Dos en el árbol");
		System.out.println(arbol.buscarNodo("dos"));
		System.out.println("");
		
		System.out.println("Mostrar árbol desde Raiz");
		arbol.mostrarArbol(raiz);
		System.out.println("");
		
		System.out.println("Mostrar árbol desde Ternera");
		arbol.mostrarArbol(ternera);
		System.out.println("");
		
		System.out.println("Path con Seis");
		System.out.println(arbol.path("Seis"));
		System.out.println("");

	}
}
