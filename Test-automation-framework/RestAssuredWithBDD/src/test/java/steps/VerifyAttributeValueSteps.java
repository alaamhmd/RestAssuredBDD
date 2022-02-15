package steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.parser.ParseException;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pages.GetAttributeValue;
import pages.PageBase;
import data.JSONDataReader;

public class VerifyAttributeValueSteps extends PageBase {
	
	PageBase pageBase;
	GetAttributeValue getAttributeValue;
	JSONDataReader jsonReader;
	Response response;
	SoftAssert softAssert;

	@Given("API URL")
	public void api_url() throws FileNotFoundException, IOException, ParseException {
		pageBase = new PageBase();
		getAttributeValue = new GetAttributeValue();
		jsonReader = new JSONDataReader();
		jsonReader.jsonReader();
		pageBase.setBaseURL(jsonReader.baseURL);
		path = pageBase.setPath(jsonReader.path);
	}

	@When("We send a get request to get response")
	public void we_send_a_get_request_to_get_response() throws FileNotFoundException, IOException, ParseException {

		response =pageBase.getPageResponse(path, jsonReader.agent,jsonReader.systemInfo );

	}

	@Then("We will check that value of numViews is greater than {int}")
	public void we_will_check_that_value_of_num_views_is_greater_than(Integer desiredValue) {

		softAssert = new SoftAssert();
		attributeValue = getAttributeValue.getSpecifecAttributeValue(jsonReader.attributeName, response);

		List<Integer> numViewsLessThan4000 = new ArrayList<Integer>();
		List<Integer> numViewsMoreThan4000 = new ArrayList<Integer>();
		int sizeOfNumViewsMoreThan4000List ;
		int sizeOfNumViewsLessThan4000List;
		int sizeOfNumViewsList;

		sizeOfNumViewsList = attributeValue.size();

		for (String i : attributeValue) { 
			int attributeValue =
					Integer.parseInt(i);
			if (attributeValue > desiredValue)
			{

				numViewsMoreThan4000.add(attributeValue);
			}

			else if (attributeValue < desiredValue) {

				numViewsLessThan4000.add(attributeValue);
			}
		}

		sizeOfNumViewsLessThan4000List = numViewsLessThan4000.size();
		sizeOfNumViewsMoreThan4000List = numViewsMoreThan4000.size();
		softAssert.assertEquals(sizeOfNumViewsMoreThan4000List, sizeOfNumViewsList);
		softAssert.assertEquals(sizeOfNumViewsLessThan4000List, 0);
		softAssert.assertAll();
	}
}







