/*
 * Alejandro M Canton ID: 146514,
 * con base a lo propuesto por Francisco Gutierrez en
 * https://github.com/Innova4DLab/meteor-tutorial
 */

Tasks = new Mongo.Collection("tasks");

if (Meteor.isClient) {
  // Este código se ejecuta únicamente en el cliente
  Template.body.helpers({
    tasks: function () {
      return Tasks.find({});
    }
  });
  Template.body.events({
  "submit .new-task": function (event) {
    // Esta función será llamada despues de agregar un nuevo elemento

    var text = event.target.text.value;

    Tasks.insert({
      text: text,
      createdAt: new Date() // current time
    });

    // Clear form
    event.target.text.value = "";

    // Prevenir que se envíe por default
    return false;
  }
});

//Cambia el renglon de la lista a completado o lo elimina,
// dependiendo de donde le de click el usuario
Template.task.events({
  "click .toggle-checked": function () {
    Tasks.update(this._id, {$set: {checked: ! this.checked}});
  },
  "click .delete": function () {
    Tasks.remove(this._id);
  }
});
}

if (Meteor.isServer) {
  Meteor.startup(function () {
    // code to run on server at startup
  });
}
