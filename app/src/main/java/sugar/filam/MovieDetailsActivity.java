package sugar.filam;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MovieDetailsActivity extends AppCompatActivity {

    private static final String LOG_TAG = MovieAdapter.class.getSimpleName();
    private static final String MOVIEDB_MOVIE_POSTER_BASE_URL = "http://image.tmdb.org/t/p/w780";
    private static final String TAG = "movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
        displayMovieDetails(intent);
    }

    public void displayMovieDetails(Intent intent){

        // setting up the view
        ImageView moviePosterIV = (ImageView)findViewById(R.id.moviePosterIV);
        TextView movieTitleTV = (TextView)findViewById(R.id.movieTitleTV);
        TextView movieReleaseDateTV = (TextView)findViewById(R.id.movieReleaseDateTV);
        TextView movieUserRatingTV = (TextView)findViewById(R.id.movieUserRatingTV);
        TextView movieSynopsisTV = (TextView)findViewById(R.id.movieSynopsisTV);

        Movie movie = intent.getParcelableExtra(TAG);

        // updating the details of the movie selected
        Picasso.with(this).load(MOVIEDB_MOVIE_POSTER_BASE_URL + movie.getPosterPath()).into(moviePosterIV);
        movieTitleTV.setText(movie.getOriginalTitle());
        movieReleaseDateTV.setText(movie.getReleaseDate());
        movieUserRatingTV.setText(movie.getUserRating());
        movieSynopsisTV.setText(movie.getSynopsis());
    }
}
