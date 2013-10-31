package dev.rezo.mageclash.core;

import dev.rezo.mageclash.core.Arena;
import dev.rezo.mageclash.core.ArenaRenderer;
import dev.rezo.mageclash.core.Controller.ArenaController;
import dev.rezo.mageclash.core.Model.PlayerEntity;
import dev.rezo.mageclash.core.Model.PlayerEntity.State;

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

    /**
     * Gets a vector pointing from the player to the touch location that has a length of {@link PlayerEntity#SPEED}.
     * @param touchX The X coordinate of the touch
     * @param touchY The Y coordinate of the touch
     * @param player The player whose location is the origin of the vector
     * @return A vector pointing from the player to the touch location that has a length of {@link PlayerEntity#SPEED}.
     */
    public Vector2 getVelocityVector(float touchX, float touchY, PlayerEntity player) {
        return new Vector2(touchX, touchY).sub(player.body.getPosition()).nor().scl(PlayerEntity.SPEED);
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touchX=(((float)screenX)/(float)scWidth)*renderer.cam.viewportWidth;
        touchY=(float)(scHeight-screenY)/scHeight*renderer.cam.viewportHeight;

        Vector2 velocity = getVelocityVector(touchX, touchY, arena.playerentity1);
        arena.playerentity1.setVelocity(velocity.x, velocity.y);
        arena.playerentity1.targetlocation = new Vector2(touchX, touchY);
        arena.playerentity1.setState(State.WALKING);
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        touchX=(((float)screenX)/(float)scWidth)*renderer.cam.viewportWidth;
        touchY=(float)(scHeight-screenY)/scHeight*renderer.cam.viewportHeight;
        Vector2 velocity = getVelocityVector(touchX, touchY, arena.playerentity1);
        arena.playerentity1.setVelocity(velocity.x, velocity.y);
        arena.playerentity1.targetlocation = new Vector2(touchX, touchY);
        arena.playerentity1.setState(State.WALKING);
        return true;
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