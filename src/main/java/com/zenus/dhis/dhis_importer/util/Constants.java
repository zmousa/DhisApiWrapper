package com.zenus.dhis.dhis_importer.util;

public class Constants {
	public static String AUTHORIZATION = "Basic YWRtaW46ZGlzdHJpY3Q=";
	public static String HOST = "http://localhost:8080/api/";
	public static String DHIS_DEMO_HOST = "https://play.dhis2.org/demo/api/";
	
	public static String URL_ORGANIZATION_UNITS = "organisationUnits";
	public static String URL_ORGANIZATION_UNITS_BY_LEVEL = "organisationUnits?level=$";
	public static String URL_ORGANIZATION_UNIT = "organisationUnits/$";
	
	public static String URL_DATA_ELEMENTS = "dataElements";
	public static String URL_DATA_ELEMENT = "dataElements/$";
	public static String URL_DATA_ELEMENT_BY_DATA_SET = "dataElements?dataset=$";
	
	public static String URL_DATA_SETS = "dataSets";
	public static String URL_DATA_SET = "dataSets/$";
	public static String URL_DATA_SET_BY_ORGANIZATION_UNIT = "dataSets?organisationUnits=$";
	
	public static String URL_DATA_VALUE_SETS = "dataValueSets";
	
	public static String SUCCESS_RESPONSE = "SUCCESS";
}
