import java.io.FileInputStream;

import beans.Verein;
import config.*;
import controls.Controller;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
	
public class UltimateLeagueGUI extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		VereinsDb v = new VereinsDb();
		Controller cont = new Controller();
		
		//Grid Definition
		GridPane root = new GridPane();
		root.setPadding(new Insets(10,10,10,10));
		root.setVgap(8);
		root.setHgap(10);
		
		//UI Control Defintions
		
		Button btnCreateTeam = new Button("Verein erstellen"); 
		
		
		
		root.setConstraints(btnCreateTeam,1,1);

		TextArea txtAnzeigeAreal = new TextArea();
		root.setConstraints(txtAnzeigeAreal,1,6);
		
		Button btnShowTable = new Button("Tabelle anzeigen"); 
		btnShowTable.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				txtAnzeigeAreal.setText(cont.getTeams().toString());				
			}
			}
		);
		
		root.setConstraints(btnShowTable,1,2);
		
		Button btnCreatePlan = new Button("Spielplan erstellen"); 
		root.setConstraints(btnCreatePlan,1,3);
		
		Button btnShowPlan = new Button("Spielplan anzeigen"); 
		root.setConstraints(btnShowPlan,1,4);
		btnShowPlan.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cont.getTeams();
			}
			
		});

		Button btnPlay = new Button("Spiel"); 
		btnPlay.setOnAction(new EventHandler<ActionEvent>() {
	        	    @Override 
	        	    public void handle(ActionEvent e) {
	        	    	final Stage dialog = new Stage();
	                    dialog.initModality(Modality.APPLICATION_MODAL);
	                    dialog.initOwner(primaryStage);
	                    VBox dialogVbox = new VBox(20);
	                    dialogVbox.getChildren().add(new Text("This is a Dialog"));
	                    Scene dialogScene = new Scene(dialogVbox, 300, 200);
	                    dialog.setScene(dialogScene);
	                    dialog.show();
	        	    }
	        	});
		root.setConstraints(btnPlay,1,5);
		
		
		
		FileInputStream input = new FileInputStream("C:\\Users\\epenner7169\\Documents\\ulieague112\\UltimateLeague\\src\\config\\prefererererererences.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(50.0);
        imageView.setFitWidth(50.0);

		
		Button btnPreferences = new Button(" ");
		btnPreferences.setGraphic(imageView);
		//btnPreferences.getStylesheets().add(getClass().getResource(""))
		root.setConstraints(btnPreferences,1,7);
		
		btnCreateTeam.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				cont.addTeam(txtAnzeigeAreal.getText());
			}
			
		});
		
		
		//Each UI Control has to be declared in this parameter
		root.getChildren().addAll(btnCreateTeam,btnShowPlan,btnShowTable,btnPlay,txtAnzeigeAreal,btnCreatePlan,btnPreferences);
		
		//Scene Defintion
		Scene scene = new Scene(root,400,450);
		scene.getStylesheets().add(getClass().getResource("config\\style.css").toExternalForm());
		
		//Start Scene
		primaryStage.setTitle("Ultimate Infinity League");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
