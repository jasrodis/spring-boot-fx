package org.jasrodis.bootfx;

import java.util.ArrayList;
import java.util.List;

import org.jasrodis.bootfx.gui.myaddon.ToAddView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javafx.application.Platform;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

@Component
public class BootFxView extends BorderPane {

	private static final Logger log = LoggerFactory.getLogger(BootFxView.class);
	private final ToAddView view;

	TabPane tabPane = new TabPane();
	List<Tab> tabList = new ArrayList<>();

	public BootFxView(ToAddView hview) {
		this.view = hview;
		Platform.runLater(() -> {
			log.info("Initialized  [{}] ", getClass().getSimpleName());
			Tab tabToAdd = new Tab();
			tabToAdd.setText("Sample tab");
			tabToAdd.setContent(hview);
			tabToAdd.setClosable(false);
			tabList.add(tabToAdd);
			tabPane.getTabs().add(tabToAdd);
			setCenter(tabPane);
		});
	}

}
