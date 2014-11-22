package tw.soleil.androidvillage.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.parse.ParseObject;
import com.squareup.picasso.Picasso;

import java.util.List;

import tw.soleil.androidvillage.R;

/**
 * Created by bryan on 2014/11/22.
 */
public class FoodAdapter extends ArrayAdapter <ParseObject> {

    public FoodAdapter(Context context, int resource, List<ParseObject> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.cell_food, null);

        ImageView foodImageView = (ImageView)convertView.findViewById(R.id.food_imageView);

        ParseObject eachFoodObject = getItem(position);

        Picasso.with(getContext()).load(eachFoodObject.getParseFile("imageFile").getUrl()).into(foodImageView);

        TextView foodNameTextView = (TextView)convertView.findViewById(R.id.food_name_textView);
        foodNameTextView.setText(eachFoodObject.getString("name"));

        TextView foodPriceTextView = (TextView)convertView.findViewById(R.id.food_price_textView);
        foodPriceTextView.setText(eachFoodObject.getNumber("price").toString());

        return convertView;
    }
}
