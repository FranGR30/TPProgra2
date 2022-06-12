package librerias;

import apis.ColaPrioridadTDA;
import apis.DiccionarioMultipleTDA;
import impl.ColaPrioridadAO;
import impl.DicMultipleA;

public class MetodosColaPrioridad {
	public static void pasar(ColaPrioridadTDA cp1, ColaPrioridadTDA cp2) {
		while (!cp1.colaVacia()) {
			cp2.acolarPrioridad(cp1.primero(), cp1.prioridad());
			cp1.desacolar();
		}
	}
	
	public static void copiar(ColaPrioridadTDA cp1, ColaPrioridadTDA cp2) {
		ColaPrioridadTDA cpAux = new ColaPrioridadAO();
		cpAux.inicializarCola();
		pasar(cp1,cpAux);	
		while (!cpAux.colaVacia()) {
			cp1.acolarPrioridad(cpAux.primero(), cpAux.prioridad());
			cp2.acolarPrioridad(cpAux.primero(), cpAux.prioridad());
			cpAux.desacolar();
		}
	}
	
	public static void imprimir(ColaPrioridadTDA cp1) {
		ColaPrioridadTDA cpAux = new ColaPrioridadAO();
		cpAux.inicializarCola();
		copiar(cp1, cpAux);
		while (!cpAux.colaVacia()) {
			System.out.println(cpAux.primero());
			cpAux.desacolar();		
		}
	}
	
	public static void diccionarioAPartirDeCola(ColaPrioridadTDA cp, DiccionarioMultipleTDA d) {
		ColaPrioridadTDA cpAux = new ColaPrioridadAO();
		cpAux.inicializarCola();
		copiar(cp, cpAux);
		while (!cpAux.colaVacia()) {
			d.agregar(cpAux.primero(),cpAux.prioridad());
			cpAux.desacolar();
		}
	}
	
	public static int contar(ColaPrioridadTDA cp) {
		ColaPrioridadTDA cpAux = new ColaPrioridadAO();
		cpAux.inicializarCola();
		copiar(cp, cpAux);
		int cont = 0;
		while (!cpAux.colaVacia()) {
			cont ++;
			cpAux.desacolar();
		}
	return cont;
	}
	
}
