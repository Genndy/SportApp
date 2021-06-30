package com.genndy.sportapp.content.gallery.ui;

import android.content.Context;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.genndy.sportapp.R;
import com.genndy.sportapp.content.gallery.models.Photo;
import com.genndy.sportapp.content.gallery.db.DataBaseManagerGallery;
import com.genndy.sportapp.content.gallery.adapter.MyGalleryRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * A fragment representing a list of Items.
 */
public class GalleryFragment extends Fragment {
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 2;

    private ImageView mButtonAdd;
    private ImageView mImagePicked;
    private RecyclerView mGalleryView;
    private ConstraintLayout mDialogWindow;
    private ConstraintLayout mEditPhotoGallery;
    private ConstraintLayout mDialogMask;
    private EditText mInputTextGameName;
    private EditText mInputTextPhotoLink;

    private String gameName;

    private Context thisContext;

    private TextView mButtonCancel;
    private TextView mButtonSave;
    private DataBaseManagerGallery dataBaseManagerGallery;

    private MyGalleryRecyclerViewAdapter galleryItemAdapter;

    private List<Photo> photos;

    // TODO: Customize parameter initialization

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        mImagePicked = (ImageView) view.findViewById(R.id.photo_gallery_picked);
        mDialogWindow = (ConstraintLayout) view.findViewById(R.id.dialog_window_gallery);
        mDialogMask = (ConstraintLayout) view.findViewById(R.id.layout_mask_gallery);
        mEditPhotoGallery = (ConstraintLayout) view.findViewById(R.id.edit_photo_gallery);
        mButtonCancel = (TextView) view.findViewById(R.id.text_button_cancel_gallery);
        mButtonSave = (TextView) view.findViewById(R.id.text_button_save_gallery);
        mGalleryView = (RecyclerView) view.findViewById(R.id.gallery_list_view);
        mButtonAdd = (ImageView) view.findViewById(R.id.add_picture_gallery);
        mInputTextPhotoLink = (EditText) view.findViewById(R.id.input_text_photo_link_gallery);
        dataBaseManagerGallery = new DataBaseManagerGallery(thisContext);
        photos = new ArrayList<Photo>();

        mGalleryView.setLayoutManager(new LinearLayoutManager(thisContext));
        mGalleryView.setAdapter(new MyGalleryRecyclerViewAdapter(photos, this.getContext()));

        // Set the adapter
//        if (view instanceof RecyclerView) {
//            Context context = view.getContext();
//            RecyclerView recyclerView = (RecyclerView) view;
//            if (mColumnCount <= 1) {
//                mGalleryView.setLayoutManager(new LinearLayoutManager(context));
//            } else {
//                mGalleryView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
//            }
//            mGalleryView.setAdapter(new MyGalleryRecyclerViewAdapter(photos, this.getContext()));
//        }

        mInputTextPhotoLink.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                ImageLoadingInCreatingDialog();
            }
        });

        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddOptions();
            }
        });

        mDialogMask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideAddOptions();
            }
        });

        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideAddOptions();
            }
        });

        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePhoto();
                updateList();
            }
        });

        galleryItemAdapter = new MyGalleryRecyclerViewAdapter(photos, thisContext);
        mGalleryView.setAdapter(galleryItemAdapter);
        updateList();
        return view;
    }

    private void hideAddOptions(){
        mDialogMask.setVisibility(View.GONE);
    }
    private void showAddOptions(){
        mDialogMask.setVisibility(View.VISIBLE);
    }

    private void savePhoto(){
        String id = UUID.randomUUID().toString();
        String photoURL = mInputTextPhotoLink.getText().toString();
        dataBaseManagerGallery.insertToDB(id, photoURL, gameName);
    }

    private void ImageLoadingInCreatingDialog() {
        Handler handlerTimer = new Handler(Looper.getMainLooper());
//        String photoUrl = mInputTextPhotoLink.getText().toString();
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
                //              }
            }
        }, 2000);
    }

    private void getAllFromPhoto(){
        photos = dataBaseManagerGallery.readAllFromDB(gameName);
    }

    private void updateList(){
        photos = dataBaseManagerGallery.readAllFromDB(gameName);
        galleryItemAdapter.setItems(photos);
    }


    public GalleryFragment(Context context, String gameName) {
        thisContext = context;
        this.gameName = gameName;
    }
}