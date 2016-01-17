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
public class SessionJoueur {
    public SessionJoueur(Session s) {
        this.session = s;
    }
    public Session session;
    public int id;
    public int idRoom;
    public int score;
    public int position;
    
}
