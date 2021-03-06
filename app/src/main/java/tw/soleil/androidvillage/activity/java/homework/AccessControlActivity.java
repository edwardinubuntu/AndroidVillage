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
import tw.soleil.androidvillage.activity.java.object.Circle;
import tw.soleil.androidvillage.activity.java.object.Rectangular;
import tw.soleil.androidvillage.activity.java.object.Shape;
import tw.soleil.androidvillage.activity.java.object.Square;

/**
 * Created by edward_chiang on 14/10/4.
 */
public class AccessControlActivity extends ChapterActivity {

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

        // Learning Calculate borderLength()
        displayResultText.append("Learning Interface with class");
        displayResultText.append("\n");
        Circle circle = new Circle(10);
        displayResultText.append("The Circle radius is: " + circle.getRadius() + ", and the circumference is: " + circle.calculateCircumference());

        displayResultText.append("\n");


        Shape square = new Square(10, 10);
        displayResultText.append("The Square width is: " + square.getWidth() + ", height is: "
                + square.getHeight() + " and the perimeter is: " + square.calculatePerimeter());
        displayResultText.append("\n");


        Shape rectangular = new Rectangular();
        displayResultText.append("The Rectangular width is: " + rectangular.getWidth() + ", height is: "
                +rectangular.getHeight()+" and the perimeter is: " + rectangular.calculatePerimeter());
        displayResultText.append("\n");

        displayResultText.append("\n\n");

        fullScreenTextView.setText(displayResultText.toString());
    }
}
