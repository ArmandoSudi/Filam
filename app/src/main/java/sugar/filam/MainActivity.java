package sugar.filam;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MovieAdapter movieAdapter;
    private final String LOG_TAG = MainActivity.class.getSimpleName();
    private final String TAG = "movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        GridView moviesPosterGrid= (GridView) findViewById(R.id.moviePosterGrid);

        movieAdapter = new MovieAdapter(this, new ArrayList<Movie>());
        moviesPosterGrid.setAdapter(movieAdapter);
        moviesPosterGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Movie movie = (Movie)parent.getAdapter().getItem(position);
                Intent intent = new Intent(MainActivity.this, MovieDetailsActivity.class);
                intent.putExtra(TAG, movie);
                startActivity(intent);
            }
        });
        updateMovies();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void updateMovies() {
        new FetchMoviesTask().execute();
    }

    private List<Movie> getMoviesFromJson(String jsonStr) throws JSONException{

        final String MOVIE_ORIGINAL_TITLE = "original_title";
        final String MOVIE_OVERVIEW = "overview";
        final String MOVIE_RELEASE_DATE = "release_date";
        final String MOVIE_POSTER_PATH = "poster_path";
        final String MOVIE_VOTE_AVERAGE = "vote_average";
        final boolean MOVIE_IS_ADULT = false;
        final String MOVIE_POPULARITY = "popularity";

        List<Movie> movies = new ArrayList<Movie>();

        JSONObject movieJson = new JSONObject(jsonStr);
        JSONArray movieArray = movieJson.getJSONArray("results");

        for(int i=0; i < movieArray.length(); i++){
            JSONObject movieJsonObject = movieArray.getJSONObject(i);
            String title = movieJsonObject.getString(MOVIE_ORIGINAL_TITLE);
            String synopsis = movieJsonObject.getString(MOVIE_OVERVIEW);
            String rating = movieJsonObject.getString(MOVIE_VOTE_AVERAGE);
            String releaseDate = movieJsonObject.getString(MOVIE_RELEASE_DATE);
            String posterPath = movieJsonObject.getString(MOVIE_POSTER_PATH);
            movies.add(new Movie(title, synopsis, rating, releaseDate, posterPath));

            // Checking if the movie detais have been successfully retrieved
            Log.d(LOG_TAG, title + " " + rating + " " + releaseDate + " " + posterPath);
        }

        return movies;
    }

    class FetchMoviesTask extends AsyncTask<Void, Void, List<Movie>> {

        private String LOG_TAG = FetchMoviesTask.class.getName();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(List<Movie> movies) {
            super.onPostExecute(movies);
            if (movies != null) {
                for (Movie movie : movies) {
                    movieAdapter.add(movie);
                }
            }
        }

        @Override
        protected List<Movie> doInBackground(Void... params) {
            // READING DATA FROM THE API PROVIDED BY THE MOVIEDB
            HttpURLConnection urlConnection;
            BufferedReader reader;
            String moviesJson;
            List<Movie> results;

            try {
                // building the url based on the passed parameters
                final String MOVIEDB_API_BASE_URL = "http://api.themoviedb.org/3/discover/movie?";
                final String SORTING_PARAM = "sort_by";
                final String API_KEY_PARAM = "api_key";
                final String PRIMARY_RELEASE_DATE_PARAM = "primary_release_date";

                Uri builtUri = Uri.parse(MOVIEDB_API_BASE_URL).buildUpon()
                        .appendQueryParameter(SORTING_PARAM, "popularity.desc")
                        .appendQueryParameter(API_KEY_PARAM, getResources().getString(R.string.api_key))
                        .build();
                URL url = new URL(builtUri.toString());

                // url built for the query
                Log.d(TAG, url.toString());
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                // read the input stream as a string
                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if(inputStream == null) { return null;}

                reader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                while((line = reader.readLine()) != null ) {
                    buffer.append(line + "\n");
                }

                if (buffer.length() == 0) { moviesJson = null;}
                // building the movies object based on the data in the json
                moviesJson = buffer.toString();
                try {
                    results = getMoviesFromJson(moviesJson);
                }catch (JSONException exception){
                    Log.e(LOG_TAG, "error", exception);
                    return null;
                }
            } catch(IOException exception) {
                Log.e(LOG_TAG, "error", exception);
                return null;
            }
            return results;
        }
    }
}
