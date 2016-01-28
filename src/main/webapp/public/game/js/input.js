var domain = window.location.host;
var ws = new WebSocket("ws://"+domain+"/tama-game/example");
     ws.onopen = function()
     {
       var room = getParameterByName('room');
       var action = getParameterByName('a');
         var usermail = getParameterByName('user_email');
       console.log(action);
       console.log(room);
       ws.send(action+";"+room+";"+usermail);
   };
ws.onmessage = function (evt) 
{ 			     	
    var msg = evt.data;
    alert("Message received:" +  msg);
};
ws.onclose = function()
{ 
    alert("Connection is closed..."); 
};
    function getParameterByName(name) {
        name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
        var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
            results = regex.exec(location.search);
        return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
    }

jQuery(document).ready(function($){

    var room = getParameterByName('room');

    var button_state = 'A';
    var previous_state = 'A';

    //a/b -> send message
    
    $("#button-a").on('click',function(e){
        e.preventDefault();
        previous_state = button_state;
        button_state = 'A';
        if (previous_state != button_state) {
           ws.send("move;"+room);
        }
    });

   $("#button-b").on('click',function(e){
      e.preventDefault();
      previous_state = button_state;
      button_state = 'B';
      if (previous_state != button_state) {
         ws.send("move;"+room);
      }
   });


    
    $("#button-transparent").on('click',function(e){
        e.preventDefault();
        ws.send("transparent;"+room);
    });
})
