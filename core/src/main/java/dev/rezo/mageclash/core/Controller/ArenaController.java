package dev.rezo.mageclash.core.Controller;

import java.util.HashMap;
import java.util.Map;


import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.math.Vector2;
import dev.rezo.mageclash.core.Arena;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import dev.rezo.mageclash.core.Model.Entity;
import dev.rezo.mageclash.core.Model.PlayerEntity;
import dev.rezo.mageclash.core.Model.PlayerEntity.State;


public class ArenaController {
	/**
	 * Keys are DEPRECATED for now. Kept in for future possibility of arrow controls. Currently of no actual relevance.
	 * @author Rezonance
	 *
	 */
	enum Keys {
		LEFT,RIGHT,UP,DOWN,TOUCHED
		} 
	private Arena arena;
	private PlayerEntity playerentity;
	static Map<Keys, Boolean> keys = new HashMap<Keys, Boolean>();
	public ArenaController(Arena arena) {
		this.arena = arena;
		this.playerentity = arena.playerentity1;
	}

	// CONTROLLS
	public void leftPressed() {
		keys.get(keys.put(Keys.LEFT, true));
	}
	public void rightPressed() {
		keys.get(keys.put(Keys.RIGHT, true));
	}
	public void upPressed() {
		keys.get(keys.put(Keys.UP, true));
	}
	public void downPressed() {
		keys.get(keys.put(Keys.DOWN, true));
	}
	public void leftReleased() {
		keys.get(keys.put(Keys.LEFT, false));
	}
	public void rightReleased() {
		keys.get(keys.put(Keys.RIGHT, false));
	}
	public void upReleased() {
		keys.get(keys.put(Keys.UP, false));
	}
	public void downReleased() {
		keys.get(keys.put(Keys.DOWN, false));
	}
	//--------------------------------------------
	//------------- Update method
	//-- THE MOST IMPORTAND PART OF THIS CLASS
	//--------------------------------------------
	public void update(float delta) {
		arena.playerentity1.checkSpeed();
		arena.world.step(1 / 30f, 6, 2);
		Array<Body> bodies = new Array<Body>();
		arena.world.getBodies(bodies);
		for(Body body : bodies) {
			if(body == null) continue;
			Entity data = (Entity) body.getUserData();
			if(data == null) continue;
			if(data.deleteThis) {
				arena.world.destroyBody(body);
				continue;
				}
		}
	}

}
