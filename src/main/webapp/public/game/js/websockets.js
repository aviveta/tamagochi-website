	 var ws = new WebSocket("ws://localhost:8080/tama-game/example");
	 ws.onopen = function()
	 {
		alert("Web Socket is connected!!");			        
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



	ws.send("Message to server from client");
