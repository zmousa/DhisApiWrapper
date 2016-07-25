package com.zenus.dhis.dhis_importer.model;

import java.util.ArrayList;
import java.util.List;

public class DataSet {
	private String id;
	private String name;
	private OrganizationUnit organizationUnit;
	private List<DataElement> dataElements;
	
	public DataSet(String id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.dataElements = new ArrayList<>();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<DataElement> getDataElements() {
		return dataElements;
	}

	public void setDataElements(List<DataElement> dataElements) {
		this.dataElements = dataElements;
	}

	public OrganizationUnit getOrganizationUnit() {
		return organizationUnit;
	}

	public void setOrganizationUnit(OrganizationUnit organizationUnit) {
		this.organizationUnit = organizationUnit;
	}
}
