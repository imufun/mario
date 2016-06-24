package com.imran.marriobrose.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
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


    private TmxMapLoader mMapLoader;
    private TiledMap map;
    protected OrthogonalTiledMapRenderer render;

    //Box2s variable
    
    public PlayScreen(MarioBrose game) {
        this.mGame = game;
//        mTexture= new Texture("badlogic.jpg");
        gamecam = new OrthographicCamera();
        gameProt = new FillViewport(MarioBrose.v_WIDTH, MarioBrose.v_HIGHT, gamecam);
        hud = new Hud(game.batch);

        mMapLoader = new TmxMapLoader();
        map = mMapLoader.load("level1.tmx");
        render = new OrthogonalTiledMapRenderer(map);
        gamecam.position.set(gameProt.getScreenWidth() / 2, gameProt.getScreenHeight() / 2, 0);
    }

    @Override
    public void show() {

    }

    public void handleInput(float dt) {
        if (Gdx.input.isTouched())
            gamecam.position.x += 100 * dt;
    }

    public void update(float dt) {
        handleInput(dt);
        gamecam.update();
        render.setView(gamecam);
    }

    @Override
    public void render(float delta) {
        update(delta);
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        render.render();
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
