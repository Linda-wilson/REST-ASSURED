package API_First_MavenProject.API_First_MavenProject;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;


public class TestOnLocalRestAPI {
	
	
	@Test(priority = 0)
	void getRequest() {
		
		baseURI = "http://localhost:3000";
		given()
			.get("/users")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority = 1)
	void postRequest() {
		JSONObject requestBody = new JSONObject();
		requestBody.put("firstName", "Shinto");
		requestBody.put("lastName","Antony");
		requestBody.put("subjectId","2");
		
		baseURI = "http://localhost:3000";
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(requestBody.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201);
		
	}
	
	@Test(priority = 2)
	void putRequest() {
		
		JSONObject requestBody = new JSONObject();
		requestBody.put("firstName","Linda");
		requestBody.put("lastName", "Wilson");
		requestBody.put("subjectId", "2");
		
		baseURI = "http://localhost:3000";
		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(requestBody.toJSONString())
		.when()
			.put("/users/507")
		.then()
			.statusCode(200)
			.log().all();
				
	}
	
	@Test(priority = 3)
	void patchRequest() {
		JSONObject requestBody = new JSONObject();
		requestBody.put("lastName", "Shinto");
				
		
		baseURI = "http://localhost:3000";
		given()
			.contentType(ContentType.JSON)
			.body(requestBody.toJSONString())
		.when()
			.patch("/users/507")
		.then()
			.statusCode(200);
			
	}
	
	@Test(priority = 4)
	void deleteRequest() {
		baseURI = "http://localhost:3000";
		
		when()
			.delete("/users/507")
		.then()
			.statusCode(200);
	}
	
	

}
