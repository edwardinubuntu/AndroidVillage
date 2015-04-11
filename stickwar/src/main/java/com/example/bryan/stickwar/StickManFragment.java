package com.example.bryan.stickwar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.koushikdutta.ion.Ion;
import com.koushikdutta.ion.ProgressCallback;
import com.parse.ParseObject;

/**
 * Created by bryan on 2015/3/7.
 */
public class StickManFragment extends Fragment {

    private ParseObject dataObject;

    public StickManFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_stick_man_war,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView titleTextView = (TextView) view.findViewById(R.id.title_text_view);
        titleTextView.setText(dataObject.getString("title"));

        ImageView imageView = (ImageView)view.findViewById(R.id.stick_man_image_view);

        final ProgressBar progressBar = (ProgressBar)view.findViewById(R.id.stick_man_image_loading_progressBar);
        progressBar.setVisibility(View.VISIBLE);

        Ion.with(getActivity())
                .load(dataObject.getParseFile("pictureURL").getUrl())
                .noCache()
                .progressBar(progressBar)
                .intoImageView(imageView);

        TextView contentTextView = (TextView) view.findViewById(R.id.stick_man_content_text_view);
        contentTextView .setText(dataObject.getString("content"));
    }

    public ParseObject getDataObject() {
        return dataObject;
    }

    public void setDataObject(ParseObject dataObject) {
        this.dataObject = dataObject;
    }
}
