package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

/**
 * Esta clase ejecuta la aplicacion llamando a la ventana FXML que esta diseñada en SceneBuilder, la logica esta
 * en el controlador.
 * @author Guillermo Rebuffo
 *
 */
public class Main extends Application {
	
	
	//public static Boolean isSplashLoaded = false; //declaramos el splash a falso
	
	Stage stage;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			stage = primaryStage;
			mainWindow();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private void mainWindow() {
		try {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("ventana.fxml"));
        AnchorPane pane=loader.load();
        //stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(pane));
        stage.show();
		
	}catch(IOException e) {
		e.printStackTrace();
	}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
