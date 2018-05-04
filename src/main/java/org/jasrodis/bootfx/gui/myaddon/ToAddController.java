package org.jasrodis.bootfx.gui.myaddon;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javafx.scene.Parent;

@Component
public class ToAddController {

	private static final Logger log = LoggerFactory.getLogger(ToAddController.class);

	private final ToAddModel model;
	private final ToAddView view;

	public ToAddController(ToAddModel model, ToAddView view) {
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
