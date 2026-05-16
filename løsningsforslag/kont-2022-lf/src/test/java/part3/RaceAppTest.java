package part3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import part1.Post;

public class RaceAppTest extends ApplicationTest {

	private RaceAppController controller;

	private TextField urlField;
	private Button loadButton;
	private Label message;
	private ListView<Post> postsList;

	@Override
	public void start(final Stage stage) throws Exception {
		final FXMLLoader loader = new FXMLLoader(getClass().getResource("RaceApp.fxml"));
		final Parent root = loader.load();
		this.controller = loader.getController();
		stage.setScene(new Scene(root));
		stage.show();
	}

	@BeforeEach
	public void setupControls() {
		urlField = controller.urlField;
		loadButton = lookup("Load Race file").query();
		message = controller.message;
		postsList = controller.postsList;
	}

	@Test
	public void testApp_Controller_initial() {
		assertNotNull(this.controller);
	}

	@Test
	public void testApp_Controls() {
		assertNotNull(urlField);
		assertNotNull(loadButton);
		assertNotNull(message);
		assertNotNull(postsList);
	}

	@Test
	public void testApp_Load() {
		clickOn(loadButton);
		assertEquals(3, postsList.getItems().size());
	}

	@Test
	public void testApp_Kvadrer_tre() {
		clickOn(urlField).write("x", 0);
		clickOn(loadButton);
		assertEquals(0, postsList.getItems().size());
		assertTrue(message.getText().length() > 0);
	}
}
