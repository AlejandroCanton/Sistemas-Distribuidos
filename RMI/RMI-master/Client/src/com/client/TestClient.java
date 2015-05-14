/*
 * Alejandro M Canton ID: 146514,
 * con base a lo propuesto por Francisco Gutierrez en
 * https://github.com/Innova4DLab/RMI
 */

package com.client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import com.interf.test.TestRemote;

/**
 * @author   Alejandro Morales Canton <alejandro.moralescn@udlap.mx> 146514
 * @version  1
 * @since    2015-3-3
 */
public class TestClient {
	public static final String RMI_ID = "TestRMI";
	/**
	 * Define el puerto en donde se encuentra el servidor.
	 */
	public static final int RMI_PORT = 8080;

    /**
     * @param args
     * @throws RemoteException
     * @throws NotBoundException
     */
	public static void main(String[] args) throws RemoteException, NotBoundException {
		Registry registry = LocateRegistry.getRegistry("localhost", RMI_PORT);
		TestRemote remote = (TestRemote) registry.lookup(RMI_ID);

        //Se declaran las variables a enviar al servidor
        int num1 = 12;
        int num2 = 23;
        String string = "anita lava la tina";

        //Se invoca el metodo del servidor "operation"
        System.out.println("La multiplicación de " + num1 + " y " + num2 + " es de: " + remote.operation(num1,num2));

        //Se invoca el metodo del servidor "palindromo"
        System.out.println("¿La cadena " + string + " es palindromo? " + remote.palindromo(string));
        System.out.println("¿La cadena " + "el dijo, yo dije, los dos dijimos" + " es palindromo? " + remote.palindromo("el dijo, yo dije, los dos dijimos"));
	}

}
