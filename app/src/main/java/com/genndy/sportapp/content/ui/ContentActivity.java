package com.genndy.sportapp.content.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.genndy.sportapp.R;
import com.genndy.sportapp.content.gallery.ui.GalleryFragment;
import com.genndy.sportapp.content.players.ui.PlayersFragment;
import com.genndy.sportapp.content.rules.ui.RulesFragment;

public class ContentActivity extends AppCompatActivity {
    private Adapter adapter;
    private ViewPager2 mFragmentContainer;
    private Intent intent;
    private String gameName;

    private ImageView mToolbarButtonRules;
    private ImageView mToolbarButtonPlayers;
    private ImageView mToolbarButtonGallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        intent = getIntent();
        gameName = intent.getStringExtra("game_name");

        mToolbarButtonPlayers = (ImageView) findViewById(R.id.toolbar_button_players);
        mToolbarButtonRules = (ImageView) findViewById(R.id.toolbar_button_rules);
        mToolbarButtonGallery = (ImageView) findViewById(R.id.toolbar_button_gallery);
        mFragmentContainer = (ViewPager2) findViewById(R.id.fragment_container_view);

        adapter = new Adapter(ContentActivity.this);
        adapter.createFragment(0);
        adapter.createFragment(1);
        adapter.createFragment(2);

        mFragmentContainer.setAdapter(adapter);
        //

        mToolbarButtonRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.createFragment(0);
                mFragmentContainer.setCurrentItem(0, false);
                System.out.println("Rules button clicked");
            }
        });

        mToolbarButtonPlayers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.createFragment(1);
                mFragmentContainer.setCurrentItem(1, false);
                System.out.println("Players button clicked");
            }
        });

        mToolbarButtonGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.createFragment(2);
                mFragmentContainer.setCurrentItem(2, false);
                System.out.println("Gallery button clicked");
            }
        });

        getSupportActionBar().setTitle(gameName == null ? "" : gameName);
    }

    //****************

    public class Adapter extends FragmentStateAdapter {
        public Adapter(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @Override
        public Fragment createFragment(int position) {
            Fragment fr;
            switch (position){
                case 0:
                    fr = new RulesFragment(ContentActivity.this, gameName);
                    break;
                case 1:
                    fr = new PlayersFragment(ContentActivity.this, gameName);
                    break;
                case 2:
                    fr = new GalleryFragment(ContentActivity.this, gameName);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + position);
            }
            return fr;
        }

        @Override
        public int getItemCount() {
            return 3;
        }
    }
}

