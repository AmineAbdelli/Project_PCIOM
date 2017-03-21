import java.awt.EventQueue;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Cell;
import javafx.stage.Stage;

import javax.swing.JFrame;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sun.rowset.internal.Row;


public class Stage2 extends Application{
	Serveur2 s = new Serveur2();
	private JFrame frame;
	
	void start()
    {
    	launch();
    }
	  /**
	   * @wbp.parser.entryPoint
	   */
	  public static void main(String[] args) {
	        launch(args);
	    }
	  /**
	   * @wbp.parser.entryPoint
	   */
	  
	  public void plot(Stage stage)
	  {
		  stage.setTitle("Line Chart Sample");
	        //defining the axes
		  final CategoryAxis xAxis = new CategoryAxis();
	        final NumberAxis yAxis = new NumberAxis();
	        xAxis.setLabel("Month");       
	        
	        final LineChart<String,Number> lineChart = 
	                new LineChart<String,Number>(xAxis,yAxis);
	       
	        xAxis.setLabel("transmission");
	        yAxis.setLabel("Node number");
	        //creating the chart
	      
	                
	        lineChart.setTitle("Simulation");
	        //defining a series
	        XYChart.Series series = new XYChart.Series();
	       
	        series.setName("Initial");
	        //populating the series with data
	        XYChart.Series series2 = new XYChart.Series();
	        series2.setName("Modifier v4");
	        XYChart.Series series3 = new XYChart.Series();
	        series3.setName("Modifier v3");
			boolean ok = true;
			System.out.println("Initial : ");
			ArrayList<Integer> d=new ArrayList<Integer>();
			for (int startt = 0; startt < 100 && ok; startt=startt+10) {
				final int val = startt;
				Serveur2.clear();
				//s.test(80, 120, 500, 5);
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
					 series.getData().add(new XYChart.Data(s.nodes.get(0).getR()+"", hg));
					 d.add(hg);
					 
				} 
				
			}
			Serveur2.data.put(1, d);
			d=new ArrayList<Integer>();
			System.out.println("Modifier V3 : ");
			for (int startt = 0; startt < 100 && ok; startt=startt+10) {
				final int val = startt;
				Serveur2.clear();
				
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
					 series3.getData().add(new XYChart.Data(s.nodes.get(0).getR()+"", hg));
					 d.add(hg);
				} 
				
			}
			Serveur2.data.put(2, d);
			d=new ArrayList<Integer>();
			ok = true;
			System.out.println("Modifier : v4 ");
			for (int startt = 0; startt < 100 && ok; startt++) {
//				final int val = startt;
//				serveur.clear();
//				//s.test(80, 120, 500, 5);
//				System.out.println("Read File : "+"data/file"+startt+".txt");
//				s.nodes = s.readData("data/file"+startt+".txt");
//			// read data from txt file
//				s.calculMatriceDist(); // matrice de distance
//				s.addNeighbour(); // hashM
//				s.calculMatriceScore(); // matrice de score
//				s.CreateComp();
//				UnitDisk.v2=false;
//				UnitDisk.v3=false;
//				serveur.numberC = 0;
//				s.mis = s.calculeMIS();
//				s.phase2();
//				UnitDisk.compp2 = s.phase3();
//				s.phase3_b(UnitDisk.compp2);
//				s.phase4();
//				s.getBlackCompInCompConnx();
//				s.phase4_Version2();				
//				s.miniServeur();
//				if (s.verifier()) {	
//					ok = true;
//					int hg=0;
//					for(int j=0;j<s.col.size();j++)
//					{
//						if(s.col.get(j).equals("black"))
//						{
//							hg++;
//						}
//					}
//					 series2.getData().add(new XYChart.Data(s.nodes.get(0).getR(), hg));
//					 d.add(hg);
//				} 
				
			}
			Serveur2.data.put(3, d);
	        Scene scene  = new Scene(lineChart,300,300);
	        lineChart.getData().addAll(series,series2,series3);
	     
	        lineChart.setCreateSymbols(false);
	        stage.setScene(scene);
	       
	        stage.show();
	  }
	  
	  @SuppressWarnings({ "unchecked", "rawtypes" })
		@Override 
		public void start(Stage stage) throws Exception{
       plot(stage);
        

    }

	
	  
}
