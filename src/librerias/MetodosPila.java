package librerias;

import apis.ConjuntoTDA;
import apis.DiccionarioSimpleTDA;
import apis.PilaTDA;
import impl.ConjuntoLD;
import impl.DicSimpleA;
import impl.PilaLD;
import impl.PilaTI;

public class MetodosPila {
	public static void pasar(PilaTDA p1, PilaTDA p2) {
		while(!p1.pilaVacia()) {
			p2.apilar(p1.tope());
			p1.desapilar();
		}
	}
	
	public static void copiar(PilaTDA p1, PilaTDA p2) {
		PilaTDA aux = new PilaTI();
		aux.inicializarPila();
		pasar(p1, aux);
		while(!aux.pilaVacia()) {
			p2.apilar(aux.tope());
			p1.apilar(aux.tope());
			aux.desapilar();
		}
	}

	
	public static void imprimir(PilaTDA p1) {
		if (!p1.pilaVacia()) {
			PilaTDA pa = new PilaTI();
			pa.inicializarPila();
			copiar(p1,pa);
			while(!pa.pilaVacia()) {
				System.out.println(pa.tope());
				pa.desapilar();
			}
			
		}
		else System.out.println("Pila vacia");
	}
	
	public static void imprimirEficiente(PilaTDA p1) {
		if (!p1.pilaVacia()) {
			PilaTDA pa = new PilaTI();
			pa.inicializarPila();
			while(!p1.pilaVacia()) {
				System.out.println(p1.tope());
				pa.apilar(p1.tope());
				p1.desapilar();
			}
			pasar(pa,p1);
		}
		else
			System.out.println("Pila vacia");
	}
	
	public static void invertir(PilaTDA p1) {
		PilaTDA paux = new PilaTI();
		paux.inicializarPila();
		copiar(p1,paux);
		while(!p1.pilaVacia()) {
			p1.desapilar();
		}
		pasar(paux,p1);
	}
	
	public static int contar(PilaTDA p1) {
		PilaTDA paux = new PilaTI();
		paux.inicializarPila();
		int cont = 0;
		copiar(p1,paux);
		while(!paux.pilaVacia()) {
			paux.desapilar();
			cont ++;
		}
		return cont;
	}
	
	public static int sumar(PilaTDA p1) {
		PilaTDA paux = new PilaTI();
		paux.inicializarPila();
		int suma = 0;
		copiar(p1,paux);
		while(!paux.pilaVacia()) {
			suma = suma + paux.tope();
			paux.desapilar();
		}
		return suma;
	}
	
	public static int promediar(PilaTDA p1) {
		int suma = sumar(p1);
		int cont = contar(p1);
		int promedio = suma / cont;
		return promedio;
	}
	
	public static boolean capicua(PilaTDA p) {
		boolean esCapicua = true;
		PilaTDA paux = new PilaTI();
		PilaTDA paux2 = new PilaTI();
		paux.inicializarPila();
		paux2.inicializarPila();
		copiar(p,paux);
		copiar(p,paux2);
		invertir(paux2);
		int cantElementos = contar(paux);
		int cantElementos2 = cantElementos;
		if (cantElementos % 2 != 0) {
			cantElementos --;
		}
		while (cantElementos > cantElementos2 / 2) {
			if (paux.tope() != paux2.tope()) {
				esCapicua = false;
			}
			paux.desapilar();
			paux2.desapilar();
			cantElementos --;
		}
		return esCapicua;
	}
	
	public static void elementosUnicos(PilaTDA p) {
		invertir(p);
		PilaTDA paux = new PilaTI();
		PilaTDA paux2 = new PilaTI();
		PilaTDA paux3 = new PilaTI();
		paux.inicializarPila();
		paux2.inicializarPila();
		paux3.inicializarPila();
		boolean nrepetido = false;
		while (!p.pilaVacia()) {
			if (paux.pilaVacia()){
				paux2.apilar(p.tope());
				paux.apilar(p.tope());
			}
			while (!paux.pilaVacia()){
				if (p.tope() == paux.tope()) {
					nrepetido = true;
				}
				paux.desapilar();
			}
			paux3.apilar(p.tope());
			if (nrepetido == false) {
				/*System.out.println(p.tope());*/
				paux2.apilar(p.tope());
			}
			p.desapilar();
			copiar(paux3,paux);
			nrepetido = false;
		}
		copiar(paux2,p);
	}
	
	public static void repartirPila(PilaTDA p,PilaTDA M1, PilaTDA M2) {
		int nElementos = contar(p);
		int nElementos2 = nElementos;
		while (nElementos > nElementos2 / 2){
			M1.apilar(p.tope());
			p.desapilar();
			nElementos --;
		}
		while (!p.pilaVacia()) {
			M2.apilar(p.tope());
			p.desapilar();
		}
		invertir(M1);
		invertir(M2);
	}
	
	public static void conjuntoElementosRepetidos(PilaTDA p) {
		PilaTDA paux = new PilaTI();
		paux.inicializarPila();
		copiar(p,paux);
		DiccionarioSimpleTDA d1 = new DicSimpleA();
		d1.inicializarDiccionario();
		ConjuntoTDA c = new ConjuntoLD();
		c.inicializarConjunto();
		while (!paux.pilaVacia()) {
			if (!(d1.claves().pertenece(paux.tope()))) {
				d1.agregar(paux.tope(), 1);
			}
			else
			d1.agregar(paux.tope(),2);	
			paux.desapilar();			
		}
		while (!d1.claves().conjuntoVacio()) {
			int clave = d1.claves().elegir(); 
			if (d1.recuperar(clave) == 2) {
				c.agregar(clave);
			}
			d1.eliminar(clave);
			if (!d1.claves().conjuntoVacio()) {
				clave = d1.claves().elegir();
			}
		}
		MetodosConjuntos.imprimir(c);
	}
	
	public static void elementosRepetidos(PilaTDA p) {
		PilaTDA paux = new PilaLD();
		paux.inicializarPila();
		ConjuntoTDA cjAux = new ConjuntoLD();
		cjAux.inicializarConjunto();
		ConjuntoTDA cjAux2 = new ConjuntoLD();
		cjAux2.inicializarConjunto();
		MetodosPila.copiar(p,paux);
		while(!paux.pilaVacia()) {
			if (!cjAux.pertenece(paux.tope())){
				cjAux.agregar(paux.tope());
				paux.desapilar();
			}
			else {
				cjAux2.agregar(paux.tope());
				paux.desapilar();
			}
		}
		if(!cjAux2.conjuntoVacio()) {
			MetodosConjuntos.imprimir(cjAux2);
		}
		else {
			System.out.print("No hay elementos repetidos");
		}
	}
}