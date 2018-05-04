package org.jasrodis.bootfx;

import org.jasrodis.bootfx.gui.chart.ChartView;
import org.jasrodis.bootfx.gui.form.programmatic.FormView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javafx.application.Platform;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

@Component
@SuppressWarnings("unused")
public class BootFxView extends BorderPane {

	private static final Logger log = LoggerFactory.getLogger(BootFxView.class);

	private final ChartView chartView;
	private final FormView formView;

	TabPane tabPane = new TabPane();

	public BootFxView(ChartView chartView, FormView formView) {
		this.chartView = chartView;
		this.formView = formView;
		Platform.runLater(() -> {
			log.info("Initializing  [{}] ", getClass().getSimpleName());

			Tab chartTab = new Tab();
			chartTab.setText(chartView.getUserData().toString());
			chartTab.setContent(chartView);
			chartTab.setClosable(false);

			Tab formTab = new Tab();
			formTab.setText(formView.getUserData().toString());
			formTab.setContent(formView);
			formTab.setClosable(false);

			tabPane.getTabs().addAll(chartTab, formTab);
			setCenter(tabPane);
		});
	}

}
