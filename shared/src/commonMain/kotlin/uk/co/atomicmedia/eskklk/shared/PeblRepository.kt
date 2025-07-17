package uk.co.atomicmedia.eskklk.shared

import kotlinx.coroutines.delay
import me.tatarka.inject.annotations.Inject
import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn
import kotlin.time.Clock
import kotlin.time.ExperimentalTime
import kotlin.time.Instant

@Inject
@SingleIn(AppScope::class)
class PeblRepository() {
    @OptIn(ExperimentalTime::class)
    suspend fun getEvents(): List<Event> {
        delay(2000)
        return listOf(
            Event(
                id = "1",
                source = Source.Meetup,
                title = "Example Event",
                url = "https://www.youtube.com/watch?v=dQw4w9WgXcQ",
                date = Clock.System.now(),
                imageUrl = "https://images.unsplash.com/photo-1682685797365-41f45b562c0a?q=80&w=2340&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
                bannerImageUrl = "https://images.unsplash.com/photo-1682685797365-41f45b562c0a?q=80&w=2340&auto=format&fit=crop&ixlib=rb-4.1.0&ixid=M3wxMjA3fDF8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D"
            )
        )
    }
}

/*
    static let example =
    Event(id: UUID(), source: Source.example, title: "Example Event", url: URL(string: "https://www.youtube.com/watch?v=dQw4w9WgXcQ")!, date: Date(), description: "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.", image: UIImage(named: "example-event-image")!, banner: UIImage(named: "example-event-banner")!)

 */