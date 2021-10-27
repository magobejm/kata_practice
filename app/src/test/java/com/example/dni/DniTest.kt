package com.example.dni

import org.junit.Test

import org.junit.Assert.*
import org.junit.jupiter.api.assertThrows

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class DniTest {
    //Paso 1 Demasiado Larga
    @Test
    fun testDebeFallarCuandoLongitudEsDemasiadoLarga() {
        val exception = assertThrows<LengthException> {
            DNI("0123456789")
        }
        assertEquals("Demasiado Larga", exception.message)
    }

    //Paso 2 Demasiado Corta
    @Test
    fun testDebeFallarCuandoLongitudEsDemasiadoCorta() {
        val exception = assertThrows<LengthException> {
            DNI("01234567")
        }
        assertEquals("Demasiado Corta", exception.message)
    }

    //Paso 3 Falle Termina con un número
    @Test
    fun testDebeFallarCuandoDNITerminaEnNumero() {
        val exception = assertThrows<DomainException> {
            DNI("012345678")
        }
        assertEquals("Acaba en número", exception.message)
    }

    //Paso 4 Falle Termina con una letra incorrecta [UIOÑ]
    @Test
    fun testDebeFallarConLetraIncorrecta() {
        val exception = assertThrows<DomainException> {
            DNI("01234567Ñ")
        }
        assertEquals("Acaba en letra incorrecta", exception.message)
    }

    //Paso 5 Falle con Letras en el medio
    @Test
    fun testDebeFallarConLetrasEnMedio() {
        val exception = assertThrows<DomainException> {
            DNI("0123A5678")
        }
        assertEquals("Letra en medio", exception.message)
    }

    //Paso 6 Empieza con letra y es diferente a X Y o Z
    @Test
    fun testDebeFallarConLetraInicioIncorrecta() {
        val exception = assertThrows<DomainException> {
            DNI("A12345678")
        }
        assertEquals("Caracter inicio incorrecto", exception.message)
    }


    //Paso 7 Calculo de letra de control inválido "00000000S"
    @Test
    fun testDebeFallarConLetraInválido() {
        val exception = assertThrows<DomainException> {
            DNI("00000000S")
        }
        assertEquals("Letra Invalida", exception.message)
    }

    //Paso 8 Calculo del digito de control válido acaba en T "00000000T"
    @Test
    fun testDígitoControlValido() {
       val dni = DNI("00000000T")
        assertEquals("00000000T", dni.dni)
    }

    //Paso 9 Calculo dígito de control empieza en X
    @Test
    fun testDígitoControlValidoX() {
        val dni = DNI("Y0000000T")
        assertEquals("Y0000000T", dni.dni)
    }


    //Paso 10 //Paso 9 Calculo dígito de control empieza en Y

}

