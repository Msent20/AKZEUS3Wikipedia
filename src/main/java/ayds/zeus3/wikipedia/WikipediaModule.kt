package ayds.zeus3.wikipedia

import ayds.zeus3.wikipedia.services.WikipediaServiceModule

object WikipediaModule {
    val wikipediaService: WikipediaService = WikipediaServiceModule.wikipediaService
}