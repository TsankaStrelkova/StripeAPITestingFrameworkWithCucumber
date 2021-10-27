package melon.APIBatch4CucumberProject.cuke.steps;

import org.json.JSONObject;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import melon.APIBatch4CucumberProject.cuke.base.BaseTest;
import melon.APIBatch4CucumberProject.cuke.base.ValidDataUtil;

public class CreateCustomerStepsDefinitions {
	@Before
	public void setUp() {

		BaseTest.init();

	}
	
	@Given("I set the valid aut key")
	public void i_set_the_valid_aut_key() {
		 BaseTest.requestSpecs=RestAssured.given().auth().basic(BaseTest.validUserSecretKey, "");
		
	}

	@Given("I set {string} as the email parameter")
	public void i_set_as_the_email_parameter(String email) {
		BaseTest.requestSpecs = BaseTest.requestSpecs.formParam("email", email);
		
	}

	@Given("I set {string} as the description parameter")
	public void i_set_as_the_description_parameter(String description) {

		BaseTest.requestSpecs = BaseTest.requestSpecs.formParam("description", description);
	}

	@When("I send a post request to customer API")
	public void i_send_a_post_request_to_customer_API (){
		
		BaseTest.response = BaseTest.requestSpecs.post(BaseTest.customeEndPoint);
		BaseTest.response.prettyPrint();
		
	}

	@Then("I should get {int} as the expected status code")
	public void i_should_get_as_the_expected_status_code(Integer expectedStatuscode) {
		System.out.println("I should get "+expectedStatuscode+" as expected status code");
		Integer stCode = BaseTest.response.getStatusCode();
		Assert.assertEquals(stCode, expectedStatuscode);
		
	}
	
	@Then("I should get  {string} as  email in the response")
	public void i_should_get_as_email_in_the_response(String mail) {
		System.out.println("I should get "+mail+" as expected email");
		JsonPath jsonPathEvaluator = BaseTest.response.jsonPath();
		String currentEmail = jsonPathEvaluator.get("email");
		Assert.assertEquals(currentEmail, mail);
	}

	@Then("I should have {string} field in the response")
	public void i_should_have_field_in_the_response(String id) {
		System.out.println("I should get "+id+" in the response");
		// one way to check if in the respnse there is a key
		//JsonPath jsonPathEvaluator = BaseTest.response.jsonPath();
		//String currentId = jsonPathEvaluator.get(id);
		//Assert.assertNotNull(currentId);
		
		// another way to check if in the response there is key
		boolean hasExpectedField =ValidDataUtil.jsonHasKey(BaseTest.response, id);
		Assert.assertTrue(hasExpectedField);
		
	}


	@Then("I should get {string} as description in the response")
	public void i_should_get_as_description_in_the_response(String description) {
		System.out.println("I should have "+description+" in the response");
		JsonPath jsonPathEvaluator = BaseTest.response.jsonPath();
		String currentDescription = jsonPathEvaluator.get("description");
		Assert.assertEquals(currentDescription, description);
	}


	


}
