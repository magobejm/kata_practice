package com.example.TDD.DNI

import com.example.TDD.DNI.DNI
import com.example.TDD.DNI.DomainException
import com.example.TDD.DNI.InvalidArgumentException
import com.example.TDD.DNI.LengthException
import org.junit.Test

import org.junit.Assert.*
import org.junit.jupiter.api.assertThrows

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DniTest {
    //Paso 1
    @Test
    fun testShouldFailWhenDniLongerThanMaxLenght() {
        val exception = assertThrows<LengthException> {
            DNI("0123456789")
        }
        assertEquals("Too Long", exception.message)
    }


    //Paso 2
    @Test
    fun testShouldFailWhenDniShorterThanMinLenght() {
        val exception = assertThrows<LengthException> {
            DNI("01234567")
        }
        assertEquals("Too Short", exception.message)
    }

    //Paso 3
    @Test
    fun testShouldFailWhenDniEndsWithANumber() {
        val exception = assertThrows<DomainException> {
            DNI("012345678")
        }
        assertEquals("Ends with number", exception.message)
    }

    //Paso 4
    @Test
    fun testShouldFailWhenDniEndsWithAnInvalidLetter() {
        val exception = assertThrows<DomainException> {
            DNI("01234567I")
        }
        assertEquals("Ends with invalid letter", exception.message)
    }

    //Paso 5
    @Test
    fun testShouldFailWhenDniHasLettersInTheMiddle() {
        val exception = assertThrows<DomainException> {
            DNI("012AB567R")
        }
        assertEquals("Has letters in the middle", exception.message)
    }

    //Paso 6
    @Test
    fun testShouldFailWhenDniStartsWithALetterOtherThanXYZ() {
        val exception = assertThrows<DomainException> {
            DNI("A1234567R")
        }
        assertEquals("Starts with invalid letter", exception.message)
    }


    //Paso 7
    @Test
    fun testShouldFailWhenInvalidDni() {
        val exception = assertThrows<InvalidArgumentException> {
            DNI("00000000S")
        }
        assertEquals("Invalid dni", exception.message)
    }

    //Paso 8
    @Test
    fun testShouldConstructValidDNIEndingWithT() {

        val dni = DNI("00000000T")
        assertEquals("00000000T", dni.dni)
    }

    //Paso 9
    @Test
    fun testShouldConstructValidNIEStartingWithX() {

        val dni = DNI("X0000000T")
        assertEquals("X0000000T", dni.dni)
    }

    //Paso 10
    @Test
    fun testShouldConstructInvalidNIEStartingWithY() {

        val dni = DNI("Y0000000T")
        assertEquals("Y0000000T", dni.dni)
    }
}

