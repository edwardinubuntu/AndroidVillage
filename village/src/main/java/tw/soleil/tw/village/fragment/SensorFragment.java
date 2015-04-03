package tw.soleil.tw.village.fragment;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import tw.soleil.tw.village.R;

/**
 * Created by bryan on 2015/4/3.
 */
public class SensorFragment extends PlaceholderFragment {

    private TextView sensorEventText;
    private ImageView ballImageView;
    private ImageView bambooBasketImageView;

    private RelativeLayout relativeLayout;

    private double moveX = 0;
    private double moveY = 0;

    public static SensorFragment newInstance(int sectionNumber) {
        SensorFragment fragment = new SensorFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        SensorManager sensorManager = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        sensorManager.registerListener(new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                String valueText = "X軸 :" +event.values[0] +
                        "Y軸 :" +event.values[1] +
                        "Z軸 :" +event.values[2];

                sensorEventText.setText(valueText);

                if (moveX == 0 && moveY == 0){
                   moveX =  (relativeLayout.getWidth()-ballImageView.getWidth()) / 20;
                    moveY = (relativeLayout.getHeight()-ballImageView.getHeight()) /20;
                }
                RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) ballImageView.getLayoutParams();

                params.leftMargin = (int)((10-event.values[0] * 2) * moveX);
                params.topMargin = (int)((10+event.values[1] * 2) * moveY);

                ballImageView.setLayoutParams(params);

                RelativeLayout.LayoutParams bambooParams = (RelativeLayout.LayoutParams)bambooBasketImageView.getLayoutParams();
                int[] location = new int[2];
                bambooBasketImageView.getLocationOnScreen(location);
                int minX = location[0];
                int maxX = minX + bambooBasketImageView.getMeasuredWidth();
                int minY = location[1];
                int maxY = minY + bambooBasketImageView.getMeasuredHeight();

                if (params.leftMargin > minX && params.leftMargin < maxX
                        &&
                        params.topMargin > minY && params.topMargin < maxY) {
                    Toast.makeText(getActivity(), "得分", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        }, sensor,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sensor, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sensorEventText = (TextView) view.findViewById(R.id.sensor_event_textView);

        ballImageView = (ImageView) view.findViewById(R.id.ball_imageView);

        relativeLayout = (RelativeLayout) view.findViewById(R.id.sensor_layout);

        bambooBasketImageView = (ImageView) view.findViewById(R.id.basket_imageView);
    }
}
