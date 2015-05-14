package com.Innova4d.dpm;

/**
 * Esta versión no causa Deadlock.
 * Un filósofo podría morir de hambre.
 * 
 * @author Alejandro Morales Canton ID 146514
 * @version v1.0
 *
 */
public class CenaFilosofos {
	// Número de filósofos
	private static final int num_filosofos = 5;
    /**
     * Se crea el arreglo de filosofos, monitor y se inician los threads
     * @param args
     */
	public static void main (String[] args) {
		Filosofo[] filosofos = new Filosofo[num_filosofos];
		// El monitor controla la asignación de recursos compartidos.
		Monitor monitor = new Monitor(num_filosofos);
		for (int i = 0; i < num_filosofos; i++) {
			filosofos[i] = new Filosofo(i, monitor);
			new Thread(filosofos[i]).start();
		}
	}
}