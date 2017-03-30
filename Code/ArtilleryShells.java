public class ArtilleryShells extends AmmoPhysics{

	double MaxX;
	double MaxY;
	double FlightTime;
	double TerminalVelocity;
	double dragForce;
	double BallisticCoefficient;
	double Energy;
	double BulletDrop;


	public double DragForce(double dragCoefficient, double airDensity, double InitVelocity,double CrossSecArea){

		dragForce = 0.5 * airDensity * InitVelocity * dragCoefficient * CrossSecArea;
		return dragForce;

	}

	public double FlightTime(double InitVelocity, double angle){

		angle = Math.toRadians(angle);

		FlightTime = 2*InitVelocity * Math.sin(angle) / g;
		return FlightTime;

	}

	public double DistanceX(double InitVelocity, double angle){

		double angle2 = Math.toRadians(angle);

		MaxX = ((InitVelocity * Math.cos(angle2)) * FlightTime) - (dragForce * InitVelocity); // formula to calculate the maximum horizontal distance
		return MaxX;

	}

	public double DistanceY(double InitVelocity, double angle2){

		double angle = Math.toRadians(angle2);
		double time = FlightTime * 0.5;

		MaxY = (InitVelocity * Math.sin(angle)* time) - (g * (time * time)/2); // formula to calculate the maximum vertical distance
		return MaxY;

	}


	public double TerminalVelocity(double ShellMass, double AirDensity, double CrossSecArea, double DragCoefficient){

		TerminalVelocity = Math.sqrt((2 * ShellMass * g) / (AirDensity * CrossSecArea * DragCoefficient));
		return TerminalVelocity;

	}

	public double BallisticCoeficient(double DragCoefficient, double BulletMass,double CrossSecArea){

		BallisticCoefficient = BulletMass/DragCoefficient * CrossSecArea;
		return BallisticCoefficient;

	}

	public double BulletDrop(double InitVelocity, double MaxX){

		MaxX = this.MaxX;

		BulletDrop = (0.5 * g * Math.pow(MaxX,2))/Math.pow(InitVelocity, 2);

		return BulletDrop;

	}

	public double ImpactEnergy(double BulletMass, double InitVelocity){

		Energy = 0.5 * BulletMass * Math.pow(InitVelocity,2);
		return Energy;

	}


}