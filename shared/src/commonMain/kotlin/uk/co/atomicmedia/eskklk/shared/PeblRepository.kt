package uk.co.atomicmedia.eskklk.shared

import com.apollographql.apollo.ApolloClient
import kotlinx.coroutines.delay
import me.tatarka.inject.annotations.Inject
import software.amazon.lastmile.kotlin.inject.anvil.AppScope
import software.amazon.lastmile.kotlin.inject.anvil.SingleIn
import uk.co.atomicmedia.eskklk.EventSearchQuery
import kotlin.random.Random
import kotlin.time.Clock
import kotlin.time.ExperimentalTime

@Inject
@SingleIn(AppScope::class)
class PeblRepository() {
    val apollo = ApolloClient.Builder()
        .serverUrl("https://api.meetup.com/gql-ext")
        .build()

    @OptIn(ExperimentalTime::class)
    suspend fun getEvents(
        interests: List<Interest>
    ): List<Event> {
        val result = apollo.query(
            EventSearchQuery()
        ).execute()

        return result.data
            ?.eventSearch
            ?.toModel(
                interests.filter { Random.nextBoolean() }
            )
            ?: emptyList()
    }

    suspend fun getInterests(): List<Interest> {
        delay(2000)
        return listOf(
            Interest("1", "Technology", "Events and groups focused on software development, AI, data science, cybersecurity, and emerging tech."),
            Interest("2", "Arts & Culture", "Exploring visual arts, music, theater, dance, literature, and cultural heritage."),
            Interest("3", "Sports & Fitness", "Activities like running, cycling, hiking, team sports, yoga, and gym workouts."),
            Interest("4", "Food & Drink", "Culinary experiences, cooking classes, wine tasting, craft beer, and dining out."),
            Interest("5", "Business & Networking", "Workshops, seminars, and networking events for professionals, entrepreneurs, and job seekers."),
            Interest("6", "Health & Wellness", "Focus on mental health, mindfulness, meditation, healthy living, and personal well-being."),
            Interest("7", "Hobbies & Crafts", "Engaging in various hobbies such as photography, painting, crafting, gaming, and collecting."),
            Interest("8", "Travel & Outdoors", "Adventures, local explorations, hiking, camping, and discovering new places."),
            Interest("9", "Education & Learning", "Workshops, courses, and lectures on diverse subjects for personal and professional development."),
            Interest("10", "Social & Community", "Community gatherings, volunteer opportunities, and social events to connect with others."),
            Interest("11", "Fashion & Beauty", "Trends, workshops, and events related to fashion, makeup, skincare, and personal style."),
            Interest("12", "Music", "Live concerts, music festivals, DJ sets, and genres from pop to classical."),
            Interest("13", "Film & Media", "Movie screenings, film festivals, discussions, and events related to cinema and media production."),
            Interest("14", "Gaming", "Video games, board games, role-playing games, and esports events."),
            Interest("15", "Photography", "Workshops, photo walks, and exhibitions for photography enthusiasts of all levels."),
            Interest("16", "Writing & Literature", "Creative writing workshops, book clubs, poetry readings, and literary discussions."),
            Interest("17", "Science & Nature", "Exploring scientific discoveries, environmental conservation, astronomy, and natural history."),
            Interest("18", "Home & Garden", "Gardening tips, home decor, DIY projects, and sustainable living practices."),
            Interest("19", "Parenting & Family", "Resources, support groups, and activities for parents and families."),
            Interest("20", "Pets & Animals", "Events and communities for pet owners and animal lovers."),
            Interest("21", "Cars & Motorsports", "Car shows, racing events, and discussions about automotive culture."),
            Interest("22", "Spirituality & Religion", "Exploring different faiths, mindfulness practices, and spiritual growth."),
            Interest("23", "Volunteering", "Opportunities to give back to the community and support various causes."),
            Interest("24", "Politics & Activism", "Discussions, debates, and events related to current affairs and social change."),
            Interest("25", "Dance", "Dance classes, social dancing, and performances of various dance styles."),
            Interest("26", "Comedy", "Stand-up shows, improv, and comedic performances."),
            Interest("27", "DIY & Makers", "Hands-on workshops, crafting, and creating new things."),
            Interest("28", "Investing & Finance", "Discussions, workshops, and seminars on personal finance and investment strategies."),
            Interest("29", "Real Estate", "Events and discussions related to buying, selling, and investing in property."),
            Interest("30", "Marketing & PR", "Workshops and networking for professionals in marketing, advertising, and public relations."),
            Interest("31", "Human Resources", "Events and resources for HR professionals and talent management."),
            Interest("32", "Healthcare", "Discussions and events related to medical advancements, public health, and patient care."),
            Interest("33", "Architecture & Design", "Exploring design principles, urban planning, and architectural innovations."),
            Interest("34", "History", "Lectures, tours, and discussions about historical events and figures."),
            Interest("35", "Philosophy", "Discussions and readings on philosophical concepts and ethical dilemmas."),
            Interest("36", "Psychology", "Exploring human behavior, mental processes, and psychological theories."),
            Interest("37", "Esports", "Competitive video gaming tournaments and discussions."),
            Interest("38", "Board Games", "Meetups and events for playing and discovering new board games."),
            Interest("39", "Role-Playing Games", "Tabletop RPG sessions and communities."),
            Interest("40", "Comics & Graphic Novels", "Discussions, conventions, and appreciation for comic books."),
            Interest("41", "Animation", "Exploring animated films, TV shows, and animation techniques."),
            Interest("42", "Podcasting", "Workshops and discussions for podcast creators and enthusiasts."),
            Interest("43", "Meditation & Yoga", "Practices for mindfulness, relaxation, and physical well-being."),
            Interest("44", "Survival Skills", "Workshops and outdoor activities focused on wilderness survival."),
            Interest("45", "Astronomy", "Stargazing events, discussions about space, and celestial phenomena."),
            Interest("46", "Robotics", "Building, programming, and discussing robots and automation."),
            Interest("47", "Cybersecurity", "Learning about online safety, data protection, and digital security."),
            Interest("48", "Sustainable Living", "Tips and discussions on eco-friendly practices and environmental responsibility."),
            Interest("49", "Personal Development", "Workshops and resources for self-improvement and goal setting."),
            Interest("50", "Drones & UAVs", "Flying, building, and discussing drones for hobby or professional use.")
        )
    }
}

@ExperimentalTime
private fun EventSearchQuery.EventSearch.toModel(
    interests: List<Interest>,
): List<Event> {
    return edges.map { edge ->
        edge.node.let {
            Event(
                id = it.id,
                source = Source.entries.random(),
                title = it.title,
                desc = it.description,
                url = it.eventUrl,
                date = it.dateTime?: Clock.System.now(),
                imageUrl = it.featuredEventPhoto?.highResUrl,
                bannerImageUrl = it.featuredEventPhoto?.thumbUrl,
                interests = interests
            )
        }
    }
}
