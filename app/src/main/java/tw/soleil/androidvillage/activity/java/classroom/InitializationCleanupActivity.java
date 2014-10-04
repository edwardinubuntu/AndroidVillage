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
import tw.soleil.androidvillage.activity.java.object.KingKon;
import tw.soleil.androidvillage.activity.java.object.Monkey;

/**
 * Created by edward_chiang on 14/9/27.
 */
public class InitializationCleanupActivity extends ChapterActivity {

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

        // Learning Constructor
        displayResultText.append("Learning Guaranteed init with the constructor");
        displayResultText.append("\n\n");
        Monkey monkeyEmma = new Monkey(20, 100);
        monkeyEmma.setName("Emma");

        Monkey monkeyJohn = new Monkey();
        monkeyJohn.setName("John");
        monkeyJohn.setHeight(120);
        monkeyJohn.setWeight(25);

        displayResultText.append("The monkey Emma is: "+ monkeyEmma.toString());
        displayResultText.append("\n\n");
        displayResultText.append("The monkey John is: "+ monkeyJohn.toString());

        displayResultText.append("\n\n");
        if (monkeyEmma.getHeight() >= monkeyJohn.getHeight()) {
            displayResultText.append("Emma is higher than John.");
        } else {
            displayResultText.append("Emma is shorter than John.");
        }
        displayResultText.append("\n\n");

        // Learning Method overloading
        displayResultText.append("\n");

        Monkey monkey = new Monkey(20, 100);
        displayResultText.append("The monkey sound is: "+ monkey.sound() + ". Can climb tree? "+ monkey.canClimbTree());
        displayResultText.append("\n");

        KingKon kingKon = new KingKon(50, 120);
        displayResultText.append("The kingKon sound is: "+ kingKon.sound()+ ". Can climb tree? "+ kingKon.canClimbTree());
        displayResultText.append("\n\n");

        // Learning default constructors
        monkey = new Monkey();
        displayResultText.append("The monkey is: "+ monkey.toString());
        displayResultText.append("\n\n");

        kingKon = new KingKon(50,100);
        displayResultText.append("The kingKon is: "+ kingKon.toString());
        displayResultText.append("\n\n");

        // Learning Method Overloading
        kingKon.setColor("gray");
        displayResultText.append("The kingKon sound: "+ kingKon.sound() +", color :" + kingKon.getColor());
        displayResultText.append("\n\n");

        // Learning Method Overloading
        displayResultText.append("The monkey sound: "+ monkey.sound());
        displayResultText.append("\n\n");

        displayResultText.append("\n\n");

        fullScreenTextView.setText(displayResultText.toString());
    }
}
