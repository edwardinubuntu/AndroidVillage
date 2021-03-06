/*
 * Copyright (c) 2015. Soleil Studio
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package tw.soleil.androidvillage.Fragment;

import android.location.Location;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.beardedhen.androidbootstrap.BootstrapButton;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnStreetViewPanoramaReadyCallback;
import com.google.android.gms.maps.StreetViewPanorama;
import com.google.android.gms.maps.StreetViewPanoramaFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaLocation;

import tw.soleil.androidvillage.R;

/**
 * Created by edward_chiang on 15/1/10.
 */
public class MyStreetViewFragment extends PlaceholderFragment implements OnStreetViewPanoramaReadyCallback {

    private static View rootView;

    private BootstrapButton home1Button;

    private BootstrapButton home2Button;

    private BootstrapButton taipei101Button;

    private BootstrapButton aircraftButton;

    private Location pickedLocation;

    public static MyStreetViewFragment newInstance(int sectionNumber) {
        MyStreetViewFragment fragment = new MyStreetViewFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pickedLocation = new Location("Pick Location");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        if (rootView!=null) {
            ViewGroup containerParent = (ViewGroup)container.getParent();
            if (containerParent !=null) {
                containerParent.removeView(rootView);
            }
        }
        try {
            rootView = inflater.inflate(R.layout.fragment_street_view, container, false);
        } catch (InflateException ex ){

        }

        StreetViewPanoramaFragment streetViewPanoramaFragment = (StreetViewPanoramaFragment)getFragmentManager().findFragmentById(R.id.street_view_panorama_fragment);
        streetViewPanoramaFragment.getStreetViewPanoramaAsync(this);


        home1Button = (BootstrapButton)rootView.findViewById(R.id.home1_button);
        home2Button = (BootstrapButton)rootView.findViewById(R.id.home2_button);
        taipei101Button = (BootstrapButton)rootView.findViewById(R.id.taipei101_button);
        aircraftButton = (BootstrapButton)rootView.findViewById(R.id.aircraft_button);

        return rootView;
    }



    @Override
    public void onStreetViewPanoramaReady(final StreetViewPanorama streetViewPanorama) {
        streetViewPanorama.setPosition(new LatLng(25.0336, 121.5650));

        final LatLng homeSweetHome = new LatLng(25.027509,121.538452);
        home1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                pickedLocation.setLongitude(homeSweetHome.longitude);
                pickedLocation.setLatitude(homeSweetHome.latitude);

                streetViewPanorama.setPosition(homeSweetHome);
            }
        });


        home2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LatLng home = new LatLng(24.784539,121.017765);
                pickedLocation.setLongitude(home.longitude);
                pickedLocation.setLatitude(home.latitude);
                streetViewPanorama.setPosition(home);
            }
        });
        taipei101Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LatLng taipei101 = new LatLng(25.0336, 121.5650);
                pickedLocation.setLongitude(taipei101.longitude);
                pickedLocation.setLatitude(taipei101.latitude);
                streetViewPanorama.setPosition(taipei101);
            }
        });
        aircraftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LatLng air1 = new LatLng(25.079651,121.234217);
                pickedLocation.setLongitude(air1.longitude);
                pickedLocation.setLatitude(air1.latitude);
                streetViewPanorama.setPosition(air1);
            }
        });


        streetViewPanorama.setOnStreetViewPanoramaChangeListener(new StreetViewPanorama.OnStreetViewPanoramaChangeListener() {
            @Override
            public void onStreetViewPanoramaChange(StreetViewPanoramaLocation streetViewPanoramaLocation) {

                Location currentLocation = new Location("current location");
                currentLocation.setLongitude(streetViewPanoramaLocation.position.longitude);
                currentLocation.setLatitude(streetViewPanoramaLocation.position.latitude);

                if (pickedLocation.getLatitude() >0 && pickedLocation.getLongitude() > 0) {
                    float distance = pickedLocation.distanceTo(currentLocation);

                    Toast.makeText(getActivity(), "距離出發位置：：" + (int) distance + " M", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
