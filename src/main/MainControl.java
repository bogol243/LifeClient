package main;

import java.io.IOException;

import net.*;
import om.Herbivore;
import om.Life;
import om.Plant;
import om.Predator;
import ui.*;

public class MainControl {
	private static ClientNetComm cnc = null;
	static ProtocolBackInfo lastUpdate;
	
	public static void connect(String ip, int port) {
		try {
			cnc = new ClientNetComm(ip, port);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public static void disconnect() {
		try {
			cnc.disconnect();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void save() {
		try {
			cnc.sendObject(new Protocol(Protocol.SAVE_WORLD,"save",new Life()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void load() {
		try {
			cnc.sendObject(new Protocol(Protocol.LOAD_WORLD,"save",new Life()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void update() {
		try {
			lastUpdate = cnc.update();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void create(Life l) {
		try {
			cnc.sendObject(new Protocol(Protocol.ADD_LIFE,"create",l));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void remove(Life l) {
		try {
			cnc.sendObject(new Protocol(Protocol.DELETE_LIFE,"delet",l));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void hunt(Life l) {
		try {
			cnc.sendObject(new Protocol(Protocol.HUNT,"hunt",l));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void eat(Life l) {
		try {
			cnc.sendObject(new Protocol(Protocol.EAT,"eat",l));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Predator[] getPredatorsInfo() {
		return lastUpdate.getPredatorsInfo();
	}

	public static Herbivore[] getHerbivoresInfo() {
		return lastUpdate.getHerbivoresInfo();
	}

	public static Plant[] getPlantsInfo() {
		return lastUpdate.getPlantsInfo();
	}
	
	public static void sendInfo(Protocol p) throws IOException{
		cnc.sendObject(p);
	}
}
