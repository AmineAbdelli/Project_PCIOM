import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Vector;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import javax.swing.JFrame;


public class Stage_ZoneInt extends Application{
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
	        final NumberAxis xAxis = new NumberAxis();
	        final NumberAxis yAxis = new NumberAxis();
	        xAxis.setLabel("Number of Month");
	        //creating the chart
	        final LineChart<Number,Number> lineChart = 
	                new LineChart<Number,Number>(xAxis,yAxis);
	                
	        lineChart.setTitle("Stock Monitoring, 2010");
	        //defining a series
	        XYChart.Series series = new XYChart.Series();
	        series.setName("Initial");
	        //populating the series with data
	        XYChart.Series series2 = new XYChart.Series();
	        series2.setName("Modifier");
			boolean ok = true;
			int r=120;
			for (int startt = 0; startt <= 50 && ok; startt++) {
				final int val = startt;
				Serveur2.clear();
				s.test(80, r, 500, 5);
				
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
					 series.getData().add(new XYChart.Data(r, hg));
					 r=r+10;
				} 
				
			}
			ok = true;
			r=120;
			for (int startt = 0; startt <= 50 && ok; startt++) {
				final int val = startt;
				Serveur2.clear();
				s.test(80, 120, 500, 5);
				Serveur2.numberC = 0;
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
					 series2.getData().add(new XYChart.Data(r, hg));
					 r=r+10;
				} 
				
			}
	        Scene scene  = new Scene(lineChart,300,300);
	        lineChart.getData().addAll(series,series2);
	        stage.setScene(scene);
	        stage.show();
	  }
	  @SuppressWarnings({ "unchecked", "rawtypes" })
		@Override public void start(Stage stage) {
       plot(stage);
        

    }
}
