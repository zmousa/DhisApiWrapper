package com.zenus.dhis.dhis_importer.model;

import java.util.ArrayList;
import java.util.List;

public class OrganizationUnit {
	private String id;
	private String displyName;
	private List<DataSet> dataSets;
	
	public OrganizationUnit(String id, String displyName) {
		super();
		this.id = id;
		this.displyName = displyName;
		this.dataSets = new ArrayList<>();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDisplyName() {
		return displyName;
	}
	public void setDisplyName(String displyName) {
		this.displyName = displyName;
	}

	public List<DataSet> getDataSets() {
		return dataSets;
	}

	public void setDataSets(List<DataSet> dataSets) {
		this.dataSets = dataSets;
	}
}
