package ca.bcit.comp2522.code;

/**
 * Represents a novel with a title, author name, and publication year.
 *
 * @author Ziad Malik
 * @version 1.0
 */
public class Novel
{
    private static final int MAX_TITLE_LENGTH = 200;
    private static final int MIN_YEAR = 1;

    private final String title;
    private final String authorName;
    private final int yearPublished;

    /**
     * Constructs a Novel with the specified details.
     *
     * @param title the title of the novel
     * @param authorName the name of the author
     * @param yearPublished the year the novel was published
     */
    public Novel(final String title,
                 final String authorName,
                 final int yearPublished)
    {
        validateTitle(title);
        validateAuthorName(authorName);
        validateYearPublished(yearPublished);

        this.title = title;
        this.authorName = authorName;
        this.yearPublished = yearPublished;
    }

    /**
     * Returns the title of the novel.
     *
     * @return the title
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Returns the author name.
     *
     * @return the author name
     */
    public String getAuthorName()
    {
        return authorName;
    }

    /**
     * Returns the year the novel was published.
     *
     * @return the year published
     */
    public int getYearPublished()
    {
        return yearPublished;
    }

    /**
     * Returns a string representation of this novel.
     *
     * @return formatted string with title, author, and year
     */
    @Override
    public String toString()
    {
        return title + " by " + authorName + ", " + yearPublished;
    }

    /**
     * Validates the title.
     *
     * @param title the title to validate
     * @throws IllegalArgumentException if title is null, blank, or too long
     */
    private static void validateTitle(final String title)
    {
        if (title == null || title.isBlank())
        {
            throw new IllegalArgumentException("Title must not be null or blank.");
        }

        if (title.length() > MAX_TITLE_LENGTH)
        {
            throw new IllegalArgumentException("Title must not exceed " + MAX_TITLE_LENGTH + " characters.");
        }
    }

    /**
     * Validates the author name.
     *
     * @param authorName the author name to validate
     * @throws IllegalArgumentException if author name is null or blank
     */
    private static void validateAuthorName(final String authorName)
    {
        if (authorName == null || authorName.isBlank())
        {
            throw new IllegalArgumentException("Author name must not be null or blank.");
        }
    }

    /**
     * Validates the year published.
     *
     * @param yearPublished the year to validate
     * @throws IllegalArgumentException if year is less than MIN_YEAR
     */
    private static void validateYearPublished(final int yearPublished)
    {
        if (yearPublished < MIN_YEAR)
        {
            throw new IllegalArgumentException("Year published must be at least " + MIN_YEAR + ".");
        }
    }
}