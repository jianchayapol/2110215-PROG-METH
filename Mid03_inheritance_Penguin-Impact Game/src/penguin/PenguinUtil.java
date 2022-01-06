package penguin;

public class PenguinUtil {
	public static String getTypeString(ElementalPenguin penguin) {
		switch(penguin.getType()) {
		case SNOW:
			return "(S)";
		case FIRE:
			return "(F)";
		case WATER:
			return "(W)";
		}
		return null;
	}
	
	public static String makeToString(Penguin p) {
		if (p.getClass().equals(ElementalPenguin.class)) {
			ElementalPenguin ep = (ElementalPenguin) p;
			return ep.getName() + " " + PenguinUtil.getTypeString(ep) + " " + ep.getHp() + "/" + ep.getMaxHp() + " HP, " + ep.getPow() + " POW";
		}
		
		if (p.getClass().equals(FighterPenguin.class)) {
			FighterPenguin fp = (FighterPenguin) p;
			return fp.getName() + " " + fp.getHp() + "/" + fp.getMaxHp() + " HP, " + fp.getPow() + " POW";
		}
		
		return p.getName() + " " + p.getHp() + "/" + p.getMaxHp() + " HP";
	}
	
	public static String makeSpeech(Penguin p) {
		return p.getName() + ": \"" + p.getCatchphrase() + "\"";
	}
}
