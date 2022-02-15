package pages;
import java.util.List;

import io.restassured.response.ResponseBodyExtractionOptions;

public class GetAttributeValue  {
	public List<String> attributeValue;
	PageBase pageBase;

	public List<String> getSpecifecAttributeValue(String attributeName, ResponseBodyExtractionOptions response) {

		pageBase = new PageBase();
		return attributeValue = response.xmlPath().getList(attributeName);
	}
	
}
