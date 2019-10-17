package instant.search

import org.apache.commons.collections4.trie.PatriciaTrie
import org.slf4j.LoggerFactory

class PropertyRepositoryTrieImpl(private var propertiesMap: Map<Long, Property>) : PropertyRepository {

    val logger = LoggerFactory.getLogger(PropertyRepositoryTrieImpl::class.java)

    private var index: PatriciaTrie<List<Long>> = PatriciaTrie()

    init {
        this.createIndex()
    }

    private fun createIndex() {
        this.propertiesMap.forEach(action = {
            this.index.getOrPut(it.value.name) { mutableListOf(it.key)}

            if (it.value.address != null) {
                this.index.getOrPut(it.value.address) { mutableListOf(it.key)}
            }
            if (it.value.city != null) {
                this.index.getOrPut(it.value.city) { mutableListOf(it.key)}

            }
            if (it.value.state != null) {
                this.index.getOrPut(it.value.state) { mutableListOf(it.key)}
            }
        })
    }

    override fun findAllByProperty(property: String): List<Property> {
        val start = System.currentTimeMillis()

        logger.debug("PropertyRepositoryTrieImpl -> findAllByProperty - find all by $property")

        val idList = this.index[property] ?: return emptyList()
        val list = this.propertiesMap.filter { idList.contains(it.key) }.values.toList()

        val end = System.currentTimeMillis() - start
        logger.debug("PropertyRepositoryTrieImpl -> findAllByProperty - finished in $end")

        return list
    }
}
