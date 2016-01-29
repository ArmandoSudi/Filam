package sugar.filam;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * author : sugar on 6/12/15.
 */
public class MovieAdapter extends ArrayAdapter<Movie> {

    private static final String LOG_TAG = MovieAdapter.class.getSimpleName();
    private static final String MOVIEDB_MOVIE_POSTER_BASE_URL = "http://image.tmdb.org/t/p/w342";

    public MovieAdapter(Activity context, List<Movie> movies) {
        super(context, 0, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.movie_item_layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.moviePoster = (ImageView) convertView.findViewById(R.id.movie_poster);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

       Movie movie = getItem(position);
        if (movie != null) {
            // TODO : create an asynch task to download the movie poster
            Picasso.with(getContext()).load(MOVIEDB_MOVIE_POSTER_BASE_URL + movie.getPosterPath()).into(viewHolder.moviePoster);
            Log.i(LOG_TAG, movie.getPosterPath());
            Log.i(LOG_TAG, movie.getReleaseDate());
        }

        return convertView;
    }

    private static class ViewHolder {
        ImageView moviePoster;
    }
}
