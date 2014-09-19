/*
 * Copyright (c) 2014. Soleil Studio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package tw.soleil.androidvillage.activity;

import android.os.Bundle;
import android.widget.TextView;
import tw.soleil.androidvillage.R;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by edward_chiang on 14/9/20.
 */
public class ControllingExecutionActivity extends ChapterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_full_screen_text_view);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        TextView fullScreenTextView = (TextView)findViewById(R.id.full_screen_text_view);

        // Start class here
        StringBuffer displayResultText = new StringBuffer();

        // Learning if-else
        displayResultText.append("Learning if-else");
        displayResultText.append("\n");
        int temperature = 33;
        if (temperature > 30) {
            displayResultText.append("Hot weather with temperature " + temperature + " celsius.");
        }
        displayResultText.append("\n\n");

        // Learning true and false
        displayResultText.append("Learning true and false");
        displayResultText.append("\n");
        boolean isBigger;
        isBigger = 5 > 3;
        displayResultText.append("5 > 3 is " + String.valueOf(isBigger));
        displayResultText.append("\n\n");

        // Learning Iteration
        displayResultText.append("Learning Iteration");
        displayResultText.append("\n");
        String[] colors = new String[]{"Red", "Yellow", "Blue", "Green"};
        for (int index = 0; index < colors.length; index ++) {
            String eachColor = colors[index];
            displayResultText.append(eachColor);
            displayResultText.append(" ");
        }
        displayResultText.append("\n\n");

        // Learning for each
        displayResultText.append("Learning for each");
        displayResultText.append("\n");
        for (String color : colors) {
            displayResultText.append(color);
            displayResultText.append(" ");
        }
        displayResultText.append("\n\n");

        // Learning iterator
        displayResultText.append("Learning Iterator");
        displayResultText.append("\n");
        ArrayList<String> colorList = new ArrayList<String>();
        colorList.add("Red");
        colorList.add("Yellow");
        colorList.add("Blue");
        colorList.add("Green");
        for (Iterator<String> eachColor = colorList.iterator(); eachColor.hasNext();) {
            String eachColorText = eachColor.next();
            displayResultText.append(eachColorText);
            displayResultText.append(" ");
        }
        displayResultText.append("\n\n");

        // Learning break
        displayResultText.append("Learning break");
        displayResultText.append("\n");
        for (String eachColor : colorList) {
            displayResultText.append(eachColor);
            displayResultText.append(" ");
            if (eachColor.equalsIgnoreCase("Blue")) {
                displayResultText.append("Calling break");
                break;
            }
        }
        displayResultText.append("\n\n");

        fullScreenTextView.setText(displayResultText.toString());
    }
}
