package iprocess;

import java.util.Map;

import org.json.JSONArray;

import base.IProcess;

public class TestProcesser implements IProcess {

	@Override
	public JSONArray processer(Map<String, String> map) {
		// TODO Auto-generated method stub
		System.out.println("hello world!"+map.get("name"));
		return null;
	}

}
