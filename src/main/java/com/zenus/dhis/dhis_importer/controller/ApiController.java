package com.zenus.dhis.dhis_importer.controller;

public interface ApiController {
	public String getOrganisationUnits();
	public String getOrganisationUnit(String id);
	public String getOrganisationUnitsByLevel(String level);
	
	public String getDataElementsByDataSet(String datasetId);
	public String getDataElement(String id);
	
	public String getDataSetsByOrganizationUnit(String organizationUnit);
	public String getDataSet(String id);
	
	public String postDataValueSets(String data);
}
