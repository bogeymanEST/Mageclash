package Dev.Rezo.Mageclash.Controller;

import Dev.Rezo.Mageclash.Model.Entity;
import Dev.Rezo.Mageclash.Model.PlayerEntity;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

public class ArenaContactListener implements ContactListener {
Entity fixA;
Entity fixB;

	@Override
	public void beginContact(Contact contact) {
		// TODO Auto-generated method stub
		fixA = (Entity) contact.getFixtureA().getUserData();
		fixB = (Entity) contact.getFixtureB().getUserData();
		if (fixA instanceof PlayerEntity){
			((PlayerEntity) fixA).HEALTH = ((PlayerEntity) fixA).HEALTH - 20;
			if (((PlayerEntity) fixA).HEALTH < 0){
			}
			fixB.deleteThis=true;
		}
		if (fixB instanceof PlayerEntity){
			((PlayerEntity) fixB).HEALTH = ((PlayerEntity) fixB).HEALTH - 20;
			fixA.deleteThis=true;
		}
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
