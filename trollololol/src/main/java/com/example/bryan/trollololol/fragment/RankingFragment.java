package com.example.bryan.trollololol.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;

import com.example.bryan.trollololol.R;

/**
 * Created by bryan on 2015/5/30.
 */
public class RankingFragment extends Fragment {

    private RankingAdapter rankingAdapter;

    private List<ParseObject> rankings;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        rankings = new ArrayList<>();
        rankingAdapter = new RankingAdapter(getActivity(), R.layout.cell_player_score, rankings);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ranking,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView rankingListView = (ListView)view.findViewById(R.id.ranking_list_view);
        rankingListView.setAdapter(rankingAdapter);

        Button closeButton = (Button)view.findViewById(R.id.close_button);
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().remove(RankingFragment.this).commit();
            }
        });

        ParseQuery<ParseObject> scoreQuery = ParseQuery.getQuery("Score");
        scoreQuery.orderByDescending("score");
        scoreQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, ParseException e) {
                if (parseObjects !=null) {
                    rankings.clear();
                    rankings.addAll(parseObjects);
                    rankingAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    public class RankingAdapter extends ArrayAdapter<ParseObject> {

        public RankingAdapter(Context context, int resource, List<ParseObject> objects) {
            super(context, resource, objects);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View rootView = inflater.inflate(R.layout.cell_player_score, null);

            ParseObject currentPlayerScore = getItem(position);

            ImageView topOneImageView = (ImageView)rootView.findViewById(R.id.crown_imageView);
            if (position == 0) {
                topOneImageView.setVisibility(View.VISIBLE);
            } else {
                topOneImageView.setVisibility(View.INVISIBLE);
            }

            TextView rankingTextView = (TextView)rootView.findViewById(R.id.rank_text);
            rankingTextView.setText(String.valueOf(position + 1));

            TextView playerNameTextView = (TextView)rootView.findViewById(R.id.player_name_text_view);
            playerNameTextView.setText(currentPlayerScore.getString("playerName"));

            TextView scoreTextView = (TextView)rootView.findViewById(R.id.score_textview);
            scoreTextView.setText(String.valueOf(currentPlayerScore.getNumber("score")));

            return rootView;
        }
    }
}
