package instant.search

import org.junit.Assert
import org.junit.Test
import java.io.File

/**
 * Write a Java web application which provides "instant search" over properties listed in the National Register of Historic Places.
 * Rather than waiting for the user to press a submit button, your application will dynamically update search results as input is typed.
 * We provide the file nrhp.xml.gz, which contains selected information from the register's database.
 *
 *  The key component of your server-side application is an efficient, in-memory data structure for looking up properties (written in pure Java).
 *  A good solution may take several minutes to load, but can answer a query in well under 0.1 ms on a modern PC.
 */
class InstantSearchTest {

  private val propertyRepositoryFactory = PropertyRepositoryFactory()

  @Test
  fun findAllByPropertyTest() {
    //could not find why reading from resources does not work
    val content = File("src/test/resources/nrhp.xml").readText(Charsets.UTF_8)

    val propertyRepository = propertyRepositoryFactory.createPropertyRepository(content)

    val propertyListResult = propertyRepository.findAllByProperty("Pineground Bridge")

    Assert.assertEquals(4000149, propertyListResult[0].id)
  }

}
