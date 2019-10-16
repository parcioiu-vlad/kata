package instant.search

import org.junit.Test
import java.io.File

class InstantSearchTest {

  @Test
  fun readProperties() {
    //could not find why reading from resources does not work
    val content = File("src/test/resources/nrhp.xml").readText(Charsets.UTF_8)
    val instantSearch = InstantSearch()
    instantSearch.readProperties(content)
  }

}