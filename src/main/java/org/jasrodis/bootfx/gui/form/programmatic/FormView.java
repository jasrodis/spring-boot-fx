package org.jasrodis.bootfx.gui.form.programmatic;

import static org.jasrodis.bootfx.gui.form.programmatic.FormConstants.TAB_NAME;

import org.controlsfx.glyphfont.FontAwesome.Glyph;
import org.jasrodis.bootfx.gui.utils.GlyphFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

@Component
public class FormView extends BorderPane {

	private static final Logger log = LoggerFactory.getLogger(FormView.class);

	private final FormModel model;

	// GridPane
	GridPane gpMainGrid = new GridPane();

	// Labels
	Label lbPersonId = new Label("Person Id:");
	Label lbFirstName = new Label("First Name:");
	Label lbLastName = new Label("Last Name:");
	Label lbAgeCategory = new Label("Age Category:");

	// Fields
	TextField tfPersonId = new TextField();
	TextField tfFirstName = new TextField();
	TextField tfLastName = new TextField();
	TextField tfBirthDate = new TextField();
	TextField tfAgeCategory = new TextField();

	// Buttons
	Button btnSave = new Button("Save");
	Button btnClose = new Button("Close");

	// Date format
	String dateFormat;

	public FormView(FormModel model) {
		log.debug("Initialized [{}]", getClass().getSimpleName());
		this.model = model;
		Platform.runLater(() -> {
			setUserData(TAB_NAME);
			layoutForm();
			initFieldData();
			bindFieldsToModel();
		});
	}

	protected void initFieldData() {
		// Id and names are populated using bindings.
		// Populate birth date and age category
		btnSave.setGraphic(GlyphFactory.create(Glyph.SAVE));
		btnClose.setGraphic(GlyphFactory.create(Glyph.CLOSE));
	}

	protected void layoutForm() {
		gpMainGrid.setAlignment(Pos.CENTER);

		gpMainGrid.setHgap(5);
		gpMainGrid.setVgap(5);

		gpMainGrid.add(lbPersonId, 1, 1);
		gpMainGrid.add(lbFirstName, 1, 2);
		gpMainGrid.add(lbLastName, 1, 3);
		gpMainGrid.add(lbAgeCategory, 1, 4);

		gpMainGrid.add(tfPersonId, 2, 1);
		gpMainGrid.add(tfFirstName, 2, 2);
		gpMainGrid.add(tfLastName, 2, 3);
		gpMainGrid.add(tfAgeCategory, 2, 4);

		// Add buttons and make them the same width
		VBox buttonBox = new VBox(btnSave, btnClose);
		buttonBox.setSpacing(2.0);
		btnSave.setMaxWidth(Double.MAX_VALUE);
		btnClose.setMaxWidth(Double.MAX_VALUE);

		// TitledBorderedPane titledPane = Borders.wrapWithTitledBorderedPane("Edit",
		// null, buttonBox) titlepane example
		gpMainGrid.add(buttonBox, 3, 1, 1, 5);

		// Disable the personId field
		tfPersonId.setDisable(true);
		tfAgeCategory.setDisable(true);

		// Set the prompt text for the birth date field

		setCenter(gpMainGrid);
	}

	protected void bindFieldsToModel() {
		tfPersonId.textProperty().bind(model.personIdProperty().asString());
		tfFirstName.textProperty().bindBidirectional(model.firstNameProperty());
		tfLastName.textProperty().bindBidirectional(model.lastNameProperty());
	}


	public void syncAgeCategory() {
		tfAgeCategory.setText(model.getAgeCategory().toString());
	}

}
