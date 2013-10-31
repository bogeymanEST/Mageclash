package Dev.Rezo.Mageclash;

import Dev.Rezo.Mageclash.Arena;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import Dev.Rezo.Mageclash.Model.Entity;

public class ArenaRenderer {
	public Arena arena;
	public OrthographicCamera cam;
	
	//-- Debug Rendering --//
	public ShapeRenderer debugRenderer = new ShapeRenderer();
	
	public ArenaRenderer(Arena arena){
		this.arena = arena;
		this.cam = new OrthographicCamera(16, 9);
		this.cam.position.set(8, 4.5f, 0);
		this.cam.update();
	}
	public void render(){
		// Body-based renderloop goes here
		Array<Body> bodies = new Array<Body>();
		arena.world.getBodies(bodies);
		debugRenderer.setProjectionMatrix(cam.combined);
		debugRenderer.begin(ShapeType.Filled);
		for(Body body : bodies) {
			if(body == null) continue;
			Entity data = (Entity) body.getUserData();
			if(data == null) continue;
			data.render(this);
			
		}
		arena.spellbutton1.render(this);
		debugRenderer.end();
	}
	

}
