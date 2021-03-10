package com.evgenyrsk.shortfork

import com.evgenyrsk.core.shortsqueeze.data.ShortSqueezeHtmlDocumentParser
import org.jsoup.Jsoup
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    private val parser: ShortSqueezeHtmlDocumentParser = ShortSqueezeHtmlDocumentParser()

    @Test
    fun addition_isCorrect() {
        val document = Jsoup.connect("https://shortsqueeze.com/?symbol=NOK").get() ?: return

        parser.parse(document)
    }
}
