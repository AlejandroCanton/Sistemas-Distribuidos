/*
 * Alejandro M Canton ID: 146514,
 * con base a lo propuesto por Francisco Gutierrez en
 * https://github.com/Innova4DLab/RMI
 */

package com.interf.test;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author   Alejandro Morales Canton <alejandro.moralescn@udlap.mx>
 * @version  1
 * @since    2015-3-3
 */
public interface TestRemote extends Remote{

	/*
	 * En ésta interfaz se definen los métodos que deberá
	 * implementar el servidor.
	 *
	 * En caso de agregar métodos que reciban o envíen objetos
	 * Se debe tener encuenta el serializado de dicho objeto (Marshalling).
	 * Para éste ejemplo definimos un simple método test.
	 *
	 * @param test Un String a comparar, si es idéntico a la palabra "test".
	 *
	 * @return true en caso de que sea idéntico a "test".
	 *
	 * @param operation Dos Integers a multiplicar
	 * @return resultado de multiplicacion de los numeros
	 *
	 * @param palindromo Un String a comparar con sí mismo, para ver si es un palíndromo
	 * (se lee igual al derecho que al reves)
	 *
	 * @return true en caso de que el String sea un palindromo
	 *
	 */
	public Boolean test(String test) throws RemoteException;
    public int operation(int num1, int num2 )throws RemoteException;
    public Boolean palindromo(String string) throws RemoteException;
}
