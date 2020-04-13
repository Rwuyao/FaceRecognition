package springboot.OpenCvNet.service;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import org.opencv.core.Mat;
import org.springframework.stereotype.Component;


@ServerEndpoint(value = "/websocket")
@Component
public class WebSocket {
	  
	    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>(); 	  
	    private Session session;  
	    @OnOpen  
	    public void onOpen(Session session) throws IOException{  
	    	//session.setMaxBinaryMessageBufferSize(280000);
	    	this.session = session;
	    	webSocketSet.add(this);  
	        System.out.println("Connect");
	    }  
	  
	    @OnClose  
	    public void onClose() throws IOException{  
	        webSocketSet.remove(this);  
	        System.out.println("romove");
	    }  
	  	   
	    @OnError
	    public void onError(Session session, Throwable error) {
	        System.out.println("error");
	        error.printStackTrace();
	    }	    	 	    
	    @OnMessage
	    public void onBinaryMessage(byte data[]) {	       	        
	          // System.out.println("recived");
	           bytetomat bttm = new bytetomat();            	
	           Mat result = bttm.convert(data);		           
	           result = Facedetect.facedetect(result);
	           ByteBuffer byteBuffer = ByteBuffer.wrap(bttm.rconvert(result));
	           this.session.getAsyncRemote().sendBinary(byteBuffer);
	           byteBuffer.clear();	             
	    }

}
