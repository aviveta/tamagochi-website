// var ws = new WebSocket("ws://localhost:8080/tama-game/example");
// ws.onopen = function()
// {
//     var room = getParameterByName('room');
//     var action = getParameterByName('a');
//     console.log(action);
//     console.log(room);
//     ws.send(action+";"+room);
// };

// ws.onmessage = function (evt) 
// { 			     	
//     var msg = evt.data;
//     alert("Message received:" +  msg);
//     //do action in the game
//     var msgs = msg.split(";");
//     if (msgs[0] == "move") {
//         game.inputMove(parseInt(msgs[1]));
//     }

//     if (msgs[0] == "transparent") {
//         game.inputTransparency(parseInt(msgs[1]));
//     }
// };

// ws.onclose = function()
// { 
//     alert("Connection is closed..."); 
// };



// function getParameterByName(name) {
//     name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
//     var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
//         results = regex.exec(location.search);
//     return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
// }
