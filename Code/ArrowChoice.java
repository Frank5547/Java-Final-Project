import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ArrowChoice extends GUI{

	GridPane valuesPane = new GridPane();
	GridPane Calculations = new GridPane();

	TextField Header2 = new TextField("Please provide the initial velocity: ");
	TextField InitialVelocity = new TextField();

	TextField Header3 = new TextField("Please provide the angle: ");
	TextField FiringAngle = new TextField();

	TextField Header5 = new TextField("Please provide the drag coefficient: ");
	TextField DragCoeficient = new TextField();

	TextField Header6 = new TextField("Please provide the air density: ");
	TextField AirDensity = new TextField();

	TextField Header7 = new TextField("Please provide the cross sectional area of the arrow: ");
	TextField CrossSecArea = new TextField();

	TextField Header8 = new TextField("Please provide the arrow mass: ");
	TextField Mass = new TextField();

	TextField Table1 = new TextField();

	TextField Table2 = new TextField();

	TextField Table3 = new TextField();

	TextField Table4 = new TextField();

	TextField Table5 = new TextField();

	TextField Table6 = new TextField();

	TextField Table7 = new TextField();

	public void AmmoPane(){

		Header2.setPrefWidth(375);
		valuesPane.setVgap(30);
		valuesPane.setHgap(2);

		valuesPane.add(Header2, 0, 1);
		valuesPane.add(InitialVelocity, 1, 1);

		valuesPane.add(Header3, 0, 2);
		valuesPane.add(FiringAngle, 1, 2);

		valuesPane.add(Header5, 0, 3);
		valuesPane.add(DragCoeficient, 1, 3);

		valuesPane.add(Header6, 0, 4);
		valuesPane.add(AirDensity, 1, 4);

		valuesPane.add(Header7, 0, 5);
		valuesPane.add(CrossSecArea, 1, 5);

		valuesPane.add(Header8,0,6);
		valuesPane.add(Mass,1,6);

		valuesPane.add(BallisticAnimationBT,2,7);
		valuesPane.add(CalculateBT,0,7);

		BallisticAnimationBT.setOnAction(new BallisticGraph());
		CalculateBT.setOnAction(new ArrowCalc());

		secondammo.setCenter(valuesPane);
		secondammo.setBottom(Calculations);

		Stage Stage3 = new Stage();
		Scene scene3 = new Scene(secondammo,1500,1000,Color.GHOSTWHITE);
		Stage3.setScene(scene3);
		Stage3.show();

	}

	public void InputCheck() throws NumberFormatException{
		try{

			String text = InitialVelocity.getText();
			Double.parseDouble(text);

			String text2 = FiringAngle.getText();
			Double.parseDouble(text2);

			String text3 = DragCoeficient.getText();
			Double.parseDouble(text3);

			String text4 = AirDensity.getText();
			Double.parseDouble(text4);

			String text5 = CrossSecArea.getText();
			Double.parseDouble(text5);

			String text6 = Mass.getText();
			Double.parseDouble(text6);

		}catch(NumberFormatException e){
			final JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel,"OK many things could have happened:\n"
					+ "1) You beleive yourself Katniss Everdeen and you shoot epic arrows\n"
					+ "2) You simply did not know the input I was asking for (Check instructions for help) or\n"
					+ "3) You decided that physics is going to operate with things other than numbers, PLEASE INPUT VALID DOUBLES ","Error", JOptionPane.ERROR_MESSAGE);
			
			InitialVelocity = new TextField();
			FiringAngle = new TextField();
			DragCoeficient = new TextField();
			AirDensity = new TextField();
			CrossSecArea = new TextField();
			Mass = new TextField();
			
		}	
	}


	public class ArrowCalc implements EventHandler<ActionEvent>{ // inner class that calculates the area of the triangle
		@Override
		public void handle(ActionEvent e){

			Arrows Formulas = new Arrows();
			HighVelocityException except = new HighVelocityException();
			InputCheck();

			String text = InitialVelocity.getText();
			double Velocity = Double.parseDouble(text);
			
			if(Velocity > 250){
				except.VelocityException(Velocity);
			}

			String text2 = FiringAngle.getText();
			double Angle = Double.parseDouble(text2);

			String text3 = DragCoeficient.getText();
			double Cd = Double.parseDouble(text3);

			String text4 = AirDensity.getText();
			double Density = Double.parseDouble(text4);

			String text5 = CrossSecArea.getText();
			double Area = Double.parseDouble(text5);

			String text6 = Mass.getText();
			double M = Double.parseDouble(text6);

			double time = Formulas.FlightTime(Velocity, Angle);
			Formulas.DragForce(Cd, Density, Velocity, Area);
			double MaxX = Formulas.DistanceX(Velocity, Angle);
			double MaxY = Formulas.DistanceY(Velocity,Angle);
			double Drop = Formulas.ArrowDrop(Velocity, MaxX);
			double BC = Formulas.BallisticCoeficient(Cd, M, Area);
			double Vt = Formulas.TerminalVelocity(M, Density, Area, Cd);
			double Energy = Formulas.ImpactEnergy(M, Velocity);

			TextField Table1 = new TextField("The maximum distance in X with drag is: " + MaxX + "m");

			TextField Table2 = new TextField("The maximum distance in Y with drag is: " + MaxY + "m");

			TextField Table3 = new TextField ("The time of flight of the arrow is: " + time + "seconds");

			TextField Table4 = new TextField("The estimated arrow drop is: " + Drop + "m");

			TextField Table5 = new TextField("The calculated Ballistic Coeficient for this arrow is: " + BC);

			TextField Table6 = new TextField("The terminal velocity of this arrow is: "+ Vt + "m/s");

			TextField Table7 = new TextField("The arrow energy at impact is: "+ Energy + "J");

			Table1.setPrefWidth(500);
			Calculations.setHgap(2);
			Calculations.setVgap(30);

			Calculations.add(Table1,0,0);
			Calculations.add(Table2,0,1);
			Calculations.add(Table3,0,2);
			Calculations.add(Table4,0,3);
			Calculations.add(Table5,0,4);
			Calculations.add(Table6,0,5);
			Calculations.add(Table7,0,6);



		}
	}
}