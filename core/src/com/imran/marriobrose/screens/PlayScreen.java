package com.imran.marriobrose.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.imran.marriobrose.MarioBrose;
import com.imran.marriobrose.scene.Hud;

/**
 * Created by Imran on 6/22/2016.
 */
public class PlayScreen implements Screen {

    private MarioBrose mGame;
    public Hud hud;

    Texture mTexture;
    private OrthographicCamera gamecam;
    private Viewport gameProt;

    public PlayScreen(MarioBrose game) {
        this.mGame = game;
//        mTexture= new Texture("badlogic.jpg");
        gamecam = new OrthographicCamera();
        gameProt = new FillViewport(MarioBrose.v_WIDTH, MarioBrose.v_HIGHT, gamecam);
        hud = new Hud(game.batch);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
       // Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        mGame.batch.setProjectionMatrix(hud.mstage.getCamera().combined);
        hud.mstage.draw();
    }

    @Override
    public void resize(int width, int height) {
        gameProt.update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
