package fr.prepavenir.guide.ui.listing;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import fr.prepavenir.guide.AppActivity;
import fr.prepavenir.guide.ui.details.DetailsActivity;
import fr.prepavenir.guide.R;
import fr.prepavenir.guide.models.Hotel;
import fr.prepavenir.guide.models.Restaurant;

public class ListingActivity extends AppActivity {


    //déclaration des propriétés

    private TextView textViewTitle;
    private GridView gridViewData;

    private List<Restaurant> restaurantList = new ArrayList<>(); //initialisation de la liste


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing);


        textViewTitle = (TextView) findViewById(R.id.textViewtitle);
        gridViewData = (GridView) findViewById(R.id.gridViewData);

        if(getIntent().getExtras() != null) {
            boolean isRestaurant = getIntent().getExtras().getBoolean("isRestaurant");

            if(isRestaurant) { //true
                textViewTitle.setText(getString(R.string.listing_title_restaurant));

                //ajout restaurant

                restaurantList.add(new Restaurant("La crémaillaire", "Gastronomie", "info@yahoo.fr", "02 32 51 42 15", "http://www.yahoo.fr", "http://www.thermal.cz/files/hotel/thermal/01-hotel/bar-and-restaurant/thermal-hotel-restaurant-and-lobby-02.jpg?h=1440&w=2048"));
                restaurantList.add(new Restaurant("Buffalo grille", "Gastronomie", "info@yahoo.fr", "02 32 51 42 15", "http://www.yahoo.fr", "https://media-cdn.tripadvisor.com/media/photo-s/09/bb/31/89/buffalo-grill.jpg"));
                restaurantList.add(new Restaurant("Restaurant saint martin", "Gastronomie", "info@yahoo.fr", "02 32 51 42 15", "http://www.yahoo.fr", "http://quirepond.fr/wp-content/uploads/2016/07/restau.jpg"));

                //gridViewData.setAdapter(new ArrayAdapter<Restaurant>(ListingActivity.this, android.R.layout.simple_list_item_1, restaurantList));

                gridViewData.setNumColumns(2);
                gridViewData.setAdapter(new RestaurantAdapter(ListingActivity.this, R.layout.item_restaurant, restaurantList));

                gridViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent myIntent = new Intent(ListingActivity.this, DetailsActivity.class);

                        //
                        Restaurant objet = restaurantList.get(position);

                        //TODO : envoyer les informations

                        myIntent.putExtra("title", objet.getName());
                        myIntent.putExtra("category", objet.getCategory());
                        myIntent.putExtra("email", objet.getEmail());
                        myIntent.putExtra("phone", objet.getPhone());
                        myIntent.putExtra("url", objet.getUrl());
                       // myIntent.putExtra("url", restaurantList.get(position).getCategory());
                        myIntent.putExtra("image", objet.getImage());
                        //etc...

                        startActivity(myIntent);
                    }
                });

            }else { //false
                 textViewTitle.setText(R.string.listing_title_hotel); //direct

                // ajout d'hôtel

                final List<Hotel> hotelList = new ArrayList<>();

                hotelList.add(new Hotel("Ibis", "Discount", "info@ibis.fr", "01 32 42 15 89", "http://www.ibishotel.com", "2", "https://www.ahstatic.com/photos/7161_ho_00_p_346x260.jpg"));
                hotelList.add(new Hotel("Mercure", "Discount", "info@ibis.fr", "01 32 42 15 89", "http://www.ibishotel.com", "5", "https://www.ahstatic.com/photos/3385_ho_00_p_2048x1536.jpg"));
                hotelList.add(new Hotel("Hilton", "Discount", "info@ibis.fr", "01 32 42 15 89", "http://www.ibishotel.com", "4", "http://www3.hilton.com/resources/media/hi/EWRBHHF/en_US/img/shared/full_page_image_gallery/main/hf_welcome_1_675x359_FitToBoxSmallDimension_Center.jpg"));
                hotelList.add(new Hotel("Albert 1er", "Discount", "info@ibis.fr", "01 32 42 15 89", "http://www.ibishotel.com", "3", "http://www.hotel-albert-1er.com/wp-content/blogs.dir/499/files/slider-background-home/fachada.jpg"));

                gridViewData.setAdapter(new HotelAdapter(ListingActivity.this, R.layout.item_hotel, hotelList));

                gridViewData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intentHotel = new Intent(ListingActivity.this, DetailsActivity.class);
                        // passage des informations
                        intentHotel.putExtra("title", hotelList.get(position).getName());
                        intentHotel.putExtra("category", hotelList.get(position).getCategory());
                        intentHotel.putExtra("email", hotelList.get(position).getEmail());
                        intentHotel.putExtra("phone", hotelList.get(position).getPhone());
                        intentHotel.putExtra("url", hotelList.get(position).getUrl());
                        intentHotel.putExtra("image", hotelList.get(position).getImage());
                        intentHotel.putExtra("stars", hotelList.get(position).getStars()); // nombre d'étoiles

                        startActivity(intentHotel);
                    }
                });
            }
        }
    }
}
