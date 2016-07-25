package com.zenus.dhis.dhis_importer.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.zenus.dhis.dhis_importer.model.DataElement;
import com.zenus.dhis.dhis_importer.model.DataSet;
import com.zenus.dhis.dhis_importer.model.OrganizationUnit;
import com.zenus.dhis.dhis_importer.util.Constants;

public class JsonProcessor {
	
	public List<OrganizationUnit> parseOrganizationDataJSON(String jsonData){
		List<OrganizationUnit> orgs = new ArrayList<OrganizationUnit>();
		try {
			ObjectMapper mapper = new ObjectMapper();
		  	JsonFactory factory = mapper.getFactory();
		  	JsonParser jp = factory.createParser(jsonData);
		  	JsonNode actualObj = mapper.readTree(jp);
		  	JsonNode orgUnits = actualObj.get("organisationUnits");
		  	if (orgUnits instanceof ArrayNode){
		  		for (JsonNode node : (ArrayNode) orgUnits){
		  			orgs.add(new OrganizationUnit(node.get("id").asText(), node.get("displayName").asText()));
		  		}
		  	}
		} catch (Exception e){
			e.printStackTrace();
		}
		return orgs;
	}
	
	public List<DataSet> parseDatasetJSON(String jsonData){
		List<DataSet> datasets = new ArrayList<DataSet>();
		try {
			ObjectMapper mapper = new ObjectMapper();
		  	JsonFactory factory = mapper.getFactory();
		  	JsonParser jp = factory.createParser(jsonData);
		  	JsonNode actualObj = mapper.readTree(jp);
		  	JsonNode orgUnits = actualObj.get("dataSets");
		  	if (orgUnits instanceof ArrayNode){
		  		for (JsonNode node : (ArrayNode) orgUnits){
		  			datasets.add(new DataSet(node.get("id").asText(), node.get("displayName").asText()));
		  		}
		  	}
		} catch (Exception e){
			e.printStackTrace();
		}
		return datasets;
	}
	
	public List<DataElement> parseDataElementJSON(String jsonData){
		List<DataElement> dataElements = new ArrayList<DataElement>();
		try {
			ObjectMapper mapper = new ObjectMapper();
		  	JsonFactory factory = mapper.getFactory();
		  	JsonParser jp = factory.createParser(jsonData);
		  	JsonNode actualObj = mapper.readTree(jp);
		  	JsonNode orgUnits = actualObj.get("dataElements");
		  	if (orgUnits instanceof ArrayNode){
		  		for (JsonNode node : (ArrayNode) orgUnits){
		  			dataElements.add(new DataElement(node.get("id").asText(), node.get("displayName").asText()));
		  		}
		  	}
		} catch (Exception e){
			e.printStackTrace();
		}
		return dataElements;
	}
	
	public boolean parsePostDataValueSetJSONResponse(String jsonData){
		try {
			ObjectMapper mapper = new ObjectMapper();
		  	JsonFactory factory = mapper.getFactory();
		  	JsonParser jp = factory.createParser(jsonData);
		  	JsonNode actualObj = mapper.readTree(jp);
		  	JsonNode orgUnits = actualObj.get("status");
		  	if (orgUnits != null && Constants.SUCCESS_RESPONSE.equals(orgUnits.asText()))
		  		return true;
		} catch (Exception e){
			e.printStackTrace();
		}
		return false;
	}
	
	public String dataSetJsonGenerator(DataSet dataSet, String period){
		JsonFactory factory = new JsonFactory();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		JsonGenerator generator = null;
		try {
			generator = factory.createGenerator(outputStream, JsonEncoding.UTF8);
			
			generator.writeStartObject();
			generator.writeStringField("dataSet", dataSet.getId());
			generator.writeStringField("period", period);
			generator.writeStringField("orgUnit", dataSet.getOrganizationUnit() != null? dataSet.getOrganizationUnit().getId() : "");
			generator.writeArrayFieldStart("dataValues");
			
			if (dataSet.getDataElements() != null)
				for (DataElement dataElement : dataSet.getDataElements()){
					generator.writeStartObject();
					generator.writeStringField("dataElement", dataElement.getId());
					generator.writeStringField("value", dataElement.getValue());
					generator.writeEndObject();
				}
			
			generator.writeEndArray();
			generator.writeEndObject();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (generator != null) {
				try {
					generator.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		return outputStream.toString();
	}
}
