import java.awt.EventQueue;

import javafx.scene.chart.XYChart;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Random;

import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class Simulation {

	private static JFrame frame;
	static boolean TR=false;
	static boolean ZI=false;
	public static void main(String[] args) throws FileNotFoundException {
		//start();
		//simulationVersion2();
		simulationVReel();
	}
	static void setLableInfo()
	{
		//String s="";
		//s=s+"Transmission Range :\n";
		//s=s+"Nombre node :\n ";
		//s=s+"Zone de couvertoure :\n";
		//textPane.setText(s);
		//textPane.setEnabled(false);
	}
	
	static void generateTransmissionRange()
	{
		int x = 0, y = 0;
		int min = 0, max = 20;
		Random rand = new Random();
		PrintStream fileStream;
		int ds=100;
		 
		ArrayList<Integer> randX=new ArrayList<Integer>();
		ArrayList<Integer> randY=new ArrayList<Integer>();
		ArrayList<Integer> ZrandX=new ArrayList<Integer>();
		ArrayList<Integer> ZrandY=new ArrayList<Integer>();
		for(int i=0;i<500;i++)
		{
			int randomNumX = rand.nextInt((1000 - 0) + 1) + 0;
			int randomNumY = rand.nextInt((1000 - 0) + 1) + 0;
			rand = new Random();
			min = randomNumX;
			max = randomNumY;
			randX.add(min);
			randY.add(max);
		}
		
		for (int i = 0; i < 5; i++) {
			int randomNumX = rand.nextInt((1000 - 0) + 1) + 0;
			int randomNumY = rand.nextInt((1000 - 0) + 1) + 0;
			rand = new Random();
			min = randomNumX;
			max = randomNumY;
			ZrandX.add(min);
			ZrandY.add(max);
		}
		for(int d=0;d<500;d++){

		try {
			fileStream = new PrintStream(new File("data/file"+d+".txt"));
			fileStream.println("Point");
			for (int i = 0; i < 100; i++) {
				 fileStream.println(randX.get(i) + " " + randY.get(i) + " " + ds);
				 Node nn = new Node(0, randX.get(i),randY.get(i), ds, "nodes");
				
			}
			fileStream.println("ZoneInt");
			
			for (int i = 0; i < 5; i++) {
				 fileStream.println(ZrandX.get(i)+100 + " " + (ZrandY.get(i)) + " " + 300);
				 Node nn = new Node(i, ZrandX.get(i)+100, (ZrandY.get(i)), 300,"PointInt");
			
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 ds=ds+1;
		}
		System.out.println("Gerenate Data File");
	}
	static void generateNombreNode()
	{
		int x = 0, y = 0;
		int min = 0, max = 20;
		Random rand = new Random();
		PrintStream fileStream;
		int ds=200;
		 
		ArrayList<Integer> randX=new ArrayList<Integer>();
		ArrayList<Integer> randY=new ArrayList<Integer>();
		ArrayList<Integer> ZrandX=new ArrayList<Integer>();
		ArrayList<Integer> ZrandY=new ArrayList<Integer>();
		for(int i=0;i<1000;i++)
		{
			int randomNumX = rand.nextInt((1000 - 0) + 1) + 0;
			int randomNumY = rand.nextInt((1000 - 0) + 1) + 0;
			rand = new Random();
			min = randomNumX;
			max = randomNumY;
			randX.add(min);
			randY.add(max);
		}
		
		for (int i = 0; i < 5; i++) {
			int randomNumX = rand.nextInt((1000 - 0) + 1) + 0;
			int randomNumY = rand.nextInt((1000 - 0) + 1) + 0;
			rand = new Random();
			min = randomNumX;
			max = randomNumY;
			ZrandX.add(min);
			ZrandY.add(max);
		}
		ds=1;
		for(int d=0;d<500;d++){
			
		try {
			fileStream = new PrintStream(new File("data/file"+d+".txt"));
			fileStream.println("Point");
			int k=0;
			for (int i = 0; i < ds; i++) {
				 fileStream.println(randX.get(k) + " " + randY.get(k) + " " + 100);
				 Node nn = new Node(0, randX.get(k),randY.get(k), 100, "nodes");
				k++;
			}
			fileStream.println("ZoneInt");
			
			for (int i = 0; i < 5; i++) {
				 fileStream.println(ZrandX.get(i)+100 + " " + (ZrandY.get(i)) + " " + 300);
				 Node nn = new Node(i, ZrandX.get(i)+100, (ZrandY.get(i)), 300,"PointInt");
			
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 ds=ds+1;
		}
		System.out.println("Gerenate Data File");
	}
	static void generateZoneInt()
	{
		int x = 0, y = 0;
		int min = 0, max = 20;
		Random rand = new Random();
		PrintStream fileStream;
		int ds=200;
		 
		ArrayList<Integer> randX=new ArrayList<Integer>();
		ArrayList<Integer> randY=new ArrayList<Integer>();
		ArrayList<Integer> ZrandX=new ArrayList<Integer>();
		ArrayList<Integer> ZrandY=new ArrayList<Integer>();
		for(int i=0;i<200;i++)
		{
			int randomNumX = rand.nextInt((1000 - 0) + 1) + 0;
			int randomNumY = rand.nextInt((1000 - 0) + 1) + 0;
			rand = new Random();
			min = randomNumX;
			max = randomNumY;
			randX.add(min);
			randY.add(max);
		}
		
		for (int i = 0; i < 200; i++) {
			int randomNumX = rand.nextInt((1000 - 0) + 1) + 0;
			int randomNumY = rand.nextInt((1000 - 0) + 1) + 0;
			rand = new Random();
			min = randomNumX;
			max = randomNumY;
			ZrandX.add(min);
			ZrandY.add(max);
		}
		ds=1;
		for(int d=0;d<200;d++){
			
		try {
			fileStream = new PrintStream(new File("data/file"+d+".txt"));
			fileStream.println("Point");
			int k=0;
			for (int i = 0; i < 200; i++) {
				 fileStream.println(randX.get(k) + " " + randY.get(k) + " " + 100);
				 Node nn = new Node(0, randX.get(k),randY.get(k), 100, "nodes");
				k++;
			}
			fileStream.println("ZoneInt");
			for (int i = 0; i < ds; i++) {
				 fileStream.println(ZrandX.get(i)+100 + " " + (ZrandY.get(i)) + " " + 300);
				 Node nn = new Node(i, ZrandX.get(i)+100, (ZrandY.get(i)), 300,"PointInt");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 ds=ds+1;
		}
		System.out.println("Gerenate Data File");
	}
	static void generateRangeZoneInt()
	{
		int x = 0, y = 0;
		int min = 0, max = 20;
		Random rand = new Random();
		PrintStream fileStream;
		int ds=200;
		 
		ArrayList<Integer> randX=new ArrayList<Integer>();
		ArrayList<Integer> randY=new ArrayList<Integer>();
		ArrayList<Integer> ZrandX=new ArrayList<Integer>();
		ArrayList<Integer> ZrandY=new ArrayList<Integer>();
		for(int i=0;i<200;i++)
		{
			int randomNumX = rand.nextInt((1000 - 0) + 1) + 0;
			int randomNumY = rand.nextInt((1000 - 0) + 1) + 0;
			rand = new Random();
			min = randomNumX;
			max = randomNumY;
			randX.add(min);
			randY.add(max);
		}
		
		for (int i = 0; i < 5; i++) {
			int randomNumX = rand.nextInt((1000 - 0) + 1) + 0;
			int randomNumY = rand.nextInt((1000 - 0) + 1) + 0;
			rand = new Random();
			min = randomNumX;
			max = randomNumY;
			ZrandX.add(min);
			ZrandY.add(max);
		}
		ds=1;
		for(int d=0;d<200;d++){
			
		try {
			fileStream = new PrintStream(new File("data/file"+d+".txt"));
			fileStream.println("Point");
			int k=0;
			for (int i = 0; i < 200; i++) {
				 fileStream.println(randX.get(k) + " " + randY.get(k) + " " + 100);
				 Node nn = new Node(0, randX.get(k),randY.get(k), 100, "nodes");
				k++;
			}
			fileStream.println("ZoneInt");
			for (int i = 0; i < 5; i++) {
				 fileStream.println(ZrandX.get(i)+100 + " " + (ZrandY.get(i)) + " " + ds);
				 Node nn = new Node(i, ZrandX.get(i)+100, (ZrandY.get(i)), ds,"PointInt");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ds=ds+3;
		}
		System.out.println("Gerenate Data File");
	}
	static void simulationPhase1()
	{
		
		HashMap<Double,Integer> ResultInit=new 	HashMap<Double,Integer>();
		HashMap<Double,Integer> ResultModifier=new 	HashMap<Double,Integer>();
		HashMap<Double,Integer> ResultModifierG=new 	HashMap<Double,Integer>();
		ArrayList<Double> valeur=new ArrayList<Double>();
		try {
			PrintStream fileStream = new PrintStream(new File("LatexGraphe.txt"));
			boolean ok=true;
			Serveur2 s=new Serveur2();
			if(TR){
			generateTransmissionRange();
			fileStream.println("\\begin{tikzpicture}");
			fileStream.println("\\pgfplotsset{every axis legend/.append style={at={(0.5,1.03)},anchor=south}}");
			fileStream
					.println("\\begin{axis}[ xlabel={Transmission Range}, ylabel={CDS Size},ymin=0,ymax=60  ]");
			fileStream.println("\\addplot[mark=none,blue,ultra thick] coordinates {");
			//simulation
			
			for (int startt = 0; startt < 500 && ok; startt++) {
				final int val = startt;
				Serveur2.clear();
				s=new Serveur2();
				System.out.println("Read File : "+"data/file"+startt+".txt");
				s.nodes = s.readData("data/file"+startt+".txt");
			// read data from txt file
				s.calculMatriceDist(); // matrice de distance
				s.addNeighbour(); // hashM
				s.calculMatriceScore(); // matrice de score
				s.CreateComp();
				Serveur2.numberC = 0;
				UnitDisk.v3=false;
				UnitDisk.v4=false;
				s.mis = s.calculeMIS();
				s.phase2();
				UnitDisk.compp2 = s.phase3();
				s.phase3_b(UnitDisk.compp2);
				s.phase4();
				s.getBlackCompInCompConnx();
				s.phase4_Version2();				
				//s.miniServeur();
				if (s.verifier()) {	
					ok = true;
					int hg=0;
					for(int j=0;j<s.col.size();j++)
					{
						if(s.col.get(j).equals("black"))
						{
							hg++;
						}
					}
					
					fileStream.println("("+s.nodes.get(0).getR()+","+hg+")");	
					ResultInit.put(s.nodes.get(0).getR(), hg);
					valeur.add(s.nodes.get(0).getR());
				} 
				
			}
			fileStream.println("}; ");
			fileStream.println("\\addplot[mark=none,green,ultra thick] coordinates {");
			for (int startt = 0; startt < 500 && ok;  startt++) {
				final int val = startt;
				Serveur2.clear();
				s=new Serveur2();
				//s.test(80, 120, 500, 5);
				System.out.println("Read File : "+"data/file"+startt+".txt");
				s.nodes = s.readData("data/file"+startt+".txt");
//			// read data from txt file
				s.calculMatriceDist(); // matrice de distance
				s.addNeighbour(); // hashM
				s.calculMatriceScore(); // matrice de score
				s.CreateComp();
				Serveur2.numberC = 0;
				UnitDisk.v2=true;
				UnitDisk.v3=true;
				s.mis = s.calculeMIS();
				s.phase2();
				UnitDisk.compp2 = s.phase3();
				s.phase3_b(UnitDisk.compp2);
				s.phase4();
				s.getBlackCompInCompConnx();
				s.phase4_Version2();				
				if (s.verifier()) {	
					ok = true;
					int hg=0;
					for(int j=0;j<s.col.size();j++)
					{
						if(s.col.get(j).equals("black"))
						{
							hg++;
						}
					}
					fileStream.println("("+s.nodes.get(0).getR()+","+hg+")");	
					ResultModifierG.put(s.nodes.get(0).getR(), hg);
			} 
			
			}
			fileStream.println("}; ");
			fileStream.println("\\addplot[mark=none,red,ultra thick] coordinates {");
			for (int startt = 0; startt < 500 && ok;  startt++) {
				final int val = startt;
				Serveur2.clear();
				s=new Serveur2();
				//s.test(80, 120, 500, 5);
				System.out.println("Read File : "+"data/file"+startt+".txt");
				s.nodes = s.readData("data/file"+startt+".txt");
//			// read data from txt file
				s.calculMatriceDist(); // matrice de distance
				s.addNeighbour(); // hashM
				s.calculMatriceScore(); // matrice de score
				s.CreateComp();
				Serveur2.numberC = 0;
				UnitDisk.v2=true;
				UnitDisk.v3=false;
				s.mis = s.calculeMIS();
				s.phase2();
				UnitDisk.compp2 = s.phase3();
				s.phase3_b(UnitDisk.compp2);
				s.phase4();
				s.getBlackCompInCompConnx();
				s.phase4_Version2();				
				s.miniServeur();
				if (s.verifier()) {	
					ok = true;
					int hg=0;
					for(int j=0;j<s.col.size();j++)
					{
						if(s.col.get(j).equals("black"))
						{
							hg++;
						}
					}
					fileStream.println("("+s.nodes.get(0).getR()+","+hg+")");	
					ResultModifier.put(s.nodes.get(0).getR(), hg);
			} 
			
			}
			fileStream.println("}; ");
			fileStream.println("\\legend{$d=initial$,$d=Gluton$,$d=optimal$} \\end{axis} \\end{tikzpicture}");
			//fileStream.println("\\begin{tikzpicture}");
			//fileStream.println("\\pgfplotsset{every axis legend/.append style={at={(0.5,1.03)},anchor=south}}");
		//	fileStream
		//			.println("\\begin{axis}[ xlabel={Transmission Range}, ylabel={(CDS Size Initial-CDS Modifier)/Total nodes} ]");
		//	fileStream.println("\\addplot coordinates {");
		//	System.out.println(ResultInit);
		//	for(int i=0;i<valeur.size();i++)
		//	{
		//		int init=ResultModifier.get(valeur.get(i))-ResultInit.get(valeur.get(i));
		//		float val=(float)init/100;
		//		fileStream.println("("+valeur.get(i)+","+(val)+")");	
		//	}
			//for (Entry<Double, Integer> entry : ResultInit
			//		.entrySet()) // Pour chaque composant
			//{
			//	int init=Math.abs(entry.getValue()-ResultModifier.get(entry.getKey()));
			//	float val=(float)init/100;
			//	fileStream.println("("+entry.getKey()+","+(val)+")");	
			//	}
			//fileStream.println("}; ");
			//fileStream.println("\\legend{$d=initial$,$d=modifier$} \\end{axis} \\end{tikzpicture}");
			//fileStream.println("\\begin{tikzpicture}");
			//fileStream.println("\\pgfplotsset{every axis legend/.append style={at={(0.5,1.03)},anchor=south}}");			
			//	fileStream
				//		.println("\\begin{axis}[ xlabel={Transmission Range}, ylabel={CDS Modifier/CDS Size Initial} ,ymax=10,ymin=0]");
			//	fileStream.println("\\addplot[mark=none,blue,ultra thick] coordinates {");
			//	System.out.println(ResultInit);
			//	for(int i=0;i<valeur.size();i++)
			//	{
			//		float init=(float)((float)ResultModifier.get(valeur.get(i))/(float)ResultInit.get(valeur.get(i)));
					//float val=(float)init/100;
			//		fileStream.println("("+valeur.get(i)+","+(init)+")");	
			//	}
			//	fileStream.println("}; ");
			//	fileStream.println("\\legend{} \\end{axis} \\end{tikzpicture}");
				
				
				
				
				fileStream.println("\\begin{tikzpicture}");
 				fileStream.println("\\pgfplotsset{every axis legend/.append style={at={(0.5,1.03)},anchor=south}}");			
				fileStream
						.println("\\begin{axis}[ xlabel={Average degree}, ylabel={CDS Size} ]");
				fileStream.println("\\addplot[mark=none,blue,ultra thick] coordinates {");
				//simulation
				ok=true;
				s=new Serveur2();
				for (int startt = 0; startt < 500 && ok; startt++) {
					final int val = startt;
					s=new Serveur2();
					Serveur2.clear();
					System.out.println("Read File : "+"data/file"+startt+".txt");
					s.nodes = s.readData("data/file"+startt+".txt");
				// read data from txt file
					UnitDisk.v3=false;
					UnitDisk.v2=false;
					s.calculMatriceDist(); // matrice de distance
					s.addNeighbour(); // hashM
					s.calculMatriceScore(); // matrice de score
					s.CreateComp();
					Serveur2.numberC = 0;
					s.mis = s.calculeMIS();
					s.phase2();
					UnitDisk.compp2 = s.phase3();
					s.phase3_b(UnitDisk.compp2);
					s.phase4();
					s.getBlackCompInCompConnx();
					s.phase4_Version2();				
					//s.miniServeur();
					if (s.verifier()) {	
						ok = true;
						int hg=0;
						for(int j=0;j<s.col.size();j++)
						{
							if(s.col.get(j).equals("black"))
							{
								hg++;
							}
						}
						
						fileStream.println("("+s.averageDegre(s)+","+hg+")");	
						//ResultInit.put(s.nodes.get(0).getR(), hg);
						//valeur.add(s.nodes.get(0).getR());
					} 
					
				}
				fileStream.println("}; ");
				fileStream.println("\\addplot[mark=none,green,ultra thick] coordinates {");
				//simulation
				ok=true;
				s=new Serveur2();
				for (int startt = 0; startt < 500 && ok; startt++) {
					final int val = startt;
					s=new Serveur2();
					Serveur2.clear();
					System.out.println("Read File : "+"data/file"+startt+".txt");
					s.nodes = s.readData("data/file"+startt+".txt");
				// read data from txt file
					s.calculMatriceDist(); // matrice de distance
					s.addNeighbour(); // hashM
					s.calculMatriceScore(); // matrice de score
					s.CreateComp();
					Serveur2.numberC = 0;
					s.mis = s.calculeMIS();
					s.phase2();
					UnitDisk.compp2 = s.phase3();
					UnitDisk.v3=true;
					UnitDisk.v2=true;
					s.phase3_b(UnitDisk.compp2);
					s.phase4();
					s.getBlackCompInCompConnx();
					s.phase4_Version2();				
					if (s.verifier()) {	
						ok = true;
						int hg=0;
						for(int j=0;j<s.col.size();j++)
						{
							if(s.col.get(j).equals("black"))
							{
								hg++;
							}
						}
						
						fileStream.println("("+s.averageDegre(s)+","+hg+")");	
						//ResultInit.put(s.nodes.get(0).getR(), hg);
						//valeur.add(s.nodes.get(0).getR());
					} 
					
				}
				fileStream.println("}; ");
				fileStream.println("\\addplot[mark=none,red,ultra thick] coordinates {");
				
				for (int startt = 0; startt < 500 && ok; startt++) {
					final int val = startt;
					Serveur2.clear();
					s=new Serveur2();
					//s.test(80, 120, 500, 5);
					System.out.println("Read File : "+"data/file"+startt+".txt");
					s.nodes = s.readData("data/file"+startt+".txt");
				// read data from txt file
					s.calculMatriceDist(); // matrice de distance
					s.addNeighbour(); // hashM
					s.calculMatriceScore(); // matrice de score
					s.CreateComp();
					Serveur2.numberC = 0;
					UnitDisk.v2=true;
					UnitDisk.v3=false;
					s.mis = s.calculeMIS();
					s.phase2();
					UnitDisk.compp2 = s.phase3();
					s.phase3_b(UnitDisk.compp2);
					s.phase4();
					s.getBlackCompInCompConnx();
					s.phase4_Version2();				
					s.miniServeur();
					if (s.verifier()) {	
						ok = true;
						int hg=0;
						for(int j=0;j<s.col.size();j++)
						{
							if(s.col.get(j).equals("black"))
							{
								hg++;
							}
						}
						fileStream.println("("+s.averageDegre(s)+","+hg+")");	
						//ResultModifier.put(s.nodes.get(0).getR(), hg);
					} 
					
				}
				fileStream.println("}; ");
				fileStream.println("\\legend{$d=initial$,$d=modifierG$,$d=modifier$} \\end{axis} \\end{tikzpicture}");
				generateNombreNode();
				ResultInit.clear();
				valeur.clear();
				fileStream.println("\\begin{tikzpicture}");
				fileStream.println("\\pgfplotsset{every axis legend/.append style={at={(0.5,1.03)},anchor=south}}");
				fileStream
						.println("\\begin{axis}[ xlabel={Number of nodes}, ylabel={CDS Size} ]");
				fileStream.println("\\addplot[mark=none,blue,ultra thick] coordinates {");
				//simulation
				ok=true;
				int ds=1;
				s=new Serveur2();
				for (int startt = 0; startt < 500 && ok; startt=startt+3) {
					final int val = startt;
					Serveur2.clear();
					s=new Serveur2();
					UnitDisk.v3=false;
					UnitDisk.v2=false;
					System.out.println("Read File : "+"data/file"+startt+".txt");
					s.nodes = s.readData("data/file"+startt+".txt");
				// read data from txt file
					s.calculMatriceDist(); // matrice de distance
					s.addNeighbour(); // hashM
					s.calculMatriceScore(); // matrice de score
					s.CreateComp();
					Serveur2.numberC = 0;
					s.mis = s.calculeMIS();
					s.phase2();
					UnitDisk.compp2 = s.phase3();
					s.phase3_b(UnitDisk.compp2);
					s.phase4();
					s.getBlackCompInCompConnx();
					s.phase4_Version2();				
					//s.miniServeur();
					if (s.verifier()) {	
						ok = true;
						int hg=0;
						for(int j=0;j<s.col.size();j++)
						{
							if(s.col.get(j).equals("black"))
							{
								hg++;
							}
						}
						
						fileStream.println("("+ds+","+hg+")");	
						ds=ds+3;
						ResultInit.put((double)ds, hg);
						valeur.add((double)ds);
					} 
					
				}
				ds=1;
				fileStream.println("}; ");
				ResultModifier.clear();
				fileStream.println("\\addplot[mark=none,green,ultra thick] coordinates {");
				//simulation
				ok=true;
				s=new Serveur2();
				for (int startt = 0; startt < 500 && ok; startt=startt+3) {
					final int val = startt;
					Serveur2.clear();
					s=new Serveur2();
					System.out.println("Read File : "+"data/file"+startt+".txt");
					s.nodes = s.readData("data/file"+startt+".txt");
				// read data from txt file
					s.calculMatriceDist(); // matrice de distance
					s.addNeighbour(); // hashM
					s.calculMatriceScore(); // matrice de score
					s.CreateComp();
					Serveur2.numberC = 0;
					s.mis = s.calculeMIS();
					s.phase2();
					UnitDisk.compp2 = s.phase3();
					UnitDisk.v3=true;
					UnitDisk.v4=true;
					s.phase3_b(UnitDisk.compp2);
					s.phase4();
					s.getBlackCompInCompConnx();
					s.phase4_Version2();				
					
					if (s.verifier()) {	
						ok = true;
						int hg=0;
						for(int j=0;j<s.col.size();j++)
						{
							if(s.col.get(j).equals("black"))
							{
								hg++;
							}
						}
						
						fileStream.println("("+ds+","+hg+")");	
						ds=ds+3;
						ResultInit.put((double)ds, hg);
						valeur.add((double)ds);
					} 
					
				}
				ds=1;
				fileStream.println("}; ");
				ResultModifier.clear();
				fileStream.println("\\addplot[mark=none,red,ultra thick] coordinates {");
				for (int startt = 0; startt < 500 && ok; startt=startt+3) {
					final int val = startt;
					Serveur2.clear();
					s=new Serveur2();
					//s.test(80, 120, 500, 5);
					System.out.println("Read File : "+"data/file"+startt+".txt");
					s.nodes = s.readData("data/file"+startt+".txt");
				// read data from txt file
					s.calculMatriceDist(); // matrice de distance
					s.addNeighbour(); // hashM
					s.calculMatriceScore(); // matrice de score
					s.CreateComp();
					Serveur2.numberC = 0;
					UnitDisk.v3=false;
					s.mis = s.calculeMIS();
					s.phase2();
					UnitDisk.compp2 = s.phase3();
					s.phase3_b(UnitDisk.compp2);
					s.phase4();
					s.getBlackCompInCompConnx();
					s.phase4_Version2();				
					s.miniServeur();
					if (s.verifier()) {	
						ok = true;
						int hg=0;
						for(int j=0;j<s.col.size();j++)
						{
							if(s.col.get(j).equals("black"))
							{
								hg++;
							}
						}
						fileStream.println("("+ds+","+hg+")");
						ds=ds+3;
						ResultModifier.put((double)ds, hg);
					} 
					
				}
				fileStream.println("}; ");
				fileStream.println("\\legend{$d=initial$,$d=gluton$,$d=optimal$} \\end{axis} \\end{tikzpicture}");
				
			//	fileStream.println("\\begin{tikzpicture}");
			//	fileStream.println("\\pgfplotsset{every axis legend/.append style={at={(0.5,1.03)},anchor=south}}");
			//	fileStream
			//			.println("\\begin{axis}[ xlabel={Nomber Node}, ylabel={CDS Modifier/CDS Size Initial} ,ymax=2,ymin=0]");
			//	fileStream.println("\\addplot coordinates {");
			//	System.out.println(ResultInit);
			//	for(int i=0;i<valeur.size();i++)
			//	{
			//		float init=(float)((float)ResultModifier.get(valeur.get(i))/(float)ResultInit.get(valeur.get(i)));
					//float val=(float)init/100;
			//		fileStream.println("("+valeur.get(i)+","+(init)+")");	
			//	}
			//	fileStream.println("}; ");
			//	fileStream.println("\\legend{} \\end{axis} \\end{tikzpicture}");
			//	fileStream.println("\\begin{tikzpicture}");
			//	fileStream.println("\\pgfplotsset{every axis legend/.append style={at={(0.5,1.03)},anchor=south}}");
			//	fileStream
			//			.println("\\begin{axis}[ xlabel={Nomber Node}, ylabel={Percentage} ]");
			//	fileStream.println("\\addplot[mark=none,blue,ultra thick] coordinates {");
			//	System.out.println(ResultInit);
			//	for(int i=0;i<valeur.size();i++)
			//	{
			//		float init=(float)((float)ResultModifier.get(valeur.get(i))/valeur.get(i));
					//float val=(float)init/100;
			//		fileStream.println("("+valeur.get(i)+","+(init)+")");	
			//	}
			//	fileStream.println("}; ");
			//	fileStream.println("\\addplot[mark=none,red,ultra thick] coordinates {");
				//System.out.println(ResultInit);
			//	for(int i=0;i<valeur.size();i++)
			//	{
				//	float init=(float)((float)ResultInit.get(valeur.get(i))/valeur.get(i));
					//float val=(float)init/100;
				//	fileStream.println("("+valeur.get(i)+","+(init)+")");	
			//	}
				//fileStream.println("}; ");
				//fileStream.println("\\legend{$d=initial$,$d=modifier$} \\end{axis} \\end{tikzpicture}");
			}
			if(ZI){
				generateZoneInt();
				fileStream.println("\\begin{tikzpicture}");
				fileStream.println("\\pgfplotsset{every axis legend/.append style={at={(0.5,1.03)},anchor=south}}");
				fileStream
						.println("\\begin{axis}[ xlabel={Nombre Zone Interet}, ylabel={CDS Size},ymin=50,ymax=120 ]");
				fileStream.println("\\addplot[mark=none,blue,ultra thick] coordinates {");
				//simulation
				ok=true;
				s=new Serveur2();
				for (int startt = 0; startt < 200 && ok; startt++) {
					final int val = startt;
					Serveur2.clear();
					s=new Serveur2();
					System.out.println("Read File : "+"data/file"+startt+".txt");
					s.nodes = s.readData("data/file"+startt+".txt");
				// read data from txt file
					s.calculMatriceDist(); // matrice de distance
					s.addNeighbour(); // hashM
					s.calculMatriceScore(); // matrice de score
					s.CreateComp();
					Serveur2.numberC = 0;
					s.mis = s.calculeMIS();
					s.phase2();
					UnitDisk.compp2 = s.phase3();
					s.phase3_b(UnitDisk.compp2);
					s.phase4();
					s.getBlackCompInCompConnx();
					s.phase4_Version2();				
					//s.miniServeur();
					if (s.verifier()) {	
						ok = true;
						int hg=0;
						for(int j=0;j<s.col.size();j++)
						{
							if(s.col.get(j).equals("black"))
							{
								hg++;
							}
						}
						
						fileStream.println("("+s.zoneInt.size()+","+hg+")");	
						ResultInit.put((double)s.zoneInt.size(), hg);
						valeur.add((double)s.zoneInt.size());
					} 
					
				}
				fileStream.println("}; ");
				fileStream.println("\\addplot[mark=none,green,ultra thick] coordinates {");
				for (int startt = 0; startt < 200 && ok;  startt++) {
					final int val = startt;
					Serveur2.clear();
					s=new Serveur2();
					//s.test(80, 120, 500, 5);
					System.out.println("Read File : "+"data/file"+startt+".txt");
					s.nodes = s.readData("data/file"+startt+".txt");
//				// read data from txt file
					s.calculMatriceDist(); // matrice de distance
					s.addNeighbour(); // hashM
					s.calculMatriceScore(); // matrice de score
					s.CreateComp();
					Serveur2.numberC = 0;
					UnitDisk.v2=true;
					UnitDisk.v3=true;
					s.mis = s.calculeMIS();
					s.phase2();
					UnitDisk.compp2 = s.phase3();
					s.phase3_b(UnitDisk.compp2);
					s.phase4();
					s.getBlackCompInCompConnx();
					s.phase4_Version2();				
				
					if (s.verifier()) {	
						ok = true;
						int hg=0;
						for(int j=0;j<s.col.size();j++)
						{
							if(s.col.get(j).equals("black"))
							{
								hg++;
							}
						}
						fileStream.println("("+s.zoneInt.size()+","+hg+")");	
						ResultModifierG.put((double)s.zoneInt.size(), hg);
				} 
				
				}
				fileStream.println("}; ");
				fileStream.println("\\addplot[mark=none,red,ultra thick] coordinates {");
				for (int startt = 0; startt < 200 && ok;  startt++) {
					final int val = startt;
					Serveur2.clear();
					s=new Serveur2();
					//s.test(80, 120, 500, 5);
					System.out.println("Read File : "+"data/file"+startt+".txt");
					s.nodes = s.readData("data/file"+startt+".txt");
//				// read data from txt file
					s.calculMatriceDist(); // matrice de distance
					s.addNeighbour(); // hashM
					s.calculMatriceScore(); // matrice de score
					s.CreateComp();
					Serveur2.numberC = 0;
					UnitDisk.v2=true;
					s.mis = s.calculeMIS();
					s.phase2();
					UnitDisk.compp2 = s.phase3();
					s.phase3_b(UnitDisk.compp2);
					s.phase4();
					s.getBlackCompInCompConnx();
					s.phase4_Version2();				
					s.miniServeur();
					if (s.verifier()) {	
						ok = true;
						int hg=0;
						for(int j=0;j<s.col.size();j++)
						{
							if(s.col.get(j).equals("black"))
							{
								hg++;
							}
						}
						fileStream.println("("+s.zoneInt.size()+","+hg+")");	
						ResultModifier.put((double)s.zoneInt.size(), hg);
				} 
				
				}
				fileStream.println("}; ");
				fileStream.println("\\legend{$d=initial$,$d=modifierG$,$d=modifier$} \\end{axis} \\end{tikzpicture}");
				generateRangeZoneInt();
				fileStream.println("\\begin{tikzpicture}");
				fileStream.println("\\pgfplotsset{every axis legend/.append style={at={(0.5,1.03)},anchor=south}}");
				fileStream
						.println("\\begin{axis}[ xlabel={Range Zone Interet}, ylabel={CDS Size},ymin=60,ymax=120 ]");
				fileStream.println("\\addplot[mark=none,blue,ultra thick] coordinates {");
				//simulation
				ok=true;
				s=new Serveur2();
				for (int startt = 0; startt < 200 && ok; startt++) {
					final int val = startt;
					Serveur2.clear();
					s=new Serveur2();
					UnitDisk.v3=false;
					UnitDisk.v4=false;
					UnitDisk.v2=false;
					System.out.println("Read File : "+"data/file"+startt+".txt");
					s.nodes = s.readData("data/file"+startt+".txt");
				// read data from txt file
					s.calculMatriceDist(); // matrice de distance
					s.addNeighbour(); // hashM
					s.calculMatriceScore(); // matrice de score
					s.CreateComp();
					Serveur2.numberC = 0;
					s.mis = s.calculeMIS();
					s.phase2();
					UnitDisk.compp2 = s.phase3();
					s.phase3_b(UnitDisk.compp2);
					s.phase4();
					s.getBlackCompInCompConnx();
					s.phase4_Version2();				
					//s.miniServeur();
					if (s.verifier()) {	
						ok = true;
						int hg=0;
						for(int j=0;j<s.col.size();j++)
						{
							if(s.col.get(j).equals("black"))
							{
								hg++;
							}
						}
						
						fileStream.println("("+s.zoneInt.get(0).getR()+","+hg+")");	
						ResultInit.put((double)s.zoneInt.get(0).getR(), hg);
						valeur.add((double)s.zoneInt.get(0).getR());
					} 
					
				}
				fileStream.println("}; ");
				fileStream.println("\\addplot[mark=none,green,ultra thick] coordinates {");
				for (int startt = 0; startt < 200 && ok;  startt++) {
					final int val = startt;
					Serveur2.clear();
					s=new Serveur2();
					//s.test(80, 120, 500, 5);
					System.out.println("Read File : "+"data/file"+startt+".txt");
					s.nodes = s.readData("data/file"+startt+".txt");
//				// read data from txt file
					s.calculMatriceDist(); // matrice de distance
					s.addNeighbour(); // hashM
					s.calculMatriceScore(); // matrice de score
					s.CreateComp();
					Serveur2.numberC = 0;
					UnitDisk.v2=true;
					UnitDisk.v3=true;
					s.mis = s.calculeMIS();
					s.phase2();
					UnitDisk.compp2 = s.phase3();
					s.phase3_b(UnitDisk.compp2);
					s.phase4();
					s.getBlackCompInCompConnx();
					s.phase4_Version2();				
				
					if (s.verifier()) {	
						ok = true;
						int hg=0;
						for(int j=0;j<s.col.size();j++)
						{
							if(s.col.get(j).equals("black"))
							{
								hg++;
							}
						}
						fileStream.println("("+s.zoneInt.get(0).getR()+","+hg+")");	
						ResultModifierG.put((double)s.zoneInt.get(0).getR(), hg);
				} 
				
				}
				fileStream.println("}; ");
				fileStream.println("\\addplot[mark=none,red,ultra thick] coordinates {");
				for (int startt = 0; startt < 200 && ok;  startt++) {
					final int val = startt;
					Serveur2.clear();
					s=new Serveur2();
					//s.test(80, 120, 500, 5);
					System.out.println("Read File : "+"data/file"+startt+".txt");
					s.nodes = s.readData("data/file"+startt+".txt");
//				// read data from txt file
					s.calculMatriceDist(); // matrice de distance
					s.addNeighbour(); // hashM
					s.calculMatriceScore(); // matrice de score
					s.CreateComp();
					Serveur2.numberC = 0;
					UnitDisk.v2=true;
					s.mis = s.calculeMIS();
					s.phase2();
					UnitDisk.compp2 = s.phase3();
					s.phase3_b(UnitDisk.compp2);
					s.phase4();
					s.getBlackCompInCompConnx();
					s.phase4_Version2();				
					s.miniServeur();
					if (s.verifier()) {	
						ok = true;
						int hg=0;
						for(int j=0;j<s.col.size();j++)
						{
							if(s.col.get(j).equals("black"))
							{
								hg++;
							}
						}
						fileStream.println("("+s.zoneInt.get(0).getR()+","+hg+")");	
						ResultModifier.put((double)s.zoneInt.get(0).getR(), hg);
				} 
				
				}
				fileStream.println("}; ");
				fileStream.println("\\legend{$d=initial$,$d=modifierG$,$d=modifier$} \\end{axis} \\end{tikzpicture}");
				
				fileStream.close();
			
			
		}
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Finish.");
	}
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void start() {
		// TODO Auto-generated method stub
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
	//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		JButton btnNewButton = new JButton("Start");
		btnNewButton.setBounds(255, 217, 179, 23);
		btnNewButton.addActionListener(new ActionListener (){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//simulationPhase1();
				try {
					simulationVersion2();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}});
		
		frame.getContentPane().add(btnNewButton);
		JCheckBox chckbxTransmissionRange = new JCheckBox("Transmission Range ");
		chckbxTransmissionRange.setBounds(17, 36, 146, 23);
		frame.getContentPane().add(chckbxTransmissionRange);
		JCheckBox chckbxNbNode = new JCheckBox("Nb node");
		chckbxNbNode.setBounds(17, 74, 97, 23);
		frame.getContentPane().add(chckbxNbNode);
		JCheckBox chckbxZoneDeCouvertoure = new JCheckBox("Zone de couvertoure ");
		chckbxZoneDeCouvertoure.setBounds(17, 114, 157, 23);
		frame.getContentPane().add(chckbxZoneDeCouvertoure);
		ActionListener actionListenerTR = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abstractButton = (AbstractButton) actionEvent
						.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				TR=selected;
			}
		};
		chckbxTransmissionRange.addActionListener(actionListenerTR);
		ActionListener actionListenerZI = new ActionListener() {
			public void actionPerformed(ActionEvent actionEvent) {
				AbstractButton abstractButton = (AbstractButton) actionEvent
						.getSource();
				boolean selected = abstractButton.getModel().isSelected();
				ZI=selected;
			}
		};
		chckbxZoneDeCouvertoure.addActionListener(actionListenerZI);
	}
	
	static void simulationVersion2() throws FileNotFoundException
	{
		int x = 0, y = 0;
		int min = 0, max = 20;
		Random rand = new Random();
		PrintStream fileStream = null;
		PrintStream fileStream2 = null;
		int ds=0;
		try {
			fileStream = new PrintStream(new File("LatexGraphe.txt"));
			fileStream.println("\\begin{tikzpicture}");
			fileStream.println("\\pgfplotsset{every axis legend/.append style={at={(0.5,1.03)},anchor=south}}");
			fileStream
					.println("\\begin{axis}[ xlabel={Degre Moyenne}, ylabel={CDS Size}]");
			fileStream.println("\\addplot[mark=none,blue,ultra thick] coordinates {");
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int d=0;
		for(d=0;d<2000;d=d+50) // 0 jusqua 1000
		{
			
		// creer 50 instamce pour chaque valeur	
		for(int k=0;k<50;k++){
		try {
			fileStream2 = new PrintStream(new File("data/file"+k+".txt"));
			fileStream2.println("Point");
			for (int i = 0; i < d; i++) {
				int randomNumX = rand.nextInt((1000 - 0) + 1) + 0;
				int randomNumY = rand.nextInt((1000 - 0) + 1) + 0;
				rand = new Random();
				min = randomNumX;
				max = randomNumY;
				fileStream2.println(min + " " +max + " " + 100);
				Node nn = new Node(0, min,max, 100, "nodes");
				
			}
			fileStream2.println("ZoneInt");
			for (int i = 0; i < 5; i++) {
				int randomNumX = rand.nextInt((1000 - 0) + 1) + 0;
				int randomNumY = rand.nextInt((1000 - 0) + 1) + 0;
				rand = new Random();
				min = randomNumX;
				max = randomNumY;
				fileStream2.println(min + " " + (max) + " " + 300);
				 Node nn = new Node(i, min, (max), 300,"PointInt");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		}
		boolean ok=true;
		Serveur2 s=new Serveur2();
		
		int valeurMoyenn=0;
		double moyenne=0;
		double degre=0;
		double degreMoyenne=0;
		for(int val=0;val<50;val++)
		{
			Serveur2.clear();
			s=new Serveur2();
		//	System.out.println("Read File : "+"data/file"+val+".txt");
			s.nodes = s.readData("data/file"+val+".txt");
		// read data from txt file
			s.calculMatriceDist(); // matrice de distance
			s.addNeighbour(); // hashM
			s.calculMatriceScore(); // matrice de score
			s.CreateComp();
			Serveur2.numberC = 0;
			UnitDisk.v4=true;
			UnitDisk.v2=true;
			//UnitDisk.v3=true;
			s.mis = s.calculeMIS();
			s.phase2();
			UnitDisk.compp2 = s.phase3();
			s.phase3_b(UnitDisk.compp2);
			s.phase4();
			s.getBlackCompInCompConnx();
			s.phase4_Version2();				
			s.miniServeur();
			if (s.verifier()) {	
				ok = true;
				int hg=0;
				for(int j=0;j<s.col.size();j++)
				{
					if(s.col.get(j).equals("black"))
					{
						hg++;
					}
				}
				valeurMoyenn=valeurMoyenn+hg;
				degre=degre+(double)s.averageDegre(s);
				
			}
			
			
		}
		degreMoyenne=degre/50;
		moyenne=valeurMoyenn/50;
		fileStream.println("("+degreMoyenne+","+moyenne+")");	
		//simulation
		System.out.println("Simulation : NB Node  "+(d));
		ds=ds+50;
		}
		fileStream.println("}; ");
		fileStream.println("\\legend{$d=initial$} \\end{axis} \\end{tikzpicture}");
		System.out.println("Finish");
	}
	static void simulationVReel()
	{
		PrintStream fileStream = null;
		ArrayList<Integer> data=new ArrayList<Integer>();
		ArrayList<Integer> data2=new ArrayList<Integer>();
		ArrayList<Integer> data3=new ArrayList<Integer>();
		int initial=0,gluton=0,modifier=0;
		try {
			fileStream = new PrintStream(new File("LatexGraphe.txt"));
			fileStream.println("\\begin{tikzpicture}");
			fileStream.println("\\pgfplotsset{every axis legend/.append style={at={(0.5,1.03)},anchor=south}}");
			fileStream
					.println("\\begin{axis}[ xlabel={NB Node In ZI}, ylabel={CDS Size}]");
			fileStream.println("\\addplot[mark=none,blue,ultra thick] coordinates {");
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for(int fd=0;fd<=50;fd=fd+10){
			Serveur2 s=new Serveur2();
			System.out.println("Simulation -------- >  "+fd);
			
		for(int re=0;re<50;re++){
		boolean ok=false;
		s=new Serveur2();
		Serveur2.clear();
		s.clear();
		Serveur2.numberC = 0;
		s.nodes =s.readDataVReel("data_2/test noisy.txt",fd,10,150); // nombre des points dans les zI, Nombre des ZI , Nombre Node
		s.calculMatriceDist(); // matrice de distance
		s.addNeighbour(); // hashM
		s.calculMatriceScore(); // matrice de score
		s.CreateComp();
		Serveur2.numberC = 0;
		UnitDisk.v4=false;
		UnitDisk.v2=true;
		UnitDisk.v3=true;
		s.mis = s.calculeMIS();
		
		s.phase2();
		UnitDisk.compp2 = s.phase3();
		
		s.phase3_b(UnitDisk.compp2);
		s.phase4();
		
		s.getBlackCompInCompConnx();
		s.phase4_Version2();	
		
		//s.miniServeur();
		if (s.verifier()) {	
			ok = true;
			int hg=0;
			for(int j=0;j<s.col.size();j++)
			{
				if(s.col.get(j).equals("black"))
				{
					hg++;
				}
			}
			initial=initial+hg;
			
		}
		}
		fileStream.println("("+(fd)+","+(initial/50)+")");	
		initial=0;
		}
		System.out.println("Finish");
		fileStream.println("}; ");
		fileStream.println("\\legend{$d=initial$} \\end{axis} \\end{tikzpicture}");

	}
	static void save_Exele(ArrayList<Integer> data,ArrayList<Integer> data2,ArrayList<Integer> data3) {
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Data");

		// This data needs to be written (Object[])
		Map<String, Object[]> donne = new TreeMap<String, Object[]>();
		donne.put("1", new Object[] { "ID", "Val_V1" });

		ArrayList<Integer> ok = data;
		ArrayList<Integer> ok2 = data2;
		ArrayList<Integer> ok3 = data3;
		for (int j = 0; j < ok.size(); j++) {
			donne.put("" + j,
					new Object[] { j, ok.get(j), ok2.get(j), ok3.get(j) });
		}

		// Iterate over data and write to sheet
		Set<String> keyset = donne.keySet();
		int rownum = 0;
		for (String key : keyset) {
			XSSFRow row = sheet.createRow(rownum++);
			Object[] objArr = donne.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				XSSFCell cell = row.createCell(cellnum++);
				if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Integer)
					cell.setCellValue((Integer) obj);
			}
		}
		try {
			// Write the workbook in file system
			FileOutputStream out = new FileOutputStream(new File(
					"howtodoinjava_demo.xlsx"));
			workbook.write(out);
			out.close();
			System.out
					.println("howtodoinjava_demo.xlsx written successfully on disk.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
