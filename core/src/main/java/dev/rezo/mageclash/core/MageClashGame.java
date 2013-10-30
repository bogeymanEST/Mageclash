package dev.rezo.mageclash.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;

public class MageClashGame extends Game {
    @Override
    public void create() {
        setScreen(new GameScreen());
    }
}
