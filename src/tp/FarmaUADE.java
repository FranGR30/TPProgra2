package tp;

import java.util.Random;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



public class FarmaUADE {
	static AdministradorDeColasTP farmaUADE = new AdministradorDeColasTP();
	public static void main(String[] args) throws InterruptedException {
		PedirTurnoTest();
		
	}
	public static void PedirTurnoTest() throws InterruptedException {
		int cantPuestos = 0;
		@SuppressWarnings("resource")
		Scanner leer = new Scanner(System.in);
		System.out.println("Por favor, ingrese la cantidad de puestos: ");
		cantPuestos = leer.nextInt();
		farmaUADE.inicializar(cantPuestos);
		int opcion = 0;
		int prioridad = 0;
		int id = 0;
		System.out.println("Indique lo que usted tiene ");
		System.out.println("1 - Obra Social");
		System.out.println("2 - Particular ");
		System.out.println("3 - PAMI ");
		System.out.println("4 - SALIR ");
		for (int i = 1 ; i <= 40 ; i++) {
		//opcion = leer.next();
		Random r1 = new Random();
		opcion = r1.nextInt(3)+1;
		switch(opcion) {
		case 1:
			prioridad = 40;
			id = farmaUADE.acolar(prioridad);
			System.out.println("Usted tiene el turno OSO" + id + " prioridad: "+prioridad);
			break;
		case 2:	
			prioridad  = 30;
			id = farmaUADE.acolar(prioridad);
			System.out.println("Usted tiene el turno PAR" + id+ " prioridad: "+prioridad );
			
			break;
		case 3:	
			prioridad  = 20;
			id = farmaUADE.acolar(prioridad);
			System.out.println("Usted tiene el turno PAM" + id + " prioridad: "+prioridad);
			break;
		case 4:	
			break;
		default:
			System.out.println("La opcion ingresada no es validad");
		}
		}
		atenderGente(cantPuestos);
	}
	public static void atenderGente(int cantPuestos) throws InterruptedException {
		while(!farmaUADE.colaPrioridad.colaVacia()) {
			for(int i = 1; i <= cantPuestos;i++) {
				if(!farmaUADE.colaPrioridad.colaVacia()) {
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
					int info = farmaUADE.colaPrioridad.primero();	
					if(farmaUADE.colaPrioridad.prioridad() == 40) {
						System.out.println("Ticket OSO"+info+" Puesto de atención "+i+" Hora de atención: "+dtf.format(LocalDateTime.now()));
					}
					else if(farmaUADE.colaPrioridad.prioridad() == 30) {
						System.out.println("Ticket PAR"+info+" Puesto de atención "+i+" Hora de atención: "+dtf.format(LocalDateTime.now()));
					}
					else if(farmaUADE.colaPrioridad.prioridad() == 20) {
						System.out.println("Ticket PAM"+info+" Puesto de atención "+i+" Hora de atención: "+dtf.format(LocalDateTime.now()));
					}
					else {
						System.out.println("algo anduvo mal");
					}
					farmaUADE.desacolar(i);
				}
				else {
					break;
				}	
			}
			Thread.sleep(4000);

		}
				System.out.println("Ya no hay clientes para atender");
	
	

	}
}
