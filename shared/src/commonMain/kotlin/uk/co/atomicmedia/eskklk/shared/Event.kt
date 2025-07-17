@file:OptIn(ExperimentalTime::class)

package uk.co.atomicmedia.eskklk.shared

import kotlin.time.ExperimentalTime
import kotlin.time.Instant

data class Event(
    val id: String,
    val source: Source,
    val title: String,
    val url: String,
    val date: Instant,
    val imageUrl: String,
    val bannerImageUrl: String,
)

enum class Source {
    Meetup,
    Eventbrite,
}