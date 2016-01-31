package iprocess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;

import base.BaseDao;
import base.IProcess;
import base.MyPoint;

public class GetNearShops extends BaseDao implements IProcess{
	
	@Override
	public JSONArray processer(Map<String, String> map) {
		// TODO Auto-generated method stub
		double x=Double.parseDouble(map.get("x"));
		double y=Double.parseDouble(map.get("y"));
		int n1=Integer.parseInt(map.get("m"));
		int n2=Integer.parseInt(map.get("n"));
		
		MyPoint p=new MyPoint(-1,x,y);
		List<MyPoint> allPoints=new ArrayList<MyPoint>();
		List<Map<String,String>> allShops = null;
		//
		allShops =super.quryBySql2("select * from shop where shopid between "+n1+" and "+n2);
		
		
		for(Map<String,String>m:allShops){
			MyPoint tmp=new MyPoint(Integer.parseInt(m.get("shopid")),
					Double.parseDouble(m.get("longtitude")),
					Double.parseDouble(m.get("latitude")));			
					allPoints.add(tmp);
		}
		String sql=null;
		List<Map<String,String>> result=new ArrayList<Map<String,String>>();
		for(MyPoint mp:p.getNearPoint(allPoints, n2-n1)){
			sql="select * from shop where shopid =";
			sql=sql+mp.getId();
			result.add(super.quryBySql1(sql));
		}		 
		return super.toJSON(result);
	}

}
