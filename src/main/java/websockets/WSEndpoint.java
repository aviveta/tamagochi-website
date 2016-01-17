package websockets;

import java.io.IOException;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.jboss.logging.Logger;

import java.util.*;
@ServerEndpoint("/example")
@Stateless
public class WSEndpoint {
    public static HashMap<String,ArrayList<SessionJoueur>> rooms;
    public static ArrayList<String> joueurs;
    static {
        rooms = new HashMap<String,ArrayList<SessionJoueur>>(); 


        joueurs = new ArrayList<String>();
        
    }
    
    Logger log = Logger.getLogger(this.getClass());
    @Resource
    ManagedExecutorService mes;

    
    @OnMessage
    public String receiveMessage(String message, Session session) {
        log.info("Received : "+ message + ", session:" + session.getId());

        if (message.equals("move")) {
            //room contient -> ordinateur puis les joueurs
            
            //on envoie move avec l'id du joueur au bon afficheur client (ordinateur)

            
        }

        if (message.equals("transparent")) {
            //on envoie transparent avec l'id du joueur au bon afficheur client (ordinateur)
            
        }
        
    
        return "kebab return";
    }
  
    @OnOpen
    public void open(Session session) {
        //creation de la room si on est le premier

        //sinon on rejoint la room
        log.info("Open session:" + session.getId());

        joueurs.add("joueur"+session.getId());
        String res = "";
        for (String j : joueurs)
            res += j + "\n";
        try {
        session.getBasicRemote().sendText(res);
        } catch(Exception e) {e.printStackTrace();}
       
    }
  
    @OnClose
    public void close(Session session, CloseReason c) {


        //on quitte la room
        
        //si on est le premier, on supprime toute la room
        log.info("Closing:" + session.getId());
    }
}
