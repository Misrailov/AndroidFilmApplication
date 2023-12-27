package com.example.filmapplication.model.actor

/**
 * Represents a container for a list of actor data.
 *
 * @property page The page number associated with the data (default is 0).
 * @property next The next page URL, if available.
 * @property entries The number of entries in the container.
 * @property results The list of [ApiActor] objects contained in the container.
 */
data class ActorContainer(
    val page: Int = 0,
    val next: String? = "",
    val entries: Int,
    val results: List<ApiActor>
)

/**
 * Extracts a list of [ApiActor] objects from the [ActorContainer].
 *
 * @return A list of [ApiActor] objects.
 */
fun ActorContainer.getList(): List<ApiActor> {
    return this.results
}
