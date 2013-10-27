package Dev.Rezo.Mageclash.Model;
import Dev.Rezo.Mageclash.Arena;
import Dev.Rezo.Mageclash.Model.SpellInfo;
public abstract class Spell {
	public abstract void fire(SpellInfo spellinfo);
	public abstract void fireElite(SpellInfo spellinfo);
	public abstract String getDescription();
}
