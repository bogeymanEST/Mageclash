package Dev.Rezo.Mageclash;

import Dev.Rezo.Mageclash.Model.BoundryWall;
import Dev.Rezo.Mageclash.Model.Player;
import Dev.Rezo.Mageclash.Model.PlayerEntity;
import Dev.Rezo.Mageclash.Model.SpellButton;
import Dev.Rezo.Mageclash.Model.SpellType;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.physics.box2d.*;


public class Arena {
	public World world;
	//--- Player entities ---
	public PlayerEntity playerentity1;
	public PlayerEntity playerentity2;
	public SpellButton spellbutton1;
	
	public Arena(){
		world = new World(new Vector2(0, 0), true);
		
		// Side walls
		BoundryWall.create(new Vector2(-0.5f,4.5f), new Vector2(0.5f,9f), this);
		BoundryWall.create(new Vector2(16.5f,4.5f), new Vector2(0.5f,9f), this);
		// Roof and floor
		BoundryWall.create(new Vector2(8f,-0.5f), new Vector2(16,0.5f), this);
		BoundryWall.create(new Vector2(8f,9.5f), new Vector2(16,0.5f), this);
		
		playerentity1 = Player.create(5f,5f,(short)-1,world);
		playerentity1.addToSpellBook(SpellType.FIREBALL.spell);
		playerentity2 = Player.create(14f,5f,(short)-2,world);
		spellbutton1 = new SpellButton(new Vector2(0.5f,0.5f),(short)-1,1);
	}


}
