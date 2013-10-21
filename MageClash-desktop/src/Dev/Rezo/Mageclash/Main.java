package Dev.Rezo.Mageclash;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class Main {
	public static void main(String[] args) {
		new LwjglApplication(new MageClashGame(), "Mage Clash", 1280, 720, true);
	}
}
