package part5;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {

	@FXML
	TextField input;
	@FXML
	Text output;

	@FXML
	void handleKvadrer() {
		try {
			final int num = Integer.valueOf(input.getText());
			output.setText(num + " * " + num + " = " + (num * num));
		} catch (final NumberFormatException e) {
			output.setText("\"" + input.getText() + "\" er ikke et tall");
		}
	}
}
