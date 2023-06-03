package afterRefactoring;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;


public class CustomerMenu 
{
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
        MovieLibrary movieLibrary = new MovieLibrary();
        Customer customer = new Customer();

        // Add sample movies to the movie library
        movieLibrary.addMovie(new Movie("Movie 1", "Action", 120));
        movieLibrary.addMovie(new Movie("Movie 2", "Comedy", 90));
        movieLibrary.addMovie(new Movie("Movie 3", "Drama", 150));
        movieLibrary.addMovie(new Movie("Movie 4", "Thriller", 110));

        while (true) {
            System.out.println("Movie Subscription Menu");
            System.out.println("1. View available movies");
            System.out.println("2. Subscribe to a movie");
            System.out.println("3. View subscribed movies");
            System.out.println("4. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.println("Available Movies:");
                    List<Movie> availableMovies = movieLibrary.getAvailableMovies();
                    for (Movie movie : availableMovies) {
                        System.out.println(movie);
                    }
                    break;
                case 2:
                    System.out.print("Enter the title of the movie to subscribe: ");
                    String movieTitle = scanner.nextLine();
                    Movie selectedMovie = movieLibrary.getMovieByTitle(movieTitle);
                    if (selectedMovie != null) {
                        customer.subscribeMovie(selectedMovie);
                        System.out.println("Movie subscribed successfully.");
                    } else {
                        System.out.println("Movie not found.");
                    }
                    break;
                case 3:
                    System.out.println("Subscribed Movies:");
                    List<Movie> subscribedMovies = customer.getSubscribedMovies();
                    for (Movie movie : subscribedMovies) {
                        System.out.println(movie);
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the Movie Subscription!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class Movie {
    private String title;
    private String genre;
    private int duration;

    public Movie(String title, String genre, int duration) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Movie [title=" + title + ", genre=" + genre + ", duration=" + duration + "]";
    }
}

class MovieLibrary {
    private List<Movie> movies;

    public MovieLibrary() {
        movies = new ArrayList<>();
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public List<Movie> getAvailableMovies() {
        return movies;
    }

    public Movie getMovieByTitle(String title) {
        for (Movie movie : movies) {
            if (movie.getTitle().equalsIgnoreCase(title)) {
                return movie;
            }
        }
        return null;
    }
}

class Customer {
    private List<Movie> subscribedMovies;

    public Customer() {
        subscribedMovies = new ArrayList<>();
    }

    public void subscribeMovie(Movie movie) {
        subscribedMovies.add(movie);
    }

    public List<Movie> getSubscribedMovies() {
        return subscribedMovies;
    }
}
