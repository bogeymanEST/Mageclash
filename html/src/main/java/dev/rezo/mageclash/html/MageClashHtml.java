package dev.rezo.mageclash.html;

import dev.rezo.mageclash.core.MageClashGame;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;

public class MageClashHtml extends GwtApplication {
	@Override
	public ApplicationListener getApplicationListener () {
		return new MageClashGame();
	}
	
	@Override
	public GwtApplicationConfiguration getConfig () {
		return new GwtApplicationConfiguration(480, 320);
	}
}
