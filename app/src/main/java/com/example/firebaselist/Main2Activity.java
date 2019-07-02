package com.example.firebaselist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Main2Activity extends AppCompatActivity {
    TextView txtName, txtYear, txtLength, txtRating, txtGenre;
    ImageView imgV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imgV = findViewById(R.id.imageView);

        Picasso.get().load(MainActivity.movieSelected.getUrl()).into(imgV);

        txtName = findViewById(R.id.textView1);
        txtYear = findViewById(R.id.textView2);
        txtGenre = findViewById(R.id.textView3);
        txtRating = findViewById(R.id.textView4);
        txtLength = findViewById(R.id.textView5);

        txtName.setText( MainActivity.movieSelected.getName());
        txtGenre.setText( MainActivity.movieSelected.getGenre());
        txtYear.setText( String.valueOf(MainActivity.movieSelected.getYear()) );
        txtLength.setText( String.valueOf( MainActivity.movieSelected.getLength()) + "mins" );
        txtRating.setText( String.valueOf( MainActivity.movieSelected.getRating()) );

    }
}
