package ayds.zeus3.wikipedia

interface WikipediaService {
    fun getCard(artistName: String): CardImpl?
}