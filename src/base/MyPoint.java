package base;
/*
 * this application program calculate the distance,the shortest distance of two point,and the top n near points.
 * Create on 2016-1-25
 * by liuwencai
 */
import java.util.ArrayList;
import java.util.List;

public class MyPoint {
	//the id of the point
	int id;
	//the x coordinate of the point
	double x;
	//the y coordinate of the point
	double y;
	/**
	 * Main method
	 * @param id:the id of point
	 * @param x:the x coordinate of the point
	 * @param y:the y coordinate of the point
	 */
	public MyPoint(int id,double x,double y){
		this.id=id;
		this.x=x;
		this.y=y;
	}
	
	
	//the get method of x coordinate
	public double getX() {
		return x;
	}
	
	
	//the set method of x coordinate
	public void setX(double x) {
		this.x = x;
	}
	
	
	public double getY() {
		return y;
	}
	
	
	//the set method of y coordinate
	public void setY(double y) {
		this.y = y;
	}
	
	
	//the get method of id
	public int getId() {
		return id;
	}
	
	
	//the set method of id
	public void setId(int id) {
		this.id = id;
	}


	/**
	 * get distance of this point to another point
	 * @param point:the target point
	 * @return the distance of two point
	 */
	public double getDistance(MyPoint point){
		return Math.sqrt(Math.pow(this.x-point.getX(),2)+Math.pow(this.y-point.getY(),2));
	}

	/**
	 * get Shortest point of this point to others 
	 * @param list :the range of points
	 * @param excepts : excluded points
	 * @return a nearest point in the distance
	 */
	private MyPoint getShortestPoint(List<MyPoint> list,List<MyPoint>  excepts){
		//a temp point
		MyPoint mp=this;
		//set a distance to min
		double min=this.getDistance(list.get(0));
		//dell with each point in the list
		for(MyPoint p:list){
			//find the shortest distance,and remember it to mp
			if(min>this.getDistance(p)&&!find(excepts,p)){
				min=this.getDistance(p);
				mp=p;
			}
		}
		//return the nearest point
		return mp;
	}


	/**
	 * find whether to contain a point
	 * @param list:the search range
	 * @param p:the target point
	 * @return contains or not
	 */
	private boolean find(List<MyPoint> list,MyPoint p){
		//dell with each point in the list
		for(MyPoint o :list){
			//Weather it  contains the point p or not
			if(o.getId()==p.getId()){
				//got it,and return true to the program
				return true;
			}
		}
		return false;
	}


	/**
	 * get the top n points of nearest distance
	 * @param list:the search range
	 * @param n:search number
	 * @return the top n points of nearest distance
	 */
	public List<MyPoint> getNearPoint(List<MyPoint> list,int n){
		//Weather the the size of list less then n 
		if(n>list.size()){
			//reset the n
			n=list.size();
		}
		//the points to record the shortest points
		List<MyPoint> points = new ArrayList<MyPoint>();
		for(int i=0;i<n;i++){
			//record the shortest points
			points.add(this.getShortestPoint(list,points));
		}
		return points;

	}

	/*
	 * to override super class(Object)
	 * 
	 */
	@Override
	public String toString(){
		// return  the describe of this  current point
		return "id="+this.getId()+":("+this.getX()+","+this.getY()+")\n";
	}


}
