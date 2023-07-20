package Tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

import java.net.http.HttpResponse.BodyHandler;

public class TestonLocalAPI 
{
	//@Test
	public void get() 
	{
		
		baseURI = "http://localhost:3000";
		
		given().
		    get("/users").
		    then().
		    statusCode(200).
		    log().all();
		
	}
	
	//@Test
	public void post()
	{
		JSONObject request = new JSONObject();
		
		request.put("firstName","Thomas");
		request.put("lastName", "Albert");
		request.put("subjectId", 1);
		
		//System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000";
		
		given().
		    contentType(ContentType.JSON).
		    accept(ContentType.JSON).
		    body(request.toJSONString()).
		    when().
			post("/users").
		    then().
		    statusCode(201);
	}
	
	//@Test
	public void put()
	{
		JSONObject request = new JSONObject();
		
		request.put("firstName","Steve");
		request.put("lastName", "Smith");
		request.put("subjectId", 2);
		
		//System.out.println(request.toJSONString());
		
		baseURI = "http://localhost:3000";
		
		given().
		    contentType(ContentType.JSON).
		    accept(ContentType.JSON).
		    body(request.toJSONString()).
		    when().
			put("/users/5").
		    then().
		    statusCode(200);
	}
	
	@Test
	public void patch()
	{
		JSONObject request = new JSONObject();
		
//		request.put("firstName", "Virat");
//		request.put("lastName", "Doe");
		
		request.put("name", "Manual");
		
		baseURI = "http://localhost:3000";
		
		given().
		    contentType(ContentType.JSON).
		    accept(ContentType.JSON).
		    body(request.toJSONString()).
		    when().
			//patch("/users/4").
		    patch("/subjects/2").
		    then().
		    statusCode(200);
	}
	
	//@Test
	public void delete()
	{
		baseURI="http://localhost:3000";
		when().delete("/users/5").then().statusCode(201);
	}
}
