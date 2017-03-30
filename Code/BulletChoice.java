import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BulletChoice extends GUI{

	GridPane valuesPane = new GridPane();
	GridPane Calculations = new GridPane();

	TextField Header2 = new TextField("Please provide the initial velocity: ");
	TextField InitialVelocity = new TextField();

	TextField Header3 = new TextField("Please provide the wind speed (in mph): ");
	TextField WindSpeed = new TextField();
	
	TextField Header4 = new TextField("Please provide the Temperature: ");
	TextField T = new TextField();

	TextField Header5 = new TextField("Please provide the drag coefficient: ");
	TextField DragCoefficient = new TextField();

	TextField Header6 = new TextField("Please provide the air density: ");
	TextField AirDensity = new TextField();

	TextField Header7 = new TextField("Please provide the cross sectional area of the projectile: ");
	TextField CrossSecArea = new TextField();

	TextField Header8 = new TextField("Please provide the projectile mass: ");
	TextField Mass = new TextField();
	
	TextField Header9 = new TextField("Please provide the observed distance of test shot (in inches): ");
	TextField EmpiricalCorrection = new TextField();
	
	TextField Header10 = new TextField("Please provide the distance to your target (in hundreds of yards): ");
	TextField DistancetoTarget = new TextField();
	
	TextField Header11 = new TextField("Please provide weapon range (in hundreds of yards): ");
	TextField Range = new TextField();
	
	TextField Header12 = new TextField("Please provide the downrange velocity: ");
	TextField FinalVelocity = new TextField();

	TextField Table1 = new TextField();

	TextField Table2 = new TextField();

	TextField Table3 = new TextField();

	TextField Table4 = new TextField();

	TextField Table5 = new TextField();

	TextField Table6 = new TextField();

	TextField Table7 = new TextField();
	
	TextField Table8 = new TextField();
	
	TextField Table9 = new TextField();

	public void AmmoPane(){

		Header2.setPrefWidth(425);
		valuesPane.setVgap(10);
		valuesPane.setHgap(2);

		valuesPane.add(Header2, 0, 1);
		valuesPane.add(InitialVelocity, 1, 1);

		valuesPane.add(Header3, 0, 2);
		valuesPane.add(WindSpeed, 1, 2);
		
		valuesPane.add(Header4, 0, 3);
		valuesPane.add(T, 1, 3);

		valuesPane.add(Header5, 0, 4);
		valuesPane.add(DragCoefficient, 1, 4);

		valuesPane.add(Header6, 0, 5);
		valuesPane.add(AirDensity, 1, 5);

		valuesPane.add(Header7, 0, 6);
		valuesPane.add(CrossSecArea, 1, 6);

		valuesPane.add(Header8,0,7);
		valuesPane.add(Mass,1,7);
		
		valuesPane.add(Header9,0,8);
		valuesPane.add(EmpiricalCorrection,1,8);
		
		valuesPane.add(Header10,0,9);
		valuesPane.add(DistancetoTarget,1,9);
		
		valuesPane.add(Header11,0,10);
		valuesPane.add(Range,1,10);
		
		valuesPane.add(Header12,0,11);
		valuesPane.add(FinalVelocity,1,11);

		valuesPane.add(BallisticAnimationBT,2,12);
		valuesPane.add(CalculateBT,0,12);

		BallisticAnimationBT.setOnAction(new BallisticGraph());
		CalculateBT.setOnAction(new BulletCalc());

		forthammo.setCenter(valuesPane);
		forthammo.setBottom(Calculations);

		Stage Stage5 = new Stage();
		Scene scene5 = new Scene(forthammo,1500,1000,Color.GHOSTWHITE);
		Stage5.setScene(scene5);
		Stage5.show();

	}
	
	public void InputCheck() throws NumberFormatException{
		try{
			

			String text = InitialVelocity.getText();
			Double.parseDouble(text);

			String text2 = WindSpeed.getText();
			Double.parseDouble(text2);
			
			String text3 = T.getText();
			Double.parseDouble(text3);
			
			String text4 = DragCoefficient.getText();
			Double.parseDouble(text4);

			String text5 = AirDensity.getText();
			Double.parseDouble(text5);
			
			String text6 = CrossSecArea.getText();
			Double.parseDouble(text6);
			
			String text7 = Mass.getText();
			Double.parseDouble(text7);
			
			String text8 = EmpiricalCorrection.getText();
			Double.parseDouble(text8);
			
			String text9 = DistancetoTarget.getText();
			Double.parseDouble(text9);
			
			String text10 = Range.getText();
			Double.parseDouble(text10);
			
			String text11 = FinalVelocity.getText();
			Double.parseDouble(text11);

			

		}catch(NumberFormatException e){
			final JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel,"OK many things could have happened:\n"
					+ "1) You are shooting a railgun\n"
					+ "2) You simply did not know the input I was asking for (Check instructions for help) or\n"
					+ "3) You decided that physics is going to operate with things other than numbers, PLEASE INPUT VALID DOUBLES ","Error", JOptionPane.ERROR_MESSAGE);
			
			
			InitialVelocity = new TextField();
			WindSpeed = new TextField();
			T = new TextField();
			DragCoefficient = new TextField();
			AirDensity = new TextField();
			CrossSecArea = new TextField();
			Mass = new TextField();
			EmpiricalCorrection = new TextField();
			DistancetoTarget = new TextField();
			Range = new TextField();
			FinalVelocity = new TextField();
			
		}	
	}

	public class BulletCalc implements EventHandler<ActionEvent>{ // inner class that calculates the area of the triangle
		@Override
		public void handle(ActionEvent e){
			
			Bullets Formulas = new Bullets();
			HighVelocityException except = new HighVelocityException();
			InputCheck();

			String text = InitialVelocity.getText();
			double Velocity = Double.parseDouble(text);
			
			if(Velocity > 1000){
				except.VelocityException(Velocity);
			}

			String text2 = WindSpeed.getText();
			double Wind = Double.parseDouble(text2);
			
			String text3 = T.getText();
			double T = Double.parseDouble(text3);
			
			String text4 = DragCoefficient.getText();
			double Cd = Double.parseDouble(text4);

			String text5 = AirDensity.getText();
			double Density = Double.parseDouble(text5);
			
			String text6 = CrossSecArea.getText();
			double Area = Double.parseDouble(text6);
			
			String text7 = Mass.getText();
			double M = Double.parseDouble(text7);
			
			String text8 = EmpiricalCorrection.getText();
			double Correct = Double.parseDouble(text8);
			
			String text9 = DistancetoTarget.getText();
			double Distance = Double.parseDouble(text9);
			
			String text10 = Range.getText();
			double Range = Double.parseDouble(text10);
			
			String text11 = FinalVelocity.getText();
			double Vf = Double.parseDouble(text11);
			
			double time = Formulas.FlightTime(Velocity,Distance,Vf);
			double MOAChange = Formulas.MOAChange(Correct, Distance);
            double MOAWind = Formulas.MOAWind(Velocity,Range,Wind);
            double TailWind = Formulas.TailWindComp(Distance, Wind);
            double TComp = Formulas.TComp(T, Distance);
			double Drop = Formulas.BulletDrop(Velocity, Distance);
			double Vt = Formulas.TerminalVelocity(M, Density, Area, Cd);
			double BC = Formulas.BallisticCoeficient(Cd, M, Area);
			double Energy = Formulas.ImpactEnergy(M, Velocity);
	
			TextField Table1 = new TextField("The flightime to target is: " + time + " seconds");

			TextField Table2 = new TextField("The minute of angle change to that target is: " + MOAChange + " MOA's");
			
			TextField Table3 = new TextField ("The minute of angle change due to wind is: " + MOAWind + " MOA's");

			TextField Table4 = new TextField("The tail and head wind compensation is: " + TailWind + " Yards in range");

			TextField Table5 = new TextField("The temperature compensation is: " + TComp + " yards");
			
			TextField Table6 = new TextField("The bullet drop is: " + Drop + " meters");

			TextField Table7 = new TextField("The terminal velocity of this projectile is: "+ Vt + "m/s");
			
			TextField Table8 = new TextField("The Ballistic Coefficient is: "+ BC);

			TextField Table9 = new TextField("The Projectile Energy at impact is: "+ Energy + " J");

			Table1.setPrefWidth(500);
			Calculations.setHgap(2);
			Calculations.setVgap(10);

			Calculations.add(Table1,0,0);
			Calculations.add(Table2,0,1);
			Calculations.add(Table3,0,2);
			Calculations.add(Table4,0,3);
			Calculations.add(Table5,0,4);
			Calculations.add(Table6,0,5);
			Calculations.add(Table7,0,6);
			Calculations.add(Table8,0,7);
			Calculations.add(Table9,0,8);
			


		}
	}
}