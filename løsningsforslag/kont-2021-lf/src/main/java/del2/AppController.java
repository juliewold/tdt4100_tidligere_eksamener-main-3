package del2;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AppController {
	
	//TODO - Add any needed fields here
	@FXML 
	public TextArea output;
	@FXML
	private TextField username, password;
	
	public static String logInSuccess = "Gratulerer du har logget inn!";
	public static String logInFailed = "Feil brukernavn eller passord";
	
	@FXML
	public void onLogIn() {
		String brukernavn = username.getText();// Extract username from FXML here
		String passord = password.getText(); // Extract password from FXML here
		
		if (brukernavn.equals("admin") && passord.equals("admin")) {
			output.setText(logInSuccess);
		}
		else {
			output.setText(logInFailed);
		}
	}
	
}
