package cryptosim.gui.historicaldata;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cryptosim.repository.BitfinexRepository;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Component
public class HistoricalDataModel {

	private static final Logger log = LoggerFactory.getLogger(HistoricalDataModel.class);

	private ObservableList<String> exchangeNames = FXCollections
			.observableArrayList(Arrays.asList("kraken", "gdax", "binance", "bitfinex"));

	/* GUI properties */
	private final StringProperty selectedUser = new SimpleStringProperty(this, "selectedUser", null);

	/* Repository Service */
//	private final RepositoryService repositoryService;
	
	private final BitfinexRepository repo;

	public HistoricalDataModel(BitfinexRepository repo) {
		this.repo = repo;
//		this.repositoryService = repositoryService;
	}

	/*
	 * ********************* Setters / Getters *********************
	 */

	public StringProperty selectedUserProperty() {
		return selectedUser;
	}

	public ObservableList<String> getExchangeNames() {
		return exchangeNames;
	}

}
