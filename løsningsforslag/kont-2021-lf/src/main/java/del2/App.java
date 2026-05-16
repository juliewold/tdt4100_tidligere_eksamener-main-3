package del2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class App extends Application{
	
	@Override
	public void start(final Stage primaryStage) throws Exception {
		primaryStage.setTitle("My app");
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("Ui.fxml"));
		primaryStage.setScene(new Scene(loader.load()));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		App.launch(args);
	}

}
