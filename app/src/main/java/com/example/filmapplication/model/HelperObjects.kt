/**
 * Represents the primary image associated with a title.
 *
 * @property id The ID of the primary image.
 * @property width The width of the image.
 * @property height The height of the image.
 * @property url The URL of the image.
 * @property caption The caption for the image.
 */
data class PrimaryImage(
    val id: String,
    val width: Int,
    val height: Int,
    val url: String,
    val caption: Caption
)
/**
 * Represents the caption for an image.
 *
 * @property plainText The plain text of the caption.
 * @property __typename The type name of the caption.
 */
data class Caption(
    val plainText: String,
    val __typename: String
)
/**
 * Represents the type of a title.
 *
 * @property text The text of the title.
 * @property id The ID of the title.
 * @property isSeries Indicates if the title is a series.
 * @property isEpisode Indicates if the title is an episode.
 * @property __typename The type name of the title.
 */
data class TitleType(
    val text: String,
    val id: String,
    val isSeries: Boolean,
    val isEpisode: Boolean,
    val __typename: String = ""
)
/**
 * Represents the text of a title.
 *
 * @property text The text of the title.
 * @property __typename The type name of the title.
 */
data class TitleText(
    val text: String = "",
    val __typename: String = ""
)
/**
 * Represents a year range.
 *
 * @property year The starting year.
 * @property endYear The ending year (optional).
 * @property __typename The type name of the year range.
 */
data class YearRange(
    val year: Int = 0,
    val endYear: Int? = 0,
    val __typename: String = ""
)
/**
 * Represents a release date.
 *
 * @property day The day of the release date.
 * @property month The month of the release date.
 * @property year The year of the release date.
 * @property __typename The type name of the release date.
 */
data class ReleaseDate(
    val day: Int? = 0,
    val month: Int? = 0,
    val year: Int? = 0,
    val __typename: String = ""
)