package Dev.Rezo.Mageclash.Model;

import Dev.Rezo.Mageclash.MagePlayer.State;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class PlayerEntity extends Entity{
	public enum State {
		IDLE, WALKING, SLOWED, STUNNED, CASTING, DEAD
	}
	public static final float SPEED = 4f;
	public static final float SLOWSPEED = 2f;
	public int HEALTH = 100;
	State	state = State.IDLE;
	public Array<Spell> spellBook = new Array<Spell>();

	public State getState() {
		return state;
	}
	public void setState(State newState) {
		this.state = newState;
	}
	//-- spellBook processing --//
	public void addToSpellBook(Spell spell) {
		spellBook.add(spell);
	}
	public Spell getFromSpellBook(int index) {
		return spellBook.get(index);
	}
	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHit() {
		// TODO Auto-generated method stub
		
	}
}
