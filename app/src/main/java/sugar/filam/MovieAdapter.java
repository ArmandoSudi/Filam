package sugar.filam;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * author : sugar on 6/12/15.
 */
public class MovieAdapter extends ArrayAdapter<Movie> {

    private static final String LOG_TAG = MovieAdapter.class.getSimpleName();

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
            viewHolder.movieTitle = (TextView) convertView.findViewById(R.id.movie_title);
            viewHolder.movieRating = (TextView) convertView.findViewById(R.id.movie_rating);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

       Movie movie = getItem(position);
        if (movie != null) {
            viewHolder.moviePoster.setImageResource(movie.getImage());
            viewHolder.movieTitle.setText(movie.getOriginalTitle());
            viewHolder.movieRating.setText(movie.getUserRating());
        }

        return convertView;
    }

    private static class ViewHolder {
        ImageView moviePoster;
        TextView movieTitle;
        TextView movieRating;
    }
}
