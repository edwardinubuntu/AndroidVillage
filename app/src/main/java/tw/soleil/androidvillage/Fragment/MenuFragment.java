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

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;

import tw.soleil.androidvillage.R;
import tw.soleil.androidvillage.adapter.FoodAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edward_chiang on 14/12/6.
 */
public class MenuFragment extends Fragment {

    private ArrayList<ParseObject> foodList;

    private FoodAdapter foodArrayAdapter;

    private ListView foodListView;

    private String studentID;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        foodList= new ArrayList<ParseObject>();
        foodArrayAdapter = new FoodAdapter(getActivity(), R.layout.cell_food, foodList);


    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ParseQuery<ParseObject> foodQuery = ParseQuery.getQuery("Food");

        foodQuery.findInBackground(new FindCallback<ParseObject>() {
            @Override
            public void done(List<ParseObject> parseObjects, ParseException e) {
                if (e == null) {
                    Log.d("KorrnellFair", "Retrieve: " + parseObjects);
                    foodList.clear();
                    for (ParseObject eachParseObject : parseObjects) {
                        Log.d("KorrnellFair","EachObject: "+ eachParseObject.getString("name"));
                        foodList.add(eachParseObject);
                    }
                    foodArrayAdapter.notifyDataSetChanged();
                }else {
                    Log.d("KorrnellFair", "error: "+e.getMessage());
                }
            }
        });

        if (studentID == null) {
            askUserAccount();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_shopping_menu, container, false);

        foodListView = (ListView)rootView.findViewById(R.id.Food_listView);
        foodListView.setAdapter(foodArrayAdapter);
        foodListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                final ParseObject currentObject = foodList.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("BUY NOW");
                builder.setMessage("Are you sure you want to buy "+ currentObject.getString("name") +" ?")
                        .setPositiveButton("Affirmative", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                ParseObject shopCart = new ParseObject("Cart");
                                shopCart.put("foodPointer", currentObject);
                                shopCart.put("queuingNumber", 1);
                                shopCart.put("status", 0);
                                shopCart.put("userName", studentID);
                                shopCart.saveInBackground(new SaveCallback() {
                                    @Override
                                    public void done(ParseException e) {
                                        if (e == null) {
                                            Toast.makeText(getActivity(), "Order SUCCESS", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(getActivity(), "CHECK YOUR INTERNET CONNECTION", Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            }
                        })
                        .setNegativeButton("I QUIT!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });

                builder.create().show();
            }
        });

        View userNameLayout = rootView.findViewById(R.id.user_name_layout);
        userNameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askUserAccount();
            }
        });

        return rootView;
    }

    private void askUserAccount() {
        AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

        alert.setTitle("Chose logging account");
        alert.setMessage("Input your student ID");


        final EditText input = new EditText(getActivity());
        alert.setView(input);
        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                studentID = String.valueOf(input.getText());
                TextView studentIdTextView = (TextView)getActivity().findViewById(R.id.korrnell_fair_student_ID_text_view);
                studentIdTextView.setText(studentID);

            }
        }).setNeutralButton("Use Guest", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

        alert.show();
    }
}
