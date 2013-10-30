package dev.rezo.mageclash.core.Model;
import dev.rezo.mageclash.core.Arena;
import dev.rezo.mageclash.core.ArenaRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.physics.box2d.*;
public abstract class Entity {
	public boolean deleteThis;
	public Body body;
	public abstract void render(ArenaRenderer renderer);
	public abstract void onHit();
    public final void setVelocity(float x, float y) {
        body.setLinearVelocity(x, y);
    }

}