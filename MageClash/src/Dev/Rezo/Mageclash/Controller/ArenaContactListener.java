package Dev.Rezo.Mageclash.Controller;

import Dev.Rezo.Mageclash.Model.Entity;
import Dev.Rezo.Mageclash.Model.PlayerEntity;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

public class ArenaContactListener implements ContactListener {

	@Override
	public void beginContact(Contact contact) {
		Object dA = contact.getFixtureA().getBody().getUserData();
		Object dB = contact.getFixtureB().getBody().getUserData();
		PlayerEntity pEntity = null;
		Entity entity = null;

		if(dA instanceof PlayerEntity) {
			pEntity = (PlayerEntity) dA;
			entity = (Entity) dB;
		} else if(dB instanceof PlayerEntity) {
			pEntity = (PlayerEntity) dB;
			entity = (Entity) dA;
		}
		if(pEntity == null || entity == null) return;
		pEntity.HEALTH -= 20;
		entity.deleteThis = true;
	}

	@Override
	public void endContact(Contact contact) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void preSolve(Contact contact, Manifold oldManifold) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postSolve(Contact contact, ContactImpulse impulse) {
		// TODO Auto-generated method stub
		
	}

}
