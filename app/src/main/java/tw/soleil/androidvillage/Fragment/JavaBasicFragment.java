package tw.soleil.androidvillage.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import tw.soleil.androidvillage.JavaBasicChapterManager;
import tw.soleil.androidvillage.Object.Chapter;
import tw.soleil.androidvillage.R;
import tw.soleil.androidvillage.adapter.JavaBasicAdapter;

import java.util.ArrayList;

/**
 * Created by edward_chiang on 14/9/11.
 */
public class JavaBasicFragment extends PlaceholderFragment {

    private ArrayList<Chapter> chapterArrayList;

    private JavaBasicAdapter javaBasicAdapter;

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

        javaBasicAdapter = new JavaBasicAdapter(getActivity(), android.R.layout.simple_list_item_2, chapterArrayList);

        chapterArrayList.addAll(JavaBasicChapterManager.loadAdapterObjects());
        javaBasicAdapter.notifyDataSetChanged();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_java_basic, container, false);

        ListView listView = (ListView)rootView.findViewById(R.id.list_view);

        listView.setAdapter(javaBasicAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

        return rootView;
    }
}
