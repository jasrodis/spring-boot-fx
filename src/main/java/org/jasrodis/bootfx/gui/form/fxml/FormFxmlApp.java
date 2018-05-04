package org.jasrodis.bootfx.gui.form.fxml;

import static org.jasrodis.bootfx.gui.form.fxml.FormFxmlConstants.CSS_PATH;
import static org.jasrodis.bootfx.gui.form.fxml.FormFxmlConstants.TAB_NAME;

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
import javafx.stage.Screen;
import javafx.stage.Stage;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan({ "org.jasrodis.*" })
public class FormFxmlApp extends Application {

	private static final Logger log = LoggerFactory.getLogger(FormFxmlApp.class);

	private ConfigurableApplicationContext springContext;

	private Scene scene;

	public static void main(final String[] args) {
		launch(FormFxmlApp.class, args);
	}

	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(FormFxmlApp.class);
		FormFxmlController controller = springContext.getBean(FormFxmlController.class);
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
		log.info("Starting {}!", TAB_NAME);
		primaryStage.setTitle(TAB_NAME);
		primaryStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight() / 2);
		primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth() / 2);
		primaryStage.centerOnScreen();
		primaryStage.setOnCloseRequest(e -> {
			Platform.exit();
			System.exit(0);
		});
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
