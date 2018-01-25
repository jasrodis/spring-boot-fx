package cryptosim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan
public class CryptosimGuiApp extends Application {

	private ConfigurableApplicationContext springContext;

	private static final Logger log = LoggerFactory.getLogger(CryptosimGuiApp.class);

	private final static String CSS_PATH = "/styles/bootstrap3.css";
	private final static String PROJECT_TITLE = "Data Manager";
	private Scene scene;

	public static void main(final String[] args) throws Exception {
		launch(CryptosimGuiApp.class, args);
	}

	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(CryptosimGuiApp.class);
		CryptosimGuiController c = (CryptosimGuiController) springContext.getBean(CryptosimGuiController.class);
		scene = new Scene(c.getView());
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

	private void startApplication(final Stage primaryStage) throws Exception {
		log.info("Starting application!");
		primaryStage.setTitle(PROJECT_TITLE);
		primaryStage.setHeight(Screen.getPrimary().getVisualBounds().getHeight() / 2);
		primaryStage.setWidth(Screen.getPrimary().getVisualBounds().getWidth() / 2);
		primaryStage.centerOnScreen();
		primaryStage.setOnCloseRequest((e) -> {
			Platform.exit();
			System.exit(0);
		});
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
