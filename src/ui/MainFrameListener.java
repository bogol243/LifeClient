package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import main.MainControl;
import om.*;
import net.*;
public class MainFrameListener implements ActionListener{

	MainFrame mainFrame;
	
	public MainFrameListener(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		mainFrame.getConnectButton().addActionListener(this);
		mainFrame.getDisconnectButton().addActionListener(this);
		mainFrame.getSaveButton().addActionListener(this);
		mainFrame.getLoadButton().addActionListener(this);
		mainFrame.getClearButton().addActionListener(this);
		mainFrame.getCreateButton().addActionListener(this);
		mainFrame.getUpdateButton().addActionListener(this);
		mainFrame.getPredatorInfoButton().addActionListener(this);
		mainFrame.getHerbivoreInfoButton().addActionListener(this);
		mainFrame.getGrassInfoButton().addActionListener(this);
		mainFrame.getHuntButton().addActionListener(this);
		mainFrame.getPredatorRemoveButton().addActionListener(this);
		mainFrame.getHerbivoreRemoveButton().addActionListener(this);
		mainFrame.getGrassRemoveButton().addActionListener(this);
		mainFrame.getEatWeedButton().addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == mainFrame.getConnectButton()) {
			mainFrame.connectToServer();
			int port = Integer.parseInt(mainFrame.getPortTextField().getText());
			System.out.println(port);
			String ip = mainFrame.getIpTextField().getText();
			System.out.println(ip);
			MainControl.connect(ip, port);
		}
		if(event.getSource() == mainFrame.getDisconnectButton()) {
			mainFrame.disconnectFromServer();
			MainControl.disconnect();
		}
		
		if(event.getSource()== mainFrame.getSaveButton()) {
			MainControl.save();
		}
		if(event.getSource() == mainFrame.getUpdateButton()) {
			mainFrame.update();
		}
		if(event.getSource() == mainFrame.getLoadButton()) {
			MainControl.load();
		}
		if(event.getSource() == mainFrame.getCreateButton()) {
			Life l = null;
			if(mainFrame.getPredatorCheckbox().getState()) {
				//creating the predator
				l = new Predator(	0, 
									mainFrame.getNameTextField().getText(),
									Double.parseDouble(mainFrame.getWeightTextField().getText()));
			}
			if(mainFrame.getHerbivoreCheckbox().getState()) {
				l = new Herbivore(	0, 
									mainFrame.getNameTextField().getText(),
									Double.parseDouble(mainFrame.getWeightTextField().getText()));		
			}
			if(mainFrame.getGrassCheckbox().getState()) {
				l = new Plant(	0, 
						mainFrame.getNameTextField().getText(),
						Double.parseDouble(mainFrame.getWeightTextField().getText()));
			}
			MainControl.create(l);
		}
		if(event.getSource() == mainFrame.getHerbivoreInfoButton()) {
			System.out.println("HerbivoreInfoButton");
			mainFrame.udpateInfoHerbivore();
		}
		if(event.getSource() == mainFrame.getPredatorInfoButton()) {
			System.out.println("PredatorInfoButton");
			mainFrame.udpateInfoPredator();
		}
		if(event.getSource() == mainFrame.getGrassInfoButton()) {
			System.out.println("GrassInfoButton");
			mainFrame.udpateInfoPlant();
		}
		if(event.getSource()==mainFrame.getHuntButton()) {
			mainFrame.hunt();
		}
		if(event.getSource()==mainFrame.getEatWeedButton()) {
			mainFrame.eatWeed();
		}
		if(event.getSource()==mainFrame.getPredatorRemoveButton()) {
			mainFrame.removePredator();
		}
		if(event.getSource()==mainFrame.getHerbivoreRemoveButton()) {
			mainFrame.removeHerbivore();
		}
		if(event.getSource()==mainFrame.getGrassRemoveButton()) {
			mainFrame.removeGrass();
		}
	}
}
