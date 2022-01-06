package penguin;

public class Penguin extends PenguinUtil {
	private String name;
	private int hp;
	private int maxHp;
	private String catchphrase;
	
	public Penguin(String name, int hp, String catchphrase) {
		this.setName(name);
		this.setMaxHp(hp);
		this.setHp(hp);
		this.setCatchphrase(catchphrase);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		int val = hp;
		if(hp>maxHp) val = maxHp;
		else if(hp<0) val = 0;
		this.hp = val;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		int val = maxHp;
		if(val<0) val = 0;
		this.maxHp = val;
	}

	public String getCatchphrase() {
		return catchphrase;
	}

	public void setCatchphrase(String catchphrase) {
		this.catchphrase = catchphrase;
	}
	
	public String toString() {
		return super.makeToString(this);
	}
	
	public String getSpeech() {
		return super.makeSpeech(this);
	}
	
}
