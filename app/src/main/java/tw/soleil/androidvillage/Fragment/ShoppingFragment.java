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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

import tw.soleil.androidvillage.R;
import tw.soleil.androidvillage.adapter.ShoppingAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by edward_chiang on 14/12/6.
 */
public class ShoppingFragment extends Fragment {

    private ListView shoppingListView;


    private ArrayList<ParseObject> shopFoodList;

    private ShoppingAdapter shopFoodAdapter;

    private String studentID;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        shopFoodList = new ArrayList<ParseObject>();
        shopFoodAdapter = new ShoppingAdapter(getActivity(), R.layout.cell_shop_item, shopFoodList);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        // Check student id not null

        // Query Cart


        // User where from student id, foodQuery.whereEqualTo

        // Use Android Log print cart
    }

    private void queryCart() {
        if (studentID != null) {
            ParseQuery<ParseObject> cartQuery = ParseQuery.getQuery("Cart");
            cartQuery.whereEqualTo("userName", studentID);
            cartQuery.include("foodPointer");
            cartQuery.findInBackground(new FindCallback<ParseObject>() {
                @Override
                public void done(List<ParseObject> parseObjects, ParseException e) {
                    Log.d("Cart", parseObjects.toString());

                    shopFoodList.clear();
                    shopFoodList.addAll(parseObjects);
                    shopFoodAdapter.notifyDataSetChanged();
                }
            });
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_shopping_cart, container, false);


        View userNameLayout = rootView.findViewById(R.id.user_name_layout);
        userNameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askUserAccount();
            }
        });

        // Shopping Cart List
        shoppingListView = (ListView)rootView.findViewById(R.id.shopping_cart_list_view);
        shoppingListView.setAdapter(shopFoodAdapter);

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

                queryCart();

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
