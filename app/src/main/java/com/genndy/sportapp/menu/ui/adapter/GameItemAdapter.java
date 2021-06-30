package com.genndy.sportapp.menu.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.BitmapDrawableDecoder;
import com.genndy.sportapp.R;
import com.genndy.sportapp.content.ui.ContentActivity;
import com.genndy.sportapp.menu.models.Game;
import com.genndy.sportapp.menu.ui.MenuActivity;
import com.genndy.sportapp.preloader.ui.PreloaderActivity;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;

public class GameItemAdapter extends RecyclerView.Adapter<GameItemAdapter.GameItemHolder> {
    List<Game> games = new ArrayList<>();
    Context context;

    public void setItems(List<Game> games){
       this.games = games;
        notifyDataSetChanged();
    }

    public void clearItems(){
        games.clear();
        notifyDataSetChanged();
    }

    public GameItemAdapter(List<Game> games, Context context){
        this.games = games;
        this.context = context;
        notifyDataSetChanged();
    }

    @Override
    public GameItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_games, parent, false);
        return new GameItemHolder(view);
    }

    @Override
    public void onBindViewHolder(GameItemAdapter.GameItemHolder holder, int position) {
        holder.getNameView().setText(games.get(position).getName());
        Glide.with(context)
                .load(games.get(position).getPhotoURL())
                .centerCrop()
                .fitCenter()
                .into(holder.getImageView());

        holder.getGameLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ContentActivity.class);
                intent.putExtra("game_name", holder.getNameView().getText());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return games.size();
    }

    //*******************************************************************

    public class GameItemHolder extends RecyclerView.ViewHolder {
        private final TextView gameName;
        private final ImageView gameImage;
        private final RelativeLayout gameLayout;

//        public void bind(Game game) throws FileNotFoundException {
//            gameName.setText(game.getName());
//            gameImage.setImageBitmap(null);
//
//        }

        public TextView getNameView() {
            return gameName;
        }

        public ImageView getImageView() {
            return gameImage;
        }

        public RelativeLayout getGameLayout(){
            return gameLayout;
        }

        public GameItemHolder(View itemView) {
            super(itemView);
            gameName = (TextView) itemView.findViewById(R.id.item_game_name);
            gameImage = (ImageView) itemView.findViewById(R.id.item_game_photo);
            gameLayout = (RelativeLayout) itemView.findViewById(R.id.item_game_layout);
        }
    }
}