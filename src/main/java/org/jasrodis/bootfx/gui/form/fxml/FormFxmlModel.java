package org.jasrodis.bootfx.gui.form.fxml;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Component
public class FormFxmlModel {

	private static final Logger log = LoggerFactory.getLogger(FormFxmlModel.class);
	private final ReadOnlyIntegerWrapper personId = new ReadOnlyIntegerWrapper(this, "personId",
			personSequence.incrementAndGet());
	private final StringProperty firstName = new SimpleStringProperty(this, "firstName", null);
	private final StringProperty lastName = new SimpleStringProperty(this, "lastName", null);
	private final ObjectProperty<LocalDate> birthDate = new SimpleObjectProperty<>(this, "birthDate", null);

	// Keeps track of last generated person id
	private static AtomicInteger personSequence = new AtomicInteger(0);

	public enum AgeCategory {
		BABY, CHILD, TEEN, ADULT, SENIOR, UNKNOWN
	}

	public FormFxmlModel() {
		this(null, null, null);
	}

	public FormFxmlModel(String firstName, String lastName, LocalDate birthDate) {
		this.firstName.set(firstName);
		this.lastName.set(lastName);
		this.birthDate.set(birthDate);
	}

	/* personId Property */
	public final int getPersonId() {
		return personId.get();
	}

	public final ReadOnlyIntegerProperty personIdProperty() {
		return personId.getReadOnlyProperty();
	}

	/* firstName Property */
	public final String getFirstName() {
		return firstName.get();
	}

	public final void setFirstName(String firstName) {
		firstNameProperty().set(firstName);
	}

	public final StringProperty firstNameProperty() {
		return firstName;
	}

	/* lastName Property */
	public final String getLastName() {
		return lastName.get();
	}

	public final void setLastName(String lastName) {
		lastNameProperty().set(lastName);
	}

	public final StringProperty lastNameProperty() {
		return lastName;
	}

	/* birthDate Property */
	public final LocalDate getBirthDate() {
		return birthDate.get();
	}

	public final void setBirthDate(LocalDate birthDate) {
		birthDateProperty().set(birthDate);
	}

	public final ObjectProperty<LocalDate> birthDateProperty() {
		return birthDate;
	}

	/* Domain specific business rules */
	public boolean isValidBirthDate(final LocalDate bdate) {
		return isValidBirthDate(bdate, new ArrayList<>());
	}

	/* Domain specific business rules */
	public boolean isValidBirthDate(LocalDate bdate, List<String> errorList) {
		if (bdate == null) {
			return true;
		}

		// Birth date cannot be in the future
		if (bdate.isAfter(LocalDate.now())) {
			errorList.add("Birth date must not be in future.");
			return false;
		}

		return true;
	}

	/* Domain specific business rules */
	public boolean isValidPerson(List<String> errorList) {
		return isValidPerson(this, errorList);
	}

	/* Domain specific business rules */
	public boolean isValidPerson(FormFxmlModel p, List<String> errorList) {
		boolean isValid = true;

		String fn = p.firstName.get();
		if (fn == null || fn.trim().length() == 0) {
			errorList.add("First name must contain minimum one character.");
			isValid = false;
		}

		String ln = p.lastName.get();
		if (ln == null || ln.trim().length() == 0) {
			errorList.add("Last name must contain minimum one character.");
			isValid = false;
		}

		if (!isValidBirthDate(birthDate.get(), errorList)) {
			isValid = false;
		}

		return isValid;
	}

	/* Domain specific business rules */
	public AgeCategory getAgeCategory() {
		if (birthDate.get() == null) {
			return AgeCategory.UNKNOWN;
		}

		long years = ChronoUnit.YEARS.between(birthDate.get(), LocalDate.now());
		if (years >= 0 && years < 2) {
			return AgeCategory.BABY;
		} else if (years >= 2 && years < 13) {
			return AgeCategory.CHILD;
		} else if (years >= 13 && years <= 19) {
			return AgeCategory.TEEN;
		} else if (years > 19 && years <= 50) {
			return AgeCategory.ADULT;
		} else if (years > 50) {
			return AgeCategory.SENIOR;
		} else {
			return AgeCategory.UNKNOWN;
		}
	}

	/* Domain specific business rules */
	public boolean save(List<String> errorList) {
		boolean isSaved = false;
		if (isValidPerson(errorList)) {
			log.info("Saved : {}, ", this);
			isSaved = true;
		}

		return isSaved;
	}

	@Override
	public String toString() {
		return "[personId=" + personId.get() + ", firstName=" + firstName.get() + ", lastName=" + lastName.get()
				+ ", birthDate=" + birthDate.get() + "]";
	}
}