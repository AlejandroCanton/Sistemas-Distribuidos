/*
 * Alejandro M Canton ID: 146514,
 * con base a lo propuesto por Francisco Gutierrez en
 * https://github.com/Innova4DLab/Dining-Philosophers
 */

package com.Innova4d.DP;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * El problema de los filósofos (Esta versión causa un Deadlock).
 * @author Alejandro M Canton ID: 146514
 * @version 1.0
 */
public class CenaFilosofos {
	// El número de filósofos...
	private static final int NUM_FILOSOFOS = 5;
    private static Filosofo[] filosofos;

	/**
	 * Una prueba de los filósofos.
	 * @param args Not used
	 */
	public static void main (String[] args) {
		/*
		 *  Cada tenedor es un recurso compartido.
		 *  Los recursos compartidos en Java se definen como tipo Lock.
		 */
        filosofos = new Filosofo[NUM_FILOSOFOS];

        ReentrantLock[] tenedores = new ReentrantLock[NUM_FILOSOFOS];

        //Se crean los tenedores y se ponen en un arreglo
		for (int i = 0; i < NUM_FILOSOFOS; i++) {
			tenedores[i] = new ReentrantLock();
		}

        //Se crean los filósofos y se ponen en un arreglo
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            Filosofo filosofo = new Filosofo(i, tenedores[i],tenedores[(i+1)%NUM_FILOSOFOS]);
            filosofos[i] = filosofo;
        }

        //Se inician los threads de filosofos
        for (int i = 0; i < NUM_FILOSOFOS; i++) {
            new Thread(filosofos[i]).start();
        }


	}

}
