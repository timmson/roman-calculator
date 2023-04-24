package ru.andreyTw.romanCalculator

object RomanToArabicConverter {
    fun convert(roman: String): Int {
        val num = roman.toCharArray().map {
            when (it.toString()) {
                Digits.ONE.romanValueUnits -> Digits.ONE.arabianValue
                Digits.FIVE.romanValueUnits -> Digits.FIVE.arabianValue
                Digits.ONE.romanValueTens -> Digits.ONE.arabianValue * 10
                Digits.FIVE.romanValueTens -> Digits.FIVE.arabianValue * 10
                Digits.ONE.romanValueHundreds -> Digits.ONE.arabianValue * 100
                Digits.FIVE.romanValueHundreds -> Digits.FIVE.arabianValue * 100
                Digits.ONE.romanValueThousands -> Digits.ONE.arabianValue * 1000
                else -> 0
            }
        }
        return num.reduceIndexed { i, acc, _ ->
            reduce(num, i, acc)
        }
    }

    private fun reduce(num: List<Int>, i: Int, acc: Int) =
        if (num[i] > num[i - 1]) acc + num[i] - 2 * num[i - 1] else acc + num[i]
}