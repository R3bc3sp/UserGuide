package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;


import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.util.Duration;

/**
 * Esta clase del controlador tiene 4 anchorPane, esta programada para que mediante un boton 
 * pueda interactuar entre diapositiva. Este boton esta importado de una libreria llamada JFoneix,
 * Tambien he creado una transcicion para que tarde unos segundos entre diapositiva a diapositiva.
 * @author Guillermo Rebuffo
 */

public class Controlador implements Initializable {

	@FXML
	private AnchorPane pane1;
	@FXML
	private AnchorPane pane2;
	@FXML
	private AnchorPane pane3;
	@FXML
	private AnchorPane pane4;
	@FXML
	private WebView Webview;
	
	
	

	public void translateAnimation(double duration, Node node, double byX) {

		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(duration), node);
		translateTransition.setByX(byX);
		translateTransition.play();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		translateAnimation(0.5, pane2, 600);
		translateAnimation(0.5, pane3, 600);
		translateAnimation(0.5, pane4, 600);
	
		/**
		 * El webengine permite visualizar cualquier pagina web dentro de la aplicacion
		 */
		final WebEngine engine = Webview.getEngine(); 
		
        engine.load("https://firebase.google.com/?"); //eL LINK A LLAMAR
        engine.setJavaScriptEnabled(true);

	}

	int showSlide = 0;// declaramos ver Diapositiva a 0

	@FXML
	void nextAction(ActionEvent event) { // Aqui estamos llamando al boton para al presionar pasemos al siguiente SLIDE
		if (showSlide == 0) {
			//Si la diapositiva es igual a 0 , trasladara la animacio  al panel2
			translateAnimation(0.5, pane2, -600);
			showSlide++; // showSlide=1

		} else if (showSlide == 1) {

			translateAnimation(0.5, pane3, -600);
			showSlide++; // showSlide=2
			
		
	} else if (showSlide == 2) {
			translateAnimation(0.5, pane4, -600);
			showSlide++; //showSlide = 3
			

		} else {
			System.out.println("No more slides");
		}
	}

	@FXML
	void backAction(ActionEvent event) {

		if (showSlide == 0) {
			System.out.println("No more slide");

			
		} else if (showSlide == 1) {
			translateAnimation(0.5, pane2, 600);
			showSlide--; // showSlide=0

		} else if (showSlide == 2) {
			translateAnimation(0.5, pane3, 600);
			showSlide--;

		} else if (showSlide == 3) {
			translateAnimation(0.5, pane4, 600);
			showSlide--;
		}else {
			System.out.println("No more slides");
		}
		
		//void hyperLink(ActionEvent event) {
			
		}
}

