import java.awt.EventQueue;

public class Control {

	public static void main(String[] args) {
	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
					Gui window = new Gui();
					window.frame.setVisible(true);
			}
		});
	}
}
