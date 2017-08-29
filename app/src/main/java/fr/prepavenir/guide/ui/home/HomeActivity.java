package fr.prepavenir.guide.ui.home;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import fr.prepavenir.guide.AppActivity;
import fr.prepavenir.guide.R;
import fr.prepavenir.guide.ui.listing.ListingActivity;

public class HomeActivity extends AppActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void showRestaurant(View view) {
        Intent intentRestaurant = new Intent(HomeActivity.this, ListingActivity.class);


        // passage d'un paramètre "isRestaurant" (boolean)

        intentRestaurant.putExtra("isRestaurant", true);

        startActivity(intentRestaurant); // déclenche l'ouverture de la page (activity)
    }

    public void showHotel(View view) {

        Intent intentHotel = new Intent(HomeActivity.this, ListingActivity.class);


        // passage d'un paramètre "is restaurant" (boolean)

        intentHotel.putExtra("isRestaurant", false);

        startActivity(intentHotel); // déclenche l'ouverture de la page (activity)
    }
}
