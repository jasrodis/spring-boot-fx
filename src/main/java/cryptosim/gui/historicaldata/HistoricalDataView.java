package cryptosim.gui.historicaldata;

import java.util.ArrayList;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cryptosim.data.examples.DataViewerFactory;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

@Component
public class HistoricalDataView extends BorderPane {

	private final static Logger log = LoggerFactory.getLogger(HistoricalDataView.class);

	private final String TABTITLE = "Historical Data";

	VBox leftVBox = new VBox();
	GridPane leftGridPane = new GridPane();

	Label lbExchange = new Label("Exchange:");
	ComboBox<String> cbExchange = new ComboBox<>();

	Label lbPair = new Label("Pair:");
	TextField tfPair = new TextField();

	Label lbStartTime = new Label("Start time:");
	DatePicker dpStartTime = new DatePicker();

	Label lbEndTime = new Label("End time:");
	DatePicker dpEndTime = new DatePicker();

	ListView<String> listView = new ListView<>();
	ArrayList<String> list = new ArrayList<>();

	HBox bottomHBox = new HBox();

	Button btPlotNew = new Button("Plot New");
	Button btAppendPlot = new Button("Append Plot");

	private final HistoricalDataModel model;

	public HistoricalDataView(HistoricalDataModel model) {
		log.info("Initializing CommView");
		this.model = model;
		Platform.runLater(() -> {
			setUserData(TABTITLE);
			initFieldData();
			layoutForm();
			bindFields();
		});
	}

	private void initFieldData() {
		list.addAll(Arrays.asList("aaa", "bbb", "ccc"));
		listView.setItems(FXCollections.observableArrayList(list));
	}

	private void layoutForm() {
		setLeft(setLeftPanel());
		setCenter(setCenterPanel());
		setBottom(setBottomPanel());
	}

	private void bindFields() {
		// Bind fields to model
		cbExchange.setItems(model.getExchangeNames());
		btPlotNew.disableProperty()
				.bind(cbExchange.selectionModelProperty().isNotNull().and(tfPair.textProperty().isNotEmpty()).not());
		btAppendPlot.disableProperty()
				.bind(cbExchange.selectionModelProperty().isNotNull().and(tfPair.textProperty().isNotEmpty()).not());
	}

	private Node setLeftPanel() {
		// GridPane
		leftGridPane.setAlignment(Pos.CENTER);
		leftGridPane.setHgap(5);
		leftGridPane.setVgap(5);

		leftGridPane.add(lbExchange, 1, 1);
		leftGridPane.add(cbExchange, 2, 1);

		leftGridPane.add(lbPair, 1, 2);
		leftGridPane.add(tfPair, 2, 2);

		leftGridPane.add(lbStartTime, 1, 3);
		leftGridPane.add(dpStartTime, 2, 3);

		leftGridPane.add(lbEndTime, 1, 4);
		leftGridPane.add(dpEndTime, 2, 4);

		cbExchange.setMaxWidth(Double.MAX_VALUE);

		leftVBox.setPadding(new Insets(5.0));
		leftVBox.getChildren().add(leftGridPane);

		VBox.setVgrow(leftVBox, Priority.ALWAYS);
		return leftVBox;
	}

	private Node setCenterPanel() {
		return test1();
	}

	private Node setBottomPanel() {
		bottomHBox.setAlignment(Pos.CENTER);
		HBox.setHgrow(bottomHBox, Priority.ALWAYS);
		bottomHBox.setPadding(new Insets(5.0));
		bottomHBox.setSpacing(10.0);
		bottomHBox.getChildren().addAll(btPlotNew, btAppendPlot);
		return bottomHBox;
	}

	private HBox test1() {
		VBox vboxMiddle = new VBox();
		vboxMiddle.getChildren().add(DataViewerFactory.createDataViewerExample1());

		HBox hbox = new HBox();
		hbox.getChildren().addAll(vboxMiddle);
		return hbox;
	}

}
