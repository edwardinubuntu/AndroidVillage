package tw.soleil.androidvillage.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import tw.soleil.androidvillage.R;
import tw.soleil.androidvillage.activity.android.NotifyAddActivity;

/**
 * Created by bryan on 2015/2/14.
 */
public class NotifyFragment extends PlaceholderFragment {

    public static NotifyFragment newInstance(int sectionNumber) {
        NotifyFragment fragment = new NotifyFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notify,container,false);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.notify, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                Intent addIntent = new Intent(getActivity(), NotifyAddActivity.class);
                startActivity(addIntent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
