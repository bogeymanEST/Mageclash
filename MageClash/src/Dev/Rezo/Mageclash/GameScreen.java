package Dev.Rezo.Mageclash;

import Dev.Rezo.Mageclash.Arena;
import Dev.Rezo.Mageclash.ArenaRenderer;
import Dev.Rezo.Mageclash.Controller.ArenaController;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.math.Vector2;

public class GameScreen implements Screen,InputProcessor {

//-- This is where the magic happens (here be dragons)
	private Arena arena;
	private ArenaRenderer renderer;
	private ArenaController controller;
	public int scWidth = Gdx.graphics.getWidth();
	public int scHeight = Gdx.graphics.getHeight();
	public float touchX;
	public float touchY;
	public boolean xWasNeg = false;
	public boolean yWasNeg = false;
	public float sprechenXY;
	public double multip;
	public double multipX;
	public double multipY;
	//private int width,height;
	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		controller.update(delta);
		renderer.render();
		
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void show() {
		arena = new Arena();
		renderer = new ArenaRenderer(arena);
		controller = new ArenaController(arena);
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
		
	}
	@Override
	public boolean keyDown(int keycode) {
		if (keycode == Keys.LEFT)
			controller.leftPressed();
		if (keycode == Keys.RIGHT)
			controller.rightPressed();
		if (keycode == Keys.UP)
			controller.upPressed();
		if (keycode == Keys.DOWN)
			controller.downPressed();
		return true;
	

}

	@Override
	public boolean keyUp(int keycode) {
		if (keycode == Keys.LEFT)
			controller.leftReleased();
		if (keycode == Keys.RIGHT)
			controller.rightReleased();
		if (keycode == Keys.UP)
			controller.upReleased();
		if (keycode == Keys.DOWN)
			controller.downReleased();
		return true;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		touchX=(((float)screenX)/(float)scWidth)*renderer.cam.viewportWidth;
		touchY=(float)(scHeight-screenY)/scHeight*renderer.cam.viewportHeight;
		
		Vector2 changevector = new Vector2(
				(touchX-(arena.player1.getPosition().x)),
				(touchY-(arena.player1.getPosition().y)));
		
		if (changevector.x > 0.0f){
			xWasNeg = false;
		}
		else{
			xWasNeg = true;
			changevector.x = Math.abs(changevector.x);
		}
		if (changevector.y > 0.0f){
			yWasNeg = false;
		}
		else{
			changevector.y = Math.abs(changevector.y);
			yWasNeg = true;
		}
		//---
		
		sprechenXY = (changevector.x/changevector.y);
		double multip = (double)sprechenXY;
		multip = Math.atan(multip);
		multipY = Math.cos(multip);
		multipX = Math.sin(multip);
		changevector = new Vector2(MagePlayer.SPEED*(float)multipX,MagePlayer.SPEED*(float)multipY);
		
		
		if (xWasNeg==true){
			changevector.x=-changevector.x;
		}
		if (yWasNeg==true){
			changevector.y=-changevector.y;
		}
		
		
		controller.setPlayer1Velocity(changevector.x, changevector.y);
		return true;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		controller.desetPlayer1Velocity();
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		touchX=(((float)screenX)/(float)scWidth)*renderer.cam.viewportWidth;
		touchY=(float)(scHeight-screenY)/scHeight*renderer.cam.viewportHeight;
		
		Vector2 changevector = new Vector2(
				(touchX-(arena.player1.getPosition().x)),
				(touchY-(arena.player1.getPosition().y)));
		
		if (changevector.x > 0.0f){
			xWasNeg = false;
		}
		else{
			xWasNeg = true;
			changevector.x = Math.abs(changevector.x);
		}
		if (changevector.y > 0.0f){
			yWasNeg = false;
		}
		else{
			changevector.y = Math.abs(changevector.y);
			yWasNeg = true;
		}
		
		
		sprechenXY = (changevector.x/changevector.y);
		double multip = (double)sprechenXY;
		multip = Math.atan(multip);
		multipY = Math.cos(multip);
		multipX = Math.sin(multip);
		changevector = new Vector2(MagePlayer.SPEED*(float)multipX,MagePlayer.SPEED*(float)multipY);
		
		
		if (xWasNeg==true){
			changevector.x=-changevector.x;
		}
		if (yWasNeg==true){
			changevector.y=-changevector.y;
		}
		
		
		controller.setPlayer1Velocity(changevector.x, changevector.y);
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}