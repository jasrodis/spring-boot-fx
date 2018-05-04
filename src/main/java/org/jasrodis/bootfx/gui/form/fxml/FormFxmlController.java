package org.jasrodis.bootfx.gui.form.fxml;

import static org.jasrodis.bootfx.gui.form.fxml.FormFxmlConstants.TAB_NAME;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.jasrodis.bootfx.gui.utils.Dialogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

@Component
public class FormFxmlController implements Initializable {

	private static final Logger log = LoggerFactory.getLogger(FormFxmlController.class);

	private final FormFxmlModel model = new FormFxmlModel();

	private String dateFormat;

	@FXML
	Button btnClose;
	@FXML
	Button btnSave;
	@FXML
	TextField tfAgeCategory;
	@FXML
	TextField tfBirthDate;
	@FXML
	TextField tfFirstName;
	@FXML
	TextField tfLastName;
	@FXML
	TextField tfPersonId;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		log.debug("Initialized [{}]", getClass().getSimpleName());
		dateFormat = "MM/dd/yyyy";
		syncBirthDate();
		bindFieldsToModel();
	}

	private void bindFieldsToModel() {
		tfPersonId.textProperty().bind(model.personIdProperty().asString());
		tfFirstName.textProperty().bindBidirectional(model.firstNameProperty());
		tfLastName.textProperty().bindBidirectional(model.lastNameProperty());
	}

	@FXML
	private void handleBirthDateChange() {
		String bdateStr = tfBirthDate.getText();
		if (bdateStr == null || "".equals(bdateStr.trim())) {
			model.setBirthDate(null);
			syncBirthDate();
		} else {
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormat);
				LocalDate bdate = LocalDate.parse(bdateStr, formatter);

				List<String> errorList = new ArrayList<>();
				if (model.isValidBirthDate(bdate, errorList)) {
					model.setBirthDate(bdate);
					syncAgeCategory();
				} else {
					Dialogs.showError("Error in handleBirthDateChange() :", errorList.toString());
					syncBirthDate();
				}
			} catch (DateTimeParseException e) {
				// Birth date is not in the specified date format
				String errorMsg = "Birth date must be in the " + dateFormat.toLowerCase() + " format.";
				Dialogs.showError("Error in handleBirthDateChange() :", errorMsg);

				// Refresh the view
				syncBirthDate();
			}
		}
	}

	@FXML
	private void saveData() {
		List<String> errorList = new ArrayList<>();
		boolean isSaved = model.save(errorList);
		if (!isSaved) {
			Dialogs.showError("Error!", errorList.toString());
		}
	}

	@FXML
	private void closeApplication() {
		Platform.exit();
		System.exit(0);
	}

	public void syncBirthDate() {
		LocalDate bdate = model.getBirthDate();
		if (bdate != null) {
			tfBirthDate.setText(bdate.format(DateTimeFormatter.ofPattern(dateFormat)));
		}
		syncAgeCategory();
	}

	public void syncAgeCategory() {
		tfAgeCategory.setText(model.getAgeCategory().toString());
	}

	public FormFxmlModel getModel() {
		return model;
	}

	public Parent getViewAsParent() {
		Parent view = null;
		try {
			view = FXMLLoader.load(getClass().getResource(FormFxmlConstants.FXML_PATH));
			view.setUserData(TAB_NAME);
		} catch (IOException e) {
			log.error("Error in Loading FXML file ", e);
			e.printStackTrace();
		}
		return view;
	}

}
