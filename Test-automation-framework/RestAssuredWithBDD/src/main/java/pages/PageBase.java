package pages;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PageBase {
	Response response, s;
	protected String path;
	public List<String> attributeValue ;

	public void setBaseURL(String url) {
		RestAssured.baseURI=(url);

	}
	public String setPath(String path) {
		return this.path = path;		

	}

	public Response getPageResponse(String path ,String agent , String systemInfo) {
		
		return  RestAssured
				.given().contentType(ContentType.XML).header(agent, systemInfo)
				.get(path)
				.then().extract().response();
		
	}


}

	

	
	


