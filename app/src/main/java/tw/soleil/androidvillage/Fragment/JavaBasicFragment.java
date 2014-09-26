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

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import tw.soleil.androidvillage.JavaBasicManager;
import tw.soleil.androidvillage.Object.Chapter;
import tw.soleil.androidvillage.R;
import tw.soleil.androidvillage.activity.java.classroom.ControllingExecutionActivity;
import tw.soleil.androidvillage.activity.java.classroom.InitializationCleanupActivity;
import tw.soleil.androidvillage.adapter.ChapterAdapter;

import java.util.ArrayList;

/**
 * Created by edward_chiang on 14/9/11.
 */
public class JavaBasicFragment extends PlaceholderFragment {

    protected ArrayList<Chapter> chapterArrayList;

    protected ChapterAdapter javaBasicAdapter;

    public static JavaBasicFragment newInstance(int sectionNumber) {
        JavaBasicFragment fragment = new JavaBasicFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        chapterArrayList = new ArrayList<Chapter>();

        javaBasicAdapter = new ChapterAdapter(getActivity(), android.R.layout.simple_list_item_2, chapterArrayList);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        JavaBasicManager javaBasicManager = new JavaBasicManager();
        chapterArrayList.addAll(javaBasicManager.loadAdapterObjects());
        javaBasicAdapter.notifyDataSetChanged();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_java_basic, container, false);

        ListView listView = (ListView)rootView.findViewById(R.id.list_view);

        listView.setAdapter(javaBasicAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {

                    // Controlling Execution
                    case JavaBasicManager.CHAPTER_CONTROLLING_EXECUTION_INDEX:
                        Intent intent = new Intent(getActivity(), ControllingExecutionActivity.class);
                        startActivity(intent);
                        break;
                    case JavaBasicManager.CHAPTER_CONTROLLING_EXECUTION_HOMEWORK:
                        intent = new Intent(getActivity(), tw.soleil.androidvillage.activity.java.homework.ControllingExecutionActivity.class);
                        startActivity(intent);
                        break;
                    // Initialization & Cleanup
                    case JavaBasicManager.CHAPTER_INITIALIZATION_CLEANUP_INDEX:
                        intent = new Intent(getActivity(), InitializationCleanupActivity.class);
                        startActivity(intent);
                        break;
                    case JavaBasicManager.CHAPTER_INITIALIZATION_CLEANUP_HOMEWORK:
                        intent = new Intent(getActivity(), tw.soleil.androidvillage.activity.java.homework.InitializationCleanupActivity.class);
                        startActivity(intent);
                        break;
                    default:
                }
            }
        });

        return rootView;
    }
}
