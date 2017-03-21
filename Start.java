import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Start {

	private static JFrame frame;
	static UnitDisk k=new UnitDisk();
	static String choicee="Chang Greedy Algo";
	public static void main(String[] args) {
		start();
	}
	public static void start() {
		
		Start window=new Start();
		frame = new JFrame();
		frame.setTitle("Algorithm");
		frame.setResizable(false);
		frame.setBounds(30, 30, 450, 300);
		frame.getContentPane().setLayout(null);
		final Choice choice = new Choice();
		choice.setBounds(105, 50, 190, 20);
		choice.add("-----------");
		choice.add("Chang Greedy Algo");
		choice.add("Algo 2");
		choice.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				choicee=arg0.getItem().toString();
			}
			
		});
		frame.getContentPane().add(choice);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(10, 0, 800, 680);
		panel.add(panel_1);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(choicee.equals("Chang Greedy Algo"))
				k.start();
			}
		});
		btnStart.setBounds(206, 101, 89, 23);
		frame.getContentPane().add(btnStart);
		window.frame.setVisible(true);
	}

	private void initialize() {
		
	}

}
