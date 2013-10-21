package Dev.Rezo.Mageclash;

import Dev.Rezo.Mageclash.Arena;
import Dev.Rezo.Mageclash.MagePlayer;
import Dev.Rezo.Mageclash.RockProjectile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Circle;

public class ArenaRenderer {
	public Arena arena;
	public OrthographicCamera cam;
	
	//-- Debug Rendering --//
	ShapeRenderer debugRenderer = new ShapeRenderer();
	
	public ArenaRenderer(Arena arena){
		this.arena = arena;
		this.cam = new OrthographicCamera(16, 9);
		this.cam.position.set(8, 4.5f, 0);
		this.cam.update();
	}
	//public void setPlayer1(MagePlayer newplayer1){
	//	this.arena.player1 = newplayer1;
	//}
	public void render(){
		//* RenderProjectile
		debugRenderer.setProjectionMatrix(cam.combined);
		debugRenderer.begin(ShapeType.Line);
		for (RockProjectile projectile: arena.getProjectiles()){
			Circle circ = projectile.getBounds();
			float x1 = projectile.getPosition().x + circ.x;
			float y1 = projectile.getPosition().y + circ.y;
			debugRenderer.setColor(new Color(1, 0, 0, 1));
			debugRenderer.circle(x1, y1, circ.radius, 20);
		}
		//debugRenderer.end();
		//debugRenderer.setProjectionMatrix(cam.combined);
		//debugRenderer.begin(ShapeType.Line);
		MagePlayer player1 = arena.getPlayer1();
		Rectangle rect = player1.getBounds();
		float x1 = player1.getPosition().x + rect.x;
		float y1 = player1.getPosition().y + rect.y;
		debugRenderer.setColor(new Color(0, 1, 0, 1));
		debugRenderer.rect(x1, y1, rect.width, rect.height);
		debugRenderer.end();
	}
	

}
