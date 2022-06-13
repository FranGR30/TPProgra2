package interfaceapis;

import apis.DiccionarioSimpleTDA;

public interface AdministradorDeColas {
	
		void inicializar(int cantidad);
		
		int acolar(int prioridad);
		
		void acolar(int id, int prioridad);
	
		int  desacolar(int puesto);
	
		int  cantPuestos();
	
		int primero();

		int puestoDelElem( int idElemento);
	
		DiccionarioSimpleTDA elementos();

}

