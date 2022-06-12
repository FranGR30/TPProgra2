package librerias;

import apis.ConjuntoTDA;
import apis.DiccionarioSimpleTDA;
import impl.ConjuntoLD;


public class MetodosDiccionariosSimples {
	public static void pasar(DiccionarioSimpleTDA d1, DiccionarioSimpleTDA d2) {
		ConjuntoTDA conjClaves = new ConjuntoLD();
		conjClaves.inicializarConjunto();
		conjClaves = d1.claves();
		while (!conjClaves.conjuntoVacio()) {
			int clave1 = conjClaves.elegir();
			d2.agregar(clave1, d1.recuperar(clave1));
			d1.eliminar(clave1);
			conjClaves.sacar(clave1);
			if (!conjClaves.conjuntoVacio())
				clave1 = conjClaves.elegir();			
		}
	}
	
	public static void copiar(DiccionarioSimpleTDA d1, DiccionarioSimpleTDA d2) {
		ConjuntoTDA conjClaves = new ConjuntoLD();
		conjClaves.inicializarConjunto();
		conjClaves = d1.claves();
		while (!conjClaves.conjuntoVacio()) {
			int clave1 = conjClaves.elegir();
			d2.agregar(clave1, d1.recuperar(clave1));
			conjClaves.sacar(clave1);
			if (!conjClaves.conjuntoVacio())
				clave1 = conjClaves.elegir();			
		}
	}
	
	public static void imprimir(DiccionarioSimpleTDA d1) {
		ConjuntoTDA conjClaves = new ConjuntoLD();
		conjClaves.inicializarConjunto();
		conjClaves = d1.claves();
		while (!conjClaves.conjuntoVacio()) {
			int clave1 = conjClaves.elegir();
			System.out.println(d1.recuperar(clave1));
			conjClaves.sacar(clave1);
			if (!conjClaves.conjuntoVacio())
				clave1 = conjClaves.elegir();			
		}
	}
}
