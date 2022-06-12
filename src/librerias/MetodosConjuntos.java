package librerias;

import apis.ConjuntoTDA;
import impl.ConjuntoLD;

public class MetodosConjuntos {
	public static void pasar(ConjuntoTDA cj1, ConjuntoTDA cj2) {
			int elemento = cj1.elegir();
			while(!cj1.conjuntoVacio()) {
				cj2.agregar(elemento);
				cj1.sacar(elemento);
				if (!cj1.conjuntoVacio()) {
					elemento = cj1.elegir();
				}
			}
		}
	
	public static void copiar(ConjuntoTDA cj1, ConjuntoTDA cj2) {
		ConjuntoTDA cjAux = new ConjuntoLD();
		cjAux.inicializarConjunto();
		pasar(cj1,cjAux);
		int elemento = cjAux.elegir();
		while(!cjAux.conjuntoVacio()) {
			cj1.agregar(elemento);
			cj2.agregar(elemento);
			cjAux.sacar(elemento);
			if (!cjAux.conjuntoVacio()) {
				elemento = cjAux.elegir();
			}
		}
	}
	
	public static void imprimir(ConjuntoTDA cj1) {
		ConjuntoTDA cjAux = new ConjuntoLD();
		cjAux.inicializarConjunto();
		copiar(cj1,cjAux);
		int elemento = cjAux.elegir();
		while(!cjAux.conjuntoVacio()) {
			System.out.println(elemento);
			cjAux.sacar(elemento);
			if (!cjAux.conjuntoVacio()) {
				elemento = cjAux.elegir();
			}
		}
	}
	public static boolean conjuntosIguales(ConjuntoTDA cj1, ConjuntoTDA cj2) {
		ConjuntoTDA cjaux = new ConjuntoLD();
		cjaux.inicializarConjunto();
		copiar(cj1,cjaux);
		boolean sonIguales = true;
		int clave = cjaux.elegir();
		while (!cjaux.conjuntoVacio()) {
			if (!cj2.pertenece(clave)) {
				sonIguales = false;
				break;
			}
			cjaux.sacar(clave);
			if (!cjaux.conjuntoVacio()) {
				clave = cjaux.elegir();
			}
		}
	return sonIguales;
	}
	
	public static int contar(ConjuntoTDA cj) {
		ConjuntoTDA cjaux = new ConjuntoLD();
		cjaux.inicializarConjunto();
		copiar(cj,cjaux);
		int cont = 0;
		while (!cjaux.conjuntoVacio()) {
			cont ++;
			int elemento = cjaux.elegir();
			cjaux.sacar(elemento);
		}
		return cont;
	}
}
