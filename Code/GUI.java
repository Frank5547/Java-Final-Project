/***************************************************
 * GUI.java
 * Homework 9: Event Handling
 * Author: Francisco Javier Carrera Arias
 * Date: 11/16/2014
 * Credit to Sean Holden
 * CS 225 Fall 2014
 * 
 * Important Variables:
 * Circle 1,2,3X: sets the X coordinates of the center of the circles, they are also the start and finish in X of the lines
 * Circle 1,2,3Y: sets the Y coordinates of the center of the circles, they are also the start and finish in Y of the lines
 * 
 * Important Methods:
 * public static void main(String[] args): Main method
 * public void start(Stage Stage) throws Exception: start method and Stage initialization
 * setCenterX() and set CenterY(): sets the X and Y coordinates of the center of the circle
 * setRadius(): sets the radius of the circles
 * setStartX() and setEndX(): sets the start and end in X of the lines
 * setStartY() and setEndY(): sets the start and end in Y of the lines
 * launch(): launches the GUI
 * setStyle(): sets different style elements
 * getChildren() and addAll: gets elements and adds them to a pane
 * Math.random(): generates a random number
 * setOnAction(): Activates and event handle
 * public void handle(ActionEvent e):handle method
 ******************************************************/
// import all the libraries needed

import java.nio.file.Paths;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.Group;

public class GUI extends Application {

	//  Create the panes that are going to form my GUI
	BorderPane borderPane = new BorderPane();
	GridPane valuesPane = new GridPane();
	BorderPane vpane = new BorderPane();
	BallisticAnimation Graph = new BallisticAnimation();
	Group rootGroup = new Group();
	BorderPane firstammo = new BorderPane();
	BorderPane secondammo = new BorderPane();
	BorderPane thirdammo = new BorderPane();
	BorderPane forthammo = new BorderPane();

	TextField Header1 = new TextField("What ammo type are you shooting (Bullet, Artillery, Arrow, ICBM): ");

	Image img = new Image("exacto-smart-bullet.jpg");
	ImageView imgView = new ImageView(img);
	
	Image img2 = new Image("ArtilleryTactics.jpg");
	ImageView imgView2 = new ImageView(img2);

	// Create the Button Objects
	protected Button
	BulletBT = new Button("Bullets"),
	ArtilleryBT = new Button("Artillery"),
	ArrowsBT = new Button("Arrow"),
	ICBMBT = new Button("ICBM"),
	BallisticAnimationBT = new Button("Show Trajectory"),
	SaveBT = new Button("Save Results"),
	MusicBT1 = new Button("Music"),
	CalculateBT = new Button("Calculate");

	// Initialize the Constructor
	public GUI(){
		
		borderPane.setStyle("-fx-background-color: cyan;");
		BulletBT.setPrefWidth(500);
		ArtilleryBT.setPrefWidth(500);
		ArrowsBT.setPrefWidth(500);
		ICBMBT.setPrefWidth(500);

		// Add the text fields to the grid pane
		Header1.setPrefWidth(375);
		valuesPane.setVgap(55);
		valuesPane.setHgap(2);
		valuesPane.setStyle("-fx-background-color: cyan;");
		valuesPane.add(Header1, 0, 0);
		valuesPane.add(BulletBT, 0, 1);
		valuesPane.add(ArtilleryBT, 0, 2);
		valuesPane.add(ArrowsBT, 0, 3);
		valuesPane.add(ICBMBT, 0, 4);
		

		// place the image and the text fields with the area and the image title in the vertical pane
		TextField Title = new TextField("Music Selections and Intro Video");
		Title.setPrefWidth(200);
		vpane.setTop(Title);
		vpane.setCenter(MusicBT1);
		vpane.setBottom(imgView2);
		vpane.setStyle("-fx-background-color: cyan;");

		// put all the shapes in the shape pane and set its color

	}

	@Override
	public void start(Stage Stage) throws Exception { // Start method and stage initialization

		// Event Handlers

		BulletBT.setOnAction(new BulletChoicePane());
		ArtilleryBT.setOnAction(new ArtilleryChoicePane());
		ArrowsBT.setOnAction(new ArrowChoicePane());
		ICBMBT.setOnAction(new ICBMChoicePane());
		BallisticAnimationBT.setOnAction(new BallisticGraph());
		MusicBT1.setOnAction(new Music());

		// Put everything in the scene
		Scene scene1 = new Scene(borderPane, 1500, 1000);
		borderPane.setCenter(valuesPane);
		borderPane.setBottom(imgView);
		borderPane.setRight(vpane);

		// Configure the stage
		Stage.setScene(scene1);
		Stage.setTitle("Ballistic Computer Sovereign Cerebrum");
		Stage.show();


	}

	public static void main(String[] args) { // main method
		GUI.launch(args); // launch the GUI	
	}	

	public class BallisticGraph implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e){

			Stage Stage2 = new Stage();
			Scene scene2 = new Scene(rootGroup,500,400,Color.GHOSTWHITE);
			Graph.applyAnimation(rootGroup);
			Stage2.setScene(scene2);
			Stage2.show();
		}
	}

	public class Music implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e){
			Media m = new Media(Paths.get("01 Philosophyz.mp3").toUri().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(m);
			mediaPlayer.play();

		}
	}

	public class ArtilleryChoicePane implements EventHandler<ActionEvent>{ // inner class that calculates the area of the triangle
		@Override
		public void handle(ActionEvent e){

			ArtilleryChoice Shell1 = new ArtilleryChoice();
			Shell1.AmmoPane();

		}
	}

	public class ArrowChoicePane implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e){

			ArrowChoice arrow = new ArrowChoice();
			arrow.AmmoPane();
		}
	}

	public class ICBMChoicePane implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e){

			ICBMChoice missile = new ICBMChoice();
			missile.AmmoPane();
		}
	}

	public class BulletChoicePane implements EventHandler<ActionEvent>{
		@Override
		public void handle(ActionEvent e){

			BulletChoice bullet = new BulletChoice();
			bullet.AmmoPane();
		}
	}
} // end of class main