package tp;

import apis.ColaPrioridadTDA;
import apis.ConjuntoTDA;
import apis.DiccionarioSimpleTDA;
import impl.ColaPrioridadLD;
import impl.ConjuntoLD;
import impl.DicSimpleL;
import interfaceapis.AdministradorDeColas;
import librerias.MetodosColaPrioridad;
import librerias.MetodosConjuntos;

public class AdministradorDeColasTP implements AdministradorDeColas{
	
	ColaPrioridadTDA colaPrioridad = new ColaPrioridadLD();
	ConjuntoTDA puestos = new ConjuntoLD();
	ConjuntoTDA idElementos = new ConjuntoLD();
	DiccionarioSimpleTDA elementos = new DicSimpleL();
	
	@Override
	public void inicializar(int cantidad) {
		puestos.inicializarConjunto();
		colaPrioridad.inicializarCola();	
		elementos.inicializarDiccionario();
		idElementos.inicializarConjunto();
		for (int i = 1 ; i <= cantidad ; i++) {
			puestos.agregar(i);
		}
	}
	
	@Override
	public int acolar(int prioridad) {
		int id = MetodosColaPrioridad.contar(colaPrioridad);
		id ++;
		colaPrioridad.acolarPrioridad(prioridad, id);
		idElementos.agregar(id);
		//Se acola con puesto 0 en el diccionario porque no tiene un puesto asignado aun
		elementos.agregar(id, 0);
		return id;
	}

	@Override
	public void acolar(int id, int prioridad) {
		if (!idElementos.pertenece(id)) {
			colaPrioridad.acolarPrioridad(prioridad,id);
			idElementos.agregar(id);
			//Se acola con puesto 0 en el diccionario porque no tiene un puesto asignado aun
			elementos.agregar(id, 0);
		}
		else {
			System.out.println("El id ingresado ya existe");
		}			
	}

	@Override
	public int desacolar(int puesto) {
		int elementoProximo = colaPrioridad.primero();
		colaPrioridad.desacolar();
		idElementos.sacar(elementoProximo);
		elementos.agregar(elementoProximo, puesto);
		return elementoProximo;
	}

	@Override
	public int cantPuestos() {
		int cantPuestos = MetodosConjuntos.contar(puestos);
		return cantPuestos;
	}

	@Override
	public int primero() {
		return colaPrioridad.primero();
	}

	@Override
	public int puestoDelElem(int idElemento) {
		return elementos.recuperar(idElemento);
	}

	@Override
	public DiccionarioSimpleTDA elementos() {
		return elementos;
	}

}
