import java.util.ArrayList;
import java.util.List;


public class Node implements Comparable<Node>{

	/**
	 * @param args
	 */
	private Circle circle;
	private List<Node> neighor ;
	private double r;
	private int id;
	private long IdMap;
	public long getIdMap() {
		return IdMap;
	}
	public void setIdMap(long idMap) {
		IdMap = idMap;
	}
	private String status;
	private double score;
	private ArrayList<Integer> Int=new ArrayList();;
	public ArrayList<Integer> getInt() {
		return Int;
	}
	public void setInt(ArrayList<Integer> i) {
		Int = i;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public int compareTo(Node compareFruit) {
		
		double compareQuantity =  compareFruit.getScore(); 
		
		return (int)compareQuantity - (int)this.score;
	
		
	}	
	@Override
	public String toString() {
		return "node [r=" + r + ", id=" + id + ", status=" + status
				+ ", score=" + score + ", ptX=" + ptX + ", ptY=" + ptY + "]";
	}

	public Node(int id, double ptX, double ptY, double r,String s) {
		super();
		this.neighor= new ArrayList<Node>();
		Vector2 v = new Vector2(ptX, ptY);
		this.circle = new Circle(v, r);
		this.id = id;
		this.ptX = ptX;
		this.ptY = ptY;
		this.r = r;
		this.status=s;
		this.score=0.0;
		this.IdMap=0;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getR() {
		return r;
	}
	public void setR(double r) {
		this.r = r;
	}
	public double getPtX() {
		return ptX;
	}
	public void setPtX(double ptX) {
		this.ptX = ptX;
	}
	public double getPtY() {
		return ptY;
	}
	public void setPtY(double ptY) {
		this.ptY = ptY;
	}
	public Circle getCircle() {
		return this.circle;
	}
	public void addNeibghour(Node node){
		this.neighor.add(node);
		
	}
	private double ptX,ptY;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
