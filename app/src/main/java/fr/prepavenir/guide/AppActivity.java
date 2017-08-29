package fr.prepavenir.guide;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import fr.prepavenir.guide.ui.home.HomeActivity;

/**
 * Created by Toure Soumaïla on 29/08/2017.
 */

public class AppActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case android.R.id.home:
                // TODO : fermer l'activity
                // finish();
                onBackPressed(); // méthode fléche retour physique/ virtuelle
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //afficher la flèche retour

        if (getSupportActionBar() != null) {

            if (!(this instanceof HomeActivity)) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }
        }
    }
}
