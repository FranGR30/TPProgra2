package librerias;

import apis.ColaTDA;
import apis.ConjuntoTDA;
import apis.DiccionarioSimpleTDA;
import apis.PilaTDA;
import impl.ColaLD;
import impl.ConjuntoLD;
import impl.DicSimpleA;
import impl.PilaTI;

public class MetodosCola {
	public static void pasar(ColaTDA c1, ColaTDA c2) {
	/*pasa una cola a otra, dejando la cola original vacia. Parametro: dos colas*/
		while(!c1.colaVacia()) {
			c2.acolar(c1.primero());
			c1.desacolar();
		}
	}
	
	public static int contar(ColaTDA c1) {
	/*Cuenta los elementos en una cola. Parametro: una cola*/
		ColaTDA aux = new ColaLD();
		aux.inicializarCola();
		int cont = 0;
		copiar(c1,aux);
			while(!aux.colaVacia()) {
				cont ++;
				aux.desacolar();
			}
		return cont;
		}
	
	public static void copiar(ColaTDA c1, ColaTDA c2) {
	/*Copia una cola en otra, dejando la cola original intacta. Parametro: dos cola*/
		ColaTDA aux = new ColaLD();
		aux.inicializarCola();
		pasar(c1,aux);
		while(!aux.colaVacia()) {
			c1.acolar(aux.primero());
			c2.acolar(aux.primero());
			aux.desacolar();
		}
	}
	
	public static void invertirConPilas(ColaTDA c) {
	/*Invierte una cola usando pilas. Parametro: una cola*/	
		PilaTDA aux = new PilaTI();
		aux.inicializarPila();
		while(!c.colaVacia()) {
			aux.apilar(c.primero());
			c.desacolar();
		}
		while(!aux.pilaVacia()) {
			c.acolar(aux.tope());
			aux.desapilar();
		}
	}
	
	public static void imprimirCola(ColaTDA c) {
	/*Imprime la cola parametro. Parametro: una cola*/
		ColaTDA aux = new ColaLD();
		aux.inicializarCola();
		copiar(c,aux);
		while(!aux.colaVacia()) {
			System.out.println(aux.primero());
			aux.desacolar();
		}
	}
	
	public static void invertirSinPilarecursiva(ColaTDA c) {
		if (!c.colaVacia()) {
			int primero = c.primero();
			c.desacolar();
			invertirSinPilarecursiva(c);
			c.acolar(primero);
		}
	}
	
	public static void invertirSinPila(ColaTDA c) {
	/*Invierte una cola sin usar pilas. Parametro: una cola*/
		ColaTDA caux = new ColaLD();
		caux.inicializarCola();
		ColaTDA caux2 = new ColaLD();
		caux2.inicializarCola();
		int cont = 0;
		while(!c.colaVacia()) {
			caux.acolar(c.primero());
			cont ++;
			c.desacolar();
		}
		int cont2 = cont;
		for (int i = 0 ; i <= cont ; i++) {
			for (int j = 1 ; j < cont2 ; j++) {
				if (!caux.colaVacia()){
					caux2.acolar(caux.primero());
					caux.desacolar();
				}
			}
			if (!caux.colaVacia()) {
				c.acolar(caux.primero());
				caux.desacolar();
			}
			cont2 --;
			pasar(caux2,caux);
		}
	}
	
	public static boolean elementosFinales(ColaTDA c1 , ColaTDA c2) {
	/*Compara los ultimos elementos de dos colas y devuelve TRUE si son iguales. Parametro: dos colas*/
		invertirConPilas(c1);
		invertirConPilas(c2);
		boolean elementosIguales = false;
		if (c1.primero() == c2.primero())
			elementosIguales = true;
		return elementosIguales;
	}
	
	public static boolean capicua(ColaTDA c) {
	/*Determina si una cola es capicua. Parametro: una cola*/
		boolean esCapicua = true;
		ColaTDA caux = new ColaLD();
		caux.inicializarCola();
		ColaTDA caux2 = new ColaLD();
		caux2.inicializarCola();
		copiar(c,caux);
		copiar(c,caux2);
		invertirSinPila(caux);
		while(!caux.colaVacia()) {
			if (caux2.primero() != caux.primero())
				esCapicua = false;
			caux.desacolar();
			caux2.desacolar();
		}
		return esCapicua;
	}
	
	public static boolean colasInversas(ColaTDA c1, ColaTDA c2) {
	/*Determina si una cola es la inversa de otra. Parametro: dos cola*/
		boolean esInversa = true;
		ColaTDA caux = new ColaLD();
		caux.inicializarCola();
		ColaTDA caux2 = new ColaLD();
		caux2.inicializarCola();
		copiar(c1,caux);
		copiar(c2,caux2);
		invertirSinPila(caux2);
		if(contar(c1) != contar(c2))
			esInversa = false;
		else
			while(!caux.colaVacia()) {
				if (caux2.primero() != caux.primero())
					esInversa = false;
				caux.desacolar();
				caux2.desacolar();
				}
		return esInversa;
	}
	
	public static void eliminarRepetidos(ColaTDA c) {
		ColaTDA caux = new ColaLD();
		caux.inicializarCola();
		caux.acolar(c.primero());
		c.desacolar();
		int cantElementos = contar(caux);
		boolean esUnico = true;
		while (!c.colaVacia()) {
			while (cantElementos > 0) {
				if (c.primero() == caux.primero()) {
					esUnico = false;
				}
				cantElementos --;
				caux.acolar(caux.primero());
				caux.desacolar();
			}
			if (esUnico == true) {
				caux.acolar(c.primero());
			}
			c.desacolar();
			cantElementos = contar(caux);
			esUnico = true;
			
		}
		copiar(caux,c);
	}
	
	public static void repartirCola(ColaTDA c, ColaTDA m1, ColaTDA m2 ) {
		ColaTDA caux = new ColaLD();
		caux.inicializarCola();
		m1.inicializarCola();
		m2.inicializarCola();
		copiar(c,caux);
		for (int i = 0 ; i < contar(c)/2 ; i++) {
			m1.acolar(caux.primero());
			caux.desacolar();			
		}
		pasar(caux,m2);
	}
	
	public static void conjuntoRepetidos(ColaTDA c, ConjuntoTDA cj) {
		ColaTDA caux = new ColaLD();
		caux.inicializarCola();
		DiccionarioSimpleTDA d1 = new DicSimpleA();
		d1.inicializarDiccionario();
		copiar(c,caux);
		while (!caux.colaVacia()) {
			if (!(d1.claves().pertenece(caux.primero()))) {
				d1.agregar(caux.primero(), 1);
			}
			else
			d1.agregar(caux.primero(),2);	
			caux.desacolar();			
		}
		while (!d1.claves().conjuntoVacio()) {
			int clave = d1.claves().elegir(); 
			if (d1.recuperar(clave) == 2) {
				cj.agregar(clave);
			}
			d1.eliminar(clave);
			if (!d1.claves().conjuntoVacio()) {
				clave = d1.claves().elegir();
			}
		}
	}
	
	public static void elementosRepetidos(ColaTDA c) {
		ColaTDA caux = new ColaLD();
		caux.inicializarCola();
		ConjuntoTDA cjAux = new ConjuntoLD();
		cjAux.inicializarConjunto();
		ConjuntoTDA cjAux2 = new ConjuntoLD();
		cjAux2.inicializarConjunto();
		MetodosCola.copiar(c,caux);
		while(!caux.colaVacia()) {
			if (!cjAux.pertenece(caux.primero())){
				cjAux.agregar(caux.primero());
				caux.desacolar();
			}
			else {
				cjAux2.agregar(caux.primero());
				caux.desacolar();
			}
		}
		if(!cjAux2.conjuntoVacio()) {
			MetodosConjuntos.imprimir(cjAux2);
		}
		else {
			System.out.print("No hay elementos repetidos");
		}
	}
	/*pila:
	 * nodo aux = new nodo()
	 * aux.info = x
	 * aux.sig = primero
	 * primero = aux
	 * 
	 * Cola:
	 * nodo aux = new nodo()
	 * aux.info = x
	 * aux.sig = null
	 * if (ultimo != null):
	 * 	ultimo.sig = aux
	 * ultimo = aux
	 * if (primero == null):
	 * 	primero = aux
	 * 
	 * conjunto:
	 * if(!this.pertenece(x))
	 * 	nodo aux = new nodo()
	 * 	aux.info = x
	 * 	aux.sig = c
	 * 	c = aux
	 * 
	 * Cola Prioridad:
	 * NodoPrioridad nuevo = new NodoPrioridad()
	 * nuevo.info = x
	 * nuevo.prioridad = prioridad
	 * if (mayorPrioridad == null || prioridad > mayorPrioridad.prioridad)
	 * 	nuevo.sig = mayorPrioridad
	 * 	mayorPrioridad = nuevo
	 * else:
	 * 	NodoPrioridad aux = mayorPrioridad
	 * 	while (aux.sig != null && aux.sig.prioridad >= prioridad)
	 * 		aux = aux.sig
	 * 	nuevo.sig = aux.sig
	 * 	aux.sig = nuevo
	 * 
	 * Diccionarios:
	 * NodoClave nc = Clave2NodoClave(clave)
	 * if (nc == null)
	 * 	nc = new NodoClave()
	 * 	nc.clave = clave
	 * 	nc.sigClave = origen
	 * 	origen = nc
	 * nc.valor = valor
	 * 
	 * (q-1)/2 <= t
	 * FE = altura (arbol.hijoderecho) - altura (arbol.hijoizquierdo)
	 */
	
}
