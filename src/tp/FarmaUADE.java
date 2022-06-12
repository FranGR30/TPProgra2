package tp;

import java.util.Random;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class FarmaUADE {

	public static void main(String[] args) {
		AdministradorDeColasTP farmaUADE = new AdministradorDeColasTP();
		farmaUADE.inicializar(6);
		int opcion = 0;
		int prioridad = 0;
		int id = 0;
		Scanner leer = new Scanner(System.in);
		System.out.println("Indique lo que usted tiene ");
		System.out.println("1 - Obra Social");
		System.out.println("2 - Particular ");
		System.out.println("3 - PAMI ");
		System.out.println("4 - SALIR ");
		for (int i = 1 ; i <= 40 ; i++) {
		//opcion = leer.next();
		Random r1 = new Random();
		opcion = r1.nextInt(1,4);
		switch(opcion) {
		case 1:
			prioridad = 40;
			id = farmaUADE.acolar(prioridad);
			System.out.println("Usted tiene el turno OSO" + id );
			break;
		case 2:	
			prioridad  = 30;
			id = farmaUADE.acolar(prioridad);
			System.out.println("Usted tiene el turno PAR" + id );
			break;
		case 3:	
			prioridad  = 20;
			id = farmaUADE.acolar(prioridad);
			System.out.println("Usted tiene el turno PAM" + id );
			break;
		case 4:	
			break;
		default:
			System.out.println("La opcion ingresada no es validad");
		}
		}
		Timer timer = new Timer(4000, new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                // Tu Codigo
            }
        });
	}

}
