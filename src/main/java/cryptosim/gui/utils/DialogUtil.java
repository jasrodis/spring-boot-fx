package cryptosim.gui.utils;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DialogUtil {

	public static void createDialog(AlertType type, String title, String content) {
		Alert dialog = new Alert(type);
		dialog.setResizable(false);
		dialog.setTitle(title);
		dialog.setHeaderText(null);
		dialog.setContentText(content);
		dialog.showAndWait();
	}
}