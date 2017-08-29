package fr.prepavenir.guide.ui.details;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.prepavenir.guide.AppActivity;
import fr.prepavenir.guide.R;

public class DetailsActivity extends AppActivity {

    private ImageView imageViewPhoto;
    private TextView textViewTitle, textViewCategory, textViewStars;
    private Button buttonEmail, buttonPhone, buttonUrl;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        imageViewPhoto = (ImageView) findViewById(R.id.imageViewPhoto);
        textViewTitle = (TextView) findViewById(R.id.textViewtitle);
        textViewStars = (TextView) findViewById(R.id.textViewStars);
        textViewCategory = (TextView) findViewById(R.id.textViewCategory);
        buttonEmail = (Button) findViewById(R.id.buttonEmail);
        buttonPhone = (Button) findViewById(R.id.buttonPhone);
        buttonUrl = (Button) findViewById(R.id.buttonUrl);

        //récupérer des données
        if(getIntent().getExtras()!= null) {
            String title = getIntent().getExtras().getString("title");
            String category = getIntent().getExtras().getString("category");
            String email = getIntent().getExtras().getString("email");
            String phone = getIntent().getExtras().getString("phone");
            String url = getIntent().getExtras().getString("url");
            String image = getIntent().getExtras().getString("image");
            String stars = getIntent().getExtras().getString("stars");

            textViewTitle.setText(title); // affichage du titre
            textViewCategory.setText(category);
            buttonEmail.setText(email);
            buttonPhone.setText(phone);
            buttonUrl.setText(url);

            if (stars !=null) {
            textViewStars.setVisibility(View.VISIBLE);
            textViewStars.setText(String.format(getString(R.string.listing_hotels_stars), stars)); // pour afficher x étoiles
            }else {
                textViewStars.setVisibility(View.GONE); // rendre invisible la zone "stars'
            }
            // TODO : afficher de l'image
            Picasso.with(DetailsActivity.this)
                    .load(image) //url http:// vers l'image
                    .into(imageViewPhoto);
        }

        buttonEmail.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {

                Intent intentEmail = new Intent(Intent.ACTION_SEND);
                intentEmail.setType("message/rfc822"); //filtre application messagerie

                intentEmail.putExtra(Intent.EXTRA_SUBJECT, "objet du message");
                intentEmail.putExtra(Intent.EXTRA_TEXT, "corps du message");

                intentEmail.putExtra(Intent.EXTRA_EMAIL, new String[] {buttonEmail.getText().toString(), "soumytour@yahoo.fr"}); // destinataire

                intentEmail.putExtra(Intent.EXTRA_CC, new String[] {"soumytour10@gmail.com", "soumytour@yahoo.fr"}); // email en copie

                startActivity(intentEmail); //lancement
            }
        });

        buttonPhone.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent intentPhone =  new Intent(Intent.ACTION_DIAL);
                intentPhone.setData(Uri.parse("tel:" + buttonPhone.getText().toString()));
                startActivity(intentPhone); //lancement

        }
        });

        buttonUrl.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){

                // redirection vers une page web
                Intent intentWeb = new Intent(Intent.ACTION_VIEW);
                intentWeb.setData(Uri.parse(buttonUrl.getText().toString()));
                startActivity(intentWeb); //lancement

            }
        });

    }
}
