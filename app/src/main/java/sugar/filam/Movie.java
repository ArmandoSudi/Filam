package sugar.filam;

/**
 * author : sugar on 6/12/15.
 */
public class Movie {

    private StringBuilder originalTitle;
    private int image;
    private StringBuilder synopsis;
    private StringBuilder userRating;

    public Movie(StringBuilder originalTitle, int image, StringBuilder synopsis, StringBuilder userRating) {
        this.originalTitle = originalTitle;
        this.image = image;
        this.synopsis = synopsis;
        this.userRating = userRating;
    }

    public StringBuilder getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(StringBuilder originalTitle) {
        this.originalTitle = originalTitle;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public StringBuilder getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(StringBuilder synopsis) {
        this.synopsis = synopsis;
    }

    public StringBuilder getUserRating() {
        return userRating;
    }

    public void setUserRating(StringBuilder userRating) {
        this.userRating = userRating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "originalTitle=" + originalTitle +
                '}';
    }
}
