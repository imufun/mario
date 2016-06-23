package com.imran.marriobrose;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.imran.marriobrose.screens.PlayScreen;

public class MarioBrose extends Game {
	public static final int v_WIDTH = 400;
	public static final int v_HIGHT=208;
	public SpriteBatch batch;

	
	@Override
	public void create () {
 		batch = new SpriteBatch();
  		setScreen(new PlayScreen(this));
	}

	@Override
	public void render () {
		super.render();
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		batch.draw(img, 0, 0);
//		batch.end();
	}
}
