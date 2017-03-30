import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class HighVelocityException extends Exception{

	public void VelocityException(double Velocity){
		final JPanel panel = new JPanel();
		JOptionPane.showMessageDialog(panel,"OK Slow down the velocity you used is wrong for sure:\n"
				+ "1) I you are using bullets with a speed over 1000 m/s you are delirious\n"
				+ "2) If you are shooting arrows with a speed over 250 m/s either you are shooting the mythical Kalladbolg or an alien bow\n"
				+ "3) If you are shooting Artillery and your speed exceeds 2000 m/s I have to remind you that this program does not support railguns ","Error", JOptionPane.ERROR_MESSAGE);
	}
}