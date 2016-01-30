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
		switch(cmd){
//		case "LoginProcesser":
//			p=new LoginProcesser();
//			break;
//		case "RegesterProcesser":
//			p=new RegesterProcesser();
//			break;
//		case "GetGoodsInfoProcesser":
//			p=new GetGoodsInfoProcesser();
//			break;
//		case "GetSimiarGoodsInNearShopProcesser":
//			p=new GetSimiarGoodsInNearShopProcesser();
//			break;
//		case "GetTypeListProcesser":
//			p=new GetTypeListProcesser();
//			break;
//		case "UpdateGoodsInfoProcesser":
//			p=new UpdateGoodsInfoProcesser();
//			break;
//		case "GetNearMostPriceGoods":
//			p=new GetNearMostPriceGoods();
//			break;
//		case "GetUserInfoProcesser":
//			p=new GetUserInfoProcesser();
//			break;
//		case "UpdateUserInfoProcesser":
//			p=new UpdateUserInfoProcesser();
//			break;
		 
		
			}
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
