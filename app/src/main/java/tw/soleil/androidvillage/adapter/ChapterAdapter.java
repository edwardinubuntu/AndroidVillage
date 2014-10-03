/*
 * Copyright (c) 2014. Soleil Studio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package tw.soleil.androidvillage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import tw.soleil.androidvillage.JavaBasicManager;
import tw.soleil.androidvillage.Object.Chapter;
import tw.soleil.androidvillage.R;

import java.util.List;

/**
 * Created by edward_chiang on 14/9/11.
 */
public class ChapterAdapter extends ArrayAdapter<Chapter> {

    /**
     * Constructor
     *
     * @param context  The current context.
     * @param resource The resource ID for a layout file containing a TextView to use when
     *                 instantiating views.
     * @param objects  The objects to represent in the ListView.
     */
    public ChapterAdapter(Context context, int resource, List<Chapter> objects) {
        super(context, resource, objects);
    }

    /**
     * {@inheritDoc}
     *
     * @param position
     * @param convertView
     * @param parent
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(android.R.layout.simple_list_item_2, null);

            viewHolder = new ViewHolder();
            viewHolder.chapterTextView = (TextView) convertView.findViewById(android.R.id.text2);
            viewHolder.captionTextView = (TextView) convertView.findViewById(android.R.id.text1);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        Chapter chapter = getItem(position);
        viewHolder.chapterTextView.setText(chapter.getChapterName());
        viewHolder.captionTextView.setText(chapter.getCaption());

        switch (position) {
            case JavaBasicManager.CHAPTER_CONTROLLING_EXECUTION_INDEX:
            case JavaBasicManager.CHAPTER_INITIALIZATION_CLEANUP_INDEX:
            case JavaBasicManager.CHAPTER_ACCESS_CONTROL_INDEX:
                viewHolder.captionTextView.setTextColor(getContext().getResources().getColor(R.color.theme_color_2));
                break;
            case JavaBasicManager.CHAPTER_CONTROLLING_EXECUTION_HOMEWORK:
            case JavaBasicManager.CHAPTER_INITIALIZATION_CLEANUP_HOMEWORK:
            case JavaBasicManager.CHAPTER_ACCESS_CONTROL_HOMEWORK:
                viewHolder.captionTextView.setTextColor(getContext().getResources().getColor(R.color.theme_color_5));
                break;
        }

        return convertView;
    }

    static class ViewHolder {
        TextView chapterTextView;
        TextView captionTextView;
    }
}
