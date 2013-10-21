package Dev.Rezo.Mageclash;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
public class RockProjectile {
//-- Currently just irrelevant circles on the screen	
	static final float SIZE = 0.5f;
	
	Vector2	position = new Vector2();
	Vector2	velocity = new Vector2();
	Circle	bounds = new Circle();
	
	public RockProjectile(Vector2 pos) {
		this.position = pos;
		this.bounds.radius = SIZE;
		}
	public Circle getBounds(){
		return bounds;
	}
	public Vector2 getPosition(){
		return position;
	}
	
	}
