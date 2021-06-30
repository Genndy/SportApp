package com.genndy.sportapp.content.players.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.genndy.sportapp.R;
import com.genndy.sportapp.content.players.db.DataBaseManagerPlayers;
import com.genndy.sportapp.content.players.model.Player;
import com.genndy.sportapp.content.players.ui.adapter.PlayerItemAdapter;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PlayersFragment extends Fragment {
    private ImageView mButtonAdd;
    private ImageView mImagePicked;
    private RecyclerView mPlayersView;
    private ConstraintLayout mDialogWindow;
    private ConstraintLayout mEditPhotoPlayer;
    private ConstraintLayout mDialogMask;
    private EditText mInputTextGameName;
    private EditText mInputTextPhotoLink;

    private TextView mButtonCancel;
    private TextView mButtonSave;
    private DataBaseManagerPlayers dataBaseManagerPlayers;

    String gameName;
    
    List<Player> players;

    PlayerItemAdapter playerItemAdapter;
    Context thisContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_players, container, false);
//        setContentView(R.layout.activity_menu);
        players = new ArrayList<>();

        mImagePicked = (ImageView) view.findViewById(R.id.player_picked);
        mDialogWindow = (ConstraintLayout) view.findViewById(R.id.dialog_window_players);
        mDialogMask = (ConstraintLayout) view.findViewById(R.id.layout_mask_player);
        mEditPhotoPlayer = (ConstraintLayout) view.findViewById(R.id.edit_photo_player);
        mInputTextGameName = (EditText) view.findViewById(R.id.input_text_player_name);
        mButtonCancel = (TextView) view.findViewById(R.id.text_button_cancel_players);
        mButtonSave = (TextView) view.findViewById(R.id.text_button_save_players);
        mPlayersView = (RecyclerView) view.findViewById(R.id.players_list_view);
        mButtonAdd = (ImageView) view.findViewById(R.id.players_button_add);
        mInputTextPhotoLink = (EditText) view.findViewById(R.id.input_text_photo_link_player);
        dataBaseManagerPlayers = new DataBaseManagerPlayers(thisContext);



        mInputTextPhotoLink.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                ImageLoadingInCreatingDialog();
            }
        });

        mDialogMask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideGameAddDialog();
            }
        });

        mDialogWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Заглушка
            }
        });

        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideGameAddDialog();
            }
        });

        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddDialog();
            }
        });

        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePlayer();
            }
        });

        playerItemAdapter = new PlayerItemAdapter(players, thisContext);
        mPlayersView.setAdapter(playerItemAdapter);

        String id = UUID.randomUUID().toString();
        String name = "123";
        String photoUrl = "https://sun9-16.userapi.com/s/v1/ig2/Wdovis4wUBvdKFJF9poyuLCzLzZ4sKZFpFrJ0Bum4K34eBjBf898-poiHmGmhv-0gKFBy0Uei2H_LTSgZVI67gj8.jpg?size=200x0&quality=95&crop=666,14,596,597&ava=1";
        dataBaseManagerPlayers.insertToDB(id, name, gameName, photoUrl);
        updateList();

        return view;
    }


    private void updateList(){
        players = dataBaseManagerPlayers.readAllFromDB(gameName);
        playerItemAdapter.setItems(players); // отрисовка итемов
    }

    private void showAddDialog(){
        mDialogMask.setVisibility(View.VISIBLE);
        mDialogWindow.setVisibility(View.VISIBLE);
    }

    private void hideGameAddDialog(){
        mDialogMask.setVisibility(View.GONE);
        mDialogWindow.setVisibility(View.GONE);
    }

    private void savePlayer(){
        String id = UUID.randomUUID().toString();
        String name = mInputTextGameName.getText().toString();
        String photoUrl = mInputTextPhotoLink.getText().toString();
        hideGameAddDialog();
        dataBaseManagerPlayers.insertToDB(id, name, gameName, photoUrl);
        updateList();
    }

    private void ImageLoadingInCreatingDialog() {
        Handler handlerTimer = new Handler(Looper.getMainLooper());
        handlerTimer.postDelayed(new Runnable() {
            @Override
            public void run() {
                String photoUrl = mInputTextPhotoLink.getText().toString();
                Glide.with(thisContext)
                        .load(photoUrl)
                        .error(R.drawable.no_image)
                        .placeholder(R.drawable.no_image)
                        .centerCrop()
                        .fitCenter()
                        .into(mImagePicked);
            }
        }, 2000);
    }

    public PlayersFragment(Context context, String gameName){
        thisContext = context;
        this.gameName = gameName;

    }

    }