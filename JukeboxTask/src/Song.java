import java.util.*;

/**
 * This Class creates the Song object, and contains the get methods for it's
 * data members.
 * 
 * @author Jordan Lever
 *
 */
public class Song implements Comparable<Song> {
	/**
	 * the name of the song
	 */
	private String name;
	/**
	 * The song's artist
	 */
	private String artist;
	/**
	 * The name of the album
	 */
	private String album;
	/**
	 * The rating of song
	 */
	private String rating;

	/**
	 * This is the constructor that initialized the data members
	 * 
	 * @param name1
	 *            the name of the song
	 * @param artist1
	 *            the artist
	 * @param album1
	 *            the album name
	 * @param runtime1
	 *            the song length
	 */
	public Song(String name1, String artist1, String album1, String rating1) {
		name = name1;
		artist = artist1;
		album = album1;
		rating = rating1;

	}

	/**
	 * This method gets the name of the song
	 * 
	 * @return the name of the song
	 */
	public String getTitle() {
		return name;
	}

	/**
	 * This method gets the artists name
	 * 
	 * @return the artists name
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * This method gets the album name
	 * 
	 * @return the album name
	 */
	public String getAlbum() {
		return album;
	}

	/**
	 * This method gets the length of the song
	 * 
	 * @return the runtime of the song
	 */
	public String getRating() {
		return rating;
	}

	/**
	 * This is the ToString method that overwrites the java method in order to
	 * print Song how i would like it to.
	 */
	@Override
	public String toString() {
		return name + ", " + artist + ", " + album + ", " + rating + "\n";
	}

	/**
	 * This is the compare to that sorts the songs first by rating and in case
	 * of a tie by the name of the song.
	 * 
	 * @return 1 if greater than, -1 if less than
	 */
	@Override
	public int compareTo(Song s) {
		if (this.rating.compareToIgnoreCase(s.rating) == 0) {
			if (this.name.compareToIgnoreCase(s.name) == 0) {
				return 0;
			} else if (this.name.compareToIgnoreCase(s.name) < 0) {
				return -1;
			} else {
				return 1;
			}
		} else if (this.rating.compareToIgnoreCase(s.rating) > 0) {
			return -1;
		} else {
			return 1;
		}

	}

}