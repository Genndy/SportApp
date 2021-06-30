package com.genndy.sportapp.menu.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.genndy.sportapp.R;
import com.genndy.sportapp.menu.db.DataBaseManagerMenu;
import com.genndy.sportapp.menu.models.Game;
import com.genndy.sportapp.menu.ui.adapter.GameItemAdapter;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MenuActivity extends AppCompatActivity {
    private ImageView mButtonAdd;
    private ImageView mImagePicked;
    private RecyclerView mGamesView;
    private ConstraintLayout mDialogWindow;
    private ConstraintLayout mEditPhotoGame;
    private ConstraintLayout mDialogMask;
    private EditText mInputTextGameName;
    private EditText mInputTextPhotoLink;
    private TextView mButtonCancel;
    private TextView mButtonSave;
    private DataBaseManagerMenu dataBaseManagerMenu;

    private final int PICK_IMAGE = 1;
    private Uri URIImageInSetting;
    List<Game> games;

    GameItemAdapter gameItemAdapter;
    Context thisContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        mImagePicked = (ImageView) findViewById(R.id.image_picked);
        mDialogWindow = (ConstraintLayout) findViewById(R.id.dialog_window);
        mDialogMask = (ConstraintLayout) findViewById(R.id.layout_mask);
        mEditPhotoGame = (ConstraintLayout) findViewById(R.id.edit_photo_game);
        mInputTextGameName = (EditText) findViewById(R.id.input_text_game_name);
        mButtonCancel = (TextView) findViewById(R.id.text_button_cancel_game);
        mButtonSave = (TextView) findViewById(R.id.text_button_save_game);
        mGamesView = (RecyclerView) findViewById(R.id.menu_list_view);
        mButtonAdd = (ImageView) findViewById(R.id.button_add);
        mInputTextPhotoLink = (EditText) findViewById(R.id.input_text_photo_link);
        dataBaseManagerMenu = new DataBaseManagerMenu(this);

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
                showGameAddDialog();
            }
        });

        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveGame();
            }
        });

        games = new ArrayList<>();
        gameItemAdapter = new GameItemAdapter(games, MenuActivity.this);
        mGamesView.setAdapter(gameItemAdapter);
        updateList();
    }

    private void updateList(){
        games = dataBaseManagerMenu.readAllFromDB();
        gameItemAdapter.setItems(games); // отрисовка итемов
    }

    private void showGameAddDialog(){
        mDialogMask.setVisibility(View.VISIBLE);
        mDialogWindow.setVisibility(View.VISIBLE);
    }

    private void hideGameAddDialog(){
        mDialogMask.setVisibility(View.GONE);
        mDialogWindow.setVisibility(View.GONE);
    }

    private void saveGame(){
        String id = UUID.randomUUID().toString();
        String name = mInputTextGameName.getText().toString();
        String photoUrl = mInputTextPhotoLink.getText().toString();
        hideGameAddDialog();
        dataBaseManagerMenu.insertToDB(id, name, photoUrl);
        updateList();
    }

    private void ImageLoadingInCreatingDialog() {
        Handler handlerTimer = new Handler(Looper.getMainLooper());
        handlerTimer.postDelayed(new Runnable() {
            @Override
            public void run() {
                String photoUrl = mInputTextPhotoLink.getText().toString();
                System.out.println("context changed");
                    System.out.print(" content http://");
                    System.out.print(" " + photoUrl);
                    Glide.with(MenuActivity.this)
                            .load(photoUrl)
                            .error(R.drawable.no_image)
                            .placeholder(R.drawable.no_image)
                            .centerCrop()
                            .fitCenter()
                            .into(mImagePicked);
            }
        }, 2000);
    }

    //Обрабатываем результат выбора в галерее:
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case PICK_IMAGE:
                if(resultCode == RESULT_OK){
                    try {
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        URIImageInSetting = imageUri;
                        mImagePicked.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
        }
    }


}

