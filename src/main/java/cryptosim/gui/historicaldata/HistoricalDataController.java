package cryptosim.gui.historicaldata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javafx.scene.Parent;

@Component
public class HistoricalDataController {

	private static final Logger log = LoggerFactory.getLogger(HistoricalDataController.class);

	private final HistoricalDataModel model;
	private final HistoricalDataView view;

	public HistoricalDataController(HistoricalDataModel model, HistoricalDataView view) {
		log.info("Initializing HistoricalData Controller");
		this.model = model;
		this.view = view;
		attachEvents();
	}

	public Parent getView() {
		return view;
	}

	public void attachEvents() {
		view.btPlotNew.setOnAction((e) -> log.info("Somehting"));
	}

}
