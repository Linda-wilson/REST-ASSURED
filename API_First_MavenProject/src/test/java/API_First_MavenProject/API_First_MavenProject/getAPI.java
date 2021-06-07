package API_First_MavenProject.API_First_MavenProject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class getAPI {

	
	@Test
	void getApi() {
		
		Response response = get("https://reqres.in/api/users?page=2");
		System.out.println("Status Code : " +response.getStatusCode());
		System.out.println("Response Header : " +response.getHeaders());
		System.out.println("Response Body : " +response.getBody().asString());
		System.out.println();
					
	}
	
	@Test
	void getapi2()
	{
		given()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("total_pages",equalTo(2));
			
	}
}
