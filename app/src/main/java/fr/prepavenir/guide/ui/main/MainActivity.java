package fr.prepavenir.guide.ui.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

import fr.prepavenir.guide.AppActivity;
import fr.prepavenir.guide.ui.home.HomeActivity;
import fr.prepavenir.guide.R;

public class MainActivity extends AppActivity {

    private Timer myTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // transition vers l'écran d'accueil

        myTimer = new Timer();
        myTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                // TODO : lancer l'écran HomeActivity

                Intent myIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(myIntent);
               // finish(); // pour fermer l'activity ou android:noHistory="true"
            }
        },2000);

    }
}
