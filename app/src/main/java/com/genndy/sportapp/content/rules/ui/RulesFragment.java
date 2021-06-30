package com.genndy.sportapp.content.rules.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.genndy.sportapp.R;
import com.genndy.sportapp.content.rules.db.DataBaseManagerRules;

import java.util.UUID;

public class RulesFragment extends Fragment {
    Context context;
    private TextView mTextView;
    private EditText mEditTextView;
    private String gameName;
    private String rulesText;

    private ImageView mButtonEdit;
    private TextView mButtonRulesSave;
    private TextView mButtonRulesCancel;

    private ScrollView mEditTextLayout;
    private ScrollView mTextLayout;

    private DataBaseManagerRules db;

    public RulesFragment(Context context, String gameName){
        this.gameName = gameName;
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        db = new DataBaseManagerRules(context);
        View view = inflater.inflate(R.layout.fragment_rules, container, false);
        mTextView = (TextView) view.findViewById(R.id.text_rules);
        mEditTextView = (EditText) view.findViewById(R.id.text_rules_edit);
        mButtonEdit = (ImageView) view.findViewById(R.id.button_edit_rules);
        mButtonRulesSave = (TextView) view.findViewById(R.id.text_button_save_rules);
        mButtonRulesCancel = (TextView) view.findViewById(R.id.text_button_cancel_rules);
        mTextLayout = (ScrollView) view.findViewById(R.id.text_rules_layout);
        mEditTextLayout = (ScrollView) view.findViewById(R.id.text_rules_edit_layout);
        db.createTableIfNotExist();

        updateTextView();

        mButtonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonRulesCancel.setVisibility(View.VISIBLE);
                mButtonRulesSave.setVisibility(View.VISIBLE);
                mEditTextLayout.setVisibility(View.VISIBLE);

                mTextLayout.setVisibility(View.GONE);
                mButtonEdit.setVisibility(View.GONE);
                mEditTextView.setText(mTextView.getText());
            }
        });

        mButtonRulesSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonRulesCancel.setVisibility(View.GONE);
                mButtonRulesSave.setVisibility(View.GONE);
                mEditTextLayout.setVisibility(View.GONE);

                mButtonEdit.setVisibility(View.VISIBLE);
                mTextLayout.setVisibility(View.VISIBLE);
                String id = UUID.randomUUID().toString();
                String name = gameName;
                String text = mEditTextView.getText().toString();
                db.insertToDB(id, name, text);
                updateTextView();
            }
        });

        mButtonRulesCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mButtonRulesCancel.setVisibility(View.GONE);
                mButtonRulesSave.setVisibility(View.GONE);
                mEditTextLayout.setVisibility(View.GONE);

                mTextLayout.setVisibility(View.VISIBLE);
                mButtonEdit.setVisibility(View.VISIBLE);
            }
        });

        return view;
    }

    private void updateTextView() {
        if(!db.readFromBDByGameName(gameName).get(0).getText().isEmpty()){
            rulesText = db.readFromBDByGameName(gameName).get(0).getText();
        }else{
            rulesText = "Правил нет, может стоит добавить?";
        }
        mTextView.setText(rulesText);
    }
}