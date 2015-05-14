/**
 * Alejandro M Canton ID: 146514,
 * con base a lo propuesto por Francisco Gutierrez en
 * https://github.com/Innova4DLab/Play-WebService

 */

package controllers;

import play.*;
import play.mvc.*;

import views.html.*;


import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import play.api.libs.json.*;

import java.util.Hashtable;

public class Application extends Controller {

    /**
* El siguiente método solamente despliega
* un mensaje dentro del template index.
*/
    public static Result index()
    {
        return ok(index.render("Hola mundo, servicios web!!"));
    }

    /**
    * El siguiente método hace una multiplicación de enteros.
    * @param a el primer  entero.
    * @param b el segundo entero.
    * @return Resultado en formato Json.
    */
    public static Result getMultiplicacion(int a, int b){
        ObjectNode result = Json.newObject();
        result.put("Resultado de multiplicación", a*b );
        return ok(result);
    }

    /**
    * El siguiente método verifica si una cadena es un palíndromo.
    * @param word la palabra a validar.
    * @return true o false en formato Json.
    */

    public static Result getPalindromo(String word){
        ObjectNode result = Json.newObject();
        String myWord = word.replaceAll("\\s+","");
        String reverse = new StringBuffer(myWord).reverse().toString();
        result.put("result", reverse.equalsIgnoreCase(myWord));
        return ok(result);
    }

    /**
     * Cambia el número que entra de dolares americanos a pesos mexicanos
     * @param dolar
     * @return
     */
    public static Result getPesos(int dolar){
        double moneda = 15.237;
        ObjectNode result = Json.newObject();
        result.put("Cantidad en Pesos", dolar*moneda );
        return ok(result);
    }

    /**
     * Cambia el número que entra de grados fahrenheit a grados celsius
     * @param fahrenheit
     * @return
     */
    public static Result getCelsius(int fahrenheit){
        ObjectNode result = Json.newObject();
        result.put("Grados Celsius", (fahrenheit-32)*5/9   );
        return ok(result);
    }

    /**
     * Se pide al metodo que le regrese la capital del pais europeo correspondiente
     * lo anterior sucede con el uso de una hastable que tiene los datos necesarios.
     * @param pais
     * @return ObjectNode result con los datos
     */
    public static Result getCapital(String pais){
        String cadena = "Capital de " + pais;
        String capital = "";
        ObjectNode result = Json.newObject();

        Hashtable<String,String> hashtable;
        hashtable = new Hashtable<String, String>();

        hashtable.put("Alemania", "Berlin");
        hashtable.put("Austria", "Viena");
        hashtable.put("Belgica", "Bruselas");
        hashtable.put("Bulgaria", "Sofia");
        hashtable.put("Chipre", "Nicosia");
        hashtable.put("Croacia", "Zagreb");
        hashtable.put("Dinamarca", "Copenhague");
        hashtable.put("Eslovaquia", "Bratislava");
        hashtable.put("Eslovenia", "Liubliana");
        hashtable.put("España", "Madrid");
        hashtable.put("Estonia", "Tallin");
        hashtable.put("Finlandia", "Helsinki");
        hashtable.put("Francia", "Paris");
        hashtable.put("Grecia", "Atenas");
        hashtable.put("Hungria", "Budapest");
        hashtable.put("Irlanda", "Dublin");
        hashtable.put("Italia", "Roma");
        hashtable.put("Letonia", "Riga");
        hashtable.put("Lituania", "Vilna");
        hashtable.put("Luxemburgo", "Luxemburgo");
        hashtable.put("Malta", "La Valeta");
        hashtable.put("Noruega", "Oslo");
        hashtable.put("Paises Bajos", "Amsterdam");
        hashtable.put("Polonia", "Varsovia");
        hashtable.put("Portugal", "Lisboa");
        hashtable.put("Reino Unido", "Londres");
        hashtable.put("Republica Checa", "Praga");
        hashtable.put("Rumania", "Bucarest");
        hashtable.put("Suecia", "Estocolmo");
        hashtable.put("Suiza", "Berna");


        String t = hashtable.get(pais);
        if (t != null) {
            capital = t;
        }
        else
        {
            cadena = "Nombre inválido";
        }

        result.put(cadena, capital);
        return ok(result);
    }


    /**
     * Se pide al metodo que le regrese la posición de la embajada mexicana del pais europeo correspondiente
     * lo anterior sucede con el uso de una hastable que tiene los datos necesarios.
     * @param pais
     * @return ObjectNode result con los datos
     */
    public static Result getPosicionEmbajada(String pais){
        String cadena = "Posicion de la embajada de " + pais;
        String posicion = "";
        ObjectNode result = Json.newObject();

        //Se declara, crea y llena una hashtable con todos los datos necesarios
        Hashtable<String,String> hashtable;
        hashtable = new Hashtable<String, String>();

        hashtable.put("Alemania", "52.5077843,13.3517587");
        hashtable.put("Austria", "48.1998585,16.3700744");
        hashtable.put("Belgica", "50.8083158,4.3849209");
        hashtable.put("Dinamarca", "55.6864627,12.5918263");
        hashtable.put("España", "40.4160947,-3.6973632");
        hashtable.put("Finlandia", "60.1685662,24.9351516");
        hashtable.put("Francia", "48.8648275,2.292344");
        hashtable.put("Grecia", "37.9773269,23.7406908");
        hashtable.put("Hungria", "47.516701,19.0278825");
        hashtable.put("Irlanda", "53.3303151,-6.2387368");
        hashtable.put("Italia", "41.9133032,12.5097257");
        hashtable.put("Paises Bajos", "52.0899761,4.3059916");
        hashtable.put("Polonia", "52.22499,20.99128");
        hashtable.put("Portugal", "38.7375761,-9.2019543");
        hashtable.put("Reino Unido", "51.513845,-0.1422097");
        hashtable.put("Republica Checa", "50.0801273,14.4168633");
        hashtable.put("Rumania", "50.0801273,14.4168633");
        hashtable.put("Suecia", "59.3320685,18.0830599");

        String t = hashtable.get(pais);
        if (t != null) {
            posicion = t;
        }
        else
        {
            posicion = "Nombre inválido";
        }

        result.put(cadena, posicion);
        return ok(result);
    }

}
