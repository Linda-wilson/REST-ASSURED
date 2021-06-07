package API_First_MavenProject.API_First_MavenProject;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


public class putPatchPostAPI {

	//@Test
	void putRequest() {
		
	baseURI = "https://reqres.in/api";
	
	JSONObject putRequest = new JSONObject();
	putRequest.put("Name","Linda");
	putRequest.put("Job","Sweng");
	given().
	
	when()
		.put("/users/2").
	then()
	    .statusCode(200)
	    .log().all();
	    
	}
	
	@Test
	void patchRequest() {
		
		baseURI = "https://reqres.in/api";
		
		JSONObject patchRequest = new JSONObject();
		patchRequest.put("Name","ABCD");
		patchRequest.put("Job", "XYZ");
		System.out.println(patchRequest);
		System.out.println(patchRequest.toJSONString());
		given()
		.when()
			.patch("/users/2")
		.then()
			.statusCode(200)
			.log().all();
		
		
		
	}
	
	
	@Test
	void deleteRequest() {
		
		baseURI = "https://reqres.in/api";
		given()
		.when()
			.delete("/users/2")
		.then()
			.statusCode(204)
			.log().all();
			
		

		
	}
	
	
}
