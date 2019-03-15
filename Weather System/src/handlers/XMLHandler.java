package handlers;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XMLHandler {

	public void unmarshalXML(File file) {
		JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(WeatherXML.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
             
            WeatherXML weather = (WeatherXML) jaxbUnmarshaller.unmarshal(file);
             
            System.out.println(weather);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
	}
}
