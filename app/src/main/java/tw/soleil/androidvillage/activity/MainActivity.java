package tw.soleil.androidvillage.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import tw.soleil.androidvillage.Fragment.*;
import tw.soleil.androidvillage.R;

public class MainActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments

        if (position == 5) {
            // Open Activity
            Intent fairActivityIntent = new Intent(MainActivity.this, KorrnellFairActivity.class);
            startActivity(fairActivityIntent);
            return;
        }

        if (position == 8) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, ViewPagerFragment.newInstance(position + 1))
                    .commit();
            return;
        }

        FragmentManager fragmentManager = getFragmentManager();
        Fragment fragment;
        switch (position) {
            case 0:
                fragment = JavaBasicFragment.newInstance(position + 1);
                break;
            case 1:
                fragment = AndroidBasicFragment.newInstance(position + 1);
                break;
            case 2:
                fragment = MathWithShapeFragment.newInstance(position + 1);
                break;
            case 3:
                fragment = CalculatorFragment.newInstance(position + 1);
                break;
            case 4:
                fragment = CameraExampleFragment.newInstance(position + 1);
                break;
//            case 5:
//                fragment = KorrnellFairFragment.newInstance(position + 1);
//                break;
            case 6:
                fragment = MyGoogleMapFragment.newInstance(position + 1);
                break;
            case 7:
                fragment = MyStreetViewFragment.newInstance(position + 1);
                break;
            case 9:
                fragment = NFCFragment.newInstance(position + 1);
                break;
            case 10:
                fragment = NotifyFragment.newInstance(position + 1 );
                break;
            default:
                fragment = PlaceholderFragment.newInstance(position + 1);
                break;
        }
        fragmentManager.beginTransaction()
                .replace(R.id.container, fragment)
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_java_basic);
                break;
            case 2:
                mTitle = getString(R.string.title_android_basic);
                break;
            case 3:
                mTitle = getString(R.string.title_calculate_math);
                break;
            case 4:
                mTitle = getString(R.string.title_calculator);
                break;
            case 5:
                mTitle = getString(R.string.title_camera);
                break;
            case 6:
                mTitle = "Korrnell Fair";
                break;
            case 7:
                mTitle = "My Google Map";
                break;
            case 8:
                mTitle = "My Street View";
                break;
            case 9:
                mTitle = "Multiple Views";
                break;
            case 10:
                mTitle = "NFC";
                break;
            case 11:
                mTitle = "Notify";
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.main, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}
