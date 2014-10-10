/*
 * Copyright (c) 2014. Soleil Studio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package tw.soleil.androidvillage.activity.java.homework;

import android.os.Bundle;
import android.widget.TextView;
import tw.soleil.androidvillage.R;
import tw.soleil.androidvillage.activity.ChapterActivity;
import tw.soleil.androidvillage.activity.java.object.Ape;
import tw.soleil.androidvillage.activity.java.object.KingKon;
import tw.soleil.androidvillage.activity.java.object.Monkey;

/**
 * Created by edward_chiang on 14/9/27.
 */
public class InitializationCleanupActivity extends ChapterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.fragment_math_shape);

    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        TextView fullScreenTextView = (TextView)findViewById(R.id.full_screen_text_view);

        // Start class here
        StringBuffer displayResultText = new StringBuffer();

        Ape sharmon = new Ape();
        sharmon.setName("sharmon");
        sharmon.setWeight(20);
        sharmon.setHeight(100);
        sharmon.setColor("brown");
        displayResultText.append("The sharmon is: " + sharmon.toString());
        displayResultText.append("\n\n");


        KingKon feebogdy = new KingKon(20,100);
        feebogdy.setName("feebogdy");
        feebogdy.setColor("black and gray");

        displayResultText.append("The feebogdy is: "+ feebogdy.toString());
        displayResultText.append("\n\n");

        Monkey sailmon = new Monkey();
        sailmon.setName("sailmon");
        sailmon.setWeight(30);
        sailmon.setHeight(90);
        sailmon.setColor("red and brown");
        displayResultText.append("The sailmon is: "+ sailmon.toString());
        displayResultText.append("\n\n");


        fullScreenTextView.setText(displayResultText.toString());
    }
}
