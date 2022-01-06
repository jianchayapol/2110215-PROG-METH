package solar;

import java.util.*;

import solarsystem.SolarSystem;

public class Planet {

	protected Coordinate coordinate;
	protected Coordinate orbitCenterCoordinate;
	protected int orbitRadius;

	public Planet() {
		this.coordinate = new Coordinate(1, 0);
		this.orbitCenterCoordinate = new Coordinate(0, 0);
		this.orbitRadius = 1;
	}

	public Planet(int orbitRadius) {
		if (orbitRadius < 1) {
			orbitRadius = 1;
		}
		this.coordinate = new Coordinate(orbitRadius, 0);
		this.orbitCenterCoordinate = new Coordinate(0, 0);
		this.orbitRadius = orbitRadius;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public Coordinate getOrbitCenterCoordinate() {
		return orbitCenterCoordinate;
	}

	public int getOrbitRadius() {
		return orbitRadius;
	}

	public boolean orbit() {
		int x = coordinate.getX();
		int y = coordinate.getY();
		int cx = orbitCenterCoordinate.getX();
		int cy = orbitCenterCoordinate.getY();
		int r = getOrbitRadius();

		if (coordinate.getX() == cx + r && this.coordinate.getY() == cy) {
			coordinate.setX(cx);
			coordinate.setY(cy - r);
			return true;
		} else if (coordinate.getX() == cx && coordinate.getY() == cy - r) {
			coordinate.setX(cx - r);
			coordinate.setY(cy);
			return true;
		} else if (coordinate.getX() == cx - r && coordinate.getY() == cy) {
			coordinate.setX(cx);
			coordinate.setY(cy + r);
			return true;
		} else if (coordinate.getX() == cx && coordinate.getY() == cy + r) {
			coordinate.setX(cx + r);
			coordinate.setY(cy);
			return true;
		}

		return false;
	}

}
