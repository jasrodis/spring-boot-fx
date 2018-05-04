package org.jasrodis.bootfx.gui.chart;

import java.util.Arrays;

import org.jasrodis.bootfx.service.RepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Component
@SuppressWarnings("unused")
public class ChartModel {

	private static final Logger log = LoggerFactory.getLogger(ChartModel.class);

	private ObservableList<String> names = FXCollections
			.observableArrayList(Arrays.asList("wookie", "demogorgon", "pied piper", "emancipator"));

	/* Repository Service */
	private final RepositoryService repositoryService;
	
	public ChartModel(RepositoryService repositoryService) {
		log.debug("Initializing [{}]", getClass().getSimpleName());
		this.repositoryService = repositoryService;
	}

	/*
	 * ********************* Setters / Getters *********************
	 */

	public ObservableList<String> getNames() {
		return names;
	}

}
