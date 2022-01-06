package solar;

import java.util.ArrayList;

public class Application {

	private ArrayList<Planet> planets = new ArrayList<>();

	public static String printPlanet(Planet planet) {

		if (planet.getClass().equals(Earth.class)) {
			Earth planetEarth = (Earth) planet;
			return "Earth's Waste Level is " + planetEarth.getWasteLevel();
		} else if (planet.getClass().equals(Saturn.class)) {
			Saturn planetSaturn = (Saturn) planet;
			return "Saturn's Speed is " + planetSaturn.getSpeed();
		}
		return "";

	}

	public void main() {
		Planet earth = new Earth(1, 4);
		Planet saturn = new Saturn(2, 2);
		planets.add(earth);
		planets.add(saturn);
		System.out.println(printPlanet(earth));
		System.out.println(printPlanet(saturn));
	}

}
