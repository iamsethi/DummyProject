package com.dummy;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RestAssuredDemo {

	private Response responseBody;
	private static Logger log = LogManager.getLogger(RestAssuredDemo.class);
	private String petId;
	private String petName;

	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = "http://petstore.swagger.io";
		RestAssured.basePath = "/v2";

	}

	@Test(priority = 0)
	public void postExample() {
		// http://petstore.swagger.io/v2/pet
		responseBody = given().basePath(RestAssured.basePath.concat("/pet")).contentType("application/json")
				.body(new File("./dog.json")).when().post().then().assertThat().statusCode(200).extract().response();
		this.petId = responseBody.jsonPath().get("id").toString();
		this.petName = responseBody.jsonPath().get("name").toString();
		log.info(petId + "########POST EXAMPLE######" + petName);

	}

	@Test(priority = 1)
	public void getExample() {
		// // http://petstore.swagger.io/v2/pet/{petId}
		responseBody = given().basePath(RestAssured.basePath.concat("/pet/{petId}")).contentType("application/json")
				.pathParam("petId", this.petId).when().get().then().assertThat().statusCode(200).extract().response();

		log.info("########GET EXAMPLE######" + responseBody.asString());

	}

	@Test(priority = 2)
	public void putExample() {
		// http://petstore.swagger.io/v2/pet
		responseBody = given()
				.basePath(RestAssured.basePath.concat("/pet"))
				.contentType("application/json")
				.body(new File("./elephant.json"))
				.when()
				.put()
				.then()
				.assertThat()
				.statusCode(200)
				.extract().response();
		
		this.petId = responseBody.jsonPath().get("id").toString();
		this.petName = responseBody.jsonPath().get("name").toString();
		
		log.info(petId + "########PUT EXAMPLE######" + petName);

	}
	
	@Test(priority = 3)
	public void deleteExample() {
		// http://petstore.swagger.io/v2/pet/{petId}
						given()
						.basePath(RestAssured.basePath.concat("/pet/{petId}"))
						.contentType("application/json")
						.pathParam("petId", this.petId)
						.when()
						.delete()
						.then()
						.assertThat()
						.statusCode(200);


	}


}
