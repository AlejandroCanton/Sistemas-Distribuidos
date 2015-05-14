/*
 * Alejandro M Canton ID: 146514,
 * con base a lo propuesto por Francisco Gutierrez en
 * https://github.com/Innova4DLab/RMI
 */

package com.server;

import java.rmi.AccessException;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @author   Alejandro Morales Canton <alejandro.moralescn@udlap.mx>
 * @version  1
 * @since    2015-3-3
 */
public class RMIServer {

	public static final String RMI_ID = "TestRMI";
	/**
	 * Define el puerto en donde se encuentra el servidor.
	 */
	public static final int RMI_PORT = 8080;

	/**
	 *
	 * @param args
	 * @throws AccessException
	 * @throws RemoteException
	 * @throws AlreadyBoundException
	 */
	public static void main(String[] args) throws AccessException, RemoteException, AlreadyBoundException {

		ServerDefinition impl = new ServerDefinition();
		Registry registry = LocateRegistry.createRegistry(RMI_PORT);
		registry.bind(RMI_ID, impl);

		System.out.println("Server is running...");
	}
}
