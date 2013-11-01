package Dev.Rezo.Mageclash.Model;

import com.badlogic.gdx.math.Vector2;
import Dev.Rezo.Mageclash.Arena;

/**
 * @author Rezonance
 *
 */
public class SpellInfo {
	
	Arena arena;
	Vector2 playerposition;
	Vector2 firedirection;
	short playerID;
	/**
	 * 
	 * @param arena - Usual arena class, it just needs it to add objects to world ect.
	 * @param playerposition - The location of the player who casts the spell
	 * @param firedirection - The normalized vector where it is going to
	 * @param playerID - The collision ID of the player who casts the spell
	 */
	public SpellInfo(Arena arena,Vector2 playerposition,Vector2 firedirection,short playerID){
		this.arena = arena;
		this.playerposition = playerposition;
		this.firedirection = firedirection;
		this.playerID = playerID;
	}
}
