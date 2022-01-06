package solar;

public class Saturn extends Planet {

	private int speed;

	public Saturn() {
		super();
		this.speed = 0;
	}

	public Saturn(int orbitRadius, int speed) {
		super(orbitRadius);
		if (speed < 0) {
			speed = 0;
		}
		this.speed = speed;
	}

	public int getSpeed() {
		return this.speed;
	}

	public boolean orbit() {
		int round = 0;
		if(this.speed > 0) {
			while(round<this.speed) {
				super.orbit(); 
				round++;
			}
			return true;
		}
		return false;
	}

}
