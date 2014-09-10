/*
 * Copyright (c) 2014. Soleil Studio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package tw.soleil.androidvillage;

import tw.soleil.androidvillage.Object.Chapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edward_chiang on 14/9/11.
 */
public class JavaBasicManager extends ChapterManager {

    public List<Chapter> loadAdapterObjects() {

        ArrayList<Chapter> chapterArrayList = new ArrayList<Chapter>();

        // Prepare Data
        Chapter chapter11 = new Chapter();
        chapter11.setChapterName("Chapter 1.1");
        chapter11.setCaption("Object");
        chapterArrayList.add(chapter11);

        Chapter chapter12 = new Chapter();
        chapter12.setChapterName("Chapter 1.2");
        chapter12.setCaption("Operators");
        chapterArrayList.add(chapter12);

        Chapter chapter13 = new Chapter();
        chapter13.setChapterName("Chapter 1.3");
        chapter13.setCaption("Controlling Execution");
        chapterArrayList.add(chapter13);

        Chapter chapter14 = new Chapter();
        chapter14.setChapterName("Chapter 1.4");
        chapter14.setCaption("Initialization & Cleanup");
        chapterArrayList.add(chapter14);

        Chapter chapter21 = new Chapter();
        chapter21.setChapterName("Chapter 2.1");
        chapter21.setCaption("Reusing Classes");
        chapterArrayList.add(chapter21);

        Chapter chapter22 = new Chapter();
        chapter22.setChapterName("Chapter 2.2");
        chapter22.setCaption("Polymorphism");
        chapterArrayList.add(chapter22);

        Chapter chapter23 = new Chapter();
        chapter23.setChapterName("Chapter 2.3");
        chapter23.setCaption("Interfaces");
        chapterArrayList.add(chapter23);

        Chapter chapter24 = new Chapter();
        chapter24.setChapterName("Chapter 2.4");
        chapter24.setCaption("Inner Classes");
        chapterArrayList.add(chapter24);

        return  chapterArrayList;
    }
}
