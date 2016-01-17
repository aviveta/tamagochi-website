var ws = new WebSocket("ws://localhost:8080/tama-game/example");
     ws.onopen = function()
     {
       var room = getParameterByName('room');
       var action = getParameterByName('a');
       console.log(action);
       console.log(room);
       ws.send(action+";"+room);
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
    
    $("#move").on('click',function(e){
        e.preventDefault();
        ws.send("move;"+room);
    });
    
    $("#transparent").on('click',function(e){
        e.preventDefault();
        ws.send("transparent;"+room);
    });
})
