package dev.rezo.mageclash.core.Model;

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
	public SpellButton(Vector2 location,short playerID,int buttonnumber){
		this.location = location;
		this.playerID = playerID;
		this.buttonnumber = buttonnumber;
	}
}
