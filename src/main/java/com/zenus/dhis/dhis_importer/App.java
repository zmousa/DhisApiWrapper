package com.zenus.dhis.dhis_importer;

import java.util.ArrayList;
import java.util.List;

import com.zenus.dhis.dhis_importer.controller.ApiController;
import com.zenus.dhis.dhis_importer.controller.DHIS2ApiController;
import com.zenus.dhis.dhis_importer.controller.JsonProcessor;
import com.zenus.dhis.dhis_importer.model.DataElement;
import com.zenus.dhis.dhis_importer.model.DataSet;
import com.zenus.dhis.dhis_importer.model.OrganizationUnit;

public class App 
{
    public static void main(String[] args)
    {
    	ApiController api_Controller = new DHIS2ApiController();
    	JsonProcessor jsonProcessor = new JsonProcessor();
    	
    	// Get Organization Units
		String jsonData = api_Controller.getOrganisationUnitsByLevel("2");
		List<OrganizationUnit> organizationUnits = jsonProcessor.parseOrganizationDataJSON(jsonData);
		System.out.println(organizationUnits.size());
		
		// Get Data Set By Organization Unit
		jsonData = api_Controller.getDataSetsByOrganizationUnit("ImspTQPwCqd");
		List<DataSet> dataSets = jsonProcessor.parseDatasetJSON(jsonData);
		System.out.println(dataSets.size());
		
		// Get Data Elements By Data Set
		jsonData = api_Controller.getDataElementsByDataSet("BfMAe6Itzgt");
		List<DataElement> dataElements = jsonProcessor.parseDataElementJSON(jsonData);
		System.out.println(dataElements.size());
		
		// Post Data Set Values
		DataSet dataSet = new DataSet("pBOMPrpg1QX", "test");
		OrganizationUnit organizationUnit = new OrganizationUnit("DiszpKrYNg8", "org");
		dataSet.setOrganizationUnit(organizationUnit);
		List<DataElement> elements = new ArrayList<>();
		DataElement de1 = new DataElement("f7n9E0hX8qk", "de1");
		de1.setValue("10");
		DataElement de2 = new DataElement("Ix2HsbDMLea", "de2");
		de2.setValue("11");
		DataElement de3 = new DataElement("eY5ehpbEsB7", "de3");
		de3.setValue("12");
		elements.add(de1);
		elements.add(de2);
		elements.add(de3);
		dataSet.setDataElements(elements);
		
		jsonData = jsonProcessor.dataSetJsonGenerator(dataSet, "201401");
		jsonData = api_Controller.postDataValueSets(jsonData);
		System.out.println(jsonProcessor.parsePostDataValueSetJSONResponse(jsonData));
    }
}
