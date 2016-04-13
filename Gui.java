import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.awt.event.ActionEvent;

public class Gui extends JFrame{
	private JButton Button1;
	private JTextArea textArea;
	private Algorithm newAlgo;

	/**
	 * Create the application.
	 */
	public Gui(Algorithm newAlgo) {
		initialize();
		this.newAlgo = newAlgo;
	}

	public Gui() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.setSize(500,500);
		this.setLayout(new FlowLayout());

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		Button1 = new JButton("Click Me");
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setSize(300, 200);		

		this.add(Button1);
		this.add(textArea);
		
		Button1.addActionListener(new ActionListener() {


	        @Override
			public void actionPerformed(ActionEvent e) {
				Object eventSource = e.getSource();
				if(eventSource == Button1){
					Algorithm newAlgo = new Algorithm();
					PrintStream printStream = new PrintStream(new TextOutput(textArea));
					System.setOut(printStream);
					System.setErr(printStream);
					newAlgo.results();
				}
	        }

	}
	}
}
