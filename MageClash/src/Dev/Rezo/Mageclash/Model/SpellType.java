package Dev.Rezo.Mageclash.Model;

public enum SpellType {
	ICESHARD("Ice Shard", new IceShardSpell()),
	FIREBALL("Fireball", new FireballSpell()),
	LIGHTNINGBOLT("Lightning Bolt", new LightningBoltSpell()),
	LIGHTBEAM("Light beam", new LightBeamSpell()),
	HEALCIRCLE("Healing Circle", new HealCircleSpell());
	public String name;
	public Spell spell;
	private SpellType(String name, Spell spell){
		this.name = name;
		this.spell = spell;
	}

}
