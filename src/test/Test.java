package test;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import networks.Mediator;

public class Test {
	public static void main(String args[]){
		JSONArray jsonarray=new JSONArray();
		JSONObject jo=new JSONObject();
		try {
			jo.put("name", "mike");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jsonarray.put(jo);
		Mediator m=new Mediator("TestProcesser",jsonarray.toString() );
		m.process();
		
	}
}
