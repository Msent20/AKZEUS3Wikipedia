package ayds.zeus3.wikipedia.service

import ayds.zeus3.wikipedia.WikipediaArticle
import ayds.zeus3.wikipedia.WikipediaService
import retrofit2.Response

internal class WikipediaServiceImpl(
    private val wikipediaToArticleResolver: WikipediaToArticleResolver,
    private val wikipediaAPI: WikipediaAPI
) : WikipediaService {
    override fun getArticle(artistName: String): WikipediaArticle? {
        val callResponse = getResponseFromService(artistName)
        return wikipediaToArticleResolver.getArticleFromExternalData(callResponse.body())
    }

    private fun getResponseFromService(query: String): Response<String> {
        return wikipediaAPI.getArtistInfo(query).execute()
    }
}