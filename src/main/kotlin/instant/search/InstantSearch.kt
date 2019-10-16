package instant.search

import org.xml.sax.InputSource
import javax.xml.parsers.DocumentBuilderFactory

/**
 * Write a Java web application which provides "instant search" over properties listed in the National Register of Historic Places.
 * Rather than waiting for the user to press a submit button, your application will dynamically update search results as input is typed.
 * We provide the file nrhp.xml.gz, which contains selected information from the register's database.
 *
 *  The key component of your server-side application is an efficient, in-memory data structure for looking up properties (written in pure Java).
 *  A good solution may take several minutes to load, but can answer a query in well under 0.1 ms on a modern PC.
 */
class InstantSearch {

  fun readProperties(xmlContent: String) {
    val dbFactory = DocumentBuilderFactory.newInstance()
    val dBuilder = dbFactory.newDocumentBuilder()
    val xmlInput = InputSource(xmlContent)
    val doc = dBuilder.parse(xmlInput)

    doc.getElementsByTagName("properties")
  }
}