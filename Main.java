import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

        // CREATE INSTANCE VARIABLES HERE. Ensure they are static.
        // May want to create an array of goodbye answers.
        static String[] goodBye = { "bye" };
        static Book[] fictionBooksUnder11 = {
                        new Book("Harry Potter", "J.K. Rowling", "Fantasy"),
                        new Book("Percy Jackson", "Rick Riordan", "Fantasy"),
                        new Book("The Maze Runner", "James Dashner", "Science Fiction"),
                        new Book("A Wrinkle in Time", "Madeline L Engle", "Science Fiction"),
                        new Book("Wonder", "R.J. Palacio", "Friendships"),
                        new Book("One and Only Ivan", "Katherine Applegate", "Friendships"),
                        new Book("Doll Bones", "Holly Black", "Horror/Thriller"),
                        new Book("Coraline", "Neil Gaiman", "Horror/Thriller"),
                        new Book("Nancy Drew: The Secret of the Old Clock", "Carolyn Keene", "Mystery"),
                        new Book("The Van Goh Deception", "Deron R. Hicks", "Mystery"),
                        new Book("Al Capone Does My Shirts", "Gennifer Choldenko", "Historical Fiction"),
                        new Book("Refugee", "Alan Gratz", "Historical Fiction")
        };
        static Book[] fictionBooksTeen = {

                        new Book("The Hobbit", "JRR Tolkein", "Fantasy"),
                        new Book("Everlost", "Neal Shusterman", "Fantasy"),
                        new Book("Zeroboxer", "Fonda Lee", "Science Fiction"),
                        new Book("Scythe", "Neal Shushterman", "Science Fiction"),
                        new Book("The Seven Husbands of Evelyn Hugo", "Taylor Jenkins Reid", "Romance"),
                        new Book("Save Me a Seat", "Gita Varadarajan and Sarah Weeks", "Romance"),
                        new Book("Theres Someone Inside Your House", "Stephanie Perkins", "Horror/Thriller"),
                        new Book("Five Survive", "Holly Jackson", "Horror/Thriller"),
                        new Book("A Good Girls Guide To Murder", "Holly Jackson", "Mystery"),
                        new Book("The Inheritance Games", "Jennifer Lynn Barnes", "Mystery"),
                        new Book("The Book Theif", "Markus Zusak", "Historical Fiction"),
                        new Book("My Lady Jane", "Cynthia Hand", "Historical Fiction")
        };
        static Book[] fictionBooksAdult = {
                        new Book("Fourth Wing", "Rebecca Yarros", "Fantasy"),
                        new Book("One Dark Window", "Rachel Gillig", "Fantasy"),
                        new Book("Exodus", "Peter F. Hamilton", "Science Fiction"),
                        new Book("Children Of Memory", "Adrian Tchaikovsky", "Science Fiction"),
                        new Book("The Love Hypothesis", "Ali Hazelwood", "Romance"),
                        new Book("Red, White, and Royal Blue", "Casey McQuinston", "Romance"),
                        new Book("The Silent Patient", "Alex Michaelides", "Horror/Thriller"),
                        new Book("Tender Is The Flesh", "Agustina Bazterrica", "Horror/Thriller"),
                        new Book("The Maid", "Nita Prose", "Mystery"),
                        new Book("The Mysterious Affair At Styles", "Agatha Cirstie", "Mystery"),
                        new Book("All the Light We Cannot See", "Anthony Doerr", "Historical Fiction"),
                        new Book("Where the Crawdads Sing", "Delia Owens", "Historical Fiction")
        };

        static Book[] nonFictionBooksUnder11 = {
                        new Book("National Geographic First Book of Science", "National Geographic", "Science"),
                        new Book("How Things Work", "National Geographic", "Science"),
                        new Book("The Extraordinary Mark Twain", "Barbara Kerley", "Biography"),
                        new Book("I am Sacagawea", "Scholastic", "Biography"),
                        new Book("The World Needs Who You Were Meant to Be", "Joanne Gaines", "Self-help"),
                        new Book("How Full is Your Bucket?", "Tom Rath", "Self-help")
        };
        static Book[] nonFictionBooksTeen = {
                        new Book("All Your Twisted Secrets", "Diana Urban", "Science"),
                        new Book("The 57 Bus", "Dashka Slater", "Science"),
                        new Book("The Plot to Kill Hitler", "Patrick McCormick", "Biography"),
                        new Book("Just Mercy", "Bryan Stevenson", "Biography"),
        };

        static Book[] nonFictionBooksAdult = {
                        new Book("American Predator", "Maureen Callahan", "Science"),
                        new Book("I'll Be Gone in the Dark", "Michelle McNarama", "Science"),
                        new Book("Elon Musk", "Walter Isaacson", "Biography"),
                        new Book("Educated", "Tara Westover", "Biography")
        };
        static String[] answers = { "yes", "no", "yeah", "yep", "yup", "nope", "fiction", "nonfiction", "fantasy",
                        "science fiction", "historical fiction", "mystery", "romance", "friendship", "horror/thriller",
                        "auto/biographies", "self-help", "true crime", "science" };
        static String[] response = { "Sorry, I don't understand.", "Sorry, I don't get that.",
                        "Sorry, I can't comprehend.", "Please enter a valid response.", "Sorry, I don't recognize that",
                        "Sorry, I'm not aware of that response." };
        static String[] niceResponses = { "Okay, thank you!", "Great!", "Nice choice!", "Awesome!", "Terrific!",
                        "Cool!", "Great choice!", "Awesome choice!" };

        public static void main(String[] args) {
                Scanner in2 = new Scanner(System.in);

                while (true) {
                        Answer answer = getAnswer(in2);
                        recommendBook(answer);

                        System.out.println("Say stop to stop or anything else to keep going!");
                        String stop = in2.nextLine();
                        if(stop.equals("stop")){
                                System.out.println("Bye!");
                                break;
                        }
                        
                }
        }

        public static Answer getAnswer(Scanner in2) {
                System.out.println(
                                "Hello, I am book recommender. I can recommend books for you!");

                int age;
                while (true) {
                        System.out.println("How old are you? (Enter a digit.)");
                        try {
                                age = in2.nextInt(); // Gets the user's input as an integer.
                                break;
                        } catch (InputMismatchException exception) {
                                in2.nextLine();
                        }
                }
                in2.nextLine();

                boolean isFiction;
                while (true) {
                        System.out.println("Do you prefer fiction or nonfiction? (fiction/nonfiction)");
                        String userResp1 = in2.nextLine();
                        if (userResp1.equals("fiction")) {
                                isFiction = true;
                                break;
                        } else if (userResp1.equals("nonfiction")) {
                                isFiction = false;
                                break;
                        }
                }

                boolean isRandom;
                while (true) {
                        System.out.println("Would you like a random book? (yes/no)");
                        String userResp1 = in2.nextLine();
                        if (userResp1.equals("yes")) {
                                isRandom = true;
                                break;
                        } else if (userResp1.equals("no")) {
                                isRandom = false;
                                break;
                        }
                }

                String genre = null;
                if (!isRandom) {
                        if (isFiction) {
                                while (true) {
                                        System.out.println(
                                                        "Ok! What genre would you like? (fantasy, science fiction, friendships, horror/thriller, mystery, historical fiction, fantasy?");
                                        String userResp3 = in2.nextLine();
                                        if (userResp3.equals("fantasy")) {
                                                genre = "Fantasy";
                                                break;
                                        } else if (userResp3.equals("science fiction")) {
                                                genre = "Science Fiction";
                                                break;
                                        } else if (userResp3.equals("friendships")) {
                                                genre = "Friendships";
                                                break;
                                        } else if (userResp3.equals("horror/thriller")) {
                                                genre = "Horror/Thriller";
                                                break;
                                        } else if (userResp3.equals("mystery")) {
                                                genre = "Mystery";
                                                break;
                                        } else if (userResp3.equals("historical fiction")) {
                                                genre = "Historical Fiction";
                                                break;
                                        } else if (userResp3.equals("fantasy")) {
                                                genre = "Fantasy";
                                                break;
                                        }

                                }
                        } else {
                                while (true) {
                                        System.out.println(
                                                        "Okay! What genre would you like? (science, biography, self help)");
                                        String userResp3 = in2.nextLine();
                                        if (userResp3.equals("science")) {
                                                genre = "Science";
                                                break;
                                        } else if (userResp3.equals("biography")) {
                                                genre = "Biography";
                                                break;
                                        } else if (userResp3.equals("self help")) {
                                                genre = "Self-help";
                                                break;
                                        }
                                }
                        }
                }

                return new Answer(age, isFiction, isRandom, genre);
        }

        static public void recommendBook(Answer answer) {
                Book[] selection = null;
                int age = answer.getAge();

                if (answer.getIsFiction()) {
                        if (age <= 11) {
                                selection = fictionBooksUnder11;
                        } else if (age < 18) {
                                selection = fictionBooksTeen;
                        } else {
                                selection = fictionBooksAdult;
                        }
                } else {
                        if (age <= 11) {
                                selection = nonFictionBooksUnder11;
                        } else if (age < 18) {
                                selection = nonFictionBooksTeen;
                        } else {
                                selection = nonFictionBooksAdult;
                        }
                }

                if (answer.getIsRandom()) {
                        recommendRandomBook(selection);
                } else {
                        recommendGenreBook(selection, answer.getGenre());
                }
        }

        static public void recommendRandomBook(Book[] selection) {
                int x = (int) (Math.random() * selection.length);
                System.out.println("We recommend " + selection[x].getTitle() + " by " + selection[x].getAuthor());
        }

        static public void recommendGenreBook(Book[] selection, String genre) {
                String redText = "\u001B[31m";
                String resetText = "\u001B[0m";
                for (int i = 0; i < selection.length; i++) {
                        if (selection[i].getGenre().equals(genre)) {
                                System.out.println(redText + "We recommend " + selection[i].getTitle() + " by "
                                                + selection[i].getAuthor() + resetText);
                                return;
                        }
                }

                System.out.println("Sorry! We couldn't find a book with those requirements.");
        }

}
