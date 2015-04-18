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

import tw.soleil.tw.village.R;

/**
 * Created by bryan on 2015/4/18.
 */
public class GameOverFragment extends Fragment implements Animation.AnimationListener {

    private TextView scoreTextView;

    private AlphaAnimation fadeIn;
    private AlphaAnimation fadeOut;

    private static int count = 0, finalValue = 20;

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

        scoreTextView = (TextView) view.findViewById(R.id.score_textview);

//        animateTextView(1, 100, scoreTextView);

        fadeIn = new AlphaAnimation(0.0f, 1.0f);
        fadeOut = new AlphaAnimation(1.0f, 0.0f);

        fadeIn.setDuration(1);
        fadeIn.setFillAfter(true);
        fadeOut.setDuration(1);
        fadeOut.setFillAfter(true);

        fadeIn.setAnimationListener(this);
        fadeOut.setAnimationListener(this);
        scoreTextView.startAnimation(fadeIn);
        scoreTextView.startAnimation(fadeOut);

    }

    public void animateTextView(int initialValue, int finalValue, final TextView textview) {
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator(0.1f);
        int start = Math.min(initialValue, finalValue);
        int end = Math.max(initialValue, finalValue);
        int difference = Math.abs(finalValue - initialValue);
        Handler handler = new Handler();
        for (int count = start; count <= end; count++) {
            int time = Math.round(decelerateInterpolator.getInterpolation((((float) count) / difference)) * 100) * count;
            final int finalCount = ((initialValue > finalValue) ? initialValue - count : count);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    textview.setText(finalCount + "");
                }
            }, time);
        }
    }

    @Override
    public void onAnimationStart(Animation animation) {
        Log.i("mini", "Count:" + count);

        getActivity().runOnUiThread(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                scoreTextView.setText("" + count);
            }
        });

        if (count == finalValue) {
            scoreTextView.setText("" + finalValue);
        } else {
            ++count;
            scoreTextView.startAnimation(fadeIn);
            scoreTextView.startAnimation(fadeOut);
        }
    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
