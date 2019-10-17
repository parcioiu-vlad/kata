package instant.search

import org.slf4j.LoggerFactory
import org.w3c.dom.Element
import org.w3c.dom.NodeList
import org.xml.sax.InputSource
import java.io.StringReader
import javax.xml.parsers.DocumentBuilderFactory

class PropertyRepositoryFactory {

  val logger = LoggerFactory.getLogger(PropertyRepositoryFactory::class.java)

  fun createPropertyRepository(xmlContent: String): PropertyRepository {
    val start = System.currentTimeMillis()
    logger.debug("PropertyRepositoryFactory -> createPropertyRepository - creating trie based repository")

    val propertyMap = this.loadData(xmlContent)
    val propertyRepository = PropertyRepositoryTrieImpl(propertyMap)

    val end = System.currentTimeMillis() - start
    logger.debug("PropertyRepositoryFactory -> createPropertyRepository - finished in $end ms")

    return propertyRepository
  }

  private fun loadData(xmlContent: String): HashMap<Long, Property> {
    val dbFactory = DocumentBuilderFactory.newInstance()
    val dBuilder = dbFactory.newDocumentBuilder()
    val doc = dBuilder.parse(InputSource(StringReader(xmlContent)))

    val nodes = doc.getElementsByTagName("properties")

    val element = nodes.item(0) as Element
    val properties = element.getElementsByTagName("property")

    return this.initMap(properties)
  }

  private fun initMap(properties: NodeList): HashMap<Long, Property> {
    val propertiesMap: HashMap<Long, Property> = HashMap()

    for (i in 0 until properties.length) {
      val propertyElement = properties.item(i) as Element
      val id = propertyElement.attributes.getNamedItem("id").nodeValue
      val name = propertyElement.getElementsByTagName("name")
      val address = propertyElement.getElementsByTagName("address")
      val city = propertyElement.getElementsByTagName("city")
      val state = propertyElement.getElementsByTagName("state")

      //TODO make name, address, city, state as lists
      propertiesMap[id.toLong()] = Property(id.toLong(),
              name.item(0).getFirstChild().getTextContent(),
              address.item(0)?.getFirstChild()?.getTextContent(),
              city.item(0)?.getFirstChild()?.getTextContent(),
              state.item(0)?.getFirstChild()?.getTextContent()
      )
    }

    return propertiesMap
  }

}
