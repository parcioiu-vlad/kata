package instant.search

class Property(val id: Long, val name: String, val address: String?,
               val city: String?, val state: String?) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Property

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }

    override fun toString(): String {
        return "Property(id=$id, name='$name', address='$address', city='$city', state='$state')"
    }


}
