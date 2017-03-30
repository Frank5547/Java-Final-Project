public class ICBM extends AmmoPhysics{

	double MaxHeight;
	double TimeforImpact;
	double alpha;
	final double EarthRadius = 6371000;

	public double TimeImpact(double InitVelocity, double angle, double DistanceToTarget){

		angle = Math.toRadians(angle);
		TimeforImpact = (DistanceToTarget)/(InitVelocity * Math.cos(angle));
		return TimeforImpact;

	}
}