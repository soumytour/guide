package fr.prepavenir.guide.ui.listing;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import fr.prepavenir.guide.R;
import fr.prepavenir.guide.models.Restaurant;

/**
 * Created by Toure Soumaïla on 24/08/2017.
 */

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {

    private int resId;
    private LayoutInflater inflater; //par defaut egal à null

    public RestaurantAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Restaurant> objects) {
        super(context, resource, objects);

        resId = resource; // récupération du layout.item_restaurant
        inflater = LayoutInflater.from(context); // permet d'afficher layout item_restaurant
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder myViewHolder; //déclaration

        //afichage du layout item_restaurant
        if (convertView == null) {
        convertView = inflater.inflate(resId, null); // permet d'afficherle layout item_restarant

            myViewHolder = new ViewHolder(); // instance de class

        myViewHolder.textViewTitle = (TextView) convertView.findViewById(R.id.textViewtitle);
        myViewHolder.textViewCategory = (TextView) convertView.findViewById(R.id.textViewCategory);
          convertView.setTag(myViewHolder); // enregistrer les propriétés title /category
        }else {
           myViewHolder = (ViewHolder) convertView.getTag(); //récupération des proprités
        }
        //récupération d'un objet par rapport à la position
        Restaurant item = getItem(position);

        //affichage des informations du Restaurant
        myViewHolder.textViewTitle.setText(item.getName());
        myViewHolder.textViewCategory.setText(item.getCategory());
       // }



        return convertView;
    }

    class ViewHolder {
        TextView textViewTitle;
        TextView textViewCategory;
    }

}
