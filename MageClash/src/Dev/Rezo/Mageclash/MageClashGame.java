package Dev.Rezo.Mageclash;

import com.badlogic.gdx.Game;
import Dev.Rezo.Mageclash.GameScreen;
// Place from where the game is started, not of much relevance
public class MageClashGame extends Game {
	@Override
	public void create() {
		setScreen(new GameScreen());
	}

}
