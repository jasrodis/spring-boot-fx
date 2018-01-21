package cryptosim.data.examples;

import charts.dataviewer.api.trace.BarTrace;
import charts.dataviewer.api.trace.ContourTrace;
import charts.dataviewer.api.trace.GenericTrace;
import charts.dataviewer.api.trace.Histogram2dContourTrace;
import charts.dataviewer.api.trace.HistogramTrace;
import charts.dataviewer.api.trace.LineTrace;
import charts.dataviewer.api.trace.ScatterTrace;
import charts.dataviewer.api.trace.TimeSeriesTrace;
import charts.dataviewer.api.trace.TraceConfiguration;
import charts.dataviewer.utils.TraceColour;
import charts.dataviewer.utils.TraceMode;
import charts.dataviewer.utils.TraceVisibility;

/**
 * Trace usage examples
 *  
 * @author jasrodis
 */
public class TraceFactory {

	public static LineTrace<?> createLineTrace() {
		LineTrace<Object> lineTrace = new LineTrace<>();
		lineTrace.setxArray(new String[] { "asdf", "fdsa", "asdfffe" , "asdfe", "asfee3"});
		lineTrace.setyArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
		lineTrace.setTraceName("MyLineTrace");
		lineTrace.setTraceColour(TraceColour.PURPLE);
		return lineTrace;
	}

	public static LineTrace<Double> createLineTraceWithConfig() {
		LineTrace<Double> lineTrace = new LineTrace<>();
		lineTrace.setxArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
		lineTrace.setyArray(new Double[] { 0.0, DataFactory.generateRandomDoubleData(), DataFactory.generateRandomDoubleData(), DataFactory.generateRandomDoubleData(),
				DataFactory.generateRandomDoubleData(), DataFactory.generateRandomDoubleData() });

		TraceConfiguration lineConfig = new TraceConfiguration();
		lineConfig.setTraceColour(TraceColour.RED);
		lineConfig.setTraceName("MyLineTrace1");
		lineConfig.setTraceVisibility(TraceVisibility.TRUE);

		lineTrace.setConfiguration(lineConfig);
		return lineTrace;
	}

	public static BarTrace<Object> createBarTrace() {
		BarTrace<Object> barTrace = new BarTrace<>();
		barTrace.setxArray(new String[] { "Demogorgon", "Freeman", "Obi-wan", "PiedPiper", "Yoda", "Wookie" });
		barTrace.setyArray(new Integer[] { DataFactory.generateRandomIntegerData(), DataFactory.generateRandomIntegerData(), DataFactory.generateRandomIntegerData(),
				DataFactory.generateRandomIntegerData(), DataFactory.generateRandomIntegerData(), DataFactory.generateRandomIntegerData() });
		barTrace.setTraceName("MyBarTrace");
		barTrace.setTraceColour(TraceColour.BLUE);
		return barTrace;
	}

	public static BarTrace<Object> createBarTraceWithConfig() {
		BarTrace<Object> barTrace = new BarTrace<>();
		barTrace.setxArray(new String[] { "10", "20", "30", "40", "50", "60" });
		barTrace.setyArray(new Integer[] { DataFactory.generateRandomIntegerData(), DataFactory.generateRandomIntegerData(), DataFactory.generateRandomIntegerData(),
				DataFactory.generateRandomIntegerData(), DataFactory.generateRandomIntegerData(), DataFactory.generateRandomIntegerData() });

		TraceConfiguration barConfig = new TraceConfiguration();
		barTrace.setTraceName("MyBarTrace1");
		barConfig.setTraceColour(TraceColour.ORANGE);

		barTrace.setConfiguration(barConfig);
		return barTrace;
	}

	public static ScatterTrace<Double> createScatterTrace() {
		ScatterTrace<Double> scatterTrace = new ScatterTrace<>();
		scatterTrace.setxArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
		scatterTrace.setyArray(new Double[] { 0.0, DataFactory.generateRandomDoubleData() * 100, DataFactory.generateRandomDoubleData() * 100,
				DataFactory.generateRandomDoubleData() * 100, DataFactory.generateRandomDoubleData() * 100, DataFactory.generateRandomDoubleData() * 100 });
		scatterTrace.setTraceName("MyScatterTrace");
		scatterTrace.setTraceColour(TraceColour.PURPLE);
		scatterTrace.setTraceMode(TraceMode.MARKERS);
		return scatterTrace;
	}

	public static ScatterTrace<Double> createScatterTraceWithConfig() {
		ScatterTrace<Double> scatterTrace = new ScatterTrace<>();
		scatterTrace.setxArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
		scatterTrace.setyArray(new Double[] { 0.0, DataFactory.generateRandomDoubleData(), DataFactory.generateRandomDoubleData(), DataFactory.generateRandomDoubleData(),
				DataFactory.generateRandomDoubleData(), DataFactory.generateRandomDoubleData() });

		TraceConfiguration scatterConfig = new TraceConfiguration();
		scatterConfig.setTraceName("MyScatterTrace1");
		scatterConfig.setTraceColour(TraceColour.RED);
		scatterConfig.setTraceMode(TraceMode.MARKERS);

		scatterTrace.setConfiguration(scatterConfig);
		return scatterTrace;
	}

	public static HistogramTrace<Double> createHistogramTrace() {
		HistogramTrace<Double> histogramTrace = new HistogramTrace<>();
		histogramTrace.setxArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });
		histogramTrace.setTraceName("MyHistogramTrace");
		histogramTrace.setTraceColour(TraceColour.BLUE);
		return histogramTrace;
	}

	public static HistogramTrace<Double> createHistogramTraceWithConfig() {
		HistogramTrace<Double> histogramTrace = new HistogramTrace<>();
		histogramTrace.setxArray(new Double[] { 0.0, 1.0, 200.0, 3.0, 4000.0, 5.0 });

		TraceConfiguration histogramConfig = new TraceConfiguration();
		histogramConfig.setTraceName("HistogramTrace1");
		histogramConfig.setTraceColour(TraceColour.RED);

		histogramTrace.setConfiguration(histogramConfig);
		return histogramTrace;
	}

	public static ContourTrace<Double> createContourTrace() {
		ContourTrace<Double> contourTrace = new ContourTrace<>();
		contourTrace.setxArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });
		contourTrace.setyArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });
		contourTrace.setzArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });
		contourTrace.setTraceName("ContourTrace");
		return contourTrace;
	}

	public static ContourTrace<Double> createContourTraceWithConfig() {
		ContourTrace<Double> contourTrace = new ContourTrace<>();

		contourTrace.setxArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });
		contourTrace.setyArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });
		contourTrace.setzArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5, 0.5, 0.6, 1.6 });

		TraceConfiguration contourConfig = new TraceConfiguration();
		contourConfig.setTraceName("ContourTrace1");

		contourTrace.setConfiguration(contourConfig);
		return contourTrace;
	}

	public static TimeSeriesTrace<Object> createTimeSeriesTrace() {
		TimeSeriesTrace<Object> timeSeriesTrace = new TimeSeriesTrace<>();
		timeSeriesTrace.setxArray(new String[] { "2013-10-04 22:23:00", "2013-10-05 22:23:01", "2013-10-06 22:23:02", "2013-10-07 22:23:03", "2013-10-08 22:23:04",
				"2013-10-09 22:23:05", "2013-10-10 22:23:06" });
		timeSeriesTrace.setyArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5 });
		timeSeriesTrace.setTraceColour(TraceColour.BLUE);
		timeSeriesTrace.setTraceName("timeSeriesTrace");
		return timeSeriesTrace;
	}

	public static TimeSeriesTrace<Object> createTimeSeriesTraceWithConfig() {
		TimeSeriesTrace<Object> timeSeriesTrace = new TimeSeriesTrace<>();

		timeSeriesTrace.setxArray(new String[] { "2013-10-04 22:23:00", "2013-10-04 22:23:01", "2013-10-04 22:23:02", "2013-10-04 22:23:03", "2013-10-04 22:23:04",
				"2013-10-04 22:23:05", "2013-10-04 22:23:06" });
		timeSeriesTrace.setyArray(new Double[] { -0.2, 0.0, 0.1, 0.1, 0.3, 0.4, 0.5 });

		TraceConfiguration timeSeriesConfig = new TraceConfiguration();
		timeSeriesConfig.setTraceName("TimeSeriesTrace");

		timeSeriesTrace.setConfiguration(timeSeriesConfig);
		return timeSeriesTrace;
	}

	public static GenericTrace<?>[] createDensityTrace() {

		int N = 2000;
		int a = -1;
		Double b = 1.2;

		Double step = (b - a) / (N - 1);

		Double t[] = new Double[N];
		Double x[] = new Double[N];
		Double y[] = new Double[N];

		for (int i = 0; i < N; i++) {
			t[i] = a + step * i;
			x[i] = (Math.pow(t[i], 3)) + (0.3 * normal());
			y[i] = (Math.pow(t[i], 6)) + (0.3 * normal());
		}
		Histogram2dContourTrace<Double> h2dc = new Histogram2dContourTrace<>();
		h2dc.setxArray(x);
		h2dc.setyArray(y);
		h2dc.setTraceName("Density");

		HistogramTrace<Double> hx = new HistogramTrace<>();
		hx.setxArray(x);
		hx.setyAxis("y2");
		hx.setTraceColour(TraceColour.GREEN);
		hx.setTraceName("x density");

		HistogramTrace<Double> hy = new HistogramTrace<>();
		hy.setyArray(y);
		hy.setxAxis("x2");
		hy.setTraceColour(TraceColour.GREEN);
		hy.setTraceName("Y density");

		GenericTrace<?>[] gt = new GenericTrace<?>[3];
		gt[0] = h2dc;
		gt[1] = hx;
		gt[2] = hy;

		return gt;
	}

	public static LineTrace<Double> createMultipleAxisTrace() {
		LineTrace<Double> lineTrace = new LineTrace<>();
		lineTrace.setTraceName("Multiple axis");
		lineTrace.setxArray(new Double[] { 0.0, 1.0, 2.0, 3.0, 4.0, 5.0 });
		lineTrace.setyArray(new Double[] { 0.0, 100.0, DataFactory.generateRandomDoubleData(), DataFactory.generateRandomDoubleData(), DataFactory.generateRandomDoubleData(),
				DataFactory.generateRandomDoubleData() });
		lineTrace.setyAxis("y2");

		return lineTrace;
	}

	public static double normal() {
		double x = 0, y = 0, rds, c;
		do {
			x = Math.random() * 2 - 1;
			y = Math.random() * 2 - 1;
			rds = x * x + y * y;
		} while (rds == 0 || rds > 1);
		c = Math.sqrt(-2 * Math.log(rds) / rds);
		return x * c;
	}

}
