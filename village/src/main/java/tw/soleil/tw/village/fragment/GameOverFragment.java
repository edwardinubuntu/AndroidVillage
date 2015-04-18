package tw.soleil.tw.village.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.gitonway.lee.risenumber.lib.RiseNumberTextView;

import tw.soleil.tw.village.R;

/**
 * Created by bryan on 2015/4/18.
 */
public class GameOverFragment extends Fragment {

    private RiseNumberTextView scoreTextView;

    public static GameOverFragment newInstance() {
        GameOverFragment fragment = new GameOverFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_over,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        scoreTextView = (RiseNumberTextView) view.findViewById(R.id.score_textview);

        scoreTextView
                .withNumber(100)
                .setDuration(1000).start();

    }
}
