package org.jasrodis.bootfx.gui.form.programmatic;

import static org.jasrodis.bootfx.gui.form.programmatic.FormConstants.CSS_PATH;
import static org.jasrodis.bootfx.gui.form.programmatic.FormConstants.TAB_NAME;

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
@ComponentScan({"org.jasrodis.*"})
public class FormApp extends Application {
	
		private static final Logger log = LoggerFactory.getLogger(FormApp.class);

		private ConfigurableApplicationContext springContext;

		private Scene scene;

		public static void main(final String[] args)  {
			launch(FormApp.class, args);
		}

		@Override
		public void init() throws Exception {
			springContext = SpringApplication.run(FormApp.class);
			FormController controller = springContext.getBean(FormController.class);
			scene = new Scene(controller.getView());
			
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
			primaryStage.getScene().getStylesheets().add(CSS_PATH);
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
