package ayds.zeus3.wikipedia

interface Article {
    val info: String
    val url: String
    val logo_url: String
    val source: Int
    var isLocallyStoraged: Boolean
}

data class ArticleImpl(
    override val info: String,
    override val url: String,
    override val logo_url: String,
    override val source: Int,
    override var isLocallyStoraged: Boolean = false
) : Article

object EmptyArticle : Article {
    override val info: String = ""
    override val url: String = ""
    override val logo_url: String = ""
    override val source: Int = -1
    override var isLocallyStoraged: Boolean = false
}