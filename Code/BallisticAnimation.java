
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

public class BallisticAnimation{
	
	double pathOpacity = 10.0;

		public Path generateCurvyPath( double pathOpacity,double Curve1, double Curve2)
		{
			final Path path = new Path();
			path.getElements().add(new MoveTo(20,20));
			path.getElements().add(new QuadCurveTo(380, 0, Curve1, Curve2));
			//path.getElements().add(new QuadCurveTo(0, 120, 0, 240));
			path.setOpacity(pathOpacity);
			return path;
		}

		public PathTransition generatePathTransition( Shape shape,  Path path)
		{
			final PathTransition pathTransition = new PathTransition();
			pathTransition.setDuration(Duration.seconds(8.0));
			pathTransition.setDelay(Duration.seconds(1.0));
			pathTransition.setPath(path);
			pathTransition.setNode(shape);
			pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
			pathTransition.setCycleCount(Timeline.INDEFINITE);
			pathTransition.setAutoReverse(true);
			return pathTransition;
		}

		public void applyAnimation(final Group group)
		{
			final Circle circle = new Circle(20, 20, 15);
			circle.setFill(Color.DARKRED);
			final Path path = generateCurvyPath(pathOpacity,200,400);
			group.getChildren().add(path);
			group.getChildren().add(circle);
			//group.getChildren().add(new Circle(600, 400, 5));
			//group.getChildren().add(new Circle(0, 0, 5));
			final PathTransition transition = generatePathTransition(circle, path);
			transition.play(); 
		}
	
}