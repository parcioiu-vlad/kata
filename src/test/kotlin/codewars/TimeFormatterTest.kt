package codewars

import junit.framework.Assert.assertEquals
import org.junit.Test

class TimeFormatterTest {

    @Test
    fun testFormatDurationExamples() {
        // Example Test Cases

        assertEquals("1 second", TimeFormatterKata.formatDuration(1))
        assertEquals("1 minute and 2 seconds", TimeFormatterKata.formatDuration(62))
        assertEquals("2 minutes", TimeFormatterKata.formatDuration(120))
        assertEquals("1 hour", TimeFormatterKata.formatDuration(3600))
        assertEquals("1 hour, 1 minute and 2 seconds", TimeFormatterKata.formatDuration(3662))
    }

}
