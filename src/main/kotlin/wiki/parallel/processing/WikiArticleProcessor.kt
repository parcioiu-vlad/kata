package wiki.parallel.processing

import kotlinx.coroutines.*
import java.lang.Thread.currentThread
import java.lang.Thread.sleep
import java.util.function.Consumer

class WikiArticleProcessor {

    suspend fun test(value: Int): String {
        return withContext(Dispatchers.IO) {
            sleep(10000)
            return@withContext value.toString() + " - " + currentThread().id
        }
    }

}

fun main(args: Array<String>) {
    val test = WikiArticleProcessor()

    runBlocking {

        val list = mutableListOf<Deferred<String>>()

        for (i in 0..100) {
            val deferred = async {
                return@async test.test(i)
            }
            list.add(deferred)
        }

        val completedList = list.awaitAll()

        completedList.forEach(Consumer(::println))
    }
}
