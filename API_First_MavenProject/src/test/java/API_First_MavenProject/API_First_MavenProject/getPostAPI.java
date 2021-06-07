package API_First_MavenProject.API_First_MavenProject;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class getPostAPI {
	
	
	//@Test
	void getAPI() {
		baseURI ="https://reqres.in/api";
		given()
			.get("/users?page=2").
		then()
			.statusCode(200);
		
	
		
	}
	
	@Test
	void postAPI() {
		
		baseURI ="https://reqres.in/api";
		JSONObject request = new JSONObject();
		request.put("name","Linda");
		request.put("Job","Software Engineer");
		
		System.out.println(request.toJSONString());
		
		given()
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201)
			.log().all();
		
	}
		

	}


