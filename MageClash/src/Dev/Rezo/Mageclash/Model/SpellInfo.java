package Dev.Rezo.Mageclash.Model;

import com.badlogic.gdx.math.Vector2;
import Dev.Rezo.Mageclash.Arena;

public class SpellInfo {
	Arena arena;
	Vector2 playerposition;
	Vector2 firedirection;
	short playerID;
	public SpellInfo(Arena arena,Vector2 playerposition,Vector2 firedirection,short playerID){
		this.arena = arena;
		this.playerposition = playerposition;
		this.firedirection = firedirection;
		this.playerID = playerID;
	}
}
