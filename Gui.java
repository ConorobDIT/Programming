import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;

public class Gui extends Algorithm {

	protected JFrame frame;
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
		frame = new JFrame();
		frame.setBounds(100, 100, 523, 422);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Click Me");
		btnNewButton.setBounds(185, 40, 100, 40);
		frame.getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Algorithm newAlgo = new Algorithm();
				textArea = new JTextArea();
				textArea.setEditable(false);
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				textArea.setBounds(48, 91, 387, 279);
				PrintStream printStream = new PrintStream(new TextOutput(textArea));
				System.setOut(printStream);
				System.setErr(printStream);
				System.out.println("Started!");
				Algorithm.results();
			}
		});
	}
}
