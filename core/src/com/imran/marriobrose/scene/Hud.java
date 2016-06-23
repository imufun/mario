package com.imran.marriobrose.scene;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.imran.marriobrose.MarioBrose;


/**
 * Created by Imran on 6/22/2016.
 */
public class Hud {

    public Stage mstage;
    private Viewport mViewport;

    private Integer worldTimer;
    private float timeCount;
    private Integer score;


    Label countdownlabel;
    Label scoreLable;
    Label timeLable;
    Label levelLable;
    Label worldLable;
    Label marioLable;

    public Hud(SpriteBatch sb) {
        worldTimer = 300;
        timeCount = 0;
        score = 0;

        mViewport = new FillViewport(MarioBrose.v_WIDTH, MarioBrose.v_HIGHT, new OrthographicCamera());
        mstage = new Stage(mViewport, sb);

        Table table = new Table();
        table.top();
        table.setFillParent(true);


        countdownlabel = new Label(String.format("%3d", worldTimer), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        scoreLable = new Label(String.format("%6d", scoreLable), new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        timeLable = new Label("TIME", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        levelLable = new Label("1-1", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        worldLable = new Label("WORLD", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        marioLable = new Label("MARIO", new Label.LabelStyle(new BitmapFont(), Color.WHITE));


        table.add(marioLable).expandX().padTop(10);
        table.add(worldLable).expandX().padTop(10);
        table.add(timeLable).expandX().padTop(10);
        table.row();

        table.add(scoreLable).expandX();
        table.add(levelLable).expandX();
        table.add(countdownlabel).expandX();

        mstage.addActor(table);
    }
}
