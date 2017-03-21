import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import com.sun.glass.events.KeyEvent;
import com.sun.prism.Image;

import javax.swing.JList;
import java.awt.Choice;
import java.awt.Label;
import javax.swing.JProgressBar;
import javax.swing.JFormattedTextField;

import sun.net.www.URLConnection;
import sun.net.www.protocol.http.HttpURLConnection;

import java.awt.Canvas;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JTextField;

public class UnitDisk {

	private static JFrame frame;

	static DefaultTableModel model = new DefaultTableModel();

	private static JButton btnNewButton;
	static int startt = 0;
	static Vector<Vector<String>> data = new Vector<Vector<String>>();
	private static JTable table;
	private static JPanel panel;
	static JMenuBar menuBar = new JMenuBar();
	static String click = "";
	static boolean checkBox = false;
	static boolean start = false;
	static boolean viewID = false;
	static boolean onlyB = false;
	static boolean AddMan = false;
	final static Configuration conf = new Configuration();
	static boolean cnnx = false;
	static HashMap<Integer, ArrayList<Integer>> compp2;
	static PointPanelC pointPanel = new PointPanelC();
	static PointPanel drawing;
	final static JButton btnNewButton_1 = new JButton("Start Algo.");
	final static JButton btnNewButton_2 = new JButton("Ph. 2");
	final static JButton btnPhase_1 = new JButton("Ph. 3");
	final static JButton btnPhase_2 = new JButton("Ph. 4");
	final static JButton btnPhaseb = new JButton("Ph. 3_b");
	final static JButton btnPhase = new JButton("Ph. 1");
	static JButton btnNewButton_5 = new JButton("Create txt File");
	static JButton btnNewButton_4 = new JButton("Draw");
	final static Serveur2 s = new Serveur2();
	static JCheckBox chckbxV = new JCheckBox("AllInZI");
	static JCheckBox chckbxV_1 = new JCheckBox("Gluton");
	static boolean v2 = false;
	static boolean v3 = false;
	static boolean v4 = false;
	static boolean fi = false;
	static boolean v2M = false;
	private static JTextField NodeNumber;
	private static JTextField NodeZone;
	private static JTextField ZINumber;
	private static JTextField ZIZone;

	public static void main(String[] args) {
		start();
	}

	void showData() {

	}

	static void start() {
		UnitDisk window = new UnitDisk();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int height = screenSize.height - 30;
		int width = screenSize.width - 10;
		btnNewButton_4.setBounds(124, 370, 103, 23);
		btnNewButton_4.setEnabled(false);
		frame = new JFrame();
		frame.setBounds(0, 0, width, height);
		btnNewButton_5.setBounds(10, 537, 175, 23);
		JLabel lblNode = new JLabel("NODE");
		lblNode.setBounds(10, 172, 46, 14);
		JLabel lblNodezone = new JLabel("NodeZone");
		lblNodezone.setBounds(10, 203, 58, 14);
		
		
		JLabel lblZi = new JLabel("ZI");
		lblZi.setBounds(181, 172, 46, 14);

		
		JLabel lblZiZone = new JLabel("ZI Zone");
		lblZiZone.setBounds(163, 203, 46, 14);
		NodeNumber = new JTextField();
		NodeNumber.setBounds(67, 169, 86, 20);
		frame.getContentPane().add(NodeNumber);
		NodeNumber.setColumns(10);
		
		NodeZone = new JTextField();
		NodeZone.setColumns(10);
		NodeZone.setBounds(67, 200, 86, 20);
		frame.getContentPane().add(NodeZone);
		
		ZINumber = new JTextField();
		ZINumber.setColumns(10);
		ZINumber.setBounds(203, 169, 86, 20);
		frame.getContentPane().add(ZINumber);
		
		ZIZone = new JTextField();
		ZIZone.setColumns(10);
		ZIZone.setBounds(203, 200, 86, 20);
		frame.getContentPane().add(ZIZone);		
		btnNewButton_5.setEnabled(false);
		frame.getContentPane().setLayout(null);
		table = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 5, 279, 153);
		frame.getContentPane().add(scrollPane);

		final JTextPane textPane = new JTextPane();
		textPane.setBounds(10, 585, 256, 82);
		frame.getContentPane().add(textPane);
		// s.test(80, 120, 150, 5);
		model.addColumn("id");
		model.addColumn("status");
		model.addColumn("score");
		model.addColumn("ptX");
		model.addColumn("ptY");
		model.addColumn("INT");
		btnNewButton = new JButton("Clear");

		panel = new JPanel();
		panel.setBounds(286, 5, 1054, 680);

		panel.setLayout(null);

		pointPanel.setBounds(10, 0, 1034, 658);

		panel.add(pointPanel);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNewButton.setEnabled(false);
				Serveur2.clear();
				pointPanel.clear();
				Serveur2.numberC = 0;

				model.setRowCount(0);
				for (int i = 0; i < Serveur2.nodes.size(); i++) {
					Vector<String> k = new Vector<String>();
					k.add(Serveur2.nodes.get(i).getId() + "");
					k.add(Serveur2.nodes.get(i).getStatus() + "");
					k.add(String
							.format("%.2f", Serveur2.nodes.get(i).getScore()));
					if (Serveur2.nodes.get(i).getScore() > 0)
						Serveur2.numberC++;
					k.add(Serveur2.nodes.get(i).getPtX() + "");
					k.add(Serveur2.nodes.get(i).getPtY() + "");
					k.add(Serveur2.nodes.get(i).getInt() + "");
					model.addRow(k);
				}
				for (int i = 0; i < Serveur2.zoneInt.size(); i++) {
					Vector<String> k = new Vector<String>();
					k.add(Serveur2.zoneInt.get(i).getId() + "");
					k.add(Serveur2.zoneInt.get(i).getStatus() + "");
					k.add(String.format("%.2f", Serveur2.zoneInt.get(i)
							.getScore()));

					k.add(Serveur2.zoneInt.get(i).getPtX() + "");
					k.add(Serveur2.zoneInt.get(i).getPtY() + "");
					k.add(Serveur2.zoneInt.get(i).getInt() + "");
					model.addRow(k);
				}
				table.setModel(model);
				double a = ((double) Serveur2.numberC / (double) Serveur2.nbtotal) * 100;
			//	lblNewLabel.setText("couvertur = " + a);
				//lblNewLabel_1.setText("nC=" + serveur.numberC + "   nbtotal= "
				//		+ serveur.nbtotal);

				if (Serveur2.finish)
					btnNewButton.setEnabled(true);

				btnPhase.setEnabled(false);
			}
		});
		scrollPane.setRowHeaderView(btnNewButton);

		scrollPane.setViewportView(table);
		;
		frame.getContentPane().add(panel);
		btnNewButton_2.setBounds(10, 302, 93, 23);

		btnNewButton_2.setEnabled(false);
		btnPhase_1.setBounds(10, 336, 93, 23);
		btnPhase_1.setEnabled(false);
		btnPhase_2.setBounds(10, 404, 93, 23);
		btnPhase_2.setEnabled(false);
		btnPhaseb.setBounds(10, 370, 93, 23);
		btnPhaseb.setEnabled(false);
		btnPhase.setBounds(10, 268, 93, 23);
		btnPhase.setEnabled(false);
		conf.chckbxNewCheckBox.setEnabled(false);
		conf.chckbxNewCheckBox_1.setEnabled(false);
		conf.chckbxNewCheckBox_2.setEnabled(false);
		btnNewButton_1.setBounds(10, 234, 104, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					PrintStream fileStream = new PrintStream(new File("Latex_Phase.txt"));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(!NodeZone.getText().equals("") && !ZIZone.getText().equals("") && !NodeNumber.getText().equals("") 
						&& !ZINumber.getText().equals("")){
				btnNewButton.setEnabled(true);
				cnnx = false;
				checkBox = false;
				textPane.setText("");
				conf.chckbxNewCheckBox.setSelected(false);
				conf.chckbxNewCheckBox_1.setSelected(false);
				conf.chckbxNewCheckBox_2.setSelected(false);
				if (!UnitDisk.AddMan) {
					Serveur2.clear();
					pointPanel.clear();
				}


				
				if (!UnitDisk.AddMan) {
					s.test(Integer.parseInt(NodeZone.getText()), Integer.parseInt(ZIZone.getText()), 
							Integer.parseInt(NodeNumber.getText()), Integer.parseInt(ZINumber.getText()));
					// s.function2();
				}
				s.phase5 = false;
				if (!UnitDisk.AddMan) {
					pointPanel.plot_phase1();
					click = "";
					pointPanel.setBounds(10, 0, 1043, 658);
					Serveur2.numberC = 0;

				}
				model.setRowCount(0);
				//int a = Serveur.nodes.size();
				for (int i = 0; i < Serveur2.nodes.size(); i++) {
					Vector<String> k = new Vector<String>();
					k.add(Serveur2.nodes.get(i).getId() + "");
					k.add(Serveur2.nodes.get(i).getStatus() + "");
					k.add(String
							.format("%.2f", Serveur2.nodes.get(i).getScore()));
					if (Serveur2.nodes.get(i).getScore() > 0)
						Serveur2.numberC++;
					k.add(Serveur2.nodes.get(i).getPtX() + "");
					k.add(Serveur2.nodes.get(i).getPtY() + "");
					k.add(Serveur2.nodes.get(i).getInt() + "");
					model.addRow(k);
				}
				for (int i = 0; i < Serveur2.zoneInt.size(); i++) {
					Vector<String> k = new Vector<String>();
					k.add(Serveur2.zoneInt.get(i).getId() + "");
					k.add(Serveur2.zoneInt.get(i).getStatus() + "");
					k.add(String.format("%.2f", Serveur2.zoneInt.get(i)
							.getScore()));
					k.add(Serveur2.zoneInt.get(i).getPtX() + "");
					k.add(Serveur2.zoneInt.get(i).getPtY() + "");
					k.add(Serveur2.zoneInt.get(i).getInt() + "");
					model.addRow(k);

				}
				table.setModel(model);
				double a = ((double) Serveur2.numberC / (double) Serveur2.nbtotal) * 100;
				//lblNewLabel.setText("couvertur = " + a);
			//	lblNewLabel_1.setText("nC=" + serveur.numberC + "   nbtotal= "
			//			+ serveur.nbtotal);
				btnPhase.setEnabled(true);
				btnNewButton_2.setEnabled(false);
				btnPhase_1.setEnabled(false);
				btnPhase_2.setEnabled(false);
				btnPhaseb.setEnabled(false);
			}
			else
			{
				 
				 JOptionPane.showMessageDialog(null,  "add node number, node Zone \n"
						 +"ZI number, ZI Zone ");
			}
			}
		});
		frame.getContentPane().add(btnNewButton_1);

		btnPhase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				click = "Phase1";
				conf.chckbxNewCheckBox.setEnabled(true);
				conf.chckbxNewCheckBox_1.setEnabled(true);
				conf.chckbxNewCheckBox_2.setEnabled(true);
				s.mis = s.calculeMIS();
				btnPhase.setEnabled(false);
				btnNewButton_2.setEnabled(true);
				btnPhase_2.setEnabled(false);
				btnPhaseb.setEnabled(false);
				s.finish = true;
				s.CreateLatex_Phase1();
			}
			
		});
		frame.getContentPane().add(btnPhase);

		ActionListener actionListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abstractButton = (AbstractButton) actionEvent
						.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				System.out.println(selected);
				checkBox = selected;

			}
		};
		ActionListener actionListenerCnnx = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abstractButton = (AbstractButton) actionEvent
						.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				System.out.println(selected);
				cnnx = selected;

			}
		};

		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				click = "Phase2";
				s.phase2();
				btnNewButton_2.setEnabled(false);
				btnPhase_1.setEnabled(true);
				s.CreateLatex_Phase2("2");
				
			}
		});
		btnPhase_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				// textPane.setText(s.calculWhiteComp().toString());
				compp2 = s.phase3();
				btnPhase_1.setEnabled(false);
				btnPhaseb.setEnabled(true);
				s.CreateLatex_Phase2("3");

			}
		});
		frame.getContentPane().add(btnNewButton_2);
		frame.getContentPane().add(btnPhase_1);

		btnPhaseb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				s.phase3_b(compp2);
				btnPhase_2.setEnabled(true);
				btnPhaseb.setEnabled(false);
				s.CreateLatex_Phase2("3_b");
			}
		});
		frame.getContentPane().add(btnPhaseb);
		btnPhase_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				s.phase4_Version2();
				String st = "";
				st = st + "Wait For " + "Verification ..";
				st = st + "\n";
				if (s.verifier())
					st = st + "Solution verifier !";
				else
					st = st + "Solution non verifier !";
				textPane.setText(st);
				btnPhase_2.setEnabled(false);
				
				s.phase5();
				btnNewButton_5.setEnabled(true);
				s.CreateLatex_Phase2("4");
				// final JOptionPane optionPane = new JOptionPane(
				// "Finish ! \n"
				// + st+".\n"
				// + "New Exemple ?",
				// JOptionPane.QUESTION_MESSAGE,
				// JOptionPane.YES_NO_OPTION);
				// int dialogButton = JOptionPane.showConfirmDialog (null,
				// "Finish !\n"
				// + st+".\n"
				// + "New Exemple ?","New Exemple",JOptionPane.YES_NO_OPTION);
				//
				// if(dialogButton == JOptionPane.YES_OPTION) {
				// btnNewButton_1.doClick();
			}
		});
		frame.getContentPane().add(btnPhase_2);
		JButton btnConfig = new JButton("Config.");
		btnConfig.setBounds(124, 302, 103, 23);
		btnConfig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!conf.startttt) {
					conf.start();
				}
			}
		});
		frame.setTitle("ALGORITHME");
		frame.getContentPane().add(btnConfig);
		JButton btnNewButton_3 = new JButton("Verification 100 Exm");
		btnNewButton_3.setBounds(10, 503, 225, 23);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				long startTime = System.currentTimeMillis();
				boolean ok = true;
				for (startt = 0; startt <= 100 && ok; startt++) {
					final int val = startt;
					btnNewButton.setEnabled(true);
					cnnx = false;
					checkBox = false;
					conf.chckbxNewCheckBox.setSelected(false);
					conf.chckbxNewCheckBox_1.setSelected(false);
					conf.chckbxNewCheckBox_2.setSelected(false);
					Serveur2.clear();
					pointPanel.clear();
					//String nb = textPane_1.getText();
					//String nb2 = textPane_2.getText();
				//	String nb3 = textPane_3.getText();
				//	String nb4 = textPane_4.getText();

					s.test(50, 100, 100, 5);
					pointPanel.plot_phase1();
					click = "";
					pointPanel.setBounds(5, 11, 761, 680);
					Serveur2.numberC = 0;
					model.setRowCount(0);
					for (int i = 0; i < Serveur2.nodes.size(); i++) {
						Vector<String> k = new Vector<String>();
						k.add(Serveur2.nodes.get(i).getId() + "");
						k.add(Serveur2.nodes.get(i).getStatus() + "");
						k.add(String.format("%.2f", Serveur2.nodes.get(i)
								.getScore()));
						if (Serveur2.nodes.get(i).getScore() > 0)
							Serveur2.numberC++;
						k.add(Serveur2.nodes.get(i).getPtX() + "");
						k.add(Serveur2.nodes.get(i).getPtY() + "");
						k.add(Serveur2.nodes.get(i).getInt() + "");
						model.addRow(k);
					}
					for (int i = 0; i < Serveur2.zoneInt.size(); i++) {
						Vector<String> k = new Vector<String>();
						k.add(Serveur2.zoneInt.get(i).getId() + "");
						k.add(Serveur2.zoneInt.get(i).getStatus() + "");
						k.add(String.format("%.2f", Serveur2.zoneInt.get(i)
								.getScore()));
						k.add(Serveur2.zoneInt.get(i).getPtX() + "");
						k.add(Serveur2.zoneInt.get(i).getPtY() + "");
						k.add(Serveur2.zoneInt.get(i).getInt() + "");
						model.addRow(k);
					}
					table.setModel(model);
					double a = ((double) Serveur2.numberC / (double) Serveur2.nbtotal) * 100;
					//lblNewLabel.setText("couvertur = " + a);
					//lblNewLabel_1.setText("nC=" + serveur.numberC
						//	+ "   nbtotal= " + serveur.nbtotal);
					String sk = "On a " + Serveur2.Comp.size() + " Composant";
					sk = sk + " \n";
					sk = sk + Serveur2.Comp.toString();
					sk = sk + " \n";
					textPane.setText(sk);
					btnPhase.setEnabled(true);
					btnNewButton_2.setEnabled(false);
					btnPhase_1.setEnabled(false);
					btnPhase_2.setEnabled(false);
					btnPhaseb.setEnabled(false);
					click = "Phase1";
					conf.chckbxNewCheckBox.setEnabled(true);
					conf.chckbxNewCheckBox_1.setEnabled(true);
					conf.chckbxNewCheckBox_2.setSelected(true);
					s.mis = s.calculeMIS();
					sk = "";
					sk = textPane.getText();
					sk = sk + "\n";
					sk = sk + "  les " + Serveur2.mis.size() + " MIS sont : \n";
					sk = sk + Serveur2.mis.toString();
					sk = sk + " \n";
					textPane.setText(sk);
					btnPhase.setEnabled(false);
					btnNewButton_2.setEnabled(true);
					btnPhase_2.setEnabled(false);
					btnPhaseb.setEnabled(false);
					click = "Phase2";
					s.phase2();
					btnNewButton_2.setEnabled(false);
					btnPhase_1.setEnabled(true);
					textPane.setText(s.calculWhiteComp().toString());
					compp2 = s.phase3();
					btnPhase_1.setEnabled(false);
					btnPhaseb.setEnabled(true);
					s.phase3_b(compp2);
					btnPhase_2.setEnabled(true);
					btnPhaseb.setEnabled(false);
					s.phase4();
					s.getBlackCompInCompConnx();
					// if(v2)
					s.phase4_Version2();
					s.miniServeur();
					String st = "Finish";
					st = st + "\n" + " Verification ..";
					st = st + "\n";
					ok = false;
					if (s.verifier()) {
						st = st + " Valide !";
						ok = true;
					} else
						st = st + " Non-Valide !";
					textPane.setText(st);
					btnPhase_2.setEnabled(false);
				}
				long stopTime = System.currentTimeMillis();
				long elapsedTime = stopTime - startTime;
				NumberFormat formatter = new DecimalFormat("#0.00000");
				String k = textPane.getText();
				k = k + "\n";
				k = k + "Execution time is "
						+ formatter.format((elapsedTime) / 1000d) + " seconds";
				textPane.setText(k);

			}
		});
		frame.getContentPane().add(btnNewButton_3);
		textPane.setEditable(false);
		btnConfig.setVisible(true);
		frame.setJMenuBar(menuBar);
		createMenuBar(window, pointPanel, s);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				drawing = new PointPanel();
				// drawing.start();

			}
		});
		frame.getContentPane().add(btnNewButton_4);

		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// pointPanel.drawImg=true;
				BufferedImage image = new BufferedImage(panel.getWidth(), panel
						.getHeight(), BufferedImage.TYPE_INT_RGB);
				Graphics2D graphics2D = image.createGraphics();
				panel.paint(graphics2D);
				try {
					ImageIO.write(image, "jpg", new File("imageGraphe.jpg"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Serveur2.createTXTB();
				Serveur2.CreateLatex();
				String st = textPane.getText();
				st = st + "\n";
				st = st + "Create TXT File.";
				textPane.setText(st);
				// PointPanelC.finish=true;
			}
		});
		frame.getContentPane().add(btnNewButton_5);
		ActionListener AddManualListener = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abstractButton = (AbstractButton) actionEvent
						.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				v2 = selected;

			}
		};
		chckbxV.setBounds(124, 425, 97, 23);
		chckbxV.addActionListener(AddManualListener);
		frame.getContentPane().add(chckbxV);
		chckbxV_1.setBounds(124, 447, 97, 23);
		chckbxV_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbstractButton abstractButton = (AbstractButton) arg0
						.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				v3 = selected;
			}
		});
		frame.getContentPane().add(chckbxV_1);

		JCheckBox chckbxV_2 = new JCheckBox("Optimal");
		chckbxV_2.setBounds(124, 473, 97, 23);
		chckbxV_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AbstractButton abstractButton = (AbstractButton) arg0
						.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				v4 = selected;
			}
		});
		frame.getContentPane().add(chckbxV_2);

		JButton btnPhmini = new JButton("Ph. 4Mini");
		btnPhmini.setBounds(10, 435, 93, 23);
		btnPhmini.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (v4)
					s.miniServeur();
				String st = "";
				if (s.verifier()) {
					st = st + " Valide !";

				} else
					st = st + " Non-Valide !";
				textPane.setText(st);
				s.CreateLatex_Phase2("4_mini");
				
			}
		});
		btnPhmini.setEnabled(true);
		frame.getContentPane().add(btnPhmini);
		JButton btnNewButton_7 = new JButton("Save Ex");
		btnNewButton_7.setBounds(124, 336, 103, 23);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//serveur.save_Exele();
			}
		});
		frame.getContentPane().add(btnNewButton_7);
		
		JButton btnSim = new JButton("Sim");
		btnSim.setBounds(10, 469, 89, 23);
		btnSim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Thread t = new Thread(new Runnable() {
					public void run() {

					//	stage sk = new stage();
						//sk.start();
					//	UnitDisk.fi = true;
						Simulation s=new Simulation();
						s.start();
					}
				});
				t.start();
				
			}
		});
		frame.getContentPane().add(btnSim);
		
		
		
	
		frame.getContentPane().add(lblNode);
		
	
		frame.getContentPane().add(lblNodezone);
		
		frame.getContentPane().add(lblZi);
		
		
		frame.getContentPane().add(lblZiZone);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Serveur2 s=new Serveur2();
				s.clear();
				Serveur2.numberC = 0;
				pointPanel.clear();
				s.nodes =s.readDataVReel("data_2/test noisy.txt",5,10,150);
				s.calculMatriceScore();// matrice de score
				s.calculMatriceDist();
				// matrice de distance
				s.addNeighbour();// hashM
				s.CreateComp();// les composants connexes
				s.mis=s.calculeMIS();
				pointPanel.plot_phase1();
				click = "";
				pointPanel.setBounds(10, 0, 1043, 658);
				Serveur2.numberC = 0;
				click = "Phase1";
				click = "Phase2";
				try {
					PrintStream fileStream = new PrintStream(new File("fileTest.txt"));
					fileStream.println("Point");
					for (int i = 0; i < s.nodes.size(); i++) {
						
							fileStream.println(s.nodes.get(i).getPtX()
									+ " " + s.nodes.get(i).getPtY()+" "+(int)s.nodes.get(i).getR());
						
					}
					fileStream.println("ZoneInt");
					for (int i = 0; i < s.zoneInt.size(); i++) {
						fileStream.println(s.zoneInt.get(i).getPtX()
								+ " " + s.zoneInt.get(i).getPtY()+" "+(int)s.zoneInt.get(i).getR());
					}
					fileStream.close();
					// System.out.println("Create Folder");
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				s.phase2();
				conf.chckbxNewCheckBox.setEnabled(true);
				conf.chckbxNewCheckBox_1.setEnabled(true);
				conf.chckbxNewCheckBox_2.setSelected(true);
				btnNewButton_2.setEnabled(false);
				btnPhase_1.setEnabled(true);
				textPane.setText(s.calculWhiteComp().toString());
				compp2 = s.phase3();
				btnPhase_1.setEnabled(false);
				btnPhaseb.setEnabled(true);
				s.phase3_b(compp2);
				btnPhase_2.setEnabled(true);
				btnPhaseb.setEnabled(false);
				s.phase4();
				s.getBlackCompInCompConnx();
				// if(v2)
				s.phase4_Version2();
				//s.miniServeur();
				Serveur2.createTXTB();
				System.out.println(s.zoneInt.size());
			}
		});
		btnNewButton_6.setBounds(187, 537, 89, 23);
		frame.getContentPane().add(btnNewButton_6);
		window.frame.setVisible(true);
return;
	}
	static void runServeur(String version,Serveur2 s)
	{
		
		if(version.equals("V4"))
		{
			UnitDisk.v4=true;
		}
		else 
			UnitDisk.v4=false;
		if(version.equals("V3"))
		{
			UnitDisk.v2=true;
			UnitDisk.v3=true;
			
		}
		else
		{
			UnitDisk.v2=false;
			UnitDisk.v3=false;
		}
		if(version.equals("Initial"))
		{
			UnitDisk.v2=false;
			UnitDisk.v3=false;
			UnitDisk.v4=false;
		}
		s=new Serveur2();
		s.clear();
		Serveur2.numberC = 0;
		pointPanel.clear();
		// matrice de distance
		s.test(Integer.parseInt(NodeZone.getText()), Integer.parseInt(ZIZone.getText()), 
				Integer.parseInt(NodeNumber.getText()), Integer.parseInt(ZINumber.getText()));
		s.mis=s.calculeMIS();
		pointPanel.plot_phase1();
		click = "";
		pointPanel.setBounds(10, 0, 1043, 658);
		Serveur2.numberC = 0;
		click = "Phase1";
		click = "Phase2";
		s.phase2();
		conf.chckbxNewCheckBox.setEnabled(true);
		conf.chckbxNewCheckBox_1.setEnabled(true);
		conf.chckbxNewCheckBox_2.setSelected(true);
		btnNewButton_2.setEnabled(false);
		btnPhase_1.setEnabled(true);
		compp2 = s.phase3();
		btnPhase_1.setEnabled(false);
		btnPhaseb.setEnabled(true);
		s.phase3_b(compp2);
		btnPhase_2.setEnabled(true);
		btnPhaseb.setEnabled(false);
		s.phase4();
		s.getBlackCompInCompConnx();
		s.phase4_Version2();
		if(version.equals("V4"))
		s.miniServeur();
		Serveur2.createTXTB();
		System.out.println(s.zoneInt.size());
		
		
	}
	public static JFrame getFrame() {
		return frame;
	}

	public static void setFrame(JFrame frame) {
		UnitDisk.frame = frame;
	}

	public static DefaultTableModel getModel() {
		return model;
	}

	public static void setModel(DefaultTableModel model) {
		UnitDisk.model = model;
	}

	public static JButton getBtnNewButton() {
		return btnNewButton;
	}

	public static JButton getBtnNewButton_1() {
		return btnNewButton_1;
	}

	public static void setBtnNewButton(JButton btnNewButton) {
		UnitDisk.btnNewButton = btnNewButton;
	}

	public static int getStartt() {
		return startt;
	}

	public static void setStartt(int startt) {
		UnitDisk.startt = startt;
	}

	public static Vector<Vector<String>> getData() {
		return data;
	}

	public static void setData(Vector<Vector<String>> data) {
		UnitDisk.data = data;
	}

	public static JTable getTable() {
		return table;
	}

	public static void setTable(JTable table) {
		UnitDisk.table = table;
	}

//	public static JLabel getLblNewLabel() {
//	//	return lblNewLabel;
//	}
//
//	public static void setLblNewLabel(JLabel lblNewLabel) {
//	//	UnitDisk.lblNewLabel = lblNewLabel;
//	}
//
//	public static JLabel getLblNewLabel_1() {
//	//	return lblNewLabel_1;
//	}
//
//	public static void setLblNewLabel_1(JLabel lblNewLabel_1) {
//		//UnitDisk.lblNewLabel_1 = lblNewLabel_1;
//	}

	public static JPanel getPanel() {
		return panel;
	}

	public static void setPanel(JPanel panel) {
		UnitDisk.panel = panel;
	}

	public static JMenuBar getMenuBar() {
		return menuBar;
	}

	public static void setMenuBar(JMenuBar menuBar) {
		UnitDisk.menuBar = menuBar;
	}

	public static String getClick() {
		return click;
	}

	public static void setClick(String click) {
		UnitDisk.click = click;
	}

	public static boolean isCheckBox() {
		return checkBox;
	}

	public static void setCheckBox(boolean checkBox) {
		UnitDisk.checkBox = checkBox;
	}

	public static boolean isStart() {
		return start;
	}

	public static void setStart(boolean start) {
		UnitDisk.start = start;
	}

	public static boolean isViewID() {
		return viewID;
	}

	public static void setViewID(boolean viewID) {
		UnitDisk.viewID = viewID;
	}

	public static boolean isOnlyB() {
		return onlyB;
	}

	public static void setOnlyB(boolean onlyB) {
		UnitDisk.onlyB = onlyB;
	}

	public static boolean isAddMan() {
		return AddMan;
	}

	public static void setAddMan(boolean addMan) {
		AddMan = addMan;
	}

	public static boolean isCnnx() {
		return cnnx;
	}

	public static void setCnnx(boolean cnnx) {
		UnitDisk.cnnx = cnnx;
	}

	public static HashMap<Integer, ArrayList<Integer>> getCompp2() {
		return compp2;
	}

	public static void setCompp2(HashMap<Integer, ArrayList<Integer>> compp2) {
		UnitDisk.compp2 = compp2;
	}

	public static PointPanelC getPointPanel() {
		return pointPanel;
	}

	public static void setPointPanel(PointPanelC pointPanel) {
		UnitDisk.pointPanel = pointPanel;
	}

	public static PointPanel getDrawing() {
		return drawing;
	}

	public static void setDrawing(PointPanel drawing) {
		UnitDisk.drawing = drawing;
	}

	public static Configuration getConf() {
		return conf;
	}

	private static void createMenuBar(final UnitDisk window,
			final PointPanelC pointPanel, final Serveur2 s) {

		ImageIcon icon = new ImageIcon("Exit.png");
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		ImageIcon icon2 = new ImageIcon("settings.png");

		JMenuItem eMenuItem = new JMenuItem("Exit", icon);
		JMenuItem Config = new JMenuItem("Configuration", icon2);
		Config.setToolTipText("Configuration");
		Config.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {

				if (!conf.startttt) {
					conf.start();
				}

			}
		});
		eMenuItem.setMnemonic(KeyEvent.VK_E);
		eMenuItem.setToolTipText("Exit application");
		eMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
				window.frame.dispose();
				window.frame.removeAll();
				window.table.removeAll();
				window.menuBar.removeAll();
				window.model = new DefaultTableModel();
				pointPanel.clear();
				s.clear();

			}
		});

		file.add(Config);
		file.add(eMenuItem);
		menuBar.add(file);

	}
}
