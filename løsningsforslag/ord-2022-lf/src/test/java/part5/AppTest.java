package part5;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AppTest extends ApplicationTest {

	private Controller controller;

	private TextField input;
	private Text output;
	private Button kvadrer;

	@Override
	public void start(final Stage stage) throws Exception {
		final FXMLLoader loader = new FXMLLoader(getClass().getResource("App.fxml"));
		final Parent root = loader.load();
		this.controller = loader.getController();
		stage.setScene(new Scene(root));
		stage.show();
	}

	@BeforeEach
	public void setupControls() {
		input = lookup("#input").query();
		output = lookup("#output").query();
		kvadrer = lookup("Kvadrer:").query();
	}

	@Test
	public void testApp_Controller_initial() {
		assertNotNull(this.controller);
	}

	@Test
	public void testApp_Controls() {
		assertNotNull(input);
		assertNotNull(output);
		assertNotNull(kvadrer);
	}

	@Test
	public void testApp_Kvadrer_3() {
		clickOn(input).write("9", 0);
		clickOn(kvadrer);
		assertTrue(output.getText().contains("81"));
	}

	@Test
	public void testApp_Kvadrer_tre() {
		clickOn(input).write("tre", 0);
		clickOn(kvadrer);
		assertTrue(output.getText().contains("\"tre\""));
	}
}
