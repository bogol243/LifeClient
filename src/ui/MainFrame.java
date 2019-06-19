package ui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import main.MainControl;
import net.*;
import om.*;

public class MainFrame extends Frame{
	private Button connectButton;
	private Button disconnectButton;
	private Label ipLabel;
	private Label portLabel;
	private TextField portTextField;
	private TextField ipTextField;
	private TextField nameTextField;
	private Label nameLabel;
	private TextField weightTextField;
	private Label weightLabel;
	private Checkbox predatorCheckbox;
	private Checkbox herbivoreCheckbox;
	private Checkbox grassCheckbox;
	private CheckboxGroup selectThing;
	private Button createButton;
	private List predatorList;
	private List herbivoresList;
	private List grassList;
	private Label informationLabel;
	private Label predatorsLabel;
	private Label herbivoresLabel;
	private Label grassLabel;
	private Button huntButton;
	private Button predatorInfoButton;
	private Button predatorRemoveButton;
	private Button eatWeedButton;
	private Button herbivoreInfoButton;
	private Button herbivoreRemoveButton;
	private Button grassInfoButton;
	private Button grassRemoveButton;
	private TextArea infoArea;
	private Button clearButton;
	private Button saveButton;
	private Button loadButton;
	private Button updateButton;
	private Font mainFont = new Font("Calibri", Font.PLAIN, 20);
	public MainFrame() {
		setLayout(null);
		setResizable(false);
		addWindowListener(new WindowAdapter(){ 
			public void windowClosing(WindowEvent e){
			dispose(); 
			}
		});
		clearButton = new Button("Clear");
		clearButton.setFont(mainFont);
		clearButton.setBounds(50, 660, 300, 50);
		add(clearButton);
		connectButton = new Button("Connect");
		ipLabel = new Label("Ip");
		ipLabel.setFont(mainFont);
		ipLabel.setBounds(1200, 170, 100, 30);
		add(ipLabel);
		ipTextField = new TextField();
		ipTextField.setBounds(1200, 210, 100, 30);
		add(ipTextField);
		portLabel = new Label("Port");
		portLabel.setFont(mainFont);
		portLabel.setBounds(1320, 170, 100, 30);
		add(portLabel);
		portTextField = new TextField();
		portTextField.setBounds(1320, 210, 100, 30);
		add(portTextField);
		connectButton.setFont(mainFont);
		connectButton.setBounds(1200, 250, 220, 30);
		disconnectButton = new Button("Disconnect");
		disconnectButton.setBounds(1200, 290, 220, 30);
		disconnectButton.setFont(mainFont);
		add(disconnectButton);
		add(connectButton);
		updateButton = new Button("Update");
		updateButton.setBounds(1200,500, 200, 30);
		updateButton.setFont(mainFont);
		add(updateButton);
		selectThing = new CheckboxGroup();
		nameTextField = new TextField();
		nameLabel = new Label("Name");
		nameLabel.setBounds(50, 170, 100, 30);
		nameLabel.setFont(mainFont);
		add(nameLabel);
		nameTextField.setBounds(50,200,150,30);
		weightLabel = new Label("Weight");
		weightLabel.setBounds(205, 170, 100, 30);
		weightLabel.setFont(mainFont);
		add(weightLabel);
		weightTextField = new TextField();
		weightTextField.setBounds(205, 200, 150, 30);
		add(nameTextField);
		add(weightTextField);
		predatorCheckbox = new Checkbox("Predator");
		predatorCheckbox.setBounds(50,100,100, 30);
		herbivoreCheckbox = new Checkbox("Herbivore");
		herbivoreCheckbox.setBounds(160,100,100,30);
		grassCheckbox = new Checkbox("Grass");
		grassCheckbox.setBounds(270,100,100,30);
		predatorCheckbox.setFont(mainFont);
		herbivoreCheckbox.setFont(mainFont);
		grassCheckbox.setFont(mainFont);
		predatorCheckbox.setCheckboxGroup(selectThing);
		herbivoreCheckbox.setCheckboxGroup(selectThing);
		grassCheckbox.setCheckboxGroup(selectThing);
		createButton = new Button("Create");
		createButton.setBounds(50, 250, 300, 50);
		createButton.setFont(mainFont);
		predatorList = new List(5);
		predatorList.setBounds(400, 200, 200, 100);
		predatorsLabel = new Label("Predators");
		predatorsLabel.setBounds(400,170, 100, 30);
		predatorsLabel.setFont(mainFont);
		saveButton = new Button("Save");
		saveButton.setFont(mainFont);
		saveButton.setBounds(390, 100, 100, 30);
		add(saveButton);
		loadButton = new Button("Load");
		loadButton.setFont(mainFont);
		loadButton.setBounds(510, 100, 100, 30);
		add(loadButton);
		add(predatorsLabel);
		herbivoresList = new List(5);
		herbivoresList.setBounds(650, 200, 200, 100);
		herbivoresLabel = new Label("Herbivores");
		herbivoresLabel.setBounds(650,170, 100, 30);
		herbivoresLabel.setFont(mainFont);
		add(herbivoresList);
		add(herbivoresLabel);
		grassList = new List(5);
		grassList.setBounds(900, 200, 200, 100);
		grassLabel = new Label("Grass");
		grassLabel.setBounds(900,170, 100, 30);
		grassLabel.setFont(mainFont);
		predatorInfoButton = new Button("Get info");
		predatorInfoButton.setBounds(400, 310, 200, 30);
		predatorInfoButton.setFont(mainFont);
		add(predatorInfoButton);
		huntButton = new Button("Hunt!");
		huntButton.setBounds(400, 350, 200, 30);
		huntButton.setFont(mainFont);
		add(huntButton);
		predatorRemoveButton = new Button("Remove");
		predatorRemoveButton.setBounds(400, 390, 200, 30);
		predatorRemoveButton.setFont(mainFont);
		add(predatorRemoveButton);
		herbivoreInfoButton = new Button("Get info");
		herbivoreInfoButton.setBounds(650, 310, 200, 30);
		herbivoreInfoButton.setFont(mainFont);
		eatWeedButton = new Button("Eat grass");
		eatWeedButton.setBounds(650, 350, 200, 30);
		eatWeedButton.setFont(mainFont);
		herbivoreRemoveButton = new Button("Remove");
		herbivoreRemoveButton.setBounds(650, 390, 200, 30);
		herbivoreRemoveButton.setFont(mainFont);
		grassRemoveButton = new Button("Remove");
		grassRemoveButton.setBounds(900, 350, 200, 30);
		grassRemoveButton.setFont(mainFont);
		grassInfoButton = new Button("Get info");
		grassInfoButton.setBounds(900, 310, 200, 30);
		grassInfoButton.setFont(mainFont);
		add(grassInfoButton);
		add(grassRemoveButton);
		infoArea = new TextArea();
		infoArea.setBounds(50,350, 300, 300);
		infoArea.setEditable(false);
		informationLabel = new Label("Information");
		informationLabel.setBounds(150, 310, 150, 30);
		informationLabel.setFont(mainFont);
		add(informationLabel);
		add(infoArea);
		add(herbivoreInfoButton);
		add(eatWeedButton);
		add(herbivoreRemoveButton);
		add(grassList);
		add(grassLabel);
		add(predatorList);
		add(createButton);
		add(herbivoreCheckbox);
		add(grassCheckbox);
		add(predatorCheckbox);
		setSize(1920, 1080);
		setVisible(true);
		disconnectFromServer();
	}
	public void disconnectFromServer() {
		connectButton.setEnabled(true);
		disconnectButton.setEnabled(false);
		nameTextField.setEnabled(false);
		weightTextField.setEnabled(false);
		createButton.setEnabled(false);
		predatorCheckbox.setEnabled(false);
		herbivoreCheckbox.setEnabled(false);
		grassCheckbox.setEnabled(false);
		clearButton.setEnabled(false);
		huntButton.setEnabled(false);
		predatorInfoButton.setEnabled(false);
		predatorRemoveButton.setEnabled(false);
		eatWeedButton.setEnabled(false);
		herbivoreInfoButton.setEnabled(false);
		herbivoreRemoveButton.setEnabled(false);
		grassInfoButton.setEnabled(false);
		grassRemoveButton.setEnabled(false);
		ipTextField.setEnabled(true);
		portTextField.setEnabled(true);
		saveButton.setEnabled(false);
		loadButton.setEnabled(false);
		predatorList.setEnabled(false);
		herbivoresList.setEnabled(false);
		grassList.setEnabled(false);
	}
	public void connectToServer() {
		connectButton.setEnabled(false);
		disconnectButton.setEnabled(true);
		nameTextField.setEnabled(true);
		weightTextField.setEnabled(true);
		createButton.setEnabled(true);
		predatorCheckbox.setEnabled(true);
		herbivoreCheckbox.setEnabled(true);
		grassCheckbox.setEnabled(true);
		clearButton.setEnabled(true);
		huntButton.setEnabled(true);
		predatorInfoButton.setEnabled(true);
		predatorRemoveButton.setEnabled(true);
		eatWeedButton.setEnabled(true);
		herbivoreInfoButton.setEnabled(true);
		herbivoreRemoveButton.setEnabled(true);
		grassInfoButton.setEnabled(true);
		grassRemoveButton.setEnabled(true);
		ipTextField.setEnabled(false);
		portTextField.setEnabled(false);
		saveButton.setEnabled(true);
		loadButton.setEnabled(true);
		predatorList.setEnabled(true);
		herbivoresList.setEnabled(true);
		grassList.setEnabled(true);
	}
	public void update(){
		//update predators
		MainControl.update();
		
		//clear the lists
		predatorList.removeAll();
		herbivoresList.removeAll();
		grassList.removeAll();
		
		Predator[] ps = MainControl.getPredatorsInfo();
		for(int n = 0; n<ps.length;n++) {
			predatorList.add(ps[n].getName(), n);
		}
		//update herbivores
		Herbivore[] hs = MainControl.getHerbivoresInfo();
		for(int n = 0; n<hs.length;n++) {
			herbivoresList.add(hs[n].getName(), n);
		}		
		//update plants
		Plant[] gs = MainControl.getPlantsInfo();
		for(int n = 0; n<gs.length;n++) {
			grassList.add(gs[n].getName(), n);
		}
	}
	
	public void udpateInfoHerbivore(){
		//getting the proper unit
		int ind = herbivoresList.getSelectedIndex();
		Life observable = MainControl.getHerbivoresInfo()[ind];
		infoArea.setText(observable.getInfo());
	}
	
	public void udpateInfoPredator(){
		//getting the proper unit
		int ind = predatorList.getSelectedIndex();
		Life observable = MainControl.getPredatorsInfo()[ind];
		infoArea.setText(observable.getInfo());
	}
	
	public void udpateInfoPlant(){
		//getting the proper unit
		int ind = grassList.getSelectedIndex();
		Life observable = MainControl.getPlantsInfo()[ind];
		infoArea.setText(observable.getInfo());
	}
	
	public Button getConnectButton() {
		return connectButton;
	}
	public void setConnectButton(Button connectButton) {
		this.connectButton = connectButton;
	}
	public Button getDisconnectButton() {
		return disconnectButton;
	}
	public void setDisconnectButton(Button disconnectButton) {
		this.disconnectButton = disconnectButton;
	}
	public Label getIpLabel() {
		return ipLabel;
	}
	public void setIpLabel(Label ipLabel) {
		this.ipLabel = ipLabel;
	}
	public Label getPortLabel() {
		return portLabel;
	}
	public void setPortLabel(Label portLabel) {
		this.portLabel = portLabel;
	}
	public TextField getPortTextField() {
		return portTextField;
	}
	public void setPortTextField(TextField portTextField) {
		this.portTextField = portTextField;
	}
	public TextField getIpTextField() {
		return ipTextField;
	}
	public void setIpTextField(TextField ipTextField) {
		this.ipTextField = ipTextField;
	}
	public TextField getNameTextField() {
		return nameTextField;
	}
	public void setNameTextField(TextField nameTextField) {
		this.nameTextField = nameTextField;
	}
	public Label getNameLabel() {
		return nameLabel;
	}
	public void setNameLabel(Label nameLabel) {
		this.nameLabel = nameLabel;
	}
	public TextField getWeightTextField() {
		return weightTextField;
	}
	public void setWeightTextField(TextField weightTextField) {
		this.weightTextField = weightTextField;
	}
	public Label getWeightLabel() {
		return weightLabel;
	}
	public void setWeightLabel(Label weightLabel) {
		this.weightLabel = weightLabel;
	}
	public Checkbox getPredatorCheckbox() {
		return predatorCheckbox;
	}
	public void setPredatorCheckbox(Checkbox predatorCheckbox) {
		this.predatorCheckbox = predatorCheckbox;
	}
	public Checkbox getHerbivoreCheckbox() {
		return herbivoreCheckbox;
	}
	public void setHerbivoreCheckbox(Checkbox herbivoreCheckbox) {
		this.herbivoreCheckbox = herbivoreCheckbox;
	}
	public Checkbox getGrassCheckbox() {
		return grassCheckbox;
	}
	public void setGrassCheckbox(Checkbox grassCheckbox) {
		this.grassCheckbox = grassCheckbox;
	}
	public CheckboxGroup getSelectThing() {
		return selectThing;
	}
	public void setSelectThing(CheckboxGroup selectThing) {
		this.selectThing = selectThing;
	}
	public Button getCreateButton() {
		return createButton;
	}
	public void setCreateButton(Button createButton) {
		this.createButton = createButton;
	}
	public List getPredatorList() {
		return predatorList;
	}
	public void setPredatorList(List predatorList) {
		this.predatorList = predatorList;
	}
	public List getHerbivoresList() {
		return herbivoresList;
	}
	public void setHerbivoresList(List herbivoresList) {
		this.herbivoresList = herbivoresList;
	}
	public List getGrassList() {
		return grassList;
	}
	public void setGrassList(List grassList) {
		this.grassList = grassList;
	}
	public Label getInformationLabel() {
		return informationLabel;
	}
	public void setInformationLabel(Label informationLabel) {
		this.informationLabel = informationLabel;
	}
	public Label getPredatorsLabel() {
		return predatorsLabel;
	}
	public void setPredatorsLabel(Label predatorsLabel) {
		this.predatorsLabel = predatorsLabel;
	}
	public Label getHerbivoresLabel() {
		return herbivoresLabel;
	}
	public void setHerbivoresLabel(Label herbivoresLabel) {
		this.herbivoresLabel = herbivoresLabel;
	}
	public Label getGrassLabel() {
		return grassLabel;
	}
	public void setGrassLabel(Label grassLabel) {
		this.grassLabel = grassLabel;
	}
	public Button getHuntButton() {
		return huntButton;
	}
	public void setHuntButton(Button huntButton) {
		this.huntButton = huntButton;
	}
	public Button getPredatorInfoButton() {
		return predatorInfoButton;
	}
	public void setPredatorInfoButton(Button predatorInfoButton) {
		this.predatorInfoButton = predatorInfoButton;
	}
	public Button getPredatorRemoveButton() {
		return predatorRemoveButton;
	}
	public void setPredatorRemoveButton(Button predatorRemoveButton) {
		this.predatorRemoveButton = predatorRemoveButton;
	}
	public Button getEatWeedButton() {
		return eatWeedButton;
	}
	public void setEatWeedButton(Button eatWeedButton) {
		this.eatWeedButton = eatWeedButton;
	}
	public Button getHerbivoreInfoButton() {
		return herbivoreInfoButton;
	}
	public void setHerbivoreInfoButton(Button herbivoreInfoButton) {
		this.herbivoreInfoButton = herbivoreInfoButton;
	}
	public Button getHerbivoreRemoveButton() {
		return herbivoreRemoveButton;
	}
	public void setHerbivoreRemoveButton(Button herbivoreRemoveButton) {
		this.herbivoreRemoveButton = herbivoreRemoveButton;
	}
	public Button getGrassInfoButton() {
		return grassInfoButton;
	}
	public void setGrassInfoButton(Button grassInfoButton) {
		this.grassInfoButton = grassInfoButton;
	}
	public Button getGrassRemoveButton() {
		return grassRemoveButton;
	}
	public void setGrassRemoveButton(Button grassRemoveButton) {
		this.grassRemoveButton = grassRemoveButton;
	}
	public TextArea getInfoArea() {
		return infoArea;
	}
	public void setInfoArea(TextArea infoArea) {
		this.infoArea = infoArea;
	}
	public Button getClearButton() {
		return clearButton;
	}
	public void setClearButton(Button clearButton) {
		this.clearButton = clearButton;
	}
	public Button getSaveButton() {
		return saveButton;
	}
	public void setSaveButton(Button saveButton) {
		this.saveButton = saveButton;
	}
	public Button getLoadButton() {
		return loadButton;
	}
	public void setLoadButton(Button loadButton) {
		this.loadButton = loadButton;
	}
	public Font getMainFont() {
		return mainFont;
	}
	public void setMainFont(Font mainFont) {
		this.mainFont = mainFont;
	}
	public Button getUpdateButton() {
		return updateButton;
	}
	public void setUpdateButton(Button updateButton) {
		this.updateButton = updateButton;
	}
	
}
