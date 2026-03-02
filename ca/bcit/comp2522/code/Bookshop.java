package ca.bcit.comp2522.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Represents a bookshop containing a collection of novels stored in a HashMap.
 * Provides methods to iterate, filter, and display novels.
 *
 * @author Ziad Malik, Sebastion Roby
 * @version 1.0
 */
public class Bookshop
{
    private static final String FILTER_WORD = "the";

    private final String name;
    private final Map<String, Novel> novels;

    /**
     * Constructs a Bookshop with the specified name and populates it with novels.
     *
     * @param name the name of the bookshop
     */
    public Bookshop(final String name)
    {
        validateName(name);

        this.name = name;
        this.novels = new HashMap<>();

        populateNovels();

        System.out.println("\nBookshop: " + name);
        System.out.println("\nAll Titles:");
        printAllTitlesWithIterator();

        System.out.println("\nRemoving all novels with \"the\" in the title...");
        removeTitlesContainingThe();

        System.out.println("\nRemaining Titles:");
        printSortedTitles();
    }

    /**
     * Populates the novels map with the classic novel collection.
     */
    private void populateNovels()
    {
        addNovel(new Novel("The Adventures of Augie March", "Saul Bellow", 1953));
        addNovel(new Novel("All the King's Men", "Robert Penn Warren", 1946));
        addNovel(new Novel("American Pastoral", "Philip Roth", 1997));
        addNovel(new Novel("An American Tragedy", "Theodore Dreiser", 1925));
        addNovel(new Novel("Animal Farm", "George Orwell", 1946));
        addNovel(new Novel("Appointment in Samarra", "John O'Hara", 1934));
        addNovel(new Novel("Are You There God? It's Me, Margaret.", "Judy Blume", 1970));
        addNovel(new Novel("The Assistant", "Bernard Malamud", 1957));
        addNovel(new Novel("At Swim-Two-Birds", "Flann O'Brien", 1938));
        addNovel(new Novel("Atonement", "Ian McEwan", 2002));
        addNovel(new Novel("Beloved", "Toni Morrison", 1987));
        addNovel(new Novel("The Berlin Stories", "Christopher Isherwood", 1946));
        addNovel(new Novel("The Big Sleep", "Raymond Chandler", 1939));
        addNovel(new Novel("The Blind Assassin", "Margaret Atwood", 2000));
        addNovel(new Novel("Blood Meridian", "Cormac McCarthy", 1986));
        addNovel(new Novel("Brideshead Revisited", "Evelyn Waugh", 1946));
        addNovel(new Novel("The Bridge of San Luis Rey", "Thornton Wilder", 1927));
        addNovel(new Novel("Call It Sleep", "Henry Roth", 1935));
        addNovel(new Novel("Catch-22", "Joseph Heller", 1961));
        addNovel(new Novel("The Catcher in the Rye", "J.D. Salinger", 1951));
        addNovel(new Novel("A Clockwork Orange", "Anthony Burgess", 1963));
        addNovel(new Novel("The Confessions of Nat Turner", "William Styron", 1967));
        addNovel(new Novel("The Corrections", "Jonathan Franzen", 2001));
        addNovel(new Novel("The Crying of Lot 49", "Thomas Pynchon", 1966));
        addNovel(new Novel("A Dance to the Music of Time", "Anthony Powell", 1951));
        addNovel(new Novel("The Day of the Locust", "Nathanael West", 1939));
        addNovel(new Novel("Death Comes for the Archbishop", "Willa Cather", 1927));
        addNovel(new Novel("A Death in the Family", "James Agee", 1958));
        addNovel(new Novel("The Death of the Heart", "Elizabeth Bowen", 1958));
        addNovel(new Novel("Deliverance", "James Dickey", 1970));
        addNovel(new Novel("Dog Soldiers", "Robert Stone", 1974));
        addNovel(new Novel("Falconer", "John Cheever", 1977));
        addNovel(new Novel("The French Lieutenant's Woman", "John Fowles", 1969));
        addNovel(new Novel("The Golden Notebook", "Doris Lessing", 1962));
        addNovel(new Novel("Go Tell It on the Mountain", "James Baldwin", 1953));
        addNovel(new Novel("Gone with the Wind", "Margaret Mitchell", 1936));
        addNovel(new Novel("The Grapes of Wrath", "John Steinbeck", 1939));
        addNovel(new Novel("Gravity's Rainbow", "Thomas Pynchon", 1973));
        addNovel(new Novel("The Great Gatsby", "F. Scott Fitzgerald", 1925));
        addNovel(new Novel("A Handful of Dust", "Evelyn Waugh", 1934));
        addNovel(new Novel("The Heart Is a Lonely Hunter", "Carson McCullers", 1940));
        addNovel(new Novel("The Heart of the Matter", "Graham Greene", 1948));
        addNovel(new Novel("Herzog", "Saul Bellow", 1964));
        addNovel(new Novel("Housekeeping", "Marilynne Robinson", 1981));
        addNovel(new Novel("A House for Mr. Biswas", "V.S. Naipaul", 1962));
        addNovel(new Novel("I, Claudius", "Robert Graves", 1934));
        addNovel(new Novel("Infinite Jest", "David Foster Wallace", 1996));
        addNovel(new Novel("Invisible Man", "Ralph Ellison", 1952));
        addNovel(new Novel("Light in August", "William Faulkner", 1932));
        addNovel(new Novel("The Lion, The Witch and the Wardrobe", "C.S. Lewis", 1950));
        addNovel(new Novel("Lolita", "Vladimir Nabokov", 1955));
        addNovel(new Novel("Lord of the Flies", "William Golding", 1954));
        addNovel(new Novel("The Lord of the Rings", "J.R.R. Tolkien", 1954));
        addNovel(new Novel("Loving", "Henry Green", 1945));
        addNovel(new Novel("Lucky Jim", "Kingsley Amis", 1954));
        addNovel(new Novel("The Man Who Loved Children", "Christina Stead", 1940));
        addNovel(new Novel("Midnight's Children", "Salman Rushdie", 1981));
        addNovel(new Novel("Money", "Martin Amis", 1984));
        addNovel(new Novel("The Moviegoer", "Walker Percy", 1961));
        addNovel(new Novel("Mrs. Dalloway", "Virginia Woolf", 1925));
        addNovel(new Novel("Naked Lunch", "William Burroughs", 1959));
        addNovel(new Novel("Native Son", "Richard Wright", 1940));
        addNovel(new Novel("Neuromancer", "William Gibson", 1984));
        addNovel(new Novel("Never Let Me Go", "Kazuo Ishiguro", 2005));
        addNovel(new Novel("1984", "George Orwell", 1948));
        addNovel(new Novel("On the Road", "Jack Kerouac", 1957));
        addNovel(new Novel("One Flew Over the Cuckoo's Nest", "Ken Kesey", 1962));
        addNovel(new Novel("The Painted Bird", "Jerzy Kosinski", 1965));
        addNovel(new Novel("Pale Fire", "Vladimir Nabokov", 1962));
        addNovel(new Novel("A Passage to India", "E.M. Forster", 1924));
        addNovel(new Novel("Play It as It Lays", "Joan Didion", 1970));
        addNovel(new Novel("Portnoy's Complaint", "Philip Roth", 1969));
        addNovel(new Novel("Possession", "A.S. Byatt", 1990));
        addNovel(new Novel("The Power and the Glory", "Graham Greene", 1939));
        addNovel(new Novel("The Prime of Miss Jean Brodie", "Muriel Spark", 1961));
        addNovel(new Novel("Rabbit, Run", "John Updike", 1960));
        addNovel(new Novel("Ragtime", "E.L. Doctorow", 1975));
        addNovel(new Novel("The Recognitions", "William Gaddis", 1955));
        addNovel(new Novel("Red Harvest", "Dashiell Hammett", 1929));
        addNovel(new Novel("Revolutionary Road", "Richard Yates", 1961));
        addNovel(new Novel("The Sheltering Sky", "Paul Bowles", 1949));
        addNovel(new Novel("Slaughterhouse-Five", "Kurt Vonnegut", 1969));
        addNovel(new Novel("Snow Crash", "Neal Stephenson", 1992));
        addNovel(new Novel("The Sot-Weed Factor", "John Barth", 1960));
        addNovel(new Novel("The Sound and the Fury", "William Faulkner", 1929));
        addNovel(new Novel("The Sportswriter", "Richard Ford", 1986));
        addNovel(new Novel("The Spy Who Came in from the Cold", "John le Carré", 1964));
        addNovel(new Novel("The Sun Also Rises", "Ernest Hemingway", 1926));
        addNovel(new Novel("Their Eyes Were Watching God", "Zora Neale Hurston", 1937));
        addNovel(new Novel("Things Fall Apart", "Chinua Achebe", 1959));
        addNovel(new Novel("To Kill a Mockingbird", "Harper Lee", 1960));
        addNovel(new Novel("To the Lighthouse", "Virginia Woolf", 1929));
        addNovel(new Novel("Tropic of Cancer", "Henry Miller", 1934));
        addNovel(new Novel("Ubik", "Philip K. Dick", 1969));
        addNovel(new Novel("Under the Net", "Iris Murdoch", 1954));
        addNovel(new Novel("Under the Volcano", "Malcolm Lowry", 1947));
        addNovel(new Novel("Watchmen", "Alan Moore and Dave Gibbons", 1986));
        addNovel(new Novel("White Noise", "Don DeLillo", 1985));
        addNovel(new Novel("White Teeth", "Zadie Smith", 2000));
        addNovel(new Novel("Wide Sargasso Sea", "Jean Rhys", 1966));
    }

    /**
     * Adds a novel to the map with the title as the key.
     *
     * @param novel the novel to add
     */
    private void addNovel(final Novel novel)
    {
        novels.put(novel.getTitle(), novel);
    }

    /**
     * Prints all titles using an iterator.
     */
    private void printAllTitlesWithIterator()
    {
        final Set<String> keySet;
        final Iterator<String> iterator;

        keySet = novels.keySet();
        iterator = keySet.iterator();

        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }
    }

    /**
     * Removes all novels whose title contains the word "the" in any case.
     */
    private void removeTitlesContainingThe()
    {
        final Set<String> keySet;
        final Iterator<String> iterator;

        keySet = novels.keySet();
        iterator = keySet.iterator();

        while (iterator.hasNext())
        {
            final String title;

            title = iterator.next();

            if (title.toLowerCase().contains(FILTER_WORD))
            {
                iterator.remove();
            }
        }
    }

    /**
     * Prints all novels in sorted order by title.
     */
    private void printSortedTitles()
    {
        final Set<String> keySet;
        final List<String> keyList;

        keySet = novels.keySet();
        keyList = new ArrayList<>(keySet);

        Collections.sort(keyList);

        for (final String key : keyList)
        {
            System.out.println(novels.get(key));
        }
    }

    /**
     * Validates the bookshop name.
     *
     * @param name the name to validate
     * @throws IllegalArgumentException if name is null or blank
     */
    private static void validateName(final String name)
    {
        if (name == null || name.isBlank())
        {
            throw new IllegalArgumentException("Bookshop name must not be null or blank.");
        }
    }

    /**
     * Program entry point.
     * Creates a bookshop and demonstrates HashMap operations.
     *
     * @param args command line arguments
     */
    public static void main(final String[] args)
    {
        new Bookshop("Classic Literature HashMap Collection");
    }
}