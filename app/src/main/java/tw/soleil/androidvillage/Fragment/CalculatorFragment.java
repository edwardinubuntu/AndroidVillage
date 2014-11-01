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

    private StringBuffer calculatorText;

    private TextView operationTextView;

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

        calculatorText = new StringBuffer();
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

        Button buttonClear = (Button)rootView.findViewById(R.id.button_clear);

        operationTextView = (TextView)rootView.findViewById(R.id.calculate_operation_textView);

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

        Typeface spaceTypeface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/SPACECRAFT.ttf");
        buttonClear.setTypeface(spaceTypeface);

        final TextView answer_textView = (TextView) rootView.findViewById(R.id.calculate_answer_textView);

        button_period.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (calculatorText.toString() == null || calculatorText.toString() == "") {
                    calculatorText.append(0);
                }
                textButtonPressed(".", answer_textView);
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathCalculator.clearAll();
                calculatorText = new StringBuffer();
                operationTextView.setText("");
                // Because we want to make the label to 0, but don't want to add them to text buffer.
                answer_textView.setText(String.valueOf((int)mathCalculator.getComingNumber()));
            }
        });

        button_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathCalculator.setOperation(MathCalculator.Operation.PLUS);
                Log.i("Calculator", mathCalculator.toString());
                operationTextView.setText("+");
                calculatorText = new StringBuffer();
            }
        });

        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathCalculator.setOperation(MathCalculator.Operation.MINUS);
                Log.i("Calculator", mathCalculator.toString());
                operationTextView.setText("-");
                calculatorText = new StringBuffer();
            }
        });

        button_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathCalculator.setOperation(MathCalculator.Operation.TIME);
                Log.i("Calculator", mathCalculator.toString());
                operationTextView.setText("*");
                calculatorText = new StringBuffer();
            }
        });


        button_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathCalculator.setOperation(MathCalculator.Operation.DIVIDE);
                Log.i("Calculator", mathCalculator.toString());
                operationTextView.setText("/");
                calculatorText = new StringBuffer();
            }
        });


        button_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathCalculator.operate();

                String result;
                if (mathCalculator.getAnswer() == Math.floor(mathCalculator.getAnswer()) && !Double.isInfinite(mathCalculator.getAnswer())) {
                    // Int
                    result = String.valueOf((int)mathCalculator.getAnswer());
                } else {
                    double answer = mathCalculator.getAnswer();

                    // Checkout http://stackoverflow.com/questions/703396/how-to-nicely-format-floating-numbers-to-string-without-unnecessary-decimal-0
                    if (answer == (int)answer) {
                        result = String.format("%d", (long)answer);
                    } else {
                        result = String.format("%.3s", answer);
                    }
                }

                answer_textView.setText(result);
                Log.i("Calculator", mathCalculator.toString());
                operationTextView.setText("=");
                calculatorText = new StringBuffer();
                mathCalculator.clearAll();
            }
        });

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberButtonPressed(1, answer_textView);
            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberButtonPressed(2, answer_textView);
            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberButtonPressed(3, answer_textView);
            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberButtonPressed(4, answer_textView);
            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberButtonPressed(5, answer_textView);
            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberButtonPressed(6, answer_textView);
            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberButtonPressed(7, answer_textView);
            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberButtonPressed(8, answer_textView);
            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberButtonPressed(9, answer_textView);
            }
        });

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathCalculator.setComingNumber(0);
                try {
                    if (calculatorText.length() > 0 && Float.parseFloat(calculatorText.toString()) > 0) {
                        numberButtonPressed(0, answer_textView);
                    } else {
                        answer_textView.setText(String.valueOf(0));
                    }
                } catch (NumberFormatException e) {
                    numberButtonPressed(0, answer_textView);
                }
            }
        });

        return  rootView;
    }

    private void textButtonPressed(String text, TextView answer_textView) {
        if (calculatorText.length() > 0 && !calculatorText.toString().contains(text)) {
            calculatorText.append(text);
            answer_textView.setText(calculatorText);
        }
    }

    private void numberButtonPressed(int number, TextView answer_textView) {
        calculatorText.append(number);
        mathCalculator.setComingNumber(Float.parseFloat(calculatorText.toString()));
        answer_textView.setText(calculatorText);
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
        mathCalculator.setOperation(MathCalculator.Operation.TIME);
        mathCalculator.setComingNumber(4);
        mathCalculator.operate();

        Log.i("Calculator", "Answer is: " + mathCalculator.getAnswer());
    }
}