package org.jasrodis.bootfx.gui.chart;

import static org.jasrodis.bootfx.gui.chart.ChartConstants.TABTITLE;

import java.util.ArrayList;
import java.util.Arrays;

import org.charts.dataviewer.javafx.example.factory.JavaFxDataViewerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

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
public class ChartView extends BorderPane {

	private static final Logger log = LoggerFactory.getLogger(ChartView.class);

	VBox vbLeft = new VBox();
	GridPane gpLeft = new GridPane();

	Label lbExample = new Label("Example:");
	ComboBox<String> cbExample = new ComboBox<>();

	Label lbExample2 = new Label("Example2:");
	TextField tfExample = new TextField();

	Label lbStartTime = new Label("Start time:");
	DatePicker dpStartTime = new DatePicker();

	Label lbEndTime = new Label("End time:");
	DatePicker dpEndTime = new DatePicker();

	ListView<String> lvMain = new ListView<>();
	ArrayList<String> list = new ArrayList<>();

	HBox hbBottom = new HBox();

	Button btPlotNew = new Button("Plot New");

	private final ChartModel model;

	public ChartView(ChartModel model) {
		log.info("Initializing [{}]", getClass().getSimpleName());
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
		lvMain.setItems(FXCollections.observableArrayList(list));
	}

	private void layoutForm() {
		setLeft(setLeftPanel());
		setCenter(setCenterPanel());
		setBottom(setBottomPanel());
	}

	private void bindFields() {
		// Bind fields to model
		cbExample.setItems(model.getNames());
		btPlotNew.disableProperty()
				.bind(cbExample.selectionModelProperty().isNotNull().and(tfExample.textProperty().isNotEmpty()).not());
	}

	private Node setLeftPanel() {
		// GridPane
		gpLeft.setAlignment(Pos.CENTER);
		gpLeft.setHgap(5);
		gpLeft.setVgap(5);

		gpLeft.add(lbExample, 1, 1);
		gpLeft.add(cbExample, 2, 1);

		gpLeft.add(lbExample2, 1, 2);
		gpLeft.add(tfExample, 2, 2);

		gpLeft.add(lbStartTime, 1, 3);
		gpLeft.add(dpStartTime, 2, 3);

		gpLeft.add(lbEndTime, 1, 4);
		gpLeft.add(dpEndTime, 2, 4);

		cbExample.setMaxWidth(Double.MAX_VALUE);

		vbLeft.setPadding(new Insets(5.0));
		vbLeft.getChildren().add(gpLeft);

		VBox.setVgrow(vbLeft, Priority.ALWAYS);
		return vbLeft;
	}

	private Node setCenterPanel() {
		return createSampleChart();
	}

	private Node setBottomPanel() {
		hbBottom.setAlignment(Pos.CENTER);
		HBox.setHgrow(hbBottom, Priority.ALWAYS);
		hbBottom.setPadding(new Insets(5.0));
		hbBottom.setSpacing(10.0);
		hbBottom.getChildren().addAll(btPlotNew);
		return hbBottom;
	}

	private HBox createSampleChart() {
		VBox vboxMiddle = new VBox();
		vboxMiddle.getChildren().add(JavaFxDataViewerFactory.createDataViewerExample1());

		HBox hbox = new HBox();
		hbox.getChildren().addAll(vboxMiddle);
		return hbox;
	}

}
