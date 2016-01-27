package sugar.filam;

/**
 * author : sugar on 6/12/15.
 */
public class Movie {

    private String originalTitle;
    private int image;
    private String synopsis;
    private String userRating;
    private String releaseDate;
    private String posterPath;

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public Movie(String originalTitle, int image, String synopsis, String userRating, String posterPath) {
        this.originalTitle = originalTitle;
        this.image = image;
        this.synopsis = synopsis;
        this.userRating = userRating;
        this.posterPath = posterPath;

    }

    public Movie(String originalTitle, String userRating, String releaseDate, String posterPath) {
        this.originalTitle = originalTitle;
        this.userRating = userRating;
        this.releaseDate = releaseDate;
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {

        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "originalTitle=" + originalTitle +
                '}';
    }
}
