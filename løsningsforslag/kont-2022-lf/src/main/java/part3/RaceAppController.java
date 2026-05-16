package part3;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import part1.Post;
import part1.Race;

public class RaceAppController {

	private final RaceFormat raceFormat = new RaceFormat();

	@FXML
	TextField urlField;

	@FXML
	Label message;

	@FXML
	ListView<Post> postsList;

	@FXML
	void initialize() {
		urlField.setText(String.valueOf(getClass().getResource("sample-race.txt").toString()));
	}

	@FXML
	void handleLoad() {
		// clear list items first
		postsList.getItems().clear();;
		try {
			final URL url = new URL(urlField.getText());
			// load Race
			final Race race = raceFormat.readRace(url.openStream());
			// fill list with posts
			postsList.getItems().addAll(race.getPosts());
		} catch (final Exception e) {
			message.setText(e.getMessage());
		}
	}
}
