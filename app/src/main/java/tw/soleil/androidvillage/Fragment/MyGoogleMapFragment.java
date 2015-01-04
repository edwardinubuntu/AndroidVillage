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

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import tw.soleil.androidvillage.R;

/**
 * Created by edward_chiang on 15/1/3.
 */
public class MyGoogleMapFragment extends PlaceholderFragment implements OnMapReadyCallback {

    private MarkerOptions myHomeMarker;

    private WebView webView;

    public static MyGoogleMapFragment newInstance(int sectionNumber) {
        MyGoogleMapFragment fragment = new MyGoogleMapFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my_google_map, container, false);

        MapFragment mapFragment = (MapFragment)getFragmentManager().findFragmentById(R.id.my_google_map_view);
        mapFragment.getMapAsync(this);

        webView = (WebView)rootView.findViewById(R.id.my_google_map_web_view);
        webView.setVisibility(View.INVISIBLE);

        return rootView;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng taipei101 = new LatLng(25.0336, 121.5650);

        googleMap.setMyLocationEnabled(true);

        googleMap.addMarker(new MarkerOptions()
                .title("taipei101")
                .snippet("the highest building in Taiwan")
                .position(taipei101));

        LatLng homeSweetHome = new LatLng(25.027509,121.538452);

        myHomeMarker = new MarkerOptions()
                .title("琉璃藏")
                .snippet("琉璃藏")
                .position(homeSweetHome);

        googleMap.addMarker(myHomeMarker );






        LatLng home = new LatLng(24.784539,121.017765);

        myHomeMarker = new MarkerOptions()
                .title("北歐")
                .snippet("北歐")
                .position(home);

        googleMap.addMarker(myHomeMarker);




        LatLng slash = new LatLng(25.034731,121.521934);

        myHomeMarker = new MarkerOptions()
                .title("中正紀念堂")
                .snippet("中正紀念堂")
                .position(slash);

        googleMap.addMarker(myHomeMarker);




        LatLng air1 = new LatLng(25.079651,121.234217);

        myHomeMarker = new MarkerOptions()
                .title("臺灣桃園國際機場")
                .snippet("臺灣桃園國際機場")
                .position(air1);

        googleMap.addMarker(myHomeMarker);
        // Home 2

        // 中正紀念堂

        googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {

                marker.showInfoWindow();


                String url = "http://maps.googleapis.com/maps/api/streetview?size=200x200&location="+marker.getPosition().latitude+",%20"+marker.getPosition().longitude+"&fov=90&heading=235&pitch=10&sensor=false";
                webView.loadUrl(url);

                webView.setVisibility(View.VISIBLE);

                return true;
            }
        });


        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(taipei101, 13));

    }
}
