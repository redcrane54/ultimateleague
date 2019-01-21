
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Game extends Application {

	@Override
	public void start(Stage primaryStage) {
		//Scene Defintion
		//Grid Definition
		GridPane root = new GridPane();
		root.setPadding(new Insets(10,10,10,10));
		root.setVgap(8);
		root.setHgap(10);
		
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
