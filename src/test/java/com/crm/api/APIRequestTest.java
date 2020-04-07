package com.crm.api;

import static com.jayway.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class APIRequestTest {

	@Test
	public void testDemo() {
		System.out.println("Test testDemo() Completed...");
	}
	
	//GET	/api/customers
	@Test	
	public void test_GETRequest(){
		Response resp = given().
				when().
				get("http://localhost:8082/api/customers");


		System.out.println("GET response is : " + resp.asString());
	}
	
	//POST   /api/customers
	@Test
	public void test_POSTRequest(){

		Response resp=	given().
				body("  {\"firstName\":\"Aveer\","
						+ " \"lastName\":\"Singh\","
						+ " \"email\":\"aveer.singh@gmail.com\" }  ").
						when().
						contentType(ContentType.JSON).
						post("http://localhost:8082/api/customers");


		System.out.println("POST response is : " + resp.asString());
	}
	
	//PUT   /api/customers
	@Test
	public void test_PUTRequest(){

		Response resp=	given().
				body("  {\"id\":15,"
						+ " \"firstName\":\"Aveer12\","
						+ " \"lastName\":\"Singh12\","
						+ " \"email\":\"aveer.singh12@gmail.com\" }  ").
						when().
						contentType(ContentType.JSON).
						put("http://localhost:8082/api/customers");


		System.out.println("PUT response is : " + resp.asString());
	}
	
	
	//DELETE /api/customers/{id}
	@Test
	public void test_DELETERequest(){
		Response resp = given().
		when().
		delete("http://localhost:8082/api/customers/17");
		
		System.out.println("Deleting response : "+ resp.asString());
	}
	
	
}