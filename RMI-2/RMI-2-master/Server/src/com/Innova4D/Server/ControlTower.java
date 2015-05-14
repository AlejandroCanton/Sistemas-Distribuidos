/*
 * Alejandro M Canton ID: 146514,
 * con base a lo propuesto por Francisco Gutierrez en
 * https://github.com/Innova4DLab/RMI-2
 */

package com.Innova4D.Server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import com.Innova4D.Interface.*;

public class ControlTower extends UnicastRemoteObject implements RemoteInterface {

	/*
	 * El constructor, protegido para asegurar la integridad de ControlTower.
	 * Protected: Accesible únicamente por ésta clase y sus subclases.
	 */
	protected ControlTower() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * { 0, 0, 0, 0, 0, 0, 0, 0 },
	 * { 0, 0, 0, 0, 0, 0, 0, 0 },
	 * { 0, 0, 0, 0, 0, 0, 0, 0 },
	 * { 0, 0, 0, 0, 0, 0, 0, 0 }
	 */
	private Object[][] mapaPista = new Object[4][8];

	private static final long serialVersionUID = 1L;

	/**
 	* Regresa el mapa de las pistas.
 	*/
	@Override
	public Object[][] getMapaPistas() throws RemoteException {
		return this.mapaPista;
	}

	/**
	 * Mueve un avión en la matriz, un bloque a la vez. Izq. Der.
	 */
	@Override
	public Boolean moverAvion(Avion a, int c) throws RemoteException {
		Boolean flag = false;
		int newY = a.getY() + 1;
		if (newY < 8) {
		try {
				this.mapaPista[c][a.getY()] = null;
				this.mapaPista[c][newY] = a;
				a.setX(0);
				a.setY(newY);
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		}
		return flag;
	}

  /**
 	* Busca por un avión en el mapa aéreo usando su ID.
 	* @param id El identificador del objeto.
 	* @param c  El carril donde se encuentra el objeto.
 	*/
	@Override
	public Avion getAvion(String id, int c) throws RemoteException {
		Avion a = null;
		for (int i = 0; i < 8; i++) {
		    if(this.mapaPista[c][i] != null){
		    	a = (Avion) this.mapaPista[c][i];
		    	if(!a.getId().equals(id))
		    		a = null;
		    }
		}
		return a;
	}

	@Override
	public Boolean checkInAvion(Avion a) throws RemoteException {
		if(this.mapaPista[a.getX()][a.getY()] == null)
			this.mapaPista[a.getX()][a.getY()] = a;
		return true;
	}

	/*
	 * Aquí comienzan los métodos del auto.
	 */

	@Override
	public Boolean checkInAuto(Auto a) throws RemoteException {
		if(this.mapaPista[a.getX()][a.getY()] == null)
			this.mapaPista[a.getX()][a.getY()] = a;
		return true;
	}
	@Override
	public Auto getAuto(String id, int c) throws RemoteException {
		Auto a = null;
		for (int i = 0; i < 8; i++) {
		    if(this.mapaPista[c][i] != null){
		    	a = (Auto) this.mapaPista[c][i];
		    	if(!a.getId().equals(id))
		    		a = null;
		    }
		}
		return a;
	}
	@Override
	public Boolean moverAuto(Auto a, int c) throws RemoteException {
		Boolean flag = false;
		int newY = a.getY() + 1;
		if (newY < 8) {
		try {
				this.mapaPista[c][a.getY()] = null;
				this.mapaPista[c][newY] = a;
				a.setX(0);
				a.setY(newY);
				flag = true;
			} catch (Exception e) {
				flag = false;
			}
		}
		return flag;
	}

    /*
     * Aquí comienzan los métodos del boeing.
     */
    public Boolean checkInBoeing(Boeing b) throws RemoteException {
        if(this.mapaPista[b.getX()][b.getY()] == null)
            this.mapaPista[b.getX()][b.getY()] = b;
        return true;
    }
    public Boeing getBoeing(String id, int c) throws RemoteException {
        Boeing b = null;
        for (int i = 0; i < 8; i++) {
            if(this.mapaPista[c][i] != null){
                b = (Boeing) this.mapaPista[c][i];
                if(!b.getId().equals(id))
                    b = null;
            }
        }
        return b;
    }
    public Boolean moverBoeing(Boeing b, int c) throws RemoteException {
        Boolean flag = false;
        int newY = b.getY() + 1;
        if (newY < 8) {
            try {
                this.mapaPista[c][b.getY()] = null;
                this.mapaPista[c][newY] = b;
                b.setX(0);
                b.setY(newY);
                flag = true;
            } catch (Exception e) {
                flag = false;
            }
        }
        return flag;
    }

    /*
	 * Aquí comienzan los métodos del ufo.
	 */
    public Boolean checkInUFO(UFO u) throws RemoteException {
        if(this.mapaPista[u.getX()][u.getY()] == null)
            this.mapaPista[u.getX()][u.getY()] = u;
        return true;
    }
    public UFO getUFO(String id, int c) throws RemoteException {
        UFO u = null;
        for (int i = 0; i < 8; i++) {
            if(this.mapaPista[c][i] != null){
                u = (UFO) this.mapaPista[c][i];
                if(!u.getId().equals(id))
                    u = null;
            }
        }
        return u;
    }
    public Boolean moverUFO(UFO u, int c) throws RemoteException {
        Boolean flag = false;
        int newY = u.getY() + 1;
        if (newY < 8) {
            try {
                this.mapaPista[c][u.getY()] = null;
                this.mapaPista[c][newY] = u;
                u.setX(0);
                u.setY(newY);
                flag = true;
            } catch (Exception e) {
                flag = false;
            }
        }
        return flag;
    }

}
