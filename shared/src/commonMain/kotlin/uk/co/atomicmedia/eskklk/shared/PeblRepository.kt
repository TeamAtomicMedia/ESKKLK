package uk.co.atomicmedia.eskklk.shared

import kotlinx.coroutines.delay
import me.tatarka.inject.annotations.Inject
import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn
import kotlin.random.Random
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@Inject
@SingleIn(AppScope::class)
class PeblRepository() {
    @OptIn(ExperimentalTime::class)
    suspend fun getEvents(
        interests: List<Interest>
    ): List<Event> {
        delay(2000)
        return listOf(
            Event(
                id = "1",
                source = Source.Meetup,
                title = "Example Event",
                url = "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
                date = Clock.System.now(),
                imageUrl = "https://images.unsplash.com/photo-1682685797365-41f45b562c0a?q=80&w=2340&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                bannerImageUrl = "https://images.unsplash.com/photo-1682685797365-41f45b562c0a?q=80&w=2340&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                interests = interests.filter { Random.nextBoolean() } // Randomly filter interests for demonstration
            )
        )
    }

    suspend fun getInterests(): List<Interest> {
        delay(2000)
        return listOf(
            Interest(
                id = "1",
                name = "Food",
                desc = "Yum."
            )
        )
    }
}
