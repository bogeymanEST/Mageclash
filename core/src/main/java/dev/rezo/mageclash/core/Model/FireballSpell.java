package dev.rezo.mageclash.core.Model;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import dev.rezo.mageclash.core.Model.SpellInfo;
public class FireballSpell extends Spell{

	@Override
	public void fire(SpellInfo spellinfo) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set(spellinfo.playerposition.x, spellinfo.playerposition.y);
		Body body = spellinfo.arena.world.createBody(bodyDef);

		CircleShape dynamicCircle = new CircleShape();
		dynamicCircle.setRadius(1f);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = dynamicCircle;
		fixtureDef.density = 1.0f;
		fixtureDef.friction = 0.0f;
		fixtureDef.restitution = 0.0f;
		fixtureDef.filter.groupIndex = spellinfo.playerID;
		

		FireballEntity fEnt = new FireballEntity();
		fEnt.body = body;
		body.setLinearVelocity(spellinfo.firedirection.x, spellinfo.firedirection.y);
		body.setUserData(fEnt);
		dynamicCircle.dispose();
		
	}

	@Override
	public void fireElite(SpellInfo spellinfo) {
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.DynamicBody;
		bodyDef.position.set(spellinfo.playerposition.x, spellinfo.playerposition.y);
		Body body = spellinfo.arena.world.createBody(bodyDef);

		CircleShape dynamicCircle = new CircleShape();
		dynamicCircle.setRadius(1f);
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = dynamicCircle;
		fixtureDef.density = 1.0f;
		fixtureDef.friction = 0.0f;
		fixtureDef.restitution = 0.0f;
		fixtureDef.filter.groupIndex = spellinfo.playerID;
		

		FireballEliteEntity fEEnt = new FireballEliteEntity();
		fEEnt.body = body;
		body.setLinearVelocity(spellinfo.firedirection.x, spellinfo.firedirection.y);
		body.setUserData(fEEnt);
		dynamicCircle.dispose();
		
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return "It's a ball of fire, hurr durr. ELITE: Explodes on impact dealing some extra damage. The fireball also detonates when it hits a wall, meaning it can miss but still deal damage.";
	}

}
