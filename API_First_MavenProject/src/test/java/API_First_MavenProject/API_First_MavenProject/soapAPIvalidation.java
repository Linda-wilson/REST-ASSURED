package API_First_MavenProject.API_First_MavenProject;

import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class soapAPIvalidation {

	@Test
	public void soapAPITest() throws IOException {
		baseURI ="https://ecs.syr.edu/faculty/fawcett/Handouts/cse775/code/calcWebService";
		File file = new File("./xmlRequest/add.xml");
		FileInputStream fileInputStream = new FileInputStream(file);
		String requestBody = IOUtils.toString(fileInputStream,"UTF-8");
		
		
		
		given()
			.contentType("text/xml")
			.accept(ContentType.XML)
			.body(requestBody)
		.when()
			.post("/Calc.asmx")
		.then()
			.statusCode(200)
			.log().all()
		.and()
			.body("//*:AddResult.text()",equalTo("28"));
	}
	
}
