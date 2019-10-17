package instant.search

interface PropertyRepository {

    /**
     * Search through all properties from {@link Property}
     *
     * @param property
     * @return list of {@link Property}
     */
    fun findAllByProperty(property: String): List<Property>

}
