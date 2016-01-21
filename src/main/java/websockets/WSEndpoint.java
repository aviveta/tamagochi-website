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

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;

import org.jboss.logging.Logger;

import java.util.*;
@ServerEndpoint(value = "/example", configurator = GetHttpSessionConfigurator.class)
@Stateless
public class WSEndpoint {
    public static HashMap<String,ArrayList<Session>> rooms;
    public static ArrayList<String> joueurs;
    static {
        rooms = new HashMap<String,ArrayList<Session>>(); 
        joueurs = new ArrayList<String>();
    }
    
    Logger log = Logger.getLogger(this.getClass());
    @Resource
    ManagedExecutorService mes;
    
    // private HttpSession sessionHttp;
    // private Session wsSession;
    
    @OnMessage
    public void receiveMessage(String message, Session session) {
        // Map<String,List<String>> mapQuery = session.getRequestParameterMap();
        // Map<String,String> mapQuery = getQueryMap(url.toString());
        log.info("Received : "+ message + ", session:" + session.getId());
        String[] params = message.split(";");
        String room = null;
        String action = null;
        String user = null;
        if (params.length == 2) {
            room = params[1];
            action = params[0];
        }
        if (params.length == 3) {
            room = params[1];
            action = params[0];
            user = params[2];
        }
        System.out.println(room);
        System.out.println(action);
        
        if (action != null && room != null ) {
            //creation room
            if (action.equals("creationRoom")) {
                log.info("Creation room" + room);
                rooms.put(room,new ArrayList<Session>());
                //ajout de l'ordinateur
                rooms.get(room).add(0,session);
            }
            //rejoindre
            if (action.equals("rejoindre")) {
                log.info("rejoindre" + session.getId());
                if (rooms.containsKey(room)) {
                    log.info("le joueur rejoint la room " + session.getId());
                    rooms.get(room).add(session);
                    //on envoie une notification au jeu 
                    try {
                        rooms.get(room).get(0).getBasicRemote().sendText("newPlayer");
                    } catch(Exception e) {e.printStackTrace();}
                }
            }
            //ingame
            if (action.equals("move") || action.equals("transparent")) {
                //recherche du joueur qui a envoye l'input
                Iterator<Session> it = rooms.get(room).iterator();
                boolean trouve = false;
                Session joueurCourant = null;
                int index = 0;
                while (!trouve && it.hasNext()) {
                    joueurCourant = it.next();
                    if (joueurCourant.getId().equals(session.getId())) {
                        trouve = true;
                    } else {
                        index++;
                    }
                }
                
                if (trouve) {
                    log.info("joueur :" + index);
                    if (action.equals("move")) {
                        //on envoie move avec l'id du joueur au bon afficheur client (ordinateur)
                        try {
                            rooms.get(room).get(0).getBasicRemote().sendText("move;"+index);
                        } catch(Exception e) {e.printStackTrace();}
                    }

                    if (action.equals("transparent")) {
                        //on envoie transparent avec l'id du joueur au bon afficheur client (ordinateur)
                        try {
                            rooms.get(room).get(0).getBasicRemote().sendText("transparent;"+index);
                        } catch(Exception e) {e.printStackTrace();}
                    }
            
                }
            }
        
        }
        // return message;
    }
  
    @OnOpen
    public void open(Session session, EndpointConfig config) {

        // this.wsSession = session;
        // this.httpSession = (HttpSession) config.getUserProperties()
        //                                    .get(HttpSession.class.getName());
        // System.out.println("KEKEKEKEKEK" + httpSession.getAttribute("username"));

        //creation de la room si on est le premier
        // URI url = session.getRequestURI();
        // Map<String,List<String>> mapQuery = session.getRequestParameterMap();

        // String[] params = message.split(";");
        // String room = null;
        // String action = null;
        // if (params.length >= 2) {
        //     room = params[1];
        //     action = params[0];
        // }
        
        // Map<String,String> mapQuery = getQueryMap(url.toString());
        
        //si creation -> creation room
        // if (action.equals("creationRoom")) {
        //     if (room != null) {
        //         log.info("Creation room" + session.getId());
        //         rooms.put(room,new ArrayList<Session>());
        //         //ajout de l'ordinateur
        //         rooms.get(room).add(0,session);
        //     }
        // }
        // //sinon on ajoute le joueur dans la room
        // if (action.equals("rejoindre")) {
        //     if (room != null) {
        //         if (rooms.containsKey(room)) {
        //             log.info("le joueur rejoint la room " + session.getId());
        //             rooms.get(room).add(session);
                    
        //             //on envoie une notification au jeu 
        //             try {
        //                 session.getBasicRemote().sendText("newPlayer");
        //             } catch(Exception e) {e.printStackTrace();}
                    
        //         } else {
        //             log.info("demande pas possible" + session.getId());
        //         }
                
        //     }
        // }
    }
  
    
    @OnClose
    public void close(Session session, CloseReason c) {
        //on quitte la room
        
        //si on est le premier, on supprime toute la room
        log.info("Closing:" + session.getId());
    }
}
