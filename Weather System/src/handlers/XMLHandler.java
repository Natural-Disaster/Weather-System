package handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLHandler {

	private File file;
	private Document document;
	
	public XMLHandler(File file) {
		this.file = file;
	}
	
	public void dailySearch(String date) throws ParserConfigurationException, SAXException, IOException {
		FileInputStream inputStream = new FileInputStream(file);
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		document = builder.parse(inputStream);
		
		NodeList children = document.getElementsByTagName("Location");
		Element e = (Element)children.item(0);
		
		System.out.println(e.getAttribute("name"));
		
	}
}
