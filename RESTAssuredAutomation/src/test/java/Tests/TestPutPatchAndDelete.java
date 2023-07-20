package Tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class TestPutPatchAndDelete 
{
    @Test
	public void testput()
	{
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Raghav");
		request.put("Job", "Teacher");
		
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		
		given().
		header("CONTENT-Type", "application/json").
		contentType(ContentType.JSON).
		body(request.toJSONString()).
		when().
		put("/users/2").
		then().
		statusCode(200).
		log().all();
	}
    
    @Test
    public void testpatch()
	{
		
		JSONObject request = new JSONObject();
		
		request.put("name", "Raghav");
		request.put("Job", "Teacher");
		
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in";
		
		given().
		header("CONTENT-Type", "application/json").
		contentType(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("/api/users/2").
		then().
		statusCode(200).
		log().all();
	}
    
    @Test
    public void testdelete()
	{
		
		baseURI="https://reqres.in";
		when().
		delete("/api/users/2").
		then().
		statusCode(204).
		log().all();
	}
	
}
