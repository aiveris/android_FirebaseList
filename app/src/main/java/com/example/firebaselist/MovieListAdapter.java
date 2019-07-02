package com.example.firebaselist;

import android.app.Activity;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MovieListAdapter extends ArrayAdapter<Movie> {

        Activity context;
        List<Movie> listWithMovies;

        public MovieListAdapter(Activity context, List<Movie> listWithMovies){
            super(context,R.layout.list_layout_card_view, listWithMovies);//have to pass all this to super with the Layout that will be used
            this.context = context;//passing the activity as a parameter... not sure if it is the same as passing Context??
            this.listWithMovies = listWithMovies;
        }

        @NonNull
        @Override// this method seems to get called just before the ActualList(in MainAcitvity) is displayed & after the Adapter has been created all the data
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            //View view = super.getView(position, convertView, parent);//for only alternate color

            LayoutInflater inflater = context.getLayoutInflater();
            View listViewItem = inflater.inflate(R.layout.list_layout, null, true);//change for CardView to list_layout_card_view

            ImageView imgV = listViewItem.findViewById(R.id.imageView);
            TextView textViewName = listViewItem.findViewById(R.id.textViewName);
            TextView textViewGenre = listViewItem.findViewById(R.id.textViewGenre);
            TextView textViewRating = listViewItem.findViewById(R.id.textViewRating);
            View lay = listViewItem.findViewById(R.id.layout);//comment out for CardView

            Movie MovieInQuestion = listWithMovies.get(position);  // this returns an entire data row of the Movie at that position
            String urlphoto = MovieInQuestion.getUrl();

            Picasso.get().load(urlphoto).into(imgV);
            textViewName.setText(MovieInQuestion.getName());
            textViewGenre.setText(MovieInQuestion.getGenre());
            textViewRating.setText( String.valueOf(MovieInQuestion.getRating()) );

            if (position % 2 == 0) {
                lay.setBackgroundColor(Color.LTGRAY);//comment out for CardView
            }

            ///Every time an Movie objects of the MoviesListObj that was passed, needs to be set up correctly in the 2 textboxes by the inflator
            //the position of that Movie is taken.. then puts that Movies Name/Genre in the respective TxtViews.. andt then returns that List Item
            //So this inflator seems to be set up like that.

            return listViewItem;

        }
}
