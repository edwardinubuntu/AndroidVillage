package tw.soleil.androidvillage.Fragment;

import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
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

        Typeface warriorTypeface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/StitchWarrior.ttf");
        button_1.setTypeface(warriorTypeface);
        button_2.setTypeface(warriorTypeface);
        button_3.setTypeface(warriorTypeface);
        button_4.setTypeface(warriorTypeface);
        button_5.setTypeface(warriorTypeface);
        button_6.setTypeface(warriorTypeface);
        button_7.setTypeface(warriorTypeface);
        button_8.setTypeface(warriorTypeface);
        button_9.setTypeface(warriorTypeface);
        button_0.setTypeface(warriorTypeface);
        button_equal.setTypeface(warriorTypeface);

        final TextView answer_textView = (TextView) rootView.findViewById(R.id.calculate_answer_textView);

        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathCalculator.setOperation(MathCalculator.Operation.PLUS);
                Log.i("Calculator", mathCalculator.toString());
            }
        });

        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathCalculator.operate();
                answer_textView.setText(String.valueOf(mathCalculator.getAnswer()));
                Log.i("Calculator", mathCalculator.toString());

                mathCalculator.clearAll();
            }
        });

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathCalculator.setComingNumber(1);
                answer_textView.setText(String.valueOf(mathCalculator.getComingNumber()));
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathCalculator.setComingNumber(2);
                answer_textView.setText(String.valueOf(mathCalculator.getComingNumber()));
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathCalculator.setComingNumber(3);
                answer_textView.setText(String.valueOf(mathCalculator.getComingNumber()));
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathCalculator.setComingNumber(4);
                answer_textView.setText(String.valueOf(mathCalculator.getComingNumber()));
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathCalculator.setComingNumber(5);
                answer_textView.setText(String.valueOf(mathCalculator.getComingNumber()));
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathCalculator.setComingNumber(6);
                answer_textView.setText(String.valueOf(mathCalculator.getComingNumber()));
            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathCalculator.setComingNumber(7);
                answer_textView.setText(String.valueOf(mathCalculator.getComingNumber()));
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathCalculator.setComingNumber(8);
                answer_textView.setText(String.valueOf(mathCalculator.getComingNumber()));
            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathCalculator.setComingNumber(9);
                answer_textView.setText(String.valueOf(mathCalculator.getComingNumber()));
            }
        });

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathCalculator.setComingNumber(0);
                answer_textView.setText(String.valueOf(mathCalculator.getComingNumber()));
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
        mathCalculator.setOperation(MathCalculator.Operation.PLUS);
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