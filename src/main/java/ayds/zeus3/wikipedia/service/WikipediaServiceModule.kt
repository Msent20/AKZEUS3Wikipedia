package ayds.zeus3.wikipedia.service

import ayds.zeus3.wikipedia.WikipediaService
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

internal object WikipediaServiceModule {
    private const val URL_WIKIPEDIA = "https://en.wikipedia.org/w/"
    private val wikipediaAPIretrofit = Retrofit.Builder()
        .baseUrl(URL_WIKIPEDIA)
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()
    private val wikipediaAPI = wikipediaAPIretrofit.create(WikipediaAPI::class.java)
    private val wikipediaToArticleResolver: WikipediaToArticleResolver = JsonToArticleResolver()
    val wikipediaService: WikipediaService = WikipediaServiceImpl(
        wikipediaToArticleResolver,
        wikipediaAPI
    )
}