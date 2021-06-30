package com.genndy.sportapp.content.gallery.adapter;

import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.genndy.sportapp.R;
import com.genndy.sportapp.content.gallery.models.Photo;
import com.genndy.sportapp.content.ui.placeholder.PlaceholderContent.PlaceholderItem;
// import com.genndy.sportapp.content.ui.databinding.FragmentGalleryBinding;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link PlaceholderItem}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyGalleryRecyclerViewAdapter extends RecyclerView.Adapter<MyGalleryRecyclerViewAdapter.PhotoItemHolder> {
    List<Photo> photos;
    Context context;

    public void setItems(List<Photo> photos){
        this.photos = photos;
        notifyDataSetChanged();
    }

    public MyGalleryRecyclerViewAdapter(List<Photo> photos, Context context) {
        this.photos = photos;
        this.context = context;
        notifyDataSetChanged();
    }

    @Override
    public PhotoItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_photo, parent, false);
        return new PhotoItemHolder(view);
    }

    /*
        public void onBindViewHolder( RecyclerView.ViewHolder holder, int position) {

        }
    */
    @Override
    public void onBindViewHolder(final MyGalleryRecyclerViewAdapter.PhotoItemHolder holder, int position) {
        Glide.with(context)
                .load(photos.get(position).getPhotoURL())
                .centerCrop()
                .fitCenter()
                .into(holder.getImageView());
    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    // ************

    public class PhotoItemHolder extends RecyclerView.ViewHolder {
        private ImageView galleryPhoto;
        private RelativeLayout galleryItemLayout;

        public ImageView getImageView() {
            return galleryPhoto;
        }

        public RelativeLayout getGameLayout(){
            return galleryItemLayout;
        }

        public PhotoItemHolder(View itemView) {
            super(itemView);
            galleryPhoto = (ImageView) itemView.findViewById(R.id.item_gallery_photo);
            galleryItemLayout = (RelativeLayout) itemView.findViewById(R.id.item_gallery_layout);
        }
    }


//    public class MygalleryRecyclerViewAdapter extends RecyclerView.Adapter<com.genndy.sportapp.content.ui.MygalleryRecyclerViewAdapter.ViewHolder> {

    /*

    private final List<PlaceholderItem> mValues;

    public MygalleryRecyclerViewAdapter(List<PlaceholderItem> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentGalleryBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView mContentView;
        public PlaceholderItem mItem;

        public ViewHolder(FragmentGalleryBinding binding) {
            super(binding.getRoot());
            mIdView = binding.itemNumber;
            mContentView = binding.content;
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
     */
}