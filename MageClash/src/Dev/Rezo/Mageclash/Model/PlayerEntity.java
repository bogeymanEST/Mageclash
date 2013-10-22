package Dev.Rezo.Mageclash.Model;

import Dev.Rezo.Mageclash.MagePlayer.State;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

public class PlayerEntity extends Entity{

	@Override
	public void render() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHit() {
		// TODO Auto-generated method stub
		
	}
	public enum State {
		IDLE, WALKING, STUNNED, CASTING, DEAD, SLOWED
	}
	public static final float SPEED = 4f;
	State	state = State.IDLE;
	public Array<Spell> spellBook = new Array<Spell>();

	public State getState() {
		return state;
	}
	public void setState(State newState) {
		this.state = newState;
	}
	public void setVelocity(float x, float y){
	//-- Sets the velocity via body --//
	}
	//-- spellBook processing --//
	public void addToSpellBook(Spell spell) {
		spellBook.add(spell);
	}
	public Spell getFromSpellBook(int index) {
		return spellBook.get(index);
	}

}
