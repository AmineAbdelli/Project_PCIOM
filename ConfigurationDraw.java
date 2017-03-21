import java.awt.CheckboxGroup;
import java.awt.EventQueue;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ConfigurationDraw {

	 static JFrame frame;

	
	public ConfigurationDraw() {
		
	}
	
	public void main(String[] args) {
		
		start();
		
	}
	
	void start()
	{
		frame = new JFrame();
		frame.setBounds(710, 200, 401, 174);
		frame.getContentPane().setLayout(null);
		final ButtonGroup buttonGroup = new ButtonGroup();
		final JCheckBox chckbxNewCheckBox = new JCheckBox("Node");
		chckbxNewCheckBox.setBounds(19, 30, 122, 29);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		final JCheckBox chckbxZoneInt = new JCheckBox("Zone Int");
		chckbxZoneInt.setBounds(19, 62, 122, 29);
		
		buttonGroup.add(chckbxZoneInt);
		buttonGroup.add(chckbxNewCheckBox);
		 ActionListener actionListenerNodes = new ActionListener() {
		      public void actionPerformed(ActionEvent actionEvent) {
		        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
		        boolean selected = abstractButton.getModel().isSelected();
		  
		       PointPanel.nodes=selected;
		       if(selected)
		    	   {chckbxZoneInt.setSelected(false);
		    	   PointPanel.ZoneIn=false;
		    	   }
		        else {chckbxZoneInt.setSelected(true);  PointPanel.ZoneIn=true;}
		      
		        
		      }
		    };
		    ActionListener actionListenerZone = new ActionListener() {
			      public void actionPerformed(ActionEvent actionEvent) {
			        AbstractButton abstractButton = (AbstractButton) actionEvent.getSource();
			        boolean selected = abstractButton.getModel().isSelected();
			  
			        PointPanel.ZoneIn=selected;
			        if(selected)
			        	{chckbxNewCheckBox.setSelected(false); PointPanel.nodes=false;}
			        else {chckbxNewCheckBox.setSelected(true);PointPanel.nodes=true;}
			      
			      }
			    };
	chckbxZoneInt.addActionListener(actionListenerZone);
	chckbxNewCheckBox.addActionListener(actionListenerNodes);
		frame.getContentPane().add(chckbxZoneInt);
		frame.getContentPane().add(chckbxNewCheckBox);
		frame.setVisible(true);
		  frame.setResizable(false);
	
	}
	void OFF()
	  {
		  frame.dispose();
		  frame.setVisible(false);
	  }
}
