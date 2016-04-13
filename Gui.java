import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Window;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.PrintStream;
import java.awt.event.ActionEvent;

/*This is the GUI for the Texts or Emails code.
 * Conor O'Brien C14733295  */

public class Gui extends JFrame implements ActionListener{
	private JButton Button1;
	private JTextArea textArea;
	private JPanel panel;
	private Algorithm newAlgo;

	//Create the application.
	public Gui(String title) {
		super(title);
		newAlgo = newAlgo;
		//Setting up the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setLayout(new FlowLayout());
		//Making a button, panel and text area.
		Button1 = new JButton("Click Me to start");
		JPanel panel= new JPanel();
		
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setSize(300, 200);	
		//Adding the button and text area to the panel
		panel.add(Button1);
		panel.add(textArea);
		//Adding the Panel to the frame
		add(panel);
		//Making the frame visible
		setVisible(true);
		
		Button1.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object eventSource = e.getSource();
		//When the button is clicked the Algorithm is started.
		if(eventSource == Button1){
			Algorithm newAlgo = new Algorithm();
			//This makes the prints in the "results" method appear in the text box instead of the console.
			PrintStream printStream = new PrintStream(new TextOutput(textArea));
			System.setOut(printStream);
			System.setErr(printStream);
			newAlgo.results();
				}
	        }

	}
