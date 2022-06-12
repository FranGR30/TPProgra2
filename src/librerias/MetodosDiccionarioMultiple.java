package librerias;

import apis.ConjuntoTDA;
import apis.DiccionarioMultipleTDA;
import impl.ConjuntoLD;

public class MetodosDiccionarioMultiple {
	public static void pasar(DiccionarioMultipleTDA dm1, DiccionarioMultipleTDA dm2) {
		ConjuntoTDA conjClaves = new ConjuntoLD();
		ConjuntoTDA conjElementos = new ConjuntoLD();
		conjClaves.inicializarConjunto();
		conjElementos.inicializarConjunto();
		conjClaves = dm1.claves();
		while (!conjClaves.conjuntoVacio()) {
			int clave1 = conjClaves.elegir();
			conjElementos = dm1.recuperar(clave1);
			while (!conjElementos.conjuntoVacio()) {
				int subClaveElementos = conjElementos.elegir();
				dm2.agregar(clave1, subClaveElementos);
				conjElementos.sacar(subClaveElementos);
				if (!conjElementos.conjuntoVacio())
					subClaveElementos = conjElementos.elegir();
			}
			dm1.eliminar(clave1);
			conjClaves.sacar(clave1);
			if (!conjClaves.conjuntoVacio())
				clave1 = conjClaves.elegir();			
		}
	}
	
	public static void copiar(DiccionarioMultipleTDA dm1, DiccionarioMultipleTDA dm2) {
		ConjuntoTDA conjClaves = new ConjuntoLD();
		ConjuntoTDA conjElementos = new ConjuntoLD();
		conjClaves.inicializarConjunto();
		conjElementos.inicializarConjunto();
		conjClaves = dm1.claves();
		while (!conjClaves.conjuntoVacio()) {
			int clave1 = conjClaves.elegir();
			conjElementos = dm1.recuperar(clave1);
			while (!conjElementos.conjuntoVacio()) {
				int subClaveElementos = conjElementos.elegir();
				dm2.agregar(clave1, subClaveElementos);
				conjElementos.sacar(subClaveElementos);
				if (!conjElementos.conjuntoVacio())
					subClaveElementos = conjElementos.elegir();
			}
			conjClaves.sacar(clave1);
			if (!conjClaves.conjuntoVacio())
				clave1 = conjClaves.elegir();			
		}
	}
	
	public static void imprimir(DiccionarioMultipleTDA dm1) {
		ConjuntoTDA conjClaves = new ConjuntoLD();
		ConjuntoTDA conjElementos = new ConjuntoLD();
		conjClaves.inicializarConjunto();
		conjElementos.inicializarConjunto();
		conjClaves = dm1.claves();
		while (!conjClaves.conjuntoVacio()) {
			int clave1 = conjClaves.elegir();
			System.out.println("Clave: " + clave1);
			System.out.println("Elementos: ");
			conjElementos = dm1.recuperar(clave1);
			MetodosConjuntos.imprimir(conjElementos);
			conjClaves.sacar(clave1);
			if (!conjClaves.conjuntoVacio())
				clave1 = conjClaves.elegir();			
		}
	}
}
