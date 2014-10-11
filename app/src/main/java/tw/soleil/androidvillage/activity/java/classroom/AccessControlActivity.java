/*
 * Copyright (c) 2014. Soleil Studio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package tw.soleil.androidvillage.activity.java.classroom;

import android.os.Bundle;
import android.widget.TextView;
import tw.soleil.androidvillage.R;
import tw.soleil.androidvillage.activity.ChapterActivity;
import tw.soleil.androidvillage.activity.java.object.*;

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

        // Learning shape
        displayResultText.append("Learning Interface with class");
        displayResultText.append("\n");
        Shape triangle = new Triangle(2, 3);
        displayResultText.append("The triangle area is: " + triangle.calculateArea());
        displayResultText.append("\n\n");

        // Learning shape
        displayResultText.append("Learning Interface with override");
        displayResultText.append("\n");
        Shape circle = new Circle(10);
        displayResultText.append("The Circle width is: " + circle.getWidth() + ", and the area is: " + circle.calculateArea());
        displayResultText.append("\n");

        Circle circleObject = new Circle(10);
        displayResultText.append("The Circle radius is: " + circleObject.getRadius() + ", and the area is: " + circleObject.calculateArea());
        displayResultText.append("\n\n");

        // Learning shape
        displayResultText.append("Learning Interface with override");
        displayResultText.append("\n");
        Shape rectangular = new Rectangular(5, 10);
        displayResultText.append("The Rectangular width is: " + rectangular.getWidth() + ", height is: "
                +rectangular.getHeight()+" and the area is: " + rectangular.calculateArea());
        displayResultText.append("\n");

        Square square = new Square(10, 10);
        displayResultText.append("The Rectangular width is: " + square.getWidth() + ", height is: "
                +square.getHeight()+" and the area is: " + square.calculateArea());
        displayResultText.append("\n");
        displayResultText.append("Is Square a really valid shape? " + square.isValidShape());

        displayResultText.append("\n");
        displayResultText.append("Is 2nd Square a really valid shape? " + new Square(5, 12).isValidShape());
        displayResultText.append("\n\n");

        fullScreenTextView.setText(displayResultText.toString());
    }
}
