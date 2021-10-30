package application;

import java.net.URL;
import java.util.ResourceBundle;

import application.ScoreinfoManager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class FxFXMLController {
	
	
	@FXML private TableView<Scoreinfo> tblScore = new TableView<Scoreinfo>();
	
	ObservableList<Scoreinfo> data = FXCollections.observableArrayList();

	@FXML private TableColumn<Scoreinfo, String> colRanking = new TableColumn<>("#"); 
	@FXML private TableColumn<Scoreinfo, String> colName = new TableColumn<>("NIMIMERKKI");
    @FXML private TableColumn<Scoreinfo, String> colScore = new TableColumn<>("PISTEET");

	
	@FXML private TextField textName;
    @FXML private TextField textScore;
    
     
    // location and resources will be automatically injected by the FXML loader
    @FXML
    private URL location;
    @FXML
    private ResourceBundle resources;
     
    // Add a public no-args constructor
    public FxFXMLController() 
    {
    }
     
    @FXML
    private void initialize() {
    	System.out.print("test");
    	System.out.print(data.size());
    	
    	
    	colName.setCellValueFactory(new PropertyValueFactory<Scoreinfo, String>("name"));
    	colScore.setCellValueFactory(new PropertyValueFactory<Scoreinfo, String>("score"));
    	
    	tblScore.setItems(data);
    	tblScore.getColumns().addAll(colRanking, colName, colScore);
    }

	@FXML
    private void printOutput() {
		
		ScoreinfoManager scoreinfoManager = new ScoreinfoManager();
		//scoreinfoManager.create("haha", 1);
		scoreinfoManager.setup();
		scoreinfoManager.read(3);
		scoreinfoManager.exit();
		//data.addAll(scoreinfoManager.getAll());
		//data = FXCollections.observableArrayList(scoreinfoManager.getAll());
		
		//if ((textName.getText().isBlank() || textScore.getText().isBlank()) && (textName.getText().isEmpty() || textScore.getText().isEmpty())){
		//	System.out.println("ei voi lis‰t‰ tyhj‰‰");
		//	textName.setText(null);
    	//	textScore.setText(null);
    	//} else {
    	//	data.add(new Scoreinfo(textName.getText(), textScore.getText()));
    	//	textName.setText(null);
    	//	textScore.setText(null);
    	//}
	}
}
