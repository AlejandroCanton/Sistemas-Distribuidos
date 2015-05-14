/*
 * Alejandro M Canton ID: 146514,
 * con base a lo propuesto por Francisco Gutierrez en
 * https://github.com/Innova4DLab/RMI-2
 */

package com.Innova4D.Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author   Alejandro Morales Canton <alejandro.moralescn@udlap.mx>
 * @version  1
 * @since    2015-3-16
 */
public interface RemoteInterface extends Remote {

	/*
	 * Aquí se definen los métodos a implementarse en el servidor.
	 */
	public Object[][] getMapaPistas()  throws RemoteException;

	/*
	 * Métodos para el avión
	 */
	public Boolean checkInAvion(Avion a)      throws RemoteException;
	public Avion   getAvion(String id, int c) throws RemoteException;
	public Boolean moverAvion(Avion a, int c) throws RemoteException;

	/*
	 * Métodos para el auto.
	 */
	/**
	 * Registra al auto en la pista.
	 * @param a el auto que se desea hacer checkIn.
	 * @return
	 * @throws RemoteException
	 */
	public Boolean checkInAuto(Auto a)       throws RemoteException;
	public Auto    getAuto(String id, int c) throws RemoteException;
	public Boolean moverAuto(Auto a, int c)  throws RemoteException;

    /*
	 * Métodos para el boeing.
	 */
    public Boolean checkInBoeing(Boeing b) throws RemoteException;
    public Boeing getBoeing(String id, int c) throws RemoteException;
    public Boolean moverBoeing(Boeing b, int c) throws RemoteException;

    /*
	 * Métodos para el ufo.
	 */
    public Boolean checkInUFO(UFO u) throws RemoteException;
    public UFO getUFO(String id, int c) throws RemoteException;
    public Boolean moverUFO(UFO u, int c) throws RemoteException;


}
