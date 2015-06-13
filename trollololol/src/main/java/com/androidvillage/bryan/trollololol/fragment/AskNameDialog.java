package com.androidvillage.bryan.trollololol.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.androidvillage.bryan.trollololol.R;


/**
 * Created by bryan on 2015/5/16.
 */
public abstract class AskNameDialog extends DialogFragment implements TextView.OnEditorActionListener, View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_ask_name, container);

        getDialog().setTitle(R.string.app_name);

        EditText editText = (EditText)view.findViewById(R.id.your_name_editText);
        editText.setOnEditorActionListener(this);

        editText.requestFocus();

        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        Button doneButton = (Button)view.findViewById(R.id.done_button);
        doneButton.setOnClickListener(this);

        return  view;
    }
}
