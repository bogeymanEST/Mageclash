package Dev.Rezo.Mageclash.Model;

import Dev.Rezo.Mageclash.Arena;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;

public class BoundryWall {
	public static void create(Vector2 position, Vector2 parameters, Arena arena){
		
		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.StaticBody;
		bodyDef.position.set(position);
		Body body = arena.world.createBody(bodyDef);
		
		PolygonShape polShape = new PolygonShape();
		polShape.setAsBox(parameters.x/2,parameters.y/2);
		
		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = polShape;
		fixtureDef.density = 1.0f;
		fixtureDef.friction = 1.0f;
		fixtureDef.restitution = 1.0f;
		fixtureDef.filter.groupIndex = 3;
		body.createFixture(fixtureDef);
		
		polShape.dispose();
	}

}
