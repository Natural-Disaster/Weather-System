package xml;

public class Param {

	private String name, units;
	
	public Param(String name, String units) {
		this.name = name;
		this.units = units;
	}
	
	public String getName() {
		return name;
	}
	
	public String getUnits() {
		return units;
	}
}
