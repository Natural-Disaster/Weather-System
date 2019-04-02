package handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import xml.Param;

public class XMLHandler {

	private File file;
	private Document document;
	
	private ArrayList<Param> Params = new ArrayList<Param>();
	
	private FileInputStream inputStream;
	private DocumentBuilderFactory factory;
	private DocumentBuilder builder;
	
	public XMLHandler(File file) throws ParserConfigurationException, SAXException, IOException {
		this.file = file;
		
		inputStream = new FileInputStream(file);
		factory = DocumentBuilderFactory.newInstance();
		builder = factory.newDocumentBuilder();
		document = builder.parse(inputStream);
		
		NodeList paramList = document.getElementsByTagName("Param");
		for (int i = 0; i < paramList.getLength(); i++) {
			Element param = (Element)paramList.item(i);
			Param p = new Param(param.getAttribute("name"), param.getAttribute("units"));
		}
		
	}
	
	public void outputRep(Element repElement) {
		String time 		= String.format("%04d", Integer.parseInt((repElement.getTextContent()))*100/60);
		String windSpeed 	= String.format("%2s", repElement.getAttribute("G")); 
		String windDirec 	= String.format("%3s", repElement.getAttribute("D")); 
		String temp 		= String.format("%2s", repElement.getAttribute("T"));
		String feelTemp	 	= String.format("%2s", repElement.getAttribute("F")); 


		//System.out.println(repElement.getTextContent());
		//System.out.println(repElement.getAttribute("D"));
		System.out.println(time + "Z  " + "Wind: " + windDirec + " " + windSpeed + "MPH" + "  Temp: " + temp + "°C but feels like " + feelTemp + "°C");
		
	}
	
	
	public void dailySearch(String date) {
		
		NodeList locations = document.getElementsByTagName("Location");
		Element location = (Element)locations.item(0);
				
		//System.out.println(e.getAttribute("name"));
		
		NodeList periods = document.getElementsByTagName("Period");
		
		for (int i = 0; i < periods.getLength(); i++) {
			Element period = (Element)periods.item(i);
			if(period.getAttribute("value").contains(date)){
				System.out.println(location.getAttribute("name") + ": ");
				NodeList repList = period.getElementsByTagName("Rep");
				for (int j = 0; j < repList.getLength(); j++) {
					Element rep = (Element)repList.item(j);
					outputRep(rep);
				}
				System.out.println("\n");
			}
		}		
	}
	
	public String getName() {
		NodeList locations = document.getElementsByTagName("Location");
		Element location = (Element)locations.item(0);
		String name = location.getAttribute("name");
		
		return name;
	}
	
}
