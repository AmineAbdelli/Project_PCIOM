import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.TimerTask;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Control;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.sun.net.ssl.internal.www.protocol.https.Handler;

class PointPanelC extends JPanel  {
	
	
//	 int imageX = 700, imageY = 700;
//	    int lastMouseX = 0, lastMouseY = 0;
//	    int centerX = 225;
//	    int centerY = 225;
//	    int canvasWidth = this.getWidth();
//	    int canvasHeight = this.getHeight();
//	    double scaleFactor = 1.0;
//	    boolean firstMouseDrag = true;
	static boolean finish=false;
	static boolean drawImg=false;
	static boolean draw=false;
	static int circleV,circleVI;
	static HashMap<Integer, Circle> point = new HashMap<Integer, Circle>();
	static HashMap<Integer, Circle> pointInt = new HashMap<Integer, Circle>();
	static List pointList;
	static List pointList2;
	static List pointList3;
	static ArrayList<Circle> c1 = new ArrayList<Circle>();
	static ArrayList<Circle> c2 = new ArrayList<Circle>();
	static ArrayList<Circle> c3 = new ArrayList<Circle>();
	 Graphics2D g2=null;
	Color selectedColor;
	boolean re = true;
	static Ellipse2D selectedPoint;
	  private static int x = 0;
      private static int y = 100;
      private static int mousex = 0;
      private static int mousey = 0;
      private static int radius = 20;
      private static int xDelta = 2;
      private static int yDelta = 2;
	public PointPanelC() {
				
		plot_phase1();
		
	}
	
	void clear()
	{
		pointList.clear();
		pointList2.clear();
		pointList3.clear();
		c1.clear();
		c2.clear();
		c3.clear();
		point.clear();
		pointInt.clear();
		
	}
	void plot_phase1()
	{
		pointList = new ArrayList();
		pointList2 = new ArrayList();
		pointList3 = new ArrayList();
		MouseMotionHandler mouseHandler = new MouseMotionHandler();
	    addMouseMotionListener(mouseHandler);
	    addMouseListener(mouseHandler);
	    addMouseWheelListener(mouseHandler);
		selectedColor = Color.red;
		setBackground(Color.white);
		this.setSize(200, 200);
		setAllPoint();
		setAllPointInte();
		this.setBounds(10, 0, 1043, 658);
	//	movingCircle();
	}
	
	protected void paintComponent(Graphics g) {
		if(!finish){
		super.paintComponent(g);
		g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		drawImg();
			function1(g2);
			function3(g2);
			function2(g2);	
			function4(g2);
			draw();
			clickm();
			
		}
			//Dimension d=new Dimension();
		//	d.setSize(imageX, imageY);
	//	this.setSize(d);
	//	movingCircle();
	  //  Ellipse2D ef = new Ellipse2D.Double(x, y - radius,radius * 2, radius * 2);
	  
        //  g2.setPaint(Color.BLACK);
         // g2.fill(ef);
	}

	private void clickm() {
		// TODO Auto-generated method stub
		if(UnitDisk.AddMan)
		{
			Ellipse2D ef = new Ellipse2D.Double(mousex+10, mousey+10 ,10, 10);
		    g2.setPaint(Color.BLACK);
		    g2.fill(ef);
		}
		
	}

	void showInt()
	{
		
			function3(g2);
     
	}
	void showIntt()
	{
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				  try {
	                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
	                }
				
				  showInt();
			}
		});
		
		
	}
	public static List getPointList() {
		return pointList;
	}

	public static List getPointList2() {
		return pointList2;
	}

	public static List getPointList3() {
		return pointList3;
	}

	public static void setSelectedPoint(Ellipse2D e) {
		selectedPoint = e;

	}

	public static void addPoint(Circle p) {
		Ellipse2D e = new Ellipse2D.Double(p.getCenterX() - 3,
				p.getCenterY() - 3, 15, 15);
		c1.add(p);
		pointList.add(e);
		selectedPoint = null;

	}

	public static void addPoint2(Circle p) {
		Ellipse2D e = new Ellipse2D.Double(p.getCenterX() - 3,
				p.getCenterY() - 3, 15, 15);
		pointList2.add(e);
		c2.add(p);
		selectedPoint = null;

	}

	public static void addPoint3(Circle p) {
		Ellipse2D e = new Ellipse2D.Double(p.getCenterX() - 3,
				p.getCenterY() - 3, 15, 15);
		c3.add(p);
		pointList3.add(e);
		selectedPoint = null;

	}

	public static void setAllPoint() {
		for (int i = 0; i < Serveur2.nodes.size(); i++) {

			Circle p = new Circle(Serveur2.nodes.get(i).getPtX() + 10,
					Serveur2.nodes.get(i).getPtY() + 10, Serveur2.nodes.get(i)
							.getR());
			point.put(i, p);

			p.setId(Serveur2.nodes.get(i).getId() + "");
			if (Serveur2.nodes.get(i).getScore() != 0) {
				
				List list = getPointList();
				addPoint(p);
			} else {
				addPoint3(p);
			}
		}

	}

	public static void setAllPointInte() {
		for (int i = 0; i < Serveur2.zoneInt.size(); i++) {
			Circle p = new Circle(Serveur2.zoneInt.get(i).getPtX() + 10,
					Serveur2.zoneInt.get(i).getPtY() + 10, Serveur2.zoneInt
							.get(i).getR());
			pointInt.put(i, p);
			p.setId(Serveur2.nodes.get(i).getId() + "");
			boolean haveSelection = false;
			List list = getPointList2();
			addPoint2(p);
		}

	}

	public void movingCircle() {
		  
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				  try {
	                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
	                }
				
                T();
                
			}
		});
	}


	
	public void T() {

		
                  x += xDelta+10;
                  if (x + (radius *2) > 1000) {
                      x = 10 - (radius*2 );
                      xDelta *= -1;
                  } else if (x < 0) {
                      x = 0;
                      xDelta *= -1;
                  }
                  y += yDelta+10;
                  if (y + (radius *2) > 680) {
                      y = 10 - (radius*2 );
                      yDelta *= -1;
                  } else if (x < 0) {
                      y = 0;
                      yDelta *= -1;
                  }
                  
                  
                  
                  repaint();
           try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
	
		
	}
	

	
	void function1(final Graphics2D g2 )
	{
		

				  Ellipse2D e;
					 Color color = null;
					 String s=UnitDisk.click;
					 if(UnitDisk.click.equals("Phase1"))
						 color = Color.blue;
					 else if (UnitDisk.click.equals("Phase2"))
						 color = Color.GRAY;
					for (int j = 0; j < pointList.size(); j++) {
						e = (Ellipse2D) pointList.get(j);
					if(s.equals("Phase1"))
					{
						if(Serveur2.mis.contains(Integer.parseInt(c1.get(j).getId())))
							{
							 color = Color.BLACK;
							
							}
						else
							color = Color.BLUE;
						
							g2.setPaint(color);
							g2.fill(e);
					}else if (s.equals("Phase2")){
						//if(serveur.mis.contains(Integer.parseInt(c1.get(j).getId())))
						if(Serveur2.col.get(Integer.parseInt(c1.get(j).getId()))=="black")
						{
							color = Color.BLACK;;
							g2.setPaint(color);
							g2.fill(e);
						}
						else if (Serveur2.col.get(Integer.parseInt(c1.get(j).getId()))=="white")
								{color = Color.RED;
								g2.setPaint(color);
								g2.fill(e);
							
								}
							else if(Serveur2.col.get(Integer.parseInt(c1.get(j).getId()))=="gray")
							{
								color = Color.GRAY;
								g2.setPaint(color);
								g2.fill(e);
							}
						}
					if(s!=""){
						color = Color.BLACK;
						g2.setPaint(color);
						double d = c1.get(j).getCenterX();
						int d1 = (int) d - 2;
						double ds = c1.get(j).getCenterY();
						int d2 = (int) ds;
					//	g2.drawString(c1.get(j).getId() + "", (int) d1, (int) d2);
					}
						
					}
					repaint();

			
		
	
				
	}
	
	void function2(final Graphics2D g2 )
	{
		

				 Ellipse2D e;
				 Color color = null;
				 String s=UnitDisk.click;
				 if(UnitDisk.click.equals("Phase1"))
					 color = Color.black;
				 else if (UnitDisk.click.equals("Phase2"))
					 color = Color.GRAY;
				 for (int j = 0; j < pointList3.size(); j++) {
						e = (Ellipse2D) pointList3.get(j);
						//color = Color.black;
						//	color = Color.blue;
						//color = Color.GRAY;
						if(s.equals("Phase1"))
						{
						if(Serveur2.mis.contains(Integer.parseInt(c3.get(j).getId())))
						{
							 color = Color.black;
							 g2.setPaint(color);
							 g2.fill(e);
						}
						else
							{
							color = Color.BLUE;
							g2.setPaint(color);
							g2.fill(e);
							}
						}
						else if(s.equals("Phase2")) {
						if(Serveur2.col.get(Integer.parseInt(c3.get(j).getId()))=="black")
						{
							color = Color.BLACK;;
							g2.setPaint(color);
							g2.fill(e);
						}
						else if (Serveur2.col.get(Integer.parseInt(c3.get(j).getId()))=="white")
							{
							color = Color.RED;
							g2.setPaint(color);
							g2.fill(e);
								}
						else if(Serveur2.col.get(Integer.parseInt(c3.get(j).getId()))=="gray")
							{
							color = Color.GRAY;
							g2.setPaint(color);
							g2.fill(e);
							}
						}
						if(s!=""){
						color = Color.BLACK;
						g2.setPaint(color);
						double d = c3.get(j).getCenterX();
						int d1 = (int) d - 2;
						double ds = c3.get(j).getCenterY();
						int d2 = (int) ds;
						//g2.drawString(c3.get(j).getId() + "", (int) d1, (int) d2);
						}
					}
				
				 repaint();

				 
		
	}
	void function3(final Graphics2D g2)
	{

		if(UnitDisk.checkBox)
		{
			
				 Ellipse2D e;
				 Color color;
				for (int j = 0; j < pointList2.size(); j++) {
					e = (Ellipse2D) pointList2.get(j);
					color = Color.red;
					g2.setPaint(color);
					g2.fill(e);
					Circle c=c2.get(j);
			//		g2.drawOval((int)c.getCenterX()-10, (int)c.getCenterY()-10, 80, 80);
					g2.drawOval((int)c.getCenterX()-145, (int)c.getCenterY()-145, 300, 300);
					color = Color.BLACK;
					g2.setPaint(color);
					double d = c2.get(j).getCenterX();
					int d1 = (int) d - 2;
					double ds = c2.get(j).getCenterY();
					int d2 = (int) ds;
				//	g2.drawString(c2.get(j).getId() + "", (int) d1, (int) d2);
				}
				 repaint();
		}
		
			
	}

	void function4(final Graphics2D g2)
	{

		
				if(UnitDisk.cnnx)
				{
					
				
				Color color = null;
					Object[] k = Serveur2.HashM.keySet().toArray();
					for (int i = 0; i < Serveur2.HashM.size(); i++) {
						boolean black=false;
						if(Serveur2.col.get(i)!=null && Serveur2.col.get(i).equals("black"))
						{
							black=true;
						}
						int s = (Integer) k[i];
						ArrayList<Integer> a = new ArrayList<Integer>();
						a = Serveur2.HashM.get(i);
						for (int j = 0; j < a.size(); j++) {
							if(black)
								if(Serveur2.col.get(a.get(j)).equals("black"))
									{color=Color.RED;
										g2.setStroke(new BasicStroke(6f));
										
									}
								else
									{
									
									color = Color.green;
									g2.setStroke(new BasicStroke(1f));
									
									
									}
							else
								{
								
								color = Color.green;
								g2.setStroke(new BasicStroke(1f));
								
								}
							g2.setPaint(color);
							
							g2.drawLine((int)Serveur2.nodes.get(s).getPtX() + 12,(int) Serveur2.nodes
									.get(s).getPtY() + 12, (int)Serveur2.nodes.get(a.get(j))
									.getPtX() + 12,
									(int)Serveur2.nodes.get(a.get(j)).getPtY() + 12);
									

						}
						
					}
					repaint();
				}	
				else if(Serveur2.phase5)
				{
					boolean d=false;
					Color color = null;
						Object[] k = Serveur2.HashM.keySet().toArray();
						for (int i = 0; i < Serveur2.HashM.size(); i++) {
							boolean black=false;
							if(Serveur2.col.get(i)!=null && Serveur2.col.get(i).equals("black"))
							{
								black=true;
							}
							int s = (Integer) k[i];
							ArrayList<Integer> a = new ArrayList<Integer>();
							a = Serveur2.HashM.get(i);
							for (int j = 0; j < a.size(); j++) {
								if(black)
									if(Serveur2.col.get(a.get(j)).equals("black"))
										{color=Color.RED;
											g2.setStroke(new BasicStroke(6f));
											d=true;
										}
									else
										{
										if(Serveur2.phase5 && Serveur2.backB.get(i)!=null && Serveur2.backB.get(i).equals(a.get(j)))
										{
										color = Color.green;
										g2.setStroke(new BasicStroke(1f));
										d=true;
										}
										}
								else
									{
									if(Serveur2.phase5 && Serveur2.backB.get(i)!=null && Serveur2.backB.get(i).equals(a.get(j)))
									{
									color = Color.green;
									g2.setStroke(new BasicStroke(1f));
									d=true;
									}}
								if(d)g2.setPaint(color);
								
								if(d)g2.drawLine((int)Serveur2.nodes.get(s).getPtX() + 12, (int)Serveur2.nodes
										.get(s).getPtY() + 12, (int)Serveur2.nodes.get(a.get(j))
										.getPtX() + 12,
										(int)Serveur2.nodes.get(a.get(j)).getPtY() + 12);
								d=false;

							}
							
						}
						repaint();
				}
				else if(UnitDisk.onlyB)
				{
					boolean d=false;
					Color color = null;
			Object[] k = Serveur2.HashM.keySet().toArray();
					for (int i = 0; i < Serveur2.HashM.size(); i++) {
						boolean black=false;
						if(Serveur2.col.get(i)!=null && Serveur2.col.get(i).equals("black"))
						{
							black=true;
						}
						int s = (Integer) k[i];
						ArrayList<Integer> a = new ArrayList<Integer>();
						a = Serveur2.HashM.get(i);
						for (int j = 0; j < a.size(); j++) {
							if(black)
								if(Serveur2.col.get(a.get(j)).equals("black"))
									{color=Color.RED;
										g2.setStroke(new BasicStroke(6f));
										//black=true;

										g2.setPaint(color);
										
										g2.drawLine((int)Serveur2.nodes.get(s).getPtX() + 12, (int)Serveur2.nodes
												.get(s).getPtY() + 12, (int)Serveur2.nodes.get(a.get(j))
												.getPtX() + 12,
												(int)Serveur2.nodes.get(a.get(j)).getPtY() + 12);
									}
								
							
							

						}
						
					}
					repaint();
				}

			
		  
		
		
}
	class MouseMotionHandler extends MouseMotionAdapter implements
	MouseListener, MouseWheelListener {

	public void mousePressed(MouseEvent e) {
		
	}

	public void mouseDragged(MouseEvent e) {
		
	}


	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		super.mouseMoved(arg0);
		if(UnitDisk.viewID){
		x=arg0.getX();
		y=arg0.getY();
		draw=false;
		for(int i=0;i<point.size();i++)
		{
			if((point.get(i).getCenterX()-7)<x && x<(point.get(i).getCenterX()+7)){
			if((point.get(i).getCenterY()-7)<y && y<(point.get(i).getCenterY()+7))
				{
					circleV=i;
					draw=true;
					circleVI=-1;
				}
		
			}
			
			
		}
		for(int i=0;i<pointInt.size();i++)
		{
			if((pointInt.get(i).getCenterX()-7)<x && x<(pointInt.get(i).getCenterX()+7)){
			if((pointInt.get(i).getCenterY()-7)<y && y<(pointInt.get(i).getCenterY()+7))
				{
					circleVI=i;
					draw=true;
					circleV=-1;
				}
		
			}
			
			
		}
		
		}
	}

	public void mouseWheelMoved(MouseWheelEvent e) {
		
	}
	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		if(UnitDisk.AddMan)
		{
			
			int x=e.getX();
			int y=e.getY();
			mousex=x;
			mousey=y;
			
			Node nn = new Node(Serveur2.HashM.size(), x,
					y, 100,
					"nodes");
			ArrayList<Integer> s = new ArrayList<Integer>();
			Serveur2.HashM.put(Serveur2.HashM.size(), s);
			s = new ArrayList<Integer>();
			Serveur2.nbtotal++;
			Serveur2.nodes.add(nn);
			//UnitDisk.pointPanel.plot_phase1();
			//UnitDisk.pointPanel.setBounds(5, 11, 761, 680);
		    clickm();
		}
		
		
	}

	}
	public void draw() {
		// TODO Auto-generated method stub
		if(draw){
		
   		Ellipse2D ef = new Ellipse2D.Double(x, y ,100, 100);
   	 BufferedImage img = null;
     try {
         img = ImageIO.read(new File("rectangle.png"));
     } catch (IOException e) {
     }
     Graphics g = img.getGraphics();
     	g2.drawImage(img,x,y, this);
   		g2.setPaint(Color.RED);
   		int n=0;
   		if(circleV!=-1){
   		g2.drawString("Point "+point.get(circleV).getId(), x+10, y+15);
   		if(Serveur2.backB.get(circleV)!=null)
   			{
   			//g2.drawString("Cnnx->"+serveur.backB.get(circleV)+" Score : "+serveur.nodes.get(circleV).getScore(), x+2, y+27
   				//	);
   			}
   		else 
   			if(Serveur2.col.get(circleV)!=null && Serveur2.col.get(circleV).equals("black"))
   					//g2.drawString("BackB", x+2, y+27);
   		repaint();
		}else
		{
			g2.drawString("Point "+pointInt.get(circleVI).getId(), x+10, y+15);
	   		
	   		repaint();
		}
		}
		
	}
	public  void drawImg() {
		if(drawImg)
		{
			 BufferedImage img = null;
		     try {
		         img = ImageIO.read(new File("bb.png"));
		     } catch (IOException e) {
		     }
	
		g2.drawImage(img,0,0,this);
		}
	}
	
}
