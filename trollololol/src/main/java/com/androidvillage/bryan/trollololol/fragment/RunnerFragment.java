package com.androidvillage.bryan.trollololol.fragment;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidvillage.bryan.trollololol.activity.MainActivity;
import com.androidvillage.bryan.trollololol.R;

/**
 * Created by bryan on 2015/4/11.
 */
public class RunnerFragment extends PlaceholderFragment {

    private int numberOfSteps;

    private TextView stepsTextView;

    private MediaPlayer countDownMediaPlayer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((MainActivity)getActivity()).getSupportActionBar().hide();

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);

        countDownMediaPlayer = MediaPlayer.create(getActivity(), R.raw.motion_graphics);
    }

    public void onDestroy() {
        countDownMediaPlayer.stop();
        super.onDestroy();

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

        final ImageView trollFaceImageView = (ImageView)view.findViewById(R.id.trollFaceImageView);

        final TextView yourNameTextView = (TextView)view.findViewById(R.id.name_Text_View);

        stepsTextView = (TextView)view.findViewById(R.id.steps_text_view);

        beforeButton.setEnabled(false);

        beforeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                beforeButton.setEnabled(false);
                nextButton.setEnabled(true);

                trollFaceImageView.setImageResource(R.drawable.troll_face_left);

                numberOfSteps++;

                stepsTextView.setText("Steps: "+numberOfSteps);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextButton.setEnabled(false);
                beforeButton.setEnabled(true);

                trollFaceImageView.setImageResource(R.drawable.troll_face_right);
            }
        });

        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        AskNameDialog askNameDialog = new AskNameDialog() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (EditorInfo.IME_ACTION_DONE == actionId){

                    EditText nameEditText = (EditText)getDialog().findViewById(R.id.your_name_editText);
                    if (nameEditText.getText() != null) {
                        yourNameTextView.setText(nameEditText.getText().toString());

                        startGaming();

                        dismiss();
                    }
                    return true;
                }
                return false;
            }

            @Override
            public void onClick(View v) {

                EditText nameEditText = (EditText)getDialog().findViewById(R.id.your_name_editText);
                if (nameEditText.getText() != null) {
                    yourNameTextView.setText(nameEditText.getText().toString());

                    startGaming();

                    dismiss();
                }


            }
        };
        askNameDialog.setCancelable(false);
        askNameDialog.show(fragmentManager, "ask name");


    }

    private void startGaming() {

        numberOfSteps = 0;
        stepsTextView.setText("Steps: "+numberOfSteps);

        final TextView yourNameTextView = (TextView)getActivity().findViewById(R.id.name_Text_View);
        final TextView timerTextView = (TextView)getActivity().findViewById(R.id.timerTextView);

        CountDownTimer countDownTimer = new CountDownTimer(20 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText("Timer: " + millisUntilFinished / 1000);

                if (millisUntilFinished / 1000 == 15) {
                    countDownMediaPlayer.start();
                }
            }

            @Override
            public void onFinish() {
                timerTextView.setText("TIME'S UP");

                GameOverFragment gameOverFragment = GameOverFragment.newInstance();
                gameOverFragment.setOnRestartListener(new GameOverFragment.OnRestartListener() {
                    @Override
                    public void onRestart() {
                        startGaming();
                    }
                });
                gameOverFragment.setTotalSteps(numberOfSteps);
                gameOverFragment.setPlayerName(yourNameTextView.getText().toString());

                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction()
                        .add(R.id.container, gameOverFragment)
                        .commitAllowingStateLoss();


            }
        }.start();
    }

}
