package mvc.employee.view;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class AlertBox {

	public static Optional<ButtonType> showAndWait(AlertType alertType, String title, String message) {
		Alert alertCustomized = new Alert(alertType);
		alertCustomized.setTitle (title);
		alertCustomized.setHeaderText(message);
		if(alertType == AlertType.CONFIRMATION){
			alertCustomized.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);
		}

		return alertCustomized.showAndWait();
	}



}
