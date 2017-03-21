import java.awt.EventQueue;



import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;

import javax.swing.JLabel;

import com.sun.glass.events.WindowEvent;

import java.awt.List;
import java.awt.Choice;
import java.awt.Color;


public class Configuration {

	private static JFrame frame;
	final static JCheckBox chckbxNewCheckBox = new JCheckBox("Connx");
	final static JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Zone Inte");
	static final JCheckBox chckbxNewCheckBox_2 = new JCheckBox("View ID");
	static final JCheckBox chckbxNewCheckBox_3 = new JCheckBox("C");
	static final JCheckBox chckbxNewCheckBox_4 = new JCheckBox("Only BackB");
	static final JCheckBox AddManual = new JCheckBox("Add On Click");
	static boolean startttt=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		start();
		
	}

	
	static void start() {
		if(!startttt){
		frame = new JFrame();
		frame.setBounds(30, 30, 450, 300);
		frame.getContentPane().setLayout(null);
		chckbxNewCheckBox.setBounds(31, 40, 97, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
	
		
		chckbxNewCheckBox_1.setBounds(31, 66, 97, 23);
		 ActionListener actionListenerCnnx = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
		        boolean selected = abstractButton.getModel().isSelected();
		  
		        UnitDisk.cnnx=selected;
		        if(selected) chckbxNewCheckBox_3.setEnabled(false);
		        else 
		        	chckbxNewCheckBox_3.setEnabled(false);
		      }
		    };
		    ActionListener actionListenerZoneInte = new ActionListener() {
			      public void actionPerformed(ActionEvent actionEvent) {
			        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
			        boolean selected = abstractButton.getModel().isSelected();
			       
			        UnitDisk.checkBox=selected;
			        
			      }
			    };
			    ActionListener actionListener3 = new ActionListener() {
				      public void actionPerformed(ActionEvent actionEvent) {
				        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
				        boolean selected = abstractButton.getModel().isSelected();
				       
				        UnitDisk.viewID=selected;
				        
				      }
				    };
				    
		chckbxNewCheckBox.addActionListener(actionListenerCnnx);
		chckbxNewCheckBox_1.addActionListener(actionListenerZoneInte);
		chckbxNewCheckBox_2.addActionListener(actionListener3);
		
		frame.setTitle("Configuration");
		frame.getContentPane().add(chckbxNewCheckBox_1);
		
		JLabel lblShowOrHide = new JLabel("Show or Hide ");
		lblShowOrHide.setForeground(Color.RED);
		lblShowOrHide.setFont(new Font("Tahoma", Font.BOLD, 15));
	
		lblShowOrHide.setBounds(31, 11, 178, 37);
		frame.getContentPane().add(lblShowOrHide);
		chckbxNewCheckBox_2.setBounds(31, 92, 200, 23);
		chckbxNewCheckBox_3.setBounds(31, 115, 200, 23);
		chckbxNewCheckBox_4.setBounds(31, 138, 200, 23);
		AddManual.setBounds(31, 160, 200, 23);
		frame.getContentPane().add(AddManual);
		frame.getContentPane().add(chckbxNewCheckBox_2);
		frame.getContentPane().add(chckbxNewCheckBox_3);
		frame.getContentPane().add(chckbxNewCheckBox_4);
		
		  ActionListener actionListener4 = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
		        boolean selected = abstractButton.getModel().isSelected();
		       
		        UnitDisk.onlyB=selected;
		     //   if(selected) chckbxNewCheckBox.setEnabled(false);
		     //   else 
		     //   	chckbxNewCheckBox.setEnabled(true);
		      }
		    };
		    ActionListener AddManualListener = new ActionListener() {
			      public void actionPerformed(ActionEvent actionEvent) {
			        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
			        boolean selected = abstractButton.getModel().isSelected();
			       
			        UnitDisk.AddMan=selected;
			        UnitDisk.btnNewButton_4.setEnabled(selected);
			     //   if(selected) chckbxNewCheckBox.setEnabled(false);
			     //   else 
			     //   	chckbxNewCheckBox.setEnabled(true);
			      }
			    };
		chckbxNewCheckBox_4.addActionListener(actionListener4);  
		chckbxNewCheckBox_3.setEnabled(false);
		AddManual.addActionListener(AddManualListener);
		//AddManual.setEnabled(false);
		frame.setVisible(true);
		frame.setResizable(false);
		//startttt=true;
		
		}
		
	}
	
	void setOFF()
	{
		
	}
}
