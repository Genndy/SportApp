package com.genndy.sportapp.content.players.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.genndy.sportapp.R;
import com.genndy.sportapp.content.players.model.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerItemAdapter extends RecyclerView.Adapter<PlayerItemAdapter.PlayerItemHolder> {
    List<Player> players = new ArrayList<>();
    Context context;

    public void setItems(List<Player> players){
       this.players = players;
        notifyDataSetChanged();
    }

    public void clearItems(){
        players.clear();
        notifyDataSetChanged();
    }

    public PlayerItemAdapter(List<Player> players, Context context){
        this.players = players;
        this.context = context;
        notifyDataSetChanged();
    }

    @Override
    public PlayerItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_games, parent, false);
        return new PlayerItemHolder(view);
    }

    @Override
    public void onBindViewHolder(PlayerItemHolder holder, int position) {
        holder.getNameView().setText(players.get(position).getName());
        Glide.with(context)
                .load(players.get(position).getPhotoURL())
                .centerCrop()
                .fitCenter()
                .into(holder.getImageView());

        holder.getGameLayout().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(context, ContentActivity.class);
//                intent.putExtra("game_name", holder.getNameView().getText());
//                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return players.size();
    }

    //*******************************************************************

    public class PlayerItemHolder extends RecyclerView.ViewHolder {
        private final TextView gameName;
        private final ImageView gameImage;
        private final RelativeLayout gameLayout;

        public TextView getNameView() {
            return gameName;
        }

        public ImageView getImageView() {
            return gameImage;
        }

        public RelativeLayout getGameLayout(){
            return gameLayout;
        }

        public PlayerItemHolder(View itemView) {
            super(itemView);
            gameName = (TextView) itemView.findViewById(R.id.item_game_name);
            gameImage = (ImageView) itemView.findViewById(R.id.item_game_photo);
            gameLayout = (RelativeLayout) itemView.findViewById(R.id.item_game_layout);
        }
    }
}