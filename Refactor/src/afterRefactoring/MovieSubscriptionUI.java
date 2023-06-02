package afterRefactoring;

import java.util.Scanner;

public class MovieSubscriptionUI {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MovieSubscription subscription = new MovieSubscription();

        while (true) {
            System.out.println("MovieTest Subscription Menu");
            System.out.println("1. Add a MovieTest to the subscription");
            System.out.println("2. Remove a MovieTest from the subscription");
            System.out.println("3. View all movies in the subscription");
            System.out.println("4. Quit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter the MovieTest title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter the MovieTest genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter the MovieTest duration: ");
                    int duration = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character
                    subscription.addMovie(new MovieTest(title, genre, duration));
                    System.out.println("MovieTest added to the subscription.");
                    break;
                case 2:
                    System.out.print("Enter the MovieTest title to remove: ");
                    String removeTitle = scanner.nextLine();
                    if (subscription.removeMovie(removeTitle)) {
                        System.out.println("MovieTest removed from the subscription.");
                    } else {
                        System.out.println("MovieTest not found in the subscription.");
                    }
                    break;
                case 3:
                    System.out.println("Movies in the subscription:");
                    MovieTest[] movies = subscription.getAllMovies();
                    for (MovieTest MovieTest : movies) {
                        System.out.println(MovieTest);
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the MovieTest Subscription!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

class MovieTest {
    private String title;
    private String genre;
    private int duration;

    public MovieTest(String title, String genre, int duration) {
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
        return "MovieTest [title=" + title + ", genre=" + genre + ", duration=" + duration + "]";
    }
}

class MovieSubscription {
    private static final int MAX_CAPACITY = 10;
    private MovieTest[] movies;
    private int count;

    public MovieSubscription() {
        movies = new MovieTest[MAX_CAPACITY];
        count = 0;
    }

    public void addMovie(MovieTest MovieTest) {
        if (count < MAX_CAPACITY) {
            movies[count++] = MovieTest;
        } else {
            System.out.println("MovieTest subscription is full. Cannot add more movies.");
        }
    }

    public boolean removeMovie(String title) {
        for (int i = 0; i < count; i++) {
            if (movies[i].getTitle().equalsIgnoreCase(title)) {
                for (int j = i; j < count - 1; j++) {
                    movies[j] = movies[j + 1];
                }
                movies[count - 1] = null;
                count--;
                return true;
            }
        }
        return false;
    }

    public MovieTest[] getAllMovies() {
        MovieTest[] allMovies = new MovieTest[count];
        System.arraycopy(movies, 0, allMovies, 0, count);
        return allMovies;
    }
}

