package dev.rezo.mageclash.core.Model;
import dev.rezo.mageclash.core.Arena;
import dev.rezo.mageclash.core.Model.SpellInfo;
public abstract class Spell {
	public abstract void fire(SpellInfo spellinfo);
	public abstract void fireElite(SpellInfo spellinfo);
	public abstract String getDescription();
}
