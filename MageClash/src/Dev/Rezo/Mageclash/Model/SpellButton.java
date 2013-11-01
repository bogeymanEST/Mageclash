package Dev.Rezo.Mageclash.Model;

import Dev.Rezo.Mageclash.ArenaRenderer;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

/**
 * This class handles button rendering and is used to find, if any buttons were pressed.
 * @author Rezonance
 *
 */
public class SpellButton {
	Vector2 location;
	short playerID;
	int buttonnumber;
	static float SIZE=1f;
	Color color= new Color(1,1,1,1);
	public SpellButton(Vector2 location,short playerID,int buttonnumber){
		this.location = location;
		this.playerID = playerID;
		this.buttonnumber = buttonnumber;
	}
	public void render(ArenaRenderer renderer){
		renderer.debugRenderer.setColor(color);
		renderer.debugRenderer.rect(location.x, location.y, SIZE, SIZE);
	}
	public boolean isTouched(Vector2 touchlocation){
		boolean touchdetected=false;
		color= new Color(1,1,1,1);
		if (touchlocation.x > location.x && touchlocation.x < (location.x+SIZE)){
			if (touchlocation.y > location.y && touchlocation.y < (location.y+SIZE)){
				touchdetected=true;
				if (color.b != 0){
					color= new Color(1,0,0,1);
				}
			}
		}
		return touchdetected;
	}
}
