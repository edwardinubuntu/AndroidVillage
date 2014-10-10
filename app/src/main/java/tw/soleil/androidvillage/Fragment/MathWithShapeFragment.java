/*
 * Copyright (c) 2014. Soleil Studio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package tw.soleil.androidvillage.Fragment;

import android.os.Bundle;
import android.view.*;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import tw.soleil.androidvillage.R;
import tw.soleil.androidvillage.activity.java.object.Circle;

/**
 * Created by edward_chiang on 14/10/11.
 */
public class MathWithShapeFragment extends PlaceholderFragment {

    public static MathWithShapeFragment newInstance(int sectionNumber) {
        MathWithShapeFragment fragment = new MathWithShapeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_math_shape, container, false);

        final EditText radiusEditText = (EditText)rootView.findViewById(R.id.radius_edit_text);
        final TextView radiusCalculateResultView = (TextView)rootView.findViewById(R.id.circle_answer_text_view);
        final Button radiusCalculateButton = (Button)rootView.findViewById(R.id.calculate_circle_button);

        radiusCalculateButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                Circle circleOnView = new Circle();
                if (radiusEditText.getText() != null) {

                    // String convert to float
                    circleOnView.setRadius(Double.parseDouble(radiusEditText.getText().toString()));

                    radiusCalculateResultView.setText(String.valueOf(circleOnView.calculateArea()));
                }

                return true;
            }
        });

        // http://developer.android.com/reference/android/text/InputType.html
        radiusEditText.setInputType(EditorInfo.TYPE_CLASS_NUMBER);

        return rootView;
    }

}