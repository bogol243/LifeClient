package net;

import java.net.*;

import net.*;
import om.Life;

import java.io.*;

public class ClientNetComm{
	private Socket socket;
	private ObjectOutputStream oos;
	private ObjectInputStream ois;
	
	public ClientNetComm(String ip, int port) throws IOException{
		connect(ip, port);
	}
	
	
	public void connect(String ip, int port) throws IOException{
			socket = new Socket(ip,port);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
	}
	
	public void disconnect() throws IOException{
		try {
			sendObject(new Protocol(Protocol.DISCONNECT,"disconnect",new Life()));
			oos.close();
			ois.close();
			socket.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//дегенерируем нужный код
	public void sendObject(Protocol p) throws IOException{
		oos.flush();
		oos.writeObject(p);
	}


	public ProtocolBackInfo update() throws IOException{
		//asking for an update
		Protocol msg = new Protocol(Protocol.UPDATE,"update",new Life());
		sendObject(msg);
		//waiting for response from server
		ProtocolBackInfo pbi = null;
		
		//трайкич блок
		try {
			pbi = (ProtocolBackInfo)ois.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		return pbi;
	}
	
	
}

