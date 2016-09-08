package com.prokarma.cucumber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import junit.framework.Assert;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HelloSteps {
	final Logger logger = LoggerFactory.getLogger(HelloSteps.class);
	private String hello_url;
	ClientResponse response;

	@Given("^I query hi$")
	public void i_query_hello_world() throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		hello_url = "http://localhost:8001/hi";
		logger.info("http query = " + hello_url);
	}

	@When("^I make the rest call$")
	public void I_make_the_rest_call() throws IOException, JSONException {
		response = getServiceResponse(hello_url);
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(hello_url);
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));
		String line = "";
		while ((line = rd.readLine()) != null) {
			logger.info(line);
		}

	}

	@Then("^response should contain:$")
	public void response_should_contain_JSON(String expected_json_str)
			throws JSONException, ClientProtocolException, IOException {
		logger.info("Comparing reponse with" + expected_json_str);
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(hello_url);
		HttpResponse response = client.execute(request);
		BufferedReader rd = new BufferedReader(new InputStreamReader(response
				.getEntity().getContent()));
		String line = "";
		StringBuilder sb = new StringBuilder();
		while ((line = rd.readLine()) != null) {
			logger.info(line);
			sb.append(line);
		}
		System.out.println("expected_json_str::" + expected_json_str);
		System.out.println("sb::" + sb);
		Assert.assertEquals(expected_json_str, sb.toString());

	}

	protected ClientResponse getServiceResponse(String url) {
		try {
			Client client = Client.create();
			WebResource webResource = client.resource(url);
			response = webResource.type("application/json").get(
					ClientResponse.class);

		} catch (RuntimeException r) {
			throw r;
		} catch (Exception e) {
			System.out.println("Exception caught");
			e.printStackTrace();
		}
		return response;
	}
}
