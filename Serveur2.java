import java.awt.BasicStroke;
import java.awt.Color;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.corba.se.impl.encoding.OSFCodeSetRegistry.Entry;

public class Serveur2 {

	/**
	 * @param args
	 */

	public Serveur2(){
		
	}
	static ArrayList<Integer> xxx = new ArrayList<Integer>();
	static ArrayList<Integer> yyy = new ArrayList<Integer>();
	static int numberC = 0, nbtotal = 0;
	static ArrayList<Node> zoneInt = new ArrayList<Node>();
	static HashMap<Integer, ArrayList<Integer>> HashM = new HashMap<Integer, ArrayList<Integer>>();
	static HashMap<Integer, ArrayList<Integer>> HashMSupprimer = new HashMap<Integer, ArrayList<Integer>>();
	static HashMap<Integer, ArrayList<Double>> distMatrice = new HashMap<Integer, ArrayList<Double>>();
	static HashMap<Integer, ArrayList<Double>> ScoretMatrice = new HashMap<Integer, ArrayList<Double>>();
	static ArrayList<Node> nodes = new ArrayList<Node>();
	static ArrayList<Node> nodesSupprimer = new ArrayList<Node>();
	static HashMap<Integer, Node> nodesV2M = new HashMap<Integer, Node>();
	static HashMap<Integer, ArrayList<Integer>> Comp = new HashMap<Integer, ArrayList<Integer>>();
	static HashMap<Integer, Integer> Comp2 = new HashMap<Integer, Integer>();
	static ArrayList<Integer> mis = new ArrayList<Integer>();
	static HashMap<Integer, String> col = new HashMap<Integer, String>();
	static HashMap<Integer, ArrayList<Integer>> compN = new HashMap<Integer, ArrayList<Integer>>();
	static HashMap<Integer, ArrayList<Integer>> Blackcomp = new HashMap<Integer, ArrayList<Integer>>();
	static HashMap<Integer, Integer> degWhite = new HashMap<Integer, Integer>();
	static HashMap<Integer, Integer> ZonIntPoint = new HashMap<Integer, Integer>();
	static boolean finish = false;
	static boolean phase5 = false;
	static HashMap<Integer, Integer> backB = new HashMap<Integer, Integer>();
	static HashMap<Integer, ArrayList<Integer>> data = new HashMap<Integer, ArrayList<Integer>>();

	static void clear() {
		numberC = 0;
		nbtotal = 0;
		zoneInt.clear();
		HashM.clear();
		distMatrice.clear();
		ScoretMatrice.clear();
		nodes.clear();
		Comp.clear();
		Comp2.clear();
		mis.clear();
		compN.clear();
		col.clear();
		finish = false;
	}

	static ArrayList<Node> readData() {
		BufferedReader br;
		int i = 0;

		ArrayList<Node> n = new ArrayList<Node>();
		ArrayList<Integer> s = new ArrayList<Integer>();
		try {
			br = new BufferedReader(new FileReader("file.txt"));
			try {
				String x;

				while ((x = br.readLine()) != null && !x.equals("ZoneInt")) {

					if (x.equals("Point"))
						x = br.readLine();
					if(x!=null && !x.equals("ZoneInt")){
					String[] a = x.split(" ");
					Node nn = new Node(i, Integer.parseInt(a[0]),
							Integer.parseInt(a[1]), Integer.parseInt(a[2]),
							"nodes");
			
					n.add(nn);
					HashM.put(i, s);
					s = new ArrayList<Integer>();
					i++;
					nbtotal++;}
				}
				i = 0;
				while ((x = br.readLine()) != null) {
					String[] a = x.split(" ");
					Node nn = new Node(i, Integer.parseInt(a[0]),
							Integer.parseInt(a[1]), Integer.parseInt(a[2]),
							"PointInt");
					zoneInt.add(nn);
					i++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return n;
	}

	static ArrayList<Node> readDataVReel(String name,int nbz,int nbZoneInt,int nbNode) {
		BufferedReader br;
		int i = 0;

		ArrayList<Node> n = new ArrayList<Node>();
		ArrayList<Node> nodeFinal = new ArrayList<Node>();
		ArrayList<Integer> s = new ArrayList<Integer>();
		try {
			br = new BufferedReader(new FileReader(name));
			try {
				String x;

				while ((x = br.readLine()) != null && !x.equals("routes")) {

					if (x.equals("zonesint"))
						x = br.readLine();
					if(x!=null && !x.equals("routes")){
					String[] a = x.split(" ");
					Node nn = new Node(i, Integer.parseInt(a[1]),
							Integer.parseInt(a[2]), 150,
							"PointInt");
					nn.setIdMap(Long.parseLong(a[0]));
					n.add(nn);
					zoneInt.add(nn);
					i++;
					nn = new Node(i, Integer.parseInt(a[1]),
							Integer.parseInt(a[2]), 50,
							"nodes");
					nn.setIdMap(Long.parseLong(a[0]));
					s = new ArrayList<Integer>();
					HashM.put(i, s);
					nbtotal++;
					nodeFinal.add(nn);
					i++;
					}
				}
				double min = 0;
				int minimum = 0;
				//choisir 10 zone 
				double max = 20;
				Random rand = new Random();
				i=0;

				
				
				while ((x = br.readLine()) != null) {
					String[] a = x.split(" ");
					Node nn = new Node(i, Integer.parseInt(a[1]),
							Integer.parseInt(a[2]), 50,
							"nodes");
					nn.setIdMap(Long.parseLong(a[0]));
					s = new ArrayList<Integer>();
					HashM.put(i, s);
					i++;
					nbtotal++;
					nodeFinal.add(nn);
				
					
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return nodeFinal;
	}
	static void readDataZone() {
		BufferedReader br;
		int i = 0;
		String x;
		try {
			br = new BufferedReader(new FileReader(
					"points d'interet générés.txt"));
			x = br.readLine();
			while ((x = br.readLine()) != null) {
				String[] a = x.split(" ");
				int xx = Integer.parseInt(a[1]);
				int yy = Integer.parseInt(a[2]);
				if (xx < 740 && yy < 640) {
					Node nn = new Node(i, Integer.parseInt(a[1]),
							Integer.parseInt(a[2]), 120, "PointInt");
					nn.setIdMap(Integer.parseInt(a[0]));
					zoneInt.add(nn);
					i++;
				}
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static ArrayList<Node> readData(String non) {
		BufferedReader br;
		int i = 0;

		ArrayList<Node> n = new ArrayList<Node>();
		ArrayList<Integer> s = new ArrayList<Integer>();
		try {
			br = new BufferedReader(new FileReader(non));
			try {
				String x;

				while ((x = br.readLine()) != null && !x.equals("ZoneInt")) {

					if (x.equals("Point"))
						x = br.readLine();
					if(x!=null && !x.equals("ZoneInt")){
					String[] a = x.split(" ");
					Node nn = new Node(i, Integer.parseInt(a[0]),
							Integer.parseInt(a[1]), Integer.parseInt(a[2]),
							"nodes");
					n.add(nn);
					HashM.put(i, s);
					s = new ArrayList<Integer>();
					i++;
					nbtotal++;}
				}
				i = 0;
				while ((x = br.readLine()) != null) {
					String[] a = x.split(" ");
					Node nn = new Node(i, Integer.parseInt(a[0]),
							Integer.parseInt(a[1]), Integer.parseInt(a[2]),
							"PointInt");
					zoneInt.add(nn);
					i++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return n;
	}

	static ArrayList<Node> readData2() {

		BufferedReader br;
		int i = 0;
		ArrayList<Node> n = new ArrayList<Node>();
		ArrayList<Integer> s = new ArrayList<Integer>();
		try {
			br = new BufferedReader(new FileReader("file.txt"));
			try {
				String x;

				while ((x = br.readLine()) != null && !x.equals("ZoneInt")) {

					if (x.equals("Point"))
						x = br.readLine();
					String[] a = x.split(" ");
					Node nn = new Node(i, Integer.parseInt(a[0]),
							Integer.parseInt(a[1]), Integer.parseInt(a[2]),
							"nodes");
					n.add(nn);
					HashM.put(i, s);
					s = new ArrayList<Integer>();
					i++;
					nbtotal++;
				}
				i = 0;
				while ((x = br.readLine()) != null) {
					String[] a = x.split(" ");
					Node nn = new Node(i, Integer.parseInt(a[0]),
							Integer.parseInt(a[1]), Integer.parseInt(a[2]),
							"PointInt");
					zoneInt.add(nn);
					i++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		}

		try {
			br = new BufferedReader(new FileReader("points d'interet.txt"));
			try {
				String x;

				while ((x = br.readLine()) != null && !x.equals("zoneInt")) {

					if (x.equals("Point"))
						x = br.readLine();
					String[] a = x.split(" ");
					Node nn = new Node(i, Integer.parseInt(a[0]),
							Integer.parseInt(a[1]), Integer.parseInt(a[2]),
							"nodes");
					n.add(nn);
					HashM.put(i, s);
					s = new ArrayList<Integer>();
					i++;
					nbtotal++;
				}
				i = 0;
				while ((x = br.readLine()) != null) {
					String[] a = x.split(" ");
					int xt = (int) (Double.parseDouble(a[1]));
					int yt = (int) (Double.parseDouble(a[2]));
					Node nn = new Node(i, xt, yt, 120, "PointInt");
					zoneInt.add(nn);
					i++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println(e);
			e.printStackTrace();
		}
		return n;
	}

	static void calculMatriceDist() {

		for (int i = 0; i < nodes.size(); i++) {
			ArrayList<Double> a = new ArrayList<Double>();
			for (int j = 0; j < nodes.size(); j++) {
				if (i != j) {
					a.add(calculDist(nodes.get(i), nodes.get(j)));
				}
				if (i == j)
					a.add(0.00);
			}
			distMatrice.put(i, a);
		}
	}

	static void calculMatriceScore() {

		for (int i = 0; i < nodes.size(); i++)
			nodes.get(i).setScore(0);
		for (int i = 0; i < nodes.size(); i++) {
			for (int j = 0; j < zoneInt.size(); j++) {
				double d = calculDist(nodes.get(i), zoneInt.get(j));
				if (d < zoneInt.get(j).getR()) {
					double s = nodes.get(i).getScore();
					s = s + (zoneInt.get(j).getR() - d);
					nodes.get(i).setScore(s);
					nodes.get(i).getInt().add(zoneInt.get(j).getId());
					ZonIntPoint.put(i, zoneInt.get(j).getId());
				}

			}

		}
	}

	static double calculDist(Node a, Node b) {
		double dis = Math.sqrt(Math.pow((a.getPtX() - b.getPtX()), 2)
				+ Math.pow((a.getPtY() - b.getPtY()), 2));
		return dis;
	}

	static void printM() {
		for (int i = 0; i < distMatrice.size(); i++) {
			System.out.print("Distance de " + i + " a : ");
			for (int j = 0; j < distMatrice.get(i).size(); j++) {
				System.out.print(" " + j + " = " + distMatrice.get(i).get(j));
			}
			System.out.println("");
		}
	}

	static void addNeighbour() {
		for (int i = 0; i < distMatrice.size(); i++) {
			for (int j = 0; j < distMatrice.get(i).size(); j++) {
				if (i != j) {
					if (distMatrice.get(i).get(j) < nodes.get(i).getR())// i et
																		// j
																		// sont
																		// connecter
					{
						ArrayList<Integer> k;
						if (HashM.get(i) != null)
							k = HashM.get(i);
						else
							k = new ArrayList<Integer>();
						if (!k.contains(j)) {
							k.add(j);
							HashM.put(i, k);

						}

					}
				}
			}
		}
		if (UnitDisk.v2M) {
			for (int i = 0; i < nodes.size(); i++) {
				// ArrayList<Integer> fd=new ArrayList<Integer>();
				// fd=HashM.get(i);

			}
		}
	}

	static int app(int s) {
		return 0;
	}

	static boolean existe(ArrayList<Integer> a, ArrayList<Integer> b) {

		if (!a.isEmpty() && !b.isEmpty() && a.size() > b.size()
				&& a.containsAll(b))
			return true;
		else
			return false;
	}

	static void CreateComp() {

		int c = 0;
		int wq = 0;

		for (int i = 0; i < HashM.size(); i++) {
			int u = 0;
			ArrayList<Integer> tr = new ArrayList<Integer>();

			boolean l = false;
			for (int o = 0; o < HashM.get(i).size(); o++) {
				if (Comp2.get(HashM.get(i).get(o)) != null) {
					wq = Comp2.get(HashM.get(i).get(o));
					l = true;

					
				}
			}
			if (!l) {
				wq = c++;
			}
			if (Comp2.get(i) == null) {
				Comp2.put(i, wq);

			} else
				tr.add(Comp2.get(i));

			for (int j = 0; j < HashM.get(i).size(); j++) {

				if (Comp2.get(HashM.get(i).get(j)) != null) {
					u = Comp2.get(HashM.get(i).get(j));
					if (!tr.contains(u))
						tr.add(u);
					wq = u;
				} else
					Comp2.put(HashM.get(i).get(j), wq);

			}

			for (int hg = 0; hg < Comp2.size() && tr.size() > 0; hg++) {
				if (tr.contains(Comp2.get(hg))) {
					Comp2.put(hg, tr.get(0));// ????
				}
			}

		}


		for (int i = 0; i < Comp2.size(); i++) {
			int k = Comp2.get(i);
			if (Comp.get(k) != null) {
				ArrayList<Integer> fd = new ArrayList<Integer>();
				fd = Comp.get(k);
				if (!fd.contains(i)) {
					fd.add(i);
				}
				Comp.put(k, fd);
			} else {
				ArrayList<Integer> fd = new ArrayList<Integer>();
				fd.add(i);
				Comp.put(k, fd);
			}
		}

	}
	static void setNeigbhour(){
		
	}
	static void CreateCompMini(HashMap<Integer, ArrayList<Integer>> HashM,
			HashMap<Integer, Integer> Comp2,
			HashMap<Integer, ArrayList<Integer>> Comp) {

		int c = 0;
		int wq = 0;
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entry : HashM
				.entrySet()) // Pour chaque composant
		{
			int i = entry.getKey();

			int u = 0;
			ArrayList<Integer> tr = new ArrayList<Integer>();

			boolean l = false;
			for (int o = 0; o < HashM.get(i).size(); o++) {
				if (Comp2.get(HashM.get(i).get(o)) != null) {
					wq = Comp2.get(HashM.get(i).get(o));
					l = true;

					// tre.add(wq);
				}
			}
			if (!l) {
				wq = c++;
			}
			if (Comp2.get(i) == null) {
				Comp2.put(i, wq);

			} else
				tr.add(Comp2.get(i));

			for (int j = 0; j < HashM.get(i).size(); j++) {

				if (Comp2.get(HashM.get(i).get(j)) != null) {
					u = Comp2.get(HashM.get(i).get(j));
					if (!tr.contains(u))
						tr.add(u);
					wq = u;
				} else
					Comp2.put(HashM.get(i).get(j), wq);

			}

			for (int hg = 0; hg < Comp2.size() && tr.size() > 0; hg++) {
				if (tr.contains(Comp2.get(hg))) {
					Comp2.put(hg, tr.get(0));// ????
				}
			}

		}
		for (java.util.Map.Entry<Integer, Integer> entry : Comp2.entrySet()) // Pour
																				// chaque
																				// composant
		{
			int i = entry.getKey();
			int k = entry.getValue();
			ArrayList<Integer> fr = HashM.get(i);
			for (int v : fr) {
				if (Comp2.get(v) != k) {
					int d = Comp2.get(v);
					for (java.util.Map.Entry<Integer, Integer> entryy : Comp2
							.entrySet()) // Pour chaque composant
					{
						int ii = entryy.getKey();
						int kk = entryy.getValue();
						if (kk == d)
							Comp2.put(ii, k);
					}
				}
			}

		}
		for (java.util.Map.Entry<Integer, Integer> entry : Comp2.entrySet()) // Pour
																				// chaque
																				// composant
		{
			int i = entry.getKey();
			int k = entry.getValue();
			if (Comp.get(k) != null) {
				ArrayList<Integer> fd = new ArrayList<Integer>();
				fd = Comp.get(k);
				if (!fd.contains(i)) {
					fd.add(i);
				}
				Comp.put(k, fd);
			} else {
				ArrayList<Integer> fd = new ArrayList<Integer>();
				fd.add(i);
				Comp.put(k, fd);
			}
		}

	}

	static void gerate() {
		int x = 0, y = 0;
		int min = 0, max = 20;
		Random rand = new Random();
		for (int i = 0; i < 105; i++) {

			int randomNumX = rand.nextInt((740 - 0) + 1) + 0;
			int randomNumY = rand.nextInt((640 - 0) + 1) + 0;
			rand = new Random();
			min = randomNumX;
			max = randomNumY;

			xxx.add(randomNumX);
			yyy.add(randomNumY);
		}
	}

	static void generate() {
		// gerate();
		int x = 0, y = 0;
		int min = 0, max = 20;

		Random rand = new Random();
		PrintStream fileStream;
	

		try {
			fileStream = new PrintStream(new File("file.txt"));
			fileStream.println("Point");

			for (int i = 0; i < 100; i++) {
				// simulation
				int randomNumX = rand.nextInt((740 - 0) + 1) + 0;
				int randomNumY = rand.nextInt((640 - 0) + 1) + 0;
				rand = new Random();
				min = randomNumX;
				max = randomNumY;
		
				fileStream.println(randomNumX + " " + randomNumY + " " + 80);
				Node nn = new Node(0, randomNumX, randomNumY, 80, "nodes");
			}
			fileStream.println("ZoneInt");

			for (int i = 0; i < 5; i++) {
				// simulation
				int randomNumX = rand.nextInt((740 - 0) + 1) + 0;
				int randomNumY = rand.nextInt((640 - 0) + 1) + 0;
				rand = new Random();
				min = randomNumX;
				max = randomNumY;
	
				fileStream.println(randomNumX + " " + randomNumY + " " + 120);
				Node nn = new Node(i, randomNumX, randomNumY, 120, "PointInt");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	static void test(int rn, int rne, int nb, int nbint) {
		CreateGraphe c = new CreateGraphe();
	if (!UnitDisk.AddMan) {
			try {
				c.createGraphe();
				c.test(rn, rne, nb, nbint);// random valeur des nodes
			} catch (IOException e) {

				e.printStackTrace();
			}
			nodes = readData();
			// readDataZone();
		}// read data from txt file
		calculMatriceScore();// matrice de score
		calculMatriceDist();
		// matrice de distance
		addNeighbour();// hashM
		
		CreateComp();// les composants connexes
	}

	public static void main(String[] args) {
		generate();

	}

	static void save_Exele(ArrayList<Integer> data,ArrayList<Integer> data2,ArrayList<Integer> data3) {
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create a blank sheet
		XSSFSheet sheet = workbook.createSheet("Employee Data");

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

	
	static float averageDegre(Serveur2 s)
	{
		int i=0;
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entry : s.HashM
				.entrySet()) // Pour chaque composant
		{
			i=i+entry.getValue().size();
		}
		return (float)i/s.HashM.size();
		
	}
	static ArrayList<Integer> calculeMIS() {
		boolean found = false;
		HashMap<Integer, String> node = new HashMap<Integer, String>();
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entry : HashM
				.entrySet()) // Pour chaque composant
		{
			node.put(entry.getKey(), "white");
		}


		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entry : Comp
				.entrySet()) // Pour chaque composant
		{

			ArrayList<Integer> compo = entry.getValue();

			ArrayList<Integer> yellow = new ArrayList<Integer>();
			int id = compo.get(0);// minimum
			node.put(id, "black");// colorie black
			for (int k = 0; k < HashM.get(id).size(); k++) {

				if (!node.get(HashM.get(id).get(k)).equals("black"))
					node.put(HashM.get(id).get(k), "gray");// color one hope
															// gray
			}
			for (int s = 0; s < HashM.get(id).size(); s++) {
				for (int u = 0; u < HashM.get(HashM.get(id).get(s)).size(); u++) {
					String st = node
							.get(HashM.get(HashM.get(id).get(s)).get(u));
					if (st.equals("white")) {
						node.put(HashM.get(HashM.get(id).get(s)).get(u),
								"yellow");
						if (!yellow.contains(HashM.get(HashM.get(id).get(s))
								.get(u)))
							yellow.add(HashM.get(HashM.get(id).get(s)).get(u));
					}
				}
			}
			// pour tout les yellow

			while (yellow.size() > 0) {

				id = yellow.get(0);

				found = false;
				for (int ji = 0; ji < HashM.get(id).size(); ji++)
					if (node.get(HashM.get(id).get(ji)).equals("black"))
						found = true;
				if (!found)
					node.put(id, "black");
				yellow.remove(0);
				for (int k = 0; k < HashM.get(id).size(); k++) {
					if (!node.get(HashM.get(id).get(k)).equals("black"))
						node.put(HashM.get(id).get(k), "gray");// color one hope
																// gray

				}
				for (int s = 0; s < HashM.get(id).size(); s++) {
					for (int u = 0; u < HashM.get(HashM.get(id).get(s)).size(); u++) {
						String st = node.get(HashM.get(HashM.get(id).get(s))
								.get(u));
						if (st.equals("white")) {
							node.put(HashM.get(HashM.get(id).get(s)).get(u),
									"yellow");
							if (!yellow.contains(HashM
									.get(HashM.get(id).get(s)).get(u)))
								yellow.add(HashM.get(HashM.get(id).get(s)).get(
										u));
						}
					}
				}

			}

		}

		ArrayList<Integer> d = new ArrayList<Integer>();
		for (Node n : nodes) {
			if (node.get(n.getId()).equals("black"))
				d.add(n.getId());
		}
	

		return d;
	}

	static HashMap<Integer, Integer> CalculWeight(ArrayList<Integer> compo) {
		HashMap<Integer, Integer> weight = new HashMap<Integer, Integer>();
		if (UnitDisk.v2 || UnitDisk.v3) {
			for (int j = 0; j < compo.size(); j++) {

				weight.put(compo.get(j), (-1 + (int) nodes.get(j).getScore()));

			}
		} else
			for (int j = 0; j < compo.size(); j++) {
				weight.put(compo.get(j), (-1));
			}

		ArrayList<Integer> mis = Serveur2.mis;
		for (int i = 0; i < compo.size(); i++) {
			int k = compo.get(i);
			ArrayList<Integer> s = HashM.get(k);
			for (int j = 0; j < s.size(); j++)
				if (mis.contains(s.get(j))) {
					int y = weight.get(compo.get(i));
					y++;
					weight.put(compo.get(i), y);
				}

		}
		return weight;

	}

	static HashMap<Integer, Integer> calculDegre() {
		HashMap<Integer, Integer> deg = new HashMap<Integer, Integer>();
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entry : HashM
				.entrySet()) // Pour
		// chaque
		// composant
		{
			Integer key = entry.getKey();
			ArrayList<Integer> val = entry.getValue();
			deg.put(key, val.size());
		}
	
		return deg;

	}

	static HashMap<Integer, Integer> calculDegreMini(
			HashMap<Integer, ArrayList<Integer>> HashM) {
		HashMap<Integer, Integer> deg = new HashMap<Integer, Integer>();
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entry : HashM
				.entrySet()) // Pour
		// chaque
		// composant
		{
			Integer key = entry.getKey();
			ArrayList<Integer> val = entry.getValue();
			deg.put(key, val.size());
		}

		return deg;

	}

	static HashMap<Integer, String> setRed(ArrayList<Integer> compo) {
		HashMap<Integer, String> color = new HashMap<Integer, String>();
		for (int i = 0; i < compo.size(); i++)
			if (mis.contains(compo.get(i)))
				color.put(compo.get(i), "red");
			else
				color.put(compo.get(i), "white");
		return color;

	}

	static ArrayList<Integer> getMaxWeight(HashMap<Integer, Integer> weight,
			ArrayList<Integer> compo) {

		ArrayList<Integer> k = new ArrayList<Integer>();
		int max = -100;
		int keys = 0;
		for (java.util.Map.Entry<Integer, Integer> entry : weight.entrySet()) // Pour
																				// chaque
																				// element dans weight
		{
			Integer key = entry.getKey();
			Integer val = entry.getValue();
			if (compo.contains(key))
				if (val > max) {
					max = val;
					keys = key;
				}
		}
		for (java.util.Map.Entry<Integer, Integer> entry : weight.entrySet()) // Pour
																				// chaque
																				// element dans weight
		{
			Integer key = entry.getKey();
			Integer val = entry.getValue();
			if (compo.contains(key))
				if (val == max)
					k.add(key);
		}

		return k;

	}

	static ArrayList<Integer> calculDeg(HashMap<Integer, Integer> deg,
			ArrayList<Integer> k) {

		ArrayList<Integer> bb = new ArrayList<Integer>();
		int max = -100;
		int keys = 0;

		for (java.util.Map.Entry<Integer, Integer> entry : deg.entrySet()) // Pour
																			// chaque
																			// element dans deg
		{
			Integer key = entry.getKey();
			Integer val = entry.getValue();

			if (k.contains(key)) {
				if (val > max)
					max = val;
			}

		}

		for (java.util.Map.Entry<Integer, Integer> entry : deg.entrySet()) // Pour
																			// chaque
																			// element dans deg
		{

			Integer key = entry.getKey();
			Integer val = entry.getValue();
			if (k.contains(key))
				if (val == max) {
					bb.add(key);
				}
		}

		return bb;

	}

	static void phase2() { 
		Comp = new HashMap<Integer, ArrayList<Integer>>();
		CreateComp();
		HashMap<Integer, Integer> deg = new HashMap<Integer, Integer>();
		deg = calculDegre();
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entry : Comp
				.entrySet()) // Pour chaque composant
		{

			HashMap<Integer, Integer> compRed = new HashMap<Integer, Integer>();
			ArrayList<Integer> compo = entry.getValue();
			HashMap<Integer, String> color = new HashMap<Integer, String>();
			HashMap<Integer, Integer> weight = new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> compNoire = new HashMap<Integer, Integer>();
			compRed = calculRedPoint(compo);
			weight = CalculWeight(compo);
			color = setRed(compo);
			int s = 0;
			for (int i = 0; i < weight.size(); i++) {
				if (weight.get(compo.get(i)) > -1)
					s++;
			}
			while (s > 0) { // tanque il ya un weight non-negative
				int node;
				ArrayList<Integer> fWeight = new ArrayList<Integer>();
				ArrayList<Integer> fdegre = new ArrayList<Integer>();
				fWeight = getMaxWeight(weight, compo);
				if (fWeight.size() > 1) {
					fdegre = calculDeg(deg, fWeight);
					node = fdegre.get(fdegre.size() - 1);
				} else
					node = fWeight.get(fWeight.size() - 1);
				if (color.get(node) != "black") {
					color.put(node, "black");
				}

				for (int i = 0; i < HashM.get(node).size(); i++) {
					String colors = color.get(HashM.get(node).get(i));
					if (!colors.equals("black")) {
						if (!colors.equals("gray")) {
							color.put(HashM.get(node).get(i), "gray");
						}
						if (colors.equals("red")) {
							compRed.remove(HashM.get(node).get(i));
						}
					}
				}
				if (!compNoire.containsKey(node)) {
					compNoire.put(node, node);
					if (UnitDisk.v3) {
						ArrayList<Integer> fr = HashM.get(node);
						for (int u = 0; u < fr.size(); u++) {
							if (nodes.get(fr.get(u)).getInt().size() != 0)
								if (nodes.get(fr.get(u)).getScore() < nodes
										.get(node).getScore()) {
									nodes.get(fr.get(u)).setScore(0);
									// System.out.println("score a 0 du node "+fr.get(u));
								}
						}
					}
				}
				for (java.util.Map.Entry<Integer, Integer> entryy : compNoire
						.entrySet()) // Pour chaque composant noire
				{
					ArrayList<Integer> allF = new ArrayList<Integer>();
					Integer key = entryy.getKey();
					ArrayList<Integer> g = HashM.get(node);
					for (int jf = 0; jf < g.size(); jf++) {
						if (compNoire.containsKey(g.get(jf))) {
							int valeur = compNoire.get(g.get(jf));
							for (java.util.Map.Entry<Integer, Integer> entr : compNoire
									.entrySet()) // Pour chaque composant noire
							{
								Integer ke = entr.getKey();
								Integer ve = entr.getValue();
								if (ve.equals(valeur))
									compNoire.put(ke, node);
							}
						}
					}
				}
				updateweight(compNoire, compo, compRed, weight, node);
				s = 0;
				for (int i = 0; i < weight.size(); i++) {
					if (weight.get(compo.get(i)) > 0)
						s++;
				}
				
			}
			for (java.util.Map.Entry<Integer, String> entryyy : color
					.entrySet()) // Pour chaque composant restant de couleur
									// rouge
			{
				Integer key = entryyy.getKey();
				String val = entryyy.getValue();
				if (val.equals("red")) {
					color.put(key, "black");
					for (int i = 0; i < HashM.get(key).size(); i++) {
						if (color.get(HashM.get(key).get(i)) == "white")
							color.put(HashM.get(key).get(i), "gray");
						if (color.get(HashM.get(key).get(i)) == "black") {
							int t = compNoire.get(HashM.get(key).get(i));
							compNoire.put(key, t);
						} else {
							compNoire.put(key, key);
						}
					}
					if (HashM.get(key).size() == 0)
						compNoire.put(key, key);
				}
			}
			for (java.util.Map.Entry<Integer, Integer> ent : compNoire
					.entrySet()) // Pour chaque composant noire
			{
				ArrayList<Integer> f;
				int key = ent.getKey();
				int val = ent.getValue();
				if (compN.get(val) != null) {
					f = compN.get(val);
				} else
					f = new ArrayList<Integer>();
				f.add(key);
				compN.put(val, f);
			}
			col.putAll(color);
		}
		finish = true;
	}

	static void phase2_mini(HashMap<Integer, ArrayList<Integer>> HashM,
			HashMap<Integer, Integer> Comp2,
			HashMap<Integer, ArrayList<Integer>> Comp,
			HashMap<Integer, Node> nodes,
			HashMap<Integer, ArrayList<Integer>> compN,
			HashMap<Integer, String> col, ArrayList<Integer> mis,
			ArrayList<Integer> extB) {
		Comp = new HashMap<Integer, ArrayList<Integer>>();
		CreateCompMini(HashM, Comp2, Comp);
		HashMap<Integer, Integer> deg = new HashMap<Integer, Integer>();
		deg = calculDegreMini(HashM);
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entry : Comp
				.entrySet()) // Pour chaque composant
		{

			HashMap<Integer, Integer> compRed = new HashMap<Integer, Integer>();
			ArrayList<Integer> compo = entry.getValue();
			HashMap<Integer, String> color = new HashMap<Integer, String>();
			HashMap<Integer, Integer> weight = new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> compNoire = new HashMap<Integer, Integer>();
			compRed = calculRedPointMini(compo, mis);
			weight = CalculWeightMini(compo, mis, HashM, extB);
			color = setRedMini(compo, mis);
			int s = 0;
			for (int i = 0; i < weight.size(); i++) {
				if (weight.get(compo.get(i)) > -1)
					s++;
			}
			while (s > 0) { // tanque il ya un weight non-negative
				int node;
				ArrayList<Integer> fWeight = new ArrayList<Integer>();
				ArrayList<Integer> fdegre = new ArrayList<Integer>();
				fWeight = getMaxWeightMini(weight, compo);

				if (fWeight.size() > 1) {

					fdegre = calculDegMini(deg, fWeight);

					node = fdegre.get(fdegre.size() - 1);

				} else
					node = fWeight.get(fWeight.size() - 1);

				if (color.get(node) != "black") {
					color.put(node, "black");

				}
				for (int i = 0; i < HashM.get(node).size(); i++) {

					String colors = color.get(HashM.get(node).get(i));
					if (!colors.equals("black")) {
						if (!colors.equals("gray")) {
							color.put(HashM.get(node).get(i), "gray");

						}
						if (colors.equals("red")) {
							compRed.remove(HashM.get(node).get(i));

						}
					}

				}

				if (!compNoire.containsKey(node)) {
					compNoire.put(node, node);

				}

				for (java.util.Map.Entry<Integer, Integer> entryy : compNoire
						.entrySet()) // Pour chaque composant noire
				{

					ArrayList<Integer> allF = new ArrayList<Integer>();
					Integer key = entryy.getKey();
					ArrayList<Integer> g = HashM.get(node);
					for (int jf = 0; jf < g.size(); jf++) {

						if (compNoire.containsKey(g.get(jf))) {
							int valeur = compNoire.get(g.get(jf));

							for (java.util.Map.Entry<Integer, Integer> entr : compNoire
									.entrySet()) // Pour chaque composant noire
							{
								Integer ke = entr.getKey();
								Integer ve = entr.getValue();// error
								if (ve.equals(valeur))
									compNoire.put(ke, node);
							}

						}

					}

				}

				updateweightMini(compNoire, compo, compRed, weight, node,
						HashM, extB);
				s = 0;
				for (int i = 0; i < weight.size(); i++) {
					if (weight.get(compo.get(i)) > 0)
						s++;
				}

			}

			for (java.util.Map.Entry<Integer, String> entryyy : color
					.entrySet()) // Pour chaque composant restant de couleur
									// rouge
			{

				Integer key = entryyy.getKey();
				String val = entryyy.getValue();
				if (val.equals("red")) {

					color.put(key, "black");
					for (int i = 0; i < HashM.get(key).size(); i++) {
						if (color.get(HashM.get(key).get(i)) == "white")
							color.put(HashM.get(key).get(i), "gray");
						if (color.get(HashM.get(key).get(i)) == "black") {
							int t = compNoire.get(HashM.get(key).get(i));
							compNoire.put(key, t);

						} else {
							compNoire.put(key, key);

						}
					}
					if (HashM.get(key).size() == 0)
						compNoire.put(key, key);
				}
			}
			
			for (java.util.Map.Entry<Integer, Integer> ent : compNoire
					.entrySet()) // Pour chaque composant
			{
				ArrayList<Integer> f;
				int key = ent.getKey();
				int val = ent.getValue();
				if (compN.get(val) != null) {
					f = compN.get(val);
				} else
					f = new ArrayList<Integer>();
				f.add(key);
				compN.put(val, f);
			}
			col.putAll(color);

		}
	
	}

	private static void updateweightMini(HashMap<Integer, Integer> compNoire,
			ArrayList<Integer> compo, HashMap<Integer, Integer> compRed,
			HashMap<Integer, Integer> weight, int node,
			HashMap<Integer, ArrayList<Integer>> HashM, ArrayList<Integer> extB) {

		for (int i = 0; i < compo.size(); i++) {
			ArrayList<Integer> numberV = new ArrayList<Integer>();
			ArrayList<Integer> voisin = HashM.get(compo.get(i));
			for (int j = 0; j < voisin.size(); j++) {
				if (compNoire.containsKey(voisin.get(j))) {
					if (!numberV.contains(compNoire.get(voisin.get(j))))
						numberV.add(compNoire.get(voisin.get(j)));
				}
				if (compRed.containsKey(voisin.get(j))) {
					if (!numberV.contains(compRed.containsKey(voisin.get(j))))
						numberV.add(compRed.get(voisin.get(j)));
				}
			}
			if (compNoire.containsKey(compo.get(i))) {
				weight.put(compo.get(i), 0);
			} else if (extB.contains(compo.get(i))) {
				weight.put(compo.get(i), numberV.size() - 1 + 100);
			} else
				weight.put(compo.get(i), numberV.size() - 1);

		}

	}

	private static ArrayList<Integer> calculDegMini(
			HashMap<Integer, Integer> deg, ArrayList<Integer> k) {
		// TODO Auto-generated method stub
		ArrayList<Integer> bb = new ArrayList<Integer>();
		int max = -100;
		int keys = 0;

		for (java.util.Map.Entry<Integer, Integer> entry : deg.entrySet()) // Pour
																			// chaqu
																			// //
																			// composant
		{
			Integer key = entry.getKey();
			Integer val = entry.getValue();

			if (k.contains(key)) {
				if (val > max)
					max = val;
			}

		}

		for (java.util.Map.Entry<Integer, Integer> entry : deg.entrySet()) // Pour
																			// chaque
																			// composant
		{

			Integer key = entry.getKey();
			Integer val = entry.getValue();
			if (k.contains(key))
				if (val == max) {
					bb.add(key);
				}
		}

		return bb;
	}

	private static ArrayList<Integer> getMaxWeightMini(
			HashMap<Integer, Integer> weight, ArrayList<Integer> compo) {
		// TODO Auto-generated method stub
		ArrayList<Integer> k = new ArrayList<Integer>();
		int max = -100;
		int keys = 0;
		for (java.util.Map.Entry<Integer, Integer> entry : weight.entrySet()) // Pour
																				// chaque
		// composant
		{
			Integer key = entry.getKey();
			Integer val = entry.getValue();
			if (compo.contains(key))
				if (val > max) {
					max = val;
					keys = key;
				}
		}
		for (java.util.Map.Entry<Integer, Integer> entry : weight.entrySet()) // Pour
																				// chaque
																				// composant
		{
			Integer key = entry.getKey();
			Integer val = entry.getValue();
			if (compo.contains(key))
				if (val == max)
					k.add(key);
		}

		return k;
	}

	private static HashMap<Integer, String> setRedMini(
			ArrayList<Integer> compo, ArrayList<Integer> mis) {
		// TODO Auto-generated method stub
		HashMap<Integer, String> color = new HashMap<Integer, String>();
		for (int i = 0; i < compo.size(); i++)
			if (mis.contains(compo.get(i)))
				color.put(compo.get(i), "red");
			else
				color.put(compo.get(i), "white");
		return color;

	}

	private static HashMap<Integer, Integer> CalculWeightMini(
			ArrayList<Integer> compo, ArrayList<Integer> mis,
			HashMap<Integer, ArrayList<Integer>> HashM, ArrayList<Integer> extB) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> weight = new HashMap<Integer, Integer>();
		for (int j = 0; j < compo.size(); j++)
			weight.put(compo.get(j), (-1));

		for (int i = 0; i < compo.size(); i++) {
			int k = compo.get(i);
			ArrayList<Integer> s = HashM.get(k);
			for (int j = 0; j < s.size(); j++)
				if (mis.contains(s.get(j))) {
					int y = weight.get(compo.get(i));
					y++;
					weight.put(compo.get(i), y);
				}
			// if(extB.contains(compo.get(i)))
			// {
			// weight.put(compo.get(i), 100);
			// }

		}
		return weight;

	}

	private static HashMap<Integer, Integer> calculRedPointMini(
			ArrayList<Integer> compo, ArrayList<Integer> mis) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> cn = new HashMap<Integer, Integer>();
		int c = 0;
		for (int i = 0; i < compo.size(); i++) {
			if (mis.contains(compo.get(i)))
				cn.put(compo.get(i), compo.get(i));
		}

		return cn;

	}

	static HashMap<Integer, ArrayList<Integer>> calculWhiteCompMini(
			HashMap<Integer, String> col,
			HashMap<Integer, ArrayList<Integer>> HashM) {
		HashMap<Integer, ArrayList<Integer>> WhiteC = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> allWhite = new ArrayList<Integer>();
		HashMap<Integer, Integer> composantW = new HashMap<Integer, Integer>();
		for (java.util.Map.Entry<Integer, String> entryyy : col.entrySet()) // Pour
																			// chaque
																			// composant
																			// restant
																			// de
																			// couleur
																			// rouge
		{

			Integer key = entryyy.getKey();
			String val = entryyy.getValue();
			if (val.equals("white"))
				allWhite.add(key);
		}

		HashMap<Integer, ArrayList<Integer>> HashMWhite = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < allWhite.size(); i++) {
			ArrayList<Integer> k = new ArrayList<Integer>();
			for (int j = 0; j < HashM.get(allWhite.get(i)).size(); j++)
				if (allWhite.contains(HashM.get(allWhite.get(i)).get(j))) {
					k.add(HashM.get(allWhite.get(i)).get(j));
				}
			HashMWhite.put(allWhite.get(i), k);
		}

		int c = 0;
		int wq = 0;
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entryyy : HashMWhite
				.entrySet()) // Pour chaque composant de HashMWhite
		{

			Integer key = entryyy.getKey();
			ArrayList<Integer> val = entryyy.getValue();
			int u = 0;
			ArrayList<Integer> tr = new ArrayList<Integer>();
			boolean l = false;

			for (int o = 0; o < val.size(); o++) {
				if (composantW.get(val.get(o)) != null) {
					wq = composantW.get(val.get(o));
					l = true;

					// tre.add(wq);
				}
			}

			if (!l) {
				wq = c++;
			}
			if (composantW.get(key) == null) {
				composantW.put(key, wq);

			} else
				tr.add(composantW.get(key));

			for (int j = 0; j < val.size(); j++) {

				if (composantW.get(val.get(j)) != null) {
					u = composantW.get(val.get(j));
					if (!tr.contains(u))
						tr.add(u);
					wq = u;
				} else
					composantW.put(val.get(j), wq);

			}

			for (int hg = 0; hg < composantW.size() && tr.size() > 0; hg++) {
				if (tr.contains(composantW.get(hg))) {
					composantW.put(hg, tr.get(0));
				}
			}

		}
		for (java.util.Map.Entry<Integer, Integer> entryyy : composantW
				.entrySet()) // Pour chaque composant de composantW
		{

			Integer key = entryyy.getKey();
			Integer val = entryyy.getValue();
			if (WhiteC.get(val) != null) {
				ArrayList<Integer> fd = new ArrayList<Integer>();
				fd = WhiteC.get(val);
				if (!fd.contains(key)) {
					fd.add(key);
				}
				WhiteC.put(val, fd);
			} else {
				ArrayList<Integer> fd = new ArrayList<Integer>();
				fd.add(key);
				WhiteC.put(val, fd);
			}
		}

		return WhiteC;

	}

	static HashMap<Integer, ArrayList<Integer>> calculWhiteComp() {
		HashMap<Integer, ArrayList<Integer>> WhiteC = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> allWhite = new ArrayList<Integer>();
		HashMap<Integer, Integer> composantW = new HashMap<Integer, Integer>();
		for (int i = 0; i < col.size(); i++) {
			if (col.get(i).equals("white"))
				allWhite.add(i);
		}
		HashMap<Integer, ArrayList<Integer>> HashMWhite = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < allWhite.size(); i++) {
			ArrayList<Integer> k = new ArrayList<Integer>();
			for (int j = 0; j < HashM.get(allWhite.get(i)).size(); j++)
				if (allWhite.contains(HashM.get(allWhite.get(i)).get(j))) {
					k.add(HashM.get(allWhite.get(i)).get(j));
				}
			HashMWhite.put(allWhite.get(i), k);
		}

		int c = 0;
		int wq = 0;
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entryyy : HashMWhite
				.entrySet()) // Pour chaque composant restant de couleur rouge
		{

			Integer key = entryyy.getKey();
			ArrayList<Integer> val = entryyy.getValue();
			int u = 0;
			ArrayList<Integer> tr = new ArrayList<Integer>();
			boolean l = false;

			for (int o = 0; o < val.size(); o++) {
				if (composantW.get(val.get(o)) != null) {
					wq = composantW.get(val.get(o));
					l = true;

					// tre.add(wq);
				}
			}

			if (!l) {
				wq = c++;
			}
			if (composantW.get(key) == null) {
				composantW.put(key, wq);

			} else
				tr.add(composantW.get(key));

			for (int j = 0; j < val.size(); j++) {

				if (composantW.get(val.get(j)) != null) {
					u = composantW.get(val.get(j));
					if (!tr.contains(u))
						tr.add(u);
					wq = u;
				} else
					composantW.put(val.get(j), wq);

			}

			for (int hg = 0; hg < composantW.size() && tr.size() > 0; hg++) {
				if (tr.contains(composantW.get(hg))) {
					composantW.put(hg, tr.get(0));// ????
				}
			}

		}
		for (java.util.Map.Entry<Integer, Integer> entryyy : composantW
				.entrySet()) // Pour chaque composant restant de couleur rouge
		{

			Integer key = entryyy.getKey();
			Integer val = entryyy.getValue();
			if (WhiteC.get(val) != null) {
				ArrayList<Integer> fd = new ArrayList<Integer>();
				fd = WhiteC.get(val);
				if (!fd.contains(key)) {
					fd.add(key);
				}
				WhiteC.put(val, fd);
			} else {
				ArrayList<Integer> fd = new ArrayList<Integer>();
				fd.add(key);
				WhiteC.put(val, fd);
			}
		}

		return WhiteC;

	}

	private static void updateweight(HashMap<Integer, Integer> compNoire,
			ArrayList<Integer> compo, HashMap<Integer, Integer> compRed,
			HashMap<Integer, Integer> weight, int node) {
		// TODO Auto-generated method stub

		for (int i = 0; i < compo.size(); i++) {
			ArrayList<Integer> numberV = new ArrayList<Integer>();
			ArrayList<Integer> voisin = HashM.get(compo.get(i));
			for (int j = 0; j < voisin.size(); j++) {
				if (compNoire.containsKey(voisin.get(j))) {
					if (!numberV.contains(compNoire.get(voisin.get(j))))
						numberV.add(compNoire.get(voisin.get(j)));
				}
				if (compRed.containsKey(voisin.get(j))) {
					if (!numberV.contains(compRed.containsKey(voisin.get(j))))
						numberV.add(compRed.get(voisin.get(j)));
				}
			}
			if (UnitDisk.v2 || UnitDisk.v3) {
				if (compNoire.containsKey(compo.get(i))) {
					int uy = weight.get(compo.get(i));
					weight.put(compo.get(i), -1);
				} else
					weight.put(compo.get(i), numberV.size() - 1
							+ (int) nodes.get(compo.get(i)).getScore());
			} else
				weight.put(compo.get(i), numberV.size() - 1);
		}

	}

	private static HashMap<Integer, Integer> calculRedPoint(
			ArrayList<Integer> compo) {
		HashMap<Integer, Integer> cn = new HashMap<Integer, Integer>();
		int c = 0;
		for (int i = 0; i < compo.size(); i++) {
			if (Serveur2.mis.contains(compo.get(i)))
				cn.put(compo.get(i), compo.get(i));
		}

		return cn;
	}

	static HashMap<Integer, Integer> calculComp(ArrayList<Integer> compo) {
		HashMap<Integer, Integer> g = new HashMap<Integer, Integer>();
		for (int i = 0; i < compo.size(); i++) {

			int c = 0;
			for (int j = 0; j < HashM.get(compo.get(i)).size(); j++) {
				if (Serveur2.mis.contains(HashM.get(compo.get(i)).get(j))) {
					c++;// les nombres des composant connexe

				}
			}
			g.put(compo.get(i), c);
		}
		return g;
	}

	static HashMap<Integer, ArrayList<Integer>> phase3() {// construire un arbre couvrant a partir des noeuds whites
		HashMap<Integer, String> allWhite = new HashMap<Integer, String>();
		for (int i = 0; i < col.size(); i++) {
			if (col.get(i).equals("white"))
				allWhite.put(i, "white");
		}
		degWhite = calculDegreWhite(allWhite);

		HashMap<Integer, ArrayList<Integer>> compp = calculWhiteComp();
		HashMap<Integer, ArrayList<Integer>> compp2 = compp;
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entryyy : compp
				.entrySet()) // Pour chaque composant white
		{

			Integer key = entryyy.getKey();
			ArrayList<Integer> val = entryyy.getValue();
			HashMap<Integer, Integer> deg = calculDegreWhite(allWhite);// numbre
																		// des
																		// white
																		// voisin

			ArrayList<Integer> k = calculDeg(deg, val);

			int node = k.get(k.size() - 1);// node avec max degre et max id

			allWhite.put(node, "black");

			for (int j = 0; j < val.size(); j++) {
				if (val.get(j) != node)
					if (allWhite.get(val.get(j)) != null)
						if (allWhite.get(val.get(j)) != "black")
							if (allWhite.get(val.get(j)) != "gray") {
								allWhite.put(val.get(j), "gray");
							}
			}
			int s = 0;
			ArrayList<Integer> kf = new ArrayList<Integer>();
			for (java.util.Map.Entry<Integer, String> entry : allWhite
					.entrySet()) // Pour chaque composant de allWhite
									
			{
				Integer keyy = entry.getKey();
				String vall = entry.getValue();
				if (val.equals("white")) {
					s++;
					kf.add(keyy);
				}
			}
			while (s > 0) {
				ArrayList<Integer> st = calculDeg(deg, kf);
				int n = st.get(st.size() - 1);
				allWhite.put(n, "black");

				for (int j = 0; j < val.size(); j++) {
					if (val.get(j) != n)
						if (allWhite.get(val.get(j)) != null)
							if (allWhite.get(val.get(j)) != "black")
								if (allWhite.get(val.get(j)) != "gray")
									allWhite.put(val.get(j), "gray");
				}
				kf = new ArrayList<Integer>();
				s = 0;
				for (java.util.Map.Entry<Integer, String> entrys : allWhite
						.entrySet()) // Pour chaque composant de allWhite
										
				{
					Integer keyy = entrys.getKey();

					if (val.equals("white")) {
						s++;
						kf.add(keyy);
					}
				}

			}

		}

		for (java.util.Map.Entry<Integer, String> entrys : allWhite.entrySet()) {
			Integer key = entrys.getKey();
			String val = entrys.getValue();
			col.put(key, val);
		}

		return compp2;
	}

	static HashMap<Integer, ArrayList<Integer>> phase3mini(
			HashMap<Integer, String> col, HashMap<Integer, Integer> degWhite,
			HashMap<Integer, ArrayList<Integer>> HashM) {
		HashMap<Integer, String> allWhite = new HashMap<Integer, String>();
		for (java.util.Map.Entry<Integer, String> entryyy : col.entrySet()) // Pour
																			// chaque
																			// composant
																			// restant
																			// de
																			// couleur
																			// rouge
		{
			int i = entryyy.getKey();
			String val = entryyy.getValue();
			if (val.equals("white"))
				allWhite.put(i, "white");
		}

		degWhite = calculDegreWhiteMini(allWhite, HashM);

		HashMap<Integer, ArrayList<Integer>> compp = calculWhiteCompMini(col,
				HashM);
		HashMap<Integer, ArrayList<Integer>> compp2 = compp;
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entryyy : compp
				.entrySet()) // Pour chaque composant restant de couleur rouge
		{

			Integer key = entryyy.getKey();
			ArrayList<Integer> val = entryyy.getValue();
			HashMap<Integer, Integer> deg = calculDegreWhiteMini(allWhite,
					HashM);// numbre
			// des
			// white
			// voisin

			ArrayList<Integer> k = calculDegMini(deg, val);

			int node = k.get(k.size() - 1);// node avec max degre et max id

			allWhite.put(node, "black");

			for (int j = 0; j < val.size(); j++) {
				if (val.get(j) != node)
					if (allWhite.get(val.get(j)) != null)
						if (allWhite.get(val.get(j)) != "black")
							if (allWhite.get(val.get(j)) != "gray") {
								allWhite.put(val.get(j), "gray");
							}
			}
			int s = 0;
			ArrayList<Integer> kf = new ArrayList<Integer>();
			for (java.util.Map.Entry<Integer, String> entry : allWhite
					.entrySet()) // Pour chaque composant restant de couleur
									// rouge
			{
				Integer keyy = entry.getKey();
				String vall = entry.getValue();
				if (val.equals("white")) {
					s++;
					kf.add(keyy);
				}
			}
			while (s > 0) {
				ArrayList<Integer> st = calculDegMini(deg, kf);
				int n = st.get(st.size() - 1);
				allWhite.put(n, "black");

				for (int j = 0; j < val.size(); j++) {
					if (val.get(j) != n)
						if (allWhite.get(val.get(j)) != null)
							if (allWhite.get(val.get(j)) != "black")
								if (allWhite.get(val.get(j)) != "gray")
									allWhite.put(val.get(j), "gray");
				}
				kf = new ArrayList<Integer>();
				s = 0;
				for (java.util.Map.Entry<Integer, String> entrys : allWhite
						.entrySet()) // Pour chaque composant restant de couleur
										// rouge
				{
					Integer keyy = entrys.getKey();

					if (val.equals("white")) {
						s++;
						kf.add(keyy);
					}
				}

			}

		}

		for (java.util.Map.Entry<Integer, String> entrys : allWhite.entrySet()) {
			Integer key = entrys.getKey();
			String val = entrys.getValue();
			col.put(key, val);
		}

		return compp2;
	}

	static void phase3_b(HashMap<Integer, ArrayList<Integer>> compp2) { // si un noeud noire a un voisin j qui appartien au MIS , j-> noire

		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entry : compp2
				.entrySet()) {
			boolean ok = false;
			Integer key = entry.getKey();
			ArrayList<Integer> val = entry.getValue();
			ArrayList<Integer> k = calculDeg(degWhite, val);
			ArrayList<Integer> hash = HashM.get(k.get(k.size() - 1));
			for (int j = 0; j < hash.size(); j++) {
				if (mis.contains(hash.get(j))) {
					if (!col.get(hash.get(j)).equals("black")) {
						col.put(hash.get(j), "black");
						break;
					}
				}
			}
		}

	}

	static void phase3_bMini(HashMap<Integer, ArrayList<Integer>> compp2,
			HashMap<Integer, Integer> degWhite,
			HashMap<Integer, ArrayList<Integer>> HashM, ArrayList<Integer> mis,
			HashMap<Integer, String> col) {

		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entry : compp2
				.entrySet()) {
			boolean ok = false;
			Integer key = entry.getKey();
			ArrayList<Integer> val = entry.getValue();
			ArrayList<Integer> k = calculDegMini(degWhite, val);
			if (k.size() > 0) {
				ArrayList<Integer> hash = HashM.get(k.get(k.size() - 1));
				for (int j = 0; j < hash.size(); j++) {
					if (mis.contains(hash.get(j))) {
						if (!col.get(hash.get(j)).equals("black")) {
							col.put(hash.get(j), "black");
							break;
						}
					}
				}
			}
		}

	}

	private static HashMap<Integer, Integer> calculDegreWhite( // calculer le tableux des poids (utiliser dans la phase 2 )
			HashMap<Integer, String> allWhite) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> degg = new HashMap<Integer, Integer>();
		for (java.util.Map.Entry<Integer, String> entry : allWhite.entrySet()) // Pour
																				// chaque
																				// composant
																				// restant
																				// de
																				// couleur
																				// rouge
		{
			int deg = 0;
			Integer keyy = entry.getKey();
			String vall = entry.getValue();
			ArrayList<Integer> g = HashM.get(keyy);
			for (int i = 0; i < g.size(); i++) {
				if (allWhite.containsKey(g.get(i)))
					deg++;
			}
			degg.put(keyy, deg);
		}

		return degg;
	}

	private static HashMap<Integer, Integer> calculDegreWhiteMini(
			HashMap<Integer, String> allWhite,
			HashMap<Integer, ArrayList<Integer>> HashM) {
		// TODO Auto-generated method stub
		HashMap<Integer, Integer> degg = new HashMap<Integer, Integer>();
		for (java.util.Map.Entry<Integer, String> entry : allWhite.entrySet()) // Pour
																				// chaque
																				// composant
																				// restant
																				// de
																				// couleur
																				// rouge
		{
			int deg = 0;
			Integer keyy = entry.getKey();
			String vall = entry.getValue();
			ArrayList<Integer> g = HashM.get(keyy);
			for (int i = 0; i < g.size(); i++) {
				if (allWhite.containsKey(g.get(i)))
					deg++;
			}
			degg.put(keyy, deg);
		}

		return degg;
	}

	static HashMap<Integer, ArrayList<Integer>> calculBlackCompMini(
			HashMap<Integer, String> col,
			HashMap<Integer, ArrayList<Integer>> HashM) {
		HashMap<Integer, ArrayList<Integer>> blackC = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> allBlack = new ArrayList<Integer>();
		HashMap<Integer, Integer> composantB = new HashMap<Integer, Integer>();
		for (java.util.Map.Entry<Integer, String> entryyy : col.entrySet()) // Pour
																			// chaque
																			// composant
																			// restant
																			// de
																			// couleur
																			// rouge
		{

			Integer key = entryyy.getKey();
			String val = entryyy.getValue();
			if (val.equals("black"))
				allBlack.add(key);
		}
		HashMap<Integer, ArrayList<Integer>> HashMWhite = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < allBlack.size(); i++) {
			ArrayList<Integer> k = new ArrayList<Integer>();
			for (int j = 0; j < HashM.get(allBlack.get(i)).size(); j++)
				if (allBlack.contains(HashM.get(allBlack.get(i)).get(j))) {
					k.add(HashM.get(allBlack.get(i)).get(j));
				}
			HashMWhite.put(allBlack.get(i), k);
		}

		int c = 0;
		int wq = 0;
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entryyy : HashMWhite
				.entrySet()) // Pour chaque composant restant de couleur rouge
		{

			Integer key = entryyy.getKey();
			ArrayList<Integer> val = entryyy.getValue();
			int u = 0;
			ArrayList<Integer> tr = new ArrayList<Integer>();
			boolean l = false;

			for (int o = 0; o < val.size(); o++) {
				if (composantB.get(val.get(o)) != null) {
					wq = composantB.get(val.get(o));
					l = true;

				}
			}

			if (!l) {
				wq = c++;
			}
			if (composantB.get(key) == null) {
				composantB.put(key, wq);

			} else
				tr.add(composantB.get(key));

			for (int j = 0; j < val.size(); j++) {

				if (composantB.get(val.get(j)) != null) {
					u = composantB.get(val.get(j));
					if (!tr.contains(u))
						tr.add(u);
					wq = u;
				} else
					composantB.put(val.get(j), wq);

			}

			for (int hg = 0; hg < composantB.size() && tr.size() > 0; hg++) {
				if (tr.contains(composantB.get(hg))) {
					composantB.put(hg, tr.get(0));
				}
			}

		}
		for (java.util.Map.Entry<Integer, Integer> entry : composantB
				.entrySet()) // Pour chaque composant
		{
			int indice = entry.getKey();
			int val = entry.getValue();
			ArrayList<Integer> hash = HashM.get(indice);
			for (java.util.Map.Entry<Integer, Integer> entryy : composantB
					.entrySet()) // Pour chaque composant
			{
				int indicee = entryy.getKey();
				int vall = entryy.getValue();
				if (hash.contains(indicee) && val != vall) {
					for (java.util.Map.Entry<Integer, Integer> entryyy : composantB
							.entrySet()) // Pour chaque composant
					{
						int indiceee = entryyy.getKey();
						int valll = entryyy.getValue();
						if (valll == vall) {
							composantB.put(indiceee, val);
						}
					}
				}

			}

		}
		for (java.util.Map.Entry<Integer, Integer> entry : composantB
				.entrySet()) // Pour chaque composant
		{
			int indice = entry.getKey();
			int val = entry.getValue();
			ArrayList<Integer> hash = HashM.get(indice);
			for (java.util.Map.Entry<Integer, Integer> entryy : composantB
					.entrySet()) // Pour chaque composant
			{
				int indicee = entryy.getKey();
				int vall = entryy.getValue();
				if (hash.contains(indicee) && val != vall) {
					for (java.util.Map.Entry<Integer, Integer> entryyy : composantB
							.entrySet()) // Pour chaque composant
					{
						int indiceee = entryyy.getKey();
						int valll = entryyy.getValue();
						if (valll == vall) {
							composantB.put(indiceee, val);
						}
					}
				}

			}

		}

		for (java.util.Map.Entry<Integer, Integer> entryyy : composantB
				.entrySet()) // Pour chaque composant restant de couleur rouge
		{

			Integer key = entryyy.getKey();
			Integer val = entryyy.getValue();
			if (blackC.get(val) != null) {
				ArrayList<Integer> fd = new ArrayList<Integer>();
				fd = blackC.get(val);
				if (!fd.contains(key)) {
					fd.add(key);
				}
				blackC.put(val, fd);
			} else {
				ArrayList<Integer> fd = new ArrayList<Integer>();
				fd.add(key);
				blackC.put(val, fd);
			}
		}
		HashMap<Integer, Integer> com = new HashMap<Integer, Integer>();
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entryyy : blackC
				.entrySet()) // Pour chaque composant restant de couleur rouge
		{
			Integer key = entryyy.getKey();
			ArrayList<Integer> val = entryyy.getValue();
			for (java.util.Map.Entry<Integer, ArrayList<Integer>> entry : blackC
					.entrySet()) // Pour chaque composant restant de couleur
									// rouge
			{
				Integer keyy = entry.getKey();
				ArrayList<Integer> vall = entry.getValue();
				if (key != keyy) {
					for (int i = 0; i < val.size(); i++) {
						ArrayList<Integer> Hash = HashM.get(val.get(i));
						for (int j = 0; j < Hash.size(); j++) {
							if (vall.contains(Hash.get(j))) {
								// key et keyy sont des composant connecter

								if (com.get(keyy) == null
										&& com.get(key) == null)

								{
									com.put(key, key);
									com.put(keyy, key);
								} else if (com.get(key) != null
										&& com.get(keyy) == null)
									com.put(keyy, key);
								else if (com.get(key) != null
										&& com.get(keyy) != null) {
									int a = com.get(key);
									int b = com.get(keyy);
									for (java.util.Map.Entry<Integer, Integer> entryy : com
											.entrySet()) // Pour chaque
															// composant restant
															// de couleur rouge
									{
										int v = entryy.getValue();
										int k = entryy.getKey();
										if (v == b)
											com.put(k, a);
									}
								}
							}
						}
					}
				}

			}

		}

		HashMap<Integer, ArrayList<Integer>> sjahdja = new HashMap<Integer, ArrayList<Integer>>();
		for (java.util.Map.Entry<Integer, Integer> entryy : com.entrySet()) // Pour
																			// chaque
																			// composant
																			// restant
																			// de
																			// couleur
																			// rouge
		{
			int v = entryy.getValue();
			int k = entryy.getKey();
			ArrayList<Integer> r = new ArrayList<Integer>();
			if (sjahdja.get(v) == null) {
				r.add(k);
				sjahdja.put(v, r);
			} else {
				r = sjahdja.get(v);
				if (!r.contains(k))
					r.add(k);
				sjahdja.put(v, r);
			}

		}
		HashMap<Integer, ArrayList<Integer>> blackCC = blackC;

		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entryy : sjahdja
				.entrySet()) {
			ArrayList<Integer> v = entryy.getValue();
			int k = entryy.getKey();
			ArrayList<Integer> zero = blackC.get(v.get(0));
			for (int i = 1; i < v.size(); i++) {
				ArrayList<Integer> re = blackC.get(v.get(i));
				zero.addAll(re);
				blackC.remove(v.get(i));
			}
			blackC.put(v.get(0), zero);

		}
		return blackC;

	}

	static HashMap<Integer, ArrayList<Integer>> calculBlackComp() { // calculer les composants noirs dans les composants connexes
		HashMap<Integer, ArrayList<Integer>> blackC = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> allBlack = new ArrayList<Integer>();
		HashMap<Integer, Integer> composantB = new HashMap<Integer, Integer>();
		for (int i = 0; i < col.size(); i++) {
			if (col.get(i).equals("black"))
				allBlack.add(i);
		}

		HashMap<Integer, ArrayList<Integer>> HashMWhite = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < allBlack.size(); i++) {
			ArrayList<Integer> k = new ArrayList<Integer>();
			for (int j = 0; j < HashM.get(allBlack.get(i)).size(); j++)
				if (allBlack.contains(HashM.get(allBlack.get(i)).get(j))) {
					k.add(HashM.get(allBlack.get(i)).get(j));
				}
			HashMWhite.put(allBlack.get(i), k);
		}

		int c = 0;
		int wq = 0;
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entryyy : HashMWhite
				.entrySet()) // Pour chaque composant restant de couleur rouge
		{

			Integer key = entryyy.getKey();
			ArrayList<Integer> val = entryyy.getValue();
			int u = 0;
			ArrayList<Integer> tr = new ArrayList<Integer>();
			boolean l = false;

			for (int o = 0; o < val.size(); o++) {
				if (composantB.get(val.get(o)) != null) {
					wq = composantB.get(val.get(o));
					l = true;

				}
			}

			if (!l) {
				wq = c++;
			}
			if (composantB.get(key) == null) {
				composantB.put(key, wq);

			} else
				tr.add(composantB.get(key));

			for (int j = 0; j < val.size(); j++) {

				if (composantB.get(val.get(j)) != null) {
					u = composantB.get(val.get(j));
					if (!tr.contains(u))
						tr.add(u);
					wq = u;
				} else
					composantB.put(val.get(j), wq);

			}

			for (int hg = 0; hg < composantB.size() && tr.size() > 0; hg++) {
				if (tr.contains(composantB.get(hg))) {
					composantB.put(hg, tr.get(0));
				}
			}

		}
		for (java.util.Map.Entry<Integer, Integer> entryyy : composantB
				.entrySet()) // Pour chaque composant restant de couleur rouge
		{

			Integer key = entryyy.getKey();
			Integer val = entryyy.getValue();
			if (blackC.get(val) != null) {
				ArrayList<Integer> fd = new ArrayList<Integer>();
				fd = blackC.get(val);
				if (!fd.contains(key)) {
					fd.add(key);
				}
				blackC.put(val, fd);
			} else {
				ArrayList<Integer> fd = new ArrayList<Integer>();
				fd.add(key);
				blackC.put(val, fd);
			}
		}
		HashMap<Integer, Integer> com = new HashMap<Integer, Integer>();
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entryyy : blackC
				.entrySet()) // Pour chaque composant restant de couleur rouge
		{
			Integer key = entryyy.getKey();
			ArrayList<Integer> val = entryyy.getValue();
			for (java.util.Map.Entry<Integer, ArrayList<Integer>> entry : blackC
					.entrySet()) // Pour chaque composant restant de couleur
									// rouge
			{
				Integer keyy = entry.getKey();
				ArrayList<Integer> vall = entry.getValue();
				if (key != keyy) {
					for (int i = 0; i < val.size(); i++) {
						ArrayList<Integer> Hash = HashM.get(val.get(i));
						for (int j = 0; j < Hash.size(); j++) {
							if (vall.contains(Hash.get(j))) {
								// key et keyy sont des composant connecter

								if (com.get(keyy) == null
										&& com.get(key) == null)

								{
									com.put(key, key);
									com.put(keyy, key);
								} else if (com.get(key) != null
										&& com.get(keyy) == null)
									com.put(keyy, key);
								else if (com.get(key) != null
										&& com.get(keyy) != null) {
									int a = com.get(key);
									int b = com.get(keyy);
									for (java.util.Map.Entry<Integer, Integer> entryy : com
											.entrySet()) // Pour chaque
															// composant restant
															// de couleur rouge
									{
										int v = entryy.getValue();
										int k = entryy.getKey();
										if (v == b)
											com.put(k, a);
									}
								}
							}
						}
					}
				}

			}

		}

		HashMap<Integer, ArrayList<Integer>> sjahdja = new HashMap<Integer, ArrayList<Integer>>();
		for (java.util.Map.Entry<Integer, Integer> entryy : com.entrySet()) // Pour
																			// chaque
																			// composant
																			// restant
																			// de
																			// couleur
																			// rouge
		{
			int v = entryy.getValue();
			int k = entryy.getKey();
			ArrayList<Integer> r = new ArrayList<Integer>();
			if (sjahdja.get(v) == null) {
				r.add(k);
				sjahdja.put(v, r);
			} else {
				r = sjahdja.get(v);
				if (!r.contains(k))
					r.add(k);
				sjahdja.put(v, r);
			}

		}
		HashMap<Integer, ArrayList<Integer>> blackCC = blackC;
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entryy : sjahdja
				.entrySet()) // Pour chaque composant restant de couleur rouge
		{
			ArrayList<Integer> v = entryy.getValue();
			int k = entryy.getKey();
			ArrayList<Integer> zero = blackC.get(v.get(0));
			for (int i = 1; i < v.size(); i++) {
				ArrayList<Integer> re = blackC.get(v.get(i));
				zero.addAll(re);
				blackC.remove(v.get(i));
			}
			blackC.put(v.get(0), zero);

		}
		com = new HashMap<Integer, Integer>();
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entryyy : blackC
				.entrySet()) // Pour chaque composant restant de couleur rouge
		{
			Integer key = entryyy.getKey();
			ArrayList<Integer> val = entryyy.getValue();
			for (java.util.Map.Entry<Integer, ArrayList<Integer>> entry : blackC
					.entrySet()) // Pour chaque composant restant de couleur
									// rouge
			{
				Integer keyy = entry.getKey();
				ArrayList<Integer> vall = entry.getValue();
				if (key != keyy) {
					for (int i = 0; i < val.size(); i++) {
						ArrayList<Integer> Hash = HashM.get(val.get(i));
						for (int j = 0; j < Hash.size(); j++) {
							if (vall.contains(Hash.get(j))) {
								// key et keyy sont des composant connecter

								if (com.get(keyy) == null
										&& com.get(key) == null)

								{
									com.put(key, key);
									com.put(keyy, key);
								} else if (com.get(key) != null
										&& com.get(keyy) == null)
									com.put(keyy, key);
								else if (com.get(key) != null
										&& com.get(keyy) != null) {
									int a = com.get(key);
									int b = com.get(keyy);
									for (java.util.Map.Entry<Integer, Integer> entryy : com
											.entrySet()) // Pour chaque
															// composant restant
															// de couleur rouge
									{
										int v = entryy.getValue();
										int k = entryy.getKey();
										if (v == b)
											com.put(k, a);
									}
								}
							}
						}
					}
				}

			}

		}

		sjahdja = new HashMap<Integer, ArrayList<Integer>>();
		for (java.util.Map.Entry<Integer, Integer> entryy : com.entrySet()) // Pour
																			// chaque
																			// composant
																			// restant
																			// de
																			// couleur
																			// rouge
		{
			int v = entryy.getValue();
			int k = entryy.getKey();
			ArrayList<Integer> r = new ArrayList<Integer>();
			if (sjahdja.get(v) == null) {
				r.add(k);
				sjahdja.put(v, r);
			} else {
				r = sjahdja.get(v);
				if (!r.contains(k))
					r.add(k);
				sjahdja.put(v, r);
			}

		}
		blackCC = blackC;
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entryy : sjahdja
				.entrySet()) // Pour chaque composant restant de couleur rouge
		{
			ArrayList<Integer> v = entryy.getValue();
			int k = entryy.getKey();
			ArrayList<Integer> zero = blackC.get(v.get(0));
			for (int i = 1; i < v.size(); i++) {
				ArrayList<Integer> re = blackC.get(v.get(i));
				zero.addAll(re);
				blackC.remove(v.get(i));
			}
			blackC.put(v.get(0), zero);

		}

		return blackC;

	}

	HashMap<Integer, ArrayList<Integer>> phase4() { // phase 4 original ( n'est pas utiliser )
		HashMap<Integer, ArrayList<Integer>> blackcomp = calculBlackComp();

		int c;
		// pour chaque node gris si elle est connecter au moins 2 composant
		// noire different elle va etres noire
		for (int i = 0; i < col.size(); i++) {
			c = 0;
			if (col.get(i).equals("gray")) {
				ArrayList<Integer> f = connecter(i, blackcomp);
				if (f.size() >= 2) {
					col.put(i, "black");
					blackcomp = calculBlackComp();
				}
			}
		}

		for (int i = 0; i < col.size(); i++) {
			if (col.get(i).equals("black"))
				if (UnitDisk.v2) {
					if (HashM.get(i).size() == 1
							&& col.get(HashM.get(i).get(0)).equals("black")
							&& nodes.get(HashM.get(i).get(0)).getScore() > 0) {
						col.put(i, "gray");
						blackcomp = calculBlackComp();
					}
				} else {
					if (HashM.get(i).size() == 1
							&& col.get(HashM.get(i).get(0)).equals("black")) {
						col.put(i, "gray");
						blackcomp = calculBlackComp();
					}
				}

		}

		blackcomp = calculBlackComp();
		return blackcomp;

	}

	static HashMap<Integer, ArrayList<Integer>> phase4Mini(
			HashMap<Integer, String> col,
			HashMap<Integer, ArrayList<Integer>> HashM,
			HashMap<Integer, Node> nodes, ArrayList<Integer> extB) {
		HashMap<Integer, ArrayList<Integer>> blackcomp = calculBlackCompMini(
				col, HashM);

		int c;
		// pour chaque node gris si elle est connecter au moins 2 composant
		// noire different elle va etres noire
		for (java.util.Map.Entry<Integer, String> entryyy : col.entrySet()) // Pour
																			// chaque
																			// composant
																			// restant
																			// de
																			// couleur
																			// rouge
		{
			int key = entryyy.getKey();
			String val = entryyy.getValue();
			c = 0;
			if (val.equals("gray")) {
				ArrayList<Integer> f = connecterMini(key, blackcomp, HashM);
				if (f.size() >= 2) {
					col.put(key, "black");
					blackcomp = calculBlackCompMini(col, HashM);
				}
			}
		}

		for (java.util.Map.Entry<Integer, String> entryyy : col.entrySet()) // Pour
																			// chaque
																			// composant
																			// restant
																			// de
																			// couleur
																			// rouge
		{
			int key = entryyy.getKey();
			String val = entryyy.getValue();
			if (val.equals("black"))
				if (HashM.get(key).size() == 1
						&& col.get(HashM.get(key).get(0)).equals("black")) {
					col.put(key, "gray");
					blackcomp = calculBlackCompMini(col, HashM);

				}
		}

		blackcomp = calculBlackCompMini(col, HashM);
		return blackcomp;

	}

	int WhatComp(int i, HashMap<Integer, ArrayList<Integer>> b) {// savoire dans quelle composant appartien node i
		Integer key = null;
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entryyy : b
				.entrySet()) // Pour chaque composant restant de couleur rouge
		{
			key = entryyy.getKey();
			ArrayList<Integer> val = entryyy.getValue();
			if (val.contains(i))
				return key;
		}
		return key;

	}

	boolean different(ArrayList<Integer> a, ArrayList<Integer> b) {
		boolean different = true;
		for (int i = 0; i < a.size(); i++)
			if (b.contains(a.get(i)))
				different = false;
		return different;
	}

	boolean getTwoNeighbors(int k) { // savoir s'il ya un point de couleurs gris qui connecte deux composant noire dans un composant k
		boolean ok = false;
		HashMap<Integer, ArrayList<Integer>> blackcomp = calculBlackComp();
		for (int i = 0; i < Comp.get(k).size(); i++) {
			if (col.get(Comp.get(k).get(i)).equals("gray")) {
				boolean found = false;
				blackcomp = calculBlackComp();
				ArrayList<Integer> f = connecter(Comp.get(k).get(i), blackcomp);

				for (int s = 0; s < HashM.get(Comp.get(k).get(i)).size(); s++) {

					if (col.get(HashM.get(Comp.get(k).get(i)).get(s)).equals(
							"gray")) {
						ArrayList<Integer> ff = connecter(
								HashM.get(Comp.get(k).get(i)).get(s), blackcomp);
						if (different(f, ff)) {

							col.put(Comp.get(k).get(i), "black");
							col.put(HashM.get(Comp.get(k).get(i)).get(s),
									"black");

							ok = true;
							break;
						}

					}
				}
			}

		}
		return ok;
	}

	static boolean getTwoNeighborsMini(
			int k,
			HashMap<Integer, ArrayList<Integer>> HashM,
			HashMap<Integer, ArrayList<Integer>> Comp,
			HashMap<Integer, String> col) {
		boolean ok = false;
		HashMap<Integer, ArrayList<Integer>> blackcomp = calculBlackCompMini(
				col, HashM);
		for (int i = 0; i < Comp.get(k).size(); i++) {
			if (col.get(Comp.get(k).get(i)).equals("gray")) {
				boolean found = false;
				blackcomp = calculBlackCompMini(col, HashM);
				ArrayList<Integer> f = connecterMini(Comp.get(k).get(i),
						blackcomp, HashM);

				for (int s = 0; s < HashM.get(Comp.get(k).get(i)).size(); s++) {

					if (col.get(HashM.get(Comp.get(k).get(i)).get(s)).equals(
							"gray")) {
						ArrayList<Integer> ff = connecterMini(
								HashM.get(Comp.get(k).get(i)).get(s),
								blackcomp, HashM);
						if (differentMini(f, ff)) {

							col.put(Comp.get(k).get(i), "black");
							col.put(HashM.get(Comp.get(k).get(i)).get(s),
									"black");

							ok = true;
							break;
						}
					}
				}
			}
		}
		return ok;
	}

	private static boolean differentMini(ArrayList<Integer> a,
			ArrayList<Integer> b) {
		// TODO Auto-generated method stub

		boolean different = true;
		for (int i = 0; i < a.size(); i++)
			if (b.contains(a.get(i)))
				different = false;
		return different;

	}

	static HashMap<Integer, ArrayList<Integer>> phase4_Version2Mini(
			ArrayList<Integer> mis, HashMap<Integer, ArrayList<Integer>> HashM,
			HashMap<Integer, String> col,
			HashMap<Integer, ArrayList<Integer>> Comp,
			HashMap<Integer, Node> nodes, ArrayList<Integer> extB) {
		for (int i = 0; i < mis.size(); i++)
			// connectivite
			if (col.get(mis.get(i)).equals("gray")) {
				ArrayList<Integer> hash = HashM.get(mis.get(i));
				for (int j = 0; j < hash.size(); j++)
					if (grayFreindMini(hash.get(j), col, HashM)) {
						col.put(mis.get(i), "black");
					}
			}
		boolean change = false;
		HashMap<Integer, ArrayList<Integer>> comp_connx = getBlackCompInCompConnxMini(
				col, HashM, Comp);
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entryyy : comp_connx
				.entrySet()) // Pour chaque composant restant de couleur rouge
		{
			boolean ok = false;
			Integer key = entryyy.getKey();
			ArrayList<Integer> val = entryyy.getValue();
			HashMap<Integer, ArrayList<Integer>> comp_connxx = getBlackCompInCompConnxMini(
					col, HashM, Comp);
			while (val.size() > 1) {
				phase4Mini(col, HashM, nodes, extB);
				getTwoNeighborsMini(key, HashM, Comp, col);
				comp_connxx = getBlackCompInCompConnxMini(col, HashM, Comp);
				val = comp_connxx.get(key);
			}
			phase4Mini(col, HashM, nodes, extB);
		}
		verificationNoirePointMini(col, HashM, nodes);// eliminier les triangles
		return null;
	}

	private static boolean grayFreindMini(Integer i,
			HashMap<Integer, String> col,
			HashMap<Integer, ArrayList<Integer>> HashM) {
		// TODO Auto-generated method stub
		boolean ok = true;
		if (col.get(i).equals("gray"))
			for (int s = 0; s < HashM.get(i).size(); s++) {
				if (!col.get(HashM.get(i).get(s)).equals("gray"))
					ok = false;
			}
		else
			ok = false;
		return ok;
	}

	HashMap<Integer, ArrayList<Integer>> phase4_Version2() {// phase 4 qui sert a connecter les differents composant noire dans un seul composant
		for (int i = 0; i < mis.size(); i++)
			// connectivite
			if (col.get(mis.get(i)).equals("gray")) {
				ArrayList<Integer> hash = HashM.get(mis.get(i));
				for (int j = 0; j < hash.size(); j++)
					if (grayFreind(hash.get(j))) {
						col.put(mis.get(i), "black");
					}
			}
		boolean change = false;
		HashMap<Integer, ArrayList<Integer>> comp_connx = getBlackCompInCompConnx();
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entryyy : comp_connx
				.entrySet()) // Pour chaque composant restant de couleur rouge
		{
			boolean ok = false;
			Integer key = entryyy.getKey();
			ArrayList<Integer> val = entryyy.getValue();
			HashMap<Integer, ArrayList<Integer>> comp_connxx = getBlackCompInCompConnx();
			while (val.size() > 1) {
				phase4();
				getTwoNeighbors(key);
				comp_connxx = getBlackCompInCompConnx();
				val = comp_connxx.get(key);
			}
			phase4();
		}
		verificationNoirePoint();// eliminier les triangles
		return null;
	}
	void Vgluton() //version gluton
	{
		calculMatriceScore();
		for(int i=0;i<col.size();i++)
			col.put(i, "black");
		Node[] n = new Node[nodes.size()];
	//	for (int i = 0; i < zoneInt.size(); i++) {
			ArrayList<Integer> fr = new ArrayList<Integer>();
			for (int j = 0; j < nodes.size(); j++)
			//	if (nodes.get(j).getInt().contains(zoneInt.get(i).getId())) {
					fr.add(j);
			//	}
			for (int f = 0; f < n.length; f++)
				n[f] = null;
			n = new Node[fr.size()];

			for (int y = 0; y < fr.size(); y++)
				n[y] = nodes.get(fr.get(y));

			// System.out.println("----------------------------");
			for (int f = 0; f < n.length; f++)
				// System.out.println(n[f]);
				Arrays.sort(n);
			for (int s = fr.size() - 1; s > 0; s--) {
				String ds = col.get(n[s].getId());
				if (ds.equals("black")) {
					int gfd = calculBlackComp().size();
					col.put(n[s].getId(), "gray");
					// System.out.println("put gray on "+n[s].getId());
					int gfd2 = calculBlackComp().size();
					// System.out.println(gfd);

					if (gfd2 > gfd || !verifier()) {
						col.put(n[s].getId(), "black");

					}
				}
			}
		}
	
	void verificationNoirePoint() { //verifier les composant noire et eliminer les formes de triangles ou les feuilles noires
		for (int i = 0; i < col.size(); i++)
			if (col.get(i).equals("black")) {
				ArrayList<Integer> fr = HashM.get(i);
				if (fr.size() == 2)
					if (col.get(fr.get(0)).equals("black")
							&& col.get(fr.get(1)).equals("black"))
						if (UnitDisk.v3) {
							if (nodes.get(i).getInt().size() != 0) {
								if (nodes.get(i).getScore() < nodes.get(
										fr.get(0)).getScore()
										&& nodes.get(i).getScore() < nodes.get(
												fr.get(1)).getScore())

									if (HashM.get(fr.get(0))
											.contains(fr.get(1)))
										col.put(i, "gray");
							} else if (nodes.get(i).getInt().size() == 0
									&& nodes.get(fr.get(0)).getInt().size() == 0
									&& nodes.get(fr.get(1)).getInt().size() == 0) {
								if (HashM.get(fr.get(0)).contains(fr.get(1)))
									col.put(i, "gray");
							}
						} else if (HashM.get(fr.get(0)).contains(fr.get(1)))
							col.put(i, "gray");
			}
		// if(!UnitDisk.v2 && !UnitDisk.v3 ){
		for (int i = 0; i < col.size(); i++)
			if (col.get(i).equals("black")) {
				ArrayList<Integer> fr = HashM.get(i);
				if (fr.size() == 2) {
					String col1 = col.get(fr.get(0));
					String col2 = col.get(fr.get(1));
					if ((col1.equals("gray") && col2.equals("black"))
							|| (col2.equals("gray") && col1.equals("black")))

					{
						if (col1.equals("gray")) {
							if (HashM.get(fr.get(0)).contains(fr.get(1)))
								col.put(i, "gray");
						} else if (col2.equals("gray")) {
							if (HashM.get(fr.get(1)).contains(fr.get(0)))
								col.put(i, "gray");
						}
					}
				}
			}
		// }
		if (UnitDisk.v3) {
			calculMatriceScore();
			Node[] n = new Node[nodes.size()];
			for (int i = 0; i < zoneInt.size(); i++) {

				ArrayList<Integer> fr = new ArrayList<Integer>();
				for (int j = 0; j < nodes.size(); j++)
					if (nodes.get(j).getInt().contains(zoneInt.get(i).getId())) {
						fr.add(j);
					}
				for (int f = 0; f < n.length; f++)
					n[f] = null;
				n = new Node[fr.size()];

				for (int y = 0; y < fr.size(); y++)
					n[y] = nodes.get(fr.get(y));

				// System.out.println("----------------------------");
				for (int f = 0; f < n.length; f++)
					// System.out.println(n[f]);
					Arrays.sort(n);
				// System.out.println("----------------------------");
				// for(int f=0;f<n.length;f++)
				// System.out.println(n[f]);
				for (int s = fr.size() - 1; s > 0; s--) {
					String ds = col.get(n[s].getId());
					if (ds.equals("black")) {
						int gfd = calculBlackComp().size();
						col.put(n[s].getId(), "gray");
						// System.out.println("put gray on "+n[s].getId());
						int gfd2 = calculBlackComp().size();
						// System.out.println(gfd);

						if (gfd2 > gfd || !verifier()) {
							col.put(n[s].getId(), "black");

						}
					}
				}
			}
		}
	}

	
	static void verificationNoirePointMini(HashMap<Integer, String> col,
			HashMap<Integer, ArrayList<Integer>> HashM,
			HashMap<Integer, Node> nodes) {
		for (java.util.Map.Entry<Integer, String> entryyy : col.entrySet()) // Pour
																			// chaque
																			// composant
																			// restant
																			// de
																			// couleur
																			// rouge
		{
			boolean ok = false;

			Integer key = entryyy.getKey();
			String val = entryyy.getValue();

			if (val.equals("black")) {
				ArrayList<Integer> fr = HashM.get(key);
				if (fr.size() == 2)
					if (col.get(fr.get(0)).equals("black")
							&& col.get(fr.get(1)).equals("black"))

						if (nodes.get(key).getInt().size() == 0
								&& nodes.get(fr.get(0)).getInt().size() == 0
								&& nodes.get(fr.get(1)).getInt().size() == 0) {
							if (HashM.get(fr.get(0)).contains(fr.get(1)))
								col.put(key, "gray");
						} else if (HashM.get(fr.get(0)).contains(fr.get(1)))
							col.put(key, "gray");
			}
		}
		for (java.util.Map.Entry<Integer, String> entryyy : col.entrySet()) // Pour
																			// chaque
																			// composant
																			// restant
																			// de
																			// couleur
																			// rouge
		{
			boolean ok = false;

			Integer key = entryyy.getKey();
			String val = entryyy.getValue();

			if (val.equals("black")) {
				ArrayList<Integer> fr = HashM.get(key);
				if (fr.size() == 2) {
					String col1 = col.get(fr.get(0));
					String col2 = col.get(fr.get(1));
					if ((col1.equals("gray") && col2.equals("black"))
							|| (col2.equals("gray") && col1.equals("black")))

					{
						if (col1.equals("gray")) {
							if (HashM.get(fr.get(0)).contains(fr.get(1)))
								col.put(key, "gray");
						} else if (col2.equals("gray")) {
							if (HashM.get(fr.get(1)).contains(fr.get(0)))
								col.put(key, "gray");
						}
					}
				}

			}
		}

	}

	boolean grayFreind(int i) { // savoir si on a un voisin gris
		boolean ok = true;
		if (col.get(i).equals("gray"))
			for (int s = 0; s < HashM.get(i).size(); s++) {
				if (!col.get(HashM.get(i).get(s)).equals("gray"))
					ok = false;
			}
		else
			ok = false;
		return ok;
	}

	static HashMap<Integer, ArrayList<Integer>> getBlackCompInCompConnx() { // retourne les coposant noire connexe dans un composant 
		HashMap<Integer, ArrayList<Integer>> b = calculBlackComp();

		HashMap<Integer, ArrayList<Integer>> BlackCompInCompCnnx = new HashMap<Integer, ArrayList<Integer>>();
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entryyy : Comp
				.entrySet()) // Pour chaque composant restant de couleur rouge
		{
			Integer key = entryyy.getKey();
			ArrayList<Integer> val = entryyy.getValue();
			ArrayList<Integer> f = new ArrayList<Integer>();

			for (int i = 0; i < val.size(); i++) {
				for (java.util.Map.Entry<Integer, ArrayList<Integer>> entry : b
						.entrySet()) // Pour chaque composant restant de couleur
										// rouge
				{
					Integer keyy = entry.getKey();
					ArrayList<Integer> vall = entry.getValue();
					if (vall.contains(val.get(i))) {
						if (!f.contains(keyy)) {

							f.add(keyy);
						}

					}

				}

			}
			BlackCompInCompCnnx.put(key, f);
		}

		return BlackCompInCompCnnx;

	}

	static HashMap<Integer, ArrayList<Integer>> getBlackCompInCompConnxMini(
			HashMap<Integer, String> col,
			HashMap<Integer, ArrayList<Integer>> HashM,
			HashMap<Integer, ArrayList<Integer>> Comp) {
		HashMap<Integer, ArrayList<Integer>> b = calculBlackCompMini(col, HashM);

		HashMap<Integer, ArrayList<Integer>> BlackCompInCompCnnx = new HashMap<Integer, ArrayList<Integer>>();
		for (java.util.Map.Entry<Integer, ArrayList<Integer>> entryyy : Comp
				.entrySet()) // Pour chaque composant restant de couleur rouge
		{
			Integer key = entryyy.getKey();
			ArrayList<Integer> val = entryyy.getValue();
			ArrayList<Integer> f = new ArrayList<Integer>();

			for (int i = 0; i < val.size(); i++) {
				for (java.util.Map.Entry<Integer, ArrayList<Integer>> entry : b
						.entrySet()) // Pour chaque composant restant de couleur
										// rouge
				{
					Integer keyy = entry.getKey();
					ArrayList<Integer> vall = entry.getValue();
					if (vall.contains(val.get(i))) {
						if (!f.contains(keyy)) {

							f.add(keyy);
						}

					}

				}

			}
			BlackCompInCompCnnx.put(key, f);
		}

		return BlackCompInCompCnnx;

	}

	ArrayList<Integer> connecter(int j, HashMap<Integer, ArrayList<Integer>> b) {
		ArrayList<Integer> d = new ArrayList<Integer>();
		ArrayList<Integer> gf = HashM.get(j);
		for (int s = 0; s < gf.size(); s++)
			for (java.util.Map.Entry<Integer, ArrayList<Integer>> entryyy : b
					.entrySet()) // Pour chaque composant restant de couleur
									// rouge
			{
				Integer key = entryyy.getKey();
				ArrayList<Integer> val = entryyy.getValue();

				if (val.contains(gf.get(s))) {
					if (!d.contains(key))
						d.add(key);
				}
			}
		return d;

	}

	static ArrayList<Integer> connecterMini(int j,
			HashMap<Integer, ArrayList<Integer>> b,
			HashMap<Integer, ArrayList<Integer>> HashM) {
		ArrayList<Integer> d = new ArrayList<Integer>();
		ArrayList<Integer> gf = HashM.get(j);
		for (int s = 0; s < gf.size(); s++)
			for (java.util.Map.Entry<Integer, ArrayList<Integer>> entryyy : b
					.entrySet()) // Pour chaque composant restant de couleur
									// rouge
			{
				Integer key = entryyy.getKey();
				ArrayList<Integer> val = entryyy.getValue();

				if (val.contains(gf.get(s))) {
					if (!d.contains(key))
						d.add(key);
				}
			}
		return d;

	}

	boolean verifier() { // verifier que chaque point gris et connecter a au moin un point noire
		boolean ok = false;
		for (int i = 0; i < col.size(); i++) {
			if (col.get(i).equals("gray")) {
				ok = false;
				ArrayList<Integer> hash = HashM.get(i);
				for (int j = 0; j < hash.size(); j++)
					if (col.get(hash.get(j)).equals("black")) {
						ok = true;
						break;
					}
				if (!ok) {
					// System.out.println(serveur.mis);
					break;
				}
			}
		}
		return ok;
	}

	void phase5() {
		for (int i = 0; i < col.size(); i++) {
			if (col.get(i).equals("gray")) {
				backB.put(i, calculBestCnnx(i));
			}
		}
		phase5 = false;

	}

	int calculBestCnnx(int i) { // calculer la meuilleur connection entre une point gris et ces different voisin noire
		double val = -100;
		int y = 0;
		ArrayList<Integer> fr = HashM.get(i);
		if (fr.size() > 0)
			for (int s = 0; s < fr.size(); s++) {
				if (nodes.get(fr.get(s)).getScore() > val
						&& col.get(fr.get(s)).equals("black"))

				{
					val = nodes.get(fr.get(s)).getScore();
					y = fr.get(s);
				}
			}
		return y;
	}

	static void createTXTB() { // crrere un fichier TXT qui contient les elements du backbone
		try {
			PrintStream fileStream = new PrintStream(new File("backB.txt"));
			fileStream.println("BackBone");
			
			for (int i = 0; i < col.size(); i++) {
			//	if (col.get(i).equals("black") && nodes.get(i).getIdMap()!=0) { %% for real data with IdMap 
				if (col.get(i).equals("black")) {
					
					fileStream.println("Node:"+nodes.get(i).getId()+" "+nodes.get(i).getPtX()+" "+nodes.get(i).getPtY());
				}
			}
			fileStream.close();
			// System.out.println("Create Folder");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void CreateLatex() {// creere une fichier txt avec un format latex pour representer le graphe
		try {
			PrintStream fileStream = new PrintStream(new File("Latex.txt"));
			fileStream.println("\\begin{figure}[!h]");
			fileStream.println("\\centering");
			fileStream
					.println("\\tikzstyle{sommet}=[circle,draw,thick, fill=red, inner sep=2pt]");
			fileStream
					.println("\\tikzstyle{sommetZ}=[circle,draw,thick, fill=green, inner sep=2pt]");
			fileStream
					.println("\\tikzstyle{sommetB}=[circle,draw,thick, fill=black, inner sep=2pt]");
			fileStream
					.println("\\tikzstyle{fleche}=[<->,>=latex,dashed, black, line width=0.4mm]");
		
			fileStream.println("\\begin{tikzpicture}[scale=0.3]");
			fileStream.println("\\def\\ang{53}");
			for (int i = 0; i < zoneInt.size(); i++) {

				float x = (float) Math.abs(zoneInt.get(i).getPtX() + 12) / 20;
				float y = (float) Math.abs(zoneInt.get(i).getPtY() + 12 - 500) / 20;
				fileStream.println("\\draw[dashed,black] (" + x + "," + y
						+ ") circle (6);");

			}
			Object[] k = Serveur2.HashM.keySet().toArray();
			for (int i = 0; i < HashM.size(); i++) {

				int s = (Integer) k[i];
				ArrayList<Integer> a = new ArrayList<Integer>();
				a = Serveur2.HashM.get(i);
				for (int j = 0; j < a.size(); j++) {
					if(col.get(Serveur2.nodes.get(s).getId()).equals("black")){
						if(col.get(Serveur2.nodes.get(a.get(j)).getId()).equals("black")){
					float x = (float) Math
							.abs(Serveur2.nodes.get(s).getPtX() + 12) / 20;
					float y = (float) Math
							.abs(Serveur2.nodes.get(s).getPtY() + 12 - 500) / 20;
					float x1 = (float) Math.abs(Serveur2.nodes.get(a.get(j))
							.getPtX() + 12) / 20;
					float y1 = (float) Math.abs(Serveur2.nodes.get(a.get(j))
							.getPtY() + 12 - 500) / 20;
					fileStream.println("\\draw[line width=0.3mm] (" + x + ","
							+ y + ") -- (" + x1 + "," + y1 + ");");
					}}
				}
			}
			for (int i = 0; i < nodes.size(); i++) {
				float x = (float) Math.abs(Serveur2.nodes.get(i).getPtX() + 12) / 20;
				float y = (float) Math
						.abs(Serveur2.nodes.get(i).getPtY() + 12 - 500) / 20;
				if (Serveur2.col.get(i).equals("black")) {
					fileStream.println("\\draw  (" + x + "," + y
							+ ")  node[sommetB]{};");
				} else
					fileStream.println("\\draw  (" + x + "," + y
							+ ")  node[sommet]{};");
			}
			for (int i = 0; i < zoneInt.size(); i++) {
				float x = (float) Math
						.abs(Serveur2.zoneInt.get(i).getPtX() + 12) / 20;
				float y = (float) Math
						.abs(Serveur2.zoneInt.get(i).getPtY() + 12 - 500) / 20;
				fileStream.println("\\draw  (" + x + "," + y
						+ ")  node[sommetZ]{};");
			}
			fileStream.println("\\end{tikzpicture}");
			fileStream.println("\\caption{Examples of UDG graphs}");
			fileStream.println("\\label{UDG}");
			fileStream.println("\\end{figure}");
			fileStream.close();
			// System.out.println("Create Folder");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void CreateLatex_Phase1()
	{
		try {
			//PrintStream fileStream = new PrintStream(new File("Latex_Phase1.txt"));
			PrintStream fileStream = new PrintStream(new BufferedOutputStream(new FileOutputStream("Latex_Phase.txt", true)));
			
			fileStream.println("\\begin{figure}[!h]");
			fileStream.println("\\centering");
			fileStream
					.println("\\tikzstyle{sommet}=[circle,draw,thick, fill=red, inner sep=2pt]");
			fileStream
					.println("\\tikzstyle{sommetZ}=[circle,draw,thick, fill=green, inner sep=2pt]");
			fileStream
					.println("\\tikzstyle{sommetB}=[circle,draw,thick, fill=black, inner sep=3pt]");
			fileStream
					.println("\\tikzstyle{fleche}=[<->,>=latex,dashed, black, line width=0.4mm]");
		
			fileStream.println("\\begin{tikzpicture}[scale=0.3]");
			fileStream.println("\\def\\ang{53}");
			for (int i = 0; i < zoneInt.size(); i++) {

				float x = (float) Math.abs(zoneInt.get(i).getPtX() + 12) / 20;
				float y = (float) Math.abs(zoneInt.get(i).getPtY() + 12 - 500) / 20;
				fileStream.println("\\draw[dashed,black] (" + x + "," + y
						+ ") circle (6);");

			}
//			Object[] k = serveur.HashM.keySet().toArray();
//			for (int i = 0; i < HashM.size(); i++) {
//
//				int s = (Integer) k[i];
//				ArrayList<Integer> a = new ArrayList<Integer>();
//				a = serveur.HashM.get(i);
//				for (int j = 0; j < a.size(); j++) {
//					
//					float x = (float) Math
//							.abs(serveur.nodes.get(s).getPtX() + 12) / 20;
//					float y = (float) Math
//							.abs(serveur.nodes.get(s).getPtY() + 12 - 500) / 20;
//					float x1 = (float) Math.abs(serveur.nodes.get(a.get(j))
//							.getPtX() + 12) / 20;
//					float y1 = (float) Math.abs(serveur.nodes.get(a.get(j))
//							.getPtY() + 12 - 500) / 20;
//					fileStream.println("\\draw[line width=0.3mm] (" + x + ","
//							+ y + ") -- (" + x1 + "," + y1 + ");");
//					
//				}
//			}
			for (int i = 0; i < nodes.size(); i++) {
				float x = (float) Math.abs(Serveur2.nodes.get(i).getPtX() + 12) / 20;
				float y = (float) Math
						.abs(Serveur2.nodes.get(i).getPtY() + 12 - 500) / 20;
				if(Serveur2.mis.contains(Serveur2.nodes.get(i).getId()))
				{
					fileStream.println("\\draw  (" + x + "," + y
							+ ")  node[sommetB]{};");
				} else
					fileStream.println("\\draw  (" + x + "," + y
							+ ")  node[sommet]{};");
			}
			for (int i = 0; i < zoneInt.size(); i++) {
				float x = (float) Math
						.abs(Serveur2.zoneInt.get(i).getPtX() + 12) / 20;
				float y = (float) Math
						.abs(Serveur2.zoneInt.get(i).getPtY() + 12 - 500) / 20;
				fileStream.println("\\draw  (" + x + "," + y
						+ ")  node[sommetZ]{};");
			}
			fileStream.println("\\end{tikzpicture}");
			fileStream.println("\\caption{Examples of phase 1}");
			fileStream.println("\\label{UDG}");
			fileStream.println("\\end{figure}");
			fileStream.close();
			// System.out.println("Create Folder");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	void CreateLatex_Phase2(String n)
	{
		try {
			//PrintStream fileStream = new PrintStream(new File("Latex_Phase"+n+".txt"));
			PrintStream fileStream = new PrintStream(new BufferedOutputStream(new FileOutputStream("Latex_Phase.txt", true)));
			fileStream.println("\\begin{figure}[!h]");
			fileStream.println("\\centering");
			fileStream
					.println("\\tikzstyle{sommet}=[circle,draw,thick, fill=red, inner sep=2pt]");
			fileStream
			.println("\\tikzstyle{sommetW}=[circle,draw,thick, fill=yellow, inner sep=2pt]");
			fileStream
					.println("\\tikzstyle{sommetZ}=[circle,draw,thick, fill=green, inner sep=2pt]");
			fileStream
					.println("\\tikzstyle{sommetB}=[circle,draw,thick, fill=black, inner sep=3pt]");
			fileStream
					.println("\\tikzstyle{fleche}=[<->,>=latex,dashed, black, line width=0.4mm]");
		
			fileStream.println("\\begin{tikzpicture}[scale=0.3]");
			fileStream.println("\\def\\ang{53}");
			for (int i = 0; i < zoneInt.size(); i++) {

				float x = (float) Math.abs(zoneInt.get(i).getPtX() + 12) / 20;
				float y = (float) Math.abs(zoneInt.get(i).getPtY() + 12 - 500) / 20;
				fileStream.println("\\draw[dashed,black] (" + x + "," + y
						+ ") circle (6);");

			}
			Object[] k = Serveur2.HashM.keySet().toArray();
			for (int i = 0; i < HashM.size(); i++) {

				int s = (Integer) k[i];
				ArrayList<Integer> a = new ArrayList<Integer>();
				a = Serveur2.HashM.get(i);
				for (int j = 0; j < a.size(); j++) {
					if(col.get(Serveur2.nodes.get(s).getId()).equals("black")){
						if(col.get(Serveur2.nodes.get(a.get(j)).getId()).equals("black")){
					float x = (float) Math
							.abs(Serveur2.nodes.get(s).getPtX() + 12) / 20;
					float y = (float) Math
							.abs(Serveur2.nodes.get(s).getPtY() + 12 - 500) / 20;
					float x1 = (float) Math.abs(Serveur2.nodes.get(a.get(j))
							.getPtX() + 12) / 20;
					float y1 = (float) Math.abs(Serveur2.nodes.get(a.get(j))
							.getPtY() + 12 - 500) / 20;
					fileStream.println("\\draw[line width=0.3mm] (" + x + ","
							+ y + ") -- (" + x1 + "," + y1 + ");");
						}}
				}
			}
			for (int i = 0; i < nodes.size(); i++) {
				float x = (float) Math.abs(Serveur2.nodes.get(i).getPtX() + 12) / 20;
				float y = (float) Math
						.abs(Serveur2.nodes.get(i).getPtY() + 12 - 500) / 20;
				if(Serveur2.col.get(i).equals("black"))
				{
					fileStream.println("\\draw  (" + x + "," + y
							+ ")  node[sommetB]{};");
				} else
					if(Serveur2.col.get(i).equals("gray"))
					fileStream.println("\\draw  (" + x + "," + y
							+ ")  node[sommet]{};");
					else
						fileStream.println("\\draw  (" + x + "," + y
								+ ")  node[sommetW]{};");
			}
			for (int i = 0; i < zoneInt.size(); i++) {
				float x = (float) Math
						.abs(Serveur2.zoneInt.get(i).getPtX() + 12) / 20;
				float y = (float) Math
						.abs(Serveur2.zoneInt.get(i).getPtY() + 12 - 500) / 20;
				fileStream.println("\\draw  (" + x + "," + y
						+ ")  node[sommetZ]{};");
			}
			fileStream.println("\\end{tikzpicture}");
			if(n!="4")
			fileStream.println("\\caption{Examples phase "+ n +"}");
			else if(UnitDisk.v3)
				fileStream.println("\\caption{Examples phase_gluton}");
			
			fileStream.println("\\label{UDG}");
			fileStream.println("\\end{figure}");
			fileStream.close();
			// System.out.println("Create Folder");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	static void miniServeur() {

		for (int i = 0; i < zoneInt.size(); i++) // pour chaque zone interet
		{
			ArrayList<Node> zoneInt = new ArrayList<Node>();
			HashMap<Integer, ArrayList<Integer>> HashM = new HashMap<Integer, ArrayList<Integer>>();
			HashMap<Integer, HashMap<Integer, Double>> distMatrice = new HashMap<Integer, HashMap<Integer, Double>>();
			HashMap<Integer, ArrayList<Double>> ScoretMatrice = new HashMap<Integer, ArrayList<Double>>();
			HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
			HashMap<Integer, ArrayList<Integer>> Comp = new HashMap<Integer, ArrayList<Integer>>();
			HashMap<Integer, Integer> Comp2 = new HashMap<Integer, Integer>();
			ArrayList<Integer> mis = new ArrayList<Integer>();
			HashMap<Integer, String> col = new HashMap<Integer, String>();
			HashMap<Integer, ArrayList<Integer>> compN = new HashMap<Integer, ArrayList<Integer>>();
			HashMap<Integer, ArrayList<Integer>> Blackcomp = new HashMap<Integer, ArrayList<Integer>>();
			HashMap<Integer, Integer> degWhite = new HashMap<Integer, Integer>();
			HashMap<Integer, Integer> backB = new HashMap<Integer, Integer>();
			ArrayList<Integer> extB = new ArrayList<Integer>();
			ArrayList<Integer> extG = new ArrayList<Integer>();
			HashMap<Integer, ArrayList<Integer>> compp2;
			for (int j = 0; j < Serveur2.nodes.size(); j++)
				// add all node in the zone Interet
				if (Serveur2.nodes.get(j).getInt()
						.contains(Serveur2.zoneInt.get(i).getId())) {
					nodes.put(Serveur2.nodes.get(j).getId(),
							Serveur2.nodes.get(j));

				}
			zoneInt.add(Serveur2.zoneInt.get(i));

			HashMap<Integer, Node> nodess = new HashMap<Integer, Node>();

			for (java.util.Map.Entry<Integer, Node> entryy : nodes.entrySet()) // Pour
																				// chaque
																				// composant
			{
				int d = entryy.getKey();
				Node val = entryy.getValue();
				nodess.put(d, val);
			}
			for (java.util.Map.Entry<Integer, Node> entryy : nodess.entrySet()) // Pour
																				// chaque
																				// composant
			{
				int d = entryy.getKey();
				Node val = entryy.getValue();
				if (val.getInt().contains(Serveur2.zoneInt.get(i).getId())) {
					ArrayList<Integer> fr = Serveur2.HashM.get(val.getId());

					for (int s = 0; s < fr.size(); s++) {
						if (Serveur2.col.get(fr.get(s)).equals("black")
								&& !Serveur2.nodes
										.get(fr.get(s))
										.getInt()
										.contains(
												Serveur2.zoneInt.get(i).getId())) {// connecter
																					// a
																					// une
																					// node
																					// black
																					// dehors
																					// du
																					// zone
																					// d'interet
							if (!extB.contains(fr.get(s)))
								extB.add(fr.get(s));
							if (!nodes.containsKey(Serveur2.nodes.get(fr.get(s))
									.getId()))

							{
								nodes.put(Serveur2.nodes.get(fr.get(s)).getId(),
										Serveur2.nodes.get(fr.get(s)));

							}
						} else if (Serveur2.col.get(fr.get(s)).equals("gray")
								&& !Serveur2.nodes
										.get(fr.get(s))
										.getInt()
										.contains(
												Serveur2.zoneInt.get(i).getId())) {// connecter
																					// a
																					// une
																					// gray
							ArrayList<Integer> fs = Serveur2.HashM
									.get(fr.get(s));
							boolean okays = false;
							for (int po = 0; po < fs.size(); po++) {// si elle
																	// est
																	// connecteur
																	// a une
																	// black qui
																	// n'appartient
																	// pas a
																	// cette
																	// zone
																	// d'interet
																	// on
																	// l'ajoute
																	// pas
								if (Serveur2.col.get(fs.get(po)).equals("black")
										&& !Serveur2.nodes
												.get(fs.get(po))
												.getInt()
												.contains(
														Serveur2.zoneInt.get(i)
																.getId()))
									okays = true;
							}
							if (!okays) {
								if (!extG.contains(fr.get(s)))
									extG.add(fr.get(s));
								if (!nodes.containsKey(Serveur2.nodes.get(
										fr.get(s)).getId()))

								{
									nodes.put(Serveur2.nodes.get(fr.get(s))
											.getId(), Serveur2.nodes.get(fr
											.get(s)));

								}
							}
						}
					}
				}
			}
			for (java.util.Map.Entry<Integer, Node> entryy : nodes.entrySet()) // Pour
																				// chaque
																				// composant
			{

				int d = entryy.getKey();
				Node val = entryy.getValue();
				ArrayList<Integer> s = new ArrayList<Integer>();
				HashM.put(d, s);
			}

			for (java.util.Map.Entry<Integer, Node> entryy : nodes.entrySet()) // Pour
																				// chaque
																				// composant
			{

				int d = entryy.getKey();
				Node val = entryy.getValue();
				HashMap<Integer, Double> a = new HashMap<Integer, Double>();
				for (java.util.Map.Entry<Integer, Node> entryyy : nodes
						.entrySet()) // Pour chaque composant
				{
					int dd = entryyy.getKey();
					Node vall = entryyy.getValue();

					if (val.getId() != vall.getId()) {
						a.put(vall.getId(), calculDist(val, vall));
					}
					if (val.getId() == vall.getId()) {
						a.put(vall.getId(), 0.00);
					}

				}
				distMatrice.put(val.getId(), a);
			}

			for (java.util.Map.Entry<Integer, HashMap<Integer, Double>> entry : distMatrice
					.entrySet()) // Pour chaque composant
			{
				int key = entry.getKey();
				HashMap<Integer, Double> val = entry.getValue();

				for (java.util.Map.Entry<Integer, Double> entryy : val
						.entrySet()) // Pour chaque composant
				{
					int keyy = entryy.getKey();
					Double vall = entryy.getValue();
					if (key != keyy) {
						if (vall < nodes.get(key).getR())// i et
						{
							ArrayList<Integer> k = HashM.get(nodes.get(key)
									.getId());
							if (!k.contains(keyy)) {
								k.add(keyy);
								HashM.put(key, k);

							}

						}
					}

				}
			}

			for (java.util.Map.Entry<Integer, Node> entryyy : nodes.entrySet()) // Pour
																				// chaque
																				// composant
			{
				int dd = entryyy.getKey();
				Node vall = entryyy.getValue();
				vall.setScore(0);
			}
			for (java.util.Map.Entry<Integer, Node> entryyy : nodes.entrySet()) // Pour
																				// chaque
																				// composant
			{
				int dd = entryyy.getKey();
				Node vall = entryyy.getValue();
				for (int j = 0; j < zoneInt.size(); j++) {
					double d = calculDist(vall, zoneInt.get(j));
					if (d < zoneInt.get(j).getR()) {
						double s = vall.getScore();
						s = s + (zoneInt.get(j).getR() - d);
						vall.setScore(s);
						vall.getInt().add(zoneInt.get(j).getId());
					}
				}
			}

			int c = 0; // create composant
			int wq = 0;
			for (java.util.Map.Entry<Integer, ArrayList<Integer>> entry : HashM
					.entrySet()) // Pour chaque composant
			{

				int ii = entry.getKey();
				ArrayList<Integer> val = entry.getValue();

				int u = 0;
				ArrayList<Integer> tr = new ArrayList<Integer>();

				boolean l = false;

				for (int o = 0; o < HashM.get(ii).size(); o++) {
					if (Comp2.get(HashM.get(ii).get(o)) != null) {
						wq = Comp2.get(HashM.get(ii).get(o));
						l = true;

						// tre.add(wq);
					}
				}
				if (!l) {
					wq = c++;
				}
				if (Comp2.get(ii) == null) {
					Comp2.put(ii, wq);

				} else
					tr.add(Comp2.get(ii));

				for (int j = 0; j < HashM.get(ii).size(); j++) {

					if (Comp2.get(HashM.get(ii).get(j)) != null) {
						u = Comp2.get(HashM.get(ii).get(j));
						if (!tr.contains(u))
							tr.add(u);
						wq = u;
					} else
						Comp2.put(HashM.get(ii).get(j), wq);

				}

				for (int hg = 0; hg < Comp2.size() && tr.size() > 0; hg++) {
					if (tr.contains(Comp2.get(hg))) {
						Comp2.put(hg, tr.get(0));// ????
					}
				}

			}
			c = 0; // create composant
			wq = 0;
			for (java.util.Map.Entry<Integer, ArrayList<Integer>> entry : HashM
					.entrySet()) // Pour chaque composant
			{

				int ii = entry.getKey();
				ArrayList<Integer> val = entry.getValue();

				int u = 0;
				ArrayList<Integer> tr = new ArrayList<Integer>();

				boolean l = false;

				for (int o = 0; o < HashM.get(ii).size(); o++) {
					if (Comp2.get(HashM.get(ii).get(o)) != null) {
						wq = Comp2.get(HashM.get(ii).get(o));
						l = true;

						// tre.add(wq);
					}
				}
				if (!l) {
					wq = c++;
				}
				if (Comp2.get(ii) == null) {
					Comp2.put(ii, wq);

				} else
					tr.add(Comp2.get(ii));

				for (int j = 0; j < HashM.get(ii).size(); j++) {

					if (Comp2.get(HashM.get(ii).get(j)) != null) {
						u = Comp2.get(HashM.get(ii).get(j));
						if (!tr.contains(u))
							tr.add(u);
						wq = u;
					} else
						Comp2.put(HashM.get(ii).get(j), wq);

				}

				for (int hg = 0; hg < Comp2.size() && tr.size() > 0; hg++) {
					if (tr.contains(Comp2.get(hg))) {
						Comp2.put(hg, tr.get(0));// ????
					}
				}

			}
			for (java.util.Map.Entry<Integer, Integer> entry : Comp2.entrySet()) // Pour
																					// chaque
																					// composant
			{
				int indice = entry.getKey();
				int val = entry.getValue();
				ArrayList<Integer> hash = HashM.get(indice);
				for (java.util.Map.Entry<Integer, Integer> entryy : Comp2
						.entrySet()) // Pour chaque composant
				{
					int indicee = entryy.getKey();
					int vall = entryy.getValue();
					if (hash.contains(indicee) && val != vall) {
						for (java.util.Map.Entry<Integer, Integer> entryyy : Comp2
								.entrySet()) // Pour chaque composant
						{
							int indiceee = entryyy.getKey();
							int valll = entryyy.getValue();
							if (valll == vall) {
								Comp2.put(indiceee, val);
							}
						}
					}

				}

			}
			for (java.util.Map.Entry<Integer, Integer> entry : Comp2.entrySet()) // Pour
																					// chaque
																					// composant
			{
				int indice = entry.getKey();
				int val = entry.getValue();
				if (Comp.get(val) != null) {
					ArrayList<Integer> fd = new ArrayList<Integer>();
					fd = Comp.get(val);
					if (!fd.contains(indice)) {
						fd.add(indice);
					}
					Comp.put(val, fd);
				} else {
					ArrayList<Integer> fd = new ArrayList<Integer>();
					fd.add(indice);
					Comp.put(val, fd);
				}
			}

			boolean found = false;
			HashMap<Integer, String> node = new HashMap<Integer, String>();
			for (java.util.Map.Entry<Integer, ArrayList<Integer>> entry : HashM
					.entrySet()) // Pour chaque composant
			{
				int ii = entry.getKey();
				node.put(ii, "white");

			}

			for (java.util.Map.Entry<Integer, ArrayList<Integer>> entry : Comp
					.entrySet()) // Pour chaque composant
			{

				ArrayList<Integer> compo = entry.getValue();

				ArrayList<Integer> yellow = new ArrayList<Integer>();
				int id = compo.get(0);// minimum
				node.put(id, "black");// colorie black

				for (int k = 0; k < HashM.get(id).size(); k++) {

					if (!node.get(HashM.get(id).get(k)).equals("black"))
						node.put(HashM.get(id).get(k), "gray");// color one hope
																// gray
				}
				for (int s = 0; s < HashM.get(id).size(); s++) {
					for (int u = 0; u < HashM.get(HashM.get(id).get(s)).size(); u++) {
						String st = node.get(HashM.get(HashM.get(id).get(s))
								.get(u));
						if (st.equals("white")) {
							node.put(HashM.get(HashM.get(id).get(s)).get(u),
									"yellow");
							if (!yellow.contains(HashM
									.get(HashM.get(id).get(s)).get(u)))
								yellow.add(HashM.get(HashM.get(id).get(s)).get(
										u));
						}
					}
				}
				// pour tout les yellow
				while (yellow.size() > 0) {

					id = yellow.get(0);

					found = false;
					for (int ji = 0; ji < HashM.get(id).size(); ji++)
						if (node.get(HashM.get(id).get(ji)).equals("black"))
							found = true;
					if (!found)
						node.put(id, "black");
					yellow.remove(0);
					for (int k = 0; k < HashM.get(id).size(); k++) {
						if (!node.get(HashM.get(id).get(k)).equals("black"))
							node.put(HashM.get(id).get(k), "gray");// color one
																	// hope
																	// gray

					}

					for (int s = 0; s < HashM.get(id).size(); s++) {
						for (int u = 0; u < HashM.get(HashM.get(id).get(s))
								.size(); u++) {
							String st = node.get(HashM
									.get(HashM.get(id).get(s)).get(u));
							if (st.equals("white")) {
								node.put(
										HashM.get(HashM.get(id).get(s)).get(u),
										"yellow");
								if (!yellow.contains(HashM.get(
										HashM.get(id).get(s)).get(u)))
									yellow.add(HashM.get(HashM.get(id).get(s))
											.get(u));
							}
						}
					}

				}

			}

			ArrayList<Integer> d = new ArrayList<Integer>();
			for (java.util.Map.Entry<Integer, String> entryy : node.entrySet()) // Pour
																				// chaque
																				// composant
			{
				int key = entryy.getKey();
				String val = entryy.getValue();
				if (val.equals("black"))
					d.add(key);
			}

			mis = d;
			phase2_mini(HashM, Comp2, Comp, nodes, compN, col, mis, extB);
			compp2 = phase3mini(col, degWhite, HashM);
			phase3_bMini(compp2, degWhite, HashM, mis, col);
			phase4_Version2Mini(mis, HashM, col, Comp, nodes, extB);
			for (java.util.Map.Entry<Integer, String> entryy : col.entrySet()) // Pour
																				// chaque
																				// composant
			{
				int key = entryy.getKey();
				String val = entryy.getValue();
				Serveur2.col.put(key, val);
				if (extB.contains(key))
					Serveur2.col.put(key, "black");
			}
			phase4Mini(col, HashM, nodes, extB);
			verificationNoirePointMini(col, HashM, nodes);
		}
	}
	

	
	
}
