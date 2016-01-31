package networks;



import org.json.JSONArray;
import org.json.JSONException;

import base.BaseDao;
import base.IProcess;


public class Mediator extends BaseDao{
	String cmd;
	String jsonStr;
	IProcess p;
	public Mediator(String cmd,String jsonStr){
		this.cmd=cmd;

		this.jsonStr=jsonStr;
		p= createProcess(cmd);
	}
	protected IProcess createProcess(String className)  
	{
		IProcess p = null;
		 
			try {
				Class xmlmenu = Class.forName("iprocess."+className);
				 
				p  = (IProcess) xmlmenu.newInstance();
			} catch (ClassNotFoundException | InstantiationException
					| IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 
		return p ;
	}

	public  JSONArray process(){
		JSONArray jsa = null;
		try {
			jsa=new JSONArray(jsonStr);

		} catch (JSONException e) {

			e.printStackTrace();
		}	 

		return p.processer(super.toMap(jsa.toString()));		
	}
}
