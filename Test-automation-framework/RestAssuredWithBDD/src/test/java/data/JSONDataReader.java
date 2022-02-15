package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class JSONDataReader {
	public String baseURL,path , agent ,systemInfo,
	attributeName;
	public void jsonReader() throws FileNotFoundException, IOException, ParseException {
		
		String filePath = System.getProperty("user.dir")+"/src/test/java/data/UserData.json";
		File srcFile = new File(filePath);
		JSONParser parser = new JSONParser();
		JSONArray jArray = (JSONArray) parser.parse(new FileReader(srcFile));
		for (Object jsonObj : jArray) {
			
			JSONObject user =  (JSONObject) jsonObj;
			baseURL = (String) user.get("baseURL");
			//System.out.println(baseURL);
			
			path = (String) user.get("path");
			//System.out.println(path);

			agent= (String) user.get("agent");
			//System.out.println(agent);

			systemInfo = (String) user.get("systemInfo");
			//System.out.println(systemInfo);
			
			attributeName = (String) user.get("attributeName");
		


		}

	}
}
