package hillelee.defaultMethods;

public interface Fruit {
	String getColor();
	
	Integer getWeight();
	
	default Double getVitC() {
		if (getColor().equals("GREEN")) {
			return getWeight() * 0.0001;
		} else {
			return getWeight() * 0.00005;
		}
	}
	
}
