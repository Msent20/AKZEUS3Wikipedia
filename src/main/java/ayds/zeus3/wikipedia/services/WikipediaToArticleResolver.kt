package ayds.zeus3.wikipedia.services

import ayds.zeus3.wikipedia.ArticleImpl
import com.google.gson.Gson
import com.google.gson.JsonObject

interface WikipediaToArticleResolver {
    fun getArticleFromExternalData(serviceData: String?): ArticleImpl?
}

private const val JSON_SNIPPET = "snippet"
private const val JSON_PAGE_ID = "pageid"
private const val WIKIPEDIA_SHORT_URL = "https://en.wikipedia.org/?curid="
private const val JSON_QUERY = "query"
private const val JSON_SEARCH = "search"
private const val LOGO_URL = "https://upload.wikimedia.org/wikipedia/commons/8/8c/Wikipedia-logo-v2-es.png"

internal class JsonToArticleResolver : WikipediaToArticleResolver {

    override fun getArticleFromExternalData(serviceData: String?): ArticleImpl? =
        try {
            serviceData?.getResponseJson()?.getArtistJson()?.let { item ->
                ArticleImpl(
                    item.getInfo(),
                    item.getUrl(),
                    LOGO_URL
                )
            }
        } catch (e: Exception) {
            null
        }

    private fun String?.getResponseJson(): JsonObject {
        val gson = Gson()
        return gson.fromJson(this, JsonObject::class.java)
    }

    private fun JsonObject.getInfo(): String {
        return this[JSON_SNIPPET].asString.replace("\\n", "\n")
    }

    private fun JsonObject.getUrl(): String {
        return WIKIPEDIA_SHORT_URL + this[JSON_PAGE_ID].asString
    }

    private fun JsonObject.getArtistJson(): JsonObject {
        val query = this[JSON_QUERY].asJsonObject
        return query[JSON_SEARCH].asJsonArray[0].asJsonObject
    }
}

