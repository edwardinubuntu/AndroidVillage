package tw.soleil.androidvillage.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import tw.soleil.androidvillage.Object.MathCalculator;
import tw.soleil.androidvillage.R;

/**
 * Created by bryan on 2014/10/18.
 */
public class CalculatorFragment extends PlaceholderFragment{public static CalculatorFragment newInstance(int sectionNumber) {
    CalculatorFragment fragment = new CalculatorFragment();
    Bundle args = new Bundle();
    args.putInt(ARG_SECTION_NUMBER, sectionNumber);
    fragment.setArguments(args);
    return fragment;
     }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_calculator, container, false);

        Button button_1 = (Button) rootView.findViewById(R.id.button_one);

        Button button_2 = (Button) rootView.findViewById(R.id.button_two);

        Button button_3 = (Button) rootView.findViewById(R.id.button_three);

        Button button_4 = (Button) rootView.findViewById(R.id.button_four);

        Button button_5 = (Button) rootView.findViewById(R.id.button_five);

        Button button_6 = (Button) rootView.findViewById(R.id.button_six);

        Button button_7 = (Button) rootView.findViewById(R.id.button_seven);

        Button button_8 = (Button) rootView.findViewById(R.id.button_eight);

        Button button_9 = (Button) rootView.findViewById(R.id.button_nine);

        return  rootView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        runTest();
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