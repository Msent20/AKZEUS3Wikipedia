package ayds.zeus3.wikipedia

interface WikipediaService {
    fun getArticle(artistName: String): WikipediaArticle?
}