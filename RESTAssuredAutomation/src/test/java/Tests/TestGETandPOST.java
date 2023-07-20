package Tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
//import static io.restassured.matcher.RestAssuredMatchers.*;

public class TestGETandPOST {

	//@Test
	public void testGet()
	{
		baseURI="https://reqres.in/api";
		
		given().
		get("/users?page=2").
		then().
		statusCode(200).
		body("data[4].first_name", equalTo("George")).
		body("data.first_name", hasItems("George","Rachel")).
		
		body("data[0].last_name",equalTo("Lawson")).
		body("data.last_name",hasItems("Lawson","Ferguson"));
		
	}
	
	@Test
	public void getPost()
	{
		Map<String, Object> map = new HashMap<String, Object>();
		
//		map.put("name", "Raghav");
//		map.put("Job", "Teacher");
//		
//		System.out.println(map);
		
		JSONObject request = new JSONObject(map);
		
		request.put("name", "Raghav");
		request.put("Job", "Teacher");
		
		System.out.println(request.toJSONString());
		
		baseURI="https://reqres.in/api";
		
		given().
		body(request.toJSONString()).
		when().
		post("/users").
		then().
		statusCode(201).
		log().all();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
