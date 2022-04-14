package com.evgenyrsk.feature.aggregator.presentation.indicators.recycler

/**
 * @author Evgeny Rasskazov
 */
internal sealed class Value(
    val color: IndicatorColor = IndicatorColor.DEFAULT
) {
    abstract fun toHumanReadable(): String

    class Decorator(
        val prefix: String = "",
        val postfix: String = ""
    )
}

internal class NumberValue(
    private val decorator: Decorator = Decorator(),
    val value: Number,
    color: IndicatorColor
) : Value(color) {

    override fun toHumanReadable(): String =
        StringBuilder(decorator.prefix)
            .append(String.format("%.2f", value))
            .append(decorator.postfix)
            .toString()
}

internal class BooleanValue(
    val value: Boolean,
    color: IndicatorColor
) : Value(color) {

    override fun toHumanReadable(): String = if (value) "Есть" else "Нет"
}

internal class EmptyValue(color: IndicatorColor) : Value(color) {

    override fun toHumanReadable(): String = "–"
}