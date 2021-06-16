package ayds.zeus3.wikipedia

interface Article {
    val info: String
    val url: String
    val logoUrl: String
}

data class ArticleImpl(
    override val info: String,
    override val url: String,
    override val logoUrl: String
) : Article

object EmptyArticle : Article {
    override val info: String = ""
    override val url: String = ""
    override val logoUrl: String = ""
}