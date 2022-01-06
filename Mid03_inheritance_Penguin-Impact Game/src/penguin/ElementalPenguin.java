package penguin;

public class ElementalPenguin extends FighterPenguin {
	
	private PenguinType type;
	
	public ElementalPenguin(String name, int hp, int pow, PenguinType type, String catchphrase) {
		super(name, hp, pow, catchphrase);
		setType(type);
	}

	public PenguinType getType() {
		return type;
	}

	public void setType(PenguinType type) {
		this.type = type;
	}

	public int getElementalAdvantage(Penguin target) {
		if(target instanceof ElementalPenguin ) {
			if( ((ElementalPenguin) target).getType().equals(type)) {
				return 0;
			}
			if(type.equals(PenguinType.FIRE)&& ((ElementalPenguin) target).getType().equals(PenguinType.SNOW)) {
				return 1;
			}
			if(type.equals(PenguinType.SNOW)&& ((ElementalPenguin) target).getType().equals(PenguinType.WATER)) {
				return 1;
			}
			if(type.equals(PenguinType.WATER)&& ((ElementalPenguin) target).getType().equals(PenguinType.FIRE)) {
				return 1;
			}
			else return -1;
		}
		return 0;
		
	}
	
	public int attack(Penguin target) {
		int atk;
		if(getElementalAdvantage(target)==1){
			atk = this.getPow()*2;
		}
		else if(getElementalAdvantage(target)==-1) {
			atk = this.getPow()/2;
		}
		else atk = this.getPow();
		target.setHp(target.getHp()-atk);
		return atk;
	}
	
	public String toString() {
		return super.makeToString(this);
	}
}
