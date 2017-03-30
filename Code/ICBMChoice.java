import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ICBMChoice extends GUI{

	GridPane valuesPane = new GridPane();
	GridPane Calculations = new GridPane();
	double timeImpact = 0;

	TextField Header2 = new TextField("Please provide the initial velocity: ");
	TextField InitialVelocity = new TextField();

	TextField Header3 = new TextField("Please provide the firing angle: ");
	TextField FiringAngle = new TextField();

	TextField Header4 = new TextField("Please provide the horizontal Distance to target: ");
	TextField HDistance = new TextField();

	TextField Header5 = new TextField("Please provide the projectile name: ");
	TextField Name = new TextField();

	public void AmmoPane(){

		Header2.setPrefWidth(375);
		valuesPane.setVgap(10);
		valuesPane.setHgap(2);

		valuesPane.add(Header2, 0, 1);
		valuesPane.add(InitialVelocity, 1, 1);

		valuesPane.add(Header3, 0, 2);
		valuesPane.add(FiringAngle, 1, 2);

		valuesPane.add(Header4, 0, 3);
		valuesPane.add(HDistance, 1, 3);

		valuesPane.add(Header5, 0, 4);
		valuesPane.add(Name, 1, 4);

		valuesPane.add(BallisticAnimationBT,2,5);
		valuesPane.add(CalculateBT,0,5);
		valuesPane.add(SaveBT,1,5);

		BallisticAnimationBT.setOnAction(new BallisticGraph());
		CalculateBT.setOnAction(new ICBMCalc());
		//SaveBT.setOnAction(new ICBMResults());

		thirdammo.setCenter(valuesPane);
		thirdammo.setBottom(Calculations);

		Stage Stage4 = new Stage();
		Scene scene4 = new Scene(thirdammo,1500,1000,Color.GHOSTWHITE);
		Stage4.setScene(scene4);
		Stage4.show();
	}

	public void InputCheck() throws NumberFormatException{
		try{
			String text = InitialVelocity.getText();
			Double.parseDouble(text);

			String text2 = FiringAngle.getText();
			Double.parseDouble(text2);

			String text3 = HDistance.getText();
			Double.parseDouble(text3);

		}catch(NumberFormatException e){
			final JPanel panel = new JPanel();
			JOptionPane.showMessageDialog(panel,"Some input that you entered does not correspond with a number, please ENTER A NUMBER","Error", JOptionPane.ERROR_MESSAGE);
			InitialVelocity = new TextField();
			FiringAngle = new TextField();
			HDistance = new TextField();
		}	
	}

	public class ICBMCalc implements EventHandler<ActionEvent> { // inner class that calculates the area of the triangle
		@Override
		public void handle(ActionEvent e){

			ICBM Formulas = new ICBM();
			InputCheck();

			String text = InitialVelocity.getText();
			double Velocity = Double.parseDouble(text);

			String text2 = FiringAngle.getText();
			double Angle = Double.parseDouble(text2);

			String text3 = HDistance.getText();
			double distance = Double.parseDouble(text3);

			timeImpact = Formulas.TimeImpact(Velocity,Angle,distance);

			TextField Table1 = new TextField("The time for impact is: " + timeImpact + "s");

			valuesPane.add(Table1,0,6);
			
		}
	}
}