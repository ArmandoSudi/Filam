package sugar.filam;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        
        ListView moviesListView = (ListView) findViewById(R.id.listView);

        Movie[] movies = {
                new Movie("Hunger Games", R.drawable.ic_launcher, "Some girls getting revenge", "Not bad"),
                new Movie("Iron man 3", R.drawable.ic_launcher, "Ssome genius guy", "Not bad"),
                new Movie("Super man", R.drawable.ic_launcher, "The closest to saiyan", "Not bad"),
                new Movie("James Bond", R.drawable.ic_launcher, "Some gspy", "Not bad"),
                new Movie("Hunger Games", R.drawable.ic_launcher, "Some girls getting revenge", "Not bad"),
                new Movie("Hunger Games", R.drawable.ic_launcher, "Some girls getting revenge", "Not bad"),
                new Movie("Hunger Games", R.drawable.ic_launcher, "Some girls getting revenge", "Not bad"),
                new Movie("Hunger Games", R.drawable.ic_launcher, "Some girls getting revenge", "Not bad"),
                new Movie("Hunger Games", R.drawable.ic_launcher, "Some girls getting revenge", "Not bad"),
                new Movie("Hunger Games", R.drawable.ic_launcher, "Some girls getting revenge", "Not bad"),
                new Movie("Hunger Games", R.drawable.ic_launcher, "Some girls getting revenge", "Not bad"),
                new Movie("Hunger Games", R.drawable.ic_launcher, "Some girls getting revenge", "Not bad"),
                new Movie("Hunger Games", R.drawable.ic_launcher, "Some girls getting revenge", "Not bad"),
                new Movie("Hunger Games", R.drawable.ic_launcher, "Some girls getting revenge", "Not bad"),
                new Movie("Hunger Games", R.drawable.ic_launcher, "Some girls getting revenge", "Not bad"),
                new Movie("Hunger Games", R.drawable.ic_launcher, "Some girls getting revenge", "Not bad"),
                new Movie("Hunger Games", R.drawable.ic_launcher, "Some girls getting revenge", "Not bad"),
                new Movie("Hunger Games", R.drawable.ic_launcher, "Some girls getting revenge", "Not bad"),
                new Movie("Hunger Games", R.drawable.ic_launcher, "Some girls getting revenge", "Not bad"),
                new Movie("Hunger Games", R.drawable.ic_launcher, "Some girls getting revenge", "Not bad"),
                new Movie("Hunger Games", R.drawable.ic_launcher, "Some girls getting revenge", "Not bad"),
        };
        List<Movie> moviesList = Arrays.<Movie>asList(movies);

        MovieAdapter movieAdapter = new MovieAdapter(this, moviesList);
        moviesListView.setAdapter(movieAdapter);
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
}
