import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.util.*;
import java.util.List;
import javax.swing.*;
  
  
class PointPanel extends JPanel
{
    List pointList;
    List pointList2;
    JFrame f = new JFrame();
    JPanel panel;
    Color selectedColor;
    Ellipse2D selectedPoint;
    static boolean nodes=false;
    static boolean ZoneIn=false;
    static final ConfigurationDraw d=new ConfigurationDraw();
	void start()
	{
        
	}
    public PointPanel()
    {
    	f.getContentPane().add(this);
        f.setSize(1010,690);
        f.setLocation(10,10);
        f.setVisible(true);
        pointList = new ArrayList();
        pointList2 = new ArrayList();
        selectedColor = Color.red;
        addMouseListener(new PointLocater(this));
        setBackground(Color.white);
        this.setBounds(5, 11, 1000, 680);
        setLayout(null);
        
		d.start();
        JButton btnNewButton = new JButton("Start");
        JButton btnNewButton_1 = new JButton("Configuration");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	
        		d.start();
        	}
        });
        
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		Configuration.AddManual.setSelected(true);
        		Serveur2.clear();
        		UnitDisk.pointPanel.clear();
        		Serveur2.nbtotal=0;
        		Ellipse2D e;
        	
        		Serveur2.nodes.clear();
        		for(int i=0;i<pointList.size();i++)
        		{
        			ArrayList<Integer> s=new ArrayList<Integer>();
        			
        			 e = (Ellipse2D)pointList.get(i);
        			 Node nn = new Node(i, (int)e.getCenterX(),
							(int)e.getCenterY(), 100,
							"nodes");
        			 Serveur2.nodes.add(nn);
        			 Serveur2.HashM.put(i, s);
        			 s = new ArrayList<Integer>();
        			 Serveur2.nbtotal++;
        		}
        		for(int i=0;i<pointList2.size();i++)
        		{	
       			 e = (Ellipse2D)pointList2.get(i);
       			 Node nn = new Node(i, (int)e.getCenterX(),
							(int)e.getCenterY(), 120,
							"PointInt");
       			Serveur2.zoneInt.add(nn);
        		}
        		Serveur2.test(100, 120, 150, 5);
        		UnitDisk.pointPanel.plot_phase1();
        		UnitDisk.pointPanel.setBounds(5, 11, 1000, 680);
				Serveur2.numberC = 0;
				UnitDisk.model.setRowCount(0);
        		UnitDisk.click="";
        		UnitDisk.btnNewButton_1.doClick();
        		UnitDisk.click = "Phase1";	
        		UnitDisk.conf.chckbxNewCheckBox.setEnabled(true);
        		UnitDisk.conf.chckbxNewCheckBox_1.setEnabled(true);
        		UnitDisk.conf.chckbxNewCheckBox_2.setEnabled(true);
        		UnitDisk.s.mis = UnitDisk.s.calculeMIS();
        		UnitDisk.btnPhase.setEnabled(false);
        		UnitDisk.btnNewButton_2.setEnabled(true);
        		UnitDisk.btnPhase_2.setEnabled(false);
        		UnitDisk.btnPhaseb.setEnabled(false);
        		
        		OFF();
        		d.OFF();
        		Configuration.AddManual.setSelected(false);
        	}
        });
        f.addComponentListener(new ComponentAdapter() {
            public void componentMoved(ComponentEvent e) {
              
                int x=(int)f.getLocation().getX()+700;
                int y=(int)f.getLocation().getY()+300;
               d.frame.setLocation(x,y);
            }
        });
        btnNewButton.setBounds(540, 585, 89, 23);
        btnNewButton_1.setBounds(416, 585, 114, 23);
        add(btnNewButton);
        add(btnNewButton_1);
        f.setResizable(false);
    }
  void OFF()
  {
	  f.dispose();
	  f.setVisible(false);
  }
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        Ellipse2D e;
        Color color;
        for(int j = 0; j < pointList.size(); j++)
        {
            e = (Ellipse2D)pointList.get(j);
          
            color = Color.blue;
            g2.setPaint(color);
            g2.fill(e);
        }
        for(int j = 0; j < pointList2.size(); j++)
        {
            e = (Ellipse2D)pointList2.get(j);
            color = Color.RED;
            g2.setPaint(color);
            g2.fill(e);
        }
    }
  
    public List getPointList()
    {
        return pointList;
    }
    public List getPointList2()
    {
        return pointList2;
    }
    public void setSelectedPoint(Ellipse2D e)
    {
        selectedPoint = e;
        repaint();
    }
  
    public void addPoint(Point p)
    {
        Ellipse2D e = new Ellipse2D.Double(p.x - 3, p.y - 3, 10, 10);
        pointList.add(e);
        selectedPoint = null;
        repaint();
    }
    public void addPoint2(Point p)
    {
        Ellipse2D e = new Ellipse2D.Double(p.x - 3, p.y - 3, 10, 10);
        pointList2.add(e);
        selectedPoint = null;
        repaint();
    }
}
  
class PointLocater extends MouseAdapter
{
    PointPanel pointPanel;
  
    public PointLocater(PointPanel pp)
    {
        pointPanel = pp;
    }
  
    public void mousePressed(MouseEvent e)
    {
    	
        Point p = e.getPoint();
        List list =null;
       
        if(PointPanel.nodes){
        list = pointPanel.getPointList();
        pointPanel.addPoint(p);
     
        }
        else if(PointPanel.ZoneIn)
        {
        	list = pointPanel.getPointList2();
        	pointPanel.addPoint2(p);
        	 
        }
       
      
    } 
    
}