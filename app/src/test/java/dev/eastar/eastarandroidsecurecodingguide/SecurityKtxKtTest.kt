package dev.eastar.eastarandroidsecurecodingguide

import junit.framework.TestCase
import org.junit.Assert.assertArrayEquals
import org.junit.Test

class SecurityKtxKtTest {

    @Test
    fun toByte() {
        //given
        val charSampleData: CharArray = "A ß € 嗨 𝄞 🙂".toCharArray()

        //when
        val actual = toByte(charSampleData)

        //then
        println(String(actual))
        println(actual.toTypedArray().hex)

        assertArrayEquals("A ß € 嗨 𝄞 🙂".toByteArray(), actual)
        TestCase.assertEquals("A ß € 嗨 𝄞 🙂".toByteArray().hex, actual.hex)
    }


    @Test
    fun toByteAscii() {
        //given
        val charSampleData: CharArray = "eastardev1".toCharArray()

        //when
        val actual = toByteAscii(charSampleData)

        //then
        val byteArrayData = charSampleData.map { it.code.toByte() }.toByteArray()
        assertArrayEquals(actual, byteArrayData)
    }

    @Test
    fun toByte2() {
        //given
        val charSampleData: CharArray = "eastardev1".toCharArray()

        //when
        val actual = toByte(charSampleData)

        //then
        val byteArrayData = charSampleData.map { it.code.toByte() }.toByteArray()
        assertArrayEquals(actual, byteArrayData)
    }
}

private val ByteArray?.hex: String
    get() = this?.joinToString("") { "%02x".format(it) } ?: ""
private val Array<Byte>?.hex: String
    get() = this?.joinToString("") { "%02x".format(it) } ?: ""
