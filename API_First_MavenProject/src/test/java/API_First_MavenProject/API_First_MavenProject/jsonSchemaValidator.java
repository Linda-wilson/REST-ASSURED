package API_First_MavenProject.API_First_MavenProject;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class jsonSchemaValidator {

	
	@Test
	void jsonSchemaValidation() {
		given()
			.get("https://reqres.in/api/users?page=2")
			
		.then()
			.statusCode(200)
			.assertThat().body(matchesJsonSchemaInClasspath("schema.json"));
			
			
		
	}
}
