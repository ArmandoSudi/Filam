package sugar.filam;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * author : sugar on 6/12/15.
 */
public class Movie implements Parcelable {

    private final String originalTitle;
    private final String synopsis;
    private final String userRating;
    private final String releaseDate;
    private final String posterPath;

    public Movie(String originalTitle,String synopsis, String userRating, String releaseDate, String posterPath) {
        this.originalTitle = originalTitle;
        this.synopsis = synopsis;
        this.userRating = userRating;
        this.releaseDate = releaseDate;
        this.posterPath = posterPath;
    }

    private Movie(Parcel parcel) {
        originalTitle = parcel.readString();
        synopsis = parcel.readString();
        userRating = parcel.readString();
        releaseDate = parcel.readString();
        posterPath = parcel.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // saving data
    @Override
    public void writeToParcel(Parcel destination, int flags) {
        destination.writeString(originalTitle);
        destination.writeString(synopsis);
        destination.writeString(userRating);
        destination.writeString(releaseDate);
        destination.writeString(posterPath);
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getPosterPath() {return this.posterPath;}
    public String getReleaseDate() {return this.releaseDate;}
    public String getOriginalTitle() {return this.originalTitle;}
    public String getSynopsis() {
        return this.synopsis;
    }
    public String getUserRating() {return this.userRating;}

    @Override
    public String toString() {
        return "Movie{" +
                "originalTitle=" + this.originalTitle +
                '}';
    }

}
