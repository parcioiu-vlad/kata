package wiki.parallel.processing

import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import java.lang.Thread.currentThread
import java.lang.Thread.sleep
import java.util.stream.Collectors


/**
 * - Write an application, which reads the content in HTML format from that URL: https://en.wikipedia.org/wiki/Europe
 * - Afterwards each link in that article MUST be stored and followed up, reads again the content from the link found and stores all of the URLs found in the content
 * - All of the processing MUST happen parallel
 * - At the end, a file MUST be generated with a list of all URLs being found in all articles AND a counter how often they have been appeared.
 */
class WikiArticleProcessor(private val startLink: String) {

    companion object {
        val BASE_URL = "https://en.wikipedia.org"
    }

    suspend fun test(value: Int): String {
        return withContext(Dispatchers.IO) {
            sleep(10000)
            return@withContext value.toString() + " - " + currentThread().id
        }
    }

    fun extractLinksFromUrls(links: List<String>): MutableList<String> {
        val linkList = mutableListOf<String>()
        val deferredList = mutableListOf<Deferred<List<String>?>>()

        runBlocking {
            links.forEach { link: String ->
                val deferred = async {
                    return@async extractLinks(link)
                }
                deferredList.add(deferred)
            }

            deferredList.awaitAll().forEach { list: List<String>? -> linkList.addAll(list.orEmpty()) }
        }

        return linkList
    }

    fun extractLinks(url: String): List<String>? {
        val doc: Document = Jsoup.connect(url).get()
        val links: Elements = doc.select("a[href]")

        return links.stream().map { el -> el.attr("href") }.collect(Collectors.toList())
    }

}

fun main(args: Array<String>) {
    val wikiArticleProcessor = WikiArticleProcessor("https://en.wikipedia.org/wiki/Europe")

    val links = wikiArticleProcessor.extractLinks("https://en.wikipedia.org/wiki/Europe")
    print(wikiArticleProcessor.extractLinksFromUrls(links.orEmpty()))
}
