package instant.search

import org.w3c.dom.Element
import org.w3c.dom.NodeList
import org.xml.sax.InputSource
import java.io.StringReader
import javax.xml.parsers.DocumentBuilderFactory

/**
 * Write a Java web application which provides "instant search" over properties listed in the National Register of Historic Places.
 * Rather than waiting for the user to press a submit button, your application will dynamically update search results as input is typed.
 * We provide the file nrhp.xml.gz, which contains selected information from the register's database.
 *
 *  The key component of your server-side application is an efficient, in-memory data structure for looking up properties (written in pure Java).
 *  A good solution may take several minutes to load, but can answer a query in well under 0.1 ms on a modern PC.
 */
class InstantSearch(xmlContent: String) {

  private var propertiesMap: HashMap<Long, Property> = HashMap()

  init {
    this.loadData(xmlContent)
  }

  private fun loadData(xmlContent: String) {
    val dbFactory = DocumentBuilderFactory.newInstance()
    val dBuilder = dbFactory.newDocumentBuilder()
    val doc = dBuilder.parse(InputSource(StringReader(xmlContent)))

    val nodes = doc.getElementsByTagName("properties")

    val element = nodes.item(0) as Element
    val properties = element.getElementsByTagName("property")

    this.initMap(properties)
  }

  private fun initMap(properties: NodeList) {
    for (i in 0 until properties.length) {
      val propertyElement = properties.item(i) as Element
      val id = propertyElement.attributes.getNamedItem("id").nodeValue
      val name = propertyElement.getElementsByTagName("name")
      val address = propertyElement.getElementsByTagName("address")
      val city = propertyElement.getElementsByTagName("city")
      val state = propertyElement.getElementsByTagName("state")

      propertiesMap[id.toLong()] = Property(id.toLong(),
              name.item(0).getFirstChild().getTextContent(),
              address.item(0)?.getFirstChild()?.getTextContent(),
              city.item(0)?.getFirstChild()?.getTextContent(),
              state.item(0)?.getFirstChild()?.getTextContent()
      )
    }
  }

}
