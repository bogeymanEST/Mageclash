package Dev.Rezo.Mageclash.Model;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;

import Dev.Rezo.Mageclash.Arena;
import Dev.Rezo.Mageclash.Model.SpellInfo;

public class LightningBoltSpell extends Spell {
	static float SPEED = 5f;

	@Override
	public void fire(SpellInfo spellinfo) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set(spellinfo.playerposition.x+spellinfo.firedirection.x, spellinfo.playerposition.y+spellinfo.firedirection.y);
		Body body = spellinfo.arena.world.createBody(bodyDef);

		CircleShape dynamicCircle = new CircleShape();
		dynamicCircle.setRadius(0.5f);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = dynamicCircle;
		fixtureDef.density = 1.0f;
		fixtureDef.friction = 1.0f;
		fixtureDef.restitution = 1.0f;
		fixtureDef.filter.groupIndex = spellinfo.playerID;
		

		FireballEntity fEnt = new FireballEntity();
		fEnt.body = body;
		body.setLinearVelocity(spellinfo.firedirection.scl(SPEED));
		body.setUserData(fEnt);
		dynamicCircle.dispose();
		
	}

	@Override
	public void fireElite(SpellInfo spellinfo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "Fire a bolt of lightning. It stuns enemies but is difficult to hit with. ELITE: The lightning bolt turns a red color and travels faster.";
	}

}
