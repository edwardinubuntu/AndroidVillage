package tw.soleil.tw.village.fragment;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

import tw.soleil.tw.village.R;

/**
 * Created by bryan on 2015/4/11.
 */
public class RunnerFragment extends PlaceholderFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
    }

    public static RunnerFragment newInstance(int sectionNumber) {
        RunnerFragment fragment = new RunnerFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_runner, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final ImageButton beforeButton = (ImageButton)view.findViewById(R.id.imageButtonBefore);
        final ImageButton nextButton = (ImageButton)view.findViewById(R.id.imageButtonNext);

        beforeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beforeButton.setEnabled(false);
                nextButton.setEnabled(true);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextButton.setEnabled(false);
                beforeButton.setEnabled(true);
            }
        });

        final TextView timerTextView = (TextView) view.findViewById(R.id.timerTextView);

        CountDownTimer countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText("Timer: " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                timerTextView.setText("TIME'S UP");
            }
        }.start();
    }
}
