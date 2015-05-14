/*
 * Alejandro M Canton ID: 146514,
 * con base a lo propuesto por Francisco Gutierrez en
 * https://github.com/Innova4DLab/websocket-play

 * Aquí se escribirá código JavaScript puro, para conectarse al WebSocket
 */

/*
 * Iniciamos la conexión con websocket hacia el servidor
 * Cuando un mensaje es recibido se hace un parsing del JSON
 * Se obtiene el mensaje y se agrega a la vista.
 */
$(function() {
  var ws;

  //Speech funciona como un arreglo, del cual se obtendran las oraciones
  var speech = ["Hello there!","Welcome to the world of Pokémon!",
                "My name is Oak!","People call me the Pokémon Prof!",
                "This world is inhabited by creatures called Pokémon!",
                "For some people, Pokémon are pets",
                "Other use them for fights",
                "Myself… I study Pokémon as a profession",
                "First, what is your name?"];
  //Se define un contador para saber en que linea del speech se encuentra
  var contador = 0;

  ws = new WebSocket($("body").data("ws-url")); //Se toma La URL del Tag en Body
  ws.onmessage = function(event) {
    var message;
    message = JSON.parse(event.data);
    switch (message.type) {
      case "message":
        return $("#board tbody").append("<tr><td>"+ message.msg + "</td></tr>");
      default:
        return console.log(message);
    }
  };

  $("#msgform").submit(function(event) {
  event.preventDefault();
  console.log($("#msgtext").val());
  ws.send(JSON.stringify({ //Enviar el mensaje en el formulario como JSON.
    msg: $("#msgtext").val()
  }));
  return $("#msgtext").val("");

});

/* Se define una función que se realizará cada determinado tiempo,
*  en este caso, se realizará cada 5 seg (5000 milisegundos)
*  La variable speech es utilizado como un arreglo, el cual separa sus
*  oraciones con comas "," por lo que se pueden acceder a las oraciones
*  de la misma manera que en un arreglo. Se utiliza una variable contador
*  para determinar que oracion se obtendrá del arreglo, y se incrementa en uno
*  para que la próxima vez que se use la función (pasado el tiempo especificado)
*  se obtenga la siguiente oración. Lo anterior sucede hasta terminar el arreglo.
*/
window.setInterval(function(){

  ws.send(JSON.stringify({ //Enviar el mensaje en el formulario como JSON.
    msg: speech[contador].toString()
  }));
  contador = contador +1;

}, 5000); // Tiempo en milisegundos









});
