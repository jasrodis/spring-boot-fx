package org.jasrodis.bootfx.chart.examples;

import org.charts.dataviewer.api.config.DataViewerConfiguration;
import org.charts.dataviewer.api.data.PlotData;
import org.charts.dataviewer.javafx.JavaFxDataViewer;
import org.charts.dataviewer.utils.AxisType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * DataViewer usages examples
 *  
 * @author jasrodis
 */
public class DataViewerFactory {

	private final static Logger logger = LoggerFactory.getLogger(DataViewerFactory.class.getName());

	public static JavaFxDataViewer createDataViewerExample1() {

		JavaFxDataViewer dataviewer = new JavaFxDataViewer();
		
		DataViewerConfiguration config = new DataViewerConfiguration();
		config.setPlotTitle("Line Trace Example");
		config.setxAxisTitle("X Example 1");
		config.setyAxisTitle("Y Example 1");
		config.showLegend(true);
		config.setLegendInsidePlot(false);
		dataviewer.updateConfiguration(config);

		PlotData plotData = new PlotData();

		plotData.addTrace(TraceFactory.createLineTrace());
		plotData.addTrace(TraceFactory.createLineTraceWithConfig());

		dataviewer.updatePlot(plotData);

		return dataviewer;
	}

	public static JavaFxDataViewer createDataViewerExample2() {

		JavaFxDataViewer dataviewer = new JavaFxDataViewer();

		DataViewerConfiguration config = new DataViewerConfiguration();
		config.setPlotTitle("Multiple Trace Example");
		config.setxAxisTitle("X Example 2");
		config.setyAxisTitle("Y Example 2");
		config.showLegend(false);
		dataviewer.updateConfiguration(config);

		PlotData plotData = new PlotData();

		plotData.addTrace(TraceFactory.createBarTrace());
		plotData.addTrace(TraceFactory.createLineTrace());
		plotData.addTrace(TraceFactory.createScatterTraceWithConfig());

		dataviewer.updatePlot(plotData);
		return dataviewer;
	}

	public static JavaFxDataViewer createDataViewerExample3() {
		JavaFxDataViewer dataviewer = new JavaFxDataViewer();

		DataViewerConfiguration config = new DataViewerConfiguration();
		config.setPlotTitle("Bar Trace Example");
		config.setxAxisTitle("X Example 3");
		config.setyAxisTitle("Y Example 3");
		config.showLegend(false);
		dataviewer.updateConfiguration(config);

		PlotData plotData = new PlotData();

		plotData.addTrace(TraceFactory.createBarTrace());
		plotData.addTrace(TraceFactory.createBarTrace());
		plotData.addTrace(TraceFactory.createBarTrace());

		dataviewer.updatePlot(plotData);
		return dataviewer;
	}

	public static JavaFxDataViewer createDataViewerExample4() {
		JavaFxDataViewer dataviewer = new JavaFxDataViewer();

		DataViewerConfiguration config = new DataViewerConfiguration();
		config.setPlotTitle("Scatter Trace Example");
		config.setxAxisTitle("X Example 4");
		config.setyAxisTitle("Y Example 4");
		config.showLegend(false);
		dataviewer.updateConfiguration(config);

		PlotData plotData = new PlotData();

		plotData.addTrace(TraceFactory.createScatterTraceWithConfig());
		plotData.addTrace(TraceFactory.createScatterTrace());

		dataviewer.updatePlot(plotData);
		return dataviewer;
	}


	public static JavaFxDataViewer createDataViewerExample5() {

		JavaFxDataViewer dataviewer = new JavaFxDataViewer();

		DataViewerConfiguration config = new DataViewerConfiguration();
		config.setPlotTitle("Hybrid Log Trace Example");
		config.setxAxisTitle("X Example 5");
		config.setyAxisTitle("Y Example 5");
		config.showLegend(true);
		config.setLegendInsidePlot(true);
		config.setyAxisType(AxisType.LOG);
		config.setxAxisType(AxisType.LOG);

		dataviewer.updateConfiguration(config);

		PlotData plotData = new PlotData();
		plotData.addTrace(TraceFactory.createLineTrace());
		plotData.addTrace(TraceFactory.createScatterTraceWithConfig());

		dataviewer.updatePlot(plotData);

		return dataviewer;
	}

	public static JavaFxDataViewer createDataViewerExample6() {

		JavaFxDataViewer dataviewer = new JavaFxDataViewer();

		DataViewerConfiguration config = new DataViewerConfiguration();
		config.setPlotTitle("TimeSeries Trace Example");
		config.setxAxisTitle("X Example 6");
		config.setyAxisTitle("Y Example 6");
		config.showLegend(true);
		config.setLegendInsidePlot(true);
		dataviewer.updateConfiguration(config);

		PlotData plotData = new PlotData();
		plotData.addTrace(TraceFactory.createTimeSeriesTrace());
		dataviewer.updatePlot(plotData);

		return dataviewer;
	}

	public static JavaFxDataViewer createDataViewerExample7() {

		JavaFxDataViewer dataviewer = new JavaFxDataViewer();

		DataViewerConfiguration config = new DataViewerConfiguration();
		config.setPlotTitle("Contour Example");
		config.setxAxisTitle("X Example 7");
		config.setyAxisTitle("Y Example 7");
		dataviewer.updateConfiguration(config);

		PlotData plotData = new PlotData();
		plotData.addTrace(TraceFactory.createContourTrace());
		dataviewer.updatePlot(plotData);

		return dataviewer;
	}

	public static JavaFxDataViewer createDataViewerExample8() {

		JavaFxDataViewer dataviewer = new JavaFxDataViewer();

		DataViewerConfiguration config = new DataViewerConfiguration();
		config.setPlotTitle("Histogram Example");
		config.setxAxisTitle("X Example 8");
		config.setyAxisTitle("Y Example 8");
		dataviewer.updateConfiguration(config);

		PlotData plotData = new PlotData();
		plotData.addTrace(TraceFactory.createHistogramTrace());
		dataviewer.updatePlot(plotData);

		return dataviewer;
	}

	public static JavaFxDataViewer createDataViewerExample9() {

		JavaFxDataViewer dataviewer = new JavaFxDataViewer();

		DataViewerConfiguration config = new DataViewerConfiguration();
		config.setPlotTitle("Density Example");
		config.setxAxisTitle("X Example 9");
		config.setyAxisTitle("Y Example 9");
		config.setxRange2(0.85, 1);
		config.setyRange2(0.85, 1);
		config.showLegend(false);
		dataviewer.updateConfiguration(config);

		PlotData plotData = new PlotData();
		plotData.addAll(TraceFactory.createDensityTrace());
		dataviewer.updatePlot(plotData);

		return dataviewer;
	}

}
