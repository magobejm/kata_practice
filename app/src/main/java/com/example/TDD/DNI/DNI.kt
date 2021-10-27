package com.example.TDD.DNI

class DNI(val dni: String) {
    companion object {
        val VALID_DNI_LENGTH = 9
    }

    //Paso 1
    /*init {
        throw LengthException("Too Long")
    }*/

    //Paso 2
    /*init {
        if (dni.length > 9) {
            throw LengthException("Too Long")
        }
        throw LengthException("Too Short")
    }*/

    //Paso 3
    /*init {
        if (dni.length != VALID_DNI_LENGTH)
            throw LengthException("Too Long")
        if (dni.length < VALID_DNI_LENGTH)
            throw LengthException("Too Short")

        throw DomainException("Ends with number")
    }*/

    //Paso 3.1
    /*init {
        checkDNIHasValidLength()

        throw DomainException("Ends with number")
    }*/

    private fun checkDNIHasValidLength() {
        if (dni.length != VALID_DNI_LENGTH)
            throw LengthException(if (dni.length > VALID_DNI_LENGTH) "Too Long" else "Too Short")
    }


    //Paso 4
    /*init {
        checkDNIHasValidLength()

        if (dni.toIntOrNull() != null)
            throw DomainException("Ends with number")
        throw DomainException("Ends with invalid letter")
    }*/


    //Paso 5
/*    init {
        checkDNIHasValidLength()

        if (dni.toIntOrNull() != null)
            throw DomainException("Ends with number")

        val regexPattern = "[UIOÑ]".toRegex()

        if (dni.contains(regexPattern))
            throw DomainException("Ends with invalid letter")

        throw DomainException("Has letters in the middle")
    }*/

    //Paso 6
/*    init {
        checkDNIHasValidLength()

        if (dni.toIntOrNull() != null)
            throw DomainException("Ends with number")

        val regexPatternLastCharacter = "[UIOÑ]".toRegex()

        if (dni.contains(regexPatternLastCharacter))
            throw DomainException("Ends with invalid letter")

        dnval regexPatternCharactersInTheMiddle = "\\S[0-9]{7,7}\\S".toRegex()

        if (!dni.contains(regexPatternCharactersInTheMiddle)) {
            throw DomainException("Has letters in the middle")
        }

        throw DomainException("Starts with invalid letter")
    }*/


    //Paso 7
/*    init {
        checkDNIHasValidLength()

        if (dni.toIntOrNull() != null)
            throw DomainException("Ends with number")

        val regexPatternLastCharacter = "[UIOÑ]".toRegex()

        if (dni.contains(regexPatternLastCharacter))
            throw DomainException("Ends with invalid letter")

        val regexPatternCharactersInTheMiddle = "\\S[0-9]{7,7}\\S".toRegex()

        if (!dni.contains(regexPatternCharactersInTheMiddle)) {
            throw DomainException("Has letters in the middle")
        }

        val regexPatternCharactersInit = "^[XYZ0-9]".toRegex()
        if (!dni.contains(regexPatternCharactersInit)) {
            throw DomainException("Starts with invalid letter")
        }

        throw InvalidArgumentException("Invalid dni");
    }*/

    //Paso 8
  /*  init {
        checkDNIHasValidLength()

        if (dni.toIntOrNull() != null)
            throw DomainException("Ends with number")

        val regexPatternLastCharacter = "[UIOÑ]".toRegex()

        if (dni.contains(regexPatternLastCharacter))
            throw DomainException("Ends with invalid letter")

        val regexPatternCharactersInTheMiddle = "\\S[0-9]{7,7}\\S".toRegex()

        if (!dni.contains(regexPatternCharactersInTheMiddle)) {
            throw DomainException("Has letters in the middle")
        }

        val regexPatternCharactersInit = "^[XYZ0-9]".toRegex()
        if (!dni.contains(regexPatternCharactersInit)) {
            throw DomainException("Starts with invalid letter")
        }

        if (!isDNIValid())
            throw InvalidArgumentException("Invalid dni");

    }

    private fun isDNIValid() : Boolean {
        val number = dni.substring(1,8).toInt()
        val letter = dni.substring(8,9)

        val mod = number % 23

        if (mod == 0 && letter != "T") {
            return false
        }

        if (mod == 1 && letter != "R") {
            return false
        }

        if (mod == 2 && letter != "W") {
            return false
        }

        return true
    }*/

    //Paso 9 y 10
     init {

        checkDNIHasValidLength()

        if (dni.toIntOrNull() != null)
            throw DomainException("Ends with number")

        val regexPatternLastCharacter = "[UIOÑ]".toRegex()

        if (dni.contains(regexPatternLastCharacter))
            throw DomainException("Ends with invalid letter")

        val regexPatternCharactersInTheMiddle = "\\S[0-9]{7,7}\\S".toRegex()

        if (!dni.contains(regexPatternCharactersInTheMiddle)) {
            throw DomainException("Has letters in the middle")
        }

        val regexPatternCharactersInit = "^[XYZ0-9]".toRegex()
        if (!dni.contains(regexPatternCharactersInit)) {
            throw DomainException("Starts with invalid letter")
        }

        if (!isDNIValid())
            throw InvalidArgumentException("Invalid dni");

    }

    private fun isDNIValid() : Boolean {
        val number = dni.substring(0,8).replace("X","0").replace("Y", "1").replace("Z","2").toInt()
        val letter = dni.substring(8,9)

        val mod = number % 23

        if (mod == 0 && letter != "T") {
            return false
        }

        if (mod == 1 && letter != "R") {
            return false
        }

        if (mod == 2 && letter != "W") {
            return false
        }

        return true
    }
}