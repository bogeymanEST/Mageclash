package Dev.Rezo.Mageclash;

import Dev.Rezo.Mageclash.Model.*;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
//-- Just a playerclass, this is from where the coordinates are adjusted for the movement process. 
//-- This also stores the spells available to either player respectively. 
//-- There are two of these in the Arena. player1 and player2**** (not yet implemented)
public class MagePlayer {
	public enum State {
		IDLE, WALKING, STUNNED, CASTING, DEAD
	}
	public static final float SPEED = 4f;
	public static final float SIZE = 1f;
	
	Vector2	position = new Vector2();
	Vector2	velocity = new Vector2();
	Rectangle bounds = new Rectangle();
	State	state = State.IDLE;
	float facingrot = 0;
	public Array<Spell> spellBook = new Array<Spell>();
	
	public MagePlayer(Vector2 position) {
		this.position = position;
		this.bounds.height = SIZE;
		this.bounds.width = SIZE;
	}
	public Vector2 getPosition(){
		return position;
	}
	public Rectangle getBounds() {
		return bounds;
	}
	public Vector2 getVelocity() {
		return velocity;
	}
	public State getState() {
		return state;
	}
	public void setState(State newState) {
		this.state = newState;
	}
	public void setVelocity(float x, float y){
		velocity.x = x;
		velocity.y = y;
	}
	//-- spellBook processing --//
	public void addToSpellBook(Spell spell) {
		spellBook.add(spell);
	}
	public Spell getFromSpellBook(int index) {
		return spellBook.get(index);
	}
	//--//
	public void update(float delta) {
		if (delta != 0){
		position.add(velocity.scl(delta)); 
		}
	}
	
}