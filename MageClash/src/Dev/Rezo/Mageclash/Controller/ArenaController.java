package Dev.Rezo.Mageclash.Controller;

import java.util.HashMap;
import java.util.Map;


import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.math.Vector2;

import Dev.Rezo.Mageclash.MagePlayer;
import Dev.Rezo.Mageclash.MagePlayer.State;
import Dev.Rezo.Mageclash.Arena;
import Dev.Rezo.Mageclash.RockProjectile;


public class ArenaController {
	enum Keys {
		LEFT,RIGHT,UP,DOWN,TOUCHED
		}
	private Vector2 touchVelocity; 
	private Arena arena;
	private MagePlayer player1;
	static Map<Keys, Boolean> keys = new HashMap<ArenaController.Keys, Boolean>();
	static {
		keys.put(Keys.LEFT, false);
		keys.put(Keys.RIGHT, false);
		keys.put(Keys.UP, false);
		keys.put(Keys.DOWN, false);
		keys.put(Keys.TOUCHED, false);

	};
	// Collision not yet implemented
	// private Array<RockProjectile> collidable = new Array<RockProjectile>();
	public ArenaController(Arena arena) {
		this.arena = arena;
		this.player1 = arena.getPlayer1();
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
	//-- Update method
	public void update(float delta) {
		processInput();
		player1.update(delta);
		}
	//-- Setting player velocity on click
	public void setPlayer1Velocity(float x, float y){
		touchVelocity = new Vector2(x,y);
		keys.get(keys.put(Keys.TOUCHED, true));
	}
	public void desetPlayer1Velocity() {
		keys.get(keys.put(Keys.TOUCHED, false));
	}
	private void processInput() {
		if (keys.get(Keys.LEFT)) {
			player1.setState(State.WALKING);
			player1.getVelocity().x = -MagePlayer.SPEED;
		}
		if (keys.get(Keys.RIGHT)) {
			player1.setState(State.WALKING);
			player1.getVelocity().x = MagePlayer.SPEED;
		}
		if (keys.get(Keys.UP)) {
			player1.setState(State.WALKING);
			player1.getVelocity().y = MagePlayer.SPEED;
		}
		if (keys.get(Keys.DOWN)) {
			player1.setState(State.WALKING);
			player1.getVelocity().y = -MagePlayer.SPEED;
		}
		if (keys.get(Keys.LEFT) && keys.get(Keys.RIGHT) ||
				(!(keys.get(Keys.LEFT)) && !(keys.get(Keys.RIGHT)))){
			player1.setState(State.IDLE);
			player1.getVelocity().x = 0;
		}
		if (keys.get(Keys.UP) && keys.get(Keys.DOWN) ||
				(!(keys.get(Keys.UP)) && !(keys.get(Keys.DOWN)))){
			player1.setState(State.IDLE);
			player1.getVelocity().y = 0;
		}
		if (keys.get(Keys.TOUCHED)) {
			player1.setState(State.WALKING);
			player1.getVelocity().x = (float)touchVelocity.x;
			player1.getVelocity().y = (float)touchVelocity.y;
			System.out.println("ITS HABBENING");
			System.out.println(touchVelocity.x);
			System.out.println(touchVelocity.y);
			System.out.println(player1.getVelocity().x);
			System.out.println(player1.getVelocity().y);
		}
	}

}
