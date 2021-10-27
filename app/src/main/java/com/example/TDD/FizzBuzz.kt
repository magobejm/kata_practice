package com.example.TDD

import java.util.*


class FizzBuzz {
    private val filters: ArrayList<(integer : Int) -> String> = ArrayList<(integer : Int) -> String>()

    private fun addFilters() {
        addFilter {
            if (it % 3 == 0) "Fizz" else ""
        }
        addFilter {
            integer -> (if (integer % 5 == 0) "Buzz" else "")
        }
        /*addFilter {
            integer -> (
                if (calcPrimus(integer)) "Primus" else ""
            )
        }*/
    }

    private fun calcPrimus(integer : Int) : Boolean {
        for (i in 2..integer / 2) {
            // condition for nonprime number
            if (integer % i == 0) {
                return false
                break
            }
        }
        return true
    }

    fun filter(integers: IntArray): Array<Any?> {
        addFilters()
        val result = arrayOfNulls<Any>(integers.size)
        for (i in integers.indices) {
            result[i] = convert(integers[i])
        }
        return result
    }

    private fun convert(integer: Int): Any {
        val converted = applyFilters(integer)
        return if ("" == converted) integer else converted
    }

    private fun applyFilters(integer: Int): String {
        var converted = ""
        for (filter in filters) {
            converted += filter(integer)
        }
        return converted
    }

    private fun addFilter(fizzBuzzFilter: (integer: Int) -> String) {
        filters.add(fizzBuzzFilter)
    }
}