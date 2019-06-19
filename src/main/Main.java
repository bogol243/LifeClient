package main;

import java.net.*;

import ui.*;
import net.ClientNetComm;
import net.Protocol;
import om.*;

public class Main {
	
	public static void main(String args[]) throws Exception{
		MainFrame mf = new MainFrame();
		MainFrameListener mfl = new MainFrameListener(mf);
	}
}
