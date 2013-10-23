package Dev.Rezo.Mageclash;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.physics.box2d.*;

public class Arena {
	public World world;
	//--- Deprecated ---
	public Array<RockProjectile> projectiles = new Array<RockProjectile>();
	public MagePlayer player1;
	//------------------
	
	//--- Get this stuff for upper classes
	public MagePlayer getPlayer1(){
		return player1;
	}
	public Array<RockProjectile> getProjectiles() {
		return projectiles;
	}
	//---
	public Arena(){
		world = new World(new Vector2(0, 0), true);
		createDemoArena();
	}
	private void createDemoArena(){
		player1 = new MagePlayer(new Vector2(7,2));
		projectiles.add(new RockProjectile(new Vector2(7,4)));
		projectiles.add(new RockProjectile(new Vector2(9,2)));
		projectiles.add(new RockProjectile(new Vector2(1,1)));
	}


}
