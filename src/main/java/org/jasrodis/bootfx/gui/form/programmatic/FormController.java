package org.jasrodis.bootfx.gui.form.programmatic;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import org.jasrodis.bootfx.gui.utils.Dialogs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class FormController {
	
	private static final Logger log = LoggerFactory.getLogger(FormController.class);

    final FormModel model;
    final FormView view;

    public FormController(FormModel model, FormView view) {
        this.model = model;
        this.view = view;
        attachEvents();
    }

    protected void attachEvents() {
        view.tfBirthDate.setOnAction(e -> handleBirthDateChange());
        view.btnSave.setOnAction(e -> saveData());
        view.btnClose.setOnAction(e -> view.getScene().getWindow().hide());
    }

    private void handleBirthDateChange() {
        String bdateStr = view.tfBirthDate.getText();
        if (bdateStr == null || "".equals(bdateStr.trim())) {
            model.setBirthDate(null);
        } else {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(view.dateFormat);
                LocalDate bdate = LocalDate.parse(bdateStr, formatter);

                List<String> errorList = new ArrayList<>();
                if (model.isValidBirthDate(bdate, errorList)) {
                    model.setBirthDate(bdate);
                    view.syncAgeCategory();
                } else {
                    Dialogs.showError("Error in handleBirthDateChange() :", errorList.toString());
                }
            } catch (DateTimeParseException e) {
                String errorMsg = "Birth date must be in the " + view.dateFormat.toLowerCase() + " format.";
                Dialogs.showError("Error in handleBirthDateChange() :", errorMsg);

            }
        }
    }

    private void saveData() {
        List<String> errorList = new ArrayList<>();
        boolean isSaved = model.save(errorList);
        if (!isSaved) {
            Dialogs.showError("Error in saveData() :", errorList.toString());
        }
    }

    public FormView getView() {
        return view;
    }

    public FormModel getModel() {
        return model;
    }
}
