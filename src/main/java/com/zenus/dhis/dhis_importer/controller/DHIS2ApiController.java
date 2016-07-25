package com.zenus.dhis.dhis_importer.controller;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.zenus.dhis.dhis_importer.util.Constants;


public class DHIS2ApiController implements ApiController{

	public String getOrganisationUnits() {
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			
		  	HttpGet request = new HttpGet(Constants.HOST + Constants.URL_ORGANIZATION_UNITS);
		  	request.setHeader(HttpHeaders.AUTHORIZATION, Constants.AUTHORIZATION);
		  	HttpResponse response = client.execute(request);
	
		  	HttpEntity entity = response.getEntity();
		  	return EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getOrganisationUnit(String id) {
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			
			HttpGet request = new HttpGet(Constants.HOST + Constants.URL_ORGANIZATION_UNIT.replace("$", id));
			request.setHeader(HttpHeaders.AUTHORIZATION, Constants.AUTHORIZATION);
		  	HttpResponse response = client.execute(request);
	
		  	HttpEntity entity = response.getEntity();
		  	return EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getOrganisationUnitsByLevel(String level) {
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			
			HttpGet request = new HttpGet(Constants.HOST + Constants.URL_ORGANIZATION_UNITS_BY_LEVEL.replace("$", level));
			request.setHeader(HttpHeaders.AUTHORIZATION, Constants.AUTHORIZATION);
		  	HttpResponse response = client.execute(request);
	
		  	HttpEntity entity = response.getEntity();
		  	return EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getDataElementsByDataSet(String datasetId) {
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			
			HttpGet request = new HttpGet(Constants.HOST + Constants.URL_DATA_ELEMENT_BY_DATA_SET.replace("$", datasetId));
			request.setHeader(HttpHeaders.AUTHORIZATION, Constants.AUTHORIZATION);
		  	HttpResponse response = client.execute(request);
	
		  	HttpEntity entity = response.getEntity();
		  	return EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getDataElement(String id) {
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			
			HttpGet request = new HttpGet(Constants.HOST + Constants.URL_DATA_ELEMENT.replace("$", id));
			request.setHeader(HttpHeaders.AUTHORIZATION, Constants.AUTHORIZATION);
		  	HttpResponse response = client.execute(request);
	
		  	HttpEntity entity = response.getEntity();
		  	return EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getDataSetsByOrganizationUnit(String organizationUnit) {
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			
			HttpGet request = new HttpGet(Constants.HOST + Constants.URL_DATA_SET_BY_ORGANIZATION_UNIT.replace("$", organizationUnit));
			request.setHeader(HttpHeaders.AUTHORIZATION, Constants.AUTHORIZATION);
		  	HttpResponse response = client.execute(request);
	
		  	HttpEntity entity = response.getEntity();
		  	return EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public String getDataSet(String id) {
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			
			HttpGet request = new HttpGet(Constants.HOST + Constants.URL_DATA_SET.replace("$", id));
			request.setHeader(HttpHeaders.AUTHORIZATION, Constants.AUTHORIZATION);
		  	HttpResponse response = client.execute(request);
	
		  	HttpEntity entity = response.getEntity();
		  	return EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	public String postDataValueSets(String data) {
		try {
			CloseableHttpClient client = HttpClientBuilder.create().build();
			
			HttpPost request = new HttpPost(Constants.DHIS_DEMO_HOST + Constants.URL_DATA_VALUE_SETS);
			request.setHeader(HttpHeaders.AUTHORIZATION, Constants.AUTHORIZATION);
			request.addHeader("Content-Type", "application/json");
			
			StringEntity params =new StringEntity(data);
			request.setEntity(params);

		  	HttpResponse response = client.execute(request);
	
		  	HttpEntity entity = response.getEntity();
		  	return EntityUtils.toString(entity, "UTF-8");
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	
}
