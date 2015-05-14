/*
 * Alejandro M Canton ID: 146514,
 * con base a lo propuesto por Francisco Gutierrez en
 * https://github.com/Innova4DLab/RMI
 */

package com.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.interf.test.TestRemote;

/**
 * @author   Alejandro Morales Canton <alejandro.moralescn@udlap.mx>
 * @version  1
 * @since    2015-3-3
 */

public class ServerDefinition extends UnicastRemoteObject implements TestRemote {

	/**
	 * Identificador único de la serialización (Default).
	 */
	private static final long serialVersionUID = 1L;

	protected ServerDefinition() throws RemoteException {
		super();
	}

    /**
     *
     * @param test
     * @return Boolean
     * @throws RemoteException
     */
	public Boolean test(String test) throws RemoteException {
		if(test.equalsIgnoreCase("test")) return true;
		return false;
	}


    /**
     * el Metodo operation recibe dos numeros y regresa la multiplicacion de los dos
     * @param num1
     * @param num2
     * @return int
     * @throws RemoteException
     */
    public int operation(int num1, int num2 )throws RemoteException  {
        int result;

        result = num1 * num2;

        return result;
    }



    /**
     * el Metodo palindromo recibe un String, y lo compara con sí mismo
     esto lo hace leyendo los caracteres de reversa y comparandose

     * @param string
     * @return Boolean
     * @throws RemoteException
     */
    public Boolean palindromo(String string) throws RemoteException {


        String string2 = "";

        for (int i = 0; i < string.length(); i++)
        {
            if (string.substring(i,i+1).equals(" ") == false )
            {
                string2 = string2 + string.substring(i,i+1);
            }
        }

        System.out.println(string2);

        string = (new StringBuilder(string2).reverse().toString());

        System.out.println(string);

        if (string.equals(string2))
            return true;

        return false;
    }

}
