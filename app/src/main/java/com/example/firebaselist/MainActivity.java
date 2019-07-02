package com.example.firebaselist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    static Movie movieSelected;
    List<Movie> myList;
    ListView realListView;
    DatabaseReference dbref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbref = FirebaseDatabase.getInstance().getReference("MovieList");
        myList = new ArrayList<>();

        realListView = findViewById(R.id.listView);
        realListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.e("LIST 1", "Selected Position: " + position);
                movieSelected = myList.get(position);
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(i);
            }
        });

        //==============================only run the below code 1 time to set up this Data in FirebaseDataBase under "MovieList"
      /* Movie m = new Movie("ShawShank Redemption", "Drama", "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX182_CR0,0,182,268_AL_.jpg", 1994, 142, 9.3f);
       dbref.push().setValue(m);
       myList.add(m);
       m = new Movie("God Father", "Crime", "https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UY268_CR3,0,182,268_AL_.jpg", 1972, 175, 9.2f);
       myList.add(m);
       dbref.push().setValue(m);
       m = new Movie("Dark Night", "Action", "https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_UX182_CR0,0,182,268_AL_.jpg", 2008, 152, 9.0f);
       myList.add(m);
       dbref.push().setValue(m);
       m = new Movie("12 Angry Men", "Drama", "https://m.media-amazon.com/images/M/MV5BMWU4N2FjNzYtNTVkNC00NzQ0LTg0MjAtYTJlMjFhNGUxZDFmXkEyXkFqcGdeQXVyNjc1NTYyMjg@._V1_UX182_CR0,0,182,268_AL_.jpg", 1957, 156, 8.9f);
       myList.add(m);
       dbref.push().setValue(m);
       m = new Movie("Pulp Fiction", "Crime/Drama", "https://m.media-amazon.com/images/M/MV5BNGNhMDIzZTUtNTBlZi00MTRlLWFjM2ItYzViMjE3YzI5MjljXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UY268_CR1,0,182,268_AL_.jpg", 1994, 154, 8.9f);
       myList.add(m);
       dbref.push().setValue(m);
       m = new Movie("Fignt Club", "Drama", "https://m.media-amazon.com/images/M/MV5BMjJmYTNkNmItYjYyZC00MGUxLWJhNWMtZDY4Nzc1MDAwMzU5XkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX182_CR0,0,182,268_AL_.jpg", 1999, 139, 8.8f);
       myList.add(m);
       dbref.push().setValue(m);*/
        //=============================================
    }//on Create ends.......

    @Override
    protected void onStart() {
        super.onStart();

        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                myList.clear();

                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    Movie m = childSnapshot.getValue(Movie.class);
                    myList.add(m);
                    Log.e("InsideFORLOOP", "Key: " + childSnapshot.getKey());
                }

                Log.e("Stuff", "Count: " + dataSnapshot.getChildrenCount());
                //creating adapter... now you create the adapter by passing all the MovieObjects who are NOW... in the List "myList"
                MovieListAdapter movieAdapter = new MovieListAdapter(MainActivity.this, myList);
                realListView.setAdapter(movieAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}