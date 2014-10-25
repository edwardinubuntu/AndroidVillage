package tw.soleil.androidvillage.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.TextView;


import tw.soleil.androidvillage.Object.MathCalculator;

import tw.soleil.androidvillage.R;

/**
 * Created by bryan on 2014/10/18.
 */
public class CalculatorFragment extends PlaceholderFragment{

    private MathCalculator mathCalculator;



    public static CalculatorFragment newInstance(int sectionNumber) {



    CalculatorFragment fragment = new CalculatorFragment();
    Bundle args = new Bundle();
    args.putInt(ARG_SECTION_NUMBER, sectionNumber);
    fragment.setArguments(args);
    return fragment;
     }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.mathCalculator = new MathCalculator();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calculator, container, false);

        Button button_0 = (Button) rootView.findViewById(R.id.button_zero);

        Button button_1 = (Button) rootView.findViewById(R.id.button_one);

        Button button_2 = (Button) rootView.findViewById(R.id.button_two);

        Button button_3 = (Button) rootView.findViewById(R.id.button_three);

        Button button_4 = (Button) rootView.findViewById(R.id.button_four);

        Button button_5 = (Button) rootView.findViewById(R.id.button_five);

        Button button_6 = (Button) rootView.findViewById(R.id.button_six);

        Button button_7 = (Button) rootView.findViewById(R.id.button_seven);

        Button button_8 = (Button) rootView.findViewById(R.id.button_eight);

        Button button_9 = (Button) rootView.findViewById(R.id.button_nine);

        Button button_plus = (Button) rootView.findViewById(R.id.button_plus);

        Button button_minus = (Button) rootView.findViewById(R.id.button_minus);

        Button button_divide = (Button) rootView.findViewById(R.id.button_divide);

        Button button_time = (Button) rootView.findViewById(R.id.button_time);

        Button button_period = (Button) rootView.findViewById(R.id.button_period);

        Button button_equal = (Button) rootView.findViewById(R.id.button_equal);

        final TextView answer_textView = (TextView) rootView.findViewById(R.id.calculate_answer_textView);

        button_plus.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mathCalculator.setOperation(MathCalculator.Operation.ADD);
                return true;
            }
        });

        button_equal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                mathCalculator.operate();

                answer_textView.setText(String.valueOf(mathCalculator.getAnswer()));

                return true;
            }
        });

        button_1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mathCalculator.setComingNumber(1);
                answer_textView.setText(String.valueOf(mathCalculator.getComingNumber()));
                return true;
            }
        });

        button_2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mathCalculator.setComingNumber(2);
                answer_textView.setText(String.valueOf(mathCalculator.getComingNumber()));
                return true;
            }
        });

        button_3.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mathCalculator.setComingNumber(3);
                return true;
            }
        });

        button_4.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mathCalculator.setComingNumber(4);
                return true;
            }
        });

        button_5.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mathCalculator.setComingNumber(5);
                return true;
            }
        });

        button_6.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mathCalculator.setComingNumber(6);
                return true;
            }
        });

        button_7.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mathCalculator.setComingNumber(7);
                return true;
            }
        });

        button_8.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mathCalculator.setComingNumber(8);
                return true;
            }
        });

        button_9.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mathCalculator.setComingNumber(9);
                return true;
            }
        });

        button_0.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mathCalculator.setComingNumber(0);
                return true;
            }
        });

        return  rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // runTest();
    }

    private void runTest() {
        MathCalculator mathCalculator = new MathCalculator();
        mathCalculator.setComingNumber(1);
        mathCalculator.setComingNumber(2);
        mathCalculator.setComingNumber(3);
        mathCalculator.setOperation(MathCalculator.Operation.ADD);
        mathCalculator.setComingNumber(2);
        mathCalculator.operate();

        Log.i("Calculator", "Answer is: " + mathCalculator.getAnswer());

        mathCalculator.clearAll();

        mathCalculator.setComingNumber(2);
        mathCalculator.setComingNumber(5);
        mathCalculator.setOperation(MathCalculator.Operation.Multiple);
        mathCalculator.setComingNumber(4);
        mathCalculator.operate();

        Log.i("Calculator", "Answer is: " + mathCalculator.getAnswer());
    }
}