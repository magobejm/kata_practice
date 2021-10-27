package com.example.TDD

import com.example.TDD.FizzBuzz
import org.junit.Assert.assertArrayEquals
import org.junit.Before
import org.junit.Test


class FizzBuzzTest {
    var fizzBuzz: FizzBuzz = FizzBuzz()


    @Test
    @Throws(Exception::class)
    fun shouldReturn1And2AsIs() {
        assertArrayEquals(ARRAY_OF_1_2, fizzBuzz.filter(range(1, 2)))
    }

    @Test
    @Throws(Exception::class)
    fun shouldConvertThreeToFizz() {
        assertArrayEquals(ARRAY_OF_2_FIZZ, fizzBuzz.filter(range(2, 3)))
    }

    @Test
    @Throws(Exception::class)
    fun shouldConvert6And9ToFizz() {
        assertArrayEquals(ARRAY_OF_FIZZ_7_8_FIZZ, fizzBuzz.filter(range(6, 9)))
    }

    @Test
    @Throws(Exception::class)
    fun shouldConvert5ToBuzz() {
        assertArrayEquals(ARRAY_OF_BUZZ, fizzBuzz.filter(range(5, 5)))
    }

    @Test
    @Throws(Exception::class)
    fun shouldConvert15ToFizzBuzz() {
        assertArrayEquals(ARRAY_OF_FIZZBUZZ, fizzBuzz.filter(range(15, 15)))
    }

    @Test
    @Throws(Exception::class)
    fun shouldConvert15To30Correctly() {
        assertArrayEquals(ARRAY_OF_FIZZBUZZ_TO_FIZZ, fizzBuzz.filter(range(15, 30)))
    }

    private fun range(start: Int, end: Int): IntArray {
        val range = IntArray(end - start + 1)
        for (count in range.indices) range[count] = start + count
        return range
    }

    companion object {
        private val ARRAY_OF_2_FIZZ = arrayOf(2, "Fizz")
        private val ARRAY_OF_1_2 = arrayOf<Any>(1, 2)
        private val ARRAY_OF_FIZZ_7_8_FIZZ = arrayOf("Fizz", 7, 8, "Fizz")
        private val ARRAY_OF_BUZZ = arrayOf<Any>("Buzz")
        private val ARRAY_OF_FIZZBUZZ = arrayOf<Any>("FizzBuzz")
        private val ARRAY_OF_FIZZBUZZ_TO_FIZZ = arrayOf("FizzBuzz", 16, 17, "Fizz", 19, "Buzz", "Fizz", 22, 23, "Fizz", "Buzz", 26, "Fizz", 28, 29, "FizzBuzz")
    }
}