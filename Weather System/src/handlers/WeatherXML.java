package handlers;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "SiteRep")
public class WeatherXML implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer Wx;
    private String DV;
    private String title;
 
    public WeatherXML() {
        super();
    }
    
  //Setters and Getters
    
    @Override
    public String toString() {
        return "Employee [id=" + Wx + ", firstName=" + DV + ", lastName=" + title + "]";
    }

    
}
