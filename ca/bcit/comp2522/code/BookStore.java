package ca.bcit.comp2522.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Represents a bookstore containing a collection of novels.
 * Provides methods to search, filter, and analyze the novel collection.
 *
 * @author Ziad Malik, Sebastion Roby
 * @version 1.0
 */
public class BookStore
{
    private static final int DECADE_SPAN = 10;
    private static final int PERCENTAGE_MULTIPLIER = 100;

    private final String name;
    private final List<Novel> novels;

    /**
     * Constructs a BookStore with the specified name and populates it with novels.
     *
     * @param name the name of the bookstore
     */
    public BookStore(final String name)
    {
        validateName(name);

        this.name = name;
        this.novels = new ArrayList<>();

        populateNovels();

        System.out.println("BookStore: " + name);
    }

    /**
     * Populates the novels list with the classic novel collection.
     */
    private void populateNovels()
    {
        novels.add(new Novel("The Adventures of Augie March", "Saul Bellow", 1953));
        novels.add(new Novel("All the King's Men", "Robert Penn Warren", 1946));
        novels.add(new Novel("American Pastoral", "Philip Roth", 1997));
        novels.add(new Novel("An American Tragedy", "Theodore Dreiser", 1925));
        novels.add(new Novel("Animal Farm", "George Orwell", 1946));
        novels.add(new Novel("Appointment in Samarra", "John O'Hara", 1934));
        novels.add(new Novel("Are You There God? It's Me, Margaret.", "Judy Blume", 1970));
        novels.add(new Novel("The Assistant", "Bernard Malamud", 1957));
        novels.add(new Novel("At Swim-Two-Birds", "Flann O'Brien", 1938));
        novels.add(new Novel("Atonement", "Ian McEwan", 2002));
        novels.add(new Novel("Beloved", "Toni Morrison", 1987));
        novels.add(new Novel("The Berlin Stories", "Christopher Isherwood", 1946));
        novels.add(new Novel("The Big Sleep", "Raymond Chandler", 1939));
        novels.add(new Novel("The Blind Assassin", "Margaret Atwood", 2000));
        novels.add(new Novel("Blood Meridian", "Cormac McCarthy", 1986));
        novels.add(new Novel("Brideshead Revisited", "Evelyn Waugh", 1946));
        novels.add(new Novel("The Bridge of San Luis Rey", "Thornton Wilder", 1927));
        novels.add(new Novel("Call It Sleep", "Henry Roth", 1935));
        novels.add(new Novel("Catch-22", "Joseph Heller", 1961));
        novels.add(new Novel("The Catcher in the Rye", "J.D. Salinger", 1951));
        novels.add(new Novel("A Clockwork Orange", "Anthony Burgess", 1963));
        novels.add(new Novel("The Confessions of Nat Turner", "William Styron", 1967));
        novels.add(new Novel("The Corrections", "Jonathan Franzen", 2001));
        novels.add(new Novel("The Crying of Lot 49", "Thomas Pynchon", 1966));
        novels.add(new Novel("A Dance to the Music of Time", "Anthony Powell", 1951));
        novels.add(new Novel("The Day of the Locust", "Nathanael West", 1939));
        novels.add(new Novel("Death Comes for the Archbishop", "Willa Cather", 1927));
        novels.add(new Novel("A Death in the Family", "James Agee", 1958));
        novels.add(new Novel("The Death of the Heart", "Elizabeth Bowen", 1958));
        novels.add(new Novel("Deliverance", "James Dickey", 1970));
        novels.add(new Novel("Dog Soldiers", "Robert Stone", 1974));
        novels.add(new Novel("Falconer", "John Cheever", 1977));
        novels.add(new Novel("The French Lieutenant's Woman", "John Fowles", 1969));
        novels.add(new Novel("The Golden Notebook", "Doris Lessing", 1962));
        novels.add(new Novel("Go Tell It on the Mountain", "James Baldwin", 1953));
        novels.add(new Novel("Gone with the Wind", "Margaret Mitchell", 1936));
        novels.add(new Novel("The Grapes of Wrath", "John Steinbeck", 1939));
        novels.add(new Novel("Gravity's Rainbow", "Thomas Pynchon", 1973));
        novels.add(new Novel("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        novels.add(new Novel("A Handful of Dust", "Evelyn Waugh", 1934));
        novels.add(new Novel("The Heart Is a Lonely Hunter", "Carson McCullers", 1940));
        novels.add(new Novel("The Heart of the Matter", "Graham Greene", 1948));
        novels.add(new Novel("Herzog", "Saul Bellow", 1964));
        novels.add(new Novel("Housekeeping", "Marilynne Robinson", 1981));
        novels.add(new Novel("A House for Mr. Biswas", "V.S. Naipaul", 1962));
        novels.add(new Novel("I, Claudius", "Robert Graves", 1934));
        novels.add(new Novel("Infinite Jest", "David Foster Wallace", 1996));
        novels.add(new Novel("Invisible Man", "Ralph Ellison", 1952));
        novels.add(new Novel("Light in August", "William Faulkner", 1932));
        novels.add(new Novel("The Lion, The Witch and the Wardrobe", "C.S. Lewis", 1950));
        novels.add(new Novel("Lolita", "Vladimir Nabokov", 1955));
        novels.add(new Novel("Lord of the Flies", "William Golding", 1954));
        novels.add(new Novel("The Lord of the Rings", "J.R.R. Tolkien", 1954));
        novels.add(new Novel("Loving", "Henry Green", 1945));
        novels.add(new Novel("Lucky Jim", "Kingsley Amis", 1954));
        novels.add(new Novel("The Man Who Loved Children", "Christina Stead", 1940));
        novels.add(new Novel("Midnight's Children", "Salman Rushdie", 1981));
        novels.add(new Novel("Money", "Martin Amis", 1984));
        novels.add(new Novel("The Moviegoer", "Walker Percy", 1961));
        novels.add(new Novel("Mrs. Dalloway", "Virginia Woolf", 1925));
        novels.add(new Novel("Naked Lunch", "William Burroughs", 1959));
        novels.add(new Novel("Native Son", "Richard Wright", 1940));
        novels.add(new Novel("Neuromancer", "William Gibson", 1984));
        novels.add(new Novel("Never Let Me Go", "Kazuo Ishiguro", 2005));
        novels.add(new Novel("1984", "George Orwell", 1948));
        novels.add(new Novel("On the Road", "Jack Kerouac", 1957));
        novels.add(new Novel("One Flew Over the Cuckoo's Nest", "Ken Kesey", 1962));
        novels.add(new Novel("The Painted Bird", "Jerzy Kosinski", 1965));
        novels.add(new Novel("Pale Fire", "Vladimir Nabokov", 1962));
        novels.add(new Novel("A Passage to India", "E.M. Forster", 1924));
        novels.add(new Novel("Play It as It Lays", "Joan Didion", 1970));
        novels.add(new Novel("Portnoy's Complaint", "Philip Roth", 1969));
        novels.add(new Novel("Possession", "A.S. Byatt", 1990));
        novels.add(new Novel("The Power and the Glory", "Graham Greene", 1939));
        novels.add(new Novel("The Prime of Miss Jean Brodie", "Muriel Spark", 1961));
        novels.add(new Novel("Rabbit, Run", "John Updike", 1960));
        novels.add(new Novel("Ragtime", "E.L. Doctorow", 1975));
        novels.add(new Novel("The Recognitions", "William Gaddis", 1955));
        novels.add(new Novel("Red Harvest", "Dashiell Hammett", 1929));
        novels.add(new Novel("Revolutionary Road", "Richard Yates", 1961));
        novels.add(new Novel("The Sheltering Sky", "Paul Bowles", 1949));
        novels.add(new Novel("Slaughterhouse-Five", "Kurt Vonnegut", 1969));
        novels.add(new Novel("Snow Crash", "Neal Stephenson", 1992));
        novels.add(new Novel("The Sot-Weed Factor", "John Barth", 1960));
        novels.add(new Novel("The Sound and the Fury", "William Faulkner", 1929));
        novels.add(new Novel("The Sportswriter", "Richard Ford", 1986));
        novels.add(new Novel("The Spy Who Came in from the Cold", "John le Carré", 1964));
        novels.add(new Novel("The Sun Also Rises", "Ernest Hemingway", 1926));
        novels.add(new Novel("Their Eyes Were Watching God", "Zora Neale Hurston", 1937));
        novels.add(new Novel("Things Fall Apart", "Chinua Achebe", 1959));
        novels.add(new Novel("To Kill a Mockingbird", "Harper Lee", 1960));
        novels.add(new Novel("To the Lighthouse", "Virginia Woolf", 1929));
        novels.add(new Novel("Tropic of Cancer", "Henry Miller", 1934));
        novels.add(new Novel("Ubik", "Philip K. Dick", 1969));
        novels.add(new Novel("Under the Net", "Iris Murdoch", 1954));
        novels.add(new Novel("Under the Volcano", "Malcolm Lowry", 1947));
        novels.add(new Novel("Watchmen", "Alan Moore and Dave Gibbons", 1986));
        novels.add(new Novel("White Noise", "Don DeLillo", 1985));
        novels.add(new Novel("White Teeth", "Zadie Smith", 2000));
        novels.add(new Novel("Wide Sargasso Sea", "Jean Rhys", 1966));
    }

    /**
     * Prints all titles in uppercase.
     */
    public void printAllTitles()
    {
        for (final Novel novel : novels)
        {
            System.out.println(novel.getTitle().toUpperCase());
        }
    }

    /**
     * Prints all titles that contain the specified text.
     *
     * @param title the text to search for in titles
     */
    public void printBookTitle(final String title)
    {
        validateSearchText(title);

        for (final Novel novel : novels)
        {
            if (novel.getTitle().toLowerCase().contains(title.toLowerCase()))
            {
                System.out.println(novel.getTitle());
            }
        }
    }

    /**
     * Prints all titles in alphabetical order.
     */
    public void printTitlesInAlphaOrder()
    {
        final List<String> titles;

        titles = new ArrayList<>();

        for (final Novel novel : novels)
        {
            titles.add(novel.getTitle());
        }

        Collections.sort(titles);

        for (final String title : titles)
        {
            System.out.println(title);
        }
    }

    /**
     * Prints all books from the specified decade.
     *
     * @param decade the starting year of the decade
     */
    public void printGroupByDecade(final int decade)
    {
        final int endYear;

        endYear = decade + DECADE_SPAN - 1;

        for (final Novel novel : novels)
        {
            if (novel.getYearPublished() >= decade && novel.getYearPublished() <= endYear)
            {
                System.out.println(novel.getTitle());
            }
        }
    }

    /**
     * Finds and prints the longest title in the bookstore.
     */
    public void getLongest()
    {
        Novel longestNovel;
        int maxLength;

        longestNovel = null;
        maxLength = 0;

        for (final Novel novel : novels)
        {
            if (novel.getTitle().length() > maxLength)
            {
                maxLength = novel.getTitle().length();
                longestNovel = novel;
            }
        }

        if (longestNovel != null)
        {
            System.out.println(longestNovel.getTitle());
        }
    }

    /**
     * Checks if there is a book written in the specified year.
     *
     * @param year the year to check
     * @return true if a book was written in that year, false otherwise
     */
    public boolean isThereABookWrittenBetween(final int year)
    {
        for (final Novel novel : novels)
        {
            if (novel.getYearPublished() == year)
            {
                return true;
            }
        }

        return false;
    }

    /**
     * Counts how many books contain the specified word in their title.
     *
     * @param word the word to search for
     * @return the count of books containing the word
     */
    public int howManyBooksContain(final String word)
    {
        int count;

        validateSearchText(word);

        count = 0;

        for (final Novel novel : novels)
        {
            if (novel.getTitle().toLowerCase().contains(word.toLowerCase()))
            {
                count++;
            }
        }

        return count;
    }

    /**
     * Calculates the percentage of books written between two years inclusive.
     *
     * @param first the first year
     * @param last the last year
     * @return the percentage of books written in that range
     */
    public int whichPercentWrittenBetween(final int first,
                                          final int last)
    {
        int count;
        int percentage;

        count = 0;

        for (final Novel novel : novels)
        {
            if (novel.getYearPublished() >= first && novel.getYearPublished() <= last)
            {
                count++;
            }
        }

        percentage = (count * PERCENTAGE_MULTIPLIER) / novels.size();

        return percentage;
    }

    /**
     * Returns the oldest book in the bookstore.
     *
     * @return the oldest Novel
     */
    public Novel getOldestBook()
    {
        Novel oldest;

        oldest = null;

        for (final Novel novel : novels)
        {
            if (oldest == null || novel.getYearPublished() < oldest.getYearPublished())
            {
                oldest = novel;
            }
        }

        return oldest;
    }

    /**
     * Returns a list of all books whose title length matches the specified length.
     *
     * @param titleLength the length to match
     * @return list of novels with titles of the specified length
     */
    public List<Novel> getBooksThisLength(final int titleLength)
    {
        final List<Novel> result;

        result = new ArrayList<>();

        for (final Novel novel : novels)
        {
            if (novel.getTitle().length() == titleLength)
            {
                result.add(novel);
            }
        }

        return result;
    }

    /**
     * Validates the bookstore name.
     *
     * @param name the name to validate
     * @throws IllegalArgumentException if name is null or blank
     */
    private static void validateName(final String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Bookstore name must not be null or blank.");
        }
    }

    /**
     * Validates search text.
     *
     * @param text the text to validate
     * @throws IllegalArgumentException if text is null or blank
     */
    private static void validateSearchText(final String text)
    {
        if (text == null || text.isBlank())
        {
            throw new IllegalArgumentException("Search text must not be null or blank.");
        }
    }

    /**
     * Program entry point.
     * Creates a bookstore and demonstrates all methods.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args)
    {
        final BookStore bookstore;
        final Novel oldest;
        final List<Novel> fifteenCharTitles;
        final int titleLengthToFind;

        titleLengthToFind = 15;

        bookstore = new BookStore("Classic Novels Collection");

        System.out.println("\nAll Titles in UPPERCASE:");
        bookstore.printAllTitles();

        System.out.println("\nBook Titles Containing 'the':");
        bookstore.printBookTitle("the");

        System.out.println("\nAll Titles in Alphabetical Order:");
        bookstore.printTitlesInAlphaOrder();

        System.out.println("\nBooks from the 2000s:");
        bookstore.printGroupByDecade(2000);

        System.out.println("\nLongest Book Title:");
        bookstore.getLongest();

        System.out.println("\nIs there a book written in 1950?");
        System.out.println(bookstore.isThereABookWrittenBetween(1950));

        System.out.println("\nHow many books contain 'heart'?");
        System.out.println(bookstore.howManyBooksContain("heart"));

        System.out.println("\nPercentage of books written between 1940 and 1950:");
        System.out.println(bookstore.whichPercentWrittenBetween(1940, 1950) + "%");

        System.out.println("\nOldest book:");
        oldest = bookstore.getOldestBook();
        System.out.println(oldest.getTitle() + " by " + oldest.getAuthorName() + ", " + oldest.getYearPublished());

        System.out.println("\nBooks with titles " + titleLengthToFind + " characters long:");
        fifteenCharTitles = bookstore.getBooksThisLength(titleLengthToFind);

        for (final Novel novel : fifteenCharTitles)
        {
            System.out.println(novel.getTitle());
        }
    }
}