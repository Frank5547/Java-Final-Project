public class Bullets extends AmmoPhysics{

	double MOA;
	double MOAWind;
	double FlightTime;
	double BulletDrop;
	double TerminalVelocity;
	double BallisticCoefficient;
	double Energy;
	double Comp;
	double TComp;

	public double FlightTime(double InitialVelocity, double Distance, double Finalvelocity){
		
		double distance2 = Distance * 100;

		FlightTime = (2 * distance2) / (InitialVelocity + Finalvelocity);
		return FlightTime;

	}

	public double MOAChange(double Correction, double Distance){

		MOA = Correction / Distance; // formula to calculate the maximum horizontal distance
		return MOA;

	}

	public double MOAWind(double InitVelocity, double Range, double Wind){

		if (Range <= 500){
			MOAWind = Range * Wind / 15 ; // formula to calculate the maximum vertical distance	
		}
		
		if(Range > 500 && Range <= 600){
			MOAWind = Range * Wind / 14 ;
		}
		
		if(Range > 600 && Range <= 800){
			MOAWind = Range * Wind / 13 ;
		}
		if(Range > 800 && Range <= 900){
			MOAWind = Range * Wind / 12 ;
		}
		if(Range > 900 && Range <= 1000){
			MOAWind = Range * Wind / 11 ;
		}
		
		return MOAWind;

	}
	
	public double TailWindComp(double Distance, double Wind){

		Comp = Wind * Distance / 4; // formula to calculate the maximum horizontal distance
		return Comp;

	}
	
	public double TComp(double Temperature, double Distance){
		
		if (Temperature < 60){
		TComp = (60 - Temperature) * Distance / 10; // formula to calculate the maximum horizontal distance
		
		}
		else{
			
			TComp = (Temperature - 60) * Distance / 10; // formula to calculate the maximum horizontal distance
		}
		
		return TComp;

	}

	public double BulletDrop(double InitVelocity, double Distance){
		
		double distance2 = Distance * 100;

		BulletDrop = ((0.5 * g )* (Math.pow(distance2,2))) / Math.pow(InitVelocity,2);

		return BulletDrop;

	}

	public double TerminalVelocity(double BulletMass, double AirDensity, double CrossSecArea, double DragCoefficient){
		
		TerminalVelocity = Math.sqrt((2 * BulletMass * g) / (AirDensity * CrossSecArea * DragCoefficient));
		return TerminalVelocity;

	}

	public double BallisticCoeficient(double DragCoefficient, double BulletMass,double CrossSecArea){
		
		BallisticCoefficient = (BulletMass)/DragCoefficient * CrossSecArea;
		return BallisticCoefficient;

	}

	public double ImpactEnergy(double BulletMass, double InitVelocity){
		
		Energy = 0.5 * BulletMass * Math.pow(InitVelocity,2);
		return Energy;

	}

}