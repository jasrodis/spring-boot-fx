package org.jasrodis.bootfx;

import static org.jasrodis.bootfx.BootFxConstants.CSS_PATH;
import static org.jasrodis.bootfx.BootFxConstants.HEIGHT;
import static org.jasrodis.bootfx.BootFxConstants.PROJECT_TITLE;
import static org.jasrodis.bootfx.BootFxConstants.WIDTH;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Stage;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class BootFxApp extends Application {

	private ConfigurableApplicationContext springContext;

	private static final Logger log = LoggerFactory.getLogger(BootFxApp.class);

	private Scene scene;

	public static void main(final String[] args) {
		launch(BootFxApp.class, args);
	}

	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(BootFxApp.class);
		BootFxController controller = springContext.getBean(BootFxController.class);
		scene = new Scene(controller.getView());
		scene.getStylesheets().add(CSS_PATH);
	}

	@Override
	public void stop() throws Exception {
		springContext.stop();
	}

	@Override
	public void start(Stage stage) throws Exception {
		startApplication(stage);
	}

	private void startApplication(final Stage primaryStage) {
		log.info("Starting {}!", PROJECT_TITLE);
		primaryStage.setTitle(PROJECT_TITLE);
		primaryStage.setHeight(HEIGHT);
		primaryStage.setWidth(WIDTH);
		primaryStage.centerOnScreen();
		primaryStage.setOnCloseRequest(e -> {
			Platform.exit();
			System.exit(0);
		});
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
