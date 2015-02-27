/*
 * Copyright (c) 2015. Soleil Studio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package tw.soleil.tw.village.fragment;

import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;

import tw.soleil.tw.village.R;
import tw.soleil.tw.village.Village;

/**
 * Created by edward_chiang on 15/2/27.
 */
public class SettingsFragment extends android.preference.PreferenceFragment {

    private SharedPreferences preferences;

    private static String PREFERENCES_KEY_APP_VERSION = "PREFERENCES_KEY_APP_VERSION";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.settings);

        preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        try {
            String appVersion = getActivity().getPackageManager().getPackageInfo(getActivity().getPackageName(), 0).versionName;

            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(PREFERENCES_KEY_APP_VERSION, appVersion);
            editor.apply();

        } catch (PackageManager.NameNotFoundException e) {
            Log.e(Village.TAG, e.getLocalizedMessage());
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Version
        Preference versionPreference = findPreference("setting_version_key");
        versionPreference.setSummary(this.preferences.getString(PREFERENCES_KEY_APP_VERSION, ""));
    }
}
