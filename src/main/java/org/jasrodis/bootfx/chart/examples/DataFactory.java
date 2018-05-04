package org.jasrodis.bootfx.chart.examples;

import java.util.Random;

public class DataFactory {

	public static Double generateRandomDoubleData() {
		return 5.0 * new Random().nextDouble();
	}

	public static Integer generateRandomIntegerData() {
		return new Random().nextInt(10);
	}

}