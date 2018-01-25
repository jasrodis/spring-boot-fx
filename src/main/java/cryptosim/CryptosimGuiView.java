package cryptosim;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cryptosim.gui.historicaldata.HistoricalDataView;
import javafx.application.Platform;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

@Component
public class CryptosimGuiView extends BorderPane {

	private static final Logger log = LoggerFactory.getLogger(CryptosimGuiView.class);
	private final HistoricalDataView hview;

	TabPane tabPane = new TabPane();
	List<Tab> tabList = new ArrayList<>();

	public CryptosimGuiView(HistoricalDataView hview) {
		this.hview = hview;
		Platform.runLater(() -> {
			log.info("Initializzed CryptoGuiView : !! ");
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
