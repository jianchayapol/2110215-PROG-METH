package penguin;

public class FighterPenguin extends Penguin {

	private int pow;
	
	public FighterPenguin(String name, int hp, int pow, String catchphrase) {
		super(name, hp, catchphrase);
		this.setPow(pow);
	}

	public int getPow() {
		return pow;
	}

	public void setPow(int pow) {
		int val = pow;
		if(pow<0) val = 0;
		this.pow = val;
	}
	
	public int attack(Penguin target) {
		target.setHp(target.getHp()-pow);
		return pow;
	}
	
	public String toString() {
		return super.makeToString(this);
	}
	
}
