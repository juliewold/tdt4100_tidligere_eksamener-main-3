package stuff;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MathController {
	
	Random rand;

	@FXML
	private ComboBox<Character> typeSelector;

	@FXML
	private TextField firstField;

	@FXML
	private TextField secondField;
	
	@FXML
	private TextArea resultArea;

	@FXML
	private void initialize() {
		rand = new Random();
		Collection<Character> tmp = new ArrayList<>();
		tmp.add('+');
		tmp.add('*');
		tmp.add('/');
		tmp.add('-');
		typeSelector.getItems().addAll(tmp);
		typeSelector.getSelectionModel().select(0);
	}


	/**
	 * Gather doubles from two textfields, apply a mathematical method, and update a text component.
	 */
	@FXML
	private void onCalculate() {
		double res;
		double val1 = Double.parseDouble(firstField.getText());
		double val2 = Double.parseDouble(secondField.getText());
		switch (typeSelector.getValue()) { // Could use chained if-elseif-else instead of switch
			case '+':
				res = val1 + val2;
				break;
			case '-':
				res = val1 - val2;
				break;
			case '*':
				res = val1 * val2;
				break;
			case '/':
				res = val1 / val2;
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + typeSelector.getValue());
		}
		
		resultArea.setText(Double.toString(res));
	}

	
	// Is there a method missing here? Where could it be?
	@FXML
	private void randomizeNumbers() {
		firstField.setText(Integer.toString(rand.nextInt(100) + 1));
		secondField.setText(Integer.toString(rand.nextInt(100) + 1));
	}
}
