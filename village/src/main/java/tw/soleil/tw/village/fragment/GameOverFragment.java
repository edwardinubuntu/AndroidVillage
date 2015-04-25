package tw.soleil.tw.village.fragment;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
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
import android.widget.ImageButton;
import android.widget.TextView;

import com.gitonway.lee.risenumber.lib.RiseNumberTextView;

import java.io.IOException;

import tw.soleil.tw.village.R;

/**
 * Created by bryan on 2015/4/18.
 */
public class GameOverFragment extends Fragment {

    private RiseNumberTextView scoreTextView;

    private OnRestartListener onRestartListener;

    private int totalSteps;

    private MediaPlayer coinUpMediaPlayer;

    public static GameOverFragment newInstance() {
        GameOverFragment fragment = new GameOverFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        coinUpMediaPlayer = MediaPlayer.create(getActivity(), R.raw.super_mario);
    }

    public void onDestroy() {
        coinUpMediaPlayer.stop();
        super.onDestroy();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_over,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        scoreTextView = (RiseNumberTextView) view.findViewById(R.id.score_textview);


        int totalScore = 0;

        // Calculate our score
        if (totalSteps >= 30) {
            totalScore = totalSteps * 4;
        } else if (totalSteps >= 20) {
            totalScore = totalSteps * 3;
        } else if (totalSteps >= 10) {
            totalScore = totalSteps * 2;
        } else {
            totalScore = totalSteps * 1;
        }

            coinUpMediaPlayer.setLooping(true);
            coinUpMediaPlayer.start();

            CountDownTimer countDownTimer = new CountDownTimer(totalScore / 50 * 1000, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    coinUpMediaPlayer.setLooping(false);
                    coinUpMediaPlayer.stop();
                }
            };
            countDownTimer.start();


        scoreTextView
                .withNumber(totalScore)
                .setDuration(1000).start();

        ImageButton imageButton = (ImageButton) view.findViewById(R.id.restart_imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().remove(GameOverFragment.this).commit();
                if (getOnRestartListener() != null) {
                    getOnRestartListener().onRestart();
                }
            }
        });
    }

    public OnRestartListener getOnRestartListener() {
        return onRestartListener;
    }

    public void setOnRestartListener(OnRestartListener onRestartListener) {
        this.onRestartListener = onRestartListener;
    }

    public interface OnRestartListener {
        public void onRestart();
    }

    public int getTotalSteps() {
        return totalSteps;
    }

    public void setTotalSteps(int totalSteps) {
        this.totalSteps = totalSteps;
    }
}
