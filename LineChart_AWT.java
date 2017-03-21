import javafx.scene.chart.XYChart;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart_AWT extends ApplicationFrame
{
   public LineChart_AWT( String applicationTitle , String chartTitle )
   {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle,
         "Years","Number of Schools",
         createDataset(),
         PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel( lineChart );
      chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
      setContentPane( chartPanel );
   }

   private DefaultCategoryDataset createDataset( )
   {
      DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
    //  dataset.addValue( 15 , "schools" , "1970" );
    
      Serveur2 s=new Serveur2();
      boolean ok = true;
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
				dataset.addValue(startt,"", ""+hg);
			} 
			
		}

      return dataset;
   }
   public static void main( String[ ] args ) 
   {
      LineChart_AWT chart = new LineChart_AWT(
      "School Vs Years" ,
      "Numer of Schools vs years");
      chart.pack( );
      RefineryUtilities.centerFrameOnScreen( chart );
      chart.setVisible( true );
     
      
   }
}