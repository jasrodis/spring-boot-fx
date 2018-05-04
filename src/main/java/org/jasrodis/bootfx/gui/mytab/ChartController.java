package org.jasrodis.bootfx.gui.mytab;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javafx.scene.Parent;

@Component
public class ChartController {

	private static final Logger log = LoggerFactory.getLogger(ChartController.class);

	private final ChartModel model;
	private final ChartView view;

	public ChartController(ChartModel model, ChartView view) {
		log.info("Initializing [{}]", getClass().getSimpleName());
		this.model = model;
		this.view = view;
		attachEvents();
	}

	public Parent getView() {
		return view;
	}

	public void attachEvents() {
		view.btPlotNew.setOnAction(e -> log.info("Pressed"));
	}

}
