package exament3;

import java.util.Random;

public class Parchis {
	/**
	 * Constante para el tamaño del tablero
	 */
	public static final int TAM_TABLERO = 10;
	/**
	 * Variable para guardar el valor del dado1
	 */
	static int dado1;
	/**
	 * Variable para guardar el valor del dado2
	 */
	static int dado2;
	/**
	 * Variable para guardar el valor de fichaJ1
	 */
	int fichaJ1=0;
	/**
	 * Variable para guardar el valor de fichaJ2
	 */
	int fichaJ2=0;
	/**
	 * Variable para guardar el valor de nomJ1
	 */
	String nomJ1=""; 
	/**
	 * Variable para guardar el valor de nomJ2
	 */
	String nomJ2="";

	public Parchis() {
		super();
	}

	public Parchis(String nomJ1, String nomJ2) {
		super();
		this.nomJ1 = nomJ1;
		this.nomJ2 = nomJ2;
	}

	public static void tiraDados() {
		Random rand = new Random();
		dado1 = rand.nextInt(1, 7);
		dado2 = rand.nextInt(1, 7);
	}

	public void pintaTablero() {
		System.out.print("\tI");
		for (int i = 1; i < TAM_TABLERO; i++) {
			System.out.print("\t" + i);
		}
		System.out.println("\tF");

		System.out.print(nomJ1 + "\tI");

		for (int i = 1; i < TAM_TABLERO; i++) {
			if (i == fichaJ1) {
				System.out.print("\tO");
			} else {
				System.out.print("\t");
			}
		}

		System.out.println("\tF");
		

		System.out.print(nomJ2 + "\tI");

		for (int i = 1; i < TAM_TABLERO; i++) {
			if (i == fichaJ2) {
				System.out.print("\tO");
			} else {
				System.out.print("\t");
			}
		}
		System.out.println("\tF\n");


	}

	public void avanzaPosiciones(int jugador) {
		int tirada = dado1 + dado2;

		if (jugador == 1) {
			fichaJ1 += tirada;

			if (fichaJ1 > TAM_TABLERO) {
				fichaJ1 = TAM_TABLERO - (fichaJ1 - TAM_TABLERO);
			}
		} else if (jugador == 2) {
			fichaJ2 += tirada;

			if (fichaJ2 > TAM_TABLERO) {
				fichaJ2 = 2 * TAM_TABLERO - fichaJ2;
			}
		}
	}

	public void estadoCarrera() {
		if (fichaJ1 > fichaJ2) {
			System.out.println("Va ganando " + nomJ1);
		} else if (fichaJ1 < fichaJ2) {
			System.out.println("Va ganando " + nomJ2);
		} else {
			System.out.println("Van empatados");
		}
		System.out.println();
	}

	public String esGanador() {
		
		if (fichaJ1 == TAM_TABLERO) {
			return nomJ1;
		} else if (fichaJ2 == TAM_TABLERO) {
			return nomJ2;
		} else {
			return "";
		}

	}

}
