import java.awt.Point;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.Random;

public class CreateGraphe {

	static ArrayList<Node> n = new ArrayList<Node>();

	/**
	 * @param args
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	void test(int rn, int eint, int nb, int nbint) throws FileNotFoundException {
		int x = 0, y = 0;
		int min = 0, max = 20;
		Random rand = new Random();
		PrintStream fileStream = new PrintStream(new File("file.txt"));
		fileStream.println("Point");

		for (int i = 0; i < nb; i++) {

			 int randomNumX = rand.nextInt((1000 - 0) + 1) + 0;
			 int randomNumY = rand.nextInt((640 - 0) + 1) + 0;
			//int randomNumX = rand.nextInt((1000 - 0) + 1) + 0;
			//int randomNumY = rand.nextInt((640 - 0) + 1) + 0;
			//int randomNumX = rand.nextInt((300 - 0) + 1) + 0;
			//int randomNumY = rand.nextInt((300 - 0) + 1) + 0;
			rand = new Random();

			min = randomNumX;
			max = randomNumY;
			fileStream.println(randomNumX + " " + randomNumY + " " + rn);
			Node nn = new Node(0, randomNumX, randomNumY, rn, "nodes");
			n.add(nn);
		}
		fileStream.println("ZoneInt");
		// nbint=1;
		for (int i = 0; i < nbint; i++) {

		//	int randomNumX = rand.nextInt((1000 - 0) + 1) + 0;
			//int randomNumY = rand.nextInt((650 - 0) + 1) + 0;
			 int randomNumX = rand.nextInt((1000 - 0) + 1) + 0;
			 int randomNumY = rand.nextInt((640 - 0) + 1) + 0;
			//int randomNumX = rand.nextInt((300 - 0) + 1) + 0;
			//int randomNumY = rand.nextInt((300 - 0) + 1) + 0;
			rand = new Random();

			min = randomNumX;
			max = randomNumY;
			fileStream.println(randomNumX + " " + randomNumY + " " + eint);
			Node nn = new Node(i, randomNumX, randomNumY, eint, "PointInt");
			n.add(nn);
		}
	}

	static void createGraphe() throws IOException {

	}

	static void cac() {
		double s = 299 * Math.PI * Math.pow(40, 2) / Math.pow(200, 2);
		System.out.println(s);

	}

	public static void main(String[] args) throws IOException {

	}

}
