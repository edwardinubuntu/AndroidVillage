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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import tw.soleil.androidvillage.R;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by edward_chiang on 14/9/11.
 */
public class AndroidBasicFragment extends PlaceholderFragment {

    public static final String LISTVIEW_TITLE = "Title";
    public static final String LISTVIEW_SUB_TEXT = "SubText";

    public static AndroidBasicFragment newInstance(int sectionNumber) {
        AndroidBasicFragment fragment = new AndroidBasicFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_android_basic, container, false);

        ExpandableListView listView = (ExpandableListView)rootView.findViewById(R.id.expandable_list_view);

        ArrayList<HashMap<String, String>> chapterData = new ArrayList<HashMap<String, String>>();

        ArrayList<ArrayList<HashMap<String, String>>> chapterSubData = new ArrayList<ArrayList<HashMap<String, String>>>();

        // Chapter 1
        HashMap<String, String> currentChapterData1 = new HashMap<String, String>();
        currentChapterData1.put(LISTVIEW_TITLE, "Chapter 1 Coding Environment");
        chapterData.add(currentChapterData1);

        ArrayList<HashMap<String, String>> chapterSubData11 =
                new ArrayList<HashMap<String, String>>();
        HashMap<String, String> currentCharaData11 = new HashMap<String, String>();
        currentCharaData11.put(LISTVIEW_TITLE, "What is Android");
        currentCharaData11.put(LISTVIEW_SUB_TEXT, "Learning what is Android");
        chapterSubData11.add(currentCharaData11);

        HashMap<String, String> currentCharaData12 = new HashMap<String, String>();
        currentCharaData12.put(LISTVIEW_TITLE, "Java JDK");
        currentCharaData12.put(LISTVIEW_SUB_TEXT, "All about Java and their versions.");
        chapterSubData11.add(currentCharaData12);

        HashMap<String, String> currentCharaData13 = new HashMap<String, String>();
        currentCharaData13.put(LISTVIEW_TITLE, "ADT Bundle");
        currentCharaData13.put(LISTVIEW_SUB_TEXT, "What's in the ADT Bundle.");
        chapterSubData11.add(currentCharaData13);

        HashMap<String, String> currentCharaData14 = new HashMap<String, String>();
        currentCharaData14.put(LISTVIEW_TITLE, "Android SDK");
        currentCharaData14.put(LISTVIEW_SUB_TEXT, "From Android 2.0 to Android 4.4");
        chapterSubData11.add(currentCharaData14);

        HashMap<String, String> currentCharaData15 = new HashMap<String, String>();
        currentCharaData15.put(LISTVIEW_TITLE, "Android Device");
        currentCharaData15.put(LISTVIEW_SUB_TEXT, "Learning all kind of device.");
        chapterSubData11.add(currentCharaData15);

        HashMap<String, String> currentCharaData16 = new HashMap<String, String>();
        currentCharaData16.put(LISTVIEW_TITLE, "Create A New Project");
        currentCharaData16.put(LISTVIEW_SUB_TEXT, "To create the first project.");
        chapterSubData11.add(currentCharaData16);

        HashMap<String, String> currentCharaData17 = new HashMap<String, String>();
        currentCharaData17.put(LISTVIEW_TITLE, "Files Structure");
        currentCharaData17.put(LISTVIEW_SUB_TEXT, "What kind of files store in the file system.");
        chapterSubData11.add(currentCharaData17);

        chapterSubData.add(chapterSubData11);

        // Chapter 2
        HashMap<String, String> currentChapterData2 = new HashMap<String, String>();
        currentChapterData2.put(LISTVIEW_TITLE, "Chapter 2 Basic");
        chapterData.add(currentChapterData2);

        ArrayList<HashMap<String, String>> chapterSubData21 =
                new ArrayList<HashMap<String, String>>();
        HashMap<String, String> currentCharaData21 = new HashMap<String, String>();
        currentCharaData21.put(LISTVIEW_TITLE, "Layout");
        currentCharaData21.put(LISTVIEW_SUB_TEXT, "All the layout.");
        chapterSubData21.add(currentCharaData21);

        HashMap<String, String> currentCharaData22 = new HashMap<String, String>();
        currentCharaData22.put(LISTVIEW_TITLE, "View");
        currentCharaData22.put(LISTVIEW_SUB_TEXT, "All view in Android.");
        chapterSubData21.add(currentCharaData22);

        chapterSubData.add(chapterSubData21);


        SimpleExpandableListAdapter androidChapterListAdapter = new SimpleExpandableListAdapter(
                getActivity(),
                chapterData,
                android.R.layout.simple_expandable_list_item_1,
                new String[] {LISTVIEW_TITLE},
                new int[] { android.R.id.text1},
                chapterSubData,
                android.R.layout.simple_expandable_list_item_2,
                new String[] {LISTVIEW_TITLE, LISTVIEW_SUB_TEXT},
                new int[] { android.R.id.text1, android.R.id.text2 }
        );
        listView.setAdapter(androidChapterListAdapter);

        return rootView;
    }
}
