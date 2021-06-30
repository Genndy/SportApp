package com.genndy.sportapp.preloader.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.genndy.sportapp.R;
import com.genndy.sportapp.content.gallery.db.DataBaseManagerGallery;
import com.genndy.sportapp.content.gallery.models.Photo;
import com.genndy.sportapp.content.players.db.DataBaseManagerPlayers;
import com.genndy.sportapp.content.players.model.Player;
import com.genndy.sportapp.content.rules.db.DataBaseManagerRules;
import com.genndy.sportapp.content.rules.models.Rules;
import com.genndy.sportapp.menu.db.DataBaseManagerMenu;
import com.genndy.sportapp.menu.models.Game;
import com.genndy.sportapp.menu.ui.MenuActivity;
import com.genndy.sportapp.preloader.mockdata.MockData;

import java.util.List;

public class PreloaderActivity extends AppCompatActivity {
//            AppCompatImageView
    ImageView mAppLogo;
    ImageView mCircle1;
    ImageView mCircle2;
    ImageView mCircle3;
    Animation actionUp1;
    Animation actionDown1;
    Animation actionStart1;
    Animation actionUp2;
    Animation actionDown2;
    Animation actionStart2;
    Animation actionUp3;
    Animation actionDown3;
    Animation actionStart3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preloader);
        mAppLogo = (ImageView) findViewById(R.id.app_logo);
        mCircle1 = (ImageView) findViewById(R.id.circle1);
        mCircle2 = (ImageView) findViewById(R.id.circle2);
        mCircle3 = (ImageView) findViewById(R.id.circle3);
        actionStart1 = AnimationUtils.loadAnimation(this, R.anim.action_up_start);
        actionUp1 = AnimationUtils.loadAnimation(this, R.anim.action_up);
        actionDown1 = AnimationUtils.loadAnimation(this, R.anim.action_down);
        actionStart2 = AnimationUtils.loadAnimation(this, R.anim.action_up_start);
        actionUp2 = AnimationUtils.loadAnimation(this, R.anim.action_up);
        actionDown2 = AnimationUtils.loadAnimation(this, R.anim.action_down);
        actionStart3 = AnimationUtils.loadAnimation(this, R.anim.action_up_start);
        actionUp3 = AnimationUtils.loadAnimation(this, R.anim.action_up);
        actionDown3 = AnimationUtils.loadAnimation(this, R.anim.action_down);

        playAnimation();
        // Тут ещё надо бы провести проверку на целостность данных. В частности фотки
        loadMockData();
//        mockLoading();
    }


    private void loadMockData(){
        MockData mockData = new MockData();

        DataBaseManagerMenu dataBaseManagerMenu = new DataBaseManagerMenu(this);
        DataBaseManagerPlayers dataBaseManagerPlayers
                = new DataBaseManagerPlayers(this);

        DataBaseManagerRules dataBaseManagerRules = new DataBaseManagerRules(this);

        DataBaseManagerGallery dataBaseManagerGallery
                = new DataBaseManagerGallery(this);

        dataBaseManagerRules.dropTableIfExist();
        dataBaseManagerRules.createTableIfNotExist();

        dataBaseManagerGallery.dropTableIfExist();
        dataBaseManagerGallery.createTableIfNotExist();

        dataBaseManagerPlayers.dropTableIfExist();
        dataBaseManagerPlayers.createTableIfNotExist();

        dataBaseManagerMenu.dropTableIfExist();
        dataBaseManagerMenu.createTableIfNotExist();

        List<Game> games = mockData.getGames();
        List<Player> players = mockData.getPlayers();
        List<Rules> rules = mockData.getRules();
        List<Photo> photos = mockData.getPhotos();

        for(int i = 0; i < games.size(); i++){
            String id = games.get(i).get_id();
            String name = games.get(i).getName();
            String photoURL = games.get(i).getPhotoURL();
            dataBaseManagerMenu.insertToDB(id, name, photoURL);
        }

        for(int i = 0; i < players.size(); i++){
            String id = players.get(i).get_id();
            String name = players.get(i).getName();
            String gameName = players.get(i).getGame();
            String photoURL = players.get(i).getPhotoURL();
            dataBaseManagerPlayers.insertToDB(id, name, gameName, photoURL);
        }

        for(int i = 0; i < rules.size(); i++){
            String id = rules.get(i).get_id();
            String name = rules.get(i).getName();
            String text = rules.get(i).getText();
            dataBaseManagerRules.insertToDB(id, name, text);
        }

        for(int i = 0; i < photos.size(); i++){
            String id = photos.get(i).get_id();
            String photoURL = photos.get(i).getPhotoURL();
            String gameName = photos.get(i).getGameName();
            dataBaseManagerGallery.insertToDB(id, photoURL, gameName);
        }

        mockLoading();
    }

    private void mockLoading(){
        Handler handlerTimer = new Handler(Looper.getMainLooper());

        handlerTimer.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(PreloaderActivity.this, MenuActivity.class);
                startActivity(intent);
            }
        }, 5000);
    }

    private void playAnimation() {
        Handler handler1 = new Handler(Looper.getMainLooper());
        Handler handler2 = new Handler(Looper.getMainLooper());
        Handler handler3 = new Handler(Looper.getMainLooper());

        playAnimation1();

        handler2.postDelayed(new Runnable() {
            public void run() {
                playAnimation2();
            }
        }, 500); //specify the number of milliseconds
        handler3.postDelayed(new Runnable() {
            public void run() {
                playAnimation3();
            }
        }, 1000); //specify the number of milliseconds

        handler1.postDelayed(new Runnable() {
            public void run() {
                playAnimation();
            }
        }, 1500); //specify the number of milliseconds

    }

    private void playAnimation1() {
        mCircle1.startAnimation(actionStart1);
        mCircle1.startAnimation(actionDown1);
        mCircle2.startAnimation(actionUp1);
    }

    private void playAnimation2() {
        mCircle2.startAnimation(actionDown2);
        mCircle3.startAnimation(actionUp2);
    }

    private void playAnimation3() {
        mCircle1.startAnimation(actionUp3);
        mCircle3.startAnimation(actionDown3);
    }


}