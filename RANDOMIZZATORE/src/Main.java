import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		Gui gui = new Gui();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setSize(width - 200, 120);
		gui.setLocationRelativeTo(null);
		gui.setVisible(true);
		gui.setTitle("Randomizzatore");

	}

}
