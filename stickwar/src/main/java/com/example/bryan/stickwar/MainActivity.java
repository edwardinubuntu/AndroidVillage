package com.example.bryan.stickwar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.transition.Slide;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.FindCallback;
import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {


    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    private List<ParseObject> stickManWarList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        stickManWarList = new ArrayList<>();

        Parse.initialize(this, "YRaYVYv0C1UykLKYUbuaPv53LS9VSNnp6SWzqUyh", "PY9InNYVa5YR2z7RfdnMtW8BRl4R4GJBSHntdKwC");
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        viewPager = (ViewPager) findViewById(R.id.cardViewPager);
        pagerAdapter = new SlidePagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        loadStickManWar();
    }

    private void loadStickManWar() {


        ParseQuery stickmanQuery = new ParseQuery("StickMan");
        stickmanQuery.findInBackground(new FindCallback() {
            @Override
            public void done(List list, ParseException e) {
                if (e !=null) {
                    Log.e("StickMan", "Parse find in background: " + e.getLocalizedMessage());
                }

                if(list!= null){
                    stickManWarList.clear();
                    stickManWarList.addAll(list);
                    pagerAdapter.notifyDataSetChanged();


                }
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private  class SlidePagerAdapter extends FragmentStatePagerAdapter {


        public SlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new StickManFragment(stickManWarList.get(position));
        }

        @Override
        public int getCount() {
            return stickManWarList.size();
        }
    }


}
