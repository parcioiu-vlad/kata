package codewars

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class KatasTest {
    @Test
    fun testFixed() {
        val a2 = arrayOf("lively", "alive", "harp", "sharp", "armstrong")
        assertArrayEquals(arrayOf("live", "strong"), inArray(arrayOf("xyz", "live", "strong"), a2))
        assertArrayEquals(arrayOf("arp", "live", "strong"), inArray(arrayOf("live", "strong", "arp"), a2))
        assertArrayEquals(arrayOf<String>(), inArray(arrayOf("tarp", "mice", "bull"), a2))
    }
}

