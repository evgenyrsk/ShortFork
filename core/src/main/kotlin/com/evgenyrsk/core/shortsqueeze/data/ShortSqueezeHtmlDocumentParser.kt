package com.evgenyrsk.core.shortsqueeze.data

import com.evgenyrsk.core.data.model.Response
import com.evgenyrsk.core.shortsqueeze.model.ShortSqueezeApiModel
import dagger.Reusable
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import java.text.DecimalFormat
import java.util.Locale
import java.util.regex.Pattern
import javax.inject.Inject

/**
 * @author Evgeny Rasskazov
 */
@Reusable
class ShortSqueezeHtmlDocumentParser @Inject constructor() {

    fun parse(document: Document): Response<ShortSqueezeApiModel> {
        val headerBlock =
            document.select("body > div > table:nth-child(5) > tbody > tr > td:nth-child(3) > table:nth-child(3) > tbody > tr:nth-child(3) > td > table > tbody")

        val quotePrice = headerBlock.select("tr:nth-child(1)")
            .select("td:nth-child(2)")
            .first()
            .text()
            .replace(Regex("[\\s]|(${"\\$"})", RegexOption.MULTILINE), "")
        val quoteName = headerBlock.select("tr:nth-child(1)")
            .select("td:nth-child(1)")
            .first()
            .text()
            .trim()
        val quoteTicker = headerBlock.select("tr:nth-child(2)")
            .select("td:nth-child(1)")
            .first()
            .text()
            .trim()

        val htmlData =
            document.select("body > div > table:nth-child(5) > tbody > tr > td:nth-child(3) > table:nth-child(3) > tbody > tr:nth-child(4) > td > table > tbody")
                .select("tr")
                .toMutableList()
                .apply {
                    addAll(
                        document.select("body > div > table:nth-child(5) > tbody > tr > td:nth-child(3) > table:nth-child(3) > tbody > tr:nth-child(5) > td > table > tbody")
                            .select("tr")
                    )
                    addAll(
                        document.select("body > div > table:nth-child(5) > tbody > tr > td:nth-child(3) > table:nth-child(3) > tbody > tr:nth-child(6) > td > table > tbody")
                            .select("tr")
                    )
                }

        var shortQuoteData = htmlData.map { element: Element ->
            var key = element.selectFirst("td:nth-child(1)").text()

            println("KEY = $key")

            // Convert to camel case and remove special characters
            key = key.replace(
                regex = Regex("[^A-Z0-9(%\\s)]", setOf(RegexOption.IGNORE_CASE, RegexOption.UNIX_LINES)),
                replacement = ""
            ).replace(
                regex = Regex("%", setOf(RegexOption.IGNORE_CASE, RegexOption.UNIX_LINES)),
                replacement = "Percent"
            ).capitalize(Locale.getDefault())

            println("KEY#1 = $key")

            // Replace lines that starts with the number. '52days' => 'n52days']
            val pattern = Pattern.compile("^([0-9]{2})", Pattern.MULTILINE)
            val matcher = pattern.matcher(key)
            if (matcher.find()) {
                key = key.replace(
                    regex = Regex("^([0-9]{2})", RegexOption.MULTILINE),
                    replacement = "n${matcher.group()}"
                )
            }

            // Remove numbers with parenthesis from the end of the key
            key = key.replace(Regex("(\\(\\s[0-9])|([0-9]\\))$"), "")
                .replace(Regex("(?:[0-9]{1,10})$", RegexOption.MULTILINE), "")
                .replace(Regex("\\s{2}"), " ")

            println("KEY#2 = $key")

            var value = element.selectFirst("td:nth-child(2)")
                .text()

            println("VAL = $value")

            // Remove whitespaces, commas, dollar and percentage characters
            value = value.replace(
                regex = """[\\s]|(%)|(,)|(${"\\$"})""".toRegex(
                    setOf(RegexOption.IGNORE_CASE, RegexOption.UNIX_LINES)
                ),
                replacement = ""
            )

            println("VAL#2 = $value")

            if (value.isNotEmpty() && value.toLowerCase(Locale.getDefault()) != "view") {
                key.toString() to value.toFloat()
            } else null
        }

        shortQuoteData = shortQuoteData.filterNotNull()

        shortQuoteData.forEach {
            println("ITEM!!!")
            print("${it.first}, ")
            println()
            println("SECOND = ${(DecimalFormat("#.##").format(it.second))}")
            println()
            println()
        }

        val result = ShortSqueezeApiModel(
            name = quoteName,
            price = quotePrice.toDouble(),
            ticker = quoteTicker,
            shortData = shortQuoteData
        )

        return if (result.name != "Not Available - Try Again") {
            Response.success(result)
        } else {
            Response.error(null, "Data is not available")
        }
    }
}
