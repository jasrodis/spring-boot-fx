package org.jasrodis.bootfx.gui.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Utility class for dialogs creation.
 * 
 * @author jasrodis
 */
public class Dialogs {
    private static final String INFO_TITLE = "Information";
    private static final String WARNING_TITLE = "Warning";
    private static final String ERROR_TITLE = "Error";
    private static final String EXCEPTION_TITLE = "Exception";
    private static final String CONFIRMATION_TITLE = "Confirmation";

    private Dialogs() {
    }

    private static Alert createAlert(AlertType type) {
        Alert alert = new Alert(type);
        alert.initStyle(StageStyle.DECORATED);
        // This is a workaround to https://bugs.openjdk.java.net/browse/JDK-8087981 as
        // reported here https://stackoverflow.com/questions/28937392/javafx-alerts-and-their-size/36938061#36938061
        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        return alert;
    }

    /**
     * Creates and shows an {@link Alert} with {@link AlertType#INFORMATION}.
     * 
     * @param headerText text to be displayed as header in the dialog
     * @param message text to be displayed in the dialog
     */
    public static void showInformation(String headerText, String message) {
        createInformation(headerText, message).showAndWait();
    }

    /**
     * Creates an {@link Alert} with {@link AlertType#INFORMATION}.
     * 
     * @param headerText text to be displayed as header in the dialog
     * @param message text to be displayed in the dialog
     * @return the {@link AlertType#INFORMATION} dialog
     */
    public static Alert createInformation(String headerText, String message) {
        Alert alert = createAlert(AlertType.INFORMATION);
        alert.setTitle(INFO_TITLE);
        alert.setHeaderText(headerText);
        alert.setContentText(message);
        return alert;
    }

    /**
     * Creates and shows an {@link Alert} with {@link AlertType#WARNING}.
     * 
     * @param headerText text to be displayed as header in the dialog
     * @param message text to be displayed in the dialog
     */
    public static void showWarning(String headerText, String message) {
        createWarning(headerText, message).showAndWait();
    }

    /**
     * Creates an {@link Alert} with {@link AlertType#WARNING}.
     * 
     * @param headerText text to be displayed as header in the dialog
     * @param message text to be displayed in the dialog
     * @return the {@link AlertType#WARNING} dialog
     */
    public static Alert createWarning(String headerText, String message) {
        Alert alert = createAlert(AlertType.WARNING);
        alert.setTitle(WARNING_TITLE);
        alert.setHeaderText(headerText);
        alert.setContentText(message);
        return alert;
    }

    /**
     * Creates and shows an {@link Alert} with {@link AlertType#ERROR}.
     * 
     * @param headerText text to be displayed as header in the dialog
     * @param message text to be displayed in the dialog
     */
    public static void showError(String headerText, String message) {
        createError(headerText, message).showAndWait();
    }

    /**
     * Creates an {@link Alert} with {@link AlertType#ERROR}.
     * 
     * @param headerText text to be displayed as header in the dialog
     * @param message text to be displayed in the dialog
     * @return the {@link AlertType#ERROR} dialog
     */
    public static Alert createError(String headerText, String message) {
        Alert alert = createAlert(AlertType.ERROR);
        alert.setTitle(ERROR_TITLE);
        alert.setHeaderText(headerText);
        alert.setContentText(message);
        return alert;
    }

    /**
     * Creates and shows an {@link Alert} with {@link AlertType#ERROR}, displaying a message and the stack trace of
     * given throwable in a collapsible details pane.
     * 
     * @param headerText text to be displayed as header in the dialog
     * @param message text to be displayed in the dialog
     * @param throwable the throwable to be displayed in the dialog
     */
    public static void showError(String headerText, String message, Throwable throwable) {
        createError(headerText, message, throwable).showAndWait();
    }

    /**
     * Creates {@link Alert} with {@link AlertType#ERROR}, displaying a message and the stack trace of given throwable
     * in a collapsible details pane.
     * 
     * @param headerText text to be displayed as header in the dialog
     * @param message text to be displayed in the dialog
     * @param throwable the throwable to be displayed in the dialog
     * @return the {@link AlertType#ERROR} dialog
     */
    public static Alert createError(String headerText, String message, Throwable throwable) {
        Alert alert = createAlert(AlertType.ERROR);
        alert.setTitle(EXCEPTION_TITLE);
        alert.setHeaderText(headerText);
        alert.setContentText(message);

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("Details:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        // Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);

        alert.getDialogPane().expandedProperty().addListener(observable -> Platform.runLater(() -> {
            alert.getDialogPane().requestLayout();
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.sizeToScene();
        }));
        return alert;
    }

    /**
     * Creates and shows an {@link Alert} with {@link AlertType#CONFIRMATION}.
     * 
     * @param headerText text to be displayed as header in the dialog
     * @param message text to be displayed in the dialog
     * @return the result of {@link Alert#showAndWait()}
     */
    public static Optional<ButtonType> showConfirmation(String headerText, String message) {
        return createConfirmation(headerText, message).showAndWait();
    }

    /**
     * Creates an {@link Alert} with {@link AlertType#CONFIRMATION}.
     * 
     * @param headerText text to be displayed as header in the dialog
     * @param message text to be displayed in the dialog
     * @return the confirmation dialog
     */
    public static Alert createConfirmation(String headerText, String message) {
        Alert alert = createAlert(AlertType.CONFIRMATION);
        alert.setTitle(CONFIRMATION_TITLE);
        alert.setHeaderText(headerText);
        alert.setContentText(message);
        return alert;
    }

    /**
     * Creates and shows an {@link Alert} with {@link AlertType#CONFIRMATION}, it is possible to add custom buttons to
     * the dialog.
     * 
     * @param headerText text to be displayed as header in the dialog
     * @param message text to be displayed in the dialog
     * @param customButtons custom buttons that will be displayed in the confirmation dialog
     * @return the result of {@link Alert#showAndWait()}
     */
    public static Optional<ButtonType> showConfirmation(String headerText, String message,
            ButtonType... customButtons) {
        return createConfirmation(headerText, message, customButtons).showAndWait();
    }

    /**
     * Creates an {@link Alert} with {@link AlertType#CONFIRMATION}, it is possible to add custom buttons to the dialog.
     * 
     * @param headerText text to be displayed as header in the dialog
     * @param message text to be displayed in the dialog
     * @param customButtons custom buttons that will be displayed in the confirmation dialog
     * @return the confirmation dialog
     */
    public static Alert createConfirmation(String headerText, String message, ButtonType... customButtons) {
        Alert alert = createAlert(AlertType.CONFIRMATION);
        alert.setTitle(CONFIRMATION_TITLE);
        alert.setHeaderText(headerText);
        alert.setContentText(message);
        alert.getButtonTypes().setAll(customButtons);
        return alert;
    }

	
}